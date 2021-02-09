package dam.edusoft.wikiapivolleyp4.persistence;

import java.util.LinkedList;

import dam.edusoft.wikiapivolleyp4.persistence.model.Game;

/**
 *  Clase que simula el acceso a una base de datos u otra fuente de datos
 */
public class GameFakeDatabase {

    //Importante, el objeto que queramos que quede referenciado en una variable estática ha de hacerse en la misma declaración de la variable.
    private static LinkedList<Game> gameLinkedList = new LinkedList<Game>();

    public  LinkedList<Game> getGameLinkedList() {
        return gameLinkedList;
    }

    public  void setGameLinkedList(LinkedList<Game> gameLinkedList) {
        this.gameLinkedList = gameLinkedList;
    }

    /*
        Al generar un contexto estático, cuando instanciamos la clase se ejecuta el bloque de código
        Desde este contexto podremos acceder a variables estáticas.
     */
    static {
        gameLinkedList.add(new Game("Doom","Id Software", "1993", "https://upload.wikimedia.org/wikipedia/en/5/57/Doom_cover_art.jpg", "doom"));
        gameLinkedList.add(new Game("The Secret Of Monkey Island","Lucasfilm Game", "1990", "https://upload.wikimedia.org/wikipedia/en/a/a8/The_Secret_of_Monkey_Island_artwork.jpg", "monkey"));
        gameLinkedList.add(new Game("Day of The Tentacle","LucasArts", "1993", "https://upload.wikimedia.org/wikipedia/en/7/79/Day_of_the_Tentacle_artwork.jpg", "tentacle"));
        gameLinkedList.add(new Game("StarCraft","Blizzard Entertainment", "1998", "https://www.blizzboygames.net/wp-content/uploads/2014/06/STRCBW.jpg", "terran"));
        gameLinkedList.add(new Game("Another World","Delphine Software", "1991", "https://upload.wikimedia.org/wikipedia/en/b/b9/Another_World_Coverart.png", "another"));

    }

}
