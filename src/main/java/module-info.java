module umg.zentoryapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens umg.zentoryapp to javafx.fxml;    
    exports umg.zentoryapp;
    opens umg.zentoryapp.adminControllers to javafx.fxml;
    exports umg.zentoryapp.adminControllers;
    opens umg.zentoryapp.cajeroControllers to javafx.fxml;
    exports umg.zentoryapp.cajeroControllers;
}
