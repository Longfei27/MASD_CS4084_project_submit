package com.androidchatapp.index.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.androidchatapp.Chat;
import com.androidchatapp.R;
import com.androidchatapp.base.BaseFragment;
import com.androidchatapp.util.UserManager;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;


public class Main1Fragment extends BaseFragment {
    @BindView(R.id.usersList)
    ListView usersList;
    @BindView(R.id.noUsersText)
    TextView noUsersText;
    ArrayList<String> al = new ArrayList<>();
    int totalUsers = 0;
    ProgressDialog pd;

    private UserManager userManager;


    @Override
    public int getLayoutId() {
        return R.layout.activity_users;
    }

    @Override
    public void initView() {

        userManager=UserManager.getInstance(Main1Fragment.this.getContext());
        pd = new ProgressDialog(Main1Fragment.this.context);
        pd.setMessage("Loading...");
        pd.show();

        String url = "https://myapp-b967f-default-rtdb.firebaseio.com/aaa.json";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
            @Override
            public void onResponse(String s) {
                doOnSuccess(s);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                System.out.println("" + volleyError);
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(context);
        rQueue.add(request);


    }

    @Override
    public void setListener() {
        usersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String aaa=al.get(position);
                userManager.setChatwith(aaa);
                startActivity(new Intent(context, Chat.class));
            }
        });
    }

    public void doOnSuccess(String s){
        try {
            JSONObject obj = new JSONObject(s);

            Iterator i = obj.keys();
            String key = "";

            while(i.hasNext()){
                key = i.next().toString();

                if(!key.equals(userManager.getName())) {
                    al.add(key);
                }

                totalUsers++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(totalUsers <=1){
            noUsersText.setVisibility(View.VISIBLE);
            usersList.setVisibility(View.GONE);
        }
        else{
            noUsersText.setVisibility(View.GONE);
            usersList.setVisibility(View.VISIBLE);
            usersList.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, al));
        }

        pd.dismiss();
    }
}
