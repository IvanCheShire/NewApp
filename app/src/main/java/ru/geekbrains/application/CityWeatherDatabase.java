package ru.geekbrains.application;
import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {CityWeather.class}, version = 1)
public abstract class CityWeatherDatabase extends RoomDatabase{
    public abstract CityWeatherDao getCityWeatherDao();
}
