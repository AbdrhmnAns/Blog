package com.example.blog.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.blog.ArtActivity;
import com.example.blog.Models.HomeRecItem;
import com.example.blog.R;

import java.util.List;

public class HomeRecAdapter extends RecyclerView.Adapter<HomeRecAdapter.ItemHolder> {

    List<HomeRecItem> itemList;
    Context context;

    public HomeRecAdapter(Context context, List<HomeRecItem> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View row = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home, viewGroup, false);
        ItemHolder holder = new ItemHolder(row);
        return holder;
    }


    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        HomeRecItem item = itemList.get(i);
        itemHolder.itemText.setText(item.desc);
        itemHolder.itemImg.setImageResource(item.img);
        itemHolder.itemText2.setText(item.desc2);
        itemHolder.itemImg2.setImageResource(item.img2);

   //  itemHolder.itemImg.setOnClickListener(new View.OnClickListener() {
     itemHolder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HomeRecItem homeRecItem = itemList.get(getAdapterPosition());
                    Intent intent = new Intent(content, ArtActivity.class);
                    context.startActivity(intent);
                    Toast.makeText(context, "You Clicked" + item.desc, Toast.LENGTH_SHORT).show();
                }
            }); 
            
             }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        ImageView itemImg;
        TextView itemText;
        ImageView itemImg2;
        TextView itemText2;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            itemImg = itemView.findViewById(R.id.imgId);
            itemText = itemView.findViewById(R.id.textId);
            itemImg2 = itemView.findViewById(R.id.imgId2);
            itemText2 = itemView.findViewById(R.id.textId2);

         
        }
    }
}
