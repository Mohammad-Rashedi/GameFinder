package com.ra.gamefinder.Room;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "game_table")
public class GameTable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "game-title-column")
    private String gameTitle;
    @ColumnInfo(name = "game-description-column")
    private String gameDescription;
    @ColumnInfo(name = "game-rate-column")
    private String gameRate;
    @ColumnInfo(name = "game-player-count-column")
    private int gamePlayerCount;
    @ColumnInfo(name = "game-image-address-column")
    private String gameImageAddress;
    @ColumnInfo(name = "game-video-address-column")
    private String gameVideoAddress;
    @ColumnInfo(name = "game-genre-id-column")
    private int gameGenreId;
    @ColumnInfo(name = "game-genre-name-column")
    private String gameGenreName;
    @ColumnInfo(name = "game-genre-image-address-column")
    private String gameGenreImageAddress;


    public GameTable(int id, String gameTitle,
                     String gameDescription, String gameRate,
                     int gamePlayerCount, String gameImageAddress,
                     String gameVideoAddress, int gameGenreId,
                     String gameGenreName, String gameGenreImageAddress) {
        this.id = id;
        this.gameTitle = gameTitle;
        this.gameDescription = gameDescription;
        this.gameRate = gameRate;
        this.gamePlayerCount = gamePlayerCount;
        this.gameImageAddress = gameImageAddress;
        this.gameVideoAddress = gameVideoAddress;
        this.gameGenreId = gameGenreId;
        this.gameGenreName = gameGenreName;
        this.gameGenreImageAddress = gameGenreImageAddress;
    }

    public GameTable(String gameTitle, String gameDescription,
                     String gameRate, int gamePlayerCount,
                     String gameImageAddress, String gameVideoAddress,
                     int gameGenreId, String gameGenreName,
                     String gameGenreImageAddress) {
        this.gameTitle = gameTitle;
        this.gameDescription = gameDescription;
        this.gameRate = gameRate;
        this.gamePlayerCount = gamePlayerCount;
        this.gameImageAddress = gameImageAddress;
        this.gameVideoAddress = gameVideoAddress;
        this.gameGenreId = gameGenreId;
        this.gameGenreName = gameGenreName;
        this.gameGenreImageAddress = gameGenreImageAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public String getGameRate() {
        return gameRate;
    }

    public void setGameRate(String gameRate) {
        this.gameRate = gameRate;
    }

    public int getGamePlayerCount() {
        return gamePlayerCount;
    }

    public void setGamePlayerCount(int gamePlayerCount) {
        this.gamePlayerCount = gamePlayerCount;
    }

    public String getGameImageAddress() {
        return gameImageAddress;
    }

    public void setGameImageAddress(String gameImageAddress) {
        this.gameImageAddress = gameImageAddress;
    }

    public String getGameVideoAddress() {
        return gameVideoAddress;
    }

    public void setGameVideoAddress(String gameVideoAddress) {
        this.gameVideoAddress = gameVideoAddress;
    }

    public int getGameGenreId() {
        return gameGenreId;
    }

    public void setGameGenreId(int gameGenreId) {
        this.gameGenreId = gameGenreId;
    }

    public String getGameGenreName() {
        return gameGenreName;
    }

    public void setGameGenreName(String gameGenreName) {
        this.gameGenreName = gameGenreName;
    }

    public String getGameGenreImageAddress() {
        return gameGenreImageAddress;
    }

    public void setGameGenreImageAddress(String gameGenreImageAddress) {
        this.gameGenreImageAddress = gameGenreImageAddress;
    }
}
