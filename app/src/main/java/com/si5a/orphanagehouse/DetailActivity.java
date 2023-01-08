package com.si5a.orphanagehouse;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class DetailActivity extends AppCompatActivity {
    private ImageView ivFoto;
    private TextView tvNama, tvTentang;
    private String yNama, yTentang, yFoto;
    private Button btnTelephone, btnMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setTitle("Panti Asuhan");
        btnMaps = findViewById(R.id.btn_maps);
        btnTelephone = findViewById(R.id.btn_telephone);
        initView();

        Intent terima = getIntent();
        yNama = terima.getStringExtra("xNama");
        yTentang = terima.getStringExtra("xTentang");
        yFoto = terima.getStringExtra("xFoto");

        tvNama.setText(yNama);
        tvTentang.setText(yTentang);
        Glide
                .with(DetailActivity.this)
                .load(yFoto)
                .into(ivFoto);

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maps = tvNama.getText().toString();
                Uri uriMaps = Uri.parse("geo:0,0?q=" + maps);
                Intent openMaps = new Intent(Intent.ACTION_VIEW, uriMaps);
                startActivity(openMaps);
            }
        });

        btnTelephone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String telephone = tvNama.getText().toString();
                Intent openTelephone = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", telephone, "null"));
                startActivity(openTelephone);
            }
        });

    }
    private void initView(){
        ivFoto = findViewById(R.id.iv_foto);
        tvNama = findViewById(R.id.tv_nama);
        tvTentang = findViewById(R.id.tv_tentang);
    }
}