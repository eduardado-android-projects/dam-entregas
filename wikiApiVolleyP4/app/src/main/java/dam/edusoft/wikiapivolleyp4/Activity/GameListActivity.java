package dam.edusoft.wikiapivolleyp4.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;

import java.util.LinkedList;

import dam.edusoft.wikiapivolleyp4.GameRecyclerViewAdapter;
import dam.edusoft.wikiapivolleyp4.R;
import dam.edusoft.wikiapivolleyp4.persistence.model.Game;
import dam.edusoft.wikiapivolleyp4.service.GameService;

public class GameListActivity extends AppCompatActivity  implements GameRecyclerViewAdapter.OnGameListenerInterface {

    private GameService mGameService;
    private LinkedList<Game> mGameLinkedList;
    private RecyclerView mRecyclerView;
    private GameRecyclerViewAdapter mGameRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Good Old Games");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //DATA<->ADAPTER IMPLEMENTATION
        mGameService = new GameService(); // Create an instance of Service class
        mGameLinkedList = mGameService.getAllGames(); // Request Data

        mRecyclerView = findViewById(R.id.recyclerView); //handle for RecyclerView
        mGameRecyclerViewAdapter = new GameRecyclerViewAdapter(
                this, //El Activity
                mGameLinkedList, //los datos
                this); // La interfaz (también implementada por esta clase)
        mRecyclerView.setAdapter(mGameRecyclerViewAdapter); //sets the adapter
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(gridLayoutManager); //sets the LayoutManager




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

    @Override
    public void onGameClick(Integer position) {

        Intent intent = new Intent(this, GameDetailsActivity.class);
        intent.putExtra("game",GameDetailsActivity.class); //
        startActivity(intent);

    }
}