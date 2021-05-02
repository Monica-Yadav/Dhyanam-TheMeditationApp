package com.example.dhyanam_.CATEGORIES;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.dhyanam_.BSaudioPlayers.CompleteBSAP;
import com.example.dhyanam_.BSaudioPlayers.FourMinBSAP;
import com.example.dhyanam_.DashBoardActivity;
import com.example.dhyanam_.R;

public class Cate_BodyScan extends AppCompatActivity {

    private CardView Bcategory1,Bcategory2;
    private Button back_btn;
    TextView reqmarquee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cate__body_scan);

        Bcategory1=findViewById(R.id.Bcategory1);
        Bcategory2=findViewById(R.id.Bcategory2);


        reqmarquee=findViewById(R.id.reqmaruee);

        reqmarquee.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        reqmarquee.setSelected(true);
        reqmarquee.setHorizontallyScrolling(true);


        back_btn=findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Cate_BodyScan.this, DashBoardActivity.class));
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });



        Bcategory1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Cate_BodyScan.this, FourMinBSAP.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });

        Bcategory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Cate_BodyScan.this, CompleteBSAP.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });

    }
}