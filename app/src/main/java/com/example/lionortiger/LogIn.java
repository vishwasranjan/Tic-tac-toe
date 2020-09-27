package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LogIn extends AppCompatActivity implements View.OnClickListener {
    EditText edtUsername,edtPassword;
    Button btnLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        setTitle("Log In");
        edtPassword=findViewById(R.id.edtPassword);
        edtUsername=findViewById(R.id.edtUsername);
        btnLogIn=findViewById(R.id.btnlogin);
        btnLogIn.setOnClickListener(LogIn.this);
    }

    @Override
    public void onClick(View view) {
        final ProgressDialog progressDialog=new ProgressDialog(LogIn.this);
        progressDialog.setMessage("Saving");
        progressDialog.show();
        ParseUser.logInInBackground(edtUsername.getText().toString(), edtPassword.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (user!=null&&e==null)
                {
                    progressDialog.dismiss();
                    Toast.makeText(LogIn.this,"Welcome "+ParseUser.getCurrentUser().getUsername(),Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LogIn.this,Front_activity.class);
                    finish();
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LogIn.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
        });
    }
}