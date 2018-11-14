package com.example.jonathantahod.newsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import models.NewsItem;
import models.NewsRecyclerViewAdapter;
import utilities.JsonUtils;
import utilities.NewsQueryTask;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private NewsRecyclerViewAdapter mAdapter;
    private ArrayList<NewsItem> news = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mAdapter = new NewsRecyclerViewAdapter(this, news);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.get_news) {
            NewsQueryTask task = new NewsQueryTask();
            task.execute();
            try {
                String str = task.get();
                news  = JsonUtils.parseNews(str);
                mAdapter.mNews = news;
                mAdapter.notifyDataSetChanged();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
