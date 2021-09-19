package com.example.appnghenhac.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appnghenhac.Adapter.ViewPagerPlayListNhac;
import com.example.appnghenhac.Fragment.Fragment_Dia_Nhac;
import com.example.appnghenhac.Fragment.Fragment_PlayDanhSachCacBaiHat;
import com.example.appnghenhac.Model.BaiHat;
import com.example.appnghenhac.R;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PlayNhacActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView txttime, txttotasong;
    SeekBar seekBar;
    ImageButton imgplay, imgrepaet, imgnext, imgpre, imgrand;
    ViewPager viewPager;
    Fragment_Dia_Nhac fragment_dia_nhac;
    Fragment_PlayDanhSachCacBaiHat fragment_playDanhSachCacBaiHat;


    public static ViewPagerPlayListNhac adaterPlayListNhac;
    public static ArrayList<BaiHat> baiHatArrayList = new ArrayList<>();
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_nhac);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        GetDataFromIntent();
        init();
        eventClick();

    }

    private void eventClick() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(adaterPlayListNhac.getItem(1)!=null){
                    fragment_dia_nhac.Playnhac(baiHatArrayList.get(0).getHinhbaihat());
                    handler.removeCallbacks(this);
                }else {
                    handler.postDelayed(this,300);
                }
            }
        },500);
        imgplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    imgplay.setImageResource(R.drawable.iconplay);
                }else {
                    mediaPlayer.start();
                    imgplay.setImageResource(R.drawable.iconpause);
                }
            }
        });
    }

    private void GetDataFromIntent() {
        Intent intent =getIntent();
        baiHatArrayList.clear();
        if(intent!=null){
            if(intent.hasExtra("cakhuc")){
                BaiHat baiHat = intent.getParcelableExtra("cakhuc");
                baiHatArrayList.add(baiHat);
            }
            if(intent.hasExtra("cacbaihat")){
                baiHatArrayList = intent.getParcelableArrayListExtra("cacbaihat");
            }
        }

    }

    private void init() {
        toolbar = findViewById(R.id.toolbarplaynhac);
        txttime = findViewById(R.id.textviewtimesong);
        imgnext = findViewById(R.id.imagebuttonnext);
        imgplay = findViewById(R.id.imagebuttonplay);
        imgpre = findViewById(R.id.imagebuttonpreview);
        imgrand = findViewById(R.id.imagebuttonsuffle);
        imgrepaet = findViewById(R.id.imagebuttonrepeat);
        seekBar =findViewById(R.id.seekbarsong);
        viewPager = findViewById(R.id.viewpagerplaynhac);
        txttotasong = findViewById(R.id.textviewtatotime);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setTitleTextColor(Color.WHITE);
        fragment_dia_nhac = new Fragment_Dia_Nhac();
        fragment_playDanhSachCacBaiHat = new Fragment_PlayDanhSachCacBaiHat();
        adaterPlayListNhac = new ViewPagerPlayListNhac(getSupportFragmentManager());
        adaterPlayListNhac.AddFragment(fragment_playDanhSachCacBaiHat);
        adaterPlayListNhac.AddFragment(fragment_dia_nhac);
        viewPager.setAdapter( adaterPlayListNhac);
        fragment_dia_nhac = (Fragment_Dia_Nhac) adaterPlayListNhac.getItem(1);
        if(baiHatArrayList.size()>0){
            getSupportActionBar().setTitle(baiHatArrayList.get(0).getTenbaihat());
            new PlayMp3().execute(baiHatArrayList.get(0).getLinkbaihat());
            imgplay.setImageResource(R.drawable.iconpause);

        }
    }
    public class PlayMp3 extends AsyncTask<String,Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String baihat) {
            super.onPostExecute(baihat);

            try {
                mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
            });
                mediaPlayer.setDataSource(baihat);
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
            TimeSong();
        }
    }

    private void TimeSong() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        txttotasong.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
        seekBar.setMax(mediaPlayer.getDuration());
    }
}
