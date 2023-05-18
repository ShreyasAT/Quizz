package com.adlab.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    TextView correctTv, wrongTv;
    Button backButton;
    int correctCount, wrongCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        correctTv = findViewById(R.id.correct_answers);
        wrongTv = findViewById(R.id.wrong_answers);
        backButton = findViewById(R.id.previous_button);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            correctCount = bundle.getInt("correctCount");
            wrongCount = bundle.getInt("wrongCount");
        }

        correctTv.setText(String.valueOf(MainActivity.correctans));
        wrongTv.setText(String.valueOf(MainActivity.wrongans));
        MainActivity.correctans=0;
        MainActivity.wrongans=0;
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, MainActivity3.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
