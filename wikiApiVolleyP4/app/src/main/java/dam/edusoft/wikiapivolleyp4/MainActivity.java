package dam.edusoft.wikiapivolleyp4;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.LinkedList;

import dam.edusoft.wikiapivolleyp4.persistence.model.Game;
import dam.edusoft.wikiapivolleyp4.service.GameService;

public class MainActivity extends AppCompatActivity {

    private GameService mGameService;
    private LinkedList<Game> mGameLinkedList;
    private RecyclerView mRecyclerView;
    private GameListAdapter mGameListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //DATA<->ADAPTER IMPLEMENTATION

        mGameService = new GameService(); // Create an instance of Service class
        mGameLinkedList = mGameService.getAllGames(); // Request Data

        mRecyclerView = findViewById(R.id.recyclerView); //handle for RecyclerView
        mGameListAdapter = new GameListAdapter(this,mGameLinkedList); // Instance of Adapter
        mRecyclerView.setAdapter(mGameListAdapter); //sets the adapter
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); //sets the LayoutManager




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