package com.androidchatapp.index.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.androidchatapp.R;
import com.androidchatapp.index.adapter.IndexListAdapter;
import com.androidchatapp.index.adapter.NewsListAdapter;
import com.androidchatapp.index.bean.NewsBean;
import com.androidchatapp.index.fragment.IndexFragment;

import java.util.ArrayList;

public class NewsListActivity extends AppCompatActivity {
    ListView knownStudentList;
    private String id = "";
    private ArrayList<NewsBean> vbl;
    private NewsListAdapter newsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        knownStudentList = (ListView) findViewById(R.id.known_student_list);
        getInfo();

    }

    public void getInfo() {
        vbl = new ArrayList<>();
        vbl.clear();
        NewsBean video1 = new NewsBean();
        video1.setTitle("advertise House07");
        video1.setSecondTitle("House07 just 200,000$ now!");
        video1.setVideoPath("Oxford");
        vbl.add(video1);

        NewsBean video2 = new NewsBean();
        video2.setTitle("advertise House10");
        video2.setSecondTitle("House07 just 150,000$ now!");
        video2.setVideoPath("Luton");
        vbl.add(video2);

        NewsBean video3 = new NewsBean();
        video3.setTitle("advertise House09");
        video3.setSecondTitle("House07 just 220,000$ now!");
        video3.setVideoPath("Norwich");
        vbl.add(video3);

        NewsBean video4 = new NewsBean();
        video4.setTitle("advertise House06");
        video4.setSecondTitle("House07 just 230,000$ now!");
        video4.setVideoPath("Leeds");
        vbl.add(video4);

        newsListAdapter = new NewsListAdapter(this);
        newsListAdapter.setData(vbl);
        knownStudentList.setAdapter(newsListAdapter);
    }
}
