package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import java.util.ArrayList;

public abstract class MultiDataBufferRef extends zzc {
    protected final ArrayList<DataHolder> zzaoD;

    protected MultiDataBufferRef(ArrayList<DataHolder> dataHolderCollection, int indexForRef, int dataRow) {
        super((DataHolder) dataHolderCollection.get(indexForRef), dataRow);
        this.zzaoD = dataHolderCollection;
    }
}
