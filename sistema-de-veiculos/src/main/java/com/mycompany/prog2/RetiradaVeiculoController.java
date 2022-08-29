/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.List;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import model.Veiculo;
import util.Dao;

import java.time.LocalDate;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Motorista;
import model.Operacao;
import model.Operador;
import util.Dao;
import model.Veiculo;

/**
 *
 * @author Rizzi
 */
public class RetiradaVeiculoController {
    
    @FXML
    private ComboBox<Veiculo> comboVeiculo;

    private List<Veiculo> veiculos;
    private ObservableList<Veiculo> listarVeiculos;
    
    @FXML
    private ComboBox<Motorista> comboMotorista;

    private List<Motorista> motoristas;
    private ObservableList<Motorista> listarMotoristas;
    
    @FXML
    private DatePicker pickerData;
    
    @FXML
    private void initialize(){
        Dao<Veiculo> daoVeiculo = new Dao(Veiculo.class);
        Dao<Motorista> daoMotorista = new Dao(Motorista.class);
        
        veiculos = daoVeiculo.listarTodos();
        listarVeiculos = FXCollections.observableArrayList(veiculos);
        comboVeiculo.getItems().addAll(listarVeiculos);
        comboVeiculo.setValue(listarVeiculos.get(0));
        
        motoristas = daoMotorista.listarTodos();
        listarMotoristas = FXCollections.observableArrayList(motoristas);
        comboMotorista.getItems().addAll(listarMotoristas);
        comboMotorista.setValue(listarMotoristas.get(0));
        
        pickerData.setValue(LocalDate.now());
    }
    
    @FXML
    private void retiradaVeiculo() throws IOException{
        Operacao operacao = new Operacao();
        operacao.setVeiculo(comboVeiculo.getValue());
        operacao.setMotorista(comboMotorista.getValue());
        operacao.setDataRetirada(pickerData.getValue());
        Dao<Operacao> dao = new Dao(Operacao.class);
        dao.inserir(operacao);
        
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText("");
        alerta.setContentText("Retirada de veículo registrada com sucesso");
        alerta.showAndWait();
    }
    
    @FXML
    private void cancelar() throws IOException{
        App.setRoot("principal");
    }
}
