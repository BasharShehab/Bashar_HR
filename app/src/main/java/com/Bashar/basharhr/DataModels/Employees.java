package com.Bashar.basharhr.DataModels;

public class Employees {
    private String EMP_id, first_name, last_name, father_name, birth_date, gender, email, country_code, phone, department;

    public Employees() {
    }

    public Employees(String first_name, String last_name,
                     String father_name, String birth_date,
                     String gender, String email, String country_code, String phone, String department) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.father_name = father_name;
        this.birth_date = birth_date;
        this.gender = gender;
        this.email = email;
        this.country_code = country_code;
        this.phone = phone;
        this.department = department;
    }

    public Employees(String EMP_id, String first_name, String last_name,
                     String father_name, String birth_date,
                     String gender, String email, String country_code, String phone, String department) {
        this.EMP_id = EMP_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.father_name = father_name;
        this.birth_date = birth_date;
        this.gender = gender;
        this.email = email;
        this.country_code = country_code;
        this.phone = phone;
        this.department = department;
    }

    public String getEMP_id() {
        return EMP_id;
    }

    public void setEMP_id(String EMP_id) {
        this.EMP_id = EMP_id;
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

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
