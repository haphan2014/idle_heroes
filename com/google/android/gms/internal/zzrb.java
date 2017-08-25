package com.google.android.gms.internal;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class zzrb {

    public static class zza {
        public final zzrc zzaVj;
        public final List<Asset> zzaVk;

        public zza(zzrc com_google_android_gms_internal_zzrc, List<Asset> list) {
            this.zzaVj = com_google_android_gms_internal_zzrc;
            this.zzaVk = list;
        }
    }

    private static int zza(String str, com.google.android.gms.internal.zzrc.zza.zza[] com_google_android_gms_internal_zzrc_zza_zzaArr) {
        int i = 14;
        for (com.google.android.gms.internal.zzrc.zza.zza com_google_android_gms_internal_zzrc_zza_zza : com_google_android_gms_internal_zzrc_zza_zzaArr) {
            if (i == 14) {
                if (com_google_android_gms_internal_zzrc_zza_zza.type == 9 || com_google_android_gms_internal_zzrc_zza_zza.type == 2 || com_google_android_gms_internal_zzrc_zza_zza.type == 6) {
                    i = com_google_android_gms_internal_zzrc_zza_zza.type;
                } else if (com_google_android_gms_internal_zzrc_zza_zza.type != 14) {
                    throw new IllegalArgumentException("Unexpected TypedValue type: " + com_google_android_gms_internal_zzrc_zza_zza.type + " for key " + str);
                }
            } else if (com_google_android_gms_internal_zzrc_zza_zza.type != i) {
                throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + com_google_android_gms_internal_zzrc_zza_zza.type);
            }
        }
        return i;
    }

    static int zza(List<Asset> list, Asset asset) {
        list.add(asset);
        return list.size() - 1;
    }

    public static zza zza(DataMap dataMap) {
        zzrc com_google_android_gms_internal_zzrc = new zzrc();
        List arrayList = new ArrayList();
        com_google_android_gms_internal_zzrc.zzaVl = zza(dataMap, arrayList);
        return new zza(com_google_android_gms_internal_zzrc, arrayList);
    }

    private static com.google.android.gms.internal.zzrc.zza.zza zza(List<Asset> list, Object obj) {
        com.google.android.gms.internal.zzrc.zza.zza com_google_android_gms_internal_zzrc_zza_zza = new com.google.android.gms.internal.zzrc.zza.zza();
        if (obj == null) {
            com_google_android_gms_internal_zzrc_zza_zza.type = 14;
            return com_google_android_gms_internal_zzrc_zza_zza;
        }
        com_google_android_gms_internal_zzrc_zza_zza.zzaVp = new com.google.android.gms.internal.zzrc.zza.zza.zza();
        if (obj instanceof String) {
            com_google_android_gms_internal_zzrc_zza_zza.type = 2;
            com_google_android_gms_internal_zzrc_zza_zza.zzaVp.zzaVr = (String) obj;
        } else if (obj instanceof Integer) {
            com_google_android_gms_internal_zzrc_zza_zza.type = 6;
            com_google_android_gms_internal_zzrc_zza_zza.zzaVp.zzaVv = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            com_google_android_gms_internal_zzrc_zza_zza.type = 5;
            com_google_android_gms_internal_zzrc_zza_zza.zzaVp.zzaVu = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            com_google_android_gms_internal_zzrc_zza_zza.type = 3;
            com_google_android_gms_internal_zzrc_zza_zza.zzaVp.zzaVs = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            com_google_android_gms_internal_zzrc_zza_zza.type = 4;
            com_google_android_gms_internal_zzrc_zza_zza.zzaVp.zzaVt = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            com_google_android_gms_internal_zzrc_zza_zza.type = 8;
            com_google_android_gms_internal_zzrc_zza_zza.zzaVp.zzaVx = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            com_google_android_gms_internal_zzrc_zza_zza.type = 7;
            com_google_android_gms_internal_zzrc_zza_zza.zzaVp.zzaVw = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            com_google_android_gms_internal_zzrc_zza_zza.type = 1;
            com_google_android_gms_internal_zzrc_zza_zza.zzaVp.zzaVq = (byte[]) obj;
        } else if (obj instanceof String[]) {
            com_google_android_gms_internal_zzrc_zza_zza.type = 11;
            com_google_android_gms_internal_zzrc_zza_zza.zzaVp.zzaVA = (String[]) obj;
        } else if (obj instanceof long[]) {
            com_google_android_gms_internal_zzrc_zza_zza.type = 12;
            com_google_android_gms_internal_zzrc_zza_zza.zzaVp.zzaVB = (long[]) obj;
        } else if (obj instanceof float[]) {
            com_google_android_gms_internal_zzrc_zza_zza.type = 15;
            com_google_android_gms_internal_zzrc_zza_zza.zzaVp.zzaVC = (float[]) obj;
        } else if (obj instanceof Asset) {
            com_google_android_gms_internal_zzrc_zza_zza.type = 13;
            com_google_android_gms_internal_zzrc_zza_zza.zzaVp.zzaVD = (long) zza((List) list, (Asset) obj);
        } else if (obj instanceof DataMap) {
            com_google_android_gms_internal_zzrc_zza_zza.type = 9;
            DataMap dataMap = (DataMap) obj;
            Set<String> keySet = dataMap.keySet();
            com.google.android.gms.internal.zzrc.zza[] com_google_android_gms_internal_zzrc_zzaArr = new com.google.android.gms.internal.zzrc.zza[keySet.size()];
            r1 = 0;
            for (String str : keySet) {
                com_google_android_gms_internal_zzrc_zzaArr[r1] = new com.google.android.gms.internal.zzrc.zza();
                com_google_android_gms_internal_zzrc_zzaArr[r1].name = str;
                com_google_android_gms_internal_zzrc_zzaArr[r1].zzaVn = zza((List) list, dataMap.get(str));
                r1++;
            }
            com_google_android_gms_internal_zzrc_zza_zza.zzaVp.zzaVy = com_google_android_gms_internal_zzrc_zzaArr;
        } else if (obj instanceof ArrayList) {
            com_google_android_gms_internal_zzrc_zza_zza.type = 10;
            ArrayList arrayList = (ArrayList) obj;
            com.google.android.gms.internal.zzrc.zza.zza[] com_google_android_gms_internal_zzrc_zza_zzaArr = new com.google.android.gms.internal.zzrc.zza.zza[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i = 0;
            int i2 = 14;
            while (i < size) {
                Object obj3 = arrayList.get(i);
                com.google.android.gms.internal.zzrc.zza.zza zza = zza((List) list, obj3);
                if (zza.type == 14 || zza.type == 2 || zza.type == 6 || zza.type == 9) {
                    if (i2 == 14 && zza.type != 14) {
                        r1 = zza.type;
                    } else if (zza.type != i2) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    } else {
                        obj3 = obj2;
                        r1 = i2;
                    }
                    com_google_android_gms_internal_zzrc_zza_zzaArr[i] = zza;
                    i++;
                    i2 = r1;
                    obj2 = obj3;
                } else {
                    throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                }
            }
            com_google_android_gms_internal_zzrc_zza_zza.zzaVp.zzaVz = com_google_android_gms_internal_zzrc_zza_zzaArr;
        } else {
            throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
        }
        return com_google_android_gms_internal_zzrc_zza_zza;
    }

    public static DataMap zza(zza com_google_android_gms_internal_zzrb_zza) {
        DataMap dataMap = new DataMap();
        for (com.google.android.gms.internal.zzrc.zza com_google_android_gms_internal_zzrc_zza : com_google_android_gms_internal_zzrb_zza.zzaVj.zzaVl) {
            zza(com_google_android_gms_internal_zzrb_zza.zzaVk, dataMap, com_google_android_gms_internal_zzrc_zza.name, com_google_android_gms_internal_zzrc_zza.zzaVn);
        }
        return dataMap;
    }

    private static ArrayList zza(List<Asset> list, com.google.android.gms.internal.zzrc.zza.zza.zza com_google_android_gms_internal_zzrc_zza_zza_zza, int i) {
        ArrayList arrayList = new ArrayList(com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVz.length);
        for (com.google.android.gms.internal.zzrc.zza.zza com_google_android_gms_internal_zzrc_zza_zza : com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVz) {
            if (com_google_android_gms_internal_zzrc_zza_zza.type == 14) {
                arrayList.add(null);
            } else if (i == 9) {
                DataMap dataMap = new DataMap();
                for (com.google.android.gms.internal.zzrc.zza com_google_android_gms_internal_zzrc_zza : com_google_android_gms_internal_zzrc_zza_zza.zzaVp.zzaVy) {
                    zza(list, dataMap, com_google_android_gms_internal_zzrc_zza.name, com_google_android_gms_internal_zzrc_zza.zzaVn);
                }
                arrayList.add(dataMap);
            } else if (i == 2) {
                arrayList.add(com_google_android_gms_internal_zzrc_zza_zza.zzaVp.zzaVr);
            } else if (i == 6) {
                arrayList.add(Integer.valueOf(com_google_android_gms_internal_zzrc_zza_zza.zzaVp.zzaVv));
            } else {
                throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
            }
        }
        return arrayList;
    }

    private static void zza(List<Asset> list, DataMap dataMap, String str, com.google.android.gms.internal.zzrc.zza.zza com_google_android_gms_internal_zzrc_zza_zza) {
        int i = com_google_android_gms_internal_zzrc_zza_zza.type;
        if (i == 14) {
            dataMap.putString(str, null);
            return;
        }
        com.google.android.gms.internal.zzrc.zza.zza.zza com_google_android_gms_internal_zzrc_zza_zza_zza = com_google_android_gms_internal_zzrc_zza_zza.zzaVp;
        if (i == 1) {
            dataMap.putByteArray(str, com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVq);
        } else if (i == 11) {
            dataMap.putStringArray(str, com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVA);
        } else if (i == 12) {
            dataMap.putLongArray(str, com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVB);
        } else if (i == 15) {
            dataMap.putFloatArray(str, com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVC);
        } else if (i == 2) {
            dataMap.putString(str, com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVr);
        } else if (i == 3) {
            dataMap.putDouble(str, com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVs);
        } else if (i == 4) {
            dataMap.putFloat(str, com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVt);
        } else if (i == 5) {
            dataMap.putLong(str, com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVu);
        } else if (i == 6) {
            dataMap.putInt(str, com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVv);
        } else if (i == 7) {
            dataMap.putByte(str, (byte) com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVw);
        } else if (i == 8) {
            dataMap.putBoolean(str, com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVx);
        } else if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            dataMap.putAsset(str, (Asset) list.get((int) com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVD));
        } else if (i == 9) {
            DataMap dataMap2 = new DataMap();
            for (com.google.android.gms.internal.zzrc.zza com_google_android_gms_internal_zzrc_zza : com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVy) {
                zza(list, dataMap2, com_google_android_gms_internal_zzrc_zza.name, com_google_android_gms_internal_zzrc_zza.zzaVn);
            }
            dataMap.putDataMap(str, dataMap2);
        } else if (i == 10) {
            i = zza(str, com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVz);
            ArrayList zza = zza(list, com_google_android_gms_internal_zzrc_zza_zza_zza, i);
            if (i == 14) {
                dataMap.putStringArrayList(str, zza);
            } else if (i == 9) {
                dataMap.putDataMapArrayList(str, zza);
            } else if (i == 2) {
                dataMap.putStringArrayList(str, zza);
            } else if (i == 6) {
                dataMap.putIntegerArrayList(str, zza);
            } else {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + i);
            }
        } else {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
    }

    private static com.google.android.gms.internal.zzrc.zza[] zza(DataMap dataMap, List<Asset> list) {
        Set<String> keySet = dataMap.keySet();
        com.google.android.gms.internal.zzrc.zza[] com_google_android_gms_internal_zzrc_zzaArr = new com.google.android.gms.internal.zzrc.zza[keySet.size()];
        int i = 0;
        for (String str : keySet) {
            Object obj = dataMap.get(str);
            com_google_android_gms_internal_zzrc_zzaArr[i] = new com.google.android.gms.internal.zzrc.zza();
            com_google_android_gms_internal_zzrc_zzaArr[i].name = str;
            com_google_android_gms_internal_zzrc_zzaArr[i].zzaVn = zza((List) list, obj);
            i++;
        }
        return com_google_android_gms_internal_zzrc_zzaArr;
    }
}
