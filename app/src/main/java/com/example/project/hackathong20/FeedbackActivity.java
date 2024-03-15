package com.example.project.hackathong20;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {

    private Spinner doctorsSpinner;
    private RatingBar ratingBar;
    private EditText commentsEditText;
    private Button submitFeedbackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        // Initialize UI elements
        doctorsSpinner = findViewById(R.id.spinnerDoctors);
        ratingBar = findViewById(R.id.ratingBar);
        commentsEditText = findViewById(R.id.editTextComments);
        submitFeedbackButton = findViewById(R.id.buttonSubmitFeedback);


        submitFeedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitFeedback();
            }
        });
    }

    private void submitFeedback() {

        String selectedDoctor = doctorsSpinner.getSelectedItem().toString();
        float rating = ratingBar.getRating();
        String comments = commentsEditText.getText().toString().trim();

        String feedbackMessage = "Doctor: " + selectedDoctor + "\nRating: " + rating + "\nComments: " + comments;

    }
}