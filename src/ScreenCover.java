package ireft;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by btesfaye on 12/10/15.
 */
public class ScreenCover extends Stage {


    public ScreenCover()
    {

        // Add title to the stage
        setTitle("Star Window Plot");
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();

        // set initial dimensions
        setWidth(primScreenBounds.getWidth());
        setHeight(primScreenBounds.getHeight());

        setScene(createScene());

        initStyle(StageStyle.UNDECORATED);
    }

    private Scene createScene()
    {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(12);
        grid.setAlignment(Pos.CENTER);

        HBox hbButtons = new HBox();
        hbButtons.setSpacing(10.0);

        // create scene
        Scene scene = new Scene(grid);
        //setStyle("-fx-background-color:#555555;");


        // Plot labels
        Label textTitle = new Label("Break Time alarm");
        textTitle.setFont(new Font("Arial", 150));
        // add to VBox
       grid.add(textTitle, 0, 0, 5, 5);

        // Plot labels
        Label textTitle2 = new Label("Time to move around");
        textTitle.setFont(new Font("Arial", 70));
        // add to VBox
        grid.add(textTitle2,0,6,5,3);

        return scene;
    }
}
