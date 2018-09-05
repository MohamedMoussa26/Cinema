package com.example.emohamedmoussa.cinema;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


public class F1 extends Fragment {
    private String url;
    private String jsonoffline;
    ImageView imgclk;


    public F1() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }




    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_f1, container, false);
        imgclk = (ImageView) v.findViewById(R.id.imgbg);
        imgclk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), moviesShow.class));
            }
        });






        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("moussssa", "1");


    }


    @Override
    public void onResume() {
        super.onResume();



    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    interface f1Data {

        public void sendData(Context context);

    }
}
