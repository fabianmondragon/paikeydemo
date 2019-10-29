package com.cyxtera.fabianmondragon.myapplication.conexion;

import com.cyxtera.fabianmondragon.myapplication.models.MovieStore;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviAPI {

    @GET("popular")
    Call<MovieStore> loadChanges(@Query("api_key") String status, @Query("language") String language, @Query("page") String page );

}
