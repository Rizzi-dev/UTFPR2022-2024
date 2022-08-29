/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
/**
 *
 * @author Rizzi
 */
public class Buscador {
    public Endereco buscar(String cep) throws IllegalArgumentException, IOException, Exception  {
        // Se não estiver no formato 99999-999 já dispara exceção
        if (!cep.matches("\\d{5}-\\d{3}")) {
            throw new IllegalArgumentException("Formato de CEP inválido");
        }
        Endereco endereco = null;
        try {
            URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
            BufferedReader br
                    = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
            StringBuilder jsonSb = new StringBuilder();
            br.lines().forEach(l -> jsonSb.append(l.trim()));
            endereco = new ObjectMapper().readValue(jsonSb.toString(), Endereco.class);
        } catch (IOException e) {
            System.out.println(e);
            throw new IOException("CEP não encontrado");
        } catch (Exception e) {            
            throw new Exception("Não foi possível buscar CEP");
        }
        return endereco;
    }
}
