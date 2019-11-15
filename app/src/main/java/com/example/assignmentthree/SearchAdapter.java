package com.example.assignmentthree;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchAdapterViewHolder> implements Serializable {

    private List<Cat> catsToAdapt;

    public void setData(List<Cat> catsToAdapt) {
        this.catsToAdapt = catsToAdapt;
    }
    @NonNull
    @Override
    public SearchAdapter.SearchAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_search, parent, false);

        SearchAdapterViewHolder searchAdapterViewHolder = new SearchAdapterViewHolder(view);

        return searchAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final SearchAdapter.SearchAdapterViewHolder holder,final int position) {
        final Cat catAtPosition = catsToAdapt.get(position);

        holder.bind(catAtPosition);
    }

    @Override
    public int getItemCount() {
        return catsToAdapt.size();
    }

    public static class SearchAdapterViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView catBreedTextView;

        public SearchAdapterViewHolder(@NonNull View v) {
            super(v);
            view = v;
            catBreedTextView = v.findViewById(R.id.catBreedSummary);

        }

        public void bind(final Cat cat)  {
            catBreedTextView.setText(cat.getName());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, CatDetail.class);

                    Cat catDetail = cat;
                    System.out.println(catDetail.getName());
                    intent.putExtra("cat", catDetail);
                    context.startActivity(intent);
                }
            });
        }
    }
}
