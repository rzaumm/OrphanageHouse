package com.si5a.orphanagehouse;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.CardViewHolder> {
    private ArrayList<ModelPanti> dataPanti;
    private Context ctx;

    public AdapterCard(ArrayList<ModelPanti> dataPanti, Context ctx) {
        this.dataPanti = dataPanti;
        this.ctx = ctx;

    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.item_card, parent, false);
        return new CardViewHolder(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        ModelPanti panti = dataPanti.get(position);
        holder.tvNama.setText(panti.getNama());
        holder.tvTentang.setText(panti.getTentang());

        Glide
                .with(ctx)
                .load(panti.getFoto())
                .centerCrop()
                .into(holder.ivFoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String xNama, xTentang, xFoto;

                xNama = panti.getNama();
                xTentang = panti.getTentang();
                xFoto = panti.getFoto();

                Intent kirim = new Intent(ctx, DetailActivity.class);
                kirim.putExtra("xNama", xNama);
                kirim.putExtra("xTentang", xTentang);
                kirim.putExtra("xFoto", xFoto);
                ctx.startActivity(kirim);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataPanti.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvTentang;
        ImageView ivFoto;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvTentang = itemView.findViewById(R.id.tv_tentang);
            ivFoto = itemView.findViewById(R.id.iv_foto);
        }
    }
}
