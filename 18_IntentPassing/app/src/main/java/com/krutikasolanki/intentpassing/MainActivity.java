package com.krutikasolanki.intentpassing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText nameText, rollnoText;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.nameText);
        rollnoText = findViewById(R.id.rollnoText);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameText.getText().toString();
                int rollno = Integer.parseInt(rollnoText.getText().toString());

                // Constructor takes two parameters i.e. (source, destination)
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra("name", name);
                intent.putExtra("rollno", rollno);
                startActivity(intent);
            }
        });


    }
}