package com.mycompany.veiculos;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Buscador;
import model.Operador;
import util.Dao;
import util.Endereco;

public class OperadorController {
    
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
   public void inserirOperador() throws IOException {
       Operador o  = new Operador();
       o.setNome(nome.getText());
       o.setCnh(cnh.getText());
       o.setSecao(sessao.getText());
       o.setEndereco(end);
      
       
       Dao<Operador> dao = new Dao(Operador.class);
        dao.inserir(o);
       

       Alert alerta = new Alert(Alert.AlertType.INFORMATION);
       alerta.setHeaderText("Cadastrado confirmado");
       alerta.setContentText("Operador cadastrado com sucesso!");
       alerta.showAndWait();
    }    
    
    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("menu");
    }
}