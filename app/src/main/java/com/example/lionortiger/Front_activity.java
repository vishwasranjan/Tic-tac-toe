package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Front_activity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtPlay,txtRules,txtExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_activity);
        txtExit=findViewById(R.id.txtExit);
        txtPlay=findViewById(R.id.txtplay);
        txtRules=findViewById(R.id.txtRule);
        txtRules.setOnClickListener(Front_activity.this);
        txtPlay.setOnClickListener(Front_activity.this);
        txtExit.setOnClickListener(Front_activity.this);
    }

    @Override
    public void onClick(View view) {
        TextView textView=(TextView)view;
        switch (textView.getId()){
            case R.id.txtplay:
                Intent intent=new Intent(Front_activity.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.txtExit:
                finish();
                break;
            case R.id.txtRule:
                Intent intentrules=new Intent(Front_activity.this,Rules.class);
                startActivity(intentrules);
                break;
        }
    }
}