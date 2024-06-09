package com.krutikasolanki.mycontentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ProxyInfo;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MovieProvider extends ContentProvider {
    private static final String AUTHORITY = "com.krutikasolanki.movie.provider";
    protected static final Uri MOVIES_URI = Uri.parse("content://" + AUTHORITY + "/movies");
    private static final String TABLE_NAME = "movies";
    SQLiteDatabase database;
    static int MOVIES=1;
    static int MOVIES_ID=2;
    static UriMatcher uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
    static {
        uriMatcher.addURI(AUTHORITY,"movies",MOVIES);
        uriMatcher.addURI(AUTHORITY,"movies/#",MOVIES_ID);
    }

    @Override
    public boolean onCreate() {
        DBHelper dbHelper=new DBHelper(getContext());
        database=dbHelper.getWritableDatabase();
        if(database!=null){
            return true;
        }
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor cursor= database.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        long raw=database.insert(TABLE_NAME,null,values);
        if(raw>0){
            uri= ContentUris.withAppendedId(MOVIES_URI,raw);
            getContext().getContentResolver().notifyChange(uri,null);
        }
        return uri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int raw=database.delete(TABLE_NAME,selection,selectionArgs);
        return raw;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        throw new UnsupportedOperationException("Not Yet Implemented");
    }
}
