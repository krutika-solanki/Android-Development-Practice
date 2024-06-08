package com.krutikasolanki.contactscontentprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper {
    private static final Uri CONTENT_URI= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
    private static final String CONTACT_ID=ContactsContract.CommonDataKinds.Phone.CONTACT_ID;
    private static final String DISPLAY_NAME=ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;
    private static final String NUMBER=ContactsContract.CommonDataKinds.Phone.NUMBER;
    public static List<Contact> getAllContacts(ContentResolver contentResolver){
        List<Contact> contactList=new ArrayList<>();

        // Define the columns you want to retrieve
        String[] projection = {CONTACT_ID, DISPLAY_NAME, NUMBER};

        // Query the contacts content provider
        Cursor cursor = contentResolver.query(CONTENT_URI , projection, null, null, null);

        if(cursor!=null && cursor.moveToFirst()){
            do{
                String id= cursor.getString(cursor.getColumnIndexOrThrow(CONTACT_ID));
                String name=cursor.getString(cursor.getColumnIndexOrThrow(DISPLAY_NAME));
                String number=cursor.getString(cursor.getColumnIndexOrThrow(NUMBER));
                contactList.add(new Contact(id,name,number));
            }while(cursor.moveToNext());
        }

        return contactList;
    }
}
