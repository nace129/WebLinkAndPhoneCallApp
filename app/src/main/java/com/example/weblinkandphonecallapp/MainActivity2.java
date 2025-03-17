package com.example.weblinkandphonecallapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weblinkandphonecallapp.R;

public class MainActivity2 extends AppCompatActivity {

    EditText urlEditText, phoneEditText;
    Button launchButton, ringButton, closeAppButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        urlEditText = findViewById(R.id.urlEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        launchButton = findViewById(R.id.launchButton);
        ringButton = findViewById(R.id.ringButton);
        closeAppButton = findViewById(R.id.closeAppButton);

        // Launch Website
        launchButton.setOnClickListener(view -> {
            String url = urlEditText.getText().toString();
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "http://" + url; // Ensure proper URL format
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        // Make a Phone Call
        ringButton.setOnClickListener(view -> {
            String phoneNumber = phoneEditText.getText().toString();
            if (!phoneNumber.isEmpty()) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity2.this, "Enter a valid phone number", Toast.LENGTH_SHORT).show();
            }
        });

        // Close App
        closeAppButton.setOnClickListener(view -> finishAffinity());
    }
}
