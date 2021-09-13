package com.example.appnghenhac.Service;

import com.example.appnghenhac.Model.ChuDe;
import com.example.appnghenhac.Model.ChuDeVaTheLoai;
import com.example.appnghenhac.Model.Playlist;
import com.example.appnghenhac.Model.QuangCao;
import com.example.appnghenhac.Model.TheLoai;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataservice {
    @GET("songbanner.php")
    Call<List<QuangCao>> GetDataBanner();

    @GET("playlistcurrent.php")
    Call<List<Playlist>> GetDataPlaylistToday();

    @GET("chudevatheloai.php")
    Call<List<ChuDeVaTheLoai>> GetDataChuDeTheLoaiToDay();

}
