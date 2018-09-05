//package com.example.emohamedmoussa.cinema;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//public class movieRec extends RecyclerView.Adapter<movieRec.MovieVH> {
//
//    ArrayList<movietst> moviedetails;
//
//    public class MovieVH extends RecyclerView.ViewHolder {
//        ImageView img;
//        TextView title, detail;
//
//        public MovieVH(View v) {
//            super(v);
//            Log.e("adapter","1");
//            img = (ImageView) v.findViewById(R.id.FMimg);
//            title = (TextView) v.findViewById(R.id.FMtitle);
//            detail = (TextView) v.findViewById(R.id.FMdetail);
//
//        }
//    }
//
//public movieRec(Context context, ArrayList<movietst> moviedetails){
//        this.moviedetails = moviedetails;
//    Log.e("adapter","2");
//}
//    @NonNull
//    @Override
//    public MovieVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        Log.e("adapter","3");
//        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.moviecard,parent,false);
//        Log.e("adapter","4");
//
//        return new MovieVH(itemview);
//
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MovieVH holder, int position) {
//        Log.e("adapter","5");
//        movietst moviedetail = moviedetails.get(position);
//        holder.img.setImageResource(R.drawable.m1);
//        holder.detail.setText("mousa");
//        holder.title.setText("MOHAMED");
//        Log.e("adapter","6");
//
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return moviedetails.size();
//    }
//
//
//}
