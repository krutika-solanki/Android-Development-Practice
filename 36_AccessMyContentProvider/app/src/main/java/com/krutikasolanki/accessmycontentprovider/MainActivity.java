package com.krutikasolanki.accessmycontentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String AUTHORITY = "com.krutikasolanki.movie.provider";
    public static final Uri MOVIES_URI = Uri.parse("content://" + AUTHORITY + "/movies");
    TextView resultView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loadButton = findViewById(R.id.loadButton);
        loadButton.setOnClickListener(this);

        resultView = findViewById(R.id.resultView);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.loadButton) {
            Cursor cursor = getContentResolver().query(MOVIES_URI, null, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                StringBuilder sb = new StringBuilder();
                do {
                    sb.append("ID-" + cursor.getString(0) + "\n" + "Name-" + cursor.getString(1) + "\n" + "Rating-" + cursor.getString(2));
                    sb.append("\n\n");
                } while (cursor.moveToNext());
                resultView.setText(sb);
            } else {
                resultView.setText("No Records Found");
            }
        }
    }
}