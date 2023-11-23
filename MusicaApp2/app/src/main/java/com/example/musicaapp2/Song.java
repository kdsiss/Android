package com.example.musicaapp2;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Song implements Parcelable {
    private int idSong; //Num de la canço creada
    private String nomSong;
    private boolean isLiked;

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    @SuppressLint("NewApi")
    protected Song(Parcel in) {
        idSong = in.readInt();
        nomSong = in.readString();
        time = in.readString();
        isLiked = in.readBoolean();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;

    public Song(int idSong, String nomSong, String time) {
        this.idSong = idSong;
        this.nomSong = nomSong;
        this.time = time;
        isLiked = false;
    }

    public int getIdSong() {
        return idSong;
    }

    public void setIdSong(int idSong) {
        this.idSong = idSong;
    }

    public String getNomSong() {
        return nomSong;
    }

    public void setNomSong(String nomSong) {

        this.nomSong = nomSong;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @SuppressLint("NewApi")
    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(idSong);
        parcel.writeString(nomSong);
        parcel.writeString(time);
        parcel.writeBoolean(isLiked);
    }
}
