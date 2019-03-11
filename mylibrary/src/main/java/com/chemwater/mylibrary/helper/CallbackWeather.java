package com.chemwater.mylibrary.helper;

import com.chemwater.mylibrary.retrofit.models.WeatherResponse;

public abstract class CallbackWeather {

    public abstract void success(WeatherResponse response) ;

    public abstract void failure(String message) ;

}