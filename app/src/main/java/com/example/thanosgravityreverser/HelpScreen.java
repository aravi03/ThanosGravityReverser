package com.example.thanosgravityreverser;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HelpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.lefttoright, R.anim.lefttoright);
        setContentView(R.layout.activity_help_screen);

        final MediaPlayer m2= (MediaPlayer) MediaPlayer.create(this,R.raw.game_track);

        m2.start();
    }
}
