package com.ra.gamefinder.ViewModel;

import com.ra.gamefinder.Repository.GameFinderWebRepository;
import com.ra.gamefinder.WebService.GameFromWeb;

import java.util.List;

public class GameFinderViewModel {
    GameFromWeb gameFromWeb;
    List<GameFromWeb> games;
    GameFinderWebRepository gameFinderWebRepository;
    public GameFinderViewModel() {
        gameFinderWebRepository = new GameFinderWebRepository();
    }


    public List<GameFromWeb> getGames(){
       return gameFinderWebRepository.getGames();
    }

    public GameFromWeb getGameDetails(){
        gameFromWeb = gameFinderWebRepository.getGameDetails();
        return gameFromWeb;
    }

}
