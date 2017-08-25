package com.heyzap.common.vast.util;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

public class XmlValidation {
    private static String TAG = "XmlTools";

    public static boolean validate(InputStream schemaStream, String xmlDocument) {
        VASTLog.m786i(TAG, "Beginning XSD validation.");
        try {
            SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema").newSchema(new StreamSource(schemaStream)).newValidator().validate(new StreamSource(xmlDocument));
        } catch (SAXException e) {
            VASTLog.m785e(TAG, e.getMessage(), e);
        } catch (IOException e2) {
            VASTLog.m785e(TAG, e2.getMessage(), e2);
        } catch (IllegalArgumentException e3) {
            VASTLog.m785e(TAG, e3.getMessage(), e3);
        } catch (Exception e4) {
            VASTLog.m785e(TAG, e4.getMessage(), e4);
            return false;
        }
        VASTLog.m786i(TAG, "Completed XSD validation..");
        return true;
    }
}
