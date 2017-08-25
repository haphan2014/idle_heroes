package com.heyzap.common.vast.processor;

import com.heyzap.common.vast.model.VASTMediaFile;
import java.util.List;

public interface VASTMediaPicker {
    VASTMediaFile pickVideo(List<VASTMediaFile> list);
}
