module com.adambougher {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.base;
    opens com.adambougher to javafx.fxml;
    exports com.adambougher;
}