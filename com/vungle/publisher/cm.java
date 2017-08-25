package com.vungle.publisher;

import android.database.Cursor;
import android.database.SQLException;

/* compiled from: vungle */
public final class cm {
    public static Boolean m1252a(Cursor cursor, String str) throws SQLException {
        Integer d = m1259d(cursor, str);
        if (d == null) {
            return null;
        }
        switch (d.intValue()) {
            case 0:
                return Boolean.FALSE;
            case 1:
                return Boolean.TRUE;
            default:
                throw new SQLException("invalid boolean value " + d + " for column " + str);
        }
    }

    public static <E extends Enum<E>> E m1254a(Cursor cursor, String str, Class<E> cls) throws SQLException {
        try {
            return m1253a(cursor, cursor.getColumnIndexOrThrow(str), (Class) cls);
        } catch (IllegalArgumentException e) {
            throw new SQLException("invalid column name: " + str);
        }
    }

    private static <E extends Enum<E>> E m1253a(Cursor cursor, int i, Class<E> cls) throws SQLException {
        String string = cursor.getString(i);
        try {
            return cursor.isNull(i) ? null : Enum.valueOf(cls, string);
        } catch (IllegalArgumentException e) {
            throw new SQLException("invalid enum: " + string);
        }
    }

    public static Float m1257b(Cursor cursor, String str) throws SQLException {
        try {
            int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
            return cursor.isNull(columnIndexOrThrow) ? null : Float.valueOf(cursor.getFloat(columnIndexOrThrow));
        } catch (IllegalArgumentException e) {
            throw new SQLException("invalid column name: " + str);
        }
    }

    public static int m1258c(Cursor cursor, String str) throws SQLException {
        try {
            Integer a = m1255a(cursor, cursor.getColumnIndexOrThrow(str));
            return a == null ? 0 : a.intValue();
        } catch (IllegalArgumentException e) {
            throw new SQLException("invalid column name: " + str);
        }
    }

    public static Integer m1259d(Cursor cursor, String str) throws SQLException {
        try {
            return m1255a(cursor, cursor.getColumnIndexOrThrow(str));
        } catch (IllegalArgumentException e) {
            throw new SQLException("invalid column name: " + str);
        }
    }

    private static Integer m1255a(Cursor cursor, int i) throws SQLException {
        return cursor.isNull(i) ? null : Integer.valueOf(cursor.getInt(i));
    }

    public static Long m1260e(Cursor cursor, String str) throws SQLException {
        try {
            int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
            return cursor.isNull(columnIndexOrThrow) ? null : Long.valueOf(cursor.getLong(columnIndexOrThrow));
        } catch (IllegalArgumentException e) {
            throw new SQLException("invalid column name: " + str);
        }
    }

    public static String m1261f(Cursor cursor, String str) throws SQLException {
        try {
            return cursor.getString(cursor.getColumnIndexOrThrow(str));
        } catch (IllegalArgumentException e) {
            throw new SQLException("invalid column name: " + str);
        }
    }

    public static String m1256a(int i) {
        if (i <= 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder((i * 2) - 1);
        stringBuilder.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            stringBuilder.append(",?");
        }
        return stringBuilder.toString();
    }
}
