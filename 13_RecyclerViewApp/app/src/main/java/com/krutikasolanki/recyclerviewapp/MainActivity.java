package com.krutikasolanki.recyclerviewapp;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ContactModel> arrContact = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerContact);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        arrContact.add(new ContactModel(R.drawable.profile, "a", "5564213685"));
        arrContact.add(new ContactModel(R.drawable.woman, "b", "5564213685"));
        arrContact.add(new ContactModel(R.drawable.boy, "c", "5564213685"));
        arrContact.add(new ContactModel(R.drawable.avatar1, "d", "5564213685"));
        arrContact.add(new ContactModel(R.drawable.profile, "e", "5564213685"));
        arrContact.add(new ContactModel(R.drawable.boy, "f", "5564213685"));
        arrContact.add(new ContactModel(R.drawable.woman, "g", "5564213685"));
        arrContact.add(new ContactModel(R.drawable.avatar1, "h", "5564213685"));
        arrContact.add(new ContactModel(R.drawable.boy, "i", "5564213685"));
        arrContact.add(new ContactModel(R.drawable.woman, "j", "5564213685"));
        arrContact.add(new ContactModel(R.drawable.avatar1, "k", "5564213685"));
        arrContact.add(new ContactModel(R.drawable.boy, "l", "5564213685"));
        arrContact.add(new ContactModel(R.drawable.woman, "m", "5564213685"));

        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this, arrContact);
        recyclerView.setAdapter(adapter);

        FloatingActionButton btnOpenDialog = findViewById(R.id.btnOpenDialog);

        Context context = this;
        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update);

                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtNumber = dialog.findViewById(R.id.edtNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "", number = "";

                        if (!edtName.getText().toString().equals("")) {
                            name = edtName.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please, Enter Contact Name!", Toast.LENGTH_SHORT).show();
                        }
                        if (!edtNumber.getText().toString().equals("")) {
                            number = edtNumber.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please, Enter Contact Number!", Toast.LENGTH_SHORT).show();
                        }

                        arrContact.add(new ContactModel(R.drawable.avatar1, name, number));
                        adapter.notifyItemInserted(arrContact.size() - 1);
                        recyclerView.scrollToPosition(arrContact.size() - 1);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}