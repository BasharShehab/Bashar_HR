package com.Bashar.basharhr.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.Bashar.basharhr.R;

public class MainPage extends AppCompatActivity {
    private boolean doubleBackToExitPressedOnce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pagemenu, menu);

        MenuItem.OnActionExpandListener onActionExpandListener = new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                Toast.makeText(MainPage.this,"place holder until I make db of employees",Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                Toast.makeText(MainPage.this,"COLLAPSED. place holder until I make db of employees",Toast.LENGTH_SHORT).show();
                return false;
            }
        };
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemAddEmployee:
                Intent addEmp = new Intent (this, AddingEmployee.class);
                startActivity(addEmp);
                return true;
            case R.id.itemRemoveEmployee:
                Toast.makeText(this, "Placeholder until I make remove employee activity", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.about:
                Intent moveToAbout = new Intent(this, About.class);
                startActivity(moveToAbout);
                return true;
            case R.id.search_button:

            default:
                return super.onOptionsItemSelected(item);
        }

    }
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finishAffinity();
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}