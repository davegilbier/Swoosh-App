package com.example.davegilbier.swoosh;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Skills extends AppCompatActivity {

    private Button ballerbtn;
    private Button beginnerbtn;
    private Button finishbtn;

    public static final String KEY_REPLY_MESSAGE = "key-reply-message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);
        findViews();
    }

    private void findViews() {
        ballerbtn= (Button) findViewById(R.id.baller);
        beginnerbtn=  (Button) findViewById(R.id.beginner);
        finishbtn=  (Button) findViewById(R.id.finbtn);
    }

    public void gobeginner(View view) {
        if(beginnerbtn.getAlpha()!=finishbtn.getAlpha()) {
            beginnerbtn.setAlpha(0.8f);
            ballerbtn.setAlpha(0.4f);
            finishbtn.setAlpha(0.8f);
            finishbtn.setEnabled(true);
            finishbtn.setText("Finish");
        }
        else{
            beginnerbtn.setAlpha(0.8f);
            ballerbtn.setAlpha(0.8f);
            finishbtn.setAlpha(0.4f);
            finishbtn.setEnabled(false);
            finishbtn.setText("Finish");
        }
    }

    public void goballer(View view) {
        if(ballerbtn.getAlpha()!=finishbtn.getAlpha()) {
            beginnerbtn.setAlpha(0.4f);
            ballerbtn.setAlpha(0.8f);
            finishbtn.setAlpha(0.8f);
            finishbtn.setEnabled(true);
            finishbtn.setText("Finish");
        }
        else{
           beginnerbtn.setAlpha(0.8f);
            ballerbtn.setAlpha(0.8f);
           finishbtn.setAlpha(0.4f);
            finishbtn.setEnabled(false);
            finishbtn.setText("Finish");
        }

    }
    public void gofinish(View view) {
        String reply = "";
        if(beginnerbtn.getAlpha()==0.8f) {
            reply = beginnerbtn.getText().toString();
        }
        else if(ballerbtn.getAlpha()==0.8f) {
            reply = ballerbtn.getText().toString();
        }
        Intent data = new Intent();
        data.putExtra(KEY_REPLY_MESSAGE, reply);
        setResult(Activity.RESULT_OK, data);
        finish();

    }





}
