package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Timer;

//banana

public class GameCode extends Application {

    int score = -1;
    private long timestep = System.nanoTime() + 2500;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = new Pane();
        primaryStage.setTitle("Button Game");

        Button btn = new Button("Click on me");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                score = score + 1;
                btn.setLayoutX(Math.random()*400);
                btn.setLayoutY(Math.random()*400);
            }
        });

        new AnimationTimer(){
            public void handle(long now) {
                if(now > timestep){
                    btn.setLayoutX(Math.random()*400);
                    btn.setLayoutY(Math.random()*400);
                    timestep = now + 700000000;
                }
            }
        }.start();

        btn.setLayoutX(200);
        btn.setLayoutY(250);
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
