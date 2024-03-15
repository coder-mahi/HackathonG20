package com.example.project.hackathong20;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class TelemedicineActivity extends AppCompatActivity {

    private CheckBox checkboxTelemedicine, checkboxVirtualConsultation;
    private Button buttonStartVideoCall, buttonJoinVideoCall, buttonSendMessage;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telemedicine);

        // Initialize UI components
        checkboxTelemedicine = findViewById(R.id.checkboxTelemedicine);
        checkboxVirtualConsultation = findViewById(R.id.checkboxVirtualConsultation);
        buttonStartVideoCall = findViewById(R.id.buttonStartVideoCall);
        buttonJoinVideoCall = findViewById(R.id.buttonJoinVideoCall);
        buttonSendMessage = findViewById(R.id.buttonSendMessage);
        editTextMessage = findViewById(R.id.editTextMessage);

        // Set click listeners
        buttonStartVideoCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement logic to start a video call
            }
        });

        buttonJoinVideoCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement logic to join a video call
            }
        });

        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextMessage.getText().toString();
                // Implement logic to send the message
            }
        });
    }
}