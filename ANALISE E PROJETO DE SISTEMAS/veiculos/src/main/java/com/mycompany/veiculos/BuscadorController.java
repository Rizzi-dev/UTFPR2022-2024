package com.mycompany.veiculos;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Buscador;
import util.Endereco;

public class BuscadorController {
      @FXML
    private TextField campoEntrada;
    
    @FXML
    private TextField campoLogradouro;
    
    @FXML
    private TextField campoCidade; 
    
    @FXML
    private TextField campoEstado; 
    
    private Buscador buscador;
    private Endereco endereco; 
    
    public BuscadorController(){
        buscador = new Buscador();
    }
    

    @FXML
    private void buscar() {
        String cep = campoEntrada.getText();
        try {
            endereco = buscador.buscar(cep);
            campoLogradouro.setText(endereco.getLogradouro());
            campoCidade.setText(endereco.getLocalidade());
            campoEstado.setText(endereco.getUf());
        } catch (IOException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("");
            alerta.setContentText(ex.getMessage());
            alerta.showAndWait(); 
        }
        catch(Exception e){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("");
            alerta.setContentText(e.getMessage());
            alerta.showAndWait(); 
        }

    }
    
}
