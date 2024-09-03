package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SenderFormActivity extends AppCompatActivity {

    private EditText etEmail, etFullName, etContactInfo, etCountry, etAddress;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender_form);

        // Initialize UI components
        etEmail = findViewById(R.id.etEmail);
        etFullName = findViewById(R.id.etFullName);
        etContactInfo = findViewById(R.id.etContactInfo);
        etCountry = findViewById(R.id.etCountry);
        etAddress = findViewById(R.id.etAddress);
        nextButton = findViewById(R.id.btnNext);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validate input fields
                if (validateInputs()) {
                    // If validation passes, proceed to next activity
                    Intent intent = new Intent(SenderFormActivity.this, ReceiverFormActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validateInputs() {
        String email = etEmail.getText().toString().trim();
        String fullName = etFullName.getText().toString().trim();
        String contactInfo = etContactInfo.getText().toString().trim();
        String country = etCountry.getText().toString().trim();
        String address = etAddress.getText().toString().trim();

        // Check if any field is empty
        if (email.isEmpty() || fullName.isEmpty() || contactInfo.isEmpty() || country.isEmpty() || address.isEmpty()) {
            showToast("Please fill in all fields");
            return false;
        }

        // Validate email format
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showToast("Please enter a valid email address");
            return false;
        }

        // Additional validation (e.g., contactInfo format) can be added here

        return true;
    }

    private void showToast(String message) {
        Toast.makeText(SenderFormActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
