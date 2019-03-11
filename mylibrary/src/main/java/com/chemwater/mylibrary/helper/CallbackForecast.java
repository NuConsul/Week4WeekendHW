package com.chemwater.mylibrary.helper;

import  com.chemwater.mylibrary.retrofit.models.ForecastResponse ;

public abstract  class CallbackForecast {
    public abstract void success(ForecastResponse response) ;

    public abstract void failure(String message) ;
}