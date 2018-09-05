package com.example.emohamedmoussa.cinema;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.emohamedmoussa.cinema.classes.Recitemclicklistner;

public class category_show extends AppCompatActivity {

    RecyclerView recyclerView;
    Recitemclicklistner recitemclicklistner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_show);



        

        String url = "https://api.themoviedb.org/4/list/"+getIntent().getStringExtra("id")+"?page=1&api_key=5b7b90a6e3498ae7267efbfece0ddf15";
        recyclerView = (RecyclerView) findViewById(R.id.reccategory);



        recitemclicklistner = new Recitemclicklistner() {
            @Override
            public void onitemclick(View view, int position, movie movie, Context context) {
                Log.e("recyyyy","1");

//                new moviesShow().movieobjet(movie,getActivity(),view,position);
//                ((moviesShow) movieobjet(movie,context,view,position);
                Log.e("recyyyy","2");
            }
        };




        (new DataShow(this, url, recyclerView)).setrecitemclicklistner(recitemclicklistner);




    }
}
