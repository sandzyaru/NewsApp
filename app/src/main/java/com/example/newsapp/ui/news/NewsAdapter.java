package com.example.newsapp.ui.news;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.data.model.Article;
import com.example.newsapp.databinding.ItemNewsBinding;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<Article> newsList = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void setNewsList(List<Article> newsList) {
        this.newsList = newsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNewsBinding binding = ItemNewsBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new NewsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.onbind(newsList.get(position));

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    protected static class NewsViewHolder extends RecyclerView.ViewHolder {
        private final ItemNewsBinding binding;

        public NewsViewHolder(@NonNull ItemNewsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onbind(Article article) {
            binding.tvTitle.setText(article.getTitle());
            binding.tvDescription.setText(article.getDescription());
            Glide.with(binding.getRoot()).load(article.getUrlToImage())
                    .centerCrop()
                    .into(binding.ivNewsImage);
        }
    }
}
