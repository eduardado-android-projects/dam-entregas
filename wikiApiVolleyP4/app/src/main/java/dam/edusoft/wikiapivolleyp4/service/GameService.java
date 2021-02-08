package dam.edusoft.wikiapivolleyp4.service;

import java.util.LinkedList;

import dam.edusoft.wikiapivolleyp4.persistence.GameFakeDatabase;
import dam.edusoft.wikiapivolleyp4.persistence.model.Game;

public class GameService {

    public GameService(){

    }

    public LinkedList<Game> getAllGames(){
        LinkedList<Game> gameLinkedList = new LinkedList<Game>();

        GameFakeDatabase gameFakeDatabase = new GameFakeDatabase();

        gameLinkedList = gameFakeDatabase.getGameLinkedList();

        return gameLinkedList;
    }

    public static void main(String[] args) {
        GameService gameService = new GameService();
        LinkedList<Game> gameLinkedList = gameService.getAllGames();
        gameLinkedList.forEach(game -> System.out.println(game));
    }

}
