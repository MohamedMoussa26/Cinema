package com.example.emohamedmoussa.cinema;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    TextView txtoverview, txttitle, txtdate, txttrailers, txttrailers1, txttrailers2, txttrailers3, txttrailers4, txttrailers5, txttrailers6, txtcomment;
    ImageView img, img1, img2, img3, img4, img5;
    EditText edcomment;
    Button btncomment;
    ArrayList<String> videos;
    ArrayList<String> comments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().setTitle("Movie Details");
        comments = new ArrayList<String>();
        comments.add("mohamed");
        comments.add("k");
        comments.add("klk;");
        comments.add("jnkl");


        Intent i = getIntent();
        movie movie = i.getParcelableExtra("movie");
        Log.e("mohamed on nnnn", "" + movie.overvirew);

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("" + movie.movie_id);


        videos = new ArrayList<String>();
        img = (ImageView) findViewById(R.id.imgbg);
        img1 = (ImageView) findViewById(R.id.imgbg1);
        img2 = (ImageView) findViewById(R.id.imgbg2);
        img3 = (ImageView) findViewById(R.id.imgbg3);
        img4 = (ImageView) findViewById(R.id.imgbg4);
        img5 = (ImageView) findViewById(R.id.imgbg5);


        txtoverview = (TextView) findViewById(R.id.txtoverview);
        txtdate = (TextView) findViewById(R.id.mtxtdate);
        txttitle = (TextView) findViewById(R.id.mtxttite);

        txttrailers = (TextView) findViewById(R.id.mtxttrailers);
        txttrailers1 = (TextView) findViewById(R.id.mtxttrailers1);
        txttrailers2 = (TextView) findViewById(R.id.mtxttrailers2);
        txttrailers3 = (TextView) findViewById(R.id.mtxttrailers3);
        txttrailers4 = (TextView) findViewById(R.id.mtxttrailers4);
        txttrailers5 = (TextView) findViewById(R.id.mtxttrailers5);
        txttrailers6 = (TextView) findViewById(R.id.mtxttrailers6);

        txtcomment = (TextView) findViewById(R.id.txtComments);
        edcomment = (EditText) findViewById(R.id.etcomment);
        btncomment = (Button) findViewById(R.id.btncomment);
        btncomment.setOnClickListener(this);

        txtcomment.setMovementMethod(new ScrollingMovementMethod());

        ((ScrollView) findViewById(R.id.Pscrol)).setOnTouchListener(new View.OnTouchListener() {


            @Override
            public boolean onTouch(View v, MotionEvent event) {
//                Log.v(TAG, "PARENT TOUCH");

                findViewById(R.id.txtComments).getParent()
                        .requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });

        txtcomment.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
//                Log.v(TAG, "CHILD TOUCH");

                // Disallow the touch request for parent scroll on touch of  child view
                txtcomment.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });


        txttrailers.setOnClickListener(this);
        txttrailers1.setOnClickListener(this);
        txttrailers2.setOnClickListener(this);
        txttrailers3.setOnClickListener(this);
        txttrailers4.setOnClickListener(this);
        txttrailers5.setOnClickListener(this);
        txttrailers6.setOnClickListener(this);


        txtoverview.setText(movie.overvirew);
        txtdate.setText(movie.releasedate + "   " + movie.lang + "  " + "       " + movie.rate);
        txttitle.setText(movie.title);


        Picasso.get().load(movie.background).into(img);
