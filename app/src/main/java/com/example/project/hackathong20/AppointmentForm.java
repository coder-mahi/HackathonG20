package com.example.project.hackathong20;

// AppointmentForm.java

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AppointmentForm extends AppCompatActivity {

    private EditText editTextName, editTextPhone, editTextDate, editTextTime;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_form);

        // Initialize views
        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextDate = findViewById(R.id.editTextDate);
        editTextTime = findViewById(R.id.editTextTime);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Set onClickListener for the submit button
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user inputs
                String name = editTextName.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();
                String date = editTextDate.getText().toString().trim();
                String time = editTextTime.getText().toString().trim();

                // Validate inputs
                if (name.isEmpty() || phone.isEmpty() || date.isEmpty() || time.isEmpty()) {
                    Toast.makeText(AppointmentForm.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Process appointment registration (e.g., save to database)
                    // Here, you can implement code to save the appointment details to a database
                    // For simplicity, we'll just show a toast message
                    Toast.makeText(AppointmentForm.this, "Appointment registered successfully", Toast.LENGTH_SHORT).show();

                    // Clear input fields
                    editTextName.setText("");
                    editTextPhone.setText("");
                    editTextDate.setText("");
                    editTextTime.setText("");
                }
            }
        });
    }
}

