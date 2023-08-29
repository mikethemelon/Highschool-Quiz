package com.example.test_11.monhoc;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_11.Ontap_Nguvan_Activity;
import com.example.test_11.R;
import com.example.test_11.slide.ScreenSlideActivity;
import com.example.test_11.slide.ScreenSlidePageFragment;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class OntapAdapter extends RecyclerView.Adapter<OntapAdapter.MyViewHolder> {

    Context context;
    ArrayList<Exam> newsArrayList;
    DiaLyFragment diaLyFragment;

    public OntapAdapter(Context context, ArrayList<Exam> newsArrayList) {

        this.context = context;
        this.newsArrayList = newsArrayList = newsArrayList;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Exam news = newsArrayList.get(position);
        holder.tvHeading.setText(news.heading);
        holder.titleImage.setImageResource(news.titleImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, Ontap_Nguvan_Activity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ShapeableImageView titleImage;
        TextView tvHeading;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleImage = itemView.findViewById(R.id.title_image);
            tvHeading = itemView.findViewById(R.id.tvHeading);
        }
    }
}