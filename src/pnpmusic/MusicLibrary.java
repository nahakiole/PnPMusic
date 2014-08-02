package pnpmusic;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


public class MusicLibrary {

    private String name;
    private Player player;
    private Vector<File> cache = new Vector<File>();

    public MusicLibrary(String name, Player player) {
        this.name = name;
        this.player = player;
        scanFolder();
    }

    public void scanFolder() {
        cache.clear();
        addTree(new File("./src/Music/" + name), cache, true);
    }

    static void addTree(File file, Vector<File> all, boolean recursive) {
        File[] children = file.listFiles();
        if (children != null) {
            for (File child : children) {
                all.add(child);
                if (recursive) {
                    addTree(child, all, true);
                }
            }
        }
    }

    public void playSong() {
        Collections.shuffle(cache);

        try {
            player.playSong(cache.get(0).toURI().toURL().toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public String getName() {
        return name;
    }
}
