package dam.edusoft.wikiapivolleyp4.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.LinkedList;

import dam.edusoft.wikiapivolleyp4.GameRecyclerViewAdapter;
import dam.edusoft.wikiapivolleyp4.IntentNames;
import dam.edusoft.wikiapivolleyp4.R;
import dam.edusoft.wikiapivolleyp4.persistence.model.Game;
import dam.edusoft.wikiapivolleyp4.service.GameService;

public class GameListMainActivity extends AppCompatActivity  implements GameRecyclerViewAdapter.OnGameListenerInterface {

    private GameService mGameService; //Clase de servicios
    private LinkedList<Game> mGameLinkedList; //Estructura de datos

    //RecyclerView
    private RecyclerView mGameRecyclerView;
    private GameRecyclerViewAdapter mGameRecyclerViewAdapter;

    //Debugging
    private static final String TAG = "GameListMainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Good Old Games");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar); //TODO borrar?
        setSupportActionBar(toolbar);



        //DATA<->ADAPTER IMPLEMENTATION
        mGameService = new GameService(); // Create an instance of Service class
        mGameLinkedList = mGameService.getAllGames(); // Request Data

        mGameRecyclerView = findViewById(R.id.recyclerView); //handle for RecyclerView
        mGameRecyclerViewAdapter = new GameRecyclerViewAdapter(
                this, //El Activity
                mGameLinkedList, //los datos
                this); // La interfaz (también implementada por esta clase)
        mGameRecyclerView.setAdapter(mGameRecyclerViewAdapter); //sets the adapter
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        mGameRecyclerView.setLayoutManager(gridLayoutManager); //sets the LayoutManager


    }

    @Override
    public void onGameClick(Integer position) {
        /*
        - Para poder mandar un objeto a otro intent necesitamos que implemente la intefaz Parcelable
        - Para nombrar el Intent usamos el paquete único de la app en el intent + nombre del objeto (buenas prácticas por si recibimos mismo objeto de otra app)
         */
        Log.d(TAG, "onGameClick: Has hecho click en el juego : " + mGameLinkedList.get(position).getName());

        Game selectedGame = mGameLinkedList.get(position); //el objeto que se mandará en el intent a la otra Activity

        /*Intent intent = new Intent(this, GameDetailsActivity.class);*/

        Intent intent = new Intent(this, GameDetailsActivity.class);
        intent.putExtra(IntentNames.GAME_SELECTED, selectedGame);

        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}