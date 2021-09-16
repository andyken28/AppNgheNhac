package com.example.appnghenhac.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appnghenhac.Adapter.DanhSachBaiHatAdapter;
import com.example.appnghenhac.Model.BaiHat;
import com.example.appnghenhac.Model.Playlist;
import com.example.appnghenhac.Model.QuangCao;
import com.example.appnghenhac.R;
import com.example.appnghenhac.Service.APIService;
import com.example.appnghenhac.Service.Dataservice;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachBaiHatActivity extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;

    RecyclerView recyclerView;
    Toolbar toolbar;
    FloatingActionButton floatingActionButton;
    ImageView imageViewhinhanh;
    DanhSachBaiHatAdapter danhSachBaiHatAdapter;


    QuangCao quangCao;

    Playlist playlist;
    ArrayList<BaiHat> baiHatArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachbaihat);
        anhxa();
        DataIntent();
        init();
        if(quangCao != null && !quangCao.getTenBaiHat().equals("")){
            setValueInView(quangCao.getTenBaiHat(),quangCao.getHinhAnh(),quangCao.getHinhBaiHat());
            getDataQuangCao(quangCao.getIdQuangCao());
        }
        if(playlist != null && !playlist.getIdplaylist().equals("")){
            setValueInView(playlist.getTen(),playlist.getHinhanh(),playlist.getIcon());
            getDataPlayList(playlist.getIdplaylist());
        }
    }

    private void getDataQuangCao(String idquangcao) {
        Dataservice dataservice = APIService.getService();
        Call<List<BaiHat>> callback = dataservice.GetDataDanhSachBaiHatQuangCao(idquangcao);
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                baiHatArrayList = new ArrayList<>();
                baiHatArrayList = (ArrayList<BaiHat>) response.body();

                if (baiHatArrayList.size()>0){
                    danhSachBaiHatAdapter = new DanhSachBaiHatAdapter(DanhSachBaiHatActivity.this,baiHatArrayList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(DanhSachBaiHatActivity.this));
                    recyclerView.setAdapter(danhSachBaiHatAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });
    }

    private void getDataPlayList(String idplaylist) {
        Dataservice dataservice = APIService.getService();
        Call<List<BaiHat>> callback = dataservice.GetDataDanhSachBaiHatPlayList(idplaylist);
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                baiHatArrayList = new ArrayList<>();
                baiHatArrayList = (ArrayList<BaiHat>) response.body();
                if (baiHatArrayList.size()>0){
                    danhSachBaiHatAdapter = new DanhSachBaiHatAdapter(DanhSachBaiHatActivity.this,baiHatArrayList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(DanhSachBaiHatActivity.this));
                    recyclerView.setAdapter(danhSachBaiHatAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });
    }

    private void setValueInView(String ten, String hinh,String hinh1) {
        collapsingToolbarLayout.setTitle(ten);
        try {
            URL url = new URL(hinh);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(),bitmap);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                collapsingToolbarLayout.setBackground(bitmapDrawable);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Picasso.with(this).load(hinh1).into(imageViewhinhanh);
    }

    private  void init(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);

    }
    private void anhxa() {
        coordinatorLayout = findViewById(R.id.coordinatorlayout);
        collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar);
        recyclerView = findViewById(R.id.recyclerviewdanhsachbaihat);
        floatingActionButton = findViewById(R.id.floatingactionbutton);
        toolbar =findViewById(R.id.toolbardanhsach);
        imageViewhinhanh = findViewById(R.id.imageviewdanhsachcakhuc);
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if(intent!=null){
            if(intent.hasExtra("banner")){
                quangCao = (QuangCao) intent.getSerializableExtra("banner");
                Toast.makeText(this, quangCao.getTenBaiHat(), Toast.LENGTH_SHORT).show();
            }
            if (intent.hasExtra("itemplaylist")){
                playlist = (Playlist) intent.getSerializableExtra("itemplaylist");
                Toast.makeText(this, playlist.getTen(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
