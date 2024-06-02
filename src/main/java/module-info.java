module com.example.tap20241 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tap20241 to javafx.fxml;
    exports com.example.tap20241;

    requires java.sql;
    requires mariadb.java.client;
    opens com.example.tap20241.modelos;
}