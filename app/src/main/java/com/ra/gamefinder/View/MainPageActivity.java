package com.ra.gamefinder.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.ra.gamefinder.R;
import com.ra.gamefinder.Repository.GameFinderWebRepository;
import com.ra.gamefinder.ViewModel.GameFinderViewModel;
import com.ra.gamefinder.WebService.GameFromWeb;
import com.ra.gamefinder.WebService.RetAPI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainPageActivity extends AppCompatActivity {
    @BindView(R.id.mainPage_recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar_game_list_id)
    Toolbar toolbar;

    GameFinderViewModel gameFinderViewModel;
    List<GameFromWeb> allGames;
    GameFromWeb gameFromWeb;
    GameFromWeb gameFromWeb1;
    GameFinderWebRepository gameFinderWebRepository;
    Boolean isReady = false;
    ConnectivityManager connectivityManager;
    List<GameFromWeb> gamesFromWeb = null;
    MainPageActivityAdapter mainPageActivityAdapter;
    Boolean isConnected;
    NetworkInfo info;
    NetworkInfo[] infoAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        ButterKnife.bind(this);
        gameFinderViewModel = new GameFinderViewModel();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbarInitializing();
        }
        isConnected = checkConnection();

        if (isConnected) {
            initializingInformation();
        }
        else {
            Toast.makeText(this
                    , "You need to be connected to the Internet at least once to view files offline"
                    , Toast.LENGTH_LONG).show();
        }

        creatingView();
    }

    private void creatingView() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.i("==tt", "run: " + gamesFromWeb);
                            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            if(gamesFromWeb == null){
                                Toast.makeText(getApplicationContext(),"There is a problem",
                                        Toast.LENGTH_LONG).show();
                            }
                            else{
                                mainPageActivityAdapter = new MainPageActivityAdapter(gamesFromWeb, getApplicationContext());
                                recyclerView.setAdapter(mainPageActivityAdapter);
                                recyclerView.setHasFixedSize(true);
                                mainPageActivityAdapter.setOnItemClickListener(new MainPageActivityAdapter.onItemClickListener() {
                                    @Override
                                    public void onItemClick(GameFromWeb gameFromWeb) {
                                        String title = gameFromWeb.getTitle();

                                        Intent intent = new Intent(MainPageActivity.this,
                                                GameDetailsActivity.class);
                                        GsonBuilder builder = new GsonBuilder();
                                        Gson gson = builder.create();
                                        String s = gson.toJson(gameFromWeb);
                                        intent.putExtra("GameSelected", s);
                                        startActivity(intent);
                                    }
                                });
                            }

                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initializingInformation() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    startApp();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    void startApp() {
        allGames = gameFinderViewModel.getGames();
//         gameFromWeb = allGames.get(1);

//        gameFromWeb1 = gameFinderViewModel.getGameDetails();
        setData(allGames);


    }

    private void setData(List<GameFromWeb> allGames) {
        gamesFromWeb = allGames;
        Log.i("==tt", "setData: " + gamesFromWeb);
        isReady = true;
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String s = gson.toJson(gamesFromWeb);
//        onCreateFile(s);
    }

    private boolean checkConnection() {
        Boolean b = false;
        connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        info = connectivityManager.getActiveNetworkInfo();
        if (info != null && info.isAvailable()) {
            b = true;
        }
        return b;
    }

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
private void toolbarInitializing() {
    toolbar.inflateMenu(R.menu.menu_main_page);
    toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            int id = menuItem.getItemId();
            switch (id) {
                case R.id.refresh:
                    isConnected = checkConnection();

                    if (isConnected) {
                        initializingInformation();
                    }
                    else {
                        Toast.makeText(getApplicationContext()
                                , "You need to be connected to the Internet at least once " +
                                        "to view files offline"
                                , Toast.LENGTH_LONG).show();
                    }

                    creatingView();            }
            return true;
        }
    });
}
    }





