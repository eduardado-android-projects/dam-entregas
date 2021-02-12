package dam.edusoft.wikiapivolleyp4.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import dam.edusoft.wikiapivolleyp4.IntentNames;
import dam.edusoft.wikiapivolleyp4.R;
import dam.edusoft.wikiapivolleyp4.multimedia.Music;
import dam.edusoft.wikiapivolleyp4.persistence.model.Game;

public class GameDetailsActivity extends AppCompatActivity {
    private Game mGame;

    TextView textViewTitle;
    TextView textViewYear;
    TextView textViewDeveloper;
    ImageView imageViewGamePhoto;
    TextView textViewWikipediaPetitionResult;

    MediaPlayer mediaPlayer;

    private static final String TAG = "GameDetailsActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);

        //GUI referencias
        textViewTitle = findViewById(R.id.textViewGameTitle);
        textViewDeveloper = findViewById(R.id.textViewGameDeveloper);
        textViewYear = findViewById(R.id.textViewGameYear);
        imageViewGamePhoto = findViewById(R.id.imageViewGamePhoto);
        textViewWikipediaPetitionResult = findViewById(R.id.textViewWikipediaPetitionResult);


        //capturamos el Intent
        if(getIntent().hasExtra(IntentNames.GAME_SELECTED)){ //nos aseguramos  antes de recoger el intent de que tiene adjunto el extra que esperemos
            mGame = getIntent().getParcelableExtra(IntentNames.GAME_SELECTED);
            Log.d(TAG, "onCreate: " + mGame.getName());

            populateLayout();
        }


    }

    private void populateLayout() {
        textViewTitle.setText(mGame.getName());
        textViewDeveloper.setText(mGame.getDeveloper());
        textViewYear.setText(mGame.getYearRelease());
        Glide.with(this)
                .load(mGame.getUrlPhoto())
                .into(imageViewGamePhoto);
    }


    public void play(View view) {
        Music music = new Music(this);
        mediaPlayer = music.getSong(mGame.getSongName());
        mediaPlayer.start();
    }

    public void stop(View view) {
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
    }

    public void wiki(View view) {
        /*String peticionHttp = "https://en.wikipedia.org/w/api.php?action=opensearch&search=" + gameReplaced + "&limit=11&namespace=0&format=json";*/



    }
}