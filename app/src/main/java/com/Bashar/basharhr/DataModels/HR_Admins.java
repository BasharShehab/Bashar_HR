package com.Bashar.basharhr.DataModels;

public class HR_Admins {
    String HR_ID, user_name, first_name, last_name, email, password, phone, country_code, gender;

    public HR_Admins() {
    }
    public HR_Admins(String user_name, String first_name, String last_name,
                     String email, String password, String phone,
                     String gender, String country_code) {
        this.user_name = user_name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.country_code = country_code;
        this.phone = phone;
    }
    public HR_Admins(String HR_ID, String user_name, String first_name, String last_name, String email, String password, String phone, String gender, String country_code) {

        this.HR_ID = HR_ID;
        this.user_name = user_name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.country_code = country_code;
        this.phone = phone;
    }

    public String getHR_ID() {
        return HR_ID;
    }

    public void setHR_ID(String HR_ID) {
        this.HR_ID = HR_ID;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
