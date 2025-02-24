package com.example.exp6th;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText emailEditText, subjectEditText, bodyEditText;
    String username = "your-email@gmail.com";  // Your Gmail address
    String password = "your-email-password";  // Your Gmail password or app-specific password

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the EditTexts
        emailEditText = findViewById(R.id.emailEditText);
        subjectEditText = findViewById(R.id.subjectEditText);
        bodyEditText = findViewById(R.id.bodyEditText);
    }

    public void sendEmail(View view) {
        String recipient = emailEditText.getText().toString();
        String subject = subjectEditText.getText().toString();
        String body = bodyEditText.getText().toString();

        if (recipient.isEmpty() || subject.isEmpty() || body.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            // Create an instance of EmailSender and call the sendEmail method
            EmailSender emailSender = new EmailSender();
            emailSender.sendEmail(username, password, recipient, subject, body);

            // Notify user that the email is sent
            Toast.makeText(this, "Email sent successfully!", Toast.LENGTH_SHORT).show();
        }
    }
}
