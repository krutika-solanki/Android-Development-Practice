package com.krutikasolanki.contactscontentprovider;

public class Contact {
    String id,name,number;

    public Contact(String id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
