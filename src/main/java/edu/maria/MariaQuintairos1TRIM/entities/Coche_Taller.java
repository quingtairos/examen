package edu.maria.MariaQuintairos1TRIM.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "coches_talleres")
public class Coche_Taller {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idCoche", referencedColumnName = "id")
    private Coche coches;

    @ManyToOne
    @JoinColumn(name = "idTaller", referencedColumnName = "id")
    private Taller talleres;

    private LocalDate fecha;

    public Coche_Taller() {
    }

    public Coche_Taller(Integer id, Coche coches, Taller talleres, LocalDate fecha) {
        this.id = id;
        this.coches = coches;
        this.talleres = talleres;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Coche getCoches() {
        return coches;
    }

    public void setCoches(Coche coches) {
        this.coches = coches;
    }

    public Taller getTalleres() {
        return talleres;
    }

    public void setTalleres(Taller talleres) {
        this.talleres = talleres;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Coche_Taller [id=" + id + ", coches=" + coches + ", talleres=" + talleres + ", fecha=" + fecha + "]";
    }
    
    
}
