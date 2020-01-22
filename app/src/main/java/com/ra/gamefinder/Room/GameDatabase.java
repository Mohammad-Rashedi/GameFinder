package com.ra.gamefinder.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = GameTable.class,exportSchema = false,version = 1)
public abstract class GameDatabase extends RoomDatabase {
    private static final String DB_NAME = "GamesList_db";
    private static GameDatabase instance;
    public static synchronized GameDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    GameDatabase.class, DB_NAME).
                    fallbackToDestructiveMigration().build();

        }

        return instance;
    }

    public abstract GameDAO gameDAO();

}
