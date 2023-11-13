module com.myproject.snackandladder {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.myproject.snackandladder to javafx.fxml;
    exports com.myproject.snackandladder;
}