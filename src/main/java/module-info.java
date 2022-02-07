module ip.duke.gui {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;

    opens ip.duke.gui to javafx.controls, javafx.graphics, javafx.fxml;
}