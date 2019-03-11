package com.chemwater.mylibrary.retrofit.api;

import retrofit2.http.GET ;
import retrofit2.http.Query ;
import retrofit2.Call ;
import com.chemwater.mylibrary.retrofit.models.ForecastResponse ;
import com.chemwater.mylibrary.retrofit.models.WeatherResponse;


public interface WeatherInterface {
    @GET("forecast")
    Call<ForecastResponse> getCityForecast(@Query("appid") String appid, @Query("q") String city) ;

    @GET("forecast")
    Call<ForecastResponse> getLocationForecast(@Query("appid") String appid,
                                               @Query("lat") String latitude,
                                               @Query("lon") String longitude) ;

    @GET("weather")
    Call<WeatherResponse> getCityWeather(@Query("appid") String appid,
                                         @Query("q") String city);

    @GET("weather")
    Call<WeatherResponse> getLocationWeather(@Query("appid") String appid,
                                                  @Query("lat") String latitude,
                                                  @Query("lon") String longitude);
}

