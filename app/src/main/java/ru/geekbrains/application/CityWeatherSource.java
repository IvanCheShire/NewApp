package ru.geekbrains.application;
import java.util.List;
import ru.geekbrains.application.CityWeatherDao;
import ru.geekbrains.application.CityWeather;
public class CityWeatherSource {
    private final CityWeatherDao cityWeatherDao;
    private List<CityWeather> cityWeathers;
    public CityWeatherSource (CityWeatherDao cityWeatherDao){
        this.cityWeatherDao = cityWeatherDao;
    }
    public List<CityWeather> getCityWeathers(){
        if (cityWeathers == null){
            LoadCityWeathers();
        }
        return cityWeathers;
    }
    public void LoadCityWeathers(){
        cityWeathers = cityWeatherDao.getAllCities();
    }
    public long getCountCityWeathers(){
        return cityWeatherDao.getCountCities();
    }
    public void addCityWeather (CityWeather cityWeather){
        cityWeatherDao.insertCity(cityWeather);
        LoadCityWeathers();
    }
    public void updateCityWeather (CityWeather cityWeather){
        cityWeatherDao.updateCity(cityWeather);
        LoadCityWeathers();
    }
    public void removeCityWeather (long id){
        cityWeatherDao.deleteCityByID(id);
        LoadCityWeathers();
    }




}


