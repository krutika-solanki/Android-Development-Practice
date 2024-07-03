package com.krutikasolanki.explicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnYouTube = findViewById(R.id.btnYouTube);
        btnYouTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setPackage("com.google.android.youtube");
                intent.setData(Uri.parse("https://www.youtube.com/watch?v=2hIY1xuImuQ"));
                startActivity(intent);
            }
        });

    }
}