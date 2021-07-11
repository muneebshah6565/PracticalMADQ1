package com.example.a18arid2979pq1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassHolder> {
    ArrayList classesNames;

    public ClassAdapter(ArrayList classesNames) {
        this.classesNames = classesNames;
    }

    @NonNull
    @Override
    public ClassHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.single_class_item, parent, false);
        ClassHolder classHolder = new ClassHolder(listItem);
        return classHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ClassHolder holder, int position) {
        holder.textView.setText(classesNames.get(position).toString());

        holder.catItem.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Bundle args=new Bundle();
                args.putString("brand",classesNames.get(position).toString());
                Intent intent=new Intent(v.getContext(),DetailActivity.class);
                intent.putExtra("className",classesNames.get(position).toString());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return classesNames.size();
    }

    public class ClassHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public MaterialCardView catItem;

        public ClassHolder(@NonNull View itemView) {
            super(itemView);
            this.textView=(TextView) itemView.findViewById(R.id.categoryName);
            catItem= (MaterialCardView) itemView.findViewById(R.id.item);
        }
    }
}
