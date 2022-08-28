package model;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import util.Endereco;
        
        
        
@Entity
@Table (name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_pessoa", discriminatorType = DiscriminatorType.STRING)
public class Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
  
  @Column(length = 30)
   private String nome;
   
 
   @Embedded
   private Endereco endereco; 
     
 
  
public Pessoa(){
    this.nome = "";
}

    public Pessoa(String nome, Endereco endereço) {
        this.nome = nome;
        this.endereco = endereco;
    }
    
    public String toString() {
        return nome + " - " + endereco;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    

}
