package com.example.appnghenhac.Service;

import com.example.appnghenhac.Model.QuangCao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataservice {
    @GET("songbanner.php")
    Call<List<QuangCao>> GetDataBanner();
}
