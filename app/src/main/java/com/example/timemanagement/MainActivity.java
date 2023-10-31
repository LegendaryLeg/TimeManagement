package com.example.timemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//I am Rakhat

    EditText usernameEditText, passwordEditText;
    Button signInButton, signUpButton;
    TextView signInRedirectMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.editText_password);
        signInRedirectMessage = findViewById(R.id.textPassword);
        signInButton = findViewById(R.id.signIn_button);
        signUpButton = findViewById(R.id.signup_button);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the SignUpActivity when the signup button is clicked
                Intent intent = new Intent(MainActivity.this, Register2.class);
                startActivity(intent);
            }
        });
    }

    public Boolean checkUsername() {
        String val = usernameEditText.getText().toString();
        if(val.isEmpty()){
            usernameEditText.setError("You need to write username!");
            return false;
        }
        else {
            usernameEditText.setError(null);
            return true;
        }
    }

}
