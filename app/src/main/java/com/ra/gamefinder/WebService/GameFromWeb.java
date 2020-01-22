package com.ra.gamefinder.WebService;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GameFromWeb {

    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("rate")
    @Expose
    public String rate;
    @SerializedName("players_count")
    @Expose
    public Integer playersCount;
    @SerializedName("genre")
    @Expose
    public Genre genre;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("video")
    @Expose
    public String video;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Integer getPlayersCount() {
        return playersCount;
    }

    public void setPlayersCount(Integer playersCount) {
        this.playersCount = playersCount;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

}