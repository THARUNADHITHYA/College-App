package com.example.csespot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button signoutBtn;

    CardView pdf,chat,feedback;

    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signoutBtn = findViewById(R.id.signoutbtn);

        pdf = findViewById(R.id.pdfMaterialView);
        chat = findViewById(R.id.chatOption);
        feedback=findViewById(R.id.feedbackView);

        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PdfDownload_Activity.class);
                startActivity(intent);
                //finish();

            }
        });

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GroupChatActivity.class);
                startActivity(intent);
                //finish();
            }
        });




        signoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Intent intent = new Intent(MainActivity.this,Login_Page.class);
                startActivity(intent);
                //finish();
            }
        });


        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Feedback_Activity.class);
                startActivity(intent);
            }
        });

    }
}