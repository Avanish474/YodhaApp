package com.example.yodha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    public ArrayList<String> questions;
    public TextView question;
    public int i = 0;
    public Button next;
    public Button previous;
    public RadioButton radioButton1;
    public RadioButton radioButton2;
    public RadioButton radioButton;
    public boolean[] arr;
    public RadioGroup radioGroup;
    public RadioButton selectedRadioButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_quiz_view);
        question = findViewById(R.id.textView2);
        next = findViewById(R.id.Next);
        previous = findViewById(R.id.Previous);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioGroup = findViewById(R.id.radio);
        questions = new ArrayList<>();

        questions.add(getString(R.string.question_1));
        questions.add(getString(R.string.question_2));
        questions.add(getString(R.string.question_3));
        questions.add(getString(R.string.question_4));
        questions.add(getString(R.string.question_5));
        questions.add(getString(R.string.question_6));
        questions.add(getString(R.string.question_7));
        questions.add(getString(R.string.question_8));
        arr = new boolean[questions.size()];

        question.setText(questions.get(0));


        next.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                int selectedId = radioGroup.getCheckedRadioButtonId();

                selectedRadioButton = (RadioButton) findViewById(selectedId);
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(QuizActivity.this, "No answer selected", Toast.LENGTH_SHORT).show();
                } else {
                    if (i < questions.size()) {
                        question.setText(questions.get(++i));

                    } else if (i >= questions.size()) {
                        Toast.makeText(QuizActivity.this, "No further Question ahead", Toast.LENGTH_LONG).show();
                    }
                    boolean result = false;
                    result = (radioButton1.isChecked()) ? true : false;
                    arr[i] = result;
                    Toast.makeText(QuizActivity.this, Boolean.toString(arr[i]), Toast.LENGTH_SHORT).show();

                    radioGroup.clearCheck();

                }
            }
        });

    }

    public void onRadioClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        String str = "";
        switch (view.getId()) {
            case R.id.radioButton1:
                if (checked)
                    str = "yes";
                break;
            case R.id.radioButton2:
                if (checked)
                    str = "No";
                break;

        }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }
}
