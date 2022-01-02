module com.example.javafxchat {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.javafxchat to javafx.fxml;
    exports com.example.javafxchat;
}