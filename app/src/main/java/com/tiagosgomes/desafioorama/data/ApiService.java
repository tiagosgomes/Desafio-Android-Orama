package com.tiagosgomes.desafioorama.data;

import com.tiagosgomes.desafioorama.domain.Fund;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("orama-media/json/fund_detail_full.json?serializ%20er=fund_detail_full")
    Call<List<Fund>> getFunds();
}