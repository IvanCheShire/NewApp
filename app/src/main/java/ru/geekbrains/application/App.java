package ru.geekbrains.application;
import android.app.Application;

import androidx.room.Room;


public class App extends Application{
    private static App instance;

    private CityWeatherDatabase db;
    public static App getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        db = Room.databaseBuilder(
                getApplicationContext(),
                CityWeatherDatabase.class,
                "city_database")
                .allowMainThreadQueries()
                .build();
    }
    public CityWeatherDao getCityWeatherDao(){
        return db.getCityWeatherDao();
    }


    }
