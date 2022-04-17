package com.androidchatapp.index.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.androidchatapp.R;
import com.androidchatapp.Register;
import com.androidchatapp.UserDetails;
import com.androidchatapp.main.MainActivity;
import com.androidchatapp.util.UserManager;

import org.json.JSONException;
import org.json.JSONObject;

public class MapDetailActivity extends AppCompatActivity {
    ImageView img;
    TextView tvTitle, tvMain;

    private String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapdetail);

        id = getIntent().getStringExtra("id");

        img = (ImageView) findViewById(R.id.img_map);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvMain = (TextView) findViewById(R.id.tv_main);

        getInfo();

    }

    public void getInfo() {
        if (id.equals("1")) {

            tvTitle.setText("House1");
            tvMain.setText("100,000$");
        } else if (id.equals("2")) {

            tvTitle.setText("House2");
            tvMain.setText("300,000$");
        } else if (id.equals("3")) {

            tvTitle.setText("House3");
            tvMain.setText("500,000$");
        } else if (id.equals("4")) {

            tvTitle.setText("House4");
            tvMain.setText("150,000$");
        } else {

            tvTitle.setText("House5");
            tvMain.setText("310,000$");
        }
    }
}
