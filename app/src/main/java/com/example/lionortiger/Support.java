package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Support extends AppCompatActivity {
    TextView txtdetail,txtversion;
    ImageView imgme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        txtdetail=findViewById(R.id.txtdetail);
        txtversion=findViewById(R.id.txtversion);
        imgme=findViewById(R.id.imgme);
        imgme.setTranslationY(-2000);
        imgme.animate().setDuration(1000).translationYBy(2000);
        txtversion.setText("Version  =  "+BuildConfig.VERSION_NAME);
        txtdetail.setText("Developer = "+"Vishwas Ranjan"+"\n   Phone = 6371514362");
    }
}