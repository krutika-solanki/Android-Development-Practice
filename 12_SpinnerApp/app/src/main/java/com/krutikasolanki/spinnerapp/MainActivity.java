package com.krutikasolanki.spinnerapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    AutoCompleteTextView actxt;
    ArrayList<String> arrID = new ArrayList<>();
    ArrayList<String> arrLanguage=new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        actxt = findViewById(R.id.actxt);

        arrID.add("Adhar Card");
        arrID.add("VoterID");
        arrID.add("PassPort");
        arrID.add("RationCard");

        ArrayAdapter<String> spinnerAadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrID);
        spinner.setAdapter(spinnerAadapter);

        arrLanguage.add("C");
        arrLanguage.add("C##");
        arrLanguage.add("C++");
        arrLanguage.add("Java");
        arrLanguage.add("Python");
        arrLanguage.add("SQL");
        arrLanguage.add("PHP");
        arrLanguage.add("CScript");
        arrLanguage.add("HTML");

        ArrayAdapter<String> autoctxtAdapter= new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,arrLanguage);
        actxt.setAdapter(autoctxtAdapter);
        actxt.setThreshold(1);

    }
}