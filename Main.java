package playlistLinked;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Created by nedav on 02/04/2017.
 */
public class Main {

    private static  ArrayList<Album> albums = new ArrayList<Album>();
    public static void main(String[] args) {



        Album album = new Album("Break free", "Queen");
        album.addSong("Break free", 5.43);
        album.addSong("Mama", 4.3);
        album.addSong("Bohemian Rhapsody", 6.07);
        album.addSong("Don't stop me now", 3.37);
        album.addSong("Another one bites the dust",3.43);
        album.addSong("These are the days of our lives", 4.12);

        albums.add(album);

        album = new Album("Another Album", "Various");
        album.addSong("Praga", 3.23);
        album.addSong("Roza", 4.51);
        album.addSong("Oh Maria", 6.4);
        album.addSong("Let's go", 3.2);
        albums.add(album);

        LinkedList<Song>playList = new LinkedList<Song>();
        albums.get(0).addToPlaylist("Praga", playList);
        albums.get(0).addToPlaylist(4, playList);
        albums.get(1).addToPlaylist(2,playList);

        play(playList);



    }


    private static void play(LinkedList<Song> playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playlist.listIterator();
        if (playlist.size() == 0){
            System.out.println("No songs");
        }else{
            System.out.println("Now playing " + listIterator.next().toString());
        }
        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    }else{
                        System.out.println("End of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                            forward=false;
                        }
                        if (listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous().toString());
                        } else {
                            System.out.println("This is the start of the playlist");
                            forward = true;
                        }
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;

            }
        }
    }
}
