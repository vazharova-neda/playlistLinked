package playlistLinked;

/**
 * Created by nedav on 02/04/2017.
 */
public class Song {

    private String songTitle;
    private double songDuration;

    public Song(String songTitle, double songDuration){
        this.songTitle = songTitle;
        this.songDuration = songDuration;
    }

    public String getSongTitle(){
        return songTitle;
    }

    public double getSongDuration(){
        return songDuration;
    }

    @Override
    public String toString() {
        return this.songTitle + " : " + this.songDuration;
    }
}
