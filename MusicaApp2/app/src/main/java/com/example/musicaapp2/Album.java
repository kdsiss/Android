package com.example.musicaapp2;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Album implements Parcelable {


    private String autor;
    private String nom;


    private List<Song> musicaAlbum;
    private int anyCreacio;
    private String imgAlbumURL;


    @SuppressLint("NewApi")
    protected Album(Parcel in) {
        autor = in.readString();
        nom = in.readString();
        anyCreacio = in.readInt();
        imgAlbumURL = in.readString();
        bitmap = in.readParcelable(Bitmap.class.getClassLoader());
        int size = in.readInt();
        musicaAlbum = new ArrayList<Song>();
        for (int i = 0; i < size; i ++)
        {
            musicaAlbum.add(in.readParcelable(Song.class.getClassLoader(),Song.class));

        }


    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    public Bitmap getBitmap() {
        return bitmap;
    }

    public List<Song> getMusicaAlbum() {
        return musicaAlbum;
    }

    public void setMusicaAlbum(List<Song> musicaAlbum) {
        this.musicaAlbum = musicaAlbum;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        imgAlbumURL = null;
    }

    Bitmap bitmap; 
    

    public Album() {
        this.nom = "Good Kid EP1";
        this.anyCreacio = 2018;
        this.autor = "Good Kid";
        this.imgAlbumURL = null;
    }
    public Album(String Nom,int AnyCreacio,String ImgAlbumURL, String Creador) {
        this.nom = Nom;
        this.anyCreacio = AnyCreacio;
        this.imgAlbumURL = ImgAlbumURL;
        this.autor = Creador;
    }
    private static ArrayList<Album> _albums ;
    public static List<Album> getAlbums(){

        if(_albums==null) {
            _albums = new ArrayList<Album>();
            _albums.add(new Album("Good Kid EP1",2018,"https://images.squarespace-cdn.com/content/v1/5dae2d150bb6de758cdba920/1604669147695-GGT9G1Z4QPK9HN0MYWPS/goodkid.png", "Good Kid"));
            _albums.add(new Album("Gangsta's Paradise", 1995,"https://i1.sndcdn.com/artworks-1VaLl1yybVEJbJgD-oi2mTQ-t500x500.jpg","Coolio"));
            _albums.add(new Album("Making Mirrors", 2011, "https://upload.wikimedia.org/wikipedia/en/9/95/Gotye_-_Making_Mirrors.png", "Gotye"));
            _albums.add(new Album("Cavetown", 2011, "https://static.wikia.nocookie.net/cavetown/images/2/2d/Cavetown_-_Cavetown.jpg", "Cavetown"));
            _albums.add(new Album("Whenever you need somebody", 1987, "https://upload.wikimedia.org/wikipedia/en/1/1c/Rick_Astley_-_Whenever_You_Need_Somebody.png", "Rick Astley"));
            _albums.add(new Album("The Marshall Mathers LP", 2000, "https://upload.wikimedia.org/wikipedia/en/a/ae/The_Marshall_Mathers_LP.jpg", "Eminem"));

        }
        for (int i = 0; i < _albums.size(); i++) {
            _albums.get(i).setSongs(i);
        }
        return _albums;

    }

    //Metode per afegir cançons
    private void setSongs(int i) {

        if (this.musicaAlbum == null) {
           this.musicaAlbum = new ArrayList<Song>();
            switch (i) {
                case 0:
                    this.musicaAlbum.add(new Song(1, "Nomu", "02:49"));
                    this.musicaAlbum.add(new Song(2, "Tell Me You Know", "03:17"));
                    this.musicaAlbum.add(new Song(3, "Alchemist", "02:53"));
                    this.musicaAlbum.add(new Song(4, "Witches", "02:34"));
                    this.musicaAlbum.add(new Song(5, "Faster", "02:37"));
                    this.musicaAlbum.add(new Song(6, "Atlas", "02:24"));
                    break;

                case 1:
                    this.musicaAlbum.add(new Song(1, "That's how it is", "1:00"));
                    this.musicaAlbum.add(new Song(2, "Geto Highlites", "4:59"));
                    this.musicaAlbum.add(new Song(3, "Gangsta's Paradise", "4:00"));
                    this.musicaAlbum.add(new Song(4, "Too Hot", "4:00"));
                    this.musicaAlbum.add(new Song(5, "Cruisin'", "4:34"));
                    this.musicaAlbum.add(new Song(6, "Exercise Yo Game", "4:49"));
                    this.musicaAlbum.add(new Song(7, "1, 2, 3, 4 (Sumpin' New)", "3:33"));
                    this.musicaAlbum.add(new Song(8, "Smilin'", "4:07"));
                    this.musicaAlbum.add(new Song(9, "Fucc Coolio", "0:50"));
                    this.musicaAlbum.add(new Song(10, "Kinda High Kinda Drunk", "3:44"));
                    this.musicaAlbum.add(new Song(11, "For My Sistas", "4:26"));
                    this.musicaAlbum.add(new Song(12, "Is This Me?", "4:23"));
                    this.musicaAlbum.add(new Song(13, "A Thing Goin' On", "4:45"));
                    this.musicaAlbum.add(new Song(14, "Bright As the Sun", "4:47"));
                    this.musicaAlbum.add(new Song(15, "Recoup This", "1:21"));
                    this.musicaAlbum.add(new Song(16, "The Revolution", "3:48"));
                    this.musicaAlbum.add(new Song(17, "Get Up, Get Down", "5:32"));
                    break;
                case 2:
                    this.musicaAlbum.add(new Song(1, "Making Mirrors", "1:01"));
                    this.musicaAlbum.add(new Song(2, "Easy Way Out", "1:57"));
                    this.musicaAlbum.add(new Song(3, "Somebody That I Used to Know (featuring Kimbra)", "4:04"));
                    this.musicaAlbum.add(new Song(4, "Eyes Wide Open", "3:11"));
                    this.musicaAlbum.add(new Song(5, "Smoke and Mirrors", "5:13"));
                    this.musicaAlbum.add(new Song(6, "I Feel Better", "3:18"));
                    this.musicaAlbum.add(new Song(7, "In Your Light", "4:39"));
                    this.musicaAlbum.add(new Song(8, "State of the Art", "5:22"));
                    this.musicaAlbum.add(new Song(9, "Don't Worry, We'll Be Watching You", "3:18"));
                    this.musicaAlbum.add(new Song(10, "Giving Me a Chance", "3:07"));
                    this.musicaAlbum.add(new Song(11, "Save Me", "3:53"));
                    this.musicaAlbum.add(new Song(12, "Bronte", "3:18"));
                    this.musicaAlbum.add(new Song(13, "Dig Your Own Hole", "4:23"));
                    this.musicaAlbum.add(new Song(14, "Showdown Below My Sombrero", "2:30"));
                    this.musicaAlbum.add(new Song(15, "Two Mirrors", "2:42"));
                    this.musicaAlbum.add(new Song(16, "Atimot ot Edo", "1:27"));
                    break;
                case 3:
                    this.musicaAlbum.add(new Song(1, "Meteor Shower", "4:25"));
                    this.musicaAlbum.add(new Song(2, "Everything Is Temporary (Sticks And Stones)", "3:04"));
                    this.musicaAlbum.add(new Song(3, "We're Alive", "3:20"));
                    this.musicaAlbum.add(new Song(4, "Hazel", "3:42"));
                    this.musicaAlbum.add(new Song(5, "Untitled V.2", "3:26"));
                    this.musicaAlbum.add(new Song(6, "Intermission", "1:38"));
                    this.musicaAlbum.add(new Song(7, "Banana Bread", "4:49"));
                    this.musicaAlbum.add(new Song(8, "Devil Town", "2:59"));
                    break;
                case 4:
                    this.musicaAlbum.add(new Song(1, "Never Gonna Give You Up", "3:35"));
                    this.musicaAlbum.add(new Song(2, "Whenever You Need Somebody", "3:52"));
                    this.musicaAlbum.add(new Song(3, "Together Forever", "3:24"));
                    this.musicaAlbum.add(new Song(4, "It Would Take a Strong Strong Man", "3:39"));
                    this.musicaAlbum.add(new Song(5, "The Love Has Gone", "4:20"));
                    this.musicaAlbum.add(new Song(6, "Don't Say Goodbye", "4:11"));
                    this.musicaAlbum.add(new Song(7, "Slipping Away", "3:52"));
                    this.musicaAlbum.add(new Song(8, "No More Looking for Love", "3:10"));
                    this.musicaAlbum.add(new Song(9, "You Move Me", "3:40"));
                    this.musicaAlbum.add(new Song(10, "When I Fall in Love", "2:59"));
                    break;
                case 5:
                    this.musicaAlbum.add(new Song(1, "Public Service Announcement 2000", "0:25"));
                    this.musicaAlbum.add(new Song(2, "Kill You", "4:24"));
                    this.musicaAlbum.add(new Song(3, "Stan (with Dido)", "6:44"));
                    this.musicaAlbum.add(new Song(4, "Paul (skit)", "0:10"));
                    this.musicaAlbum.add(new Song(5, "Who Knew", "3:47"));
                    this.musicaAlbum.add(new Song(6, "Steve Berman (skit)", "0:53"));
                    this.musicaAlbum.add(new Song(7, "The Way I Am", "4:50"));
                    this.musicaAlbum.add(new Song(8, "The Real Slim Shady", "4:44"));
                    this.musicaAlbum.add(new Song(9, "Remember Me? (with RBX and Sticky Fingaz)", "3:38"));
                    this.musicaAlbum.add(new Song(10, "I'm Back", "5:10"));
                    this.musicaAlbum.add(new Song(11, "Marshall Mathers", "5:20"));
                    this.musicaAlbum.add(new Song(12, "Ken Kaniff (skit)", "1:01"));
                    this.musicaAlbum.add(new Song(13, "Drug Ballad (with Dina Rae)", "5:00"));
                    this.musicaAlbum.add(new Song(14, "Amityville (with Bizarre)", "4:14"));
                    this.musicaAlbum.add(new Song(15, "Bitch Please II (with Dr. Dre, Snoop Dogg, Xzibit and Nate Dogg)", "4:48"));
                    this.musicaAlbum.add(new Song(16, "Kim", "6:17"));
                    this.musicaAlbum.add(new Song(17, "Under the Influence (with D12)", "5:21"));
                    this.musicaAlbum.add(new Song(18, "Criminal", "5:18"));
                    this.musicaAlbum.add(new Song(19, "The Kids", "5:06"));
                    break;
            }
        }


    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnyCreacio() {
        return anyCreacio;
    }

    public void setAnyCreacio(int anyCreacio) {
        this.anyCreacio = anyCreacio;
    }

    public String getImgAlbum() {
        return imgAlbumURL;
    }

    public void setImgAlbum(String imgAlbum) {
        this.imgAlbumURL = imgAlbum;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(autor);
        parcel.writeString(nom);
        parcel.writeInt(anyCreacio);
        parcel.writeString(imgAlbumURL);
        parcel.writeParcelable(bitmap, 0);
        parcel.writeInt(musicaAlbum.size());
        for (Song s: musicaAlbum) {
            parcel.writeParcelable(s,1);
        }
    }
}
