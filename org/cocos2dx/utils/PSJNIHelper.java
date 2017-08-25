package org.cocos2dx.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class PSJNIHelper {
    static ArrayList<String> mArrayList = null;
    static HashMap<String, String> mHashMap = null;
    static Vector<String> mVector = null;

    public static void createHashMap() {
        mHashMap = new HashMap();
    }

    public static HashMap<String, String> getHashMap() {
        return mHashMap;
    }

    public static void pushHashMapElement(String key, String value) {
        if (mHashMap != null) {
            mHashMap.put(key, value);
        }
    }

    public static void createVector() {
        mVector = new Vector();
    }

    public static Vector<String> getVector() {
        return mVector;
    }

    public static void pushVectorElement(String value) {
        if (mVector != null) {
            mVector.add(value);
        }
    }

    public static void createArrayList() {
        mArrayList = new ArrayList();
    }

    public static ArrayList<String> getArrayList() {
        return mArrayList;
    }

    public static void pushArrayListElement(String value) {
        if (mArrayList != null) {
            mArrayList.add(value);
        }
    }
}
