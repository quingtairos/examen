package edu.maria.MariaQuintairos1TRIM.services;

import java.util.List;

import edu.maria.MariaQuintairos1TRIM.entities.Coche;

public interface ICochesService {

    List<Coche> obetenerListaCoches();

    Coche obtenerIdCoche(Integer id);

    Coche guardarCoche(Coche coche);

    Coche borrarCoche(Integer id);

    Coche actualizarCoche(Coche coche);

    List<Coche> obtenerCochesAntesDe(Integer anhoMax);

}
