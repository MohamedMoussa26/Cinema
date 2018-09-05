package com.example.emohamedmoussa.cinema;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        ArrayList<cinPlace> cinPlaces = getIntent().getParcelableArrayListExtra("cinemas");
        Log.e("mmmmnnmn", "" + cinPlaces.get(0).lng);


        BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.cinl);
        Bitmap bitmap = img.getBitmap();
        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap, 75, 75, false);

//        LatLng mans = new LatLng(30.05, 31.14);
        for (int i = 0; i < cinPlaces.size(); i++) {


            mMap.addMarker(new MarkerOptions().title(cinPlaces.get(i).name).
                    position(new LatLng(Double.parseDouble((cinPlaces.get(i)).lat), Double.parseDouble((cinPlaces.get(i)).lng))).
                    visible(true).
                    icon(BitmapDescriptorFactory.fromBitmap(bitmap1)));


        }


        LatLng l1 = new LatLng(30.08132149999999, 31.3055527);
        String l1title = "Air Forces Cinema";
//



        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(l1, 10));
//        mMap.addCircle(new CircleOptions().center(l1).fillColor(2).radius(185000).visible(true));

        mMap.setBuildingsEnabled(true);
        mMap.setIndoorEnabled(true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.setTrafficEnabled(true);


    }
}
