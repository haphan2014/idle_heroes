package com.heyzap.common.video.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.CountDownTimer;
import android.support.v4.view.ViewCompat;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heyzap.common.video.VideoModelInterface;
import com.heyzap.internal.AnnulurSegment;
import com.heyzap.internal.CustomRoundedRectangle;
import com.heyzap.internal.Utils;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class VideoControlView extends FrameLayout implements OnClickListener {
    private RelativeLayout ctaButton;
    private TextView ctaButtonTextView;
    private RelativeLayout hideButton;
    public OnActionListener listener;
    public View scrubBar;
    private SimpleDateFormat secondFormatter;
    private RelativeLayout skipButton;
    private TextView skipButtonTextView;
    public TextView timeTextView;

    public interface OnActionListener {
        void onClick();

        void onHide();

        void onSkip();
    }

    class C13012 implements OnClickListener {
        C13012() {
        }

        public void onClick(View v) {
            if (VideoControlView.this.listener != null) {
                VideoControlView.this.listener.onHide();
            }
        }
    }

    class C13023 implements OnClickListener {
        C13023() {
        }

        public void onClick(View v) {
            if (VideoControlView.this.listener != null) {
                VideoControlView.this.listener.onSkip();
            }
        }
    }

    private VideoControlView(Context context) {
        super(context);
    }

    public VideoControlView(Context context, VideoModelInterface model) {
        super(context);
        setBackgroundColor(0);
        addScrubBar(Boolean.valueOf(model.getVideoDisplayOptions().allowAdTimer));
        if (model.getVideoDisplayOptions().allowClick) {
            setOnClickListener(this);
        }
    }

    public void updateScrubber(int remainingTime, float percentComplete) {
        final DisplayMetrics display = getContext().getResources().getDisplayMetrics();
        if (this.secondFormatter == null) {
            this.secondFormatter = new SimpleDateFormat("s", Locale.US);
        }
        SpannableString spanString = new SpannableString(this.secondFormatter.format(Integer.valueOf(remainingTime + 1)));
        spanString.setSpan(new StyleSpan(1), 0, spanString.length(), 0);
        final SpannableString remainingTextSpan = spanString;
        final Activity activity = (Activity) getContext();
        final float f = percentComplete;
        activity.runOnUiThread(new Runnable() {
            public void run() {
                if (remainingTextSpan != null) {
                    VideoControlView.this.timeTextView.setText(remainingTextSpan);
                }
                VideoControlView.this.timeTextView.setBackgroundDrawable(VideoControlView.getArc(f, activity));
                VideoControlView.this.timeTextView.setWidth(VideoControlView.this.timeTextView.getHeight());
                LayoutParams lp = VideoControlView.this.scrubBar.getLayoutParams();
                lp.width = (int) (f * ((float) display.widthPixels));
                VideoControlView.this.scrubBar.setLayoutParams(lp);
            }
        });
    }

    private static ShapeDrawable getArc(float percentComplete, Context context) {
        return new ShapeDrawable(new AnnulurSegment(-3355444, (float) Utils.dpToPx(context, 3), percentComplete));
    }

    public void addHideButton() {
        OnClickListener ocl = new C13012();
        this.hideButton = new RelativeLayout(getContext());
        this.hideButton.setBackgroundColor(0);
        this.hideButton.setOnClickListener(ocl);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(17301560);
        imageView.setPadding(0, Utils.dpToPx(getContext(), 10), Utils.dpToPx(getContext(), 10), 0);
        RelativeLayout.LayoutParams imageLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        imageLayoutParams.addRule(11);
        this.hideButton.addView(imageView, imageLayoutParams);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(Utils.dpToPx(getContext(), 100), Utils.dpToPx(getContext(), 100));
        lp.gravity = 53;
        addView(this.hideButton, lp);
    }

    public void addSkipButton(Boolean withDelay, long delayMillisTillActive, String formattedSkipLaterText, String skipNowText) {
        OnClickListener ocl = new C13023();
        this.skipButton = new RelativeLayout(getContext());
        this.skipButton.setBackgroundColor(0);
        this.skipButton.setOnClickListener(ocl);
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(0, Utils.dpToPx(getContext(), 9), Utils.dpToPx(getContext(), 9), 0);
        this.skipButtonTextView = new TextView(getContext());
        this.skipButtonTextView.setTextSize(20.0f);
        this.skipButtonTextView.setTextColor(-1);
        this.skipButtonTextView.setGravity(17);
        this.skipButtonTextView.setShadowLayer(0.01f, -2.0f, 2.0f, -7829368);
        int rightPadding = 0;
        if (Utils.getSdkVersion() < 11) {
            rightPadding = Utils.dpToPx(getContext(), 7);
        }
        this.skipButtonTextView.setPadding(Utils.dpToPx(getContext(), 7), Utils.dpToPx(getContext(), -2), rightPadding, 0);
        linearLayout.addView(this.skipButtonTextView, new LinearLayout.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(17301538);
        if (Utils.getSdkVersion() < 11) {
            imageView.setPadding(0, 0, rightPadding, 0);
        }
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(-2, -2));
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.skipButton.addView(linearLayout, layoutParams);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(Utils.dpToPx(getContext(), 200), Utils.dpToPx(getContext(), 150));
        lp.gravity = 5;
        addView(this.skipButton, lp);
        if (withDelay.booleanValue()) {
            this.skipButton.setEnabled(false);
            final String str = formattedSkipLaterText;
            final String str2 = skipNowText;
            new CountDownTimer(delayMillisTillActive, 100) {
                public void onTick(long millisUntilFinished) {
                    SpannableString spanString = new SpannableString(str.replace("%i", String.valueOf((int) Math.ceil(((double) millisUntilFinished) / 1000.0d))));
                    spanString.setSpan(new StyleSpan(1), 0, spanString.length(), 0);
                    VideoControlView.this.skipButtonTextView.setText(spanString);
                }

                public void onFinish() {
                    VideoControlView.this.skipButton.setEnabled(true);
                    SpannableString spanString = new SpannableString(str2);
                    spanString.setSpan(new StyleSpan(1), 0, spanString.length(), 0);
                    VideoControlView.this.skipButtonTextView.setText(spanString);
                    VideoControlView.this.skipButtonTextView.setTextColor(-1);
                }
            }.start();
            return;
        }
        this.skipButton.setVisibility(0);
        SpannableString spanString = new SpannableString(skipNowText);
        spanString.setSpan(new StyleSpan(1), 0, spanString.length(), 0);
        this.skipButtonTextView.setText(spanString);
    }

    public void addCtaButton(String cta) {
        this.ctaButton = new RelativeLayout(getContext());
        this.ctaButton.setBackgroundColor(0);
        this.ctaButton.setOnClickListener(this);
        LinearLayout visibleArea = new LinearLayout(getContext());
        visibleArea.setOrientation(0);
        visibleArea.setGravity(16);
        int padding = Utils.dpToPx(getContext(), 10);
        visibleArea.setPadding(padding, padding, padding, 0);
        this.ctaButtonTextView = new TextView(getContext());
        this.ctaButtonTextView.setTextSize(20.0f);
        this.ctaButtonTextView.setTextColor(-1);
        this.ctaButtonTextView.setGravity(17);
        this.ctaButtonTextView.setShadowLayer(0.01f, -2.0f, 2.0f, -7829368);
        this.ctaButtonTextView.setBackgroundDrawable(getButtonBackground(getContext()));
        int sidePadding = Utils.dpToPx(getContext(), 7);
        int topBottomPadding = Utils.dpToPx(getContext(), 3);
        this.ctaButtonTextView.setPadding(sidePadding, topBottomPadding, sidePadding, topBottomPadding);
        visibleArea.addView(this.ctaButtonTextView, new LinearLayout.LayoutParams(-2, -2));
        RelativeLayout.LayoutParams visibleLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        visibleLayoutParams.addRule(9);
        this.ctaButton.addView(visibleArea, visibleLayoutParams);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(Utils.dpToPx(getContext(), 200), Utils.dpToPx(getContext(), 150));
        lp.gravity = 3;
        addView(this.ctaButton, lp);
        this.ctaButtonTextView.setText(cta);
    }

    private static ShapeDrawable getButtonBackground(Context context) {
        return new CustomRoundedRectangle(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null), ViewCompat.MEASURED_STATE_MASK, -1, Utils.dpToPx(context, 2), 110);
    }

    public void addScrubBar(Boolean visible) {
        this.scrubBar = new RelativeLayout(getContext());
        this.scrubBar.setBackgroundColor(ViewCompat.MEASURED_SIZE_MASK);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(0, Utils.dpToPx(getContext(), 4));
        lp.gravity = 83;
        addView(this.scrubBar, lp);
        this.timeTextView = new TextView(getContext());
        this.timeTextView.setTextColor(-1);
        this.timeTextView.setGravity(17);
        if (!Utils.isTablet(getContext())) {
            this.timeTextView.setPadding(15, 15, 15, 20);
        }
        this.timeTextView.setTextSize(20.0f);
        this.timeTextView.setShadowLayer(0.01f, -2.0f, 2.0f, -7829368);
        FrameLayout.LayoutParams ttlp = new FrameLayout.LayoutParams(-2, -2);
        ttlp.gravity = 83;
        ttlp.leftMargin = Utils.dpToPx(getContext(), 12);
        ttlp.bottomMargin = Utils.dpToPx(getContext(), 5);
        if (!visible.booleanValue()) {
            this.timeTextView.setVisibility(8);
        }
        addView(this.timeTextView, ttlp);
    }

    public void onClick(View view) {
        if (this.listener != null) {
            this.listener.onClick();
        }
    }

    public void setOnActionListener(OnActionListener listener) {
        this.listener = listener;
    }
}
