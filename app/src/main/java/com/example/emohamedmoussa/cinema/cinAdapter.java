package com.example.emohamedmoussa.cinema;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class cinAdapter extends BaseAdapter {


    ArrayList<cinPlace> cinemas;
    Context context;

    public cinAdapter(ArrayList<cinPlace> cinemas, Context context) {
        this.cinemas = cinemas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return cinemas.size();
    }

    @Override
    public cinPlace getItem(int position) {
        return cinemas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        cinholder cinholder = null;

        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.cinitem, parent, false);
            cinholder = new cinholder(convertView);
            convertView.setTag(cinholder);
        } else {
            cinholder = (cinholder) convertView.getTag();

        }

        cinholder.rate.setText((cinemas.get(position)).rating);
        cinholder.title.setText((cinemas.get(position)).name);
        cinholder.detail.setText((cinemas.get(position)).vicinity);
        cinholder.imageView.setImageResource(R.drawable.cin);
//        Picasso.get().load((cinemas.get(position)).icon).into(cinholder.imageView);


        return convertView;
    }


    public class cinholder {

        ImageView imageView;
        TextView title, detail,rate;

        cinholder(View v) {
            rate = (TextView) v.findViewById(R.id.cinemarate);
            imageView = (ImageView) v.findViewById(R.id.cinimg);
            title = (TextView) v.findViewById(R.id.cinname);
            detail = (TextView) v.findViewById(R.id.cindetails);
        }

    }
}
