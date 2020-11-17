package pack_2020_11_17;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static ArrayList<Album> albums = new ArrayList<>();
    static ArrayList<Track> tracks = new ArrayList<>();
    static ArrayList<Singer> singers = new ArrayList<>();
    static ArrayList<MusicLibrary> libraries = new ArrayList<>();

    public static void main(String[] args) {
//        int[][] array ={{1,2,3,4},{5,6,7,8}};
//        IntStream stream= Arrays.stream(array);
//        stream=stream.map(x->x+3);//не меняет объекты внутри стрима , создают новый поток с новыми данными
//        stream=stream.filter((x->x%2==0));
//        //map является конвеерным, формирует конвеер
//        System.out.println("тут прикрутили фильтр");
//
//        stream.forEach(System.out::println);//запускаем конвеер


//
//        int a=Arrays.stream(array)
//                .flatMapToInt(Arrays::stream)
//                .map(x->x*(-1))
//                .limit(3)
//                .sum();
//        System.out.println(a);
        //возвращает если стрим, значит можно что то прикрутить - конвеерный
        Singer LittleBig = new Singer(Type.BAND, "Little Big", Country.RUSSIA);
        singers.add(LittleBig);
        Track skibidi = new Track("Skibidi", LittleBig, 219, Genre.POP);
        tracks.add(skibidi);
        Track UNO = new Track("UNO", LittleBig, 129, Genre.POP);
        tracks.add(UNO);

        Singer DuncanLaurence = new Singer(Type.SOLO, "Duncan Laurence", Country.NERHERLANDS);
        singers.add(DuncanLaurence);
        Track Arcade = new Track("Arcade", DuncanLaurence, 178, Genre.POP);
        tracks.add(Arcade);
        Track LoveDontHateIt = new Track("Love Don’t Hate It", DuncanLaurence, 150, Genre.POP);
        tracks.add(LoveDontHateIt);
        Track SomeoneElse = new Track("Someone Else", DuncanLaurence, 238, Genre.POP);
        tracks.add(SomeoneElse);
        Track ImOK = new Track("I`m OK", LittleBig, 329, Genre.POP);
        tracks.add(ImOK);

        Singer Kirkorov = new Singer(Type.SOLO, "Киркоров", Country.RUSSIA);
        singers.add(Kirkorov);
        Track oLubvi = new Track("О любви", Kirkorov, 139, Genre.POP);
        tracks.add(oLubvi);
        Track poleteli = new Track("Полетели", Kirkorov, 147, Genre.POP);
        tracks.add(poleteli);
        Track sneg = new Track("Снег", Kirkorov, 203, Genre.POP);
        tracks.add(sneg);

        Singer ImagineDragons = new Singer(Type.BAND, "Imagine Dragons", Country.USA);
        singers.add(ImagineDragons);
        Track believer = new Track("Believer", ImagineDragons, 382, Genre.ROCK);
        tracks.add(believer);
        Track radioactive = new Track("Radioactive", ImagineDragons, 283, Genre.ROCK);
        tracks.add(radioactive);
        Track badLiar = new Track("Bad liar", ImagineDragons, 147, Genre.ROCK);
        tracks.add(badLiar);
        Track warriors = new Track("Warriors", ImagineDragons, 392, Genre.ROCK);
        tracks.add(warriors);

        Singer TwentyOnePilots = new Singer(Type.BAND, "Twenty One Pilots", Country.USA);
        singers.add(TwentyOnePilots);
        Track jumpsuit = new Track("Jumpsuit", TwentyOnePilots, 153, Genre.CLASSIC);
        tracks.add(jumpsuit);
        Track levitate = new Track("Levitate", TwentyOnePilots, 146, Genre.POP);
        tracks.add(levitate);
        Track myBlood = new Track("My Blood", TwentyOnePilots, 276, Genre.CLASSIC);
        tracks.add(myBlood);
        Track theHype = new Track("The Hype", TwentyOnePilots, 146, Genre.CLASSIC);
        tracks.add(theHype);

        Singer Labrinth = new Singer(Type.SOLO, "Labrinth", Country.UK);
        singers.add(Labrinth);
        Track forever = new Track("Forever", Labrinth, 113, Genre.POP);
        tracks.add(forever);
        Track allForUs = new Track("All For Us", Labrinth, 233, Genre.RAP);
        tracks.add(allForUs);
        Track noOrdinary = new Track("No Ordinary", Labrinth, 231, Genre.RAP);
        tracks.add(noOrdinary);

        Album favorite = new Album("Favorite", 2021);
        favorite.addTrack(noOrdinary);
        favorite.addTrack(forever);
        favorite.addTrack(allForUs);
        favorite.addTrack(poleteli);
        favorite.addTrack(myBlood);

        Album Trench = new Album("Trench", 2018);
        Trench.addTrack(jumpsuit);
        Trench.addTrack(levitate);
        Trench.addTrack(myBlood);
        Trench.addTrack(theHype);

        Album album2017 = new Album(
                "other",
                2017
        );
        album2017.addTrack(UNO);
        album2017.addTrack(radioactive);
        album2017.addTrack(badLiar);
        album2017.addTrack(warriors);
        album2017.addTrack(LoveDontHateIt);
        album2017.addTrack(SomeoneElse);
        Album album2020 = new Album(
                "NEW SONG",
                2020
        );

        album2020.addTrack(UNO);
        album2020.addTrack(Arcade);
        album2020.addTrack(believer);
        album2020.addTrack(warriors);

        Album album2020rusVersion = new Album(
                "NEW SONG rus version",
                2020
        );
        album2020rusVersion.addTrack(sneg);
        album2020rusVersion.addTrack(oLubvi);
        album2020rusVersion.addTrack(poleteli);
        album2020rusVersion.addTrack(ImOK);
        album2020rusVersion.addTrack(skibidi);
        albums.add(album2017);
        albums.add(album2020);
        albums.add(album2020rusVersion);
        albums.add(Trench);
        albums.add(favorite);

        MusicLibrary myLibrary = new MusicLibrary("Sana");
        myLibrary.addAlbum(favorite);
        myLibrary.addAlbum(album2020);

        MusicLibrary library1 = new MusicLibrary("2020year");
        library1.addAlbum(album2020);
        library1.addAlbum(album2020rusVersion);
        libraries.add(library1);
        libraries.add(myLibrary);
        //tracks.add(levitate);
        //1
        System.out.println("1.1) Все песни в жанре поп длины менее 180 секунд");
        tracks.stream()
                .filter(x -> x.getTime() < 180)
                .filter(x -> x.getGenre() == Genre.POP)
                .distinct()
                .forEach(System.out::println);
        //or
        System.out.println("1.2) Все песни в жанре поп длины менее 180 секунд");
        albums.stream()
                .map(album -> album.getTracks())
                .flatMap(arrayListTracks -> arrayListTracks.stream())
                .distinct()
                .filter(x -> x.getTime() < 180)
                .filter(x -> x.getGenre() == Genre.POP)
                .forEach(System.out::println);

        //2
        System.out.println("2) Все песни исполнителя Киркоров");
        albums.stream()
                .map(album -> album.getTracks())
                .flatMap(arrayListTracks -> arrayListTracks.stream())
                .filter(x -> x.getSinger() == Kirkorov)
                .distinct()
                .forEach(System.out::println);

        //3
        System.out.println("3) Длительность песен жанра поп");
        System.out.println(albums.stream()
                .map(album -> album.getTracks())
                .flatMap(arrayListTracks -> arrayListTracks.stream())
                .filter(x -> x.getGenre() == Genre.POP).mapToInt(x -> x.getTime()).sum());
        System.out.println("всего песенок:" + albums.stream()
                .map(album -> album.getTracks())
                .flatMap(arrayListTracks -> arrayListTracks.stream())
                .distinct()//удаляет одинаковые
                .count());
        System.out.println(tracks.size());
        libraries.stream()
                .filter(x -> x.getName().equals("Sana"))
                .map(library -> library.getAlbums())
                .flatMap(arrayListAlbums -> arrayListAlbums.stream())
                .map(album -> album.getTracks())
                .flatMap(arrayListTracks -> arrayListTracks.stream())
                .distinct()
                .filter(x -> x.getSinger().getName().equals("Киркоров"))
                .forEach(System.out::println);
        List<Track> kingOfPop = libraries.stream()
                .filter(x -> x.getName().equals("Sana"))
                .map(library -> library.getAlbums())
                .flatMap(arrayListAlbums -> arrayListAlbums.stream())
                .map(album -> album.getTracks())
                .flatMap(arrayListTracks -> arrayListTracks.stream())
                .distinct()
                .filter(x -> x.getSinger().getName().equals("Киркоров"))
                .collect(Collectors.toList());

        System.out.println("=============================");
        System.out.println(kingOfPop);
        System.out.println(kingOfPop instanceof ArrayList);
        System.out.println(kingOfPop instanceof LinkedList);

    }

}
