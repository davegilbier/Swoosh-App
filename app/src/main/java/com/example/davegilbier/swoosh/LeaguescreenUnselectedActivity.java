package com.example.davegilbier.swoosh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.davegilbier.swoosh.R.styleable.CompoundButton;

public class LeaguescreenUnselectedActivity extends AppCompatActivity {

    private Button mensBtn;
    private Button womensBtn;
    private Button coedBtn;
    private Button nextBtn;
    private TextView mTvReplyHolder;
    private TextView mTvReply;
    Intent intent;
    public static final String KEY_SEND_MESSAGE = "key-sent-message";
    public static final int REQ_CODE_REPLY_MESSAGE = 1111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaguescreen_unselected);
        findViews();
    }

    private void findViews() {
        mensBtn = (Button) findViewById(R.id.mens);
        womensBtn = (Button) findViewById(R.id.womens);
        coedBtn = (Button) findViewById(R.id.coed);
        nextBtn = (Button) findViewById(R.id.next);
        mTvReplyHolder = (TextView) findViewById(R.id.replyHolder);
        mTvReply = (TextView) findViewById(R.id.reply);

    }

    public void gomens(View view) {
        if (mensBtn.getAlpha() != nextBtn.getAlpha()) {
            mensBtn.setAlpha(0.8f);
            womensBtn.setAlpha(0.4f);
            coedBtn.setAlpha(0.4f);
            nextBtn.setAlpha(0.8f);
            nextBtn.setEnabled(true);
        } else if (mTvReplyHolder.getText().toString().isEmpty()) {
            mensBtn.setAlpha(0.8f);
            womensBtn.setAlpha(0.8f);
            coedBtn.setAlpha(0.8f);
            nextBtn.setAlpha(0.4f);
            nextBtn.setEnabled(false);
        }
    }

    public void gowomens(View view) {
        if (womensBtn.getAlpha() != nextBtn.getAlpha()) {
            mensBtn.setAlpha(0.4f);
            womensBtn.setAlpha(0.8f);
            coedBtn.setAlpha(0.4f);
            nextBtn.setAlpha(0.4f);
            nextBtn.setEnabled(true);
        } else if (mTvReplyHolder.getText().toString().isEmpty()) {
            mensBtn.setAlpha(0.8f);
            womensBtn.setAlpha(0.8f);
            coedBtn.setAlpha(0.8f);
            nextBtn.setAlpha(0.4f);
            nextBtn.setEnabled(false);
        }
    }


    public void gocoed(View view) {
        if (coedBtn.getAlpha() != nextBtn.getAlpha()) {
            mensBtn.setAlpha(0.4f);
            womensBtn.setAlpha(0.4f);
            coedBtn.setAlpha(0.8f);
            nextBtn.setAlpha(0.8f);
            nextBtn.setEnabled(true);

        } else if (mTvReplyHolder.getText().toString().isEmpty()) {
            mTvReply.setAlpha(0.8f);
            womensBtn.setAlpha(0.8f);
            coedBtn.setAlpha(0.8f);
            nextBtn.setAlpha(0.4f);
            nextBtn.setEnabled(false);
        }
    }


    public void nextNow(View v) {
        Intent skillIntent = new Intent(v.getContext(), Skills.class);
        startActivityForResult(skillIntent, REQ_CODE_REPLY_MESSAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQ_CODE_REPLY_MESSAGE) {
                String replyMsg = data.getStringExtra(Skills.KEY_REPLY_MESSAGE);
                mTvReplyHolder.setVisibility(View.VISIBLE);
                mTvReply.setVisibility(View.VISIBLE);
                mTvReply.setText(replyMsg);
                nextBtn.setVisibility(View.GONE);
                if (mensBtn.getAlpha() != 0.8f)
                    mensBtn.setEnabled(false);
                if (womensBtn.getAlpha() != 0.8f)
                    womensBtn.setEnabled(false);
                if (coedBtn.getAlpha() != 0.8f)
                    coedBtn.setEnabled(false);
            }
        }
    }
}
