package com.example.project.hackathong20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class AppointmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        final EditText nameEditText = findViewById(R.id.nameEditText);
        final EditText ageEditText = findViewById(R.id.ageEditText);
        final Spinner genderSpinner = findViewById(R.id.genderSpinner);
        final Spinner doctorSpinner = findViewById(R.id.doctorSpinner);
        final DatePicker datePicker = findViewById(R.id.datePicker);
        Button bookAppointmentButton = findViewById(R.id.bookAppointmentButton);

        bookAppointmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String age = ageEditText.getText().toString();
                String gender = genderSpinner.getSelectedItem().toString();
                String doctor = doctorSpinner.getSelectedItem().toString();
                String date = datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear();

                // You can perform validation here before proceeding with booking the appointment
                // For simplicity, let's just display a toast message
                String message = "Appointment booked for " + name + " with " + doctor + " on " + date;
                Toast.makeText(AppointmentActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}