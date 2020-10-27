package com.Bashar.basharhr.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import com.Bashar.basharhr.R;
import java.io.IOException;
import java.util.Objects;

public class SplashScreen extends AppCompatActivity {
    Uri uri = Uri.parse("android.resource://com.Bashar.basharhr/"+ R.raw.splashsound);
    MediaPlayer music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.splashscreen);

        music = new MediaPlayer();
        music.setAudioAttributes(
                new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
        );
        try {
            music.setDataSource(getApplicationContext(),uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            music.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        music.start();
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    nextActivity();
                }
            }
        };
        timer.start();
    }

    public void nextActivity(){
        Intent intent = new Intent(this,LoginPage.class);
        startActivity(intent);
    }
    protected void onPause(){
        super.onPause();
        music.release();
        finish();
    }


}