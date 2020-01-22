package com.ra.gamefinder.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ra.gamefinder.R;
import com.ra.gamefinder.WebService.GameFromWeb;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import kotlin.BuilderInference;

public class GameDetailsActivity extends AppCompatActivity {
    @BindView(R.id.toolbar_game_details)
    Toolbar toolbar;
    @BindView(R.id.toolbar_GameDetails)
    TextView textViewToolbarTitle;
    @BindView(R.id.textViewTitle)
    TextView textViewTitle;
    @BindView(R.id.imageGame)
    ImageView imageViewGameImage;
    @BindView(R.id.textViewGenreName)
    TextView textViewGenreName;
    @BindView(R.id.textViewGenreID)
    TextView textViewGenreId;
    @BindView(R.id.textViewDescription)
    TextView textViewDescription;
    @BindView(R.id.textViewPlayersCount)
    TextView textViewPlayersCount;
    @BindView(R.id.imageGenre)
    ImageView imageViewGenreImage;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;

    String gameSelectedConverted;
    GsonBuilder builder;
    Gson gson;
    GameFromWeb gameFromWeb;
    String gameTitle;
    String rate;
    String imageAddress;
    String genreImageAddress;
    String genreName;
    Integer genreId;
    String description;
    int playersCount;
    String videoAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);

        ButterKnife.bind(this);

        toolbarInitializing();

        getGameDetails();

        setGameDetails();

        new setGameImage().execute(imageAddress);
    }

    private void toolbarInitializing() {
        toolbar.bringToFront();
        toolbar.setNavigationIcon(R.drawable.back_button_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }});
    }

    private void setGameDetails() {
        textViewToolbarTitle.setText(gameTitle + " Details");
        textViewTitle.setText(gameTitle);
        ratingBar.setRating(Float.parseFloat(rate));
        textViewGenreName.setText("GENRE:" + genreName);
        textViewGenreId.setText("genreId: " + genreId);
        textViewDescription.setText("DESCRIPTION: " + description);
        textViewPlayersCount.setText("PLAYERS COUNT: " + playersCount);
    }

    private void getGameDetails() {
        gameSelectedConverted = getIntent().getExtras().getString("GameSelected");
        builder = new GsonBuilder();
        gson = builder.create();
        gameFromWeb = gson.fromJson(gameSelectedConverted, GameFromWeb.class);
        gameTitle = gameFromWeb.getTitle();
        rate = gameFromWeb.getRate();
        imageAddress = gameFromWeb.getImage();
        genreImageAddress = gameFromWeb.getGenre().getImage();
        genreName = gameFromWeb.getGenre().getName();
        genreId = gameFromWeb.getGenre().getId();
        description = gameFromWeb.getDescription();
        playersCount = gameFromWeb.getPlayersCount();
        videoAddress = gameFromWeb.getVideo();
    }

    public void onFabDownloadClicked(View view) {
        Toast.makeText(this,"download Started", Toast.LENGTH_LONG).show();
    }


    private class setGameImage extends AsyncTask<String,String, Bitmap> {
        Bitmap bitmap;
        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
            URL url = new URL(strings[0]);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (connection == null){
            }
            InputStream inputStream = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
    }

}}
