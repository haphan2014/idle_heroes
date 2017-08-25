package com.heyzap.sdk.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAdView;
import com.heyzap.common.concurrency.FutureUtils;
import com.heyzap.common.concurrency.HandlerExecutorService;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.DisplayOptions.Builder;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.EventStream.EventListener;
import com.heyzap.common.lifecycle.FetchOptions;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.internal.Constants;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.AuctionType;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.ContextReference;
import com.heyzap.internal.LargeSet;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Utils;
import com.heyzap.mediation.MediationManager;
import com.heyzap.mediation.MediationResult;
import com.heyzap.mediation.abstr.NetworkAdapter;
import com.heyzap.mediation.adapter.AdapterScanner;
import com.heyzap.mediation.config.ConfigLoader.MediationConfigListener;
import com.heyzap.mediation.config.MediationConfig;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.ads.HeyzapAds.BannerError;
import com.heyzap.sdk.ads.HeyzapAds.BannerListener;
import com.heyzap.sdk.ads.HeyzapAds.NativeError;
import com.heyzap.sdk.ads.NativeAd.AdmobListener;
import com.heyzap.sdk.ads.NativeAd.NativeAdOptions;
import com.heyzap.sdk.mediation.testactivity.NetworkStatus;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

public final class MediationTestActivity extends Activity {
    private ContextReference contextReference;
    TreeMap<String, NetworkStatus> currentNetworks = new TreeMap();
    private boolean inSecondView = false;
    @Nullable
    private BannerAdView lastBanner;
    private FrameLayout mainContentView;
    private ExecutorService uiThreadExecutorService;
    List<String> upperCaseNames;

    class C14861 extends ArrayList<String> {
        C14861() {
            for (NetworkStatus networkStatus : MediationTestActivity.this.currentNetworks.values()) {
                add(networkStatus.getName());
            }
        }
    }

    class C14912 implements Runnable {
        C14912() {
        }

        public void run() {
            if (!MediationTestActivity.this.inSecondView) {
                MediationTestActivity.this.reloadNetworkStatus();
            }
        }
    }

    class C14945 implements MediationConfigListener {
        C14945() {
        }

        public void onConfigLoaded(MediationConfig config) {
            for (NetworkAdapter adapter : config.getAdapterPool().getAll()) {
                NetworkStatus status = (NetworkStatus) MediationTestActivity.this.currentNetworks.get(adapter.getCanonicalName());
                if (status.getName().equals("Heyzap")) {
                    if (adapter.isInitialized()) {
                        status.setRemoteStatus(1);
                    } else {
                        status.setRemoteStatus(2);
                    }
                } else if (status.getNetworkAdapter() == null || !status.getNetworkAdapter().isInitialized()) {
                    status.setRemoteStatus(2);
                } else {
                    status.fetchRequestStore = status.getNetworkAdapter().getFetchStore();
                    status.setRemoteStatus(1);
                }
                status.refreshLocalStatus(adapter);
            }
            MediationTestActivity.this.assembleUI();
        }
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        final ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            Bitmap mIcon11 = null;
            try {
                mIcon11 = BitmapFactory.decodeStream(new URL(urls[0]).openStream());
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            this.bmImage.setImageBitmap(result);
        }
    }

    class NetworkArrayAdapter extends ArrayAdapter<String> {
        final Context context;
        final boolean isDebug;
        final String[] networkNames;
        TreeMap<String, NetworkStatus> networkStatusMap;

