/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog2;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import model.Motorista;
import model.Operacao;
import model.Veiculo;
import util.Dao;

/**
 *
 * @author Rizzi
 */
public class DevolucaoVeiculoController {
    
    @FXML
    private ComboBox<Operacao> comboInfo;

    private List<Operacao> operacoes;
    private ObservableList<Operacao> listarOperacoes;
    
    @FXML
    private ComboBox<Motorista> comboMotorista;

    private List<Motorista> motoristas;
    private ObservableList<Motorista> listarMotoristas;
    
    @FXML
    private DatePicker pickerDataRetirada;
    
    @FXML
    private DatePicker pickerDataDevolucao;
    
    @FXML
    private void initialize(){
        Dao<Operacao> daoOperacao = new Dao(Operacao.class);
        
        operacoes = daoOperacao.listarTodos();
        listarOperacoes = FXCollections.observableArrayList(operacoes);
        for(Operacao v : operacoes){
            if(v.getDataDevolucao() == null){
                comboInfo.getItems().add(v);
            }
        }
        
        pickerDataDevolucao.setValue(LocalDate.now());
    }
    
    @FXML
    private void onChangeSelect() throws IOException{ 
        Operacao aux = comboInfo.getValue();
        pickerDataRetirada.setValue(aux.getDataRetirada());
    }
    
    @FXML
    private void devolucaoVeiculo() throws IOException{ 
        Operacao aux = comboInfo.getValue();
        
        aux.setDataDevolucao(pickerDataDevolucao.getValue());
        Dao<Operacao> dao = new Dao(Operacao.class);
        dao.alterar(aux);
        
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText("");
        alerta.setContentText("Devolução de veículo registrada com sucesso");
        alerta.showAndWait();
    }
    
    @FXML
    private void cancelar() throws IOException{
        App.setRoot("principal");
    }
}
