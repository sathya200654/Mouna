package com.google.mediapipe.framework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import com.google.common.flogger.FluentLogger;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class AssetCacheDbHelper extends SQLiteOpenHelper {
    private static final String COMMA_SEP = ",";
    public static final String DATABASE_NAME = "mediapipe.db";
    public static final int DATABASE_VERSION = 2;
    private static final String INT_TYPE = " INTEGER";
    private static final String SQL_CREATE_TABLE = "CREATE TABLE AssetVersion (_id INTEGER PRIMARY KEY,asset TEXT NOT NULL UNIQUE,cache_path TEXT,version INTEGER )";
    private static final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS AssetVersion";
    private static final String TEXT_TYPE = " TEXT";
    private static final String TEXT_UNIQUE_TYPE = " TEXT NOT NULL UNIQUE";
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public static abstract class AssetCacheEntry implements BaseColumns {
        public static final String COLUMN_NAME_ASSET = "asset";
        public static final String COLUMN_NAME_CACHE_PATH = "cache_path";
        public static final String COLUMN_NAME_VERSION = "version";
        public static final String TABLE_NAME = "AssetVersion";
    }

    public AssetCacheDbHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 2);
    }

    public boolean checkVersion(String assetPath, int currentAppVersion) {
        Cursor cursorQueryAssetCacheTable = queryAssetCacheTable(getReadableDatabase(), new String[]{"version"}, "asset = ?", new String[]{assetPath});
        if (cursorQueryAssetCacheTable.getCount() == 0) {
            return false;
        }
        cursorQueryAssetCacheTable.moveToFirst();
        int i = cursorQueryAssetCacheTable.getInt(cursorQueryAssetCacheTable.getColumnIndexOrThrow("version"));
        cursorQueryAssetCacheTable.close();
        return i == currentAppVersion;
    }

    public void invalidateCache(int currentAppVersion) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        String[] strArr = {Integer.toString(currentAppVersion)};
        removeCachedFiles(writableDatabase, "version != ?", strArr);
        writableDatabase.delete(AssetCacheEntry.TABLE_NAME, "version != ?", strArr);
    }

    public void insertAsset(String asset, String cachePath, int appVersion) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        removeCachedFiles(writableDatabase, "asset = ? and cache_path != ?", new String[]{asset, cachePath});
        ContentValues contentValues = new ContentValues();
        contentValues.put(AssetCacheEntry.COLUMN_NAME_ASSET, asset);
        contentValues.put(AssetCacheEntry.COLUMN_NAME_CACHE_PATH, cachePath);
        contentValues.put("version", Integer.valueOf(appVersion));
        if (writableDatabase.insertWithOnConflict(AssetCacheEntry.TABLE_NAME, null, contentValues, 5) == -1) {
            throw new RuntimeException("Can't insert entry into the mediapipe db.");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLE);
        onCreate(db);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private Cursor queryAssetCacheTable(SQLiteDatabase db, String[] projection, String selection, String[] selectionArgs) {
        return db.query(AssetCacheEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, null);
    }

    private void removeCachedFiles(SQLiteDatabase db, String selection, String[] selectionArgs) {
        Cursor cursorQueryAssetCacheTable = queryAssetCacheTable(db, new String[]{AssetCacheEntry.COLUMN_NAME_CACHE_PATH}, selection, selectionArgs);
        if (cursorQueryAssetCacheTable.moveToFirst()) {
            do {
                String string = cursorQueryAssetCacheTable.getString(cursorQueryAssetCacheTable.getColumnIndexOrThrow(AssetCacheEntry.COLUMN_NAME_CACHE_PATH));
                File file = new File(string);
                if (file.exists() && !file.delete()) {
                    logger.atWarning().log("Stale cached file: %s can't be deleted.", string);
                }
            } while (cursorQueryAssetCacheTable.moveToNext());
        }
        cursorQueryAssetCacheTable.close();
    }
}
