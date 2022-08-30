module com.sbfinderfx.sbfinderfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;

    opens com.sbfinderfx.sbfinderfx to javafx.fxml;
    exports com.sbfinderfx.sbfinderfx;
}