package com.Bashar.basharhr.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.Bashar.basharhr.R;

public class About extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
    }

    public void onClick(View view) {
        String gitHub = "https://github.com/basharBruh/BasharShehab";
        Uri gitHubUri = Uri.parse(gitHub);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, gitHubUri);
        startActivity(launchBrowser);
    }
}