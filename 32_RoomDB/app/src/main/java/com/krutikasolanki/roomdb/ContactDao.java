package com.krutikasolanki.roomdb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

// We use List<E> because this method returns a cursor
// and cursor can't be directly conversed to ArrayList<E>
@Dao
public interface ContactDao {
    @Query(" SELECT * FROM contact")
    List<Contact> fetchContact();

    @Insert
    void addContact(Contact contact);

    @Update
    void updateContact(Contact contact);

    @Delete
    void deleteContact(Contact contact);
}
