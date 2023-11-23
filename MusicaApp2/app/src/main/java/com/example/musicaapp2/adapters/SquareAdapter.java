package com.example.musicaapp2.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicaapp2.Album;
import com.example.musicaapp2.CreateAlbum;
import com.example.musicaapp2.R;
import com.example.musicaapp2.SongsActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;
import java.util.List;

public class SquareAdapter extends  RecyclerView.Adapter<SquareAdapter.SquareViewHolder>{
private List<Album> mAlbum;
private Context mContext;

public SquareAdapter (Context c,List<Album> albums) {
    mContext = c;
    mAlbum = albums;
}


    @NonNull
    @Override
    public SquareAdapter.SquareViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       int layout = R.layout.square;
       View square = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);

       return new SquareViewHolder(square);
    }

    @Override
    public void onBindViewHolder(@NonNull SquareAdapter.SquareViewHolder holder, int position) {
        Album albumActual = mAlbum.get(position);
        holder.txvName.setText(albumActual.getNom());
        holder.txvYear.setText(Integer.toString(albumActual.getAnyCreacio()));
        holder.txvAutor.setText(albumActual.getAutor());
        if (albumActual.getBitmap() != null) {
            holder.imgAlbum.setImageBitmap(albumActual.getBitmap());
        } else {
            holder.imgAlbum.setImageResource(R.drawable.goodkidplaceholder);
            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.displayImage(albumActual.getImgAlbum(), holder.imgAlbum);

        }
        holder.imgAlbum.setOnClickListener(view -> {
            try {
                Intent intent = new Intent(mContext, SongsActivity.class);
                Log.d("Seta 3", albumActual.getMusicaAlbum().get(1).getNomSong());
                intent.putExtra("Album", albumActual);
                mContext.startActivity(intent);
            }catch (Exception e)
            {
                Log.d("Seta",e.getMessage());
            }
        });

    }



    @Override
    public int getItemCount() {
        return mAlbum.size ();
    }


    public class SquareViewHolder extends RecyclerView.ViewHolder {
        TextView txvName;
        TextView txvYear;
        TextView txvAutor;
        ImageView imgAlbum;
        ConstraintLayout clySquare;

        public SquareViewHolder (@NonNull View square) {
            super (square);
            txvName = square.findViewById(R.id.txvAlbum);
            txvYear = square.findViewById(R.id.txvYear);
            txvAutor = square.findViewById(R.id.txvAutor);
            imgAlbum = square.findViewById(R.id.imvAlbum);
            clySquare = square.findViewById(R.id.clySquare);


        }


    }

}
