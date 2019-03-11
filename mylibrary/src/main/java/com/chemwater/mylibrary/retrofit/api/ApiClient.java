package com.chemwater.mylibrary.retrofit.api;

import retrofit2.Retrofit ;
import retrofit2.converter.gson.GsonConverterFactory ;
import okhttp3.Interceptor ;
import okhttp3.OkHttpClient ;
import okhttp3.Request ;
import okhttp3.Response ;
import okhttp3.logging.HttpLoggingInterceptor ;

import android.content.Context ;
import android.support.annotation.NonNull ;

import java.io.IOException ;

public class ApiClient {

    private final String LIVE_DATA = "http://api.openweathermap.org/data/2.5/" ;
    private static ApiClient uniqueInstance ;

    private WeatherInterface weatherInterface ;

    public static synchronized ApiClient getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ApiClient() ;
        }
        return uniqueInstance ;
    }

    private void ApiClient(@NonNull final Context cuurentContext) {
        try {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor( ) ;
            //set your desired log level
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY) ;

            Interceptor headerInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request() ;
                    Request.Builder builder = original.newBuilder() ;
                    builder.method(original.method(), original.body()) ;

                    Request request = builder.build() ;


                    return chain.proceed(request) ;
                }
            } ;

            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .addInterceptor(headerInterceptor)
                    .addInterceptor(loggingInterceptor)
                    .build() ;
            String API_URL = LIVE_DATA ;

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build() ;

            weatherInterface = retrofit.create(WeatherInterface.class) ;
        } catch (Exception e) {
            e.printStackTrace() ;
        }
    }

    public WeatherInterface getApi(Context currentContext) {
        if(uniqueInstance == null) {
            getInstance() ;
        }

        uniqueInstance.ApiClient(currentContext) ;

        return weatherInterface ;
    }
}