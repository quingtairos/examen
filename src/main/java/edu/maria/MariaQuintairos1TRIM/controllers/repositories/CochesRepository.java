package edu.maria.MariaQuintairos1TRIM.controllers.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.maria.MariaQuintairos1TRIM.entities.Coche;

@Repository
public interface CochesRepository extends JpaRepository<Coche, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM coches INNER JOIN coches_Talleres ON coches.id = coches_talleres.idCoche WHERE coches.id=:id GROUP BY coches_talleres.fecha;")
    LocalDate findByAnhoAntes(anhoMax);

}
