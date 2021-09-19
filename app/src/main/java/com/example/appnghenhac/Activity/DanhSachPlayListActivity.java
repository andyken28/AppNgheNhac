package com.example.appnghenhac.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.appnghenhac.Adapter.DanhSachCacPlayListAdapter;
import com.example.appnghenhac.Model.Playlist;
import com.example.appnghenhac.R;
import com.example.appnghenhac.Service.APIService;
import com.example.appnghenhac.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachPlayListActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
DanhSachCacPlayListAdapter danhSachCacPlayListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_play_list);
        anhxa();
        init();
        GetData();

    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Playlist>> callback = dataservice.GetDataDanhSachPlayList();
        callback.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                ArrayList<Playlist> playlistArrayList = (ArrayList<Playlist>) response.body();
                danhSachCacPlayListAdapter = new DanhSachCacPlayListAdapter(DanhSachPlayListActivity.this, playlistArrayList);
                recyclerView.setLayoutManager(new GridLayoutManager(DanhSachPlayListActivity.this,2));
                recyclerView.setAdapter(danhSachCacPlayListAdapter);
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

            }
        });
    }

    private  void init(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Play Lists");
        toolbar.setTitleTextColor(getResources().getColor(R.color.mautim));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void anhxa() {
        toolbar =findViewById(R.id.toolbardanhsachplaylist);
        recyclerView =findViewById(R.id.recyclerviewdanhsachplaylist);
    }

}
