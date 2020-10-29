package com.Bashar.basharhr.Classes.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Bashar.basharhr.R;

import java.util.ArrayList;

public class CardRecyclerAdapter extends RecyclerView.Adapter<CardRecyclerAdapter.DataHolder> {

    ArrayList<CardHelperClass> featuredLocation;

    public CardRecyclerAdapter(ArrayList<CardHelperClass> featuredLocation) {
        this.featuredLocation = featuredLocation;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card_design, parent,false);
        DataHolder dataHolder = new DataHolder(view);
        return dataHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {
        CardHelperClass cardHelperClass = featuredLocation.get(position);

        holder.image.setImageResource(cardHelperClass.getImage());
        holder.title.setText(cardHelperClass.getTitle());
        holder.description.setText(cardHelperClass.getDescription());
    }

    @Override
    public int getItemCount() {
        return featuredLocation.size();
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
