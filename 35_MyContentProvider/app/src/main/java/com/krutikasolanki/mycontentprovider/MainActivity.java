package com.krutikasolanki.mycontentprovider;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText idText, nameText, rateText;
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idText = findViewById(R.id.idText);
        nameText = findViewById(R.id.nameText);
        rateText = findViewById(R.id.rateText);

        Button saveButton = findViewById(R.id.saveButton);
        Button deleteButton = findViewById(R.id.deleteButton);

        saveButton.setOnClickListener(this::onClickListener);
        deleteButton.setOnClickListener(this::onClickListener);

        resultView = findViewById(R.id.resultView);

        setResult();
    }

    private void onClickListener(View view) {
        if(view.getId()==R.id.saveButton){
            ContentValues values = new ContentValues();
            values.put("name", nameText.getText().toString());
            values.put("rating", rateText.getText().toString());
            Uri uri = getContentResolver().insert(MovieProvider.MOVIES_URI, values);
            Toast.makeText(MainActivity.this, uri.toString(), Toast.LENGTH_SHORT).show();
        }else if(view.getId()==R.id.deleteButton){
            String id = idText.getText().toString();
            int row = getContentResolver().delete(MovieProvider.MOVIES_URI, "_id = ?", new String[]{id});
            Toast.makeText(MainActivity.this, "Deleted " + row, Toast.LENGTH_SHORT).show();
        }
        setResult();
        setInputFields();
    }
    private void setResult(){
        Cursor cursor=getContentResolver().query(MovieProvider.MOVIES_URI,null,null,null,null);
        if(cursor!=null && cursor.moveToFirst()){
            StringBuilder sb=new StringBuilder();
            do{
                sb.append("ID: "+cursor.getString(0)+"\n"+"Name: "+cursor.getString(1)+"\n"+"Rating: "+cursor.getString(2));
                sb.append("\n\n");

            }while (cursor.moveToNext());
            resultView.setText(sb);
        }else{
            resultView.setText("No records found");
        }
    }
    private void setInputFields(){
        idText.setText("");
        nameText.setText("");
        rateText.setText("");
    }
}