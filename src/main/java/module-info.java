module com.dmslob.app_fx.appfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dmslob.app_fx.appfx to javafx.fxml;
    exports com.dmslob.app_fx.appfx;
}