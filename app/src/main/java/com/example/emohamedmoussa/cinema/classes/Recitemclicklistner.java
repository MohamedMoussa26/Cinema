package com.example.emohamedmoussa.cinema.classes;

import android.content.Context;
import android.view.View;

import com.example.emohamedmoussa.cinema.movie;

public interface Recitemclicklistner {
    public void onitemclick(View view, int position, movie movie, Context context);
}
