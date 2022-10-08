package com.example.manageinfomationoffoodanddrink;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChildAdapter  extends RecyclerView.Adapter<ChildAdapter.ViewHolder>{

    List<ChildModelClass> childModelClassList;
    Context context;

    public ChildAdapter(List<ChildModelClass> childModelClassList, Context context) {
        this.childModelClassList = childModelClassList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChildAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.child_rv_layout, null,false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.iv_child_image.setImageResource(childModelClassList.get(position).image);
        holder.tv_child_name.setText(childModelClassList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity) view.getContext();
                DetailFragment detailFragment=new DetailFragment();
                activity.getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView,detailFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return childModelClassList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_child_image;
        TextView tv_child_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_child_image=itemView.findViewById(R.id.iv_child_item);
            tv_child_name=itemView.findViewById(R.id.tv_child_item);

        }
    }
}
