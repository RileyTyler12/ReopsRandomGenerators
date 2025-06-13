module com.reop {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.reop to javafx.fxml;
    exports com.reop;
}
