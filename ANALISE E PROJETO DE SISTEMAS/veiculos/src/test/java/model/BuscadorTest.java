/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import util.Endereco;

/**
 *
 * @author prog2
 */
public class BuscadorTest {
    
    public BuscadorTest() {
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

    @Test
    public void testBuscar() {
        Buscador buscador = new Buscador(); 
        try{
            Endereco endereco = buscador.buscar("86360-000");
            
            System.out.println(endereco.getLocalidade());
        }
        catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
}
