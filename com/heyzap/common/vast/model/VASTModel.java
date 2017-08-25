package com.heyzap.common.vast.model;

import android.net.Uri;
import com.google.android.gms.tagmanager.DataLayer;
import com.heyzap.common.cache.Entry;
import com.heyzap.common.vast.util.HttpTools;
import com.heyzap.common.vast.util.VASTLog;
import com.heyzap.common.vast.util.XmlTools;
import com.heyzap.common.video.VideoDisplayOptions;
import com.heyzap.common.video.VideoModelInterface;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Utils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class VASTModel implements Serializable, VideoModelInterface {
    private static String TAG = "VASTModel";
    private static final String combinedSkipOffsetXPATH = "/VASTS/VAST/Ad/InLine/Creatives/Creative/Linear/@skipoffset|/VASTS/VAST/Ad/InLine/Creatives/Creative/NonLinearAds/@skipoffset";
    private static final String combinedTrackingXPATH = "/VASTS/VAST/Ad/InLine/Creatives/Creative/Linear/TrackingEvents/Tracking|/VASTS/VAST/Ad/InLine/Creatives/Creative/NonLinearAds/TrackingEvents/Tracking|/VASTS/VAST/Ad/Wrapper/Creatives/Creative/Linear/TrackingEvents/Tracking|/VASTS/VAST/Ad/Wrapper/Creatives/Creative/NonLinearAds/TrackingEvents/Tracking";
    private static final String durationXPATH = "//Duration";
    private static final String errorUrlXPATH = "//Error";
    private static final String impressionXPATH = "//Impression";
    private static final String inlineLinearSkipOffsetXPATH = "/VASTS/VAST/Ad/InLine/Creatives/Creative/Linear/@skipoffset";
    private static final String inlineLinearTrackingXPATH = "/VASTS/VAST/Ad/InLine/Creatives/Creative/Linear/TrackingEvents/Tracking";
    private static final String inlineNonLinearSkipOffsetXPATH = "/VASTS/VAST/Ad/InLine/Creatives/Creative/NonLinearAds/@skipoffset";
    private static final String inlineNonLinearTrackingXPATH = "/VASTS/VAST/Ad/InLine/Creatives/Creative/NonLinearAds/TrackingEvents/Tracking";
    private static final String mediaFileXPATH = "//MediaFile";
    private static final long serialVersionUID = 4318368258447283733L;
    private static final String videoClicksXPATH = "//VideoClicks";
    private static final String wrapperLinearTrackingXPATH = "/VASTS/VAST/Ad/Wrapper/Creatives/Creative/Linear/TrackingEvents/Tracking";
    private static final String wrapperNonLinearTrackingXPATH = "/VASTS/VAST/Ad/Wrapper/Creatives/Creative/NonLinearAds/TrackingEvents/Tracking";
    private AdUnit adUnit = null;
    private Entry cacheEntry = null;
    private VideoDisplayOptions cachedVideoDisplayOptions = null;
    private int percentDownloaded = 0;
    private VASTMediaFile pickedMediaFile = null;
    private transient Document vastsDocument;
    private VideoDisplayOptions videoDisplayOptions = new VideoDisplayOptions();

    public VASTModel(Document vasts) {
        this.vastsDocument = vasts;
        this.videoDisplayOptions.allowStreamingFallback = true;
        this.videoDisplayOptions.forceStreaming = false;
        this.videoDisplayOptions.allowSkip = false;
        this.videoDisplayOptions.allowHide = false;
        this.videoDisplayOptions.allowClick = true;
        this.videoDisplayOptions.postRollInterstitial = false;
    }

    public Document getVastsDocument() {
        return this.vastsDocument;
    }

    public HashMap<TrackingEvent, List<String>> getTrackingUrls() {
        VASTLog.m783d(TAG, "getTrackingUrls");
        HashMap<TrackingEvent, List<String>> trackings = new HashMap();
        try {
            NodeList nodes = (NodeList) XPathFactory.newInstance().newXPath().evaluate(combinedTrackingXPATH, this.vastsDocument, XPathConstants.NODESET);
            if (nodes == null) {
                return trackings;
            }
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                String eventName = node.getAttributes().getNamedItem(DataLayer.EVENT_KEY).getNodeValue();
                try {
                    TrackingEvent key = TrackingEvent.valueOf(eventName);
                    String trackingURL = HttpTools.fixupURI(XmlTools.getElementValue(node));
                    if (trackings.containsKey(key)) {
                        ((List) trackings.get(key)).add(trackingURL);
                    } else {
                        List<String> tracking = new ArrayList();
                        tracking.add(trackingURL);
                        trackings.put(key, tracking);
                    }
                } catch (IllegalArgumentException e) {
                    VASTLog.m788w(TAG, "Event:" + eventName + " is not valid. Skipping it.");
                }
            }
            return trackings;
        } catch (XPathExpressionException e2) {
            VASTLog.m785e(TAG, e2.getMessage(), e2);
            return new HashMap();
        }
    }

    public List<VASTMediaFile> getMediaFiles() {
        VASTLog.m783d(TAG, "getMediaFiles");
        ArrayList<VASTMediaFile> mediaFiles = new ArrayList();
        try {
            NodeList nodes = (NodeList) XPathFactory.newInstance().newXPath().evaluate(mediaFileXPATH, this.vastsDocument, XPathConstants.NODESET);
            if (nodes == null) {
                return mediaFiles;
            }
            for (int i = 0; i < nodes.getLength(); i++) {
                BigInteger bigInteger;
                VASTMediaFile mediaFile = new VASTMediaFile();
                Node node = nodes.item(i);
                NamedNodeMap attributes = node.getAttributes();
                Node attributeNode = attributes.getNamedItem("apiFramework");
                mediaFile.setApiFramework(attributeNode == null ? null : attributeNode.getNodeValue());
                attributeNode = attributes.getNamedItem("bitrate");
                if (attributeNode == null) {
                    bigInteger = null;
                } else {
                    bigInteger = new BigInteger(attributeNode.getNodeValue());
                }
                mediaFile.setBitrate(bigInteger);
                attributeNode = attributes.getNamedItem("delivery");
                mediaFile.setDelivery(attributeNode == null ? null : attributeNode.getNodeValue());
                attributeNode = attributes.getNamedItem("height");
                mediaFile.setHeight(attributeNode == null ? null : new BigInteger(attributeNode.getNodeValue()));
                attributeNode = attributes.getNamedItem("id");
                mediaFile.setId(attributeNode == null ? null : attributeNode.getNodeValue());
                attributeNode = attributes.getNamedItem("maintainAspectRatio");
                mediaFile.setMaintainAspectRatio(attributeNode == null ? null : Boolean.valueOf(attributeNode.getNodeValue()));
                attributeNode = attributes.getNamedItem("scalable");
                mediaFile.setScalable(attributeNode == null ? null : Boolean.valueOf(attributeNode.getNodeValue()));
                attributeNode = attributes.getNamedItem("type");
                mediaFile.setType(attributeNode == null ? null : attributeNode.getNodeValue());
                attributeNode = attributes.getNamedItem("width");
                mediaFile.setWidth(attributeNode == null ? null : new BigInteger(attributeNode.getNodeValue()));
                mediaFile.setValue(HttpTools.fixupURI(XmlTools.getElementValue(node)));
                mediaFiles.add(mediaFile);
            }
            return mediaFiles;
        } catch (Exception e) {
            VASTLog.m785e(TAG, e.getMessage(), e);
            return null;
        }
    }

    public Integer getDuration() {
        Integer num = null;
        VASTLog.m783d(TAG, "getDuration");
        String durationStr = null;
        try {
            NodeList nodes = (NodeList) XPathFactory.newInstance().newXPath().evaluate(durationXPATH, this.vastsDocument, XPathConstants.NODESET);
            if (nodes != null) {
                for (int i = 0; i < nodes.getLength(); i++) {
                    durationStr = XmlTools.getElementValue(nodes.item(i));
                }
            }
            if (durationStr != null) {
                Time timeObj = Time.valueOf(durationStr);
                num = Integer.valueOf(((timeObj.getHours() * 3600) + (timeObj.getMinutes() * 60)) + timeObj.getSeconds());
            }
        } catch (Exception e) {
            VASTLog.m785e(TAG, e.getMessage(), e);
        }
        return num;
    }

    public VideoClicks getVideoClicks() {
        VASTLog.m783d(TAG, "getVideoClicks");
        VideoClicks videoClicks = new VideoClicks();
        try {
            NodeList nodes = (NodeList) XPathFactory.newInstance().newXPath().evaluate(videoClicksXPATH, this.vastsDocument, XPathConstants.NODESET);
            if (nodes == null) {
                return videoClicks;
            }
            for (int i = 0; i < nodes.getLength(); i++) {
                NodeList childNodes = nodes.item(i).getChildNodes();
                for (int childIndex = 0; childIndex < childNodes.getLength(); childIndex++) {
                    Node child = childNodes.item(childIndex);
                    String nodeName = child.getNodeName();
                    if (nodeName.equalsIgnoreCase("ClickTracking")) {
                        videoClicks.getClickTracking().add(HttpTools.fixupURI(XmlTools.getElementValue(child)));
                    } else if (nodeName.equalsIgnoreCase("ClickThrough")) {
                        videoClicks.setClickThrough(HttpTools.fixupURI(XmlTools.getElementValue(child)));
                    } else if (nodeName.equalsIgnoreCase("CustomClick")) {
                        videoClicks.getCustomClick().add(HttpTools.fixupURI(XmlTools.getElementValue(child)));
                    }
                }
            }
            return videoClicks;
        } catch (Exception e) {
            VASTLog.m785e(TAG, e.getMessage(), e);
            return null;
        }
    }

    public Integer getSkipOffset() {
        VASTLog.m783d(TAG, "getVideoSkips");
        try {
            NodeList nodes = (NodeList) XPathFactory.newInstance().newXPath().evaluate(combinedSkipOffsetXPATH, this.vastsDocument, XPathConstants.NODESET);
            if (nodes != null && nodes.getLength() > 0) {
                String skipOffsetValue = nodes.item(0).getNodeValue();
                Integer duration = getDuration();
                if (duration != null && skipOffsetValue.endsWith("%") && skipOffsetValue.length() > 1) {
                    try {
                        Double percentageDecimal = Double.valueOf(Double.valueOf(skipOffsetValue.substring(0, skipOffsetValue.length() - 1)).doubleValue() / 100.0d);
                        if (percentageDecimal.doubleValue() <= 1.0d) {
                            return Integer.valueOf(Long.valueOf(Math.round(percentageDecimal.doubleValue() * ((double) duration.intValue()))).intValue());
                        }
                        throw new Exception("Not a valid percent!");
                    } catch (NumberFormatException e) {
                        return null;
                    }
                } else if (skipOffsetValue.contains(":")) {
                    Time timeObj = Time.valueOf(skipOffsetValue);
                    Integer totalSeconds = Integer.valueOf(((timeObj.getHours() * 3600) + (timeObj.getMinutes() * 60)) + timeObj.getSeconds());
                    if (totalSeconds.intValue() <= duration.intValue()) {
                        return totalSeconds;
                    }
                    throw new Exception("Not a valid skip. Can't be greater than duration!");
                }
            }
            return null;
        } catch (Exception e2) {
            VASTLog.m785e(TAG, e2.getMessage(), e2);
            return null;
        }
    }

    public List<String> getImpressions() {
        VASTLog.m783d(TAG, "getImpressions");
        return getListFromXPath(impressionXPATH);
    }

    public List<String> getErrorUrl() {
        VASTLog.m783d(TAG, "getErrorUrl");
        return getListFromXPath(errorUrlXPATH);
    }

    private List<String> getListFromXPath(String xPath) {
        VASTLog.m783d(TAG, "getListFromXPath");
        ArrayList<String> list = new ArrayList();
        try {
            NodeList nodes = (NodeList) XPathFactory.newInstance().newXPath().evaluate(xPath, this.vastsDocument, XPathConstants.NODESET);
            if (nodes == null) {
                return list;
            }
            for (int i = 0; i < nodes.getLength(); i++) {
                String fixedUrl = HttpTools.fixupURI(XmlTools.getElementValue(nodes.item(i)));
                if (!(fixedUrl == null || fixedUrl.isEmpty())) {
                    list.add(fixedUrl);
                }
            }
            return list;
        } catch (Exception e) {
            VASTLog.m785e(TAG, e.getMessage(), e);
            return null;
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        VASTLog.m783d(TAG, "writeObject: about to write");
        oos.defaultWriteObject();
        oos.writeObject(XmlTools.xmlDocumentToString(this.vastsDocument));
        VASTLog.m783d(TAG, "done writing");
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        VASTLog.m783d(TAG, "readObject: about to read");
        ois.defaultReadObject();
        String vastString = (String) ois.readObject();
        VASTLog.m783d(TAG, "vastString data is:\n" + vastString + "\n");
        this.vastsDocument = XmlTools.stringToDocument(vastString);
        VASTLog.m783d(TAG, "done reading");
    }

    public void setPickedMediaFile(VASTMediaFile mediaFile) {
        this.pickedMediaFile = mediaFile;
    }

    public synchronized VideoDisplayOptions getVideoDisplayOptions() {
        VideoDisplayOptions options;
        if (this.cachedVideoDisplayOptions == null) {
            options = new VideoDisplayOptions();
            options.allowClick = true;
            if (this.adUnit == null || !this.adUnit.equals(AdUnit.INCENTIVIZED)) {
                Integer lockoutTimeSeconds = getSkipOffset();
                if (lockoutTimeSeconds == null || lockoutTimeSeconds.intValue() <= 0) {
                    options.allowHide = true;
                    options.allowSkip = false;
                    options.allowInstallButton = false;
                } else {
                    options.lockoutTime = lockoutTimeSeconds.intValue() * 1000;
                    options.allowHide = false;
                    options.allowSkip = true;
                    options.allowInstallButton = false;
                }
                this.cachedVideoDisplayOptions = options;
            } else {
                options.lockoutTime = 0;
                options.allowHide = false;
                options.allowSkip = false;
                options.allowInstallButton = false;
            }
        }
        options = this.cachedVideoDisplayOptions;
        return options;
    }

    public Boolean isFileCached() {
        boolean z = this.cacheEntry != null && this.cacheEntry.fileExists().booleanValue();
        return Boolean.valueOf(z);
    }

    public Uri getStreamingUri() {
        return Uri.parse(this.pickedMediaFile.getValue());
    }

    public Uri getStaticUri() {
        return Uri.parse(this.pickedMediaFile.getValue());
    }

    public Entry getCacheEntry() {
        return this.cacheEntry;
    }

    public void setCacheEntry(Entry entry) {
        this.cacheEntry = entry;
    }

    public Boolean isReady() {
        return Boolean.valueOf(false);
    }

    public void setIsReady(Boolean isReady) {
    }

    public void setPercentDownloaded(Integer percent) {
    }

    public void setSize(int size) {
    }

    public String getCreativeUniqueIdentifier() {
        String md5 = Utils.md5Hex(this.pickedMediaFile.getValue().getBytes());
        return md5 == null ? this.pickedMediaFile.getValue().substring(0, Math.min(this.pickedMediaFile.getValue().length(), 32)) : md5;
    }

    public void setAdUnit(AdUnit adUnit) {
        this.adUnit = adUnit;
        this.cachedVideoDisplayOptions = null;
    }
}
