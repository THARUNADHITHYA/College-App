package com.example.csespot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Feedback_Activity extends AppCompatActivity {

    EditText feedback;
    Button sendBtn;
    String email ="adhiadhithya93@gmail.com";
    String subject = "Feedback of cse spot app";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        feedback = findViewById(R.id.feedbackTextMultiLine);
        sendBtn = findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userFeedback = feedback.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
                intent.putExtra(Intent.EXTRA_SUBJECT,subject);
                intent.putExtra(Intent.EXTRA_TEXT,userFeedback);

                intent.setType("message/rfc882");

                startActivity(Intent.createChooser(intent,"Choose an email client"));


            }
        });


    }
}