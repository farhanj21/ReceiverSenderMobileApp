package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ReviewActivity extends AppCompatActivity {

    private TextView tvSenderInfo, tvReceiverInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        // Initialize TextViews
        tvSenderInfo = findViewById(R.id.tvSenderInfo);
        tvReceiverInfo = findViewById(R.id.tvReceiverInfo);

        // Get data from Intent
        String senderFullName = getIntent().getStringExtra("senderFullName");
        String senderCountry = getIntent().getStringExtra("senderCountry");
        String senderAddress = getIntent().getStringExtra("senderAddress");
        String senderContactInfo = getIntent().getStringExtra("senderContactInfo");

        String receiverName = getIntent().getStringExtra("receiverName");
        String receiverCountry = getIntent().getStringExtra("receiverCountry");
        String receiverAddress = getIntent().getStringExtra("receiverAddress");
        String receiverPhone = getIntent().getStringExtra("receiverPhone");

        // Set the retrieved data to the TextViews
        tvSenderInfo.setText(senderFullName + "          " + senderCountry + "          " + senderAddress + "          " + senderContactInfo);
        tvReceiverInfo.setText(receiverName + "          " + receiverCountry + "          " + receiverAddress + "          " + receiverPhone);
    }
}
