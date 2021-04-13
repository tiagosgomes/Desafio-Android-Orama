package com.tiagosgomes.desafioorama.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tiagosgomes.desafioorama.BuildConfig;
import com.tiagosgomes.desafioorama.domain.Fund;
import com.tiagosgomes.desafioorama.domain.FundDeserializer;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitClient {

    private static Retrofit sRetrofit = null;

    static Retrofit getInstance() {
        if (sRetrofit == null) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Fund.class, new FundDeserializer());
            Gson gson = gsonBuilder.create();

            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.API_HOST)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return sRetrofit;
    }
}