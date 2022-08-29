/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog2;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.Motorista;
import model.Operacao;
import model.Veiculo;
import util.Dao;

/**
 *
 * @author Rizzi
 */
public class BuscarDataController implements Initializable {
    
    @FXML
    private TableView<Operacao> tabela;
    @FXML
    private TableColumn<Operacao, Integer> colunaID;
    @FXML
    private TableColumn<Operacao, LocalDate> colunaDevolucao;
    @FXML
    private TableColumn<Operacao, LocalDate> colunaRetirada;
    @FXML
    private TableColumn<Operacao, Integer> colunaMotorista;
    @FXML
    private TableColumn<Operacao, Integer> colunaVeiculo;
    
    @FXML
    private ComboBox<Operacao> comboInfo;

    private List<Operacao> operacoes;
    private ObservableList<Operacao> listarOperacoes;
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
        Dao<Operacao> daoOperacao = new Dao(Operacao.class);
        
        operacoes = daoOperacao.listarTodos();
        listarOperacoes = FXCollections.observableArrayList(operacoes);


        colunaID.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        colunaDevolucao.setCellValueFactory(
                new PropertyValueFactory<>("dataDevolucao"));
        colunaRetirada.setCellValueFactory(
                new PropertyValueFactory<>("dataRetirada"));        
        colunaMotorista.setCellValueFactory(
                new PropertyValueFactory<>("motorista"));
        colunaVeiculo.setCellValueFactory(
                new PropertyValueFactory<>("veiculo"));
        tabela.setItems(listarOperacoes);
        
        tabela.sort();
    }
    
 
    @FXML
    private void cancelar() throws IOException{
        App.setRoot("principal");
    }
}
