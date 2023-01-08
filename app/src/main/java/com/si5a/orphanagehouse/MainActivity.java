package com.si5a.orphanagehouse;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPantiAsuhan;
    private ArrayList<ModelPanti> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPantiAsuhan = findViewById(R.id.rv_panti);
        rvPantiAsuhan.setHasFixedSize(true);

        data.addAll(DataPanti.ambilDataPanti());
        tampilDataCard();
    }
    private void tampilDataCard(){
        rvPantiAsuhan.setLayoutManager(new LinearLayoutManager(this));
        AdapterCard AC = new AdapterCard(data, MainActivity.this);
        rvPantiAsuhan.setAdapter(AC);
    }
}