package dam.edusoft.wikiapivolleyp4.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import dam.edusoft.wikiapivolleyp4.R;
import dam.edusoft.wikiapivolleyp4.persistence.model.Game;

public class GameDetailsActivity extends AppCompatActivity {
    private Game mGame;

    private ImageView imageViewGamecover;
    private TextView textViewTitle;
    private TextView textViewYear;
    private TextView textViewDeveloper;
    private TextView textViewGameName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);

        //GUI
        imageViewGamecover = findViewById(R.id.imageViewPhoto);
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewYear = findViewById(R.id.textViewYear);
        textViewDeveloper = findViewById(R.id.textViewDeveloper);
        textViewGameName = findViewById(R.id.textViewTitle);
    }

    private void recogerIntent(){
        if(getIntent().hasExtra("game")){
            Game game= getIntent().getParcelableExtra("game");
            populateGUI(game);
        }
    }

    private void populateGUI(Game game) {
         String imageViewGamecoverText = game.getUrlPhoto();

         String textViewTitleText = game.getName();
         String textViewYearText = game.getYearRelease();
         String textViewDeveloperText = game.getDeveloper();
         String textViewGameNameText = game.getName();

        //imageViewGamecover.setText();

        textViewTitle.setText(textViewTitleText);
        textViewYear.setText(textViewYearText);
        textViewDeveloper.setText(textViewDeveloperText);
        textViewGameName.setText(textViewGameNameText);
    }
}