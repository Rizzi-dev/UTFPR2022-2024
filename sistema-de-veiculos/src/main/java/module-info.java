module com.mycompany.prog2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires java.base;

    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    
    opens com.mycompany.prog2 to javafx.fxml;
    opens model to org.hibernate.orm.core, javafx.base;
    
    exports com.mycompany.prog2;    
    exports model;
    exports util;
}
