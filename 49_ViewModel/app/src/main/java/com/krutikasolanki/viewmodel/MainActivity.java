package com.krutikasolanki.viewmodel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);

        // We pass ViewModelStoreOwner to the ViewModelProvicder constructor
        // Here, we are passing the Activity as ViewModelStoreOwner
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        // To load value after a configuration change, or To Load the default value when the app is started for the first time
        String text = String.valueOf(myViewModel.counter);
        textView.setText(text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementAndSetText();
            }
        });
    }
    private void incrementAndSetText() {
        myViewModel.increment();
        String text = String.valueOf(myViewModel.counter);
        textView.setText(text);
    }
}