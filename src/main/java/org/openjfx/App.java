package org.openjfx;

import javafx.application.Application;
import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        Board board = new Board();
        board.setBoard(grid);

        Scene scene = new Scene(grid);

        stage.setResizable(true);
        stage.setTitle("Chess board");
        stage.setScene(scene);
        //stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}