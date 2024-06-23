package com.krutikasolanki.viewmodel;

import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    int counter = 0;
    void increment() {
        counter++;
    }
}
