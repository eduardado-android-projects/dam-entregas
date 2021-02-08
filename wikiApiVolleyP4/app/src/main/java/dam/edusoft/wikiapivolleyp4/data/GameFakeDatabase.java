package dam.edusoft.wikiapivolleyp4.data;

import java.util.LinkedList;

import dam.edusoft.wikiapivolleyp4.model.Game;

/**
 *  Clase que simula el acceso a una base de datos u otra fuente de datos
 */
public class GameFakeDatabase {

    private static LinkedList<Game> gameLinkedList;

    static { //todo cuando se instancian también todos estos "Game"
        gameLinkedList.add(new Game("Doom","Id Software", "1993", "https://upload.wikimedia.org/wikipedia/en/5/57/Doom_cover_art.jpg" ));
        gameLinkedList.add(new Game("The Secret Of Monkey Island","Lucasfilm Game", "1990", "https://upload.wikimedia.org/wikipedia/en/a/a8/The_Secret_of_Monkey_Island_artwork.jpg"));
        gameLinkedList.add(new Game("Day of The Tentacle","LucasArts", "1993", "https://upload.wikimedia.org/wikipedia/en/7/79/Day_of_the_Tentacle_artwork.jpg" ));
        gameLinkedList.add(new Game("StarCraft","Blizzard Entertainment", "1998", "https://www.blizzboygames.net/wp-content/uploads/2014/06/STRCBW.jpg" ));
        gameLinkedList.add(new Game("Another World","Delphine Software", "1991", "https://upload.wikimedia.org/wikipedia/en/b/b9/Another_World_Coverart.png" ));


    }

}
