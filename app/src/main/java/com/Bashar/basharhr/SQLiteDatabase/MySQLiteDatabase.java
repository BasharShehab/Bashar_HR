package com.Bashar.basharhr.SQLiteDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.Bashar.basharhr.DataModels.Employees;
import com.Bashar.basharhr.DataModels.HR_Admins;

import java.util.ArrayList;


public class MySQLiteDatabase extends SQLiteOpenHelper {

    public static final String DB_NAME = "ALL_EMPLOYEES";
    public static final int DB_VERSION = 4;

    public static final String Create_HR_Table =
            "CREATE TABLE IF NOT EXISTS " +
            SQLiteCommands.Commands.HR_Admins_Table.TABLE_NAME + "(" +
            SQLiteCommands.Commands.HR_Admins_Table.HR_ADMIN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            SQLiteCommands.Commands.HR_Admins_Table.FIRST_NAME + " TEXT," +
            SQLiteCommands.Commands.HR_Admins_Table.LAST_NAME + " TEXT," +
            SQLiteCommands.Commands.HR_Admins_Table.EMAIL + " TEXT," +
            SQLiteCommands.Commands.HR_Admins_Table.USER_NAME +" TEXT," +
            SQLiteCommands.Commands.HR_Admins_Table.COUNTRY_CODE + " INTEGER," +
            SQLiteCommands.Commands.HR_Admins_Table.PHONE + " INTEGER," +
            SQLiteCommands.Commands.HR_Admins_Table.GENDER + " TEXT," +
            SQLiteCommands.Commands.HR_Admins_Table.PASSWORD + " TEXT);";

    public static final String Create_EMP_Table =
            "CREATE TABLE IF NOT EXISTS " +
            SQLiteCommands.Commands.Employees_Table.TABLE_NAME + "(" +
            SQLiteCommands.Commands.Employees_Table.EMP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            SQLiteCommands.Commands.Employees_Table.FIRST_NAME + " TEXT," +
            SQLiteCommands.Commands.Employees_Table.LAST_NAME + " TEXT," +
            SQLiteCommands.Commands.Employees_Table.FATHER_NAME + " TEXT, " +
            SQLiteCommands.Commands.Employees_Table.COUNTRY_CODE + " INTEGER," +
            SQLiteCommands.Commands.Employees_Table.PHONE + " INTEGER," +
            SQLiteCommands.Commands.Employees_Table.EMAIL + " TEXT," +
            SQLiteCommands.Commands.Employees_Table.BIRTH_DATE + " TEXT," +
            SQLiteCommands.Commands.Employees_Table.GENDER + " TEXT," +
            SQLiteCommands.Commands.Employees_Table.DEPARTMENT + " TEXT);";

