package com.example.musicaapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.musicaapp2.R;
import com.example.musicaapp2.adapters.SquareAdapter;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class CreateAlbum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_album);



        Button btnConfirm = findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(view -> {
            EditText edtAlbum = findViewById(R.id.txtNom);
            String AlbumNom = edtAlbum.getText().toString();
            Log.d("CreatedAlbum", "Created album Nom = " + AlbumNom);
            edtAlbum = findViewById(R.id.txtAutor);
            String AlbumAutor = edtAlbum.getText().toString();
            edtAlbum = findViewById(R.id.txtYear);
            //Para ruben del futuro, arreglar el Date para recibir el año.
            String Year = "2000";
            Album nouAlbum = new Album(AlbumNom,Integer.parseInt(Year),"https://images.squarespace-cdn.com/content/v1/5dae2d150bb6de758cdba920/1604669147695-GGT9G1Z4QPK9HN0MYWPS/goodkid.png",AlbumAutor);

            Intent intent = new Intent(this, SquareAdapter.class);
            intent.putExtra("Album",nouAlbum);

            //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            //Date AlbumDate = sdf.parse(edtAlbum.getText().toString(), new ParsePosition(0));
            //int year = AlbumDate.getYear();
            //Log.d ("CreatedAlbum", "Any de creacio : "+ Integer.toString(year));

        });


    }
}