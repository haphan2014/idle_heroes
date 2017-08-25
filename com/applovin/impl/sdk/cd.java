package com.applovin.impl.sdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class cd {
    public static final cf f536A = m490a("ad_preload_enabled", Boolean.valueOf(true));
    public static final cf f537B = m490a("ad_resource_caching_enabled", Boolean.valueOf(true));
    public static final cf f538C = m490a("fail_ad_load_on_failed_video_cache", Boolean.valueOf(true));
    public static final cf f539D = m490a("resource_cache_prefix", "https://vid.applovin.com/,https://pdn.applovin.com/,https://img.applovin.com/,https://d.applovin.com/,https://assets.applovin.com/,https://cdnjs.cloudflare.com/,http://vid.applovin.com/,http://pdn.applovin.com/,http://img.applovin.com/,http://d.applovin.com/,http://assets.applovin.com/,http://cdnjs.cloudflare.com/");
    public static final cf f540E = m490a("ad_auto_preload_sizes", "BANNER,INTER");
    public static final cf f541F = m490a("ad_auto_preload_incent", Boolean.valueOf(true));
    public static final cf f542G = m490a("is_tracking_enabled", Boolean.valueOf(true));
    public static final cf f543H = m490a("force_back_button_enabled_always", Boolean.valueOf(false));
    public static final cf f544I = m490a("countdown_color", "#C8FFFFFF");
    public static final cf f545J = m490a("close_fade_in_time", Integer.valueOf(400));
    public static final cf f546K = m490a("show_close_on_exit", Boolean.valueOf(true));
    public static final cf f547L = m490a("text_incent_prompt_title", "Earn a Reward");
    public static final cf f548M = m490a("text_incent_prompt_body", "Would you like to watch a video for a reward?");
    public static final cf f549N = m490a("text_incent_prompt_yes_option", "Watch Now");
    public static final cf f550O = m490a("text_incent_prompt_no_option", "No Thanks");
    public static final cf f551P = m490a("text_incent_completion_title", "Video Reward");
    public static final cf f552Q = m490a("text_incent_completion_body_success", "You have earned a reward!");
    public static final cf f553R = m490a("text_incent_completion_body_quota_exceeded", "You have already earned the maximum reward for today.");
    public static final cf f554S = m490a("text_incent_completion_body_reward_rejected", "Your reward was rejected.");
    public static final cf f555T = m490a("text_incent_completion_body_network_failure", "We were unable to contact the rewards server. Please try again later.");
    public static final cf f556U = m490a("text_incent_completion_close_option", "Okay");
    public static final cf f557V = m490a("incent_warning_enabled", Boolean.valueOf(false));
    public static final cf f558W = m490a("text_incent_warning_title", "Attention!");
    public static final cf f559X = m490a("text_incent_warning_body", "You won’t get your reward if the video hasn’t finished.");
    public static final cf f560Y = m490a("text_incent_warning_close_option", "Close");
    public static final cf f561Z = m490a("text_incent_warning_continue_option", "Keep Watching");
    public static final cf f562a = m490a("is_disabled", Boolean.valueOf(false));
    public static final cf aA = m490a("widget_imp_tracking_delay", Integer.valueOf(2000));
    public static final cf aB = m490a("draw_countdown_clock", Boolean.valueOf(true));
    public static final cf aC = m490a("countdown_clock_size", Integer.valueOf(32));
    public static final cf aD = m490a("countdown_clock_stroke_size", Integer.valueOf(4));
    public static final cf aE = m490a("countdown_clock_text_size", Integer.valueOf(28));
    public static final cf aF = m490a("ad_auto_preload_native", Boolean.valueOf(true));
    public static final cf aG = m490a("widget_fail_on_slot_count_diff", Boolean.valueOf(true));
    public static final cf aH = m490a("video_zero_length_as_computed", Boolean.valueOf(false));
    public static final cf aI = m490a("video_countdown_clock_margin", Integer.valueOf(10));
    public static final cf aJ = m490a("video_countdown_clock_gravity", Integer.valueOf(83));
    public static final cf aK = m490a("preload_capacity_widget", Integer.valueOf(1));
    public static final cf aL = m490a("widget_latch_timeout_ms", Integer.valueOf(500));
    public static final cf aM = m490a("android_gc_on_widget_detach", Boolean.valueOf(true));
    public static final cf aN = m490a("lhs_close_button_video", Boolean.valueOf(false));
    public static final cf aO = m490a("lhs_close_button_graphic", Boolean.valueOf(false));
    public static final cf aP = m490a("lhs_skip_button", Boolean.valueOf(true));
    public static final cf aQ = m490a("countdown_toggleable", Boolean.valueOf(false));
    public static final cf aR = m490a("native_batch_precache_count", Integer.valueOf(1));
    public static final cf aS = m490a("mute_controls_enabled", Boolean.valueOf(false));
    public static final cf aT = m490a("allow_user_muting", Boolean.valueOf(true));
    public static final cf aU = m490a("mute_button_size", Integer.valueOf(32));
    public static final cf aV = m490a("mute_button_margin", Integer.valueOf(10));
    public static final cf aW = m490a("mute_button_gravity", Integer.valueOf(85));
    public static final cf aX = m490a("qq", Boolean.valueOf(false));
    public static final cf aY = m490a("hw_accelerate_webviews", Boolean.valueOf(false));
    public static final cf aZ = m490a("mute_videos", Boolean.valueOf(false));
    public static final cf aa = m490a("show_incent_prepopup", Boolean.valueOf(true));
    public static final cf ab = m490a("show_incent_postpopup", Boolean.valueOf(true));
    public static final cf ac = m490a("preload_capacity_banner", Integer.valueOf(1));
    public static final cf ad = m490a("preload_capacity_mrec", Integer.valueOf(1));
    public static final cf ae = m490a("preload_capacity_inter", Integer.valueOf(1));
    public static final cf af = m490a("preload_capacity_leader", Integer.valueOf(1));
    public static final cf ag = m490a("preload_capacity_incent", Integer.valueOf(2));
    public static final cf ah = m490a("dismiss_video_on_error", Boolean.valueOf(true));
    public static final cf ai = m490a("precache_delimiters", ")]',");
    public static final cf aj = m490a("close_button_size_graphic", Integer.valueOf(27));
    public static final cf ak = m490a("close_button_size_video", Integer.valueOf(30));
    public static final cf al = m490a("close_button_top_margin_graphic", Integer.valueOf(10));
    public static final cf am = m490a("close_button_right_margin_graphic", Integer.valueOf(10));
    public static final cf an = m490a("close_button_top_margin_video", Integer.valueOf(8));
    public static final cf ao = m490a("close_button_right_margin_video", Integer.valueOf(4));
    public static final cf ap = m490a("force_back_button_enabled_poststitial", Boolean.valueOf(false));
    public static final cf aq = m490a("force_back_button_enabled_close_button", Boolean.valueOf(false));
    public static final cf ar = m490a("close_button_touch_area", Integer.valueOf(0));
    public static final cf as = m490a("is_video_skippable", Boolean.valueOf(false));
    public static final cf at = m490a("cache_cleanup_enabled", Boolean.valueOf(false));
    public static final cf au = m490a("cache_file_ttl_seconds", Long.valueOf(86400));
    public static final cf av = m490a("cache_max_size_mb", Integer.valueOf(-1));
    public static final cf aw = m490a("preload_merge_init_tasks_incent", Boolean.valueOf(true));
    public static final cf ax = m490a("preload_merge_init_tasks_inter", Boolean.valueOf(true));
    public static final cf ay = m490a("submit_postback_timeout", Integer.valueOf(10000));
    public static final cf az = m490a("submit_postback_retries", Integer.valueOf(10));
    public static final cf f563b = m490a("honor_publisher_settings", Boolean.valueOf(true));
    public static final cf bA = m490a("lock_specific_orientation", Boolean.valueOf(false));
    public static final cf bB = m490a("video_callbacks_for_incent_nonvideo_ads_enabled", Boolean.valueOf(true));
    public static final cf bC = m490a("user_agent_collection_enabled", Boolean.valueOf(false));
    public static final cf bD = m490a("user_agent_collection_timeout_ms", Long.valueOf(600));
    private static final List bE = Arrays.asList(new Class[]{Boolean.class, Float.class, Integer.class, Long.class, String.class});
    private static final List bF = new ArrayList();
    public static final cf ba = m490a("show_mute_by_default", Boolean.valueOf(false));
    public static final cf bb = m490a("mute_with_user_settings", Boolean.valueOf(true));
    public static final cf bc = m490a("event_tracking_endpoint", "http://rt.applovin.com/pix");
    public static final cf bd = m490a("top_level_events", "landing,checkout,iap");
    public static final cf be = m490a("events_enabled", Boolean.valueOf(true));
    public static final cf bf = m490a("force_ssl", Boolean.valueOf(false));
    public static final cf bg = m490a("postback_service_max_queue_size", Integer.valueOf(100));
    public static final cf bh = m490a("max_postback_attempts", Integer.valueOf(3));
    public static final cf bi = m490a("click_overlay_enabled", Boolean.valueOf(false));
    public static final cf bj = m490a("click_overlay_color", "#66000000");
    public static final cf bk = m490a("click_tracking_retry_count", Integer.valueOf(3));
    public static final cf bl = m490a("click_tracking_retry_delay", Integer.valueOf(2000));
    public static final cf bm = m490a("click_tracking_timeout", Integer.valueOf(10000));
    public static final cf bn = m490a("android_click_spinner_size", Integer.valueOf(50));
    public static final cf bo = m490a("android_click_spinner_style", Integer.valueOf(16973853));
    public static final cf bp = m490a("android_dismiss_inters_on_click", Boolean.valueOf(false));
    public static final cf bq = m490a("android_require_external_storage_permission", Boolean.valueOf(true));
    public static final cf br = m490a("android_drop_nomedia", Boolean.valueOf(true));
    public static final cf bs = m490a("native_auto_cache_preload_resources", Boolean.valueOf(true));
    public static final cf bt = m490a("video_immersive_mode_enabled", Boolean.valueOf(false));
    public static final cf bu = m490a("sanitize_webview", Boolean.valueOf(false));
    public static final cf bv = m490a("webview_package_name", "com.google.android.webview");
    public static final cf bw = m490a("adr", Boolean.valueOf(false));
    public static final cf bx = m490a("hgn", Boolean.valueOf(false));
    public static final cf by = m490a("inter_display_delay", Long.valueOf(200));
    public static final cf bz = m490a("volume_normalization_factor", Float.valueOf(6.6666665f));
    public static final cf f564c = m490a("device_id", "");
    public static final cf f565d = m490a("publisher_id", "");
    public static final cf f566e = m490a("device_token", "");
    public static final cf f567f = m490a("submit_data_retry_count", Integer.valueOf(1));
    public static final cf f568g = m490a("vr_retry_count", Integer.valueOf(1));
    public static final cf f569h = m490a("fetch_ad_retry_count", Integer.valueOf(1));
    public static final cf f570i = m490a("is_verbose_logging", Boolean.valueOf(false));
    public static final cf f571j = m490a("api_endpoint", "http://d.applovin.com/");
    public static final cf f572k = m490a("adserver_endpoint", "http://a.applovin.com/");
    public static final cf f573l = m490a("get_retry_delay", Long.valueOf(10000));
    public static final cf f574m = m490a("hash_algorithm", "SHA-1");
    public static final cf f575n = m490a("short_hash_size", Integer.valueOf(16));
    public static final cf f576o = m490a("http_connection_timeout", Integer.valueOf(30000));
    public static final cf f577p = m490a("fetch_ad_connection_timeout", Integer.valueOf(30000));
    public static final cf f578q = m490a("http_socket_timeout", Integer.valueOf(20000));
    public static final cf f579r = m490a("ad_session_minutes", Integer.valueOf(60));
    public static final cf f580s = m490a("ad_request_parameters", "");
    public static final cf f581t = m490a("ad_refresh_enabled", Boolean.valueOf(true));
    public static final cf f582u = m490a("ad_refresh_seconds", Long.valueOf(120));
    public static final cf f583v = m490a("mrec_ad_refresh_enabled", Boolean.valueOf(true));
    public static final cf f584w = m490a("mrec_ad_refresh_seconds", Long.valueOf(120));
    public static final cf f585x = m490a("leader_ad_refresh_enabled", Boolean.valueOf(true));
    public static final cf f586y = m490a("leader_ad_refresh_seconds", Long.valueOf(120));
    public static final cf f587z = m490a("plugin_version", "");

    private static cf m490a(String str, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("No default value specified");
        } else if (bE.contains(obj.getClass())) {
            cf cfVar = new cf(str, obj);
            bF.add(cfVar);
            return cfVar;
        } else {
            throw new IllegalArgumentException("Unsupported value type: " + obj.getClass());
        }
    }

    public static Collection m491a() {
        return Collections.unmodifiableList(bF);
    }

    public static int m492b() {
        return bF.size();
    }
}
