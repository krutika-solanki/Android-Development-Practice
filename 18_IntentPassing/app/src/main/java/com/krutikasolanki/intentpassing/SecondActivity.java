package com.krutikasolanki.intentpassing;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    TextView nameView, rollnoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nameView = findViewById(R.id.nameView);
        rollnoView = findViewById(R.id.rollnoView);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        int rollno = intent.getIntExtra("rollno", 0);

        nameView.setText(name);
        rollnoView.setText(String.valueOf(rollno));
    }
}