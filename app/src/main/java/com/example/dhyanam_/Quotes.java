package com.example.dhyanam_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.anupkumarpanwar.scratchview.ScratchView;

import java.util.Random;

public class Quotes extends AppCompatActivity {

    Random random=new Random();
    TextView textViewNextQuote,reqmarquee;
    Button btnNextQuote,back_btn;
    CardView userprofile,homepage;
    ScratchView scratchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        back_btn=findViewById(R.id.back_btn);

        reqmarquee=findViewById(R.id.reqmaruee);

        reqmarquee.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        reqmarquee.setSelected(true);
        reqmarquee.setHorizontallyScrolling(true);

        textViewNextQuote=findViewById(R.id.textViewNextquote);
        btnNextQuote=findViewById(R.id.btnNextQuote);
        btnNextQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayQuote();
                scratchView.buildLayer();

            }
        });

        userprofile=findViewById(R.id.UserProfile);
        homepage=findViewById(R.id.homepage);

        scratchView=findViewById(R.id.scratch_view);


        scratchView.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                Toast.makeText(getApplicationContext(), "Reveled", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
                if (percent>=0.5) {
                    Log.d("Reveal Percentage", "onRevealPercentChangedListener: " + String.valueOf(percent));
                }
            }

        });


        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Quotes.this,DashBoardActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Quotes.this, DashBoardActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });
        displayQuote();
    }
    public  void displayQuote(){
        int randNum=random.nextInt((20+1)-1)+1;
        String randQuote="";
        switch (randNum){
            case 1:
                randQuote=getString(R.string.quote1);
                break;
            case 2:
                randQuote=getString(R.string.quote2);
                break;
            case 3:
                randQuote=getString(R.string.quote3);
                break;
            case 4:
                randQuote=getString(R.string.quote4);
                break;
            case 5:
                randQuote=getString(R.string.quote5);
                break;
            case 6:
                randQuote=getString(R.string.quote6);
                break;
            case 7:
                randQuote=getString(R.string.quote7);
                break;

            case 8:
                randQuote=getString(R.string.quote8);
                break;
            case 9:
                randQuote=getString(R.string.quote9);
                break;
            case 10:
                randQuote=getString(R.string.quote10);
                break;
            case 11:
                randQuote=getString(R.string.quote11);
                break;

            case 12:
                randQuote=getString(R.string.quote12);
                break;
            case 13:
                randQuote=getString(R.string.quote13);
                break;
            case 14:
                randQuote=getString(R.string.quote14);
                break;
            case 15:
                randQuote=getString(R.string.quote15);
                break;
            case 16:
                randQuote=getString(R.string.quote16);
                break;
            case 17:
                randQuote=getString(R.string.quote17);
                break;
            case 18:
                randQuote=getString(R.string.quote18);
                break;
            case 19:
                randQuote=getString(R.string.quote19);
                break;
            case 20:
                randQuote=getString(R.string.quote20);
                break;

        }
        textViewNextQuote.setText(randQuote);

        userprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Quotes.this,ProfileActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });
    }
}