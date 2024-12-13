package edu.maria.MariaQuintairos1TRIM.entities;

import edu.maria.MariaQuintairos1TRIM.entities.enumerated.TipoMotor;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "motores")
public class Motor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private TipoMotor tipoMotor;
    private String fabricante;

    @OneToOne(mappedBy = "motor") 
    private Coche coche;

    public Motor() {
    }

    public Motor(Integer id, TipoMotor tipo, String fabricante, Coche coche) {
        this.id = id;
        this.tipoMotor = tipo;
        this.fabricante = fabricante;
        this.coche = coche;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoMotor getTipo() {
        return tipoMotor;
    }

    public void setTipo(TipoMotor tipo) {
        this.tipoMotor = tipo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    @Override
    public String toString() {
        return "Motor [id=" + id + ", tipo=" + tipoMotor + ", fabricante=" + fabricante + ", coche=" + coche + "]";
    }
    
}