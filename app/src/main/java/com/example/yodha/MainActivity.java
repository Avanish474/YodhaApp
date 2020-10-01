package com.example.yodha;

import android.content.Intent;
import android.icu.lang.UCharacterEnums;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button next;
    private TextView editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next = findViewById(R.id.button);
        editText = findViewById(R.id.editTextTextEmailAddress3);

    }

    public void next(View view) {
        if(!(editText.getText().toString().isEmpty())){
        Intent intent = new Intent(this, NavigateTo.class);
        startActivity(intent);
    }
        else{
            Toast.makeText(MainActivity.this,"Enter you email id ",Toast.LENGTH_SHORT).show();
        }
}}
