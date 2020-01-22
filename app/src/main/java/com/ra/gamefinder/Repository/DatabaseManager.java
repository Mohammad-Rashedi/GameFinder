package com.ra.gamefinder.Repository;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ra.gamefinder.Room.GameDatabase;

public class DatabaseManager extends AppCompatActivity {
    GameDatabase gameDatabase;
    Context context;

    public DatabaseManager(Application application) {
        context = application.getApplicationContext();
        gameDatabase = GameDatabase.getInstance(context);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);



    }
}
