package pack_2020_11_17;

public class Track {
    private String trackName;
    private Singer singer;
    private int time;
    private Genre genre;

    public Track(String trackName, Singer singer, int time, Genre genre) {
        this.trackName = trackName;
        this.singer = singer;
        this.time = time;
        this.genre = genre;
    }

    public String getTrackName() {
        return trackName;
    }

    public Singer getSinger() {
        return singer;
    }

    public int getTime() {
        return time;
    }

    public Genre getGenre() {
        return genre;
    }
    @Override
    public String toString() {
        String str;
        if (time%60<10){str="0"+time%60;}
        else {str=""+time%60;}
        return "Песня {" +
                "Название:'" + trackName + '\'' +
                ", " + singer +
                ", Длительность: " + time/60+":"+str +
                ", Жанр:" + genre +
                '}';
    }
}
