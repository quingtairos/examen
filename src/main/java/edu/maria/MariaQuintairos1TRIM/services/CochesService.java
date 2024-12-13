package edu.maria.MariaQuintairos1TRIM.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.maria.MariaQuintairos1TRIM.controllers.repositories.CochesRepository;
import edu.maria.MariaQuintairos1TRIM.entities.Coche;
import edu.maria.MariaQuintairos1TRIM.entities.Coche_Taller;
import edu.maria.MariaQuintairos1TRIM.entities.Dtos.CocheDto;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CochesService implements ICochesService {

    @Autowired
    CochesRepository  cochesRepo;

    @Override
    public List<Coche> obetenerListaCoches() {
        return cochesRepo.findAll();
    }

    @Override
    public Coche obtenerIdCoche(Integer id) {
        Optional<Coche> op = cochesRepo.findById(id);
        if (!op.isPresent()) {
            System.out.println("no se ha encontrado ningun coche con ese id");
            return null;
        }
        return op.get();
    }

    @Override
    public Coche guardarCoche(Coche coche) {
        return cochesRepo.save(coche);
    }

    @Override
    public Coche borrarCoche(Integer id) {
        Optional<Coche> op = cochesRepo.findById(id);
        if (!op.isPresent()) {
            System.out.println("no se ha encontrado ningun coche con ese id");
            return null;
        }

        cochesRepo.deleteById(id);
        System.out.println("se ha borrado el coche con id: " + id);
        return op.get();
    }

    @Override
    public Coche actualizarCoche(Coche coche) {
        Coche cocheExistente = cochesRepo.findById(coche.getId())
        .orElseThrow(() -> new EntityNotFoundException("no se ha encontrado ningun coche con ese id"));
        coche.setMotor(cocheExistente.getMotor());
        coche.setTalleres(cocheExistente.getTalleres());
        return cocheExistente.save(coche);
    }

    //otra forma de hacerlo: 

    /* @Override
    public Coche actualizarCoche(Coche coche) {
        for (Coche motor : motor.getMotor() && Coche talleres : talleres.getTalleres()) {
            motor.setMotor(coche);
            talleres.setTalleres(coche);
        }
        return cocheExistente.save(coche);
}*/

    @Override
    public List<Coche> obtenerCochesAntesDe(Integer anhoMax) {
        Optional<Coche> op = cochesRepo.findByAnho(anhoMax);
        Optional<Coche_Taller> op2 = cochesRepo.findByFecha(fecha);
        if (!op.isPresent() && !op2.isPresent()) {
            System.out.println("No existe el coche con ese id o no esiste esa fecha");
            return null;
        }
        CocheDto cocheDto = new CocheDto();
        cocheDto.setId(op.get().getId());
        cocheDto.setFecha(CochesRepo.findByFecha(op.get().getFecha()));

        return cochesDto;
        return cochesServ.obtenerHistorialCochesAntes(fecha);
    }

}
