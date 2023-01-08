package com.si5a.orphanagehouse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterGrid extends RecyclerView.Adapter<AdapterGrid.GridViewHolder> {
    private ArrayList<ModelPanti> dataPanti;

    public AdapterGrid(ArrayList<ModelPanti> dataPanti) {this.dataPanti = dataPanti; }

    public interface OnItemClickCallBack {
        void OnItemClicked(ModelPanti data);
    }

    private AdapterGrid.OnItemClickCallBack callBack;
    public void SetOnItemClickCallBack(OnItemClickCallBack callBack) {this.callBack = callBack; }

    @NonNull
    @Override
    public AdapterGrid.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_panti, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGrid.GridViewHolder holder, int position) {
        ModelPanti panti = dataPanti.get(position);

        Glide.with(holder.itemView.getContext()).load(panti.getFoto()).into(holder.ivGridPanti);
    }

    @Override
    public int getItemCount() {
        return dataPanti.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGridPanti;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGridPanti = itemView.findViewById(R.id.iv_grid_panti);
        }
    }
}
