package com.mycompany.veiculos;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Buscador;
import model.Motorista;
import util.Dao;
import util.Endereco;

public class SecondaryController {
    
    @FXML
    private TextField nome;
    
    @FXML
    private TextField cnh;
    
    @FXML
    private TextField sessao;
    
    @FXML
    private TextField inputEntrada;
    
    @FXML
    private TextField inputBairro;
     
    @FXML
    private TextField inputLogradouro;
      
    @FXML
    private TextField inputCidade;
       
    @FXML
    private TextField inputUF;
    
    Endereco end = new Endereco();
    
    
    @FXML
    public void buscarEndereco() throws IOException {
        Buscador buscador = new Buscador();
        try {
            end = buscador.buscar(inputEntrada.getText());
            inputBairro.setText(end.getBairro());
            inputLogradouro.setText(end.getLogradouro());
            inputCidade.setText(end.getLocalidade());
            inputUF.setText(end.getUf());         
        }
        
        catch(Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
       alerta.setHeaderText("");
       alerta.setContentText("CEP NAO ENCONTRADO!");
       alerta.showAndWait(); 
        }
    }
   
    
    @FXML
   public void inserirMotorista() throws IOException {
       Motorista m  = new Motorista();
       m.setNome(nome.getText());
       m.setCnh(cnh.getText());
       m.setSecao(sessao.getText());
       m.setEndereco(end);
      
       
       Dao<Motorista> dao = new Dao(Motorista.class);
        dao.inserir(m);
       

       Alert alerta = new Alert(Alert.AlertType.INFORMATION);
       alerta.setHeaderText("Cadastrado confirmado");
       alerta.setContentText("Motorista cadastrado com sucesso!");
       alerta.showAndWait();
    }    
    
    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("menu");
    }
}