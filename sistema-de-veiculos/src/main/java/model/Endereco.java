/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Embeddable;

/**
 *
 * @author prog2
 */
@Embeddable
public class Endereco {
    private String cep; 
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade; 
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi; 

    public Endereco() {
    }

    public Endereco(String cep) {
        this.cep = cep;
    }
    

    public String getCep() {
        if(cep == ""){
            return "-";
        }else{
            return cep;    
        }
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        if(logradouro == ""){
            return "-";
        }else{
            return logradouro;
        }
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        if(complemento == ""){
            return "-";
        }else{
            return complemento;
        }
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        if(bairro == ""){
            return "-";
        }else{
            return bairro;
        }
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        if(localidade == ""){
            return "-";
        }else{
            return localidade;
        }
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        if(uf == ""){
            return "-";
        }else{
            return uf;
        }
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }
    
    
    
}
