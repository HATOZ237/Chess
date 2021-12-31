module com.example.chess {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.chess to javafx.fxml;
    exports com.example.chess;
}