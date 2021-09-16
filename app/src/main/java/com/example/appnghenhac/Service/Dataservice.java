package com.example.appnghenhac.Service;

import com.example.appnghenhac.Model.Album;
import com.example.appnghenhac.Model.BaiHat;
import com.example.appnghenhac.Model.ChuDeVaTheLoai;
import com.example.appnghenhac.Model.Playlist;
import com.example.appnghenhac.Model.QuangCao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {
    @GET("songbanner.php")
    Call<List<QuangCao>> GetDataBanner();

    @GET("playlistcurrent.php")
    Call<List<Playlist>> GetDataPlaylistToday();

    @GET("chudevatheloai.php")
    Call<List<ChuDeVaTheLoai>> GetDataChuDeTheLoaiToDay();

    @GET("albumhot.php")
    Call<List<Album>> GetDataAlbumHot();

    @GET("baihatduocyeuthich.php")
    Call<List<BaiHat>> GetDataBaiHatDuocYeuThich();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>> GetDataDanhSachBaiHatQuangCao(@Field("idquangcao") String idquangcao);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>> GetDataDanhSachBaiHatPlayList(@Field("idplaylist") String idplaylist);


}
