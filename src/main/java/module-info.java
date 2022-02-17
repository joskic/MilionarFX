module com.example.milionarfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.milionarfx to javafx.fxml;
    exports com.example.milionarfx;
}