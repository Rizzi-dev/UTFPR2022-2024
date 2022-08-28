package model;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import model.Motorista;
import model.Veiculo;

/**
 *
 * @author prog2
 */

@Entity
@Table (name="operacao")
public class Operacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @JoinColumn(name="veiculo", referencedColumnName="id")
    @ManyToOne(optional=false, cascade=CascadeType.MERGE)
    private Veiculo veiculo;
    
    @JoinColumn(name="motorista", referencedColumnName="id")
    @ManyToOne(optional=false, cascade=CascadeType.MERGE)
    private Motorista motorista;
    
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate dataRetirada;
    
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate dataDevolucao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    public String toString() {
        if (this.dataDevolucao != null) {
            return "Motorista: " + this.getMotorista() + " | Veículo: " + this.getVeiculo() + " | Data retirada: " + this.getDataRetirada() + " | Data devolução: " + this.getDataDevolucao();
        } else if(this.dataRetirada != null) {
            return "Motorista: " + this.getMotorista() + " | Veículo: " + this.getVeiculo() + " | Data retirada: " + this.getDataRetirada() + " | Carro em uso, ainda não devolvido ";
        } else {
            return this.getMotorista() + " | " + this.getVeiculo();
        }
    }
}