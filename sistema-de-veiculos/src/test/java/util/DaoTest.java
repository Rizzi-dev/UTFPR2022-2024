/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package util;

import java.util.List;
import model.Motorista;
import model.Operador;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.Veiculo;
import util.Dao;
/**
 *
 * @author prog2
 */
public class DaoTest {
    
    public DaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

//    @Test
//    public void testInserir() {
//        Veiculo v = new Veiculo("Ford", "Mustang", "12345");
//        Dao<Veiculo> dao = new Dao(Veiculo.class);
//        dao.inserir(v);
//    }
    
//    @Test
//    public void testListar() {
//        Dao<Veiculo> dao = new Dao(Veiculo.class);
//        List<Veiculo> lista = dao.listarTodos();
//        for(Veiculo v : lista){
//            System.out.println(v);
//        }
//    }
   
//    @Test
//    public void testInserirMotorista() {
//        Endereco endereco = new Endereco();
//        endereco.setCep("19930-000");
//        endereco.setLocalidade("Ribeirao do sul");
//        endereco.setLogradouro("Rua tiradentes");
//        endereco.setComplemento("Portao preto");
//        endereco.setBairro("Cabeceira");
//        endereco.setUf("SP");
//        
//        Motorista m = new Motorista("123321", "Astolfo");
//        m.setNome("Gabriel Lima");
//        m.setEndereco(endereco);
//        Dao<Motorista> dao = new Dao(Motorista.class);
//        dao.inserir(m);
//    }

//    @Test
//    public void testInserirOperador() {
//        Endereco endereco = new Endereco();
//        endereco.setCep("19930-000");
//        endereco.setLocalidade("Ribeirao do sul");
//        endereco.setLogradouro("Rua tiradentes");
//        endereco.setComplemento("Portao preto");
//        endereco.setBairro("Cabeceira");
//        endereco.setUf("SP");
//
//        Operador o = new Operador("prog2", "banana123*");
//        o.setNome("Gabriel Lima");
//        o.setEndereco(endereco);
//        Dao<Operador> dao = new Dao(Operador.class);
//        dao.inserir(o);
//    }
    
}
