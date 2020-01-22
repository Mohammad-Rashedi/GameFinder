package com.ra.gamefinder.Room;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface GameDAO {
    @Query("Select * from game_table")
    List<GameTable> getGamesList();

    @Insert
    long insertGameTable(GameTable gameTable);

    @Update
    int updateGameTable(GameTable gameTable);

    @Delete
    int deleteGameTable(GameTable gameTable);

    @Query("SELECT * FROM game_table ORDER BY id")
    List<GameTable> loadAllGameTables();

    @Query("DELETE FROM game_table")
    void deleteAll();



}
