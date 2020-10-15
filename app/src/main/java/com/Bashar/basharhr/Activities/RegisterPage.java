package com.Bashar.basharhr.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.Bashar.basharhr.DataModels.HR_Admins;
import com.Bashar.basharhr.R;
import com.Bashar.basharhr.SQLiteDatabase.MySQLiteDatabase;

import static com.Bashar.basharhr.Classes.NotificationChannels.Channel_2_ID;

public class RegisterPage extends AppCompatActivity implements View.OnClickListener{
    private EditText first_name, last_name, email, password, username, phone;
    private Spinner gender, countryCode;
    private Button registerButton;
    private NotificationManagerCompat manager;

    private MySQLiteDatabase sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerpage);

        gender = findViewById(R.id.HR_gender);
        ArrayAdapter<CharSequence> adapterGender = ArrayAdapter.createFromResource(this,R.array.genderSpinner, android.R.layout.simple_spinner_item);
        adapterGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapterGender);

        countryCode = findViewById(R.id.HR_SpinnerCountry);
        ArrayAdapter<CharSequence> adapterCountry = ArrayAdapter.createFromResource(this,R.array.spinnerCountry, android.R.layout.simple_spinner_item);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countryCode.setAdapter(adapterCountry);

        first_name = findViewById(R.id.HR_FirstName);
        last_name = findViewById(R.id.HR_lastname);
        username = findViewById(R.id.HR_userName);
        email = findViewById(R.id.HR_Email);
        password = findViewById(R.id.HR_password);
        phone = findViewById(R.id.HR_phone);

        registerButton = findViewById(R.id.RegButton);
        registerButton.setOnClickListener(this);
        sqLiteHelper = new MySQLiteDatabase(this);

        manager = NotificationManagerCompat.from(this);

    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.RegButton:
                if (
                        gender.getSelectedItem().toString().trim().equalsIgnoreCase("Gender") ||
                        countryCode.getSelectedItem().toString().trim().equalsIgnoreCase("Country") ||
                        first_name.getText().toString().trim().equalsIgnoreCase("") ||
                        last_name.getText().toString().trim().equalsIgnoreCase("") ||
                        username.getText().toString().trim().equalsIgnoreCase("") ||
                        email.getText().toString().trim().equalsIgnoreCase("") ||
                        password.getText().toString().trim().equalsIgnoreCase("") ||
                        phone.getText().toString().trim().equalsIgnoreCase("")
                ){
                    Toast.makeText(this,getString(R.string.fill_space),Toast.LENGTH_SHORT).show();
                }
                else {
                        HR_Admins admin = new HR_Admins(
                                username.getText().toString().trim(),
                                first_name.getText().toString().trim(),
                                last_name.getText().toString().trim(),
                                email.getText().toString().trim(),
                                password.getText().toString().trim(),
                                phone.getText().toString().trim(),
                                gender.getSelectedItem().toString().trim(),
                                countryCode.getSelectedItem().toString().trim());
                    try{
                        sqLiteHelper.insert(admin);
                        Toast.makeText(this, R.string.HR_added_success, Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e){
                        Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    String HR_Admin_Added_Title = "Admin added successfully";
                    String HR_Admin_Added_Message = "New admin with username " + username.getText().toString().trim() + " has been added!";

                    Notification notificationAdd = new NotificationCompat.Builder(this, Channel_2_ID)
                            .setSmallIcon(R.drawable.ic_addedemployee)
                            .setContentTitle(HR_Admin_Added_Title)
                            .setContentText(HR_Admin_Added_Message)
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .build();

                    manager.notify(2,notificationAdd);

                    Toast.makeText(this,"HR Admin Added!",Toast.LENGTH_SHORT).show();
                    first_name.getText().clear();
                    last_name.getText().clear();
                    username.getText().clear();
                    email.getText().clear();
                    password.getText().clear();
                    gender.setSelection(0);
                    countryCode.setSelection(0);
                    phone.getText().clear();
                }
        }
    }
}