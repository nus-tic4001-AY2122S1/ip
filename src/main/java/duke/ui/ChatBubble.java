package duke.ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class ChatBubble extends HBox {
    @FXML
    private Label dialog;
    @FXML
    private ImageView emoji;
    @FXML
    private Circle pbg;
    @FXML
    private Rectangle bbg;
    @FXML
    private StackPane bubble;
    @FXML
    private StackPane head;


    private ChatBubble(Image emoji, String text) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/ChatBubble.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.emoji.setImage(emoji);
        dialog.setText(text);

        bbg.widthProperty().bind(dialog.widthProperty());
        bbg.heightProperty().bind(dialog.heightProperty());
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        this.setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        FXCollections.reverse(tmp);
        this.getChildren().setAll(tmp);
    }

    private void setPbgColor(String hex) {
        this.pbg.setFill(Color.web(hex));
    }

    private void setBbgColor(String hex) {
        this.bbg.setFill(Color.web(hex));
    }

    private void setBubbleAlignment(Pos pos) {
        this.bubble.setAlignment(pos);
    }

    public static ChatBubble getUserDialog(Image emoji, String input) {
        var chatBubble = new ChatBubble(emoji, input);

        return chatBubble;
    }

    public static ChatBubble getDukeDialog(Image emoji, String reply) {
        var chatBubble = new ChatBubble(emoji, reply);
        chatBubble.setPbgColor("f5ecb3");
        chatBubble.setBbgColor("D0D7D9");
        chatBubble.flip();
        chatBubble.setBubbleAlignment(Pos.TOP_LEFT);
        return chatBubble;
    }
}