        public NetworkArrayAdapter(Context context, String[] networkNames, TreeMap<String, NetworkStatus> networkStatusMap) {
            super(context, -1, networkNames);
            this.context = context;
            this.networkNames = networkNames;
            this.networkStatusMap = networkStatusMap;
            this.isDebug = Utils.isDebug(context).booleanValue();
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            RelativeLayout relativeLayout = new RelativeLayout(this.context);
            relativeLayout.setMinimumHeight(Utils.dpToPx(this.context, 50));
            int padding = Utils.dpToPx(this.context, 15);
            String networkName = this.networkNames[position];
            NetworkStatus networkStatus = getNetworkStatusFromNetworkName(networkName);
            final String canonicalName = getCanonicalNameFromNetworkName(networkName);
            TextView textView = new TextView(this.context);
            textView.setText(networkName);
            textView.setGravity(16);
            textView.setTextSize(18.0f);
            textView.setPadding(padding, 0, 0, 0);
            textView.setFocusable(false);
            textView.setFocusableInTouchMode(false);
            LayoutParams textViewLayout = new LayoutParams(-2, -2);
            textViewLayout.addRule(9);
            textViewLayout.addRule(15);
            relativeLayout.addView(textView, textViewLayout);
            LinearLayout rightRow = new LinearLayout(this.context);
            rightRow.setOrientation(0);
            LayoutParams rightRowLayout = new LayoutParams(-2, -2);
            rightRowLayout.addRule(11);
            rightRowLayout.addRule(15);
            TextView statusMark = new TextView(this.context);
            statusMark.setText(networkStatus.getNetworkStatus() ? "on" : "off");
            statusMark.setBackgroundColor(networkStatus.getNetworkStatus() ? -16711936 : SupportMenu.CATEGORY_MASK);
            statusMark.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            statusMark.getBackground().setAlpha(networkStatus.getNetworkStatus() ? TransportMediator.KEYCODE_MEDIA_RECORD : 180);
            statusMark.setTextSize(12.0f);
            statusMark.setTypeface(null, 1);
            statusMark.setGravity(17);
            LinearLayout.LayoutParams statusMarkLayout = new LinearLayout.LayoutParams(Utils.dpToPx(this.context, 30), -1);
            statusMarkLayout.setMargins(0, 0, padding, 0);
            rightRow.addView(statusMark, statusMarkLayout);
            if (this.isDebug) {
                CheckBox checkbox = new CheckBox(this.context);
                checkbox.setGravity(16);
                checkbox.setFocusable(false);
                checkbox.setFocusableInTouchMode(false);
                checkbox.setPadding(padding, padding, padding, padding);
                checkbox.setChecked(!MediationTestActivityDisabledNetworks.isNetworkDisabled(this.context, canonicalName));
                checkbox.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        MediationTestActivityDisabledNetworks.disableNetwork(NetworkArrayAdapter.this.context, canonicalName, !((CheckBox) v).isChecked());
                    }
                });
                rightRow.addView(checkbox, new LinearLayout.LayoutParams(-1, -1));
            }
            relativeLayout.addView(rightRow, rightRowLayout);
            return relativeLayout;
        }

        private String getCanonicalNameFromNetworkName(String networkName) {
            NetworkStatus networkStatus = getNetworkStatusFromNetworkName(networkName);
            if (networkStatus == null) {
                return null;
            }
            return networkStatus.getNetworkAdapter().getCanonicalName();
        }

        private NetworkStatus getNetworkStatusFromNetworkName(String networkName) {
            NetworkStatus networkStatus = null;
            for (Entry<String, NetworkStatus> entry : MediationTestActivity.this.currentNetworks.entrySet()) {
                if (((NetworkStatus) entry.getValue()).getName().equals(networkName)) {
                    networkStatus = (NetworkStatus) entry.getValue();
                }
            }
            return networkStatus;
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.uiThreadExecutorService = new HandlerExecutorService(new Handler(Looper.getMainLooper()));
        this.contextReference = MediationManager.getInstance().getContextRef();
        this.contextReference.updateContext(this);
        for (Class<? extends NetworkAdapter> klass : new AdapterScanner().scan()) {
            NetworkAdapter adapter = NetworkAdapter.createAdapterFromKlass(klass);
            this.currentNetworks.put(adapter.getCanonicalName(), new NetworkStatus(adapter.getMarketingName(), adapter));
        }
        this.upperCaseNames = new C14861();
        this.mainContentView = new FrameLayout(this);
        setContentView(this.mainContentView);
        TextView loading = new TextView(this);
        loading.setText("Loading...");
        this.mainContentView.removeAllViews();
        this.mainContentView.addView(loading);
        MediationManager.getInstance().getConfigLoader().addConfigChangedListener(new C14912());
        reloadNetworkStatus();
    }

    private void assembleUI() {
        this.inSecondView = false;
        final ListView networkStatusListView = new ListView(this);
        final NetworkArrayAdapter networkStatusArrayAdapter = new NetworkArrayAdapter(this, (String[]) this.upperCaseNames.toArray(new String[this.upperCaseNames.size()]), this.currentNetworks);
        networkStatusListView.setAdapter(networkStatusArrayAdapter);
        networkStatusListView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                MediationTestActivity.this.makeSecondaryUI((String) networkStatusArrayAdapter.getItem(position));
            }
        });
        runOnUiThread(new Runnable() {
            public void run() {
                MediationTestActivity.this.destroyBanner();
                MediationTestActivity.this.mainContentView.removeAllViews();
                MediationTestActivity.this.mainContentView.addView(networkStatusListView);
            }
        });
    }

    private void reloadNetworkStatus() {
        HeyzapAds.changeActivity(this);
        MediationManager.getInstance().getConfigLoader().get(new C14945());
    }

    private void makeSecondaryUI(String network) {
        NetworkStatus tmpStatus = null;
        for (Entry<String, NetworkStatus> entry : this.currentNetworks.entrySet()) {
            if (((NetworkStatus) entry.getValue()).getName().equals(network)) {
                tmpStatus = (NetworkStatus) entry.getValue();
            }
        }
        if (tmpStatus != null) {
            NetworkStatus status = tmpStatus;
            this.inSecondView = true;
            View localInfo = status.getLocalTextView(this);
            View manifestInfo = status.getManifestTextView(this);
            View remoteInfo = status.getRemoteTextView(this);
            View scrollView = new ScrollView(this);
            LinearLayout mainLayout = new LinearLayout(this);
            final LinearLayout nativeAdLayout = new LinearLayout(this);
            mainLayout.setOrientation(1);
            scrollView = new TextView(this);
            scrollView.setText(network);
            scrollView.setTextSize(40.0f);
            final RadioGroup adType = new RadioGroup(this);
            Set<AdUnit> validUnits = status.getNetworkAdapter().getAllAdUnitCapabilities();
            boolean first = true;
            final Button fetchButton = new Button(this);
            fetchButton.setTextSize(20.0f);
            fetchButton.setText("Fetch");
            final Button showButton = new Button(this);
            showButton.setTextSize(20.0f);
            showButton.setText("Show");
            final Button loadBannerButton = new Button(this);
            loadBannerButton.setTextSize(20.0f);
            loadBannerButton.setText("Load");
            final Button loadNativeButton = new Button(this);
            loadNativeButton.setTextSize(20.0f);
            loadNativeButton.setText("Load");
            fetchButton.setVisibility(0);
            showButton.setVisibility(0);
            loadBannerButton.setVisibility(8);
            loadNativeButton.setVisibility(8);
            if (validUnits != null) {
                for (AdUnit unit : validUnits) {
                    RadioButton button = new RadioButton(this);
                    button.setTextSize(20.0f);
                    if (unit == AdUnit.INTERSTITIAL) {
                        button.setText("Interstitial");
                    } else if (unit == AdUnit.INCENTIVIZED) {
                        button.setText("Rewarded Video");
                    } else if (unit == AdUnit.VIDEO) {
                        button.setText("Video");
                    } else if (unit == AdUnit.BANNER) {
                        button.setText("Banner");
                    } else if (unit == AdUnit.NATIVE) {
                        button.setText("Native");
                    }
                    if (unit == AdUnit.BANNER) {
                        button.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (isChecked) {
                                    fetchButton.setVisibility(8);
                                    showButton.setVisibility(8);
                                    loadBannerButton.setVisibility(0);
                                    return;
                                }
                                MediationTestActivity.this.destroyBanner();
                                loadBannerButton.setVisibility(8);
                            }
                        });
                    } else if (unit == AdUnit.NATIVE) {
                        button.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (isChecked) {
                                    fetchButton.setVisibility(8);
                                    showButton.setVisibility(8);
                                    loadNativeButton.setVisibility(0);
                                    nativeAdLayout.setVisibility(0);
                                    return;
                                }
                                loadNativeButton.setVisibility(8);
                                nativeAdLayout.setVisibility(8);
                            }
                        });
                    } else {
                        button.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (isChecked) {
                                    fetchButton.setVisibility(0);
                                    showButton.setVisibility(0);
                                }
                            }
                        });
                    }
                    adType.addView(button);
                    if (first) {
                        adType.check(button.getId());
                        first = false;
                    }
                }
            }
            if (validUnits == null || !status.getNetworkStatus()) {
                fetchButton.setEnabled(false);
                showButton.setEnabled(false);
            } else {
                final NetworkStatus networkStatus = status;
                loadBannerButton.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        MediationTestActivity.this.destroyBanner();
                        MediationTestActivity.this.loadBanner(networkStatus);
                    }
                });
                networkStatus = status;
                fetchButton.setOnClickListener(new OnClickListener() {
                    public void onClick(View arg0) {
                        MediationTestActivity.this.fetchAd(adType, networkStatus);
                    }
                });
                networkStatus = status;
                showButton.setOnClickListener(new OnClickListener() {
                    public void onClick(View arg0) {
                        MediationTestActivity.this.showAd(adType, networkStatus);
                    }
                });
                networkStatus = status;
                loadNativeButton.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        MediationTestActivity.this.loadNativeAd(nativeAdLayout, networkStatus);
                    }
                });
            }
            mainLayout.addView(scrollView);
            mainLayout.addView(localInfo);
            mainLayout.addView(manifestInfo);
            mainLayout.addView(remoteInfo);
            mainLayout.addView(adType);
            mainLayout.addView(fetchButton);
            mainLayout.addView(showButton);
            mainLayout.addView(loadBannerButton);
            mainLayout.addView(loadNativeButton);
            mainLayout.addView(nativeAdLayout);
            scrollView.addView(mainLayout);
            this.mainContentView.removeAllViews();
            this.mainContentView.addView(scrollView);
        }
    }

    @TargetApi(17)
    private void loadNativeAd(LinearLayout nativeAdContainer, NetworkStatus status) {
        NativeAd nativeAd = new NativeAd(new NativeAdOptions());
        nativeAdContainer.removeAllViews();
        final RelativeLayout nativeAdLayout = new RelativeLayout(this);
        nativeAdLayout.setGravity(80);
        final ImageView nativeIconImage = new ImageView(this);
        nativeIconImage.setId(View.generateViewId());
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        nativeIconImage.setPadding(0, 0, 20, 0);
        nativeIconImage.setAdjustViewBounds(true);
        nativeAdLayout.addView(nativeIconImage, layoutParams);
        final TextView nativeTitle = new TextView(this);
        nativeTitle.setId(View.generateViewId());
        layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(1, nativeIconImage.getId());
        nativeAdLayout.addView(nativeTitle, layoutParams);
        final TextView nativeBody = new TextView(this);
        nativeBody.setId(View.generateViewId());
        nativeBody.setLines(2);
        layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(3, nativeTitle.getId());
        layoutParams.addRule(1, nativeIconImage.getId());
        nativeAdLayout.addView(nativeBody, layoutParams);
        final ImageView nativeCoverImage = new ImageView(this);
        nativeCoverImage.setId(View.generateViewId());
        layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(8);
        layoutParams.addRule(14);
        layoutParams.addRule(3, nativeBody.getId());
        layoutParams.addRule(3, nativeIconImage.getId());
        nativeCoverImage.setAdjustViewBounds(true);
        nativeAdLayout.addView(nativeCoverImage, layoutParams);
        final TextView nativeIconDimensions = new TextView(this);
        layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(8, nativeIconImage.getId());
        nativeAdLayout.addView(nativeIconDimensions, layoutParams);
        final TextView nativeCoverImageDimensions = new TextView(this);
        layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(8, nativeCoverImage.getId());
        layoutParams.addRule(7, nativeCoverImage.getId());
        nativeAdLayout.addView(nativeCoverImageDimensions, layoutParams);
        final ImageView nativeAdChoicesImage = new ImageView(this);
        layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(11);
        nativeAdLayout.addView(nativeAdChoicesImage, layoutParams);
        final NativeAd nativeAd2 = nativeAd;
        nativeAdContainer.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                nativeAd2.doClick(nativeAdLayout);
            }
        });
        final LinearLayout linearLayout = nativeAdContainer;
        nativeAd.setListener(new NativeListener() {

            class C14802 implements Runnable {
                C14802() {
                }

                public void run() {
                    Toast.makeText(MediationTestActivity.this, "Ad Clicked", 0).show();
                }
            }

            public void onError(final NativeError error) {
                MediationTestActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(MediationTestActivity.this, error.getErrorMessage(), 1).show();
                    }
                });
            }

            public void onAdLoaded(NativeAd ad) {
                MediationTestActivity.this.displayNativeAd(ad, nativeAdLayout, nativeTitle, nativeBody, nativeIconDimensions, nativeIconImage, nativeCoverImageDimensions, nativeCoverImage, nativeAdChoicesImage, linearLayout);
            }

            public void onAdClicked(NativeAd ad) {
                MediationTestActivity.this.runOnUiThread(new C14802());
            }

            public void onAdShown(NativeAd ad) {
            }
        });
        final TextView textView = nativeTitle;
        final TextView textView2 = nativeBody;
        final TextView textView3 = nativeIconDimensions;
        final ImageView imageView = nativeIconImage;
        final TextView textView4 = nativeCoverImageDimensions;
        final ImageView imageView2 = nativeCoverImage;
        final LinearLayout linearLayout2 = nativeAdContainer;
        final RelativeLayout relativeLayout = nativeAdLayout;
        nativeAd.setAdmobListener(new AdmobListener() {
            public void onAppInstallAdLoaded(final NativeAd nativeAd, final NativeAppInstallAd appInstallAd) {
                MediationTestActivity.this.runOnUiThread(new Runnable() {

                    class C14811 implements OnClickListener {
                        C14811() {
                        }

                        public void onClick(View v) {
                            nativeAd.doClick(relativeLayout);
                        }
                    }

                    public void run() {
                        textView.setText(appInstallAd.getHeadline());
                        textView2.setText(appInstallAd.getBody());
                        textView3.setText(String.format("%sx%s", new Object[]{Integer.valueOf(appInstallAd.getIcon().getDrawable().getBounds().width()), Integer.valueOf(appInstallAd.getIcon().getDrawable().getBounds().height())}));
                        String iconUrl = appInstallAd.getIcon().getUri().toString();
                        new DownloadImageTask(imageView).execute(new String[]{iconUrl});
                        String ciu = "";
                        if (!appInstallAd.getImages().isEmpty()) {
                            ciu = ((Image) appInstallAd.getImages().get(0)).getUri().toString();
                            textView4.setText(String.format("%sx%s", new Object[]{Integer.valueOf(((Image) appInstallAd.getImages().get(0)).getDrawable().getBounds().width()), Integer.valueOf(((Image) appInstallAd.getImages().get(0)).getDrawable().getBounds().height())}));
                        }
                        String coverImageUrl = ciu;
                        new DownloadImageTask(imageView2).execute(new String[]{coverImageUrl});
                        NativeAppInstallAdView wrapper = new NativeAppInstallAdView(MediationTestActivity.this);
                        wrapper.setBodyView(textView2);
                        wrapper.setHeadlineView(textView);
                        wrapper.setIconView(imageView);
                        wrapper.setImageView(imageView2);
                        wrapper.setNativeAd(appInstallAd);
                        linearLayout2.addView(relativeLayout);
                        nativeAd.doImpression();
                        linearLayout2.setOnClickListener(new C14811());
                    }
                });
            }

            public void onContentAdLoaded(final NativeAd heyzapNativeAd, final NativeContentAd contentAd) {
                MediationTestActivity.this.runOnUiThread(new Runnable() {

                    class C14831 implements OnClickListener {
                        C14831() {
                        }

                        public void onClick(View v) {
                            heyzapNativeAd.doClick(relativeLayout);
                        }
                    }

                    public void run() {
                        textView.setText(contentAd.getHeadline());
                        textView2.setText(contentAd.getBody());
                        String iu = "";
                        if (contentAd.getLogo() != null) {
                            textView3.setText(String.format("%sx%s", new Object[]{Integer.valueOf(contentAd.getLogo().getDrawable().getBounds().width()), Integer.valueOf(contentAd.getLogo().getDrawable().getBounds().height())}));
                            iu = contentAd.getLogo().getUri().toString();
                        }
                        String iconUrl = iu;
                        new DownloadImageTask(imageView).execute(new String[]{iconUrl});
                        String ciu = "";
                        if (!contentAd.getImages().isEmpty()) {
                            ciu = ((Image) contentAd.getImages().get(0)).getUri().toString();
                            textView4.setText(String.format("%sx%s", new Object[]{Integer.valueOf(((Image) contentAd.getImages().get(0)).getDrawable().getBounds().width()), Integer.valueOf(((Image) contentAd.getImages().get(0)).getDrawable().getBounds().height())}));
                        }
                        String coverImageUrl = ciu;
                        new DownloadImageTask(imageView2).execute(new String[]{coverImageUrl});
                        NativeContentAdView wrapper = new NativeContentAdView(relativeLayout.getContext());
                        wrapper.setBodyView(textView2);
                        wrapper.setHeadlineView(textView);
                        wrapper.setLogoView(imageView);
                        wrapper.setImageView(imageView2);
                        wrapper.addView(relativeLayout);
                        wrapper.setNativeAd(contentAd);
                        heyzapNativeAd.registerView(wrapper);
                        linearLayout2.addView(wrapper);
                        heyzapNativeAd.doImpression();
                        linearLayout2.setOnClickListener(new C14831());
                    }
                });
            }
        });
        nativeAd.load(null, status.getNetworkAdapter().getCanonicalName());
    }

    private void displayNativeAd(NativeAd nativeAd, RelativeLayout nativeTestLayout, TextView nativeTitle, TextView nativeBody, TextView nativeIconDimensions, ImageView nativeIconImage, TextView nativeCoverImageDimensions, ImageView nativeCoverImage, ImageView nativeAdChoicesImage, LinearLayout nativeAdContainer) {
        final NativeAd nativeAd2 = nativeAd;
        final RelativeLayout relativeLayout = nativeTestLayout;
        final TextView textView = nativeTitle;
        final TextView textView2 = nativeBody;
        final TextView textView3 = nativeIconDimensions;
        final ImageView imageView = nativeIconImage;
        final TextView textView4 = nativeCoverImageDimensions;
        final ImageView imageView2 = nativeCoverImage;
        final ImageView imageView3 = nativeAdChoicesImage;
        final LinearLayout linearLayout = nativeAdContainer;
        runOnUiThread(new Runnable() {

            class C14851 implements OnClickListener {
                C14851() {
                }

                public void onClick(View v) {
                    Intent i = new Intent("android.intent.action.VIEW");
                    i.setData(Uri.parse(nativeAd2.getAdChoicesUrl()));
                    MediationTestActivity.this.startActivity(i);
                }
            }

            public void run() {
                nativeAd2.registerView(relativeLayout);
                textView.setText(nativeAd2.getTitle());
                textView2.setText(nativeAd2.getBody());
                NativeAd.Image icon = nativeAd2.getIcon();
                textView3.setText(String.format("%sx%s", new Object[]{Integer.valueOf(icon.getWidth()), Integer.valueOf(icon.getHeight())}));
                new DownloadImageTask(imageView).execute(new String[]{icon.getUrl()});
                NativeAd.Image coverImage = nativeAd2.getCoverImage();
                textView4.setText(String.format("%sx%s", new Object[]{Integer.valueOf(coverImage.getWidth()), Integer.valueOf(coverImage.getHeight())}));
                new DownloadImageTask(imageView2).execute(new String[]{coverImage.getUrl()});
                if (nativeAd2.getAdChoicesImage() != null) {
                    new DownloadImageTask(imageView3).execute(new String[]{nativeAd2.getAdChoicesImage().getUrl()});
                    if (nativeAd2.getAdChoicesUrl() != null) {
                        imageView3.setOnClickListener(new C14851());
                    }
                }
                linearLayout.addView(relativeLayout);
            }
        });
    }

    private void showAd(RadioGroup adType, NetworkStatus status) {
        CreativeType creativeType;
        final AdUnit adUnit = getAdUnit(((TextView) findViewById(adType.getCheckedRadioButtonId())).getText().toString());
        Builder builder = DisplayOptions.builder(adUnit);
        CreativeType[] creativeTypeArr = new CreativeType[1];
        if (adUnit == AdUnit.INTERSTITIAL) {
            creativeType = CreativeType.STATIC;
        } else {
            creativeType = (CreativeType) adUnit.creativeTypes().iterator().next();
        }
        creativeTypeArr[0] = creativeType;
        DisplayOptions displayOptions = builder.setCreativeTypes(LargeSet.of(creativeTypeArr)).build();
        NetworkAdapter networkAdapter = status.getNetworkAdapter();
        MediationRequest mediationRequest = new MediationRequest(adUnit, Constants.DEFAULT_TAG, (Activity) this);
        MediationResult mediationResult = new MediationResult();
        mediationResult.id = "testmediationid-000000000000000000000";
        final AdDisplay display = networkAdapter.show(mediationRequest, mediationResult, displayOptions);
        display.displayEventStream.addListener(new EventListener<DisplayResult>() {
            public void onEvent(DisplayResult event) {
                if (!event.success) {
                    Toast.makeText(MediationTestActivity.this, event.errorMessage, 1).show();
                }
            }
        }, this.uiThreadExecutorService);
        display.clickEventStream.addListener(new EventListener<Boolean>() {
            public void onEvent(Boolean event) {
                Toast.makeText(MediationTestActivity.this, "Click Received", 0).show();
            }
        }, this.uiThreadExecutorService);
        display.closeListener.addListener(new Runnable() {
            public void run() {
                Toast.makeText(MediationTestActivity.this, "Close Received", 0).show();
            }
        }, this.uiThreadExecutorService);
        display.incentiveListener.addListener(new Runnable() {
            public void run() {
                Exception e;
                Boolean result = null;
                try {
                    result = (Boolean) display.incentiveListener.get();
                } catch (InterruptedException e2) {
                    e = e2;
                    Logger.error("Incentive Listener", e);
                    if (adUnit != AdUnit.INCENTIVIZED) {
                        Toast.makeText(MediationTestActivity.this, String.format("Incentive Result Received: %s", new Object[]{result}), 0).show();
                    }
                } catch (ExecutionException e3) {
                    e = e3;
                    Logger.error("Incentive Listener", e);
                    if (adUnit != AdUnit.INCENTIVIZED) {
                        Toast.makeText(MediationTestActivity.this, String.format("Incentive Result Received: %s", new Object[]{result}), 0).show();
                    }
                }
                if (adUnit != AdUnit.INCENTIVIZED) {
                    Toast.makeText(MediationTestActivity.this, String.format("Incentive Result Received: %s", new Object[]{result}), 0).show();
                }
            }
        }, this.uiThreadExecutorService);
    }

    private void fetchAd(RadioGroup adType, final NetworkStatus status) {
        final AdUnit adUnit = getAdUnit(((TextView) findViewById(adType.getCheckedRadioButtonId())).getText().toString());
        if (adUnit != AdUnit.BANNER && status != null && status.getFetchRequestStore() != null) {
            CreativeType creativeType = (CreativeType) adUnit.creativeTypes().iterator().next();
            if (adUnit == AdUnit.INTERSTITIAL) {
                if (status.getNetworkAdapter().getAdUnitsForCreativeType(CreativeType.STATIC).isEmpty()) {
                    creativeType = CreativeType.VIDEO;
                } else {
                    creativeType = CreativeType.STATIC;
                }
            }
            status.getFetchRequestStore().add(adUnit);
            FetchOptions fetchOptions = FetchOptions.builder(status.getNetworkAdapter().getCanonicalName(), creativeType, status.getNetworkAdapter().getCanonicalName().endsWith("cross_promo") ? AuctionType.CROSS_PROMO : AuctionType.MONETIZATION).setAdUnit(LargeSet.of(adUnit)).build();
            SettableFuture<FetchResult> started = SettableFuture.create();
            if (status.getNetworkAdapter().isReadyForFetch(fetchOptions)) {
                started.set(new FetchResult());
            } else {
                started = status.getNetworkAdapter().start(fetchOptions);
            }
            final CreativeType finalCreativeType = creativeType;
            started.addListener(new Runnable() {

                class C14882 implements Runnable {
                    C14882() {
                    }

                    public void run() {
                        Toast.makeText(MediationTestActivity.this, "Fetching (may take up to 60 seconds)", 0).show();
                    }
                }

                public void run() {
                    final SettableFuture<FetchResult> fetchResultFuture = status.getNetworkAdapter().awaitAvailability(DisplayOptions.builder(adUnit).setCreativeTypes(LargeSet.of(finalCreativeType)).build());
                    if (fetchResultFuture.isDone()) {
                        FetchResult f = (FetchResult) FutureUtils.getImmediatelyOrDefault(fetchResultFuture, FetchResult.INTERNAL);
                        final String toastMessage = f.success ? "Ad Available" : f.getFetchFailure().getMessage();
                        MediationTestActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                Toast.makeText(MediationTestActivity.this, toastMessage, 0).show();
                            }
                        });
                        return;
                    }
                    MediationTestActivity.this.runOnUiThread(new C14882());
                    fetchResultFuture.addListener(new Runnable() {
                        public void run() {
                            FetchResult f = (FetchResult) FutureUtils.getImmediatelyOrDefault(fetchResultFuture, FetchResult.INTERNAL);
                            final String toastMessage = f.success ? "Ad available" : f.getFetchFailure().getMessage();
                            MediationTestActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    Toast.makeText(MediationTestActivity.this, toastMessage, 0).show();
                                }
                            });
                        }
                    }, MediationTestActivity.this.uiThreadExecutorService);
                }
            }, this.uiThreadExecutorService);
        }
    }

    private void destroyBanner() {
        if (this.lastBanner != null) {
            ViewManager bannerParent = (ViewManager) this.lastBanner.getParent();
            this.lastBanner.destroy();
            if (bannerParent != null) {
                bannerParent.removeView(this.lastBanner);
            }
            this.lastBanner = null;
        }
    }

    private void loadBanner(NetworkStatus status) {
        BannerAdView banner = new BannerAdView(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, Utils.dpToPx(this, 50));
        layoutParams.gravity = 80;
        addContentView(banner, layoutParams);
        banner.load(null, status.getNetworkAdapter().getCanonicalName());
        banner.setBannerListener(new BannerListener() {
            public void onAdError(BannerAdView bannerView, BannerError error) {
                Toast.makeText(MediationTestActivity.this, error.getErrorMessage(), 0).show();
            }

            public void onAdLoaded(BannerAdView bannerView) {
            }

            public void onAdClicked(BannerAdView bannerView) {
                Toast.makeText(MediationTestActivity.this, "Click Received", 0).show();
            }
        });
        this.lastBanner = banner;
    }

    private AdUnit getAdUnit(String name) {
        AdUnit adUnit = AdUnit.INTERSTITIAL;
        Object obj = -1;
        switch (name.hashCode()) {
            case 82650203:
                if (name.equals("Video")) {
                    obj = 1;
                    break;
                }
                break;
            case 95784425:
                if (name.equals("Rewarded Video")) {
                    obj = null;
                    break;
                }
                break;
            case 1982491468:
                if (name.equals("Banner")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return AdUnit.INCENTIVIZED;
            case 1:
                return AdUnit.VIDEO;
            case 2:
                return AdUnit.BANNER;
            default:
                return adUnit;
        }
    }

    public void onBackPressed() {
        if (!HeyzapAds.onBackPressed()) {
            if (this.inSecondView) {
                assembleUI();
            } else {
                super.onBackPressed();
            }
        }
    }
}
