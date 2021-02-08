package dam.edusoft.wikiapivolleyp4.persistence.model;

public class Game {

    private String name;
    private String developer;
    private String yearRelease;
    private String urlPhoto;

    public Game() {
    }

    public Game(String name, String developer, String yearRelease, String urlPhoto) {
        this.name = name;
        this.developer = developer;
        this.yearRelease = yearRelease;
        this.urlPhoto = urlPhoto;
    }

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

    @Override
    public String toString() {
        return "Juego{" +
                "name='" + name + '\'' +
                ", developer='" + developer + '\'' +
                ", yearRelease='" + yearRelease + '\'' +
                ", urlPhoto='" + urlPhoto + '\'' +
                '}';
    }
}
