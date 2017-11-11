package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main application class.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Applied Mathematics Project");

        stage.setScene(
            createScene(
                loadMainPane()
            )
        );

        stage.show();
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(
            getClass().getResourceAsStream(
                WindowNavigator.MAIN
            )
        );

        FXMLMainPaneController mainController = loader.getController();

        WindowNavigator.setMainController(mainController);
        WindowNavigator.loadPane(WindowNavigator.BASIC_CALCULATOR);

        return mainPane;
    }
    
    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(
            mainPane
        );

        scene.getStylesheets().setAll(
            getClass().getResource("application.css").toExternalForm()
        );

        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
