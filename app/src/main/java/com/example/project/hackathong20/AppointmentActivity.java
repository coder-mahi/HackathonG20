package com.example.project.hackathong20;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AppointmentActivity extends AppCompatActivity {

    private TextView textViewDate, textViewTime, textViewDoctor, textViewDepartment;
    private Button buttonSelectDate, buttonSelectTime;
    private Spinner spinnerDoctors, spinnerDepartments;
    private EditText editTextPatientName, editTextPatientAge, editTextPatientGender, editTextPatientContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        // Find views by their IDs
        textViewDate = findViewById(R.id.textViewDate);
        textViewTime = findViewById(R.id.textViewTime);
        textViewDoctor = findViewById(R.id.textViewDoctor);
        textViewDepartment = findViewById(R.id.textViewDepartment);
        buttonSelectDate = findViewById(R.id.buttonSelectDate);
        buttonSelectTime = findViewById(R.id.buttonSelectTime);
        spinnerDoctors = findViewById(R.id.spinnerDoctors);
        spinnerDepartments = findViewById(R.id.spinnerDepartments);
        editTextPatientName = findViewById(R.id.editTextPatientName);
        editTextPatientAge = findViewById(R.id.editTextPatientAge);
        editTextPatientGender = findViewById(R.id.editTextPatientGender);
        editTextPatientContact = findViewById(R.id.editTextPatientContact);

        // Set onClickListener for the buttons
        buttonSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement date selection logic here
            }
        });

        buttonSelectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement time selection logic here
            }
        });

        // Get the user-entered data when needed, for example, on a submit button click
        // You can retrieve the values entered by the user from the views like this:
        String patientName = editTextPatientName.getText().toString();
        String patientAge = editTextPatientAge.getText().toString();
        String patientGender = editTextPatientGender.getText().toString();
        String patientContact = editTextPatientContact.getText().toString();

        // You can similarly retrieve selected items from spinners
        String selectedDoctor = spinnerDoctors.getSelectedItem().toString();
        String selectedDepartment = spinnerDepartments.getSelectedItem().toString();

        // Now you can use these values as needed, for example, to upload them to a database
        // or perform any other operations in your app.
    }
}
