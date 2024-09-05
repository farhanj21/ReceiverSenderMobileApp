package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SenderFormActivity extends AppCompatActivity {

    private EditText etEmail, etFullName, etContactInfo, etCountry, etAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender_form);

        etEmail = findViewById(R.id.etEmail);
        etFullName = findViewById(R.id.etFullName);
        etContactInfo = findViewById(R.id.etContactInfo);
        etCountry = findViewById(R.id.etCountry);
        etAddress = findViewById(R.id.etAddress);

        Button nextButton = findViewById(R.id.btnNext);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    // Pass data to the next activity
                    Intent intent = new Intent(SenderFormActivity.this, ReceiverFormActivity.class);
                    intent.putExtra("email", etEmail.getText().toString().trim());
                    intent.putExtra("fullName", etFullName.getText().toString().trim());
                    intent.putExtra("contactInfo", etContactInfo.getText().toString().trim());
                    intent.putExtra("country", etCountry.getText().toString().trim());
                    intent.putExtra("address", etAddress.getText().toString().trim());
                    startActivity(intent);
                }
            }
        });
    }

    // validation
    private boolean validateInput() {
        String email = etEmail.getText().toString().trim();
        String fullName = etFullName.getText().toString().trim();
        String contactInfo = etContactInfo.getText().toString().trim();
        String country = etCountry.getText().toString().trim();
        String address = etAddress.getText().toString().trim();

        if (email.isEmpty()) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Please enter a valid email");
            etEmail.requestFocus();
            return false;
        }

        if (fullName.isEmpty()) {
            etFullName.setError("Full Name is required");
            etFullName.requestFocus();
            return false;
        }

        if (contactInfo.isEmpty()) {
            etContactInfo.setError("Contact Information is required");
            etContactInfo.requestFocus();
            return false;
        }

        if (country.isEmpty()) {
            etCountry.setError("Country is required");
            etCountry.requestFocus();
            return false;
        }

        if (address.isEmpty()) {
            etAddress.setError("Address is required");
            etAddress.requestFocus();
            return false;
        }

        return true;
    }
}
