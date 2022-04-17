package com.androidchatapp.index.fragment;

import android.widget.ListView;

import com.androidchatapp.R;
import com.androidchatapp.base.BaseFragment;
import com.androidchatapp.index.adapter.IndexListAdapter;
import com.androidchatapp.index.bean.VideoBean;
import java.util.ArrayList;
import butterknife.BindView;


public class IndexFragment extends BaseFragment {
    @BindView(R.id.known_student_list)
    ListView knownStudentList;
    private ArrayList<VideoBean> vbl;
    private IndexListAdapter playHistoryAdapter;


    @Override
    public int getLayoutId() {
        return R.layout.fragment_main3;
    }

    @Override
    public void initView() {
        getList();
    }

    @Override
    public void setListener() {

    }

    public void getList() {
        vbl = new ArrayList<>();
        vbl.clear();
        VideoBean video1 = new VideoBean();
        video1.setTitle("First");
        video1.setSecondTitle("Oxford");
        video1.setVideoPath("Oxford");
        vbl.add(video1);

        VideoBean video2 = new VideoBean();
        video2.setTitle("Two");
        video2.setSecondTitle("Luton");
        video2.setVideoPath("Luton");
        vbl.add(video2);

        VideoBean video3 = new VideoBean();
        video3.setTitle("Three");
        video3.setSecondTitle("Norwich");
        video3.setVideoPath("Norwich");
        vbl.add(video3);

        VideoBean video4 = new VideoBean();
        video4.setTitle("Four");
        video4.setSecondTitle("Leeds");
        video4.setVideoPath("Leeds");
        vbl.add(video4);

        playHistoryAdapter = new IndexListAdapter(IndexFragment.this.getContext());
        playHistoryAdapter.setData(vbl);
        knownStudentList.setAdapter(playHistoryAdapter);
    }
}

