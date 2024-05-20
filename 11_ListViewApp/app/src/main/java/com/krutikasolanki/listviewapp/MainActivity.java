package com.krutikasolanki.listviewapp;

import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrNames=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        arrNames.add("Ram");
        arrNames.add("Shyam");
        arrNames.add("Ramanujan");
        arrNames.add("Rama");
        arrNames.add("Rameez");
        arrNames.add("Raja");
        arrNames.add("Raju");
        arrNames.add("Rohit");
        arrNames.add("Ramesh");
        arrNames.add("Raam");
        arrNames.add("Raj");
        arrNames.add("Rahul");
        arrNames.add("Rajan");
        arrNames.add("Ramu");
        arrNames.add("Ram");
        arrNames.add("Shyam");
        arrNames.add("Ramanujan");
        arrNames.add("Rama");
        arrNames.add("Rameez");
        arrNames.add("Raja");
        arrNames.add("Raju");

        ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position==0){
                    Toast.makeText(MainActivity.this, "Clicked First Item", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}