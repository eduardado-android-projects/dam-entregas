package dam.edusoft.wikiapivolleyp4.cementerio;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.LinkedList;

import dam.edusoft.wikiapivolleyp4.R;
import dam.edusoft.wikiapivolleyp4.music.Music;
import dam.edusoft.wikiapivolleyp4.persistence.model.Game;

public class GameListAdapterCopy extends RecyclerView.Adapter<GameListAdapterCopy.GameViewHolder> {

    private static final String TAG = "GameListAdapter";
    private final LinkedList<Game> mGameLinkedList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    //The constructor receives the Activity and the data
    public GameListAdapterCopy(Context context, LinkedList<Game> gameLinkedList) {
        mLayoutInflater = LayoutInflater.from(context); //load the inflater using the Activity
        this.mGameLinkedList = gameLinkedList; //assign data reference to the adapter
        mContext = context;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creates a View
        View mItemView = mLayoutInflater.inflate(R.layout.gamelist_item, parent, false);

        return new GameViewHolder(mItemView, this); //it passes a ViewGroup & the Adapter to the ViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull GameListAdapterCopy.GameViewHolder holder, int position) {
        Game mCurrentGame = mGameLinkedList.get(position); //obtains the current Game from the position in the LinkedList

        //it sets each value to the specific View so the View Holder can finally paint it
        holder.mTextViewTitle.setText(mCurrentGame.getName());
        Glide.with(mContext)
                .load(mCurrentGame.getUrlPhoto())
                .centerCrop()
                .into(holder.mImageViewCover);


    }

    @Override
    public int getItemCount() {
        return mGameLinkedList.size();
    }

    public class GameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //Global scope variables for each View of "gamelist_item.xml"
        public final ImageView mImageViewCover;
        public final TextView mTextViewTitle;

        final GameListAdapterCopy mGameListAdapter; //A reference to the adapter

        public GameViewHolder(@NonNull View itemView, GameListAdapterCopy gameListAdapter) {
            super(itemView);

            mImageViewCover = itemView.findViewById(R.id.imageViewGameCover);
            mTextViewTitle = itemView.findViewById(R.id.textViewTitle);

            mGameListAdapter = gameListAdapter;



        }

        @Override
        public void onClick(View v) { //TODO TIENE SENTIDO IMPLEMENTAR EL LISTENER FUERA Y PASÁRSELO



        }
    }
}
