package edu.maria.MariaQuintairos1TRIM.entities;

import java.util.List;

import edu.maria.MariaQuintairos1TRIM.entities.enumerated.TipoCoche;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "coches")
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String modelo;
    private TipoCoche marca;
    private String matricula;
    /* @OneToMany(mappedBy = "idTaller", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Taller> talleres; */
     @ManyToMany
    @JoinTable(
        name = "coche_taller", 
        joinColumns = @JoinColumn(name = "coche_id"), 
        inverseJoinColumns = @JoinColumn(name = "taller_id")
    )
    private List<Taller> talleres;

    @OneToOne
    @JoinColumn(name = "idMotor")
    private Motor motor;

    public Coche() {
    }

    public Coche(Integer id, String modelo, TipoCoche marca, String matricula, List<Taller> talleres, Motor motor) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.matricula = matricula;
        this.talleres = talleres;
        this.motor = motor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public TipoCoche getMarca() {
        return marca;
    }

    public void setMarca(TipoCoche marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Taller> getTalleres() {
        return talleres;
    }

    public void setTalleres(List<Taller> talleres) {
        this.talleres = talleres;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Coche [id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", matricula=" + matricula
                + ", talleres=" + talleres + ", motor=" + motor + "]";
    }


    
}
