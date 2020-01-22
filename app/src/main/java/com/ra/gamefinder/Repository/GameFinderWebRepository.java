package com.ra.gamefinder.Repository;

import android.os.StrictMode;
import android.util.Log;

import com.ra.gamefinder.WebService.GameFromWeb;
import com.ra.gamefinder.WebService.RetAPI;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GameFinderWebRepository {
    OkHttpClient okHttpClient;
    Retrofit retrofit;
    RetAPI retAPI;
    GameFromWeb gameFromWeb2;
    List<GameFromWeb> games2;
    Boolean b = false;

    public GameFinderWebRepository() {

        initializeConnections();
        getAllGamesFromWeb();
        getGameDetailsFromWeb();

    }

    private void initializeConnections() {

        if (android.os.Build.VERSION.SDK_INT > 9)
    {
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
        //okHttp
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        //retrofit instance
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

    }

    public void getAllGamesFromWeb(){
        retAPI = retrofit.create(RetAPI.class);
        Call<List<GameFromWeb>> callAllGames = retAPI.getAllGames();
        callAllGames.enqueue(new Callback<List<GameFromWeb>>() {
            @Override
            public void onResponse(Call<List<GameFromWeb>> call, Response<List<GameFromWeb>> response) {
                List<GameFromWeb> games = response.body();
                setGames(games);
                b = true;
            }

            @Override
            public void onFailure(Call<List<GameFromWeb>> call, Throwable t) {

            }
        });

    }

    public void getGameDetailsFromWeb(){
        retAPI = retrofit.create(RetAPI.class);
        Call<GameFromWeb> callGameDetail = retAPI.getGameDetails();
        callGameDetail.enqueue(new Callback<GameFromWeb>() {
            @Override
            public void onResponse(Call<GameFromWeb> call, Response<GameFromWeb> response) {
                GameFromWeb gameFromWeb = response.body();
                setGameDetails(gameFromWeb);
            }

            @Override
            public void onFailure(Call<GameFromWeb> call, Throwable t) {
            }
        });


    }
    public void setGames(List<GameFromWeb> games) {
        games2 = games;
    }

    public List<GameFromWeb> getGames(){
        return games2;
    }

    public void setGameDetails(GameFromWeb gameDetails){
        gameFromWeb2 = gameDetails;
    }
    public GameFromWeb getGameDetails(){
        return gameFromWeb2;
    }
}
