package com.example.thanosgravityreverser;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Stone s;
    private Handler handler=new Handler();
    private final static long interval=30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_main);

        final MediaPlayer m3= (MediaPlayer) MediaPlayer.create(this,R.raw.game_track);

        m3.start();


        s=new Stone(this);

        setContentView(s);
        Timer timer= new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                s.invalidate();

            }

        },0,interval);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN: {

                final MediaPlayer m1= (MediaPlayer) MediaPlayer.create(this,R.raw.click_sound);

                m1.start();



                break;
            }
//                case MotionEvent.ACTION_UP: {
//                touch=false;
//                    break;
//                }
        }

        return super.onTouchEvent(event);
    }
}
