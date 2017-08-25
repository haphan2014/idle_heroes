package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.internal.model.people.zzk;

public final class PersonBuffer extends AbstractDataBuffer<Person> {
    private final zzd<PersonEntity> zzaJw;

    public PersonBuffer(DataHolder dataHolder) {
        super(dataHolder);
        if (dataHolder.zznb() == null || !dataHolder.zznb().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.zzaJw = null;
        } else {
            this.zzaJw = new zzd(dataHolder, PersonEntity.CREATOR);
        }
    }

    public Person get(int position) {
        return this.zzaJw != null ? (Person) this.zzaJw.zzbg(position) : new zzk(this.zzWu, position);
    }
}
