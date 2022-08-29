/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Veiculo;
import util.Dao;

/**
 *
 * @author Rizzi
 */
public class NovoVeiculoController {
    @FXML
    private Label statusVeiculo;

    @FXML
    private TextField campoMarca;
    
    @FXML
    private TextField campoModelo;
    
    @FXML
    private TextField campoPlaca;
    
    @FXML
    private void inserir() {
        Veiculo v = new Veiculo(campoMarca.getText(), campoModelo.getText(), campoPlaca.getText());
        Dao<Veiculo> dao = new Dao(Veiculo.class);
        dao.inserir(v);

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText("");
        alerta.setContentText("Veículo cadastrado com sucesso");
        alerta.showAndWait(); 
    }
    
    @FXML
    private void cancelar() throws IOException{
        App.setRoot("principal");
    }
}
