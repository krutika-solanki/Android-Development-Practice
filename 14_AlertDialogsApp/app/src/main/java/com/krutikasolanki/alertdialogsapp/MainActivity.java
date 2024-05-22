package com.krutikasolanki.alertdialogsapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog dialog=new AlertDialog.Builder(this).create();

        dialog.setTitle("Terms & Conditions");
        dialog.setIcon(R.drawable.inf);
        dialog.setMessage("Have You Read All the T&C");
        
        //dialog.setButton("Yes",new DialogInterface.OnClickListener(){});
        dialog.show();

        AlertDialog.Builder deletDialog= new AlertDialog.Builder(MainActivity.this);

        deletDialog.setTitle("Delete?");
        deletDialog.setIcon(R.drawable.baseline_delete_24);
        deletDialog.setMessage("Are You Sure Want To Delete?");
        deletDialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Item not deleted", Toast.LENGTH_SHORT).show();
            }
        });
        deletDialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Item Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        deletDialog.show();
    }
    @SuppressLint("MissingSuperCall")
    public void onBackPressed() {

        AlertDialog.Builder exitdialog = new AlertDialog.Builder(this);
        exitdialog.setTitle("Exit?");
        exitdialog.setMessage("Are you sure want to exit?");
        exitdialog.setIcon(R.drawable.baseline_exit_to_app_24);
        exitdialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Welcome back!", Toast.LENGTH_SHORT).show();
            }
        });
        exitdialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
            }
        });
        exitdialog.setNeutralButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Operation Canclled", Toast.LENGTH_SHORT).show();
            }
        });
        exitdialog.show();
    }
}