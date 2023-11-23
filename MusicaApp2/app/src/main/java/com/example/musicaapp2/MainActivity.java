package com.example.musicaapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;

import com.example.musicaapp2.adapters.SquareAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MainActivity extends AppCompatActivity{

    private SquareAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUniversalImageLoader();
        setSupportActionBar(findViewById(R.id.my_toolbar));
        Toolbar t = findViewById(R.id.my_toolbar);

        EditToolbar (t);
        FloatingActionButton fab = findViewById(R.id.fab);
        int colorPersonalizado = getResources().getColor(R.color.primary1);
        ColorStateList colorStateList = ColorStateList.valueOf(colorPersonalizado);
        fab.setBackgroundTintList(colorStateList);
        RecyclerView rcySquare = findViewById(R.id.rcySquare);

        // 1.- Configurem el RecyclerView ( direcció )
        rcySquare.setLayoutManager(
                new GridLayoutManager(this,2)
        );
        rcySquare.setHasFixedSize(true); // només en el cas que les files tinguin la mateixa alçada
        // 2.- Crear l'adapter
        adapter = new SquareAdapter(this, Album.getAlbums());

        // 3.- Connectar l'adapter al Recycler View
        rcySquare.setAdapter(adapter);

        fab.setOnClickListener(view -> {
            Intent intent = new Intent (this, CreateAlbum.class);
            this.startActivity(intent);
        });

    }

    private void EditToolbar(Toolbar t) {
        t.setTitle("Albums");
        setSupportActionBar(t);
    }

    private void setupUniversalImageLoader() {
        DisplayImageOptions dop = new DisplayImageOptions.Builder().
                showImageOnLoading(R.drawable.ic_launcher_background)
                .build();
        // Create global configuration and initialize ImageLoader with this config
        ImageLoaderConfiguration config =
                new ImageLoaderConfiguration.Builder(this)
                        //.threadPoolSize(10)
                        //.diskCacheSize(1000)
                        .defaultDisplayImageOptions(dop)
                        .build();

        ImageLoader.getInstance().init(config);
    }

}