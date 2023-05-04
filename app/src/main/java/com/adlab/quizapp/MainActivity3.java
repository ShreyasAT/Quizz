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

public class MainActivity3 extends Activity {

    private RadioGroup optionsGroup;
    private RadioButton selectedOption;
    private Button nextButton;
    private Button previousButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        optionsGroup = findViewById(R.id.options3);
        nextButton = findViewById(R.id.submit);
        previousButton = findViewById(R.id.previous3);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOptionId = optionsGroup.getCheckedRadioButtonId();

                if (selectedOptionId == -1) {
                    Toast.makeText(MainActivity3.this, "Please select an option", Toast.LENGTH_SHORT).show();
                    return;
                }

                selectedOption = findViewById(selectedOptionId);
                String answer = selectedOption.getText().toString();

                if(answer=="Paris"){
                    MainActivity.correctans++;
                }
                else{
                    MainActivity.wrongans++;
                }
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("answer1", getIntent().getStringExtra("answer1"));
                intent.putExtra("answer2", getIntent().getStringExtra("answer2"));
                intent.putExtra("answer3", answer);

                startActivity(intent);
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
