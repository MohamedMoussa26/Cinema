package com.example.emohamedmoussa.cinema;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import java.util.ArrayList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.emohamedmoussa.cinema.classes.Recitemclicklistner;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


public class moviesAdapter extends RecyclerView.Adapter<moviesAdapter.MovieVH> {

    ArrayList<movie> moviedetails;
    private Context context;
    Recitemclicklistner recitemclicklistner;

    public class MovieVH extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title, detail;
        private Recitemclicklistner recitemclicklistner;

        public MovieVH(View v) {
            super(v);
            Log.e("adapter", "1");
            img = (ImageView) v.findViewById(R.id.FMimg);
            title = (TextView) v.findViewById(R.id.FMtitle);
            detail = (TextView) v.findViewById(R.id.FMdetail);

            Log.e("recyyyy","4");
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("recyyyy","3");
                    recitemclicklistner.onitemclick(v,getLayoutPosition(),moviedetails.get(getLayoutPosition()),context);
                    Log.e("recyyyy","5");
                }
            });
        }


        public void setrecitemclicklistner(Recitemclicklistner recitemclicklistner){
            this.recitemclicklistner = recitemclicklistner;

        }
        
        
    }


    public void setAdapterrecitemclicklistner(Recitemclicklistner recitemclicklistner){
        this.recitemclicklistner = recitemclicklistner;
    }

    public moviesAdapter(Context context, ArrayList<movie> moviedetails) {
        this.moviedetails = moviedetails;
        this.context = context;
        Log.e("adapter", "2");

    }

    @NonNull
    @Override
    public moviesAdapter.MovieVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.moviecard, parent, false);


        Log.e("adapter", "4");
//        context = parent.getContext();
        return new moviesAdapter.MovieVH(itemview);

    }

    @Override
    public void onBindViewHolder(@NonNull final moviesAdapter.MovieVH holder, final int position) {
        Log.e("adapterssss", "5");
        final movie moviedetail = moviedetails.get(position);
//        Picasso.
        Picasso.get()
                .load(moviedetail.poster)
                .into(holder.img, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.e("adapterssss picasso", "done");
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.e("adapterssss picasso", "wrong");
                    }
                });


        holder.detail.setText(moviedetail.releasedate + " | " + moviedetail.lang);
        holder.title.setText(moviedetail.title);
        
        Log.e("adapter picasso", "" + moviedetail.background);


        Log.e("recyyyy","6");

        holder.setrecitemclicklistner(recitemclicklistner);

        Log.e("recyyyy","7");


//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Toast.makeText(context, "moudddsa", Toast.LENGTH_LONG).show();
//                context.startActivity(new Intent(context,MainActivity.class));
//
//
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return moviedetails.size();
    }

}
