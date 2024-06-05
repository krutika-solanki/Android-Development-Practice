package com.krutikasolanki.sqlitedb;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "CONTACT_INFO";
    MyDatabaseHelper dbHelper;
    EditText edtTxtID,edtTxtName, edtTxtNumber;
    Button btnAdd, btnUpdate, btnDelete;
    TextView txtViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTxtID=findViewById(R.id.edtTxtID);
        edtTxtName = findViewById(R.id.edtTxtName);
        edtTxtNumber = findViewById(R.id.edtTxtNumber);

        txtViewResult = findViewById(R.id.txtViewResult);

        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);

        dbHelper = new MyDatabaseHelper(this);

        if (dbHelper.fetchContact() != null) {
            setResult();
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnAdd) {
            ContactModel contact = new ContactModel(edtTxtName.getText().toString(), edtTxtNumber.getText().toString());
            dbHelper.addContact(contact);
            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.btnUpdate) {
            ContactModel contact = new ContactModel(Integer.parseInt(edtTxtID.getText().toString()), edtTxtName.getText().toString(), edtTxtNumber.getText().toString());
            dbHelper.updateContact(contact);
            Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.btnDelete) {
            ContactModel contact = new ContactModel(Integer.parseInt(edtTxtID.getText().toString()), edtTxtName.getText().toString(), edtTxtNumber.getText().toString());
            dbHelper.deleteContact(contact);
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
        }
        setResult();
        resetInputFields();
    }

    public void setResult() {
        ArrayList<ContactModel> arrContact = dbHelper.fetchContact();
        StringBuilder sb = new StringBuilder();
        for (ContactModel cm : arrContact) {
            sb.append("ID: " + cm.id + "    Name: " + cm.name + "    Number: " + cm.phoneNo + "\n");
        }
        txtViewResult.setText(sb);
    }

    private void resetInputFields() {
        edtTxtNumber.setText("");
        edtTxtName.setText("");
    }
}