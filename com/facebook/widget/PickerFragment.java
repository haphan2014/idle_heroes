package com.facebook.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;
import com.facebook.android.C0271R;
import com.facebook.internal.SessionTracker;
import com.facebook.model.GraphObject;
import com.facebook.widget.GraphObjectAdapter.SectionAndItem;
import com.facebook.widget.GraphObjectAdapter.SectionAndItem.Type;
import com.google.android.gms.cast.TextTrackStyle;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class PickerFragment<T extends GraphObject> extends Fragment {
    private static final String ACTIVITY_CIRCLE_SHOW_KEY = "com.facebook.android.PickerFragment.ActivityCircleShown";
    public static final String DONE_BUTTON_TEXT_BUNDLE_KEY = "com.facebook.widget.PickerFragment.DoneButtonText";
    public static final String EXTRA_FIELDS_BUNDLE_KEY = "com.facebook.widget.PickerFragment.ExtraFields";
    private static final int PROFILE_PICTURE_PREFETCH_BUFFER = 5;
    private static final String SELECTION_BUNDLE_KEY = "com.facebook.android.PickerFragment.Selection";
    public static final String SHOW_PICTURES_BUNDLE_KEY = "com.facebook.widget.PickerFragment.ShowPictures";
    public static final String SHOW_TITLE_BAR_BUNDLE_KEY = "com.facebook.widget.PickerFragment.ShowTitleBar";
    public static final String TITLE_TEXT_BUNDLE_KEY = "com.facebook.widget.PickerFragment.TitleText";
    private ProgressBar activityCircle;
    GraphObjectAdapter<T> adapter;
    private boolean appEventsLogged;
    private Button doneButton;
    private Drawable doneButtonBackground;
    private String doneButtonText;
    HashSet<String> extraFields = new HashSet();
    private GraphObjectFilter<T> filter;
    private final Class<T> graphObjectClass;
    private final int layout;
    private ListView listView;
    private LoadingStrategy loadingStrategy;
    private OnDataChangedListener onDataChangedListener;
    private OnDoneButtonClickedListener onDoneButtonClickedListener;
    private OnErrorListener onErrorListener;
    private OnScrollListener onScrollListener = new C03296();
    private OnSelectionChangedListener onSelectionChangedListener;
    private Set<String> selectionHint;
    private SelectionStrategy selectionStrategy;
    private SessionTracker sessionTracker;
    private boolean showPictures = true;
    private boolean showTitleBar = true;
    private Drawable titleBarBackground;
    private String titleText;
    private TextView titleTextView;

    abstract class PickerFragmentAdapter<U extends GraphObject> extends GraphObjectAdapter<T> {
        public PickerFragmentAdapter(Context context) {
            super(context);
        }

        boolean isGraphObjectSelected(String graphObjectId) {
            return PickerFragment.this.selectionStrategy.isSelected(graphObjectId);
        }

        void updateCheckboxState(CheckBox checkBox, boolean graphObjectSelected) {
            checkBox.setChecked(graphObjectSelected);
            int visible = (graphObjectSelected || PickerFragment.this.selectionStrategy.shouldShowCheckBoxIfUnselected()) ? 0 : 8;
            checkBox.setVisibility(visible);
        }
    }

    abstract class LoadingStrategy {
        protected static final int CACHED_RESULT_REFRESH_DELAY = 2000;
        protected GraphObjectAdapter<T> adapter;
        protected GraphObjectPagingLoader<T> loader;

        class C03301 implements LoaderCallbacks<SimpleGraphObjectCursor<T>> {
            C03301() {
            }

            public Loader<SimpleGraphObjectCursor<T>> onCreateLoader(int id, Bundle args) {
                return LoadingStrategy.this.onCreateLoader();
            }

            public void onLoadFinished(Loader<SimpleGraphObjectCursor<T>> loader, SimpleGraphObjectCursor<T> data) {
                if (loader != LoadingStrategy.this.loader) {
                    throw new FacebookException("Received callback for unknown loader.");
                }
                LoadingStrategy.this.onLoadFinished((GraphObjectPagingLoader) loader, data);
            }

            public void onLoaderReset(Loader<SimpleGraphObjectCursor<T>> loader) {
                if (loader != LoadingStrategy.this.loader) {
                    throw new FacebookException("Received callback for unknown loader.");
                }
                LoadingStrategy.this.onLoadReset((GraphObjectPagingLoader) loader);
            }
        }

        class C03312 implements com.facebook.widget.GraphObjectPagingLoader.OnErrorListener {
            C03312() {
            }

            public void onError(FacebookException error, GraphObjectPagingLoader<?> graphObjectPagingLoader) {
                PickerFragment.this.hideActivityCircle();
                if (PickerFragment.this.onErrorListener != null) {
                    PickerFragment.this.onErrorListener.onError(PickerFragment.this, error);
                }
            }
        }

        class C03323 implements com.facebook.widget.GraphObjectAdapter.OnErrorListener {
            C03323() {
            }

            public void onError(GraphObjectAdapter<?> graphObjectAdapter, FacebookException error) {
                if (PickerFragment.this.onErrorListener != null) {
                    PickerFragment.this.onErrorListener.onError(PickerFragment.this, error);
                }
            }
        }

        LoadingStrategy() {
        }

        public void attach(GraphObjectAdapter<T> adapter) {
            this.loader = (GraphObjectPagingLoader) PickerFragment.this.getLoaderManager().initLoader(0, null, new C03301());
            this.loader.setOnErrorListener(new C03312());
            this.adapter = adapter;
            this.adapter.changeCursor(this.loader.getCursor());
            this.adapter.setOnErrorListener(new C03323());
        }

        public void detach() {
            this.adapter.setDataNeededListener(null);
            this.adapter.setOnErrorListener(null);
            this.loader.setOnErrorListener(null);
            this.loader = null;
            this.adapter = null;
        }

        public void clearResults() {
            if (this.loader != null) {
                this.loader.clearResults();
            }
        }

        public void startLoading(Request request) {
            if (this.loader != null) {
                this.loader.startLoading(request, canSkipRoundTripIfCached());
                onStartLoading(this.loader, request);
            }
        }

        public boolean isDataPresentOrLoading() {
            return !this.adapter.isEmpty() || this.loader.isLoading();
        }

        protected GraphObjectPagingLoader<T> onCreateLoader() {
            return new GraphObjectPagingLoader(PickerFragment.this.getActivity(), PickerFragment.this.graphObjectClass);
        }

        protected void onStartLoading(GraphObjectPagingLoader<T> graphObjectPagingLoader, Request request) {
            PickerFragment.this.displayActivityCircle();
        }

        protected void onLoadReset(GraphObjectPagingLoader<T> graphObjectPagingLoader) {
            this.adapter.changeCursor(null);
        }

        protected void onLoadFinished(GraphObjectPagingLoader<T> graphObjectPagingLoader, SimpleGraphObjectCursor<T> data) {
            PickerFragment.this.updateAdapter(data);
        }

        protected boolean canSkipRoundTripIfCached() {
            return true;
        }
    }

    class C03241 implements Filter<T> {
        C03241() {
        }

        public boolean includeItem(T graphObject) {
            return PickerFragment.this.filterIncludesItem(graphObject);
        }
    }

    class C03252 implements OnItemClickListener {
        C03252() {
        }

        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            PickerFragment.this.onListItemClick((ListView) parent, v, position);
        }
    }

    class C03263 implements OnLongClickListener {
        C03263() {
        }

        public boolean onLongClick(View v) {
            return false;
        }
    }

    class C03274 implements StatusCallback {
        C03274() {
        }

        public void call(Session session, SessionState state, Exception exception) {
            if (!session.isOpened()) {
                PickerFragment.this.clearResults();
            }
        }
    }

    class C03285 implements OnClickListener {
        C03285() {
        }

        public void onClick(View v) {
            PickerFragment.this.logAppEvents(true);
            PickerFragment.this.appEventsLogged = true;
            if (PickerFragment.this.onDoneButtonClickedListener != null) {
                PickerFragment.this.onDoneButtonClickedListener.onDoneButtonClicked(PickerFragment.this);
            }
        }
    }

    class C03296 implements OnScrollListener {
        C03296() {
        }

        public void onScrollStateChanged(AbsListView view, int scrollState) {
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            PickerFragment.this.reprioritizeDownloads();
        }
    }

    public interface GraphObjectFilter<T> {
        boolean includeItem(T t);
    }

    abstract class SelectionStrategy {
        abstract void clear();

        abstract Collection<String> getSelectedIds();

        abstract boolean isEmpty();

        abstract boolean isSelected(String str);

        abstract void readSelectionFromBundle(Bundle bundle, String str);

        abstract void saveSelectionToBundle(Bundle bundle, String str);

        abstract boolean shouldShowCheckBoxIfUnselected();

        abstract void toggleSelection(String str);

        SelectionStrategy() {
        }
    }

    class MultiSelectionStrategy extends SelectionStrategy {
        private Set<String> selectedIds = new HashSet();

        MultiSelectionStrategy() {
            super();
        }

        public Collection<String> getSelectedIds() {
            return this.selectedIds;
        }

        boolean isSelected(String id) {
            return id != null && this.selectedIds.contains(id);
        }

        void toggleSelection(String id) {
            if (id == null) {
                return;
            }
            if (this.selectedIds.contains(id)) {
                this.selectedIds.remove(id);
            } else {
                this.selectedIds.add(id);
            }
        }

        void saveSelectionToBundle(Bundle outBundle, String key) {
            if (!this.selectedIds.isEmpty()) {
                outBundle.putString(key, TextUtils.join(",", this.selectedIds));
            }
        }

        void readSelectionFromBundle(Bundle inBundle, String key) {
            if (inBundle != null) {
                String ids = inBundle.getString(key);
                if (ids != null) {
                    String[] splitIds = TextUtils.split(ids, ",");
                    this.selectedIds.clear();
                    Collections.addAll(this.selectedIds, splitIds);
                }
            }
        }

        public void clear() {
            this.selectedIds.clear();
        }

        boolean isEmpty() {
            return this.selectedIds.isEmpty();
        }

        boolean shouldShowCheckBoxIfUnselected() {
            return true;
        }
    }

    public interface OnDataChangedListener {
        void onDataChanged(PickerFragment<?> pickerFragment);
    }

    public interface OnDoneButtonClickedListener {
        void onDoneButtonClicked(PickerFragment<?> pickerFragment);
    }

    public interface OnErrorListener {
        void onError(PickerFragment<?> pickerFragment, FacebookException facebookException);
    }

    public interface OnSelectionChangedListener {
        void onSelectionChanged(PickerFragment<?> pickerFragment);
    }

    class SingleSelectionStrategy extends SelectionStrategy {
        private String selectedId;

        SingleSelectionStrategy() {
            super();
        }

        public Collection<String> getSelectedIds() {
            return Arrays.asList(new String[]{this.selectedId});
        }

        boolean isSelected(String id) {
            return (this.selectedId == null || id == null || !this.selectedId.equals(id)) ? false : true;
        }

        void toggleSelection(String id) {
            if (this.selectedId == null || !this.selectedId.equals(id)) {
                this.selectedId = id;
            } else {
                this.selectedId = null;
            }
        }

        void saveSelectionToBundle(Bundle outBundle, String key) {
            if (!TextUtils.isEmpty(this.selectedId)) {
                outBundle.putString(key, this.selectedId);
            }
        }

        void readSelectionFromBundle(Bundle inBundle, String key) {
            if (inBundle != null) {
                this.selectedId = inBundle.getString(key);
            }
        }

        public void clear() {
            this.selectedId = null;
        }

        boolean isEmpty() {
            return this.selectedId == null;
        }

        boolean shouldShowCheckBoxIfUnselected() {
            return false;
        }
    }

    abstract PickerFragmentAdapter<T> createAdapter();

    abstract LoadingStrategy createLoadingStrategy();

    abstract SelectionStrategy createSelectionStrategy();

    abstract Request getRequestForLoadData(Session session);

    PickerFragment(Class<T> graphObjectClass, int layout, Bundle args) {
        this.graphObjectClass = graphObjectClass;
        this.layout = layout;
        setPickerFragmentSettingsFromBundle(args);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapter = createAdapter();
        this.adapter.setFilter(new C03241());
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        TypedArray a = activity.obtainStyledAttributes(attrs, C0271R.styleable.com_facebook_picker_fragment);
        setShowPictures(a.getBoolean(C0271R.styleable.com_facebook_picker_fragment_show_pictures, this.showPictures));
        String extraFieldsString = a.getString(C0271R.styleable.com_facebook_picker_fragment_extra_fields);
        if (extraFieldsString != null) {
            setExtraFields(Arrays.asList(extraFieldsString.split(",")));
        }
        this.showTitleBar = a.getBoolean(C0271R.styleable.com_facebook_picker_fragment_show_title_bar, this.showTitleBar);
        this.titleText = a.getString(C0271R.styleable.com_facebook_picker_fragment_title_text);
        this.doneButtonText = a.getString(C0271R.styleable.com_facebook_picker_fragment_done_button_text);
        this.titleBarBackground = a.getDrawable(C0271R.styleable.com_facebook_picker_fragment_title_bar_background);
        this.doneButtonBackground = a.getDrawable(C0271R.styleable.com_facebook_picker_fragment_done_button_background);
        a.recycle();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(this.layout, container, false);
        this.listView = (ListView) view.findViewById(C0271R.id.com_facebook_picker_list_view);
        this.listView.setOnItemClickListener(new C03252());
        this.listView.setOnLongClickListener(new C03263());
        this.listView.setOnScrollListener(this.onScrollListener);
        this.activityCircle = (ProgressBar) view.findViewById(C0271R.id.com_facebook_picker_activity_circle);
        setupViews(view);
        this.listView.setAdapter(this.adapter);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.sessionTracker = new SessionTracker(getActivity(), new C03274());
        setSettingsFromBundle(savedInstanceState);
        this.loadingStrategy = createLoadingStrategy();
        this.loadingStrategy.attach(this.adapter);
        this.selectionStrategy = createSelectionStrategy();
        this.selectionStrategy.readSelectionFromBundle(savedInstanceState, SELECTION_BUNDLE_KEY);
        if (this.showTitleBar) {
            inflateTitleBar((ViewGroup) getView());
        }
        if (this.activityCircle != null && savedInstanceState != null) {
            if (savedInstanceState.getBoolean(ACTIVITY_CIRCLE_SHOW_KEY, false)) {
                displayActivityCircle();
            } else {
                hideActivityCircle();
            }
        }
    }

    public void onDetach() {
        super.onDetach();
        this.listView.setOnScrollListener(null);
        this.listView.setAdapter(null);
        this.loadingStrategy.detach();
        this.sessionTracker.stopTracking();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveSettingsToBundle(outState);
        this.selectionStrategy.saveSelectionToBundle(outState, SELECTION_BUNDLE_KEY);
        if (this.activityCircle != null) {
            outState.putBoolean(ACTIVITY_CIRCLE_SHOW_KEY, this.activityCircle.getVisibility() == 0);
        }
    }

    public void onStop() {
        if (!this.appEventsLogged) {
            logAppEvents(false);
        }
        super.onStop();
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
        setSettingsFromBundle(args);
    }

    public OnDataChangedListener getOnDataChangedListener() {
        return this.onDataChangedListener;
    }

    public void setOnDataChangedListener(OnDataChangedListener onDataChangedListener) {
        this.onDataChangedListener = onDataChangedListener;
    }

    public OnSelectionChangedListener getOnSelectionChangedListener() {
        return this.onSelectionChangedListener;
    }

    public void setOnSelectionChangedListener(OnSelectionChangedListener onSelectionChangedListener) {
        this.onSelectionChangedListener = onSelectionChangedListener;
    }

    public OnDoneButtonClickedListener getOnDoneButtonClickedListener() {
        return this.onDoneButtonClickedListener;
    }

    public void setOnDoneButtonClickedListener(OnDoneButtonClickedListener onDoneButtonClickedListener) {
        this.onDoneButtonClickedListener = onDoneButtonClickedListener;
    }

    public OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    public GraphObjectFilter<T> getFilter() {
        return this.filter;
    }

    public void setFilter(GraphObjectFilter<T> filter) {
        this.filter = filter;
    }

    public Session getSession() {
        return this.sessionTracker.getSession();
    }

    public void setSession(Session session) {
        this.sessionTracker.setSession(session);
    }

    public boolean getShowPictures() {
        return this.showPictures;
    }

    public void setShowPictures(boolean showPictures) {
        this.showPictures = showPictures;
    }

    public Set<String> getExtraFields() {
        return new HashSet(this.extraFields);
    }

    public void setExtraFields(Collection<String> fields) {
        this.extraFields = new HashSet();
        if (fields != null) {
            this.extraFields.addAll(fields);
        }
    }

    public void setShowTitleBar(boolean showTitleBar) {
        this.showTitleBar = showTitleBar;
    }

    public boolean getShowTitleBar() {
        return this.showTitleBar;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public String getTitleText() {
        if (this.titleText == null) {
            this.titleText = getDefaultTitleText();
        }
        return this.titleText;
    }

    public void setDoneButtonText(String doneButtonText) {
        this.doneButtonText = doneButtonText;
    }

    public String getDoneButtonText() {
        if (this.doneButtonText == null) {
            this.doneButtonText = getDefaultDoneButtonText();
        }
        return this.doneButtonText;
    }

    public void loadData(boolean forceReload) {
        loadData(forceReload, null);
    }

    public void loadData(boolean forceReload, Set<String> selectIds) {
        if (forceReload || !this.loadingStrategy.isDataPresentOrLoading()) {
            this.selectionHint = selectIds;
            loadDataSkippingRoundTripIfCached();
        }
    }

    public void setSettingsFromBundle(Bundle inState) {
        setPickerFragmentSettingsFromBundle(inState);
    }

    void setupViews(ViewGroup view) {
    }

    boolean filterIncludesItem(T graphObject) {
        if (this.filter != null) {
            return this.filter.includeItem(graphObject);
        }
        return true;
    }

    List<T> getSelectedGraphObjects() {
        return this.adapter.getGraphObjectsById(this.selectionStrategy.getSelectedIds());
    }

    void setSelectedGraphObjects(List<String> objectIds) {
        for (String objectId : objectIds) {
            if (!this.selectionStrategy.isSelected(objectId)) {
                this.selectionStrategy.toggleSelection(objectId);
            }
        }
    }

    void saveSettingsToBundle(Bundle outState) {
        outState.putBoolean(SHOW_PICTURES_BUNDLE_KEY, this.showPictures);
        if (!this.extraFields.isEmpty()) {
            outState.putString(EXTRA_FIELDS_BUNDLE_KEY, TextUtils.join(",", this.extraFields));
        }
        outState.putBoolean(SHOW_TITLE_BAR_BUNDLE_KEY, this.showTitleBar);
        outState.putString(TITLE_TEXT_BUNDLE_KEY, this.titleText);
        outState.putString(DONE_BUTTON_TEXT_BUNDLE_KEY, this.doneButtonText);
    }

    void onLoadingData() {
    }

    String getDefaultTitleText() {
        return null;
    }

    String getDefaultDoneButtonText() {
        return getString(C0271R.string.com_facebook_picker_done_button_text);
    }

    void displayActivityCircle() {
        if (this.activityCircle != null) {
            layoutActivityCircle();
            this.activityCircle.setVisibility(0);
        }
    }

    void layoutActivityCircle() {
        setAlpha(this.activityCircle, !this.adapter.isEmpty() ? 0.25f : TextTrackStyle.DEFAULT_FONT_SCALE);
    }

    void hideActivityCircle() {
        if (this.activityCircle != null) {
            this.activityCircle.clearAnimation();
            this.activityCircle.setVisibility(4);
        }
    }

    void setSelectionStrategy(SelectionStrategy selectionStrategy) {
        if (selectionStrategy != this.selectionStrategy) {
            this.selectionStrategy = selectionStrategy;
            if (this.adapter != null) {
                this.adapter.notifyDataSetChanged();
            }
        }
    }

    void logAppEvents(boolean doneButtonClicked) {
    }

    private static void setAlpha(View view, float alpha) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(alpha, alpha);
        alphaAnimation.setDuration(0);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    private void setPickerFragmentSettingsFromBundle(Bundle inState) {
        if (inState != null) {
            this.showPictures = inState.getBoolean(SHOW_PICTURES_BUNDLE_KEY, this.showPictures);
            String extraFieldsString = inState.getString(EXTRA_FIELDS_BUNDLE_KEY);
            if (extraFieldsString != null) {
                setExtraFields(Arrays.asList(extraFieldsString.split(",")));
            }
            this.showTitleBar = inState.getBoolean(SHOW_TITLE_BAR_BUNDLE_KEY, this.showTitleBar);
            String titleTextString = inState.getString(TITLE_TEXT_BUNDLE_KEY);
            if (titleTextString != null) {
                this.titleText = titleTextString;
                if (this.titleTextView != null) {
                    this.titleTextView.setText(this.titleText);
                }
            }
            String doneButtonTextString = inState.getString(DONE_BUTTON_TEXT_BUNDLE_KEY);
            if (doneButtonTextString != null) {
                this.doneButtonText = doneButtonTextString;
                if (this.doneButton != null) {
                    this.doneButton.setText(this.doneButtonText);
                }
            }
        }
    }

    private void inflateTitleBar(ViewGroup view) {
        ViewStub stub = (ViewStub) view.findViewById(C0271R.id.com_facebook_picker_title_bar_stub);
        if (stub != null) {
            View titleBar = stub.inflate();
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            layoutParams.addRule(3, C0271R.id.com_facebook_picker_title_bar);
            this.listView.setLayoutParams(layoutParams);
            if (this.titleBarBackground != null) {
                titleBar.setBackgroundDrawable(this.titleBarBackground);
            }
            this.doneButton = (Button) view.findViewById(C0271R.id.com_facebook_picker_done_button);
            if (this.doneButton != null) {
                this.doneButton.setOnClickListener(new C03285());
                if (getDoneButtonText() != null) {
                    this.doneButton.setText(getDoneButtonText());
                }
                if (this.doneButtonBackground != null) {
                    this.doneButton.setBackgroundDrawable(this.doneButtonBackground);
                }
            }
            this.titleTextView = (TextView) view.findViewById(C0271R.id.com_facebook_picker_title);
            if (this.titleTextView != null && getTitleText() != null) {
                this.titleTextView.setText(getTitleText());
            }
        }
    }

    private void onListItemClick(ListView listView, View v, int position) {
        this.selectionStrategy.toggleSelection(this.adapter.getIdOfGraphObject((GraphObject) listView.getItemAtPosition(position)));
        this.adapter.notifyDataSetChanged();
        if (this.onSelectionChangedListener != null) {
            this.onSelectionChangedListener.onSelectionChanged(this);
        }
    }

    private void loadDataSkippingRoundTripIfCached() {
        clearResults();
        Request request = getRequestForLoadData(getSession());
        if (request != null) {
            onLoadingData();
            this.loadingStrategy.startLoading(request);
        }
    }

    private void clearResults() {
        if (this.adapter != null) {
            boolean wasData;
            boolean wasSelection = !this.selectionStrategy.isEmpty();
            if (this.adapter.isEmpty()) {
                wasData = false;
            } else {
                wasData = true;
            }
            this.loadingStrategy.clearResults();
            this.selectionStrategy.clear();
            this.adapter.notifyDataSetChanged();
            if (wasData && this.onDataChangedListener != null) {
                this.onDataChangedListener.onDataChanged(this);
            }
            if (wasSelection && this.onSelectionChangedListener != null) {
                this.onSelectionChangedListener.onSelectionChanged(this);
            }
        }
    }

    void updateAdapter(SimpleGraphObjectCursor<T> data) {
        if (this.adapter != null) {
            View view = this.listView.getChildAt(1);
            int anchorPosition = this.listView.getFirstVisiblePosition();
            if (anchorPosition > 0) {
                anchorPosition++;
            }
            SectionAndItem<T> anchorItem = this.adapter.getSectionAndItem(anchorPosition);
            int top = (view == null || anchorItem.getType() == Type.ACTIVITY_CIRCLE) ? 0 : view.getTop();
            boolean dataChanged = this.adapter.changeCursor(data);
            if (!(view == null || anchorItem == null)) {
                int newPositionOfItem = this.adapter.getPosition(anchorItem.sectionKey, anchorItem.graphObject);
                if (newPositionOfItem != -1) {
                    this.listView.setSelectionFromTop(newPositionOfItem, top);
                }
            }
            if (dataChanged && this.onDataChangedListener != null) {
                this.onDataChangedListener.onDataChanged(this);
            }
            if (this.selectionHint != null && !this.selectionHint.isEmpty() && data != null) {
                data.moveToFirst();
                boolean changed = false;
                for (int i = 0; i < data.getCount(); i++) {
                    data.moveToPosition(i);
                    T graphObject = data.getGraphObject();
                    if (graphObject.asMap().containsKey("id")) {
                        String obj = graphObject.getProperty("id");
                        if (obj instanceof String) {
                            String id = obj;
                            if (this.selectionHint.contains(id)) {
                                this.selectionStrategy.toggleSelection(id);
                                this.selectionHint.remove(id);
                                changed = true;
                            }
                            if (this.selectionHint.isEmpty()) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                if (this.onSelectionChangedListener != null && changed) {
                    this.onSelectionChangedListener.onSelectionChanged(this);
                }
            }
        }
    }

    private void reprioritizeDownloads() {
        int lastVisibleItem = this.listView.getLastVisiblePosition();
        if (lastVisibleItem >= 0) {
            this.adapter.prioritizeViewRange(this.listView.getFirstVisiblePosition(), lastVisibleItem, 5);
        }
    }
}
