//code from https://www.youtube.com/watch?v=MDuGwI6P-X8&t=428s

package com.example.study;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.Locale;


public class pomodoro extends Fragment {

    // Text view variables
    public TextView timerCountdownText;
    public Button startCountdown;
    public Button button_Restart;
    public Button stop_Countdown;

    private CountDownTimer countDownTimer;
    private static final long startTiming = 60000; //10minutes
    private long timeLeftInMilliseconds = startTiming;

    private boolean timerRunning;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.pomodoro, container, false);

        timerCountdownText = (TextView) root.findViewById(R.id.timer_countdownText);
        startCountdown = (Button) root.findViewById(R.id.buttonStartCountdown); //start button
        button_Restart = (Button) root.findViewById(R.id.restart_countdown); //stop button
        stop_Countdown= (Button) root.findViewById(R.id.stopCountdown); //stop button

        startCountdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //this is to start or stop the timer
                if (timerRunning) {
                    stopTimer();
                } else {
                    startTimer();
                }
                //NavHostFragment.findNavController(FirstFragment.this.navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        stop_Countdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopTimer();
            }
        });

        button_Restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });


        return root;
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

        String timeleftText = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);


        timerCountdownText.setText(timeleftText);
    }

    private void resetTimer() {
        timeLeftInMilliseconds = startTiming;
        updateTimer();
    }


}
