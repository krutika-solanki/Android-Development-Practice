package com.krutikasolanki.roomdb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyDatabaseManager dbManager;
    EditText idText, nameText, emailText;
    Button addButton, updateButton, deleteButton;
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idText = findViewById(R.id.idText);
        nameText = findViewById(R.id.nameText);
        emailText = findViewById(R.id.emailText);
        resultView = findViewById(R.id.resultView);

        addButton = findViewById(R.id.addButton);
        updateButton = findViewById(R.id.updateButton);
        deleteButton = findViewById(R.id.deleteButton);

        addButton.setOnClickListener(this::onClick);
        updateButton.setOnClickListener(this::onClick);
        deleteButton.setOnClickListener(this::onClick);

        dbManager=MyDatabaseManager.getMyDatabaseManager(this);
        if(dbManager.contactDao().fetchContact()!=null){
            setResult();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.addButton) {
            Contact contact = new Contact(nameText.getText().toString(), emailText.getText().toString());
            dbManager.contactDao().addContact(contact);
        } else if (id == R.id.updateButton) {
            Contact contact = new Contact(Integer.parseInt(idText.getText().toString()), nameText.getText().toString(), emailText.getText().toString());
            dbManager.contactDao().updateContact(contact);
        } else if (id == R.id.deleteButton) {
            Contact contact = new Contact(Integer.parseInt(idText.getText().toString()), nameText.getText().toString(), emailText.getText().toString());
            dbManager.contactDao().deleteContact(contact);
        }
        setResult();
        resetInputFields();
    }

    private void resetInputFields() {
        idText.setText("");
        nameText.setText("");
        emailText.setText("");
    }

    void setResult() {
        ArrayList<Contact> arrContact = (ArrayList<Contact>) dbManager.contactDao().fetchContact();
        StringBuilder sb = new StringBuilder();
        for (Contact contact : arrContact) {
            sb.append("ID: " + contact.id + " Name: " + contact.name + " E-mail: " + contact.email + "\n");
        }
        resultView.setText(sb);
    }
}