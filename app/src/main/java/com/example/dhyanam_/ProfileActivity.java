package com.example.dhyanam_;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {


    private static final int CHOOSE_IMAGE = 1000;
    private Button logout,back_btn,reminder;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
  //  ImageView imageView;
    ProgressBar progressbar;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        reminder=findViewById(R.id.reminder);


        mAuth = FirebaseAuth.getInstance();

//        loadUserInformation();
        logout = findViewById(R.id.logout_btn);

        back_btn=findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProfileActivity.this, DashBoardActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });

        reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProfileActivity.this, reminder.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });


        progressbar = findViewById(R.id.progressbar);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                finish();
                 overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView greetingTextView = (TextView) findViewById(R.id.greeting);
        final TextView fullNameTextView = (TextView) findViewById(R.id.fullname);
        final TextView emailTextView = (TextView) findViewById(R.id.emailAddress);
        final TextView ageTextView = (TextView) findViewById(R.id.age);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);
                if (userProfile != null) {
                    String fullName = userProfile.name;
                    String email = userProfile.mail;
                    String age = userProfile.textage;

                    greetingTextView.setText("Welcome," + fullName + "!");
                    fullNameTextView.setText(fullName);
                    emailTextView.setText(email);
                    ageTextView.setText(age);
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ProfileActivity.this, "Something Wrong Happened", Toast.LENGTH_LONG).show();

            }
        });

    }

}
