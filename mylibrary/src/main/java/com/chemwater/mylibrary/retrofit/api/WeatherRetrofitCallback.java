package com.chemwater.mylibrary.retrofit.api;

import retrofit2.Response ;
import retrofit2.Callback ;
import retrofit2.Call ;

import android.app.Activity ;
import android.content.Context ;

public abstract class WeatherRetrofitCallback<S> implements Callback {
    Context context ;
    Activity activity ;

    public WeatherRetrofitCallback(Activity activity) {
        this.activity = activity ;
    }

    public WeatherRetrofitCallback(Context context) {
        this.context = context ;
    }


    @Override
    public void onResponse(Call call, Response response) {
        goodMethod() ;
        onObservableWeatherResponse(call, response) ;

        Object object = response.body() ;
        if (object != null) {
            S objectResponse = (S) object ;
            onObservableWeatherObject(call, objectResponse) ;
        }
    }


    @Override
    public void onFailure(Call call, Throwable t) {
        goodMethod() ;
    }


    //Invoked for a received HTTP response.
    //An HTTP response may still indicate an application-level failure such as a 404 or 500

    protected abstract void onObservableWeatherResponse(Call call, Response response) ;

    //Invoked for a received HTTP response
    //An HTTP response may still indicate an application-level failure such as a 404 or 500

    protected  abstract void onObservableWeatherObject(Call call, S response) ;

    protected  abstract  void goodMethod() ;
}
