package com.krutikasolanki.recyclerviewapp;

public class ContactModel {
    int img;
    String name, number;

    public ContactModel(int img, String name, String number) {
        this.img = img;
        this.name = name;
        this.number = number;
    }

    public ContactModel(String name, String number) {
        this.name = name;
        this.number = number;
    }
}
