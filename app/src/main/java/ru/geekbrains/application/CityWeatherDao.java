package ru.geekbrains.application;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface CityWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCity(CityWeather cityWeather);
    @Update
    void updateCity (CityWeather cityWeather);
    @Delete
    void deleteCity (CityWeather cityWeather);
    @Query("DELETE FROM cityWeather WHERE id = :id")
    void deleteCityByID(long id);
    @Query("SELECT * FROM cityWeather")
    List<CityWeather> getAllCities();
    @Query("SELECT FROM cityWeather WHERE id = :id")
    CityWeather selectCityByID(long id);
    @Query("SELECT COUNT() FROM cityWeather")
    long getCountCities();
}
