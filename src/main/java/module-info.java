module dev.kona.todo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    opens dev.kona.todo to javafx.fxml;
    exports dev.kona.todo;
}