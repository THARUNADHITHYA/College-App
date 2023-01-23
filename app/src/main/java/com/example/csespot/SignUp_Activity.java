package com.example.csespot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp_Activity extends AppCompatActivity {


    TextInputEditText email,password;
    Button signUpBtn;

    //DatabaseReference reference;

    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_upp);


        email = findViewById(R.id.textEmail);
        password = findViewById(R.id.textPassword);
        signUpBtn = findViewById(R.id.signUpButton);


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = email.getText().toString();
                String userPassword = password.getText().toString();
                //signUpFirebase(userEmail,userPassword);
                //signUpBtn.setClickable(false);

                String split[] = userEmail.split("@");
                String domain = split[1];

                if(domain.equals("mcet.in")) {
                    signUpFirebase(userEmail, userPassword);
                    signUpBtn.setClickable(false);
                }
                else
                {
                    Log.d("mytag","else part running");
                    Toast.makeText(getApplicationContext(),"UnAUTHORIZED USER",Toast.LENGTH_SHORT).show();
                }

            }
        });

       // reference = FirebaseDatabase.getInstance().getReference().child("Users");


    }

    public void signUpFirebase(String userEmail,String userPassword )
    {
        auth.createUserWithEmailAndPassword(userEmail, userPassword ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),"Account is Created",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"There is a problem in creating the account please try again",Toast.LENGTH_SHORT).show();
                }

                signUpBtn.setClickable(false);

            }
        });
    }


}