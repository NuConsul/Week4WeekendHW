package com.chemwater.mylibrary;

import retrofit2.Call ;
import retrofit2.Response;

import com.chemwater.mylibrary.retrofit.api.ApiClient ;
import android.content.Context ;
import com.chemwater.mylibrary.retrofit.api.WeatherRetrofitCallback ;
import com.chemwater.mylibrary.retrofit.models.ForecastResponse ;
import com.chemwater.mylibrary.helper.CallbackForecast ;
import com.chemwater.mylibrary.retrofit.models.WeatherResponse ;
import com.chemwater.mylibrary.helper.CallbackWeather ;


public class MapForWeather {

    String APP_ID ;
    Context context ;

    public MapForWeather(Context context, String APP_ID) {
        this.APP_ID = APP_ID ;
        this.context = context ;
    }

    public void getForecastForCity(String city, final CallbackForecast callbackForecast) {
        final ApiClient objectApi = ApiClient.getInstance() ;
        try {
            Call objectCall = null ;

            objectCall = objectApi.getApi(context).getCityForecast(APP_ID, city) ;

            if(objectCall != null) {
                objectCall.enqueue(new WeatherRetrofitCallback<ForecastResponse>(context) {

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        callbackForecast.failure("Failed") ;
                        super.onFailure(call, t) ;
                    }

                    @Override
                    protected void onObservableWeatherResponse(Call call, Response response) {
                        if (!response.isSuccessful())
                            callbackForecast.failure("Failed") ;
                    }

                    @Override
                    protected void onObservableWeatherObject(Call call, ForecastResponse response) {
                        callbackForecast.success(response) ;
                    }

                    @Override
                    protected void goodMethod() {
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace() ;
        }
    }

    public void getForecastForLocation(String latitude, String longitude, final CallbackForecast callbackForecast) {
        final ApiClient objectApi = ApiClient.getInstance() ;
        try {
            Call objectCall = null ;

            objectCall = objectApi.getApi(context).getLocationForecast(APP_ID, latitude, longitude) ;

            if(objectCall != null) {
                objectCall.enqueue(new WeatherRetrofitCallback<ForecastResponse>(context) {

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        callbackForecast.failure("Failed") ;
                        super.onFailure(call, t) ;
                    }

                    @Override
                    protected void onObservableWeatherResponse(Call call, Response response) {
                        if(!response.isSuccessful())
                            callbackForecast.failure("Failed") ;
                    }

                    @Override
                    protected void onObservableWeatherObject(Call call, ForecastResponse response) {
                        callbackForecast.success(response) ;
                    }

                    @Override
                    protected void goodMethod() {

                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace() ;
        }
    }




    public void getWeatherForCity(String city, final CallbackWeather callbackWeather) {
        final ApiClient objectApi = ApiClient.getInstance() ;
        try {
            Call objectCall = null ;

            objectCall = objectApi.getApi(context).getCityWeather(APP_ID, city) ;

            if(objectCall != null) {
                objectCall.enqueue(new WeatherRetrofitCallback<WeatherResponse>(context) {

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        callbackWeather.failure("Failed") ;
                        super.onFailure(call, t) ;
                    }

                    @Override
                    protected void onObservableWeatherResponse(Call call, Response response) {
                        if(!response.isSuccessful())
                            callbackWeather.failure("Failed") ;
                    }

                    @Override
                    protected void onObservableWeatherObject(Call call, WeatherResponse response) {
                        callbackWeather.success(response) ;
                    }

                    @Override
                    protected void goodMethod() {

                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace() ;
        }
    }


    public void getLocationWeather(String latitude, String longitude, final CallbackWeather callbackWeather) {
        final ApiClient objectApi = ApiClient.getInstance() ;
        try {
            Call objectCall = null ;

            objectCall = objectApi.getApi(context).getLocationWeather(APP_ID, latitude, longitude) ;

            if (objectCall != null) {
                objectCall.enqueue(new WeatherRetrofitCallback<WeatherResponse>(context) {

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        callbackWeather.failure("Failed") ;
                        super.onFailure(call, t) ;
                    }


                    @Override
                    protected void onObservableWeatherResponse(Call call, Response response) {
                        if(!response.isSuccessful())
                            callbackWeather.failure("Failed") ;
                    }

                    @Override
                    protected void onObservableWeatherObject(Call call, WeatherResponse response) {
                        callbackWeather.success(response) ;
                    }

                    @Override
                    protected void goodMethod() {

                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace() ;
        }
    }


}
