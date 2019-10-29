package com.cyxtera.fabianmondragon.myapplication.conexion;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.cyxtera.fabianmondragon.myapplication.models.MovieStore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ControllerAPI implements  Callback<MovieStore>{

    static final String BASE_URL = "https://api.themoviedb.org/3/movie/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MoviAPI controllerAPI = retrofit.create(MoviAPI.class);

        Call<MovieStore> call = controllerAPI.loadChanges("0f6c06b1df72667cfd66e0b1b2108c37", "es", "1");
        call.enqueue( this);

        //Request{method=GET, url=https://api.themoviedb.org/3/movie/popular/api_key&language&page?apikey=0f6c06b1df72667cfd66e0b1b2108c37&language=es&page=1, tag=null}

    }

    @Override
    public void onResponse(Call<MovieStore> call, Response<MovieStore> response) {
        if(response.isSuccessful()) {
            List<MovieStore> changesList = (List<MovieStore>) response.body();
           // changesList.forEach(change -> System.out.println(change.subject));
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<MovieStore> call, Throwable t) {
        t.printStackTrace();
    }
}
