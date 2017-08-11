package com.example.davegilbier.swoosh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {

        startButton = (Button) findViewById(R.id.startBtn);
    }

    public void startNow(View view) {

        Intent intent = new Intent(this, LeaguescreenUnselectedActivity.class);
        startActivity(intent);

    }



}