//        Picasso.get().load(movie.poster).into(img1);
        Log.e("mousaimg", movie.background);

        Log.e("mousaimg", "2");

        ArrayList<String> posters = new ArrayList<String>();

        Log.e("mousaimg", "63");

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.GET, "https://api.themoviedb.org/3/movie/" + movie.movie_id + "/images?api_key=5b7b90a6e3498ae7267efbfece0ddf15", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("mousaimg", "3");

                try {
                    Log.e("mousaimg", "4");
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("posters");
                    JSONArray jsonArray2 = jsonObject.getJSONArray("backdrops");

                    Log.e("mousaimg", "5");

                    for (int m = 1; m <= 5; m++) {


                        switch (m) {

                            case 1:
                                Picasso.get().load("https://image.tmdb.org/t/p/w500" + (jsonArray.getJSONObject(m)).get("file_path")).into(img1);
                                break;
                            case 2:
                                Picasso.get().load("https://image.tmdb.org/t/p/w500" + (jsonArray.getJSONObject(m)).get("file_path")).into(img2);
                                break;
                            case 3:
                                Picasso.get().load("https://image.tmdb.org/t/p/w500" + (jsonArray2.getJSONObject(m)).get("file_path")).into(img3);
                                break;

                            case 4:
                                Picasso.get().load("https://image.tmdb.org/t/p/w500" + (jsonArray2.getJSONObject(m)).get("file_path")).into(img4);
                                break;

                            case 5:
                                Picasso.get().load("https://image.tmdb.org/t/p/w500" + (jsonArray2.getJSONObject(m)).get("file_path")).into(img5);
                                break;
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);


//        https://api.themoviedb.org/3/movie/345940/videos?api_key=&language=en-US&region=eg

        StringRequest stringRequest2 = new StringRequest(com.android.volley.Request.Method.GET, "https://api.themoviedb.org/3/movie/" + movie.movie_id + "/videos?api_key=5b7b90a6e3498ae7267efbfece0ddf15", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("mousaimg", "3");

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");
                    for (int m = 0; m < jsonArray.length(); m++) {
                        videos.add((jsonArray.getJSONObject(m)).getString("key"));

                        switch (m) {
                            case 0:
//                                txttrailers.setVisibility(View.VISIBLE);
                                txttrailers.setEnabled(true);
                                txttrailers.setText((jsonArray.getJSONObject(m)).get("name") + "");
                                break;
                            case 1:

//                                txttrailers.setVisibility(View.VISIBLE);
                                txttrailers1.setEnabled(true);
                                txttrailers1.setText((jsonArray.getJSONObject(m)).get("name") + "");
                                break;
                            case 2:

//                                txttrailers.setVisibility(View.VISIBLE);
                                txttrailers2.setEnabled(true);
                                txttrailers2.setText((jsonArray.getJSONObject(m)).get("name") + "");
                                break;
                            case 3:

//                                txttrailers.setVisibility(View.VISIBLE);
                                txttrailers3.setEnabled(true);
                                txttrailers3.setText((jsonArray.getJSONObject(m)).get("name") + "");
                                break;
                            case 4:

//                                txttrailers.setVisibility(View.VISIBLE);
                                txttrailers4.setEnabled(true);
                                txttrailers4.setText((jsonArray.getJSONObject(m)).get("name") + "");
                                break;
                            case 5:

//                                txttrailers.setVisibility(View.VISIBLE);
                                txttrailers5.setEnabled(true);
                                txttrailers5.setText((jsonArray.getJSONObject(m)).get("name") + "");
                                break;
                            case 6:

//                                txttrailers.setVisibility(View.VISIBLE);
                                txttrailers6.setEnabled(true);
                                txttrailers6.setText((jsonArray.getJSONObject(m)).get("name") + "");
                                break;
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue.add(stringRequest2);


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                txtcomment.setText("");
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    Log.e("firebasedd", "1");
                    comments.add(ds.getValue().toString());
                    txtcomment.append(ds.getValue().toString() + "\n _______________ \n");
//                    txtcomment.setText(txtcomment.getText()+""+ds.getValue().toString());
                    Log.e("firebasedd", "2");


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        FragmentManager fragmentManager = getFragmentManager();
        Fragment f1 = fragmentManager.findFragmentById(R.id.fragment);


//        f1.setArguments(movie);


//        Fragment fragment = new Fragment();
//        (((getFragmentManager()).beginTransaction()).add(fragment, "frag1")).commit();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.mtxttrailers:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + videos.get(0))));
                break;

            case R.id.mtxttrailers1:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + videos.get(1))));
                break;
            case R.id.mtxttrailers2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + videos.get(2))));
                break;
            case R.id.mtxttrailers3:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + videos.get(3))));
                break;
            case R.id.mtxttrailers4:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + videos.get(4))));
                break;
            case R.id.mtxttrailers5:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + videos.get(5))));
                break;

            case R.id.btncomment:
                sendComment(edcomment.getText().toString());
                edcomment.setText("");
                break;


        }


    }

    private void sendComment(String text) {

        if (text.length() != 0) {
            String key = reference.push().getKey();
            reference.child(key).setValue(text);

        }

    }


}

