package pnpmusic;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


public class MusicLibrary {

    private String name;
    private Vector<File> cache = new Vector<File>();

    public MusicLibrary(String name) {
        this.name = name;
        scanFolder();
    }

    public void scanFolder() {
        cache.clear();
        addTree(new File("./src/Music/" + name), cache, true);
        System.out.println(cache);
    }

    static void addTree(File file, Vector<File> all, boolean recursive) {
        File[] children = file.listFiles();
        if (children != null) {
            for (File child : children) {
                all.add(child);
                if (recursive){
                    addTree(child, all, true);
                }
            }
        }
    }

    public void playSong() {
        Collections.shuffle(cache);
        Media media = null;
        try {
            media = new Media(cache.get(0).toURI().toURL().toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        MediaPlayer mediaPlayer = new MediaPlayer(media);

        mediaPlayer.play();
    }

    public String getName() {
        return name;
    }
}
