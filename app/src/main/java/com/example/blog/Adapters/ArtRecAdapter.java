package com.example.blog.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.blog.Models.ArtRecItem;
import com.example.blog.Models.DescArtRecItem;
import com.example.blog.Models.ImgArtRecItem;
import com.example.blog.R;

import java.util.List;

public class ArtRecAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<ArtRecItem> itemList;

    public ArtRecAdapter(List<ArtRecItem> itemList) {
        this.itemList = itemList;
    }

    class ImgItemHolder extends RecyclerView.ViewHolder {
        ImageView itemImg;

        public ImgItemHolder(@NonNull View itemView) {
            super(itemView);
            itemImg = itemView.findViewById(R.id.imgIdart);
        }
    }

    class DescItemHolder extends RecyclerView.ViewHolder {
        TextView itemText;

        public DescItemHolder(@NonNull View itemView) {
            super(itemView);
            itemText = itemView.findViewById(R.id.textIdart);
        }
    }

    @Override
    public int getItemViewType(int position) {

        ArtRecItem artRecItem = itemList.get(position);

        if (artRecItem instanceof ImgArtRecItem) {
            position = 0;
        } else if (artRecItem instanceof DescArtRecItem) {
            position = 2;
        }
        return position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;

        if (viewType == 0) {
            viewHolder = new ImgItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.img_art_item, viewGroup, false));
        } else if (viewType == 2) {
            viewHolder = new DescItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.desc_art_item, viewGroup, false));
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        ArtRecItem artRecItem = itemList.get(i);

        if (viewHolder.getItemViewType() == 0) {
            ImgItemHolder imgItemHolder = (ImgItemHolder) viewHolder;
            ImgArtRecItem imgArtItem = (ImgArtRecItem) artRecItem;
            imgItemHolder.itemImg.setImageResource(imgArtItem.img);
        } else if (viewHolder.getItemViewType() == 2) {
            DescItemHolder descItemHolder = (DescItemHolder) viewHolder;
            DescArtRecItem descArtItem = (DescArtRecItem) artRecItem;
            descItemHolder.itemText.setText(descArtItem.text);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}