package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public class IntroAdapter extends RecyclerView.Adapter<IntroAdapter.IntroViewHolder> {

    private int[] layouts;
    private ViewPager2 viewPager2;

    public IntroAdapter(int[] layouts, ViewPager2 viewPager2) {
        this.layouts = layouts;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public IntroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layouts[viewType], parent, false);
        return new IntroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IntroViewHolder holder, int position) {
        holder.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPosition = position + 1;
                if (nextPosition < layouts.length) {
                    viewPager2.setCurrentItem(nextPosition, true); // Smooth transition
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return layouts.length;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static class IntroViewHolder extends RecyclerView.ViewHolder {
        Button nextButton;

        public IntroViewHolder(@NonNull View itemView) {
            super(itemView);
            nextButton = itemView.findViewById(R.id.nextButton);
        }
    }
}
