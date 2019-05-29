package com.example.blog.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.blog.Adapters.HomeRecAdapter;
import com.example.blog.Models.HomeRecItem;
import com.example.blog.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    List<HomeRecItem> arrOfItem;
    List<String> arrOfDesc;
    List<Integer> arrOfImg;
    List<String> arrOfDesc2;
    List<Integer> arrOfImg2;
    RecyclerView recyclerView;

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        HomeRecAdapter recAdapter = new HomeRecAdapter(getContext(), arrOfItem);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arrOfItem = new ArrayList<>();
        arrOfImg = new ArrayList<>();
        arrOfDesc = new ArrayList<>();
        arrOfImg2 = new ArrayList<>();
        arrOfDesc2 = new ArrayList<>();
        HomeRecItem item;

        for (int i = 0; i < 200; i++) {
            arrOfImg.add(R.mipmap.ic_launcher_round);
        }
        for (int i = 0; i < 200; i++) {
            arrOfDesc.add("Text....." + i + "...");
        }
        for (int i = 0; i < 200; i++) {
            arrOfImg2.add(R.mipmap.ic_launcher_round);
        }
        for (int i = 0; i < 200; i++) {
            arrOfDesc2.add("Text....." + i + "...");
        }
        for (int i = 0; i < 200; i++) {
            item = new HomeRecItem(arrOfImg.get(i), arrOfDesc.get(i), arrOfImg2.get(i), arrOfDesc2.get(i));
            arrOfItem.add(item);
        }
    }
}
