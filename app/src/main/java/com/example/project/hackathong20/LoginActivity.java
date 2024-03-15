package com.example.project.hackathong20;

import android.content.Intent;
import android.os.Bundle;
        import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
        import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText usernameEditText, passwordEditText;
    private Button loginButton;
    private TextView signUpTextView, messageTextView;
    Spinner user_spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize UI elements
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        signUpTextView = findViewById(R.id.signupbtn);
        messageTextView = findViewById(R.id.text);
        user_spinner = findViewById(R.id.user_spinner);

        // Set click listener for login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform login process
                loginProcess();
            }
        });

        // Set click listener for sign up text view
        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to sign up activity
                // For example:
                // startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });

        user_spinner.setOnItemSelectedListener(this);

        // Other initialization code...
    }

    // Override onItemSelected method to get the selected item
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Get the selected item from the spinner
        String selectedItem = parent.getItemAtPosition(position).toString();

        // Perform actions with the selected item
        Toast.makeText(this, "Selected item: " + selectedItem, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //
    private void loginProcess() {
        // Retrieve username and password from EditText fields
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String user = user_spinner.getSelectedItem().toString();
        if(username.equals("") || password.equals("")){
            Toast.makeText(getApplicationContext(),"Login Failed..!",Toast.LENGTH_SHORT).show();
        }else{
            if(user.equals("DOCTOR")||user.equals("PATIENT")){
                Intent i =new Intent(getApplicationContext(), MainActivity.class);
                Toast.makeText(getApplicationContext(),"Login Succesful..!",Toast.LENGTH_SHORT).show();
                i.putExtra("username",username);
                i.putExtra("password",password);
                i.putExtra("user",user);
                startActivity(i);
            }
        }


        // Perform validation (e.g., check if fields are empty)

        // Perform authentication (e.g., check credentials against a database)

        // For demonstration purposes, display a message
        String message = "Username: " + username + "\nPassword: " + password;
        messageTextView.setText(message);
    }
}