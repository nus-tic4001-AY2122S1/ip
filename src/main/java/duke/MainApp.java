package duke;

import duke.ui.MainWindow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    private Duke duke = new Duke();

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane mainWindow = new MainWindow(stage, duke);
        stage.setTitle("👾 [l-shihao/ip] Duke");
        stage.setScene(new Scene(mainWindow));
        stage.show();
    }
}
