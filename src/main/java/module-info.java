module com.example.demo3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo3 to javafx.fxml;
    exports com.example.demo3;

    opens board to javafx.fxml;
    exports board;

    opens register to javafx.fxml;
    exports register;

    opens login to javafx.fxml;
    exports login;

    opens start to javafx.fxml;
    exports start;
}