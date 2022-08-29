package com.mycompany.prog2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Veiculo;
import util.Dao;

public class PrincipalController {
    @FXML
    private void cadastrarOperador() throws IOException {
        App.setRoot("novoOperador");
    }
    
    @FXML
    private void cadastrarMotorista() throws IOException {
        App.setRoot("novoMotorista");
    }
    
    @FXML
    private void cadastrarVeiculo() throws IOException {
        App.setRoot("novoVeiculo");
    }
    
    @FXML
    private void retiradaVeiculo() throws IOException {
        App.setRoot("retiradaVeiculo");
    }
    
    @FXML
    private void devolucaoVeiculo() throws IOException {
        App.setRoot("devolucaoVeiculo");
    }

    @FXML
    private void buscarData() throws IOException {
        App.setRoot("buscarData");
    }

    @FXML
    private void deslogar() throws IOException {
        App.setRoot("login");
    }
    
}
