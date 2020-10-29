package com.Bashar.basharhr.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.Bashar.basharhr.Classes.Adapters.CardHelperClass;
import com.Bashar.basharhr.Classes.Adapters.CardRecyclerAdapter;
import com.Bashar.basharhr.R;
import com.Bashar.basharhr.SQLiteDatabase.MySQLiteDatabase;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {

    private boolean doubleBackToExitPressedOnce;
    RecyclerView employeeRecycler;
    RecyclerView.Adapter adapter;
    MySQLiteDatabase sqliteHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);

        employeeRecycler = findViewById(R.id.recycler_employees);
        sqliteHelper = new MySQLiteDatabase(this);
        recyclerEmployee();
    }

    private void recyclerEmployee() {
        employeeRecycler.setHasFixedSize(true);
        employeeRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));

        ArrayList<CardHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new CardHelperClass(R.drawable.github,"github","asjdklasd"));
        featuredLocations.add(new CardHelperClass(R.drawable.githubcopy,"about","fdghhs"));
        featuredLocations.add(new CardHelperClass(R.drawable.logo_transparent,"added","asdhterv"));

        adapter = new CardRecyclerAdapter(featuredLocations);
        employeeRecycler.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pagemenu, menu);

        MenuItem item = menu.findItem(R.id.itemAddEmployee);
                item.setVisible(true);

        item = menu.findItem(R.id.itemRemoveEmployee);
            item.setVisible(true);

        item = menu.findItem(R.id.search_button);
            item.setVisible(true);

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
                return true;

            case R.id.startMusic:
                startService(new Intent(this, MyService.class));
                return true;

            case R.id.stopMusic:
                stopService(new Intent(this, MyService.class));
                return true;
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