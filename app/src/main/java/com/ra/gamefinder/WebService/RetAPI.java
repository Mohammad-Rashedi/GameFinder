package com.ra.gamefinder.WebService;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetAPI {
    @GET("bins/1bjyoa")
    Call<GameFromWeb> getGameDetails();

    @GET("bins/pnfbu")
    Call<List<GameFromWeb>> getAllGames();
}
