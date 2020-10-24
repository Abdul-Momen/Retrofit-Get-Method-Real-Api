package com.nodeers.apps.jsonparseandroid;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OurRetrofitClient {

 /*     @GET("continents")
        Call<OurMainDataClass> getData(@Query("api_token") String token);
        */

        @GET("continents/{id}")
        Call<SpecipicObjectData> getData(@Path("id") int id,@Query("api_token") String token);

/*
        @GET("teams/{id}")
    Call<TeamClass> getData(@Path("id") int id, @Query("api_token") String token);


    @GET("players")
    Call<ArrayDesignClass> getPlayerData(@Query("api_token") String token
            , @Query("country_id") int cid
    );*/
}
