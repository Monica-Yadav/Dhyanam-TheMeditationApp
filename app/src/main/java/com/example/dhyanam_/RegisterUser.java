package com.example.dhyanam_;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {

    private TextView banner,registerUser;
    private EditText fullname,age,email,password;
    private ProgressBar progressbar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();

        banner=findViewById(R.id.banner);
        banner.setOnClickListener(this);

        registerUser=findViewById(R.id.registerUser);
        registerUser.setOnClickListener(this);


        fullname=findViewById(R.id.fullname);
        age=findViewById(R.id.age);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);

        progressbar=findViewById(R.id.progressbar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.banner:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case  R.id.registerUser:
                registerUser();
                break;
        }
    }

    private void registerUser() {

        final String mail=email.getText().toString().trim();
        String pass=password.getText().toString().trim();
        final String name=fullname.getText().toString().trim();
        final String textage=age.getText().toString().trim();


        if (name.isEmpty()){
            fullname.setError("FULL NAME IS REQUIRED");
            fullname.requestFocus();
            return;
        }
        if(!name.matches("^[a-zA-Z\\s]+$")){
            fullname.setError("PLEASE PROVIDE VALID NAME");
            fullname.requestFocus();
            return;
        }

        if (textage.isEmpty()){
            age.setError("AGE IS REQUIRED");
            age.requestFocus();
            return;
        }
        if(!textage.matches("^([1][6-9]|[2-5][0-9]|[8][0-5])$" )){
            age.setError("PLEASE PROVIDE VALID AGE");
            age.requestFocus();
            return;
        }





        if (mail.isEmpty()){
            email.setError("EMAIL IS REQUIRED");
            email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            email.setError("PLEASE PROVIDE VALID EMAIL");
            email.requestFocus();
            return;
        }

        if (pass.isEmpty()){
            password.setError("PASSWORD IS REQUIRED");
            password.requestFocus();
            return;
        }

        if (pass.length()<6){
            password.setError("MINIMUM LENGTH OF PASSWORD SHOULD BE 6 CHARACTER");
            password.requestFocus();
            return;
        }

        //progressbar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(mail,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            User user=new User(name,textage,mail);
                            startActivity(new Intent(RegisterUser.this,DashBoardActivity.class));

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(RegisterUser.this,"User has been registered succesfully!",Toast.LENGTH_LONG).show();
                                        startActivity(new Intent(RegisterUser.this,DashBoardActivity.class));
                                        //progressbar.setVisibility(View.GONE);
                                    }else {
                                        Toast.makeText(RegisterUser.this,"Failed to register!Try Again",Toast.LENGTH_LONG).show();
                                        //progressbar.setVisibility(View.GONE);
                                    }
                                }
                            });
                        }else {
                            Toast.makeText(RegisterUser.this,"Failed to register!Try Again",Toast.LENGTH_LONG).show();
                            //progressbar.setVisibility(View.GONE);
                        }
                    }
                });




    }
}