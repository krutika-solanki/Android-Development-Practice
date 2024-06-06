package com.krutikasolanki.roomdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "contact")
public class Contact {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "name")
    String name;
    @ColumnInfo(name = "email")
    String email;

    public Contact(int id, String name, String email){
        this.id=id;
        this.name=name;
        this.email=email;
    }
    @Ignore
    public Contact(String name, String email){
        this.name=name;
        this.email=email;
    }
}
