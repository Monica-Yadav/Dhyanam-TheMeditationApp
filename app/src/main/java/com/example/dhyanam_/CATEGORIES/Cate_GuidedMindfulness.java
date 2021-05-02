package com.example.dhyanam_.CATEGORIES;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dhyanam_.DashBoardActivity;
import com.example.dhyanam_.GUaudioPlayers.GUFiveMinBrAudioPlayer;
import com.example.dhyanam_.GUaudioPlayers.GUSixMinBrAudioPlayer;
import com.example.dhyanam_.GUaudioPlayers.GUTenMinBrAudioPlayer;
import com.example.dhyanam_.GUaudioPlayers.GUThreeMinBrAudioPlayer;
import com.example.dhyanam_.R;

public class Cate_GuidedMindfulness extends AppCompatActivity {
    private CardView category1,category2,category3,category4;
    TextView reqmarquee;


    private Button back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cate__guided_mindfulness);

        category1=findViewById(R.id.category1);
        category2=findViewById(R.id.category2);
        category3=findViewById(R.id.category3);
        category4=findViewById(R.id.category4);

        reqmarquee=findViewById(R.id.reqmaruee);

        reqmarquee.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        reqmarquee.setSelected(true);
        reqmarquee.setHorizontallyScrolling(true);


        back_btn=findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Cate_GuidedMindfulness.this, DashBoardActivity.class));
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        category1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Cate_GuidedMindfulness.this, GUThreeMinBrAudioPlayer.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });


        category2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Cate_GuidedMindfulness.this, GUFiveMinBrAudioPlayer.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });

        category3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Cate_GuidedMindfulness.this, GUSixMinBrAudioPlayer.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });

        category4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Cate_GuidedMindfulness.this, GUTenMinBrAudioPlayer.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });

    }
}