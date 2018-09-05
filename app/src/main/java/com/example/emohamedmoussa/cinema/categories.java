package com.example.emohamedmoussa.cinema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class categories extends AppCompatActivity implements View.OnClickListener {

    ImageView action, horror, crime, romance, thriller, animation, comedy, drama, adventure, sci, mystry, fantasy, hindi, arabic, hero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);


        action = (ImageView) findViewById(R.id.Caction);
        horror = (ImageView) findViewById(R.id.Choror);
        crime = (ImageView) findViewById(R.id.Ccrime);
        romance = (ImageView) findViewById(R.id.Cromance);
        thriller = (ImageView) findViewById(R.id.Cthriller);
        animation = (ImageView) findViewById(R.id.Cani);
        comedy = (ImageView) findViewById(R.id.Ccomedy);
        drama = (ImageView) findViewById(R.id.Cdrama);
        adventure = (ImageView) findViewById(R.id.Cadventure);
        sci = (ImageView) findViewById(R.id.Csci);
        mystry = (ImageView) findViewById(R.id.Cmystry);
        fantasy = (ImageView) findViewById(R.id.Cfantasy);
        hindi = (ImageView) findViewById(R.id.Chindi);
        arabic = (ImageView) findViewById(R.id.Carabic);
        hero = (ImageView) findViewById(R.id.Chero);

        action.setOnClickListener(this);
        horror.setOnClickListener(this);
        crime.setOnClickListener(this);
        romance.setOnClickListener(this);
        thriller.setOnClickListener(this);
        animation.setOnClickListener(this);
        comedy.setOnClickListener(this);
        drama.setOnClickListener(this);
        adventure.setOnClickListener(this);
        sci.setOnClickListener(this);
        mystry.setOnClickListener(this);
        fantasy.setOnClickListener(this);
        hindi.setOnClickListener(this);
        arabic.setOnClickListener(this);
        hero.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.Caction:
                startActivity(new Intent(getApplicationContext(), category_show.class).putExtra("id", "28"));
                break;
            case R.id.Choror:
                startActivity(new Intent(getApplicationContext(), category_show.class).putExtra("id", "27"));
                break;
            case R.id.Ccrime:
                startActivity(new Intent(getApplicationContext(), category_show.class).putExtra("id", "80"));
                break;
            case R.id.Cromance:
                startActivity(new Intent(getApplicationContext(), category_show.class).putExtra("id", "10749"));
                break;
            case R.id.Cani:
                startActivity(new Intent(getApplicationContext(), category_show.class).putExtra("id", "16"));
                break;
            case R.id.Cthriller:
                startActivity(new Intent(getApplicationContext(), category_show.class).putExtra("id", "53"));
                break;
            case R.id.Ccomedy:
                startActivity(new Intent(getApplicationContext(), category_show.class).putExtra("id", "35"));
                break;
            case R.id.Cdrama:
                startActivity(new Intent(getApplicationContext(), category_show.class).putExtra("id", "18"));
                break;
            case R.id.Cadventure:
                startActivity(new Intent(getApplicationContext(), category_show.class).putExtra("id", "12"));
                break;
            case R.id.Csci:
                startActivity(new Intent(getApplicationContext(), category_show.class).putExtra("id", "878"));
                break;
            case R.id.Cmystry:
                startActivity(new Intent(getApplicationContext(), category_show.class).putExtra("id", "9648"));
                break;
            case R.id.Cfantasy:
                startActivity(new Intent(getApplicationContext(), category_show.class).putExtra("id", "14"));
                break;
            case R.id.Chindi:
                startActivity(new Intent(getApplicationContext(), category_show.class).putExtra("id", "37"));
                break;
            case R.id.Carabic:
                startActivity(new Intent(getApplicationContext(), category_show.class).putExtra("id", "arabic"));
                break;
            case R.id.Chero:
                startActivity(new Intent(getApplicationContext(), category_show.class).putExtra("id", "10751"));
                break;


        }

    }
}
