module com.gjbmloslos.elevatorsim {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;


    opens com.gjbmloslos.elevatorsim to javafx.fxml;
    exports com.gjbmloslos.elevatorsim;
    exports com.gjbmloslos.elevatorsim.constants;
    opens com.gjbmloslos.elevatorsim.constants to javafx.fxml;
}