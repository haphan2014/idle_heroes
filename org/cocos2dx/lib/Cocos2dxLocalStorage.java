package org.cocos2dx.lib;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Cocos2dxLocalStorage {
    private static String DATABASE_NAME = "jsb.sqlite";
    private static final int DATABASE_VERSION = 1;
    private static String TABLE_NAME = "data";
    private static final String TAG = "Cocos2dxLocalStorage";
    private static SQLiteDatabase mDatabase = null;
    private static DBOpenHelper mDatabaseOpenHelper = null;

    private static class DBOpenHelper extends SQLiteOpenHelper {
        DBOpenHelper(Context context) {
            super(context, Cocos2dxLocalStorage.DATABASE_NAME, null, 1);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE IF NOT EXISTS " + Cocos2dxLocalStorage.TABLE_NAME + "(key TEXT PRIMARY KEY,value TEXT);");
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(Cocos2dxLocalStorage.TAG, "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        }
    }

    public static boolean init(String dbName, String tableName) {
        if (Cocos2dxActivity.getContext() == null) {
            return false;
        }
        DATABASE_NAME = dbName;
        TABLE_NAME = tableName;
        mDatabaseOpenHelper = new DBOpenHelper(Cocos2dxActivity.getContext());
        mDatabase = mDatabaseOpenHelper.getWritableDatabase();
        return true;
    }

    public static void destory() {
        if (mDatabase != null) {
            mDatabase.close();
        }
    }

    public static void setItem(String key, String value) {
        try {
            String sql = "replace into " + TABLE_NAME + "(key,value)values(?,?)";
            mDatabase.execSQL(sql, new Object[]{key, value});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getItem(String key) {
        String ret = null;
        try {
            Cursor c = mDatabase.rawQuery("select value from " + TABLE_NAME + " where key=?", new String[]{key});
            while (c.moveToNext()) {
                if (ret != null) {
                    Log.e(TAG, "The key contains more than one value.");
                    break;
                }
                ret = c.getString(c.getColumnIndex("value"));
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret == null ? "" : ret;
    }

    public static void removeItem(String key) {
        try {
            String sql = "delete from " + TABLE_NAME + " where key=?";
            mDatabase.execSQL(sql, new Object[]{key});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
