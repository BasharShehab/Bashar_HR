package com.Bashar.basharhr.Classes;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class NotificationChannels extends Application {
    public static final String Channel_1_ID = "AddEmployeeChannel";
    public static final String Channel_2_ID = "Registration Channel";
    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }


    private void createNotificationChannels() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager manager = getSystemService(NotificationManager.class);
            NotificationChannel addingEmployeeChannel = new NotificationChannel(
                    Channel_1_ID, "Adding Employee",
                    NotificationManager.IMPORTANCE_HIGH
            );
            addingEmployeeChannel.setDescription("Channel to notify when employee is added.");
            manager.createNotificationChannel(addingEmployeeChannel);

            NotificationChannel regNewHRAdmin = new NotificationChannel(
                    Channel_2_ID, "Registering New HR Admin",
                    NotificationManager.IMPORTANCE_HIGH
            );
            regNewHRAdmin.setDescription("Channel to notify when new HR Admin is added.");
                    manager.createNotificationChannel(regNewHRAdmin);
        }

    }
}
