package com.adlab.quizapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.adlab.quizapp.MainActivity3;
import com.adlab.quizapp.R;

public class MainActivity2 extends Activity {

    private RadioGroup optionsGroup2;
    private RadioButton selectedOption;

    private RadioButton correct2;
    private Button nextButton;
    private Button previousButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        optionsGroup2 = findViewById(R.id.options2);
        nextButton = findViewById(R.id.next2);
        previousButton = findViewById(R.id.previous);
        correct2= findViewById(R.id.option2c);
        int selectedOptionId = optionsGroup2.getCheckedRadioButtonId();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOptionId = optionsGroup2.getCheckedRadioButtonId();

                if (selectedOptionId == -1) {
                    Toast.makeText(MainActivity2.this, "Please select an option", Toast.LENGTH_SHORT).show();
                    return;
                }


                selectedOption = findViewById(selectedOptionId);
                String answer = selectedOption.getText().toString();
                if(answer==correct2.getText().toString()){
                    MainActivity.correctans++;
                }
                else{
                    MainActivity.wrongans++;
                }

                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("answer1", getIntent().getStringExtra("answer1"));
                intent.putExtra("answer2", answer);
                intent.putExtra("correctanswer",MainActivity.correctans);
                intent.putExtra("wrongans",MainActivity.wrongans);
                startActivity(intent);
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
