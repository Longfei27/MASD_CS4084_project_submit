package com.androidchatapp.index.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.androidchatapp.R;
import com.just.agentweb.AgentWeb;




public class GoogleMapActivity extends AppCompatActivity {


    public static void start(Context context, String url) {
        Intent intent = new Intent(context, GoogleMapActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_google_apm);
        FrameLayout webViewParent = findViewById(R.id.webViewParent);

        AgentWeb.with(this)
                .setAgentWebParent(webViewParent, new FrameLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(getIntent().getStringExtra("url"));
        
    }
}
