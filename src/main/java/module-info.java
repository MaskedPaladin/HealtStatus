module com.example.healtstatus {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.healtstatus to javafx.fxml;
    exports com.example.healtstatus;
    exports com.example.healtstatus.Controller;
    opens com.example.healtstatus.Controller to javafx.fxml;
    exports com.example.healtstatus.Menu;
    opens com.example.healtstatus.Menu to javafx.fxml;
}