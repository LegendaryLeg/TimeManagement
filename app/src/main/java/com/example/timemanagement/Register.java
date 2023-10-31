package com.example.timemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    EditText registerUsername, registerPassword, registerEmail;
    Button signupButton;
    FirebaseDatabase dataBase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerUsername = findViewById(R.id.editTextText_username);
        registerPassword = findViewById(R.id.editTextTextPassword_password);
        registerEmail = findViewById(R.id.editTextTextEmailAddress_email);
    }
}