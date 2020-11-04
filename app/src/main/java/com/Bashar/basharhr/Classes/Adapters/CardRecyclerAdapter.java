package com.Bashar.basharhr.Classes.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Bashar.basharhr.DataModels.Employees;
import com.Bashar.basharhr.R;
import com.Bashar.basharhr.SQLiteDatabase.MySQLiteDatabase;

import java.util.ArrayList;

public class CardRecyclerAdapter extends RecyclerView.Adapter<CardRecyclerAdapter.DataHolder> implements Filterable{

   // ArrayList<Employees> employeeListData;
    Context context;
    ArrayList<com.Bashar.basharhr.DataModels.Employees> employeesArrayList;
    ArrayList<com.Bashar.basharhr.DataModels.Employees> mArrayList;
    private MySQLiteDatabase sqLiteHelper;

    public CardRecyclerAdapter(Context context,
                               ArrayList<com.Bashar.basharhr.DataModels.Employees> employeesArrayList) {
        this.context = context;
        this.employeesArrayList = employeesArrayList;
      //  this.employeeListData = employeeListData;
        sqLiteHelper = new MySQLiteDatabase(context);
        this.mArrayList = employeesArrayList;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card_design, parent,false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DataHolder holder, int position) {
        final Employees employees = employeesArrayList.get(position);
        final String first_name = employees.getFirst_name();
        final String last_name = employees.getLast_name();
        final String father_name = employees.getFather_name();
        final String birth_date = employees.getBirth_date();
        final String gender = employees.getGender();
        final String email = employees.getEmail();
        final String country_code = employees.getCountry_code();
        final String phone = employees.getPhone();
        final String department = employees.getDepartment();

        //setting data
        //holder.nameTv.setText(first_name + " " + father_name + " " + last_name);
         //IM HERE KJASDKBAGJKLF;AFKDFKSJDDE KJASDKBAGJKLF;AFKDFKSJDD
        //IM HERE KJASDKBAGJKLF;AFKDFKSJDDE KJASDKBAGJKLF;AFKDFKSJDD
        //IM HERE KJASDKBAGJKLF;AFKDFKSJDDE KJASDKBAGJKLF;AFKDFKSJDD
        //IM HERE KJASDKBAGJKLF;AFKDFKSJDDE KJASDKBAGJKLF;AFKDFKSJDD
        //IM HERE KJASDKBAGJKLF;AFKDFKSJDDE KJASDKBAGJKLF;AFKDFKSJDD
        //IM HERE KJASDKBAGJKLF;AFKDFKSJDDE KJASDKBAGJKLF;AFKDFKSJDD
        //IM HERE KJASDKBAGJKLF;AFKDFKSJDDE KJASDKBAGJKLF;AFKDFKSJDD
        //IM HERE KJASDKBAGJKLF;AFKDFKSJDDE KJASDKBAGJKLF;AFKDFKSJDD
        //IM HERE KJASDKBAGJKLF;AFKDFKSJDDE KJASDKBAGJKLF;AFKDFKSJDD
        //IM HERE KJASDKBAGJKLF;AFKDFKSJDDE KJASDKBAGJKLF;AFKDFKSJDD
        //IM HERE KJASDKBAGJKLF;AFKDFKSJDDE KJASDKBAGJKLF;AFKDFKSJDD
        //IM HERE KJASDKBAGJKLF;AFKDFKSJDDE KJASDKBAGJKLF;AFKDFKSJDD

//        Employees employees = employeeListData.get(position);
//
//        holder.image.setImageResource(employees.getImage());
//        holder.title.setText(employees.getTitle());
//        holder.description.setText(employees.getDescription());
    }

    @Override
    public int getItemCount() {
        return employeeListData.size();
    }
    
    public static class DataHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, description;

        public DataHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.cardEmployeePicture);
            title = itemView.findViewById(R.id.cardEmployeeName);
            description = itemView.findViewById(R.id.cardEmployeeDescription);
        }


    }
}
