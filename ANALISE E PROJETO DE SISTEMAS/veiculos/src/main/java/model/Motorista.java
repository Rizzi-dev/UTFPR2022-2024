
package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import util.Endereco;

@Entity
@Table(name="motorista")
@DiscriminatorValue("Motorista")
public class Motorista extends Pessoa {
    
    @Column(length = 30)
    private String cnh;
    
    @Column(length = 30)
    private String secao;
    
    public Motorista() {}

    public Motorista(String cnh, String secao) {
        this.cnh = cnh;
        this.secao = secao;
    }

    public Motorista(String nome, Endereco endereco) {
        super(nome, endereco);   
    }
    
    public String toString() {
        return (this.getNome());
    }
    
    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }
    
    
}
