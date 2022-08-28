package com.mycompany.veiculos;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Veiculo;
import util.Dao;


public class PrimaryController {
    
    
    @FXML
    private TextField marca;
    
    @FXML
    private TextField modelo;
    
    @FXML
    private TextField placa;
    
    
    
    

     @FXML
    public void inserirVeiculo() throws IOException {
        Veiculo v = new Veiculo(marca.getText(), modelo.getText(), placa.getText());
        Dao<Veiculo> dao = new Dao(Veiculo.class);
        dao.inserir(v);
        
       Alert alerta = new Alert(Alert.AlertType.INFORMATION);
       alerta.setHeaderText("Cadastrado confirmado");
       alerta.setContentText("Veículo cadastrado com sucesso!");
       alerta.showAndWait();
    }    
   
    
    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("menu"); 
    
}
    
    
}
