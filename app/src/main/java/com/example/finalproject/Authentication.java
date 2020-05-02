package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Authentication extends AppCompatActivity {
    private EditText randomNumberEditText;
    private TextView randomNumberTextView;
    private Button cancelButton;
    private Button loginButton;
    private String randomNumber;
    private String numberInput;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        context = this;
        randomNumberEditText = (EditText) findViewById(R.id.randomNumberInputEditText);
        randomNumberTextView = (TextView) findViewById(R.id.randomNumberTextView);
        cancelButton = (Button) findViewById(R.id.cancelButton_authentication);
        loginButton = (Button) findViewById(R.id.loginButton_authentication);

        //creating a random six digit number
        randomNumber = Long.toString(Math.round(Math.random() * 900000 + 100000));
        randomNumberTextView.setText(randomNumber);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput = randomNumberEditText.getText().toString();
                if (numberInput.equals(randomNumber)) {
                    startActivity(new Intent(Authentication.this, MainActivity.class));
                }else {
                    Toast.makeText(context,"Wrong number, please try again",Toast.LENGTH_SHORT).show();
                }
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}