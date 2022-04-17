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
import com.androidchatapp.index.bean.VideoBean;


import java.util.List;

public class IndexListAdapter extends BaseAdapter {
    private Context mContext;
    private List<VideoBean> vbl;

    public IndexListAdapter(Context context) {
        this.mContext = context;
    }


    public void setData(List<VideoBean> vbl) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.play_history_list_item, null);
            vh.tv_title = (TextView) convertView.findViewById(R.id.tv_adapter_title);
            vh.tv_video_title = (TextView) convertView.findViewById(R.id.tv_video_title);
            vh.iv_icon = (ImageView) convertView.findViewById(R.id.iv_video_icon);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        final VideoBean bean = (VideoBean) getItem(position);
        if (bean != null) {
            vh.tv_title.setText(bean.title);
            vh.tv_video_title.setText(bean.secondTitle);

        }


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bean == null) return;
                String aaa = vbl.get(position).getVideoPath();
                if (aaa.equals("Oxford")) {
                    String url = "http://www.google.co.in/maps/dir/London/Oxford";
                    GoogleMapActivity.start(mContext, url);
                } else if (aaa.equals("Luton")) {
                    String url = "http://www.google.co.in/maps/dir/London/Luton";
                    GoogleMapActivity.start(mContext, url);
                } else if (aaa.equals("Norwich")) {
                    String url = "http://www.google.co.in/maps/dir/London/Norwich";
                    GoogleMapActivity.start(mContext, url);
                } else if (aaa.equals("Leeds")) {
                    String url = "http://www.google.co.in/maps/dir/London/Leeds";
                    GoogleMapActivity.start(mContext, url);
                }

            }
        });

        return convertView;
    }

    class ViewHolder {
        public TextView tv_title;
        public TextView tv_video_title;
        public ImageView iv_icon;
    }
}