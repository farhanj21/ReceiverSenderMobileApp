package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;

public class ReviewActivity extends AppCompatActivity {

    private TextView tvSenderInfo, tvReceiverInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        tvSenderInfo = findViewById(R.id.tvSenderInfo);
        tvReceiverInfo = findViewById(R.id.tvReceiverInfo);

        //FAB
        FloatingActionButton fabEdit = findViewById(R.id.fabEdit);
        fabEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReviewActivity.this, SenderFormActivity.class);

                intent.putExtra("senderFullName", getIntent().getStringExtra("senderFullName"));
                intent.putExtra("senderCountry", getIntent().getStringExtra("senderCountry"));
                intent.putExtra("senderAddress", getIntent().getStringExtra("senderAddress"));
                intent.putExtra("senderContactInfo", getIntent().getStringExtra("senderContactInfo"));

                startActivity(intent);
            }
        });

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
