package dam.edusoft.wikiapivolleyp4.music;

import android.content.Context;
import android.media.MediaPlayer;

import dam.edusoft.wikiapivolleyp4.R;

public class Music {

    Context mContext;

    public Music(Context context){
        this.mContext = context;
    }

    /** Devuelve un media player de la canción pedida
     *
     * @param songName
     * @return
     */
    public MediaPlayer getSong(String songName){

        switch (songName){
            case Song.STARCRAFT:{
                return MediaPlayer.create(mContext, Song.STARCRAFT_XML);
            }
            case Song.DOOM:{
                return MediaPlayer.create(mContext, Song.DOOM_XML);
            }
            case Song.MONKEY:{
                return MediaPlayer.create(mContext, Song.MONKEY_XML);
            }
            case Song.TENTACLE:{
                return MediaPlayer.create(mContext, Song.TENTACLE_XML);
            }
            case Song.ANOTHER:{
                return MediaPlayer.create(mContext, Song.ANOTHER_XML);
            }
        }

        return null;

    }

    public static class Song{
        public static final String STARCRAFT = "terran";
        public static final String DOOM = "doom";
        public static final String MONKEY = "monkey";
        public static final String TENTACLE = "tentacle";
        public static final String ANOTHER = "another";

        public static final Integer STARCRAFT_XML = R.raw.terran;
        public static final Integer DOOM_XML = R.raw.doom;
        public static final Integer MONKEY_XML = R.raw.terran;
        public static final Integer TENTACLE_XML = R.raw.tentacle;
        public static final Integer ANOTHER_XML = R.raw.another;
    }
}
