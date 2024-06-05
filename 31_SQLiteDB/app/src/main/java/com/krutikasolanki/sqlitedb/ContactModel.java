package com.krutikasolanki.sqlitedb;

public class ContactModel {
    int id;
    String name, phoneNo;

    public ContactModel() {

    }

    public ContactModel(String name, String phoneNo) {
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public ContactModel(int id, String name, String phoneNo) {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
    }
}