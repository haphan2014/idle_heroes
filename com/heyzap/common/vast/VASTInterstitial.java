package com.heyzap.common.vast;

import android.app.Activity;
import android.content.Intent;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.common.net.Connectivity;
import com.heyzap.common.vast.model.VASTModel;
import com.heyzap.common.vast.processor.VASTProcessor;
import com.heyzap.common.vast.util.DefaultMediaPicker;
import com.heyzap.common.vast.util.VASTLog;
import com.heyzap.common.video.Cacher;
import com.heyzap.exchange.ExchangeAd;
import com.heyzap.exchange.ExchangeRequestParams;
import com.heyzap.house.model.AdModel.ModelPostFetchCompleteListener;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.internal.ContextReference;
import com.heyzap.sdk.ads.VASTActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class VASTInterstitial extends ExchangeAd {
    private static final String KLASS = "com.heyzap.vast.VASTModel";
    private static final String TAG = "VASTPlayer";
    public static final String VERSION = "1.3";
    public static VASTPlayerListener listener;
    private VASTPlayerListener mListener = new ExchangeVASTInterstitialListener();
    private VASTModel vastModel;

    class C12953 implements Runnable {
        C12953() {
        }

        public void run() {
            VASTInterstitial.this.mListener.vastReady();
        }
    }

    public interface VASTPlayerListener {
        void vastClick();

        void vastComplete();

        void vastDismiss();

        void vastError(VASTError vASTError);

        void vastIncomplete();

        void vastReady();

        void vastStart();
    }

    public class ExchangeVASTInterstitialListener implements VASTPlayerListener {
        public void vastReady() {
            VASTInterstitial.this.fetchListener.set(new FetchResult());
        }

        public void vastError(VASTError error) {
            VASTInterstitial.this.fetchListener.set(new FetchResult(FetchFailureReason.UNKNOWN, "vast_" + String.valueOf(error).toLowerCase()));
        }

        public void vastClick() {
            VASTInterstitial.this.clickEventStream.sendEvent(Boolean.valueOf(true));
        }

        public void vastComplete() {
            VASTInterstitial.this.incentiveListener.set(Boolean.valueOf(true));
        }

        public void vastIncomplete() {
            VASTInterstitial.this.incentiveListener.set(Boolean.valueOf(false));
        }

        public void vastDismiss() {
            VASTInterstitial.this.closeListener.set(Boolean.valueOf(true));
        }

        public void vastStart() {
            VASTInterstitial.this.displayEventStream.sendEvent(DisplayResult.SUCCESS);
        }
    }

    public enum VASTError {
        NONE,
        NO_NETWORK,
        XML_OPEN_OR_READ,
        XML_PARSE,
        SCHEMA_VALIDATION,
        POST_VALIDATION,
        EXCEEDED_WRAPPER_LIMIT,
        VIDEO_PLAYBACK,
        CACHE_FAILED
    }

    public VASTInterstitial(String markup, String url, String adId, String score, long expiry, boolean refetchOnExpiry, String extraData, ExchangeRequestParams params, ContextReference ref) {
        super(markup, url, adId, score, expiry, refetchOnExpiry, extraData, params, ref);
        loadVideoWithData(markup);
    }

    public void loadVideoWithUrl(final String urlString) {
        VASTLog.m783d(TAG, "loadVideoWithUrl " + urlString);
        this.vastModel = null;
        if (Connectivity.isConnected(this.ref.getApp())) {
            new Thread(new Runnable() {
                public void run() {
                    Exception e;
                    Throwable th;
                    BufferedReader bufferedReader = null;
                    try {
                        BufferedReader in = new BufferedReader(new InputStreamReader(new URL(urlString).openStream()));
                        try {
                            StringBuffer sb = new StringBuffer();
                            while (true) {
                                String line = in.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line).append(System.getProperty("line.separator"));
                            }
                            if (in != null) {
                                try {
                                    in.close();
                                } catch (IOException e2) {
                                }
                            }
                            VASTInterstitial.this.loadVideoWithData(sb.toString());
                            bufferedReader = in;
                        } catch (Exception e3) {
                            e = e3;
                            bufferedReader = in;
                            try {
                                VASTInterstitial.this.sendError(VASTError.XML_OPEN_OR_READ);
                                VASTLog.m785e(VASTInterstitial.TAG, e.getMessage(), e);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e4) {
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = in;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        VASTInterstitial.this.sendError(VASTError.XML_OPEN_OR_READ);
                        VASTLog.m785e(VASTInterstitial.TAG, e.getMessage(), e);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    }
                }
            }).start();
        } else {
            sendError(VASTError.NO_NETWORK);
        }
    }

    public void loadVideoWithData(final String xmlData) {
        VASTLog.m787v(TAG, "loadVideoWithData\n" + xmlData);
        this.vastModel = null;
        if (Connectivity.isConnected(this.ref.getApp())) {
            new Thread(new Runnable() {

                class C12931 implements ModelPostFetchCompleteListener {
                    C12931() {
                    }

                    public void onComplete(Object model, Throwable e) {
                        if (e != null) {
                            VASTInterstitial.this.sendError(VASTError.CACHE_FAILED);
                        } else {
                            VASTInterstitial.this.sendReady();
                        }
                    }
                }

                public void run() {
                    VASTProcessor processor = new VASTProcessor(new DefaultMediaPicker(VASTInterstitial.this.ref.getApp()));
                    VASTError error = processor.process(xmlData);
                    if (error == VASTError.NONE) {
                        VASTInterstitial.this.vastModel = processor.getModel();
                        Cacher.start(VASTInterstitial.this.ref.getApp(), VASTInterstitial.this.vastModel, new C12931());
                        return;
                    }
                    VASTInterstitial.this.sendError(error);
                }
            }).start();
        } else {
            sendError(VASTError.NO_NETWORK);
        }
    }

    public void show(Activity activity, AdUnit adUnit) {
        VASTLog.m783d(TAG, "play");
        if (this.vastModel != null) {
            this.vastModel.setAdUnit(adUnit);
            listener = this.mListener;
            if (Connectivity.isConnected(activity)) {
                Intent vastPlayerIntent = new Intent(activity, VASTActivity.class);
                vastPlayerIntent.putExtra(KLASS, this.vastModel);
                activity.startActivity(vastPlayerIntent);
                return;
            }
            sendError(VASTError.NO_NETWORK);
            return;
        }
        VASTLog.m788w(TAG, "vastModel is null; nothing to play");
    }

    public void show(Activity activity) {
    }

    public void load() {
    }

    public boolean onBackPressed() {
        return false;
    }

    private void sendReady() {
        VASTLog.m783d(TAG, "sendReady");
        if (this.mListener != null) {
            this.ref.getActivity().runOnUiThread(new C12953());
        }
    }

    private void sendError(final VASTError error) {
        VASTLog.m783d(TAG, "sendError");
        if (this.mListener != null) {
            this.ref.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    VASTInterstitial.this.mListener.vastError(error);
                }
            });
        }
    }
}
