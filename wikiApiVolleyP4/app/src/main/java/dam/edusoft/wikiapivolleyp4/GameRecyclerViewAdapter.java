package dam.edusoft.wikiapivolleyp4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.LinkedList;

import dam.edusoft.wikiapivolleyp4.persistence.model.Game;

public class GameRecyclerViewAdapter extends RecyclerView.Adapter<GameRecyclerViewAdapter.GameViewHolder> {

    private final LinkedList<Game> mGameLinkedList; // data
    private LayoutInflater mLayoutInflater; // inflater
    private Context mContext; // Activity
    private OnGameListenerInterface mOnGameListenerInterface; //interfaz que implementaremos fuera (modular)


    //debugging
    private static final String TAG = "GameListAdapter";

    public GameRecyclerViewAdapter(Context context, LinkedList<Game> gameLinkedList, OnGameListenerInterface onGameListener) {
        mLayoutInflater = LayoutInflater.from(context); //load the inflater using the Activity
        this.mGameLinkedList = gameLinkedList; //assign data reference to the adapter
        mContext = context;
        mOnGameListenerInterface = onGameListener;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creates a View
        View mItemView = mLayoutInflater.inflate(R.layout.gamelist_item, parent, false);

        return new GameViewHolder(mItemView, this, mOnGameListenerInterface); //it passes a ViewGroup & the Adapter to the ViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull GameRecyclerViewAdapter.GameViewHolder holder, int position) {
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

    public class GameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //Global scope variables for each View of "gamelist_item.xml"
        public final ImageView mImageViewCover;
        public final TextView mTextViewTitle;

        private OnGameListenerInterface onGameListenerInterface;

        final GameRecyclerViewAdapter mGameListAdapter; //A reference to the adapter

        public GameViewHolder(@NonNull View itemView, GameRecyclerViewAdapter gameListAdapter, OnGameListenerInterface onGameListenerInterface) {
            super(itemView);
            this.onGameListenerInterface = onGameListenerInterface;

            mImageViewCover = itemView.findViewById(R.id.imageViewGameCover);
            mTextViewTitle = itemView.findViewById(R.id.textViewTitle);

            mGameListAdapter = gameListAdapter;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onGameListenerInterface.onGameClick(getAdapterPosition()); //ejecutamos el método de la interfaz pasándole la posición del objeto que se está clicando
            //onGameClick estará definido en la implementación, ya sea en otra Activity, en otra clase etc.
        }

    }

    public interface OnGameListenerInterface {
        void onGameClick(Integer position);
    }
}
