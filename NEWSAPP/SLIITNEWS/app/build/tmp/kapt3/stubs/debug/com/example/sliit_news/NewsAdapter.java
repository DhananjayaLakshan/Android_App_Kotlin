package com.example.sliit_news;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0014\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/sliit_news/NewsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/sliit_news/NewsViewHolder;", "items", "", "Lcom/example/sliit_news/database/News;", "repository", "Lcom/example/sliit_news/database/NewsRepository;", "viewModel", "Lcom/example/sliit_news/MainActivityData;", "(Ljava/util/List;Lcom/example/sliit_news/database/NewsRepository;Lcom/example/sliit_news/MainActivityData;)V", "context", "Landroid/content/Context;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "newData", "app_debug"})
public final class NewsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.sliit_news.NewsViewHolder> {
    private android.content.Context context;
    private java.util.List<com.example.sliit_news.database.News> items;
    private final com.example.sliit_news.database.NewsRepository repository = null;
    private final com.example.sliit_news.MainActivityData viewModel = null;
    
    public NewsAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.sliit_news.database.News> items, @org.jetbrains.annotations.NotNull
    com.example.sliit_news.database.NewsRepository repository, @org.jetbrains.annotations.NotNull
    com.example.sliit_news.MainActivityData viewModel) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.example.sliit_news.NewsViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.sliit_news.NewsViewHolder holder, int position) {
    }
    
    public final void updateData(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.sliit_news.database.News> newData) {
    }
}