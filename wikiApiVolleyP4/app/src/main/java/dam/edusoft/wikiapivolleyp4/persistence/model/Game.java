package dam.edusoft.wikiapivolleyp4.persistence.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Game implements Parcelable {

    private String name;
    private String developer;
    private String yearRelease;
    private String urlPhoto;
    private String songName;

    public Game() {
    }

    public Game(String name, String developer, String yearRelease, String urlPhoto, String songName) {
        this.name = name;
        this.developer = developer;
        this.yearRelease = yearRelease;
        this.urlPhoto = urlPhoto;
        this.songName = songName;
    }

    protected Game(Parcel in) {
        name = in.readString();
        developer = in.readString();
        yearRelease = in.readString();
        urlPhoto = in.readString();
        songName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(developer);
        dest.writeString(yearRelease);
        dest.writeString(urlPhoto);
        dest.writeString(songName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(String yearRelease) {
        this.yearRelease = yearRelease;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", developer='" + developer + '\'' +
                ", yearRelease='" + yearRelease + '\'' +
                ", urlPhoto='" + urlPhoto + '\'' +
                ", songName='" + songName + '\'' +
                '}';
    }
}
