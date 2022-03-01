import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.io.*;
import java.time.format.*;

public class Duke extends Application {
    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;
    private Image user = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image duke = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    @Override
    public void start(Stage stage) throws IOException, DukeException, DukeExceptionFileInput {
        Ui ui = new Ui();
        TaskLists taskList = new TaskLists();
        Storage textFile = new Storage();
        try {
            textFile.readFile(taskList);
        }
        catch (FileNotFoundException | DukeExceptionInvalidTaskInputFormat e) {
            textFile.saveToDB();
            ui.showFileInputError();
        }
        //Step 1. Setting up required components

        //The container for the content of the chat to scroll.
        scrollPane = new ScrollPane();
        dialogContainer = new VBox();
        scrollPane.setContent(dialogContainer);

        userInput = new TextField();
        sendButton = new Button("Send");

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);

        scene = new Scene(mainLayout);

        stage.setScene(scene);
        stage.show();

        //Step 2. Formatting the window to look as expected
        stage.setTitle("Duke");
        stage.setResizable(false);
        stage.setMinHeight(600.0);
        stage.setMinWidth(600.0);

        mainLayout.setPrefSize(600.0, 600.0);

        scrollPane.setPrefSize(585, 535);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);

        // You will need to import `javafx.scene.layout.Region` for this.
        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);

        userInput.setPrefWidth(525.0);

        sendButton.setPrefWidth(55.0);

        AnchorPane.setTopAnchor(scrollPane, 1.0);

        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 1.0);

        AnchorPane.setLeftAnchor(userInput, 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);

        //Step 3. Add functionality to handle user input.
        sendButton.setOnMouseClicked((event) -> {
            dialogContainer.getChildren().add(getDialogLabel(userInput.getText()));
            userInput.clear();
        });

        userInput.setOnAction((event) -> {
            dialogContainer.getChildren().add(getDialogLabel(userInput.getText()));
            userInput.clear();
        });

        //Scroll down to the end every time dialogContainer's height changes.
        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));


        //Part 3. Add functionality to handle user input.
        sendButton.setOnMouseClicked((event) -> {
            try {
                handleUserInput(taskList, textFile);
            }
            catch (DukeException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });

        userInput.setOnAction((event) -> {
            try {
                handleUserInput(taskList, textFile);
            }
            catch (DukeException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    /**
     * Iteration 1:
     * Creates a label with the specified text and adds it to the dialog container.
     *
     * @param text String containing text to add
     * @return a label with the specified text that has word wrap enabled.
     */
    private Label getDialogLabel(String text) {
        // You will need to import `javafx.scene.control.Label`.
        Label textToAdd = new Label(text);
        textToAdd.setWrapText(true);

        return textToAdd;
    }

    /**
     * Iteration 2:
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    private void handleUserInput(TaskLists taskList, Storage textFile) throws DukeException, IOException {
        Label userText = new Label(userInput.getText());
        Label dukeText = new Label(getResponse(userInput.getText(), taskList, textFile));
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userText, new ImageView(user)),
                DialogBox.getDukeDialog(dukeText, new ImageView(duke))
        );
        userInput.clear();
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    private String getResponse(String input, TaskLists taskList, Storage textFile) throws IOException, DukeException {
        Ui ui = new Ui();
        String command = null;
        String message = null;
        String result = null;
        try {
            message = input.trim();
            command = new Parser().parseInput(message);
            switch (command) {
                case "todo":
                    try {
                        taskList.addToDo(message);
                        textFile.saveFile(taskList.getList());
                    }
                    catch (StringIndexOutOfBoundsException e) {
                        result = ui.showToDoEmptyError();
                        break;
                    }
                    result = ui.showTaskAdded(taskList.displayLatestTask(), taskList.getSize());
                    break;
                case "deadline":
                    try {
                        taskList.addDeadline(message);
                        textFile.saveFile(taskList.getList());
                    }
                    catch (StringIndexOutOfBoundsException e) {
                        result = ui.showDeadlineEmptyError();
                        break;
                    }
                    catch (DateTimeParseException e) {
                        result = ui.showDateTimeError();
                        break;
                    }
                    result = ui.showTaskAdded(taskList.displayLatestTask(), taskList.getSize());
                    break;
                case "event":
                    try {
                        taskList.addEvent(message);
                        textFile.saveFile(taskList.getList());
                    }
                    catch (StringIndexOutOfBoundsException e) {
                        result = ui.showEventEmptyError();
                        break;
                    }
                    result = ui.showTaskAdded(taskList.displayLatestTask(), taskList.getSize());
                    break;
                case "list":
                    try {
                        result = ui.showList(taskList.displayList());
                    }
                    catch (DukeExceptionEmptyList e) {
                        result = ui.showListEmptyError();
                        break;
                    }
                    break;
                case "delete":
                    try {
                        result = ui.showDeletedTask(taskList.deleteTask(message), taskList);
                        textFile.saveFile(taskList.getList());
                    }
                    catch (DukeExceptionInvalidTaskInputFormat e) {
                        result = ui.showInvalidTaskFormatError();
                        break;
                    }
                    catch (NumberFormatException | IndexOutOfBoundsException e) {
                        result = ui.showInvalidTaskNumberError();
                        break;
                    }
                    break;
                case "done":
                    try {
                        result = ui.showDoneTask(taskList.doneTask(message));
                        break;
                    }
                    catch (DukeExceptionInvalidTaskInputFormat e) {
                        result = ui.showInvalidTaskFormatError();
                        break;
                    }
                    catch (NumberFormatException | IndexOutOfBoundsException e) {
                        result = ui.showInvalidTaskNumberError();
                        break;
                    }
                case "find":
                    try {
                        result = ui.showFindResult((taskList.findTask(message)));
                        break;
                    }
                    catch (DukeExceptionEmptyList e) {
                        result = ui.showListEmptyError();
                        break;
                    }
                    catch (DukeExceptionFindNoResult e) {
                        result = ui.showFindNoResult();
                        break;
                    }
                case "tag":
                    try {
                        result = ui.showTagDone(taskList.tagTask(message));
                        break;
                    }
                    catch (DukeExceptionInvalidTaskInputFormat e) {
                        result = ui.showInvalidTaskFormatError();
                        break;
                    }
                    catch (NumberFormatException | IndexOutOfBoundsException e) {
                        result = ui.showInvalidTaskNumberError();
                        break;
                    }
                case "bye":
                    result = ui.showOffline();
                    break;
                default:
                    result = ui.showUnknownInputError();
            }
        }
        catch (IOException e) {
            ui.showFileError();
        }
        textFile.saveFile(taskList.getList());
        return result;
    }
}