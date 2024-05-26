package com.krutikasolanki.implicitintent;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMail=findViewById(R.id.btnMail);

        btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();

                intent.setAction(Intent.ACTION_SEND);

                // This shows the apps that accept an Intent Sending Text
                intent.setType("text/plain");

                intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"ripalnakiya@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,"Email Subject");
                intent.putExtra(Intent.EXTRA_TEXT,"this is a sample mail");

                startActivity(intent);

                // Chooser shows list of all the apps that can handle text sharing
//                String chooserTitle="share this text with";
//                Intent chooser=Intent.createChooser(intent,chooserTitle);
//                try{
//                    startActivity(chooser);
//                }catch (ActivityNotFoundException e){
//                    System.out.println(e);
//                }

            }
        });

    }
}