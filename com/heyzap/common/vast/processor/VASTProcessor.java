package com.heyzap.common.vast.processor;

import com.heyzap.common.vast.VASTInterstitial.VASTError;
import com.heyzap.common.vast.model.VASTDocElement;
import com.heyzap.common.vast.model.VASTModel;
import com.heyzap.common.vast.util.VASTLog;
import com.heyzap.common.vast.util.XmlTools;
import com.heyzap.common.vast.util.XmlValidation;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.Charset;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public final class VASTProcessor {
    private static final boolean IS_VALIDATION_ON = false;
    private static final int MAX_VAST_LEVELS = 5;
    private static final String TAG = "VASTProcessor";
    private VASTMediaPicker mediaPicker;
    private StringBuilder mergedVastDocs = new StringBuilder(500);
    private VASTModel vastModel;

    public VASTProcessor(VASTMediaPicker mediaPicker) {
        this.mediaPicker = mediaPicker;
    }

    public VASTModel getModel() {
        return this.vastModel;
    }

    public VASTError process(String xmlData) {
        VASTLog.m783d(TAG, "process");
        this.vastModel = null;
        try {
            InputStream is = new ByteArrayInputStream(xmlData.getBytes(Charset.defaultCharset().name()));
            VASTError error = processUri(is, 0);
            try {
                is.close();
            } catch (IOException e) {
            }
            InputStream inputStream;
            if (error != VASTError.NONE) {
                inputStream = is;
                return error;
            }
            Document mainDoc = wrapMergedVastDocWithVasts();
            this.vastModel = new VASTModel(mainDoc);
            if (mainDoc == null) {
                inputStream = is;
                return VASTError.XML_PARSE;
            } else if (VASTModelPostValidator.validate(this.vastModel, this.mediaPicker)) {
                inputStream = is;
                return VASTError.NONE;
            } else {
                inputStream = is;
                return VASTError.POST_VALIDATION;
            }
        } catch (UnsupportedEncodingException e2) {
            VASTLog.m785e(TAG, e2.getMessage(), e2);
            return VASTError.XML_PARSE;
        }
    }

    private Document wrapMergedVastDocWithVasts() {
        VASTLog.m783d(TAG, "wrapmergedVastDocWithVasts");
        this.mergedVastDocs.insert(0, "<VASTS>");
        this.mergedVastDocs.append("</VASTS>");
        String merged = this.mergedVastDocs.toString();
        VASTLog.m787v(TAG, "Merged VAST doc:\n" + merged);
        return XmlTools.stringToDocument(merged);
    }

    private VASTError processUri(InputStream is, int depth) {
        VASTLog.m783d(TAG, "processUri");
        if (depth >= 5) {
            VASTLog.m784e(TAG, "VAST wrapping exceeded max limit of 5.");
            return VASTError.EXCEEDED_WRAPPER_LIMIT;
        }
        Document doc = createDoc(is);
        if (doc == null) {
            return VASTError.XML_PARSE;
        }
        merge(doc);
        NodeList uriToNextDoc = doc.getElementsByTagName(VASTDocElement.vastAdTagURI.getValue());
        if (uriToNextDoc == null || uriToNextDoc.getLength() == 0) {
            return VASTError.NONE;
        }
        VASTLog.m783d(TAG, "Doc is a wrapper. ");
        String nextUri = XmlTools.getElementValue(uriToNextDoc.item(0));
        VASTLog.m783d(TAG, "Wrapper URL: " + nextUri);
        try {
            InputStream nextInputStream = new URL(nextUri).openStream();
            VASTError error = processUri(nextInputStream, depth + 1);
            try {
                nextInputStream.close();
                return error;
            } catch (IOException e) {
                return error;
            }
        } catch (Exception e2) {
            VASTLog.m785e(TAG, e2.getMessage(), e2);
            return VASTError.XML_OPEN_OR_READ;
        }
    }

    private Document createDoc(InputStream is) {
        VASTLog.m783d(TAG, "About to create doc from InputStream");
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
            doc.getDocumentElement().normalize();
            VASTLog.m783d(TAG, "Doc successfully created.");
            return doc;
        } catch (Exception e) {
            VASTLog.m785e(TAG, e.getMessage(), e);
            return null;
        }
    }

    private void merge(Document newDoc) {
        VASTLog.m783d(TAG, "About to merge doc into main doc.");
        this.mergedVastDocs.append(XmlTools.xmlDocumentToString(newDoc.getElementsByTagName("VAST").item(0)));
        VASTLog.m783d(TAG, "Merge successful.");
    }

    private boolean validateAgainstSchema(Document doc) {
        VASTLog.m783d(TAG, "About to validate doc against schema.");
        InputStream stream = VASTProcessor.class.getResourceAsStream("assets/vast_2_0_1_schema.xsd");
        boolean isValid = XmlValidation.validate(stream, XmlTools.xmlDocumentToString(doc));
        try {
            stream.close();
        } catch (IOException e) {
        }
        return isValid;
    }
}
