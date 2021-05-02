package com.example.dhyanam_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dhyanam_.CATEGORIES.Ambience;
import com.example.dhyanam_.CATEGORIES.Cate_BodyScan;
import com.example.dhyanam_.CATEGORIES.Cate_GuidedMindfulness;
import com.example.dhyanam_.CATEGORIES.Cate_NatureVibes;
import com.example.dhyanam_.CATEGORIES.Cate_RecommendedByPro;
import com.example.dhyanam_.CATEGORIES.Cate_SanskritShlokas;
import com.example.dhyanam_.CATEGORIES.Cate_Sitting_Meditation;
import com.google.firebase.auth.FirebaseAuth;

public class DashBoardActivity extends AppCompatActivity {

    //private Button signOutBtn;
    private FirebaseAuth mAuth;
    private CardView cardView1, cardView2, cardView3,cardView4,cardView5, userprofile,quotes,cardView6,cardView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        //signOutBtn = findViewById(R.id.get_started_btn);
        cardView1 = findViewById(R.id.cardview1);
        cardView2 = findViewById(R.id.cardview2);
        cardView3 = findViewById(R.id.cardview3);
        cardView4 = findViewById(R.id.cardview4);
        cardView5=findViewById(R.id.cardview5);
        cardView6=findViewById(R.id.cardview6);
        cardView7=findViewById(R.id.cardview7);
        quotes=findViewById(R.id.quotes);



        userprofile = findViewById(R.id.UserProfile);


        mAuth = FirebaseAuth.getInstance();

//        signOutBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mAuth.signOut();
//                startActivity(new Intent(DashBoardActivity.this, MainActivity.class));
//                finish();
//                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
//            }
//        });

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoardActivity.this, Cate_GuidedMindfulness.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoardActivity.this, Cate_BodyScan.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoardActivity.this, Cate_Sitting_Meditation.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoardActivity.this, Cate_SanskritShlokas.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoardActivity.this, Cate_NatureVibes.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });

        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoardActivity.this, Cate_RecommendedByPro.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });
        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashBoardActivity.this, Ambience.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });





        userprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DashBoardActivity.this,ProfileActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        quotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashBoardActivity.this,Quotes.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });




    }

}