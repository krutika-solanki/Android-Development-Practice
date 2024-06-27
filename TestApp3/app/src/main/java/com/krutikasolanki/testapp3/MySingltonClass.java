package com.krutikasolanki.testapp3;

import android.content.Context;
import android.content.SharedPreferences;

public class MySingltonClass {
    public static SharedPreferences sharedPreferences;

    public static SharedPreferences getInstance(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences("myData", Context.MODE_PRIVATE);;
        }
        return sharedPreferences;
    }
}
