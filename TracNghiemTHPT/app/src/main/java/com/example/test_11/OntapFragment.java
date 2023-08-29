package com.example.test_11;


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
import com.example.test_11.monhoc.Exam;
import com.example.test_11.monhoc.ExamAdapter;
import com.example.test_11.monhoc.OntapAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OntapFragment extends Fragment {

    private ArrayList<Exam> newsArrayList;
    private String[] newsHeading;
    private int[] imageResourceID;
    private RecyclerView recyclerview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ontap, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();

        recyclerview = view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        OntapAdapter ontapAdapter = new OntapAdapter(getContext(),newsArrayList);
        recyclerview.setAdapter(ontapAdapter);
        ontapAdapter.notifyDataSetChanged();
    }

    private void dataInitialize() {

        newsArrayList = new ArrayList<>();

        newsHeading = new String[]{
                getString(R.string.head_11),
                getString(R.string.head_12),
                getString(R.string.head_13),

        };

        imageResourceID = new int[]{
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
