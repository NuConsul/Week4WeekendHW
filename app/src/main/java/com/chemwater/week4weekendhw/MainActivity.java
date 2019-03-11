package com.chemwater.week4weekendhw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView ;
import android.widget.LinearLayout ;
import android.widget.ImageView ;
import android.widget.ImageButton ;
import android.widget.EditText ;
import android.support.v7.widget.CardView ;

import com.chemwater.mylibrary.retrofit.models.WeatherResponse;
import com.squareup.picasso.Picasso ;

//import butterknife.Bind ;
import butterknife.BindView ;
import butterknife.ButterKnife ;
import butterknife.OnClick ;
import com.chemwater.mylibrary.helper.* ;
import com.chemwater.mylibrary.helper.CallbackForecast ;
import com.chemwater.mylibrary.helper.TemperatureUnitConverter ;
import com.chemwater.mylibrary.MapForWeather ;
import com.chemwater.mylibrary.retrofit.models.ForecastResponse ;
import com.chemwater.mylibrary.retrofit.models.Weather ;

public class MainActivity extends AppCompatActivity {

    public final String APP_ID = BuildConfig.W_API_KEY ;
    String city = "Atlanta" ;

    @BindView(R.id.refresh)
    ImageButton refresh ;
    @BindView(R.id.weather_title)
    TextView weatherTitle ;
    @BindView(R.id.location)
    TextView location ;
    @BindView(R.id.temp)
    TextView temp ;
    @BindView(R.id.tvHumidity)
    TextView tvHumidity ;
    @BindView(R.id.tvPressure)
    TextView tvPressure ;
    @BindView(R.id.weather_icon)
    ImageView weatherIcon ;
    @BindView(R.id.condition)
    TextView condition ;
    @BindView(R.id.tvWind)
    TextView tvWind ;
    @BindView(R.id.tvWindDeg)
    TextView tvWindDeg ;
    @BindView(R.id.textLayout)
    LinearLayout textLayout ;
    @BindView(R.id.tv_go)
    TextView tvGo ;
    @BindView(R.id.et_city)
    EditText etCity ;
    @BindView(R.id.pres_desc)
    TextView presDesc ;
    @BindView(R.id.ws_desc)
    TextView wsDesc ;
    @BindView(R.id.wd_desc)
    TextView wdDesc ;
    @BindView(R.id.humidity_desc)
    TextView humidityDesc ;
    @BindView(R.id.ll_extraWeather)
    LinearLayout llExtraWeather ;
    @BindView(R.id.weatherCard)
    CardView weatherCard ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main) ;
        ButterKnife.bind(this) ;
        loadUpWeather(city);
    }

    @OnClick(R.id.refresh)
    public void refresh() {
        loadUpWeather(city) ;
    }

    private void loadUpWeather(String city){
        MapForWeather mapForWeather = new MapForWeather(this, APP_ID) ;
        mapForWeather.getForecastForCity(city, new CallbackForecast() {
            @Override
            public void success(ForecastResponse response) {
                ForecastResponse forecastResponse = response ;
            }

            @Override
            public void failure(String message) {

            }
        });

        mapForWeather.getWeatherForCity(city, new CallbackWeather() {
            @Override
            public void success(WeatherResponse response) {
                populateViewsWithWeather(response) ;
            }

            @Override
            public void failure(String message) {

            }
        });

    }


    private void populateViewsWithWeather(WeatherResponse response) {
        Weather weather[] = response.getWeather() ;
        condition.setText(weather[0].getMain()) ;
        temp.setText(TemperatureUnitConverter.convertToFahrenheit(response.getMain().getTemp()).intValue() + "C") ;
        location.setText(response.getName()) ;

        tvHumidity.setText(response.getMain().getHumidity() + "%") ;
        tvPressure.setText(response.getMain().getPressure() + " hPa") ;
        tvWind.setText(response.getWind().getSpeed() + "m/s") ;
        tvWindDeg.setText(response.getWind().getDeg() + "*") ;

        String link = weather[0].getIcon() ;
        Picasso.with(this).load(link).into(weatherIcon) ;
    }


    @OnClick(R.id.tv_go)
    public void go() {
        city = etCity.getText().toString().trim() ;
        loadUpWeather(city) ;
    }
}
