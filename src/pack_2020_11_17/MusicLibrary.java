package pack_2020_11_17;

import java.util.ArrayList;

public class MusicLibrary {
    private String Name;
    private ArrayList<Album> albums = new ArrayList<>();
    public MusicLibrary(String Name) {
        this.Name = Name;
    }
    public String getName() {
        return Name;
    }
    public ArrayList<Album> getAlbums() {
        return albums;
    }
    public void addAlbum(Album album){
        albums.add(album);
    }
    @Override
    public String toString() {
        return "Фонотека {" +
                "Владелец фонотеки:'" + Name + '\'' +
                ", альбомы:" + albums +
                '}';
    }
}
