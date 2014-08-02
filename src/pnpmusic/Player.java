package pnpmusic;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Player {
    private MediaPlayer mediaPlayer;

    public void playSong(String name) {
        Media media = new Media(name);
        if (mediaPlayer != null){
            mediaPlayer.dispose();
        }
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
}
