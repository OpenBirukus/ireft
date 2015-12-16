package ireft;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;

public class Main extends Application {

    private GridPane pane = new GridPane();

    boolean runScreenCover = false;

    boolean screenOnStatus = true;

    ireft.ScreenCover screenCover;

    TextField workPeriodStr = new TextField("45");
    TextField restPeriodStr = new TextField("5");

    Timeline timeline;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.BLACK);
        String st = new String("Ireft");
        primaryStage.setTitle(st);
        primaryStage.setScene(scene);

        setInputDialog();

        // set the scene and show
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void setInputDialog()
    {
        // Title
        Label textTitle = new Label("Ireft: the break time reminder");
        textTitle.setFont(new Font("Arial", 30));

        pane.add(textTitle, 0, 0, 4, 1);

        // get star catalog path
        pane.add(new Label("Work Period (min): "), 0, 1, 1, 1);

        pane.add(workPeriodStr,1,1,2,1);

        // get star catalog path
        pane.add(new Label("Rest Period (min): "), 0, 2, 1, 1);

        pane.add(restPeriodStr, 1, 2, 2, 1);

        Button buttonStart = new Button("Start");
        pane.add(buttonStart, 1, 3, 1, 1);

        Button buttonStop = new Button("Stop");
        pane.add(buttonStop, 2, 3, 1, 1);

        pane.setVgap(20);
        pane.setHgap(4);

        Insets n = new Insets(10,10,10,10);
        pane.setPadding(n);


        screenCover = new ScreenCover();


        // add the callback event for the plot button
        buttonStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String activeButtonStyle = "-fx-background-color:green;";
                buttonStart.setStyle(activeButtonStyle);
                runScreenCover = true;

                Platform.runLater(new Runnable() {
                    public void run() {
//                screenCover.show();
                        startScreenCover();
                    };
                });

            }
        });

        // add the callback event for the plot button
        buttonStop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String activeButtonStyle = "-fx-background-color:lightgray;";
                buttonStart.setStyle(activeButtonStyle);
                runScreenCover=false;
                timeline.stop();
                screenCover.hide();
            }
        });
    }

    private void startScreenCover()
    {
        timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds((Integer.valueOf(workPeriodStr.getText()) * 60 )),
                new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        screenOnStatus = !screenOnStatus;

                        if(screenOnStatus) {
                            screenCover.show();
                            System.out.println("show");
                        }
                        else{
                            screenCover.hide();
                            System.out.println("hide");
                        }

                    }
                }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }
}
