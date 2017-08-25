package com.heyzap.common.vast.util;

import com.heyzap.http.AsyncHttpResponseHandler;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlTools {
    private static String TAG = "XmlTools";

    public static void logXmlDocument(Document doc) {
        VASTLog.m783d(TAG, "logXmlDocument");
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty("omit-xml-declaration", "no");
            transformer.setOutputProperty("method", "xml");
            transformer.setOutputProperty("indent", "yes");
            transformer.setOutputProperty("encoding", AsyncHttpResponseHandler.DEFAULT_CHARSET);
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            StringWriter sw = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            VASTLog.m783d(TAG, sw.toString());
        } catch (Exception e) {
            VASTLog.m785e(TAG, e.getMessage(), e);
        }
    }

    public static String xmlDocumentToString(Document doc) {
        String xml = null;
        VASTLog.m783d(TAG, "xmlDocumentToString");
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty("omit-xml-declaration", "no");
            transformer.setOutputProperty("method", "xml");
            transformer.setOutputProperty("indent", "yes");
            transformer.setOutputProperty("encoding", AsyncHttpResponseHandler.DEFAULT_CHARSET);
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            StringWriter sw = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            xml = sw.toString();
        } catch (Exception e) {
            VASTLog.m785e(TAG, e.getMessage(), e);
        }
        return xml;
    }

    public static String xmlDocumentToString(Node node) {
        String xml = null;
        VASTLog.m783d(TAG, "xmlDocumentToString");
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty("omit-xml-declaration", "yes");
            transformer.setOutputProperty("method", "xml");
            transformer.setOutputProperty("indent", "yes");
            transformer.setOutputProperty("encoding", AsyncHttpResponseHandler.DEFAULT_CHARSET);
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            StringWriter sw = new StringWriter();
            transformer.transform(new DOMSource(node), new StreamResult(sw));
            xml = sw.toString();
        } catch (Exception e) {
            VASTLog.m785e(TAG, e.getMessage(), e);
        }
        return xml;
    }

    public static Document stringToDocument(String doc) {
        VASTLog.m783d(TAG, "stringToDocument");
        Document document = null;
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(doc));
            document = db.parse(is);
        } catch (Exception e) {
            VASTLog.m785e(TAG, e.getMessage(), e);
        }
        return document;
    }

    public static String stringFromStream(InputStream inputStream) throws IOException {
        VASTLog.m783d(TAG, "stringFromStream");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        while (true) {
            int length = inputStream.read(buffer);
            if (length == -1) {
                return new String(baos.toByteArray(), AsyncHttpResponseHandler.DEFAULT_CHARSET);
            }
            baos.write(buffer, 0, length);
        }
    }

    public static String getElementValue(Node node) {
        NodeList childNodes = node.getChildNodes();
        String value = null;
        int childIndex = 0;
        while (childIndex < childNodes.getLength()) {
            value = ((CharacterData) childNodes.item(childIndex)).getData().trim();
            if (value.length() == 0) {
                childIndex++;
            } else {
                VASTLog.m787v(TAG, "getElementValue: " + value);
                return value;
            }
        }
        return value;
    }
}
