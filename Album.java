package playlistLinked;

import java.util.ArrayList;
import java.util.LinkedList;


/**
 * Created by nedav on 02/04/2017.
 */
public class Album {

    private String albumName;
    private String artist;
    private ArrayList<Song> songslist;

    public Album(String albumName, String artist){
        this.albumName = albumName;
        this.artist = artist;
        songslist = new ArrayList<Song>();
    }

    public boolean addSong(String songTitle, double duration){

        if (findSong(songTitle) == null) {
            songslist.add(new Song(songTitle, duration));
            return true;
        }
    return false;
    }

    private Song findSong(String title){
        for (Song checkedSong : this.songslist){
            if (checkedSong.getSongTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlaylist (int trackNumber, LinkedList<Song> playlist){
        int index = trackNumber -1;
        if ((index>0) && (index<=this.songslist.size())){
            playlist.add(this.songslist.get(index));
            return true;
        }
        System.out.println("The album has no tracks " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist){
        Song checkedSong = findSong(title);
        if (checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("This song is not in this album");
        return false;
    }


}
