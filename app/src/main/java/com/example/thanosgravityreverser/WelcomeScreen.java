package com.example.thanosgravityreverser;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {


    TextView t;
    Button b1,b2;
    public void openActivity2()
    {
        Intent intent;
        intent = new Intent(this,MainActivity.class);
        startActivity(intent);


    }
    public void openActivity3()
    {
        Intent intent;
        intent= new Intent(this,HelpScreen.class);
        startActivity(intent);
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        final MediaPlayer m2= (MediaPlayer) MediaPlayer.create(this,R.raw.welcome_track);
        m2.start();

        t=findViewById(R.id.textView);
        b1=findViewById(R.id.button2);
        b2=findViewById(R.id.button);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.blink_anim);
        b1.startAnimation(animation);
        Animation animation1= AnimationUtils.loadAnimation(this,R.anim.rotate);
        t.startAnimation(animation1);

        if(m2.isPlaying()==false) {
            final MediaPlayer m5= (MediaPlayer) MediaPlayer.create(this,R.raw.welcome_track);
             m5.start();
        }
            b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                m2.stop();
                openActivity2();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openActivity3();
            }
        });



    }

}
