package com.androidchatapp.index.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidchatapp.R;
import com.androidchatapp.index.activity.GoogleMapActivity;
import com.androidchatapp.index.activity.MapDetailActivity;
import com.androidchatapp.index.activity.NewsDetailActivity;
import com.androidchatapp.index.bean.NewsBean;
import com.androidchatapp.index.bean.VideoBean;

import java.util.List;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

public class NewsListAdapter extends BaseAdapter {
    private Context mContext;
    private List<NewsBean> vbl;

    public NewsListAdapter(Context context) {
        this.mContext = context;
    }


    public void setData(List<NewsBean> vbl) {
        this.vbl = vbl;
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return vbl == null ? 0 : vbl.size();
    }

    @Override
    public Object getItem(int position) {
        return vbl == null ? null : vbl.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            vh = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.news_list_item, null);
            vh.tv_title = (TextView) convertView.findViewById(R.id.tv_adapter_title);
            vh.tv_video_title = (TextView) convertView.findViewById(R.id.tv_video_title);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        final NewsBean bean = (NewsBean) getItem(position);
        if (bean != null) {
            vh.tv_title.setText(bean.title);
            vh.tv_video_title.setText(bean.secondTitle);

        }


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bean == null) return;
                String aaa = vbl.get(position).getTitle();
                String bbb = vbl.get(position).getSecondTitle();
                Intent intent = new Intent(mContext, NewsDetailActivity.class);
                intent.putExtra("title", aaa);
                intent.putExtra("main", bbb);
                startActivity(intent);
            }
        });

        return convertView;
    }

    class ViewHolder {
        public TextView tv_title;
        public TextView tv_video_title;
    }
}