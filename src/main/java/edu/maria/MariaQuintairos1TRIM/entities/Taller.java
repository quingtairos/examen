package edu.maria.MariaQuintairos1TRIM.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "talleres")
public class Taller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
   /*  @OneToMany(mappedBy = "idCoche")
    private List<Coche> coches; */
     @ManyToMany(mappedBy = "talleres")
    private List<Coche> coches;

    @OneToMany(mappedBy = "talleres")
    private List<Coche_Taller> cocheTalleres;

    public Taller() {
    }

    public Taller(Integer id, String nombre, List<Coche> coches, List<Coche_Taller> cocheTalleres) {
        this.id = id;
        this.nombre = nombre;
        this.coches = coches;
        this.cocheTalleres = cocheTalleres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }

    public List<Coche_Taller> getCocheTalleres() {
        return cocheTalleres;
    }

    public void setCocheTalleres(List<Coche_Taller> cocheTalleres) {
        this.cocheTalleres = cocheTalleres;
    }

    @Override
    public String toString() {
        return "Taller [id=" + id + ", nombre=" + nombre + ", coches=" + coches + ", cocheTalleres=" + cocheTalleres
                + "]";
    }

    
}
