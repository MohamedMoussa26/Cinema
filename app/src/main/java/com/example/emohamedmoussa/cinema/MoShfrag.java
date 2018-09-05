package com.example.emohamedmoussa.cinema;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.emohamedmoussa.cinema.classes.Recitemclicklistner;

import java.lang.reflect.Method;
import java.util.ArrayList;

import okhttp3.Request;


//public class MoShfrag extends Fragment implements Recitemclicklistner {
public class MoShfrag extends Fragment {


    String jsonoffline, url;
    RecyclerView recyclerView;
    Context context;
    TextView fav, newm, upcoming, best, arabic, en;
    ImageView imghome, imgfav, imgtrend;
    Recitemclicklistner recitemclicklistner;

    private OnFragmentInteractionListener mListener;

    public MoShfrag() {

    }

    interface Sendmovie {
        void movieobjet(movie movie,Context context, View v, int position);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mo_shfrag, container, false);


        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


//        ArrayList<movietst> movies = new ArrayList<movietst>();
//
//        String[] movietitle = {"movie1", "movie2", "movie3", "movie4", "movie5", "movie6", "movie7", "movie8", "movie9", "movie10"};
//        String[] moviedetail = {"movie1", "movie2", "movie3", "movie4", "movie5", "movie6", "movie7", "movie8", "movie9", "movie10"};
//        int[] movieimg = {R.drawable.m1, R.drawable.m2, R.drawable.m3, R.drawable.m4, R.drawable.m5, R.drawable.m2, R.drawable.m3, R.drawable.m5, R.drawable.m1, R.drawable.m3, R.drawable.m5, R.drawable.m4};
//
//        for (int i = 0; i < moviedetail.length; i++) {
//            movies.add(new movietst(movietitle[i], moviedetail[i], movieimg[i]));
////            movies.add(new movie(movietitle[i], moviedetail[i], movieimg[i]));
//
//        }
//
//        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.Recmovie);
//        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2,1,false));
//        movieRec adapter = new movieRec(getContext(),movies);
//        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        this.context = view.getContext();
//        this.context = view.getContext();
//        url = "https://api.themoviedb.org/3/movie/now_playing?api_key=5b7b90a6e3498ae7267efbfece0ddf15&language=en-US";
//        recyclerView = (RecyclerView) view.findViewById(R.id.Recmovie);
//
//
//        Recitemclicklistner recitemclicklistner = new Recitemclicklistner() {
//            @Override
//            public void onitemclick(View view, int position, movie movie) {
//                Log.e("recyyyy","1");
//                Toast.makeText(context,"ff",Toast.LENGTH_LONG).show();
//                Toast.makeText(context,""+movie.overvirew,Toast.LENGTH_LONG).show();
//
//                Log.e("recyyyy","2");
//            }
//        };
//
//
//        (new DataShow(view.getContext(), url, recyclerView)).setrecitemclicklistner(recitemclicklistner);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);







        url = "https://api.themoviedb.org/3/movie/now_playing?api_key=5b7b90a6e3498ae7267efbfece0ddf15&language=en-US";
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.Recmovie);



         recitemclicklistner = new Recitemclicklistner() {
            @Override
            public void onitemclick(View view, int position, movie movie,Context context) {
                Log.e("recyyyy","1");

//                new moviesShow().movieobjet(movie,getActivity(),view,position);
                ((moviesShow)getActivity()).movieobjet(movie,context,view,position);
                Log.e("recyyyy","2");
            }
        };


        (new DataShow(getContext(), url, recyclerView)).setrecitemclicklistner(recitemclicklistner);


        fav = (TextView) getActivity().findViewById(R.id.txtfavourite);
        newm = (TextView) getActivity().findViewById(R.id.txtnew);
        upcoming = (TextView) getActivity().findViewById(R.id.txtupcoming);
        best = (TextView) getActivity().findViewById(R.id.txtbest);
        arabic = (TextView) getActivity().findViewById(R.id.txtarabic);
        en = (TextView) getActivity().findViewById(R.id.txten);

        imghome = (ImageView) getActivity().findViewById(R.id.ichome);
        imgfav = (ImageView) getActivity().findViewById(R.id.icfav);
        imgtrend = (ImageView) getActivity().findViewById(R.id.itrend);


        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url="https://api.themoviedb.org/3/movie/now_playing?api_key=5b7b90a6e3498ae7267efbfece0ddf15&language=en-US&region=eg";
                (new DataShow(getContext(), url, recyclerView)).setrecitemclicklistner(recitemclicklistner);
//                startActivity(new Intent(getActivity(),d));
            }
        });
        en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               url = "https://api.themoviedb.org/3/movie/now_playing?api_key=5b7b90a6e3498ae7267efbfece0ddf15&language=en-US";
                (new DataShow(getContext(), url, recyclerView)).setrecitemclicklistner(recitemclicklistner);

            }
        });
        imgtrend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "https://api.themoviedb.org/3/trending/all/day?api_key=5b7b90a6e3498ae7267efbfece0ddf15";
                (new DataShow(getContext(), url, recyclerView)).setrecitemclicklistner(recitemclicklistner);
            }
        });
        imgfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Cinemas.class));
            }
        });
        imghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), categories.class));
            }
        });


        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                url ="https://api.themoviedb.org/3/movie/top_rated?api_key=5b7b90a6e3498ae7267efbfece0ddf15&language=en-US";
                (new DataShow(getContext(), url, recyclerView)).setrecitemclicklistner(recitemclicklistner);



            }
        });

        best.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url ="https://api.themoviedb.org/3/movie/popular?api_key=5b7b90a6e3498ae7267efbfece0ddf15&language=en-US";
                (new DataShow(getContext(), url, recyclerView)).setrecitemclicklistner(recitemclicklistner);

            }
        });


        newm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url ="https://api.themoviedb.org/3/movie/now_playing?api_key=5b7b90a6e3498ae7267efbfece0ddf15&language=en-US";
                (new DataShow(getContext(), url, recyclerView)).setrecitemclicklistner(recitemclicklistner);


            }
        });

        upcoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url ="https://api.themoviedb.org/3/movie/upcoming?api_key=5b7b90a6e3498ae7267efbfece0ddf15&language=en-US";
                (new DataShow(getContext(), url, recyclerView)).setrecitemclicklistner(recitemclicklistner);


            }
        });


    }



    public interface OnFragmentInteractionListener {


        void onFragmentInteraction(Uri uri);
    }

}

