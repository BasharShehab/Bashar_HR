package com.Bashar.basharhr.Activities;

import android.app.Notification;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.Bashar.basharhr.DataModels.Employees;
import com.Bashar.basharhr.R;
import com.Bashar.basharhr.SQLiteDatabase.MySQLiteDatabase;

import static com.Bashar.basharhr.Classes.NotificationChannels.Channel_1_ID;

public class AddingEmployee extends AppCompatActivity implements View.OnClickListener {

    private EditText firstName, lastName, birth_date,  emailAddress, department, phoneNum, fatherName;
    private Spinner countryCode, gender;
    private Button add;

    private MySQLiteDatabase sqLiteHelper;

    private Uri soundUri = Uri.parse("android.resource://com.Bashar.basharhr/"+ R.raw.splashsound);

    private NotificationManagerCompat manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addingemployee);

        gender = findViewById(R.id.EmpSpinnerGender);
        ArrayAdapter<CharSequence> adapterAddEmp = ArrayAdapter.createFromResource(this,R.array.genderSpinner, android.R.layout.simple_spinner_item);
        adapterAddEmp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapterAddEmp);

        countryCode = findViewById(R.id.EmpSpinnerCountry);
        ArrayAdapter<CharSequence> adapterCountry = ArrayAdapter.createFromResource(this,R.array.spinnerCountry, android.R.layout.simple_spinner_item);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countryCode.setAdapter(adapterCountry);

        add = findViewById(R.id.add);
        add.setOnClickListener(this);

        firstName = findViewById(R.id.AddEmpFirstName);
        lastName = findViewById(R.id.AddEmpLastName);
        birth_date = findViewById(R.id.emp_birth_date);
        phoneNum = findViewById(R.id.Emp_phone);
        emailAddress = findViewById(R.id.Emp_Email);
        department = findViewById(R.id.Emp_department);
        countryCode = findViewById(R.id.EmpSpinnerCountry);
        gender = findViewById(R.id.EmpSpinnerGender);
        fatherName = findViewById(R.id.EmpFatherName);

        manager = NotificationManagerCompat.from(this);

        sqLiteHelper = new MySQLiteDatabase(this);
    }

    @Override
    public void onClick(View v)  {
        switch(v.getId()) {
            case R.id.add:
                if (firstName.getText().toString().trim().equalsIgnoreCase("") ||
                        lastName.getText().toString().trim().equalsIgnoreCase("") ||
                        birth_date.getText().toString().trim().equalsIgnoreCase("") ||
                        phoneNum.getText().toString().trim().equalsIgnoreCase("") ||
                        emailAddress.getText().toString().trim().equalsIgnoreCase("") ||
                        fatherName.getText().toString().trim().equalsIgnoreCase("") ||
                        gender.getSelectedItem().toString().equalsIgnoreCase("Gender") ||
                        countryCode.getSelectedItem().toString().equalsIgnoreCase("Country") ||
                        department.getText().toString().trim().equalsIgnoreCase("")
                ) {
                        Toast.makeText(this, R.string.fill_space, Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        Employees employees = new Employees(
                                firstName.getText().toString().trim(),
                                lastName.getText().toString().trim(),
                                fatherName.getText().toString().trim(),
                                birth_date.getText().toString().trim(),
                                gender.getSelectedItem().toString().trim(),
                                emailAddress.getText().toString().trim(),
                                countryCode.getSelectedItem().toString().trim(),
                                phoneNum.getText().toString().trim(),
                                department.getText().toString().trim());

                        sqLiteHelper.insert(employees);
                        Toast.makeText(this,getString(R.string.emp_add_success),Toast.LENGTH_SHORT).show();

                    }
                    catch (Exception e){
                        Toast.makeText(this,"ERROR "+e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    String addEmpNotifTitle = getString(R.string.emp_add_success);
                    String addEmpNotifMessage = getString(R.string.employee_string) +
                            firstName.getText().toString().trim() +
                            lastName.getText().toString().trim() +
                            getString(R.string.has_been_added);

                    Notification notificationAdd = new NotificationCompat.Builder(this, Channel_1_ID)
                            .setSmallIcon(R.drawable.ic_addedemployee)
                            .setContentTitle(addEmpNotifTitle)
                            .setContentText(addEmpNotifMessage)
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .setSound(soundUri)
                            .build();

                    manager.notify(1, notificationAdd);

                    Toast.makeText(this, "Employee Added!", Toast.LENGTH_SHORT).show();
                    firstName.getText().clear();
                    lastName.getText().clear();
                    birth_date.getText().clear();
                    phoneNum.getText().clear();
                    emailAddress.getText().clear();
                    department.getText().clear();
                    gender.setSelection(0);
                    countryCode.setSelection(0);
                }
        }
    }
}