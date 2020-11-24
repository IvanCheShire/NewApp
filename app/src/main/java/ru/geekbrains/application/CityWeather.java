package ru.geekbrains.application;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
@Entity(indices = {@Index(value = "city")})
public class CityWeather {
    @PrimaryKey(autoGenerate = true)
    public long id;
    @ColumnInfo(name = "city")
    public String city;
}
