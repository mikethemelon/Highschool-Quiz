package com.example.test_11.monhoc;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_11.MainActivity;
import com.example.test_11.R;
import com.example.test_11.slide.ScreenSlideActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NguVanFragment extends Fragment {

    private ArrayList<Exam> newsArrayList;
    private String[] newsHeading;
    private int[] imageResourceID;
    private RecyclerView recyclerview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nguvan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();

        recyclerview = view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        ExamAdapter examAdapter = new ExamAdapter(getContext(),newsArrayList);
        recyclerview.setAdapter(examAdapter);
        examAdapter.notifyDataSetChanged();
    }

    private void dataInitialize() {

        newsArrayList = new ArrayList<>();

        newsHeading = new String[]{
                getString(R.string.head_1),
                getString(R.string.head_2),
                getString(R.string.head_3),
                getString(R.string.head_4),
                getString(R.string.head_5),
                getString(R.string.head_6),
                getString(R.string.head_7),
                getString(R.string.head_8),
                getString(R.string.head_9),
                getString(R.string.head_10),

        };

        imageResourceID = new int[]{
                R.drawable.exam2,
                R.drawable.exam2,
                R.drawable.exam2,
                R.drawable.exam2,
                R.drawable.exam2,
                R.drawable.exam2,
                R.drawable.exam2,
                R.drawable.exam2,
                R.drawable.exam2,
                R.drawable.exam2,

        };

        for (int i = 0; i< newsHeading.length; i++){

            Exam news = new Exam(newsHeading[i], imageResourceID[i]);
            newsArrayList.add(news);

        }

        
    }

}
