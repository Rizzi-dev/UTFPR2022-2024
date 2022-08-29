package com.mycompany.prog2;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Operacao;
import model.Operador;
import util.Dao;

/**
 *
 * @author Rizzi
 */
public class LoginController {

    @FXML
    private TextField campoLogin;
    
    @FXML
    private TextField campoSenha;
    
    @FXML
    private void logar() throws IOException{
        Dao<Operador> operador = new Dao(Operador.class);

        for(Operador v : operador.listarTodos()){
            if(campoLogin.getText().equals(v.getLogin()) && campoSenha.getText().equals(v.getSenha())){
                App.setRoot("principal");
                return;
            }
        }
        if(campoLogin.getText().equals("admin") && campoSenha.getText().equals("admin")){
            App.setRoot("principal");
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("");
            alerta.setContentText("Login não encontrado");
            alerta.showAndWait();
        }
    }
}
