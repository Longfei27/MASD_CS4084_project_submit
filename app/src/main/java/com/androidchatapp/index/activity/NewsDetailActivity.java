package com.androidchatapp.index.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidchatapp.R;

public class NewsDetailActivity extends AppCompatActivity {
    ImageView img;
    TextView tvTitle, tvMain;

    private String title = "";
    private String main = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapdetail);

        title = getIntent().getStringExtra("title");
        main = getIntent().getStringExtra("main");

        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvMain = (TextView) findViewById(R.id.tv_main);

        tvTitle.setText(title);
        tvMain.setText(main);

    }

}
