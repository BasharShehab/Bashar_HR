package com.Bashar.basharhr.Activities;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.Bashar.basharhr.R;

public class MyService extends Service {
    public MyService() {

    }
    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service Created!", Toast.LENGTH_SHORT).show();

        mediaPlayer = MediaPlayer.create(this, R.raw.elevatormusic);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

    }

    public void startMusic(){
        mediaPlayer.start();
        Toast.makeText(this, "Music Started", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDestroy(){
        mediaPlayer.stop();
        Toast.makeText(this, "Music Stopped", Toast.LENGTH_SHORT).show();
    }
}
