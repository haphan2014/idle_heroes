package com.heyzap.sdk.segmentation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.heyzap.internal.Constants.AuctionType;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Logger;
import java.util.Date;

public class SQLitePastImpressionStore implements PastImpressionStore {
    private final SQLiteOpenHelper dbHelper;

    private static class SQLitePastImpressionStoreDbHelper extends SQLiteOpenHelper {
        private static final String CREATE_TABLE = "CREATE TABLE `past_impressions` (`id` INTEGER PRIMARY KEY,`date` INTEGER not NULL,`creative_type` INTEGER not NULL,`auction_type` INTEGER not NULL,`tag` VARCHAR(63) not NULL);CREATE INDEX `search` ON `past_impressions` (`auction_type`, `tag`, `creative_type`);";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS `past_impressions`";
        private static final String PRUNE_TABLE = "DELETE FROM `past_impressions` WHERE `id` NOT IN (SELECT `id` FROM `past_impressions` ORDER BY `date` DESC LIMIT 1000)";

        public SQLitePastImpressionStoreDbHelper(Context context) {
            super(context, "past_impressions", null, 2);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if (oldVersion < 2) {
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }
        }

        public void onOpen(SQLiteDatabase db) {
            db.execSQL(PRUNE_TABLE);
        }
    }

    public SQLitePastImpressionStore(Context context) {
        this.dbHelper = new SQLitePastImpressionStoreDbHelper(context);
    }

    public synchronized int getPastImpressionCount(Date since, CreativeType creativeType, AuctionType auctionType, String tag) {
        int output;
        SQLiteDatabase database = null;
        Cursor cursor = null;
        try {
            database = this.dbHelper.getWritableDatabase();
            if (creativeType.equals(CreativeType.UNKNOWN)) {
                cursor = database.query(false, "past_impressions", new String[]{"COUNT(*)"}, "`auction_type` = ? AND `date` > ? AND tag = ?", new String[]{auctionType.toInt(), String.valueOf(since.getTime() / 1000), tag}, null, null, null, null);
            } else {
                cursor = database.query(false, "past_impressions", new String[]{"COUNT(*)"}, "`creative_type` = ? AND `auction_type` = ? AND `date` > ? AND tag = ?", new String[]{creativeType.toInt(), auctionType.toInt(), String.valueOf(since.getTime() / 1000), tag}, null, null, null, null);
            }
            cursor.moveToFirst();
            output = cursor.getInt(0);
            if (cursor != null) {
                cursor.close();
            }
            if (database != null) {
                database.close();
            }
        } catch (SQLiteException e) {
            output = 0;
            if (cursor != null) {
                cursor.close();
            }
            if (database != null) {
                database.close();
            }
        } catch (RuntimeException e2) {
            Logger.error("Exception encountered getting impression count, returning 0", e2);
            output = 0;
            if (cursor != null) {
                cursor.close();
            }
            if (database != null) {
                database.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            if (database != null) {
                database.close();
            }
        }
        return output;
    }

    public synchronized void putImpression(CreativeType creativeType, AuctionType auctionType, String tag) {
        SQLiteDatabase database = null;
        try {
            database = this.dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues(3);
            values.put("date", Long.valueOf(new Date().getTime() / 1000));
            values.put("creative_type", Integer.valueOf(creativeType.value));
            values.put("auction_type", Integer.valueOf(auctionType.value));
            values.put("tag", tag.substring(0, Math.min(60, tag.length())));
            database.insert("past_impressions", null, values);
            if (database != null) {
                database.close();
            }
        } catch (SQLiteException e) {
            Logger.error("Failed to insert into past_impression", e);
            if (database != null) {
                database.close();
            }
        } catch (Throwable th) {
            if (database != null) {
                database.close();
            }
        }
    }
}
