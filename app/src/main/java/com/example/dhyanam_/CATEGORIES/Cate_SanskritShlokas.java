package com.example.dhyanam_.CATEGORIES;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dhyanam_.DashBoardActivity;
import com.example.dhyanam_.R;
import com.scwang.wave.MultiWaveHeader;

public class Cate_SanskritShlokas extends AppCompatActivity {
    public Button back_btn;
    public TextUtils.TruncateAt noneEllipsize;
    TextView textview1,textview2,reqmarquee;

    ImageView btPlay, btPause, btPlay2, btPause2;
    MediaPlayer mediaPlayer, mediaPlayer2;

    MultiWaveHeader waveHeader,waveFooter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cate__sanskrit_shlokas);

        reqmarquee=findViewById(R.id.reqmaruee);

        reqmarquee.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        reqmarquee.setSelected(true);
        reqmarquee.setHorizontallyScrolling(true);

        textview1=findViewById(R.id.textview1);
        textview1.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textview1.setSelected(true);
        textview1.setHorizontallyScrolling(true);


        textview2=findViewById(R.id.textview2);
        textview2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textview2.setSelected(true);
        textview2.setHorizontallyScrolling(true);






        waveHeader=findViewById(R.id.wave_header);
        waveFooter=findViewById(R.id.wave_footer);

        waveHeader.setVelocity(1);
        waveHeader.setProgress(1);
        waveHeader.isRunning();
        waveHeader.setGradientAngle(45);
        waveHeader.setWaveHeight(40);


        waveFooter.setVelocity(1);
        waveFooter.setProgress(1);
        waveFooter.isRunning();
        waveFooter.setGradientAngle(45);
        waveFooter.setWaveHeight(40);


        back_btn=findViewById(R.id.back_btn);




        btPause = findViewById(R.id.bt_pause);
        btPlay = findViewById(R.id.bt_play);


        btPause2 = findViewById(R.id.bt_pause2);
        btPlay2 = findViewById(R.id.bt_play2);



        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Cate_SanskritShlokas.this, DashBoardActivity.class));
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
                mediaPlayer.stop();
                mediaPlayer2.stop();
               

            }
        });

        //change raw files to sanskrit shoklas

        mediaPlayer = MediaPlayer.create(this, R.raw.om);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.gayatrimantra);
        //mediaPlayer3 = MediaPlayer.create(this, R.raw.morningsoundinagarden);


        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btPlay.setVisibility(View.GONE);

                btPause.setVisibility(View.VISIBLE);

                mediaPlayer.start();

//                mediaPlayer2.stop();
//                mediaPlayer3.stop();
//                mediaPlayer4.stop();
//                mediaPlayer5.stop();
//                mediaPlayer6.stop();

                textview2.setEllipsize(noneEllipsize);



            }
        });

        btPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btPause.setVisibility(View.GONE);

                btPlay.setVisibility(View.VISIBLE);

                mediaPlayer.pause();
                textview2.setEllipsize(TextUtils.TruncateAt.MARQUEE);



            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                btPause.setVisibility(View.GONE);
                btPlay.setVisibility(View.VISIBLE);
                mediaPlayer.seekTo(0);
            }
        });


//player2

        btPlay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btPlay2.setVisibility(View.GONE);

                btPause2.setVisibility(View.VISIBLE);

                mediaPlayer2.start();
                textview1.setEllipsize(noneEllipsize);



            }
        });

        btPause2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btPause2.setVisibility(View.GONE);

                btPlay2.setVisibility(View.VISIBLE);

                mediaPlayer2.pause();


            }
        });

        mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                btPause2.setVisibility(View.GONE);
                btPlay2.setVisibility(View.VISIBLE);
                mediaPlayer2.seekTo(0);
            }
        });


//player3
//
//
//        btPlay3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                btPlay3.setVisibility(View.GONE);
//
//                btPause3.setVisibility(View.VISIBLE);
//
//                mediaPlayer3.start();
//
//
//            }
//        });
//
//        btPause3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                btPause3.setVisibility(View.GONE);
//
//                btPlay3.setVisibility(View.VISIBLE);
//
//                mediaPlayer3.pause();
//
//
//            }
//        });
//
//        mediaPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                btPause3.setVisibility(View.GONE);
//                btPlay3.setVisibility(View.VISIBLE);
//                mediaPlayer3.seekTo(0);
//            }
//        });

    }




}