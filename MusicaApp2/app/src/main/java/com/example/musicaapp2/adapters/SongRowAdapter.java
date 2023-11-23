package com.example.musicaapp2.adapters;

import android.content.Context;
import android.content.Intent;
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
import com.example.musicaapp2.R;
import com.example.musicaapp2.Song;
import com.example.musicaapp2.SongsActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class SongRowAdapter extends RecyclerView.Adapter<SongRowAdapter.SongRowViewHolder>{

    private List<Song> mSongs;
    private Context mContext;

public SongRowAdapter (Context c, List<Song> songs) {
    mContext = c;
    mSongs = songs;
}



        @NonNull
        @Override
        public SongRowViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType){
        int layout = R.layout.songrow;
        View sr = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new SongRowViewHolder(sr);
    }

        @Override
        public void onBindViewHolder (@NonNull SongRowViewHolder holder,int position){

        Song songActual = mSongs.get(position);
        holder.txvName.setText(songActual.getNomSong());
        holder.txvTemps.setText(songActual.getTime());
        holder.txvId.setText(Integer.toString(songActual.getIdSong()));
        holder.cor.setImageResource(R.drawable.heart);

            holder.cor.setOnClickListener(view -> {
             if (songActual.isLiked())
             {
                 songActual.setLiked(false);
                 holder.cor.setImageResource(R.drawable.heart);
             }
             else
             {
                 songActual.setLiked(true);
                 holder.cor.setImageResource(R.drawable.filledheart);
             }
            });
    }

        @Override
        public int getItemCount () {
                return mSongs.size();
    }



    public class SongRowViewHolder extends RecyclerView.ViewHolder {
    TextView txvName;
    TextView txvId;
    TextView txvTemps;
    ImageView cor;
    ConstraintLayout clySong;
    public SongRowViewHolder (@NonNull View songrow) {
        super (songrow);
        txvName = songrow.findViewById(R.id.textName);
        cor = songrow.findViewById(R.id.imageCor);
        txvId = songrow.findViewById(R.id.numCanço);
        txvTemps = songrow.findViewById(R.id.textTime);
        clySong = songrow.findViewById(R.id.clySr);


    }


}

}

