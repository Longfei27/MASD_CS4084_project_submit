package com.androidchatapp.index.fragment;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidchatapp.Login;
import com.androidchatapp.R;
import com.androidchatapp.Register;
import com.androidchatapp.index.activity.GoogleMapActivity;
import com.androidchatapp.index.activity.MapDetailActivity;
import com.androidchatapp.main.MainActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class SiteMapFragment extends Fragment implements OnMapReadyCallback {

    private MapView mMap;
    private GoogleMap googleMap;
    private Bundle args = null;
    private ProgressDialog mDialog;
    private String LoginID = null;
    private SharedPreferences preferences;

    private AlertDialog.Builder builder;
    private static final String LOG_TAG = SiteMapFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        Log.i("SiteMapFragment", "onCreateView");

        View view = inflater.inflate(R.layout.fragment_to_site_mapview,
                container, false);

        mMap = (MapView) view.findViewById(R.id.mapview);
        mMap.onCreate(savedInstanceState);
        mMap.onResume();// needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int errorCode = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(this.getActivity());

        if (ConnectionResult.SUCCESS != errorCode) {
            GooglePlayServicesUtil.getErrorDialog(errorCode,
                    this.getActivity(), 0).show();
        } else {
            mMap.getMapAsync(this);
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        Log.i("SiteMapFragment", "onActivityCreated");
    }

    @Override
    public void onResume() {
        super.onResume();
        mMap.onResume();

    }

    @Override
    public void onDetach() {
        // TODO Auto-generated method stub
        super.onDetach();
        Log.i("SiteMapFragment", "onDetach");
    }

    @Override
    public void onAttach(Context context) {
        // TODO Auto-generated method stub
        super.onAttach(context);
        Log.i("SiteMapFragment", "onAttach");
    }

    @Override
    public void onPause() {
        super.onPause();
        mMap.onPause();
        Log.i("SiteMapFragment", "onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMap.onDestroy();
        Log.i("SiteMapFragment", "onDestroy");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMap.onLowMemory();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("SiteMapFragment", "onDestroyView");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(51.5988, -0.1281);
        LatLng sydney1 = new LatLng(51.4988, -0.1281);
        LatLng sydney2 = new LatLng(51.5288, -0.1281);
        LatLng sydney3 = new LatLng(51.5788, -0.1281);
        LatLng sydney4 = new LatLng(51.4588, -0.1081);
        LatLng sydney5 = new LatLng(51.5188, -0.1181);
        LatLng sydney6 = new LatLng(51.5188, -0.1381);
        LatLng sydney7 = new LatLng(51.5188, -0.1481);
        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.ic_dog);
        googleMap.addMarker(new MarkerOptions().position(sydney).title("House1").icon(bitmapDescriptor));
        googleMap.addMarker(new MarkerOptions().position(sydney1).title("House2").icon(bitmapDescriptor));
        googleMap.addMarker(new MarkerOptions().position(sydney2).title("House3").icon(bitmapDescriptor));
        googleMap.addMarker(new MarkerOptions().position(sydney3).title("House4").icon(bitmapDescriptor));
        googleMap.addMarker(new MarkerOptions().position(sydney4).title("House5").icon(bitmapDescriptor));
        googleMap.addMarker(new MarkerOptions().position(sydney5).title("House6").icon(bitmapDescriptor));
        googleMap.addMarker(new MarkerOptions().position(sydney6).title("House7").icon(bitmapDescriptor));
        googleMap.addMarker(new MarkerOptions().position(sydney7).title("House8").icon(bitmapDescriptor));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
//                Intent intent1 = new Intent(SiteMapFragment.this.getContext(), GoogleMapActivity.class);
//                startActivity(intent1);

//                String url = "http://www.google.co.in/maps/dir/London/Oxford";
//                GoogleMapActivity.start(SiteMapFragment.this.getContext(), url);
                return false;
            }
        });

// 单击
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                String select = latLng.toString();
                String select1 = select.substring(10, 15);

                LatLng sydney0 = new LatLng(51.541637671663594, -0.1284027099609375);
                String aaa = sydney0.toString();
                String a1 = aaa.substring(10, 15);

                String aaa2 = sydney2.toString();
                String a2 = aaa2.substring(10, 15);

                String aaa3 = sydney3.toString();
                String a3 = aaa3.substring(10, 15);

                String aaa4 = sydney4.toString();
                String a4 = aaa4.substring(10, 15);



                if (select.equals(a1)) {
//                    String url = "http://www.google.co.in/maps/dir/London/Oxford";
//                    GoogleMapActivity.start(SiteMapFragment.this.getContext(), url);
                    Intent intent1 = new Intent(SiteMapFragment.this.getContext(), MapDetailActivity.class);
                    intent1.putExtra("id", "1");
                    startActivity(intent1);
                } else if (select.equals(a2)){
                    Intent intent2 = new Intent(SiteMapFragment.this.getContext(), MapDetailActivity.class);
                    intent2.putExtra("id", "2");
                    startActivity(intent2);
                }else if (select.equals(a3)){
                    Intent intent3 = new Intent(SiteMapFragment.this.getContext(), MapDetailActivity.class);
                    intent3.putExtra("id", "3");
                    startActivity(intent3);
                }else if (select.equals(a4)){
                    Intent intent4= new Intent(SiteMapFragment.this.getContext(), MapDetailActivity.class);
                    intent4.putExtra("id", "4");
                    startActivity(intent4);
                }else {
                    Intent intent5 = new Intent(SiteMapFragment.this.getContext(), MapDetailActivity.class);
                    intent5.putExtra("id", "5");
                    startActivity(intent5);
                }
            }
        });

//        // 不允许手势缩放
//        googleMap.getUiSettings().setZoomGesturesEnabled(false);
        //禁用精简模式下右下角的工具栏
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        // 不允许拖动地图
        googleMap.getUiSettings().setScrollGesturesEnabled(false);
        // 设置缩放级别
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(11);
        googleMap.animateCamera(zoom);

    }

}




