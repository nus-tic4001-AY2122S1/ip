import duke.ui.Ui;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;


/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Duke duke;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/rockSpirit.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/robot2.jpg"));
    private Image bunnyImage = new Image(this.getClass().getResourceAsStream("/images/rabbit.jpg"));

    /**
     * initialize
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        showOpening();
    }

    public void setDuke(Duke d) {
        duke = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = duke.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(response, bunnyImage)
        );
        userInput.clear();
        if (response.equals("Bye. Hope to see you again soon!")) {

            Timeline exitingProgram = new Timeline(
                    new KeyFrame(Duration.seconds(11), event -> { //11 sec till closing of apps
                        Platform.exit(); }
                    ));
            exitingProgram.setCycleCount(Animation.INDEFINITE);
            exitingProgram.play();
            for (int i = 10; i > 0; i--) { //10 sec of countdown
                countdown(i);
            }

        }
    }

    private void countdown(int i) {
        Timeline exitingProgram = new Timeline(
                new KeyFrame(Duration.seconds(11 - i), event -> {
                    dialogContainer.getChildren().addAll(
                            DialogBox.getDukeDialog("Closing in " + i + " sec", bunnyImage)
                    ); }
                ));
        exitingProgram.setCycleCount(1);
        exitingProgram.play();

    }


    private void showOpening() {
        dialogContainer.getChildren().addAll(
                DialogBox.getDukeDialog(Ui.showDukeWelcome(), dukeImage)
        );
    }

}
