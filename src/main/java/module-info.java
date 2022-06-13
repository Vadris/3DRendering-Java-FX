module org.v4dris._3drenderinge {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.v4dris._3drenderinge to javafx.fxml;
    exports org.v4dris._3drenderinge;
}