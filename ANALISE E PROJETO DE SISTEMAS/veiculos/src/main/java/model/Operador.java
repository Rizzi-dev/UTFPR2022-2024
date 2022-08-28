
package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import util.Endereco;

@Entity
@Table(name="operador")
@DiscriminatorValue("Operador")

public class Operador extends Pessoa {
    @Column(length = 30)
    private String cnh;
    
    @Column(length = 30)
    private String secao;
    
public Operador() {
    
}

    public Operador(String cnh, String secao) {
        this.cnh = cnh;
        this.secao = secao;
    }


    public Operador(String nome, String secao, String cnh, Endereco endereco) {
        super(nome, endereco);
        this.cnh = cnh;
        this.secao = secao;
        
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
