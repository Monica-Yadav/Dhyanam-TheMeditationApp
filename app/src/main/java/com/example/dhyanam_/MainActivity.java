package com.example.dhyanam_;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //private Button phoneNo, rough;
    private EditText email_login, pass_login;
    private Button login_btn;


    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    //for Google SignIN(gs)
   // private Button mgsSignInBtn;
    private static final int RC_SIGN_IN = 9;
    TextView regTextview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //phoneNo = findViewById(R.id.MainphoneNumber);
        email_login = findViewById(R.id.email_login);
        pass_login = findViewById(R.id.pass_login);
        login_btn = findViewById(R.id.login_btn);
        //rough = findViewById(R.id.roughwork);

        progressBar = findViewById(R.id.progressbar);

        //registrationpage
        regTextview = findViewById(R.id.reg_textView);

        regTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterUser.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        //loginpage
        login_btn.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();


        //phoneNumber
//        phoneNo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,SendOTPActivity.class));
//            }
//        });


//        rough.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, DashBoardActivity.class));
//                finish();
//            }
//        });


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reg_textView:
                startActivity(new Intent(this, RegisterUser.class));
                break;
            case R.id.login_btn:
                userLogin();
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(MainActivity.this, DashBoardActivity.class));
        }

    }

    private void userLogin() {
        String email = email_login.getText().toString().trim();
        String password = pass_login.getText().toString().trim();

        if (email.isEmpty()) {
            email_login.setError("EMAIL IS REQUIRED");
            email_login.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            email_login.setError("please provide valid email");
            email_login.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            pass_login.setError("PASSWORD IS REQUIRED");
            pass_login.requestFocus();
            return;
        }

        if (password.length() < 6) {
            pass_login.setError("Minimum length of password should be 6 character");
            pass_login.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);


        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Toast.makeText(MainActivity.this, "login Successful", Toast.LENGTH_LONG).show();

                    startActivity(new Intent(MainActivity.this,DashBoardActivity.class));
                    //Intent intent = new Intent(MainActivity.this, DashBoardActivity.class);
                    //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    //startActivity(intent);

                } else {
                    Toast.makeText(MainActivity.this, "Failed to login ! please check your credentials", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}