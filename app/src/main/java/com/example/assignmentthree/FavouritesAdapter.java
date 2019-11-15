package com.example.assignmentthree;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FavouritesAdapter extends RecyclerView.Adapter<FavouritesAdapter.FavouritesAdapterViewHolder> {

    private ArrayList<Cat> itemsToAdapt;

    public void setData(ArrayList<Cat> itemsToAdapt) {
        this.itemsToAdapt = itemsToAdapt;
    }

    @NonNull
    @Override
    public FavouritesAdapter.FavouritesAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat, parent, false);

        FavouritesAdapterViewHolder favouritesAdapterViewHolder = new FavouritesAdapter.FavouritesAdapterViewHolder(view);

        return favouritesAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavouritesAdapter.FavouritesAdapterViewHolder holder, int position) {
        final Cat cat = itemsToAdapt.get(position);

        holder.catnames.setText(cat.getName());
    }

    @Override
    public int getItemCount() {
        return itemsToAdapt.size();
    }

    public static class FavouritesAdapterViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView catnames;

        public FavouritesAdapterViewHolder(@NonNull View v) {
            super(v);

            view = v;
            catnames = view.findViewById(R.id.catnames);

        }
    }
}
