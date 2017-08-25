package com.droidhang.pay.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataProvider extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "record.db";
    private static DataProvider INSTANCE = null;
    private static final String[] PARAM = new String[1];
    private static final int VERSION = 1;
    private static Context _context;

    public static void init(Context context) {
        _context = context;
        INSTANCE = new DataProvider(_context);
    }

    public static DataProvider getDP() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        INSTANCE = new DataProvider(_context);
        return INSTANCE;
    }

    public DataProvider(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public boolean checkBillID(String billID) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            PARAM[0] = billID;
            boolean empty = true;
            Cursor cursor = db.query("record", new String[]{"bill_id"}, "bill_id=?", PARAM, null, null, null);
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    empty = false;
                }
                cursor.close();
            }
            if (!empty) {
                return false;
            }
            ContentValues vs = new ContentValues();
            vs.put("bill_id", billID);
            db.insert("record", null, vs);
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table record(bill_id text not null);");
        db.execSQL("CREATE INDEX IF NOT EXISTS index_bill_id ON record(bill_id);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
