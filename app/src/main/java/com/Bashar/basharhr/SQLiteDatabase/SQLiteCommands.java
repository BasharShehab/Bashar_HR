package com.Bashar.basharhr.SQLiteDatabase;

import android.provider.BaseColumns;

public class SQLiteCommands {

    public static final class Commands {

        private Commands() {
        }

        public static final int ADD_RECORD = 0;
        public static final int UPDATE_RECORD = 1;
        public static final String DML_TYPE = "DML-TYPE";
        public static final String UPDATE = "Update";
        public static final String Hire = "Hire";
        public static final String DELETE = "Dismiss";

        public static class HR_Admins_Table implements BaseColumns {
            public static final String TABLE_NAME = "HR_users";
            public static final String FIRST_NAME = "first_name";
            public static final String LAST_NAME = "last_name";
            public static final String HR_ADMIN_ID = "HR_Id";
            public static final String EMAIL = "email";
            public static final String USER_NAME = "username";
            public static final String PASSWORD = "password";
            public static final String COUNTRY_CODE = "country_code";
            public static final String GENDER = "gender";
            public static final String PHONE = "phone";
        }

        public static class Employees_Table implements BaseColumns {

            public static final String TABLE_NAME = "Employees";
            public static final String EMP_ID = "EMP_id";
            public static final String FIRST_NAME = "first_name";
            public static final String LAST_NAME = "last_name";
            public static final String FATHER_NAME = "father_name";
            public static final String PHONE = "Emp_phone";
            public static final String BIRTH_DATE = "emp_birth_date";
            public static final String DEPARTMENT = "Emp_department";
            public static final String COUNTRY_CODE = "country_code";
            public static final String GENDER = "gender";
            public static final String EMAIL = "Emp_Email";
        }
    }

}
