package ru.geekbrains.application;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class CityWeatherRecyclerAdapter extends RecyclerView.Adapter<CityWeatherRecyclerAdapter.ViewHolder> {
    private Activity activity;
    private CityWeatherSource dataSource;
    private long menuPosition;

    public CityWeatherRecyclerAdapter(CityWeatherSource dataSource, Activity activity) {
        this.dataSource = dataSource;
        this.activity = activity;
    }

    @NonNull
    @Override
    ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        List<CityWeather> cityWeathers = dataSource.getCityWeathers();
        CityWeather cityWeather = cityWeathers.get(position);
        holder.cityWeather.setText(cityWeather.city);
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                menuPosition = position;
                return false;
            }
        });
        if (activity != null) {
            activity.registerForContextMenu(holder.cardView);
        }
    }

    @Override
    public int getItemCount() {
        return (int) dataSource.getCountCityWeathers();
    }

    public long getMenuPosition() {
        return menuPosition;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView cityWeather;
        View cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView;
            cityWeather = cardView.findViewById(R.id.city_field);
        }
    }
}