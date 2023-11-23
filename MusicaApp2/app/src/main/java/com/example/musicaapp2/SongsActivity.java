package com.example.musicaapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;

import com.example.musicaapp2.adapters.SongRowAdapter;
import com.example.musicaapp2.adapters.SquareAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class SongsActivity extends AppCompatActivity {

    private SongRowAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_songs);
            setSupportActionBar(findViewById(R.id.my_toolbar));
            Toolbar t = findViewById(R.id.my_toolbar);
            t.setTitle("Cançons");

            FloatingActionButton fab = findViewById(R.id.fab);
            int colorPersonalizado = getResources().getColor(R.color.primary1);
            ColorStateList colorStateList = ColorStateList.valueOf(colorPersonalizado);
            fab.setBackgroundTintList(colorStateList);
            Album selectedAlbum = getIntent().getParcelableExtra("Album");

            RecyclerView rcySView = findViewById(R.id.rcySongs);
            // 1.- Configurem el RecyclerView ( direcció )
            rcySView.setLayoutManager(
                    new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            );
            Log.d("Seta 9", selectedAlbum.getMusicaAlbum().get(1).getNomSong());
            rcySView.setHasFixedSize(true); // només en el cas que les files tinguin la mateixa alçada
            // 2.- Crear l'adapter

            adapter = new SongRowAdapter(this, selectedAlbum.getMusicaAlbum());

            // 3.- Connectar l'adapter al Recycler
            Log.d("seta 5", "funka");
            rcySView.setAdapter(adapter);


            Log.d("seta 6", "funka");
        } catch (Exception e) {
            Log.d("Seta 2", e.getLocalizedMessage());
        }
    }
}