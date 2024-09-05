package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ReceiverFormActivity extends AppCompatActivity {

    private EditText etReceiverName, etReceiverAddress, etReceiverEmail, etReceiverPhone, etReceiverCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_form);

        etReceiverName = findViewById(R.id.etReceiverName);
        etReceiverAddress = findViewById(R.id.etReceiverAddress);
        etReceiverEmail = findViewById(R.id.etReceiverEmail);
        etReceiverPhone = findViewById(R.id.etReceiverContactInfo);
        etReceiverCountry = findViewById(R.id.etReceiverCountry);

        Button nextButton = findViewById(R.id.btnNext);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    // Pass data to the next activity
                    Intent intent = new Intent(ReceiverFormActivity.this, ReviewActivity.class);

                    // Get data from the previous activity (SenderFormActivity)
                    Intent previousIntent = getIntent();
                    intent.putExtra("senderEmail", previousIntent.getStringExtra("email"));
                    intent.putExtra("senderFullName", previousIntent.getStringExtra("fullName"));
                    intent.putExtra("senderContactInfo", previousIntent.getStringExtra("contactInfo"));
                    intent.putExtra("senderCountry", previousIntent.getStringExtra("country"));
                    intent.putExtra("senderAddress", previousIntent.getStringExtra("address"));

                    // Add receiver data to the intent
                    intent.putExtra("receiverName", etReceiverName.getText().toString().trim());
                    intent.putExtra("receiverAddress", etReceiverAddress.getText().toString().trim());
                    intent.putExtra("receiverEmail", etReceiverEmail.getText().toString().trim());
                    intent.putExtra("receiverCountry", etReceiverCountry.getText().toString().trim());
                    intent.putExtra("receiverPhone", etReceiverPhone.getText().toString().trim());

                    startActivity(intent);
                }
            }
        });
    }

    // validation
    private boolean validateInput() {
        String receiverName = etReceiverName.getText().toString().trim();
        String receiverAddress = etReceiverAddress.getText().toString().trim();
        String receiverEmail = etReceiverEmail.getText().toString().trim();
        String receiverPhone = etReceiverPhone.getText().toString().trim();

        if (receiverEmail.isEmpty()) {
            etReceiverEmail.setError("Receiver Email is required");
            etReceiverEmail.requestFocus();
            return false;
        }

        if (receiverName.isEmpty()) {
            etReceiverName.setError("Receiver Name is required");
            etReceiverName.requestFocus();
            return false;
        }

        if (receiverAddress.isEmpty()) {
            etReceiverAddress.setError("Receiver Address is required");
            etReceiverAddress.requestFocus();
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(receiverEmail).matches()) {
            etReceiverEmail.setError("Please enter a valid email");
            etReceiverEmail.requestFocus();
            return false;
        }

        if (receiverPhone.isEmpty()) {
            etReceiverPhone.setError("Receiver Phone is required");
            etReceiverPhone.requestFocus();
            return false;
        }

        return true;
    }
}
