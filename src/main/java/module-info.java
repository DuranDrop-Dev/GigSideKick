module com.durandrop.gigsidekick {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;

    opens com.durandrop.gigsidekick to javafx.fxml;
    exports com.durandrop.gigsidekick;
}