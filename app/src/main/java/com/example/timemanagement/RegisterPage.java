package com.example.timemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterPage extends AppCompatActivity {

    EditText registerUsername, registerPassword, registerEmail;
    TextView redirectMessage;
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

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataBase = FirebaseDatabase.getInstance();
                reference = dataBase.getReference("users");

                String name = registerUsername.getText().toString();
                String email = registerEmail.getText().toString();
                String password = registerPassword.getText().toString();

                HelperClass helperClass = new HelperClass(name, email, password);
                reference.child(name).setValue(helperClass);

                Toast.makeText(RegisterPage.this, "Signed up successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterPage.this, Log.class);
                startActivity(intent);
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the SignUpActivity when the signup button is clicked
                Intent intent = new Intent(RegisterPage.this, Register2.class);
                startActivity(intent);
            }
        });

        redirectMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterPage.this, Log.class);
                startActivity(intent);
            }
        });
    }
}