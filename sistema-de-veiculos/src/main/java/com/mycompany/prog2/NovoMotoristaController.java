/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Buscador;
import model.Endereco;
import model.Motorista;
import util.Dao;

/**
 *
 * @author Rizzi
 */
public class NovoMotoristaController {
    @FXML
    private TextField campoNome;
    
    @FXML
    private TextField campoCnh;
    
    @FXML
    private TextField campoSecao;
    
    @FXML
    private TextField campoBairro;
    
    @FXML
    private TextField campoCep;
    
    @FXML
    private TextField campoComplemento;
    
    @FXML
    private TextField campoLogradouro;
    
    @FXML
    private TextField campoCidade; 
    
    @FXML
    private TextField campoEstado; 
    
    private Buscador buscador;
    private Endereco endereco; 
    
    public NovoMotoristaController(){
        buscador = new Buscador();
    }
    
    
    @FXML
    private void buscar() {
        String cep = campoCep.getText();
        try {
            endereco = buscador.buscar(cep);
            campoLogradouro.setText(endereco.getLogradouro());
            campoCidade.setText(endereco.getLocalidade());
            campoEstado.setText(endereco.getUf());
            campoBairro.setText(endereco.getBairro());
            campoComplemento.setText(endereco.getComplemento());
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
    
    @FXML
    private void cadastrarMotorista() throws IOException{
        Endereco endereco = new Endereco();
        endereco.setCep(campoCep.getText());
        endereco.setLocalidade(campoCidade.getText());
        endereco.setLogradouro(campoLogradouro.getText());
        endereco.setComplemento(campoComplemento.getText());
        endereco.setBairro(campoBairro.getText());
        endereco.setUf(campoEstado.getText());
        
        Motorista m = new Motorista(campoCnh.getText(), campoSecao.getText());
        m.setNome(campoNome.getText());
        m.setEndereco(endereco);
        Dao<Motorista> dao = new Dao(Motorista.class);
        dao.inserir(m);
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText("");
        alerta.setContentText("Motorista cadastrado com sucesso");
        alerta.showAndWait(); 
    }
    
    @FXML
    private void cancelar() throws IOException{
        App.setRoot("principal");
    }
}
