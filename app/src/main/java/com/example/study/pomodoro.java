//code from https://www.youtube.com/watch?v=MDuGwI6P-X8&t=428s

package com.example.study;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.Locale;


public class pomodoro extends AppCompatActivity {

    // Text view variables
    public TextView timerCountdownText;
    public Button startCountdown;
    public Button button_Restart;
    // public Button stop_Countdown;

    private CountDownTimer countDownTimer;
    private static final long startTiming = 1500000; //25 minutes
    private long timeLeftInMilliseconds = startTiming;

    private boolean timerRunning;

    @SuppressLint("MissingInflatedId")

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Problem was here. fragment_current_status was used instead of fragment_pomodoro
        setContentView(R.layout.fragment_pomodoro);

//        View root = inflater.inflate(R.layout.fragment_pomodoro, container, false);

        timerCountdownText = (TextView) findViewById(R.id.timer_countdownText);
        startCountdown = (Button) findViewById(R.id.buttonStartCountdown); //start button
        button_Restart = (Button) findViewById(R.id.pomodoroRestartCountdown); //stop button
        // stop_Countdown= (Button) findViewById(R.id.pomodoroStopCountdown); //stop button

        startCountdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //this is to start or stop the timer

                if (timerRunning) {
                    startCountdown.setText("Start");
                    Toast.makeText(getApplicationContext(), "Timer Paused", Toast.LENGTH_SHORT).show();
                    stopTimer();
                } else {
                    startCountdown.setText("Pause");
                    Toast.makeText(getApplicationContext(), "Timer Started", Toast.LENGTH_SHORT).show();
                    startTimer();
                }
                // NavHostFragment.findNavController(FirstFragment.this.navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

//        stop_Countdown.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                stopTimer();
//            }
//        });

        button_Restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });
    }

    //starts the timer and updates it by decreasing the time
    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 500) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                timeLeftInMilliseconds = 0;
            }
        }.start();

        timerRunning = true;
    }

    public void stopTimer() {
        countDownTimer.cancel();
        timerRunning = false;
    }

    public void updateTimer() {
        int minutes = (int) (timeLeftInMilliseconds / 1000) / 60;
        int seconds = (int) (timeLeftInMilliseconds / 1000) % 60;

        String timeLeftText = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        timerCountdownText.setText(timeLeftText);
    }

    private void resetTimer() {
        timeLeftInMilliseconds = startTiming;
        updateTimer();
    }
}
