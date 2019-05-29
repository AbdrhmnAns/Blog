package com.example.blog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.blog.Adapters.ArtRecAdapter;
import com.example.blog.Models.ArtRecItem;
import com.example.blog.Models.DescArtRecItem;
import com.example.blog.Models.ImgArtRecItem;

import java.util.ArrayList;
import java.util.List;

public class ArtActivity extends AppCompatActivity {
    List<ArtRecItem> arrOfArtRecItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art);

        arrOfArtRecItem = new ArrayList<>();

        ArtRecItem artRecItem1 = new ImgArtRecItem(R.mipmap.ic_launcher_round);
        arrOfArtRecItem.add(artRecItem1);
        ArtRecItem artRecItem2 = new DescArtRecItem("1111111111111111111TEST, TEST, TEST, T" +
                "EST, TEST, TEST, TEST, TEST, TEST, TEST");
        arrOfArtRecItem.add(artRecItem2);
        ArtRecItem artRecItem4 = new DescArtRecItem("222222222222222222222222TEST, TEST, TEST, T" +
                "EST, TEST, TEST, TEST, TEST, TEST, TEST");
        arrOfArtRecItem.add(artRecItem4);
        ArtRecItem artRecItem3 = new DescArtRecItem("333333333333333333333TEST, TEST, TEST, T" +
                "EST, TEST, TEST, TEST, TEST, TEST, TEST");
        arrOfArtRecItem.add(artRecItem3);
        ArtRecItem artRecItem5 = new ImgArtRecItem(R.mipmap.ic_launcher_round);
        arrOfArtRecItem.add(artRecItem5);

        RecyclerView artRecyclerView = findViewById(R.id.artRecyclerView);
        artRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArtRecAdapter artRecAdapter = new ArtRecAdapter(arrOfArtRecItem);
        artRecyclerView.setAdapter(artRecAdapter);

    }
}
