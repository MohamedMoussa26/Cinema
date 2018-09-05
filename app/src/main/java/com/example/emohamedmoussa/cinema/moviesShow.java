package com.example.emohamedmoussa.cinema;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

//public class moviesShow extends AppCompatActivity implements F1.f1Data {
public class moviesShow extends AppCompatActivity implements MoShfrag.Sendmovie{

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_show);


//        Toolbar  mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
//        setSupportActionBar(mActionBarToolbar);
//        getSupportActionBar().setTitle("My title");


    }

    @Override
    public void movieobjet(movie movie, Context context, View v, int position) {
        Log.e("fffrag", "" + movie.overvirew);


        Intent i = new Intent(moviesShow.this, MainActivity.class);
        i.putExtra("movie",movie);
        startActivity(i);
//        startActivity((new Intent(context,MainActivity.class)).putExtra("movie",movie));
    }


//    @Override
//    public void sendData(Context context) {
//        Log.e("moussa", "recycler on item click listner");
//        Toast.makeText(context, "oppl", Toast.LENGTH_LONG).show();
////        startActivity(new Intent(context, moviedetail.class));
//        Log.e("moussa", "recycler on item click listner2");
//        Log.e("moussa", "recycler on item click listner2");
//
//
//    }
}
