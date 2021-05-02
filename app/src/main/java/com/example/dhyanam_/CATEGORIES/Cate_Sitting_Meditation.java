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

import com.example.dhyanam_.R;
import com.example.dhyanam_.SMaudioPlayer.BSBaudioPlayer;
import com.example.dhyanam_.SMaudioPlayer.CBaudioplayer;

public class Cate_Sitting_Meditation extends AppCompatActivity {
    private CardView Scategory1,Scategory2;
    private Button back_btn;
    TextView reqmarquee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cate__sitting__meditation);

        Scategory1=findViewById(R.id.Scategory1);
        Scategory2=findViewById(R.id.Scategory2);

        reqmarquee=findViewById(R.id.reqmaruee);

        reqmarquee.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        reqmarquee.setSelected(true);
        reqmarquee.setHorizontallyScrolling(true);

        back_btn=findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Cate_Sitting_Meditation.this, DashBoardActivity.class));
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });





        Scategory1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Cate_Sitting_Meditation.this, BSBaudioPlayer.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });

        Scategory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Cate_Sitting_Meditation.this, CBaudioplayer.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });



    }
}