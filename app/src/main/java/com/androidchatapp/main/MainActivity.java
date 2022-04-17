package com.androidchatapp.main;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.androidchatapp.R;
import com.androidchatapp.base.BaseFragmentActivity;
import com.androidchatapp.index.fragment.IndexFragment;
import com.androidchatapp.index.fragment.Main1Fragment;
import com.androidchatapp.index.fragment.SiteMapFragment;
import com.androidchatapp.mine.fragment.FragmentMine;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import butterknife.BindView;

public class MainActivity extends BaseFragmentActivity implements OnMapReadyCallback {
    @BindView(R.id.rb_school)
    RadioButton rbSchool;
    @BindView(R.id.rb_message)
    RadioButton rbMessage;
    @BindView(R.id.rb_parenting)
    RadioButton rbParenting;
    @BindView(R.id.rg_main_bottom)
    RadioGroup rgMainBottom;
    @BindView(R.id.badge_rela)
    TextView badgeRela;
    private GoogleMap mMap;

    private int showIndex = 1;

    private SiteMapFragment siteMapFragment;
    private IndexFragment indexFragment;
    private Main1Fragment main1Fragment;
    private FragmentMine fragmentMine;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main1;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {
        rgMainBottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.rb_school:
                        showIndex = 1;
                        break;
                    case R.id.rb_message:
                        showIndex = 2;
                        break;
                    case R.id.rb_parenting:
                        showIndex = 3;
                        break;

                }
                ShowFragment();
            }
        });
        rbSchool.performClick();
    }

    private void ShowFragment() {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (siteMapFragment != null && !siteMapFragment.isHidden()) {
            transaction.hide(siteMapFragment);
        }
        if (main1Fragment != null && !main1Fragment.isHidden()) {
            transaction.hide(main1Fragment);
        }
        if (fragmentMine != null && !fragmentMine.isHidden()) {
            transaction.hide(fragmentMine);
        }


        switch (showIndex) {
            case 1:
                if (siteMapFragment == null) {
                    siteMapFragment = new SiteMapFragment();
                    transaction.add(R.id.fragment_continer, siteMapFragment);
                }
                transaction.show(siteMapFragment);
                break;
            case 2:
                if (main1Fragment == null) {
                    main1Fragment = new Main1Fragment();
                    transaction.add(R.id.fragment_continer, main1Fragment);
                }
                transaction.show(main1Fragment);
                break;
            case 3:
                if (fragmentMine == null) {
                    fragmentMine = new FragmentMine();
                    transaction.add(R.id.fragment_continer, fragmentMine);
                }
                transaction.show(fragmentMine);
                break;
        }

        transaction.commitAllowingStateLoss();

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(36.69314, 117.10170);
        LatLng sydney1 = new LatLng(38.69314, 117.10170);
        LatLng sydney2 = new LatLng(40.69314, 117.10170);
        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.ic_dog);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").icon(bitmapDescriptor));
        mMap.addMarker(new MarkerOptions().position(sydney1).title("Marker in Sydney").icon(bitmapDescriptor));
        mMap.addMarker(new MarkerOptions().position(sydney2).title("Marker in Sydney").icon(bitmapDescriptor));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.setMinZoomPreference(6.0f);
        mMap.setMaxZoomPreference(14.0f);
        mMap.moveCamera(CameraUpdateFactory.zoomTo(13));
    }
}
