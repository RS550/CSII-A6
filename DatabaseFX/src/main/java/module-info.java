module com.monsters.databasefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens com.monsters.databasefx to javafx.fxml;
    exports com.monsters.databasefx;
}