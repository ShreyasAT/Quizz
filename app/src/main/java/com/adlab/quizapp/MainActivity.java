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

public class MainActivity extends Activity {
    public static int correctans=0,wrongans=0;
    private RadioGroup optionsGroup;
    private RadioButton selectedOption;
    private Button nextButton;
    private Button previousButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        optionsGroup=findViewById(R.id.options_group);
        nextButton = findViewById(R.id.next_button);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOptionId = optionsGroup.getCheckedRadioButtonId();

                if (selectedOptionId == -1) {
                    Toast.makeText(MainActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                    return;
                }

                selectedOption = findViewById(selectedOptionId);
                String answer = selectedOption.getText().toString();
                if(answer=="Paris"){
                    correctans++;
                }
                else{
                    wrongans++;
                }
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("answer1", answer);
                intent.putExtra("firstans",correctans);
                intent.putExtra("wrongans",wrongans);
                startActivity(intent);
            }
        });


    }
}
