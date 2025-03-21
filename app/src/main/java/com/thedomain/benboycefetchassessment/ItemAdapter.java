package com.thedomain.benboycefetchassessment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    private final ArrayList<Item> dataset;

    private final Context context;

    public ItemAdapter(Context context) {
        dataset = new ArrayList<>();
        this.context = context;
    }

    public ItemAdapter(Context context, ArrayList<Item> dataset) {
        this.context = context;
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id.setText(String.valueOf(dataset.get(position).getId()));
        holder.name.setText(dataset.get(position).getName());
        holder.listId.setText(String.valueOf(dataset.get(position).getListId()));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView name;
        TextView listId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.itemId);
            name = itemView.findViewById(R.id.itemName);
            listId = itemView.findViewById(R.id.itemListId);
        }
    }
}