    public MySQLiteDatabase(Context context) {

        super(context, DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(android.database.sqlite.SQLiteDatabase db) {
        db.execSQL(Create_EMP_Table);
        db.execSQL(Create_HR_Table);
    }

    @Override
    public void onUpgrade(android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL ( "DROP TABLE IF EXISTS " + SQLiteCommands.Commands.HR_Admins_Table.TABLE_NAME);
        db.execSQL( "DROP TABLE IF EXISTS " + SQLiteCommands.Commands.Employees_Table.TABLE_NAME);
        onCreate(db);
    }

    public boolean checkIfExists (String Username) {
        String[] columns = {SQLiteCommands.Commands.HR_Admins_Table.USER_NAME};
        SQLiteDatabase db = getWritableDatabase();
        String selection =
                SQLiteCommands.Commands.HR_Admins_Table.USER_NAME +"=?";
        String[] selectionArgs = {Username};
        Cursor cursor = db.query(SQLiteCommands.Commands.HR_Admins_Table.TABLE_NAME,columns, selection, selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }

    public ArrayList<Employees> haveAllEmployees(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(SQLiteCommands.Commands.Employees_Table.TABLE_NAME,null,null,null,null,null,null,null);
        ArrayList<Employees> employees = new ArrayList<>();
        Employees contact;
        if (cursor.getCount() > 0){
            for (int i = 0; i< cursor.getCount(); i++){
                cursor.moveToNext();
                contact = new Employees();
                contact.setEMP_id(cursor.getString(0));
                contact.setFirst_name(cursor.getString(1));
                contact.setLast_name(cursor.getString(2));
                contact.setFather_name(cursor.getString(3));
                contact.setCountry_code(cursor.getString(4));
                contact.setPhone(cursor.getString(5));
                contact.setEmail(cursor.getString(6));
                contact.setBirth_date(cursor.getString(7));
                contact.setGender(cursor.getString(8));
                contact.setDepartment(cursor.getString(9));

                employees.add(contact);
            }
        }
        cursor.close();
        db.close();
        return employees;
    }

    public void deleteRecord (Employees toDismiss) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(SQLiteCommands.Commands.Employees_Table.TABLE_NAME,
                toDismiss.getEMP_id() + "=?",
                new String[]{String.valueOf(toDismiss.getEMP_id())});
        db.close();
    }

    //remember when you come back EmpDataModel is Employees.
    // Contact is SQLiteCommands.Commands

    public void insert (Employees employees) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put (SQLiteCommands.Commands.Employees_Table.FIRST_NAME,
                employees.getFirst_name() );
        values.put(SQLiteCommands.Commands.Employees_Table.LAST_NAME,
                employees.getLast_name() );
        values.put(SQLiteCommands.Commands.Employees_Table.FATHER_NAME,
                employees.getFather_name() );
        values.put(SQLiteCommands.Commands.Employees_Table.COUNTRY_CODE,
                employees.getCountry_code() );
        values.put(SQLiteCommands.Commands.Employees_Table.PHONE,
                employees.getPhone() );
        values.put(SQLiteCommands.Commands.Employees_Table.EMAIL,
                employees.getEmail() );
        values.put(SQLiteCommands.Commands.Employees_Table.DEPARTMENT,
                employees.getDepartment() );
        values.put(SQLiteCommands.Commands.Employees_Table.BIRTH_DATE,
                employees.getBirth_date() );
        values.put(SQLiteCommands.Commands.Employees_Table.GENDER,
                employees.getGender() );

        db.insert(SQLiteCommands.Commands.Employees_Table.TABLE_NAME, null,values);
        db.close();
    }
    public void insert(HR_Admins admin){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put (SQLiteCommands.Commands.HR_Admins_Table.FIRST_NAME,
                admin.getFirst_name() );
        contentValues.put(SQLiteCommands.Commands.HR_Admins_Table.LAST_NAME,
                admin.getLast_name() );
        contentValues.put(SQLiteCommands.Commands.HR_Admins_Table.USER_NAME,
                admin.getUser_name() );
        contentValues.put(SQLiteCommands.Commands.HR_Admins_Table.COUNTRY_CODE,
                admin.getCountry_code() );
        contentValues.put(SQLiteCommands.Commands.HR_Admins_Table.PHONE,
                admin.getPhone() );
        contentValues.put(SQLiteCommands.Commands.HR_Admins_Table.EMAIL,
                admin.getEmail() );
        contentValues.put(SQLiteCommands.Commands.HR_Admins_Table.GENDER,
                admin.getGender() );
        contentValues.put(SQLiteCommands.Commands.HR_Admins_Table.PASSWORD,
                admin.getPassword() );

        db.insert(SQLiteCommands.Commands.HR_Admins_Table.TABLE_NAME, null,contentValues);
        db.close();
    }
    public void updateEmpInfo(Employees employees){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put (SQLiteCommands.Commands.Employees_Table.FIRST_NAME,
                employees.getFirst_name() );
        values.put(SQLiteCommands.Commands.Employees_Table.LAST_NAME,
                employees.getLast_name() );
        values.put(SQLiteCommands.Commands.Employees_Table.FATHER_NAME,
                employees.getFather_name() );
        values.put(SQLiteCommands.Commands.Employees_Table.COUNTRY_CODE,
                employees.getCountry_code() );
        values.put(SQLiteCommands.Commands.Employees_Table.PHONE,
                employees.getPhone() );
        values.put(SQLiteCommands.Commands.Employees_Table.EMAIL,
                employees.getEmail() );
        values.put(SQLiteCommands.Commands.Employees_Table.DEPARTMENT,
                employees.getDepartment() );
        values.put(SQLiteCommands.Commands.Employees_Table.BIRTH_DATE,
                employees.getBirth_date() );
        values.put(SQLiteCommands.Commands.Employees_Table.GENDER,
                employees.getGender() );

        db.update(SQLiteCommands.Commands.Employees_Table.TABLE_NAME, values,
                SQLiteCommands.Commands.Employees_Table.EMP_ID + " =?",
                new String[] { (employees.getEMP_id())});
        db.close();
    }


    public boolean checkLogin (String username, String password){
        String[] columns = {SQLiteCommands.Commands.HR_Admins_Table.USER_NAME};
        SQLiteDatabase db = getWritableDatabase();
        String selection = SQLiteCommands.Commands.HR_Admins_Table.USER_NAME +
                " = ?" + " and " + SQLiteCommands.Commands.HR_Admins_Table.PASSWORD +
                " = ? ";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(SQLiteCommands.Commands.HR_Admins_Table.TABLE_NAME, columns, selection,
                selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }

    public ArrayList<Employees> listContacts(){
        String sql = "SELECT * FROM " + SQLiteCommands.Commands.Employees_Table.TABLE_NAME+";";
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Employees> storeContacts = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                String EMP_ID = (cursor.getString(0));
                String FirstName = (cursor.getString(1));
                String LastName = (cursor.getString(2));
                String FatherName = (cursor.getString(3));
                String CountryCode = (cursor.getString(4));
                String Phone = (cursor.getString(5));
                String Email = (cursor.getString(6));
                String BirthDate = (cursor.getString(7));
                String Gender = (cursor.getString(8));
                String Department = (cursor.getString(9));

                storeContacts.add(new Employees(EMP_ID, FirstName, LastName, FatherName, CountryCode, Phone, Email, BirthDate, Gender, Department));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return storeContacts;
    }

public Employees findContacts(String name){
        String query = "SELECT * FROM " +
                SQLiteCommands.Commands.Employees_Table.TABLE_NAME + " WHERE " +
                SQLiteCommands.Commands.Employees_Table.FIRST_NAME + " = " + name + " OR " +
                SQLiteCommands.Commands.Employees_Table.LAST_NAME + " = " + name ;

        SQLiteDatabase db = this.getWritableDatabase();
        Employees contacts = null;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            String EMP_ID = (cursor.getString(0));
            String FirstName = (cursor.getString(1));
            String LastName = (cursor.getString(2));
            String FatherName = (cursor.getString(3));
            String CountryCode = (cursor.getString(4));
            String Phone = (cursor.getString(5));
            String Email = (cursor.getString(6));
            String BirthDate = (cursor.getString(7));
            String Gender = (cursor.getString(8));
            String Department = (cursor.getString(9));

            contacts = new Employees(EMP_ID,FirstName,LastName,FatherName,CountryCode,Phone,Email,BirthDate,Gender,Department);
        }

        cursor.close();
        db.close();
        return contacts;
    }

    public void deleteContact(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(SQLiteCommands.Commands.Employees_Table.TABLE_NAME,
      SQLiteCommands.Commands.Employees_Table.EMP_ID + " =?",
                new String[] { String.valueOf(id)});
    }
}

