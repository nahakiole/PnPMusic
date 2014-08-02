package pnpmusic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class Main extends Application {

    Vector<File> categories = new Vector<File>();
    Vector<Button> buttons = new Vector<Button>();
    Vector<MusicLibrary> MusicLibraries = new Vector<MusicLibrary>();


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("PnPMusic");
        primaryStage.setScene(new Scene(root, 250, 100));
        primaryStage.setResizable(false);
        GridPane mainGrid = (GridPane) primaryStage.getScene().lookup("#mainGrid");
        mainGrid.setGridLinesVisible(false);


        MusicLibrary.addTree(new File("./src/Music/"), categories, false);


        int i = 0;
        int e = 0;
        for (File directory : categories) {
            String category = directory.getName();
            Button button = new Button(category);

            final MusicLibrary musicLibrary = new MusicLibrary(category);

            MusicLibraries.add(musicLibrary);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    musicLibrary.playSong();
                }
            });
            buttons.add(button);
            if (i >= 4){
                i = 0;
                e++;
            }

            mainGrid.add(button, i, e);
            i++;
        }


        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
