package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Menu_about extends AppCompatActivity {
    ImageView menu_about_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_about);
        menu_about_img=findViewById(R.id.imageView);
        menu_about_img.setTranslationX(-2000);
        menu_about_img.animate().setDuration(1000).rotation(3600).translationXBy(2000);
    }
}