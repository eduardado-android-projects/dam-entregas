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

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.GameViewHolder> {

    private final LinkedList<Game> mGameLinkedList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    //The constructor receives the Activity and the data
    public GameListAdapter(Context context, LinkedList<Game> gameLinkedList){
        mLayoutInflater = LayoutInflater.from(context); //load the inflater using the Activity
        this.mGameLinkedList = gameLinkedList; //assign data reference to the adapter
        mContext = context;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creates a View
        View mItemView = mLayoutInflater.inflate(R.layout.gamelist_item,parent,false);

        return new GameViewHolder(mItemView,this); //it passes a ViewGroup & the Adapter to the ViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull GameListAdapter.GameViewHolder holder, int position) {
        Game mCurrentGame = mGameLinkedList.get(position); //obtains the current Game from the position in the LinkedList

        //it sets each value to the specific View so the View Holder can finally paint it
        holder.mTextViewTitle.setText(mCurrentGame.getName());
        holder.mTextViewDeveloper.setText(mCurrentGame.getDeveloper());
        holder.mTextViewYear.setText(mCurrentGame.getYearRelease());
        Glide.with(mContext)
                .load(mCurrentGame.getUrlPhoto())
                .centerCrop()
                .into(holder.mImageViewCover);


    }

    @Override
    public int getItemCount() {
        return mGameLinkedList.size();
    }

    public class GameViewHolder extends RecyclerView.ViewHolder {

        //Global scope variables for each View of "gamelist_item.xml"
        public final ImageView mImageViewCover;
        public final TextView mTextViewTitle;
        public final TextView mTextViewYear;
        public final TextView mTextViewDeveloper;

        final GameListAdapter mGameListAdapter; //A reference to the adapter

        public GameViewHolder(@NonNull View itemView, GameListAdapter gameListAdapter) {
            super(itemView);

            mImageViewCover = itemView.findViewById(R.id.imageViewCover);
            mTextViewTitle = itemView.findViewById(R.id.textViewTitle);
            mTextViewYear = itemView.findViewById(R.id.textViewYear);
            mTextViewDeveloper = itemView.findViewById(R.id.textViewDeveloper);

            mGameListAdapter = gameListAdapter;

        }
    }
}
