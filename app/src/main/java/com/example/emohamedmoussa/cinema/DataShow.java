package com.example.emohamedmoussa.cinema;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;


import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.example.emohamedmoussa.cinema.classes.Recitemclicklistner;

import java.io.ByteArrayOutputStream;

import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class DataShow {

    public DataShow() {
    }

    int increment;
    ByteArrayOutputStream byteArrayOutputStream;
    SQLiteDatabase db;
    ArrayList<movie> movies;
    ArrayList<movie> Mdb;
    String url;
    Context context;
    ListView listView;
    GridView gridView;
    String type, offlinejson;
    RecyclerView recyclerView;
    Recitemclicklistner recitemclicklistner;


    public DataShow(Context context, String url, GridView gridView, String type, String offlinejson) {
        this.context = context;
        this.url = url;
        this.gridView = gridView;
        this.type = type;
        this.offlinejson = offlinejson;
        getjson(url);


    }

    public DataShow(String offlinejson, Context context, RecyclerView recyclerView) {
        this.offlinejson = offlinejson;
        this.context = context;
        this.recyclerView = recyclerView;
        Log.e("moussa log", "1");
        getjsondata(offlinejson);
    }

    public DataShow(Context context,String url, RecyclerView recyclerView) {
        this.url = url;
        this.context = context;
        this.recyclerView = recyclerView;
        Log.e("moussa log", "1");
        getjson(url);
    }


    public DataShow(Context context, String url, ListView listView, String type, String offlinejson) {
        this.context = context;
        this.url = url;
        this.listView = listView;
        this.type = type;
        this.offlinejson = offlinejson;


        getjson(url);

    }


    public void getjson(String url) {

        Log.e("moussa log", "2");



        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("moussa log", "3");
                getjsondata(response);


            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        requestQueue.add(stringRequest);
    }


    public void setrecitemclicklistner(Recitemclicklistner recitemclicklistner){
        this.recitemclicklistner = recitemclicklistner;

    }


    public void getjsondata(String json) {

        Log.e("moussa log", "4");
        increment = 0;
        movies = new ArrayList<>();
        Log.e("moussa log", "5");
        RequestQueue rq = Volley.newRequestQueue(context);
        byteArrayOutputStream = new ByteArrayOutputStream();
        Log.e("moussa log", "6");
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        Log.e("moussa log", "7");

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            int l = jsonArray.length();

            ContentValues values = new ContentValues();

            for (int i = 0; i < jsonArray.length(); i++) {
                increment++;
                JSONObject m = jsonArray.getJSONObject(i);
                int x = i + 1;



                movies.add(new movie("https://image.tmdb.org/t/p/w500" + m.get("poster_path").toString(),
                        "https://image.tmdb.org/t/p/w500" + m.get("backdrop_path").toString(),
                        m.get("adult").toString(),
                        m.get("overview").toString(),
                        m.get("release_date").toString(),
                        m.get("title").toString(),
                        m.get("original_language").toString(),
                        m.get("vote_count").toString(),
                        m.get("vote_average").toString(),
                        m.getInt("id")));
                Log.e("moussa log", "13");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        Log.e("moussa log", "14");


//        Recitemclicklistner recitemclicklistner = new Recitemclicklistner() {
//            @Override
//            public void onitemclick(View view, int position, movie movie) {
//                Log.e("recyyyy","1");
//                        Toast.makeText(context,"ff",Toast.LENGTH_LONG).show();
//                        Toast.makeText(context,""+movie.overvirew,Toast.LENGTH_LONG).show();
//
//                Log.e("recyyyy","2");
//            }
//        };

        recyclerView.setLayoutManager(new GridLayoutManager(context, 2, 1, false));
        recyclerView.setItemAnimator(new SlideInUpAnimator());
        Log.e("moussa log", "15");

        moviesAdapter moviesAdapter = new moviesAdapter(context, movies);
        moviesAdapter.setAdapterrecitemclicklistner(recitemclicklistner);
        recyclerView.setAdapter(moviesAdapter);



//        recyclerView.setAdapter();


//        if (type.equals("list")) {
//            movieAdabter adabter = new movieAdabter(context, movies);
//            listView.setAdapter(adabter);
//            listView.setAdapter(adabter);
//        } else if (type.equals("grid")) {
//            customadapter adapter = new customadapter(context, movies);
//            gridView.setAdapter(adapter);
//
//        }


    }




    public ArrayList<movie> getjsondata(String json, boolean type) {

        Log.e("moussa log", "4");
        increment = 0;
        movies = new ArrayList<>();
        Log.e("moussa log", "5");
//        RequestQueue rq = Volley.newRequestQueue(context);
//        byteArrayOutputStream = new ByteArrayOutputStream();
//        Log.e("moussa log", "6");
//        RequestQueue requestQueue = Volley.newRequestQueue(context);
        Log.e("moussa log", "7");

        try {
            Log.e("moussa log", "8");
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            Log.e("moussa log", "9");
            int l = jsonArray.length();
            ContentValues values = new ContentValues();

            Log.e("moussa log", "10");
            for (int i = 0; i < jsonArray.length(); i++) {
                increment++;
                Log.e("moussa log", "188");
                JSONObject m = jsonArray.getJSONObject(i);
                int x = i + 1;
                Log.e("moussa log", "8");
                movies.add(new movie("https://image.tmdb.org/t/p/w500" + m.get("poster_path").toString(),
                        "https://image.tmdb.org/t/p/w500" + m.get("backdrop_path").toString(),
                        m.get("adult").toString(),
                        m.get("overview").toString(),
                        m.get("release_date").toString(),
                        m.get("title").toString(),
                        m.get("original_language").toString(),
                        m.get("vote_count").toString(),
                        m.get("vote_average").toString(),
                        m.getInt("id")));
                Log.e("moussa log", "13");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }





//        recyclerView.setAdapter();


//        if (type.equals("list")) {
//            movieAdabter adabter = new movieAdabter(context, movies);
//            listView.setAdapter(adabter);
//            listView.setAdapter(adabter);
//        } else if (type.equals("grid")) {
//            customadapter adapter = new customadapter(context, movies);
//            gridView.setAdapter(adapter);
//
//        }
        return movies;

    }


}

