package com.mycompany.veiculos;

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


public class RetirarVeiculoController  {

    @FXML 
    private ComboBox<Veiculo> veic;
    
    private List<Veiculo> veiculos;
    private ObservableList<Veiculo> listVeiculos;
    
    @FXML
    private ComboBox<Motorista> moto;
    
    private List<Motorista> motoristas;
    private ObservableList<Motorista> listarMotoristas;
    
    @FXML
    private DatePicker datepicker;
    
    @FXML
    private void initialize() {
        Dao<Veiculo> daoVeiculo = new Dao(Veiculo.class);
        Dao<Motorista> daoMotorista = new Dao(Motorista.class);
        
        veiculos = daoVeiculo.listarTodos();
        listVeiculos = FXCollections.observableArrayList(veiculos);
        veic.getItems().addAll(listVeiculos);
        veic.setValue(listVeiculos.get(0));
        
        motoristas = daoMotorista.listarTodos();
        listarMotoristas = FXCollections.observableArrayList(motoristas);
        moto.getItems().addAll(listarMotoristas);
        moto.setValue(listarMotoristas.get(0));
        
        datepicker.setValue(LocalDate.now());
    }
    
    @FXML
    private void retiradaVeiculo() throws IOException{
        Operacao operacao = new Operacao();
        operacao.setVeiculo(veic.getValue());
        operacao.setMotorista(moto.getValue());
        operacao.setDataRetirada(datepicker.getValue());
        Dao<Operacao> dao = new Dao(Operacao.class);
        dao.inserir(operacao);
        
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText("");
        alerta.setContentText("Veiculo retirado com sucesso!");
        alerta.showAndWait();
    }
    
    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("menu"); 
    }
}
