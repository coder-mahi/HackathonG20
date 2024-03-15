package com.example.project.hackathong20;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText mobNoEditText;
    private EditText emailIdEditText;
    private EditText passwordEditText;
    private Button signUpButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize UI components
        usernameEditText = findViewById(R.id.username);
        mobNoEditText = findViewById(R.id.mobno);
        emailIdEditText = findViewById(R.id.emailid);
        passwordEditText = findViewById(R.id.password);
        signUpButton = findViewById(R.id.signup);
        resultTextView = findViewById(R.id.text);

        // Set onClickListener for signUpButton
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void signUp() {
        // Retrieve user input
        String username = usernameEditText.getText().toString().trim();
        String mobNo = mobNoEditText.getText().toString().trim();
        String emailId = emailIdEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Validate user input
        if (username.isEmpty() || mobNo.isEmpty() || emailId.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            // Perform signup process (e.g., send data to server, save to database)
            // For demonstration purposes, just showing the entered data in a TextView
            String result = "Username: " + username + "\n" +
                    "Mobile No: " + mobNo + "\n" +
                    "Email ID: " + emailId + "\n" +
                    "Password: " + password;
            resultTextView.setText(result);
        }
    }
}
