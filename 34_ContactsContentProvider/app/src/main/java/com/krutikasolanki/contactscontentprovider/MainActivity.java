package com.krutikasolanki.contactscontentprovider;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.Content providers can help an application manage access to data stored by itself
 * or stored by other apps and provide a way to share data with other apps.They
 * encapsulate the data and provide mechanisms for defining data security.
 * 2.content provider to let other applications securely access and modify your app data,
 * 3.Content providers are the standard interface that connects data in one process
 * with code running in another process
 * 4.A number of other classes rely on the ContentProvider class:
 * AbstractThreadedSyncAdapter
 * CursorAdapter
 * CursorLoader
 */

public class MainActivity extends AppCompatActivity {
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button getButton = findViewById(R.id.getButton);

        getButton.setOnClickListener(this::onClick);

        resultView = findViewById(R.id.resultView);
        requestPermissionLauncher.launch(Manifest.permission.READ_CONTACTS);
    }

    private void onClick(View view) {
        if (view.getId() == R.id.getButton) {
            setResult();
        }
    }

    final ActivityResultLauncher<String> requestPermissionLauncher = (ActivityResultLauncher<String>) registerForActivityResult(new ActivityResultContracts.RequestPermission(), permissionsResult -> {
//        setResult();
    });

    void setResult() {
        List<Contact> contacts = ContactHelper.getAllContacts(getContentResolver());
        StringBuilder sb = new StringBuilder();
        for (Contact contact : contacts) {
            sb.append("ID: " + contact.id + " Name: " + contact.name + " Number: " + contact.number + "\n");
        }
        resultView.setText(sb);
    }

}