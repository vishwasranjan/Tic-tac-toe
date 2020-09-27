package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    EditText edtUsernameSignup,edtPasswordSignup,edtEmail;
    Button btnSignUp;
    TextView edtAlredyhaveanaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("Sign Up");
        edtEmail=findViewById(R.id.edtEmailSignup);
        edtPasswordSignup=findViewById(R.id.edtPasswordSignup);
        edtUsernameSignup=findViewById(R.id.edtUsernameSignup);
        btnSignUp=findViewById(R.id.btnSignup);
        btnSignUp.setOnClickListener(SignUp.this);
        edtAlredyhaveanaccount=findViewById(R.id.txtAlreadyHaveAccount);
        edtAlredyhaveanaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignUp.this,LogIn.class);
                startActivity(intent);
            }
        });
        if(ParseUser.getCurrentUser()!=null)
        {
            Intent intent = new Intent(SignUp.this, Front_activity.class);
            finish();
            startActivity(intent);
        }
    }


    @Override
    public void onClick(View v) {
        final ProgressDialog progressDialog=new ProgressDialog(SignUp.this);
        progressDialog.setMessage("Saving");
        progressDialog.show();
        ParseUser parseUser=new ParseUser();
        parseUser.setEmail(edtEmail.getText().toString());
        parseUser.setUsername(edtUsernameSignup.getText().toString());
        parseUser.setPassword(edtPasswordSignup.getText().toString());
        if (edtEmail.getText().equals("")||edtUsernameSignup.getText().equals("")||edtPasswordSignup.getText().equals(""))
        {
            progressDialog.dismiss();
            Toast.makeText(SignUp.this,"All are required",Toast.LENGTH_SHORT).show();
        }
        else {

            parseUser.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        progressDialog.dismiss();
                        Toast.makeText(SignUp.this, edtUsernameSignup.getText().toString() + " is signned up", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUp.this, Front_activity.class);
                        finish();
                        startActivity(intent);
                    } else {
                        Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }
            });
        }
    }
}