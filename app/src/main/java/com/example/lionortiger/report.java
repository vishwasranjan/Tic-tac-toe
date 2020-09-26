package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class report extends AppCompatActivity implements View.OnClickListener {
    EditText txtQuery;
    Button btnSubmit;
    ImageView imageViewThankyou;
    TextView txtsubmitanother;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        setTitle("Report");
        imageViewThankyou=findViewById(R.id.imageViewThankyou);
        txtQuery=findViewById(R.id.txtQuery);
        btnSubmit=findViewById(R.id.btnsubmit);
        txtsubmitanother=findViewById(R.id.textViewSubmitanother);
        btnSubmit.setOnClickListener(report.this);
        txtsubmitanother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSubmit.setVisibility(View.VISIBLE);
                imageViewThankyou.animate().rotation(360*4).translationX(1000f);
                txtsubmitanother.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onClick(View v) {
        final ProgressDialog progressDialog=new ProgressDialog(report.this);
        progressDialog.setMessage("Saving");
        progressDialog.show();
        ParseObject parseUser=new ParseObject("Query");
        parseUser.put("Query",ParseUser.getCurrentUser().getUsername()+" - "+txtQuery.getText().toString());
        if (txtQuery.getText().equals("")){
            Toast.makeText(report.this,"Type Something", Toast.LENGTH_SHORT).show();
        }
        else {
            parseUser.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        progressDialog.dismiss();
                        imageViewThankyou.animate().alpha(1).setDuration(2000);
                        btnSubmit.setVisibility(View.GONE);
                        txtsubmitanother.setVisibility(View.VISIBLE);

                    } else {
                        Toast.makeText(report.this, "Something Went wrong...Please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}