package com.example.roboticsscorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.CountDownTimer;

public class MainActivity extends AppCompatActivity {

    private void startTimer() {
        countDownTimer = new CountDownTimer(120000, 1000) { // 30 seconds, with a tick every 1 second
            @Override
            public void onTick(long millisUntilFinished) {
                long secondsRemaining = millisUntilFinished / 1000;
                countdownTextView.setText("" + secondsRemaining);
            }

            @Override
            public void onFinish() {
                countdownTextView.setText("0");
            }
        };

        countDownTimer.start();
    }

    private void stopTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countdownTextView.setText("120");
        }
    }

    private int currentNumber = 0;
    private TextView numberTextView;

    private CountDownTimer countDownTimer;
    private TextView countdownTextView;
    private Button startButton;

    private Button stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberTextView = findViewById(R.id.numberTextView);
        Button incrementButton10 = findViewById(R.id.incrementButton10);
        Button incrementButton5 = findViewById(R.id.incrementButton5);
        Button incrementButton1 = findViewById(R.id.incrementButton1);
        Button decrementButton10 = findViewById(R.id.decrementButton10);
        Button decrementButton5 = findViewById(R.id.decrementButton5);
        Button decrementButton1 = findViewById(R.id.decrementButton1);
        countdownTextView = findViewById(R.id.countdownTextView);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTimer();
            }
        });

        incrementButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber = currentNumber + 10;
                numberTextView.setText("Score: " + String.valueOf(currentNumber));
            }
        });

        incrementButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber = currentNumber + 5;
                numberTextView.setText("Score: " + String.valueOf(currentNumber));
            }
        });

        incrementButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber++;
                numberTextView.setText("Score: " + String.valueOf(currentNumber));
            }
        });

        decrementButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber = currentNumber - 10;
                numberTextView.setText("Score: " + String.valueOf(currentNumber));
            }
        });

        decrementButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber = currentNumber - 5;
                numberTextView.setText("Score: " + String.valueOf(currentNumber));
            }
        });

        decrementButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber--;
                numberTextView.setText("Score: " + String.valueOf(currentNumber));
            }
        });

    }
}

