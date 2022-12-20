package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class current_status extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_current_status);


        // Krunal Rathod:
        // From User Current Status to Main Screen
        final Button button_back_home = (Button) findViewById(R.id.button_status_back);

        button_back_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_to_home = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(back_to_home);
            }
        });
    }
}