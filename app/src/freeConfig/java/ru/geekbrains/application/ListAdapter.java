package ru.geekbrains.application;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<String> data;
    private Activity activity;

    public ListAdapter(List<String> data, Activity activity){
        this.data = data;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        TextView textElement = holder.getTextElement();
        textElement.setText(data.get(position));

        // Так регистрируется контекстное меню
        if (activity != null){
            activity.registerForContextMenu(textElement);
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    void addItem(String element){
        data.add(element);
        notifyItemInserted(data.size()-1);
    }


    void updateItem(String element, int position){
        data.set(position, element);
        notifyItemChanged(position);
    }


    void removeItem(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }


    void clearItems(){
        data.clear();
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textElement;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textElement = itemView.findViewById(R.id.textElement);
        }

        public TextView getTextElement() {
            return textElement;
        }
    }

}
