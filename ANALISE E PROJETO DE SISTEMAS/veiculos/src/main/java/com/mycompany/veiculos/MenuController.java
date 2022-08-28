package com.mycompany.veiculos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class MenuController implements Initializable {

       @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
    private void switchToCadastroV() throws IOException {
        App.setRoot("primary"); 
 
    }
    
    @FXML
    private void switchToCadastroM() throws IOException {
        App.setRoot("secondary");
    
}
    @FXML
    private void switchToCadastroOp() throws IOException {
        App.setRoot("operador");
    }
    
     @FXML
    private void switchToRetirar() throws IOException {
        App.setRoot("retirarVeiculo");
    }
    
    @FXML
    private void switchToConsultar() throws IOException {
        App.setRoot("consulta");
    }
}
