package com.krutikasolanki.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ContactDB";
    private static final String TABLE_NAME = "contacts";
    private static final int DATABASE_VERSION = 1;
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE_NO = "phone_no";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // CREATE TABLE TABLE_NAME( id INTEGER PRIMARY KEY AUTOINCREAMENT, name TEXT, phoneNo TEXT)
        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_NAME +
                "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_NAME + " TEXT, " + KEY_PHONE_NO + " TEXT " + ")"
        );

        //open and close database
//        SQLiteDatabase database = this.getReadableDatabase();
//        database.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addContact(ContactModel contact) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.name);
        values.put(KEY_PHONE_NO, contact.phoneNo);

        sqLiteDatabase.insert(TABLE_NAME, null, values);
    }

    public ArrayList<ContactModel> fetchContact() {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<ContactModel> arrContact = new ArrayList<>();

        while (cursor.moveToNext()) {
            ContactModel contact = new ContactModel();
            contact.id = cursor.getInt(0);
            contact.name = cursor.getString(1);
            contact.phoneNo = cursor.getString(2);
            arrContact.add(contact);
        }
        return arrContact;
    }

    public void updateContact(ContactModel contactModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contactModel.name);
        values.put(KEY_PHONE_NO, contactModel.phoneNo);

        db.update(TABLE_NAME, values, KEY_ID + "=" + contactModel.id, null);
    }

    public void deleteContact(ContactModel contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + " = ?", new String[]{String.valueOf(contact.id)});
    }
}

