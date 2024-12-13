package edu.maria.MariaQuintairos1TRIM.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.maria.MariaQuintairos1TRIM.entities.Coche;
import edu.maria.MariaQuintairos1TRIM.services.ICochesService;





@RestController
@RequestMapping("/coches")
public class CochesController {

    @Autowired
    ICochesService cochesServ;




    @GetMapping("/all")
    public List<Coche> obetenerListaCoches() {
        return cochesServ.obetenerListaCoches();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Coche> obtenerIdCoche(@PathVariable("id") Integer id) {
        Coche coche = cochesServ.obtenerIdCoche(id);
        if (coche == null) {
            return ResponseEntity.notFound().build();
        }   
        return ResponseEntity.ok().build();
    }

    @PostMapping("/guardar")
    public Coche crearCoche(@RequestBody Coche coche) {
        return cochesServ.guardarCoche(coche);
    }
    
    @DeleteMapping("/borrar/{id}")
    public Coche borrarCoche(@PathVariable("id") Integer id) {
        return cochesServ.borrarCoche(id);
    }
    
    @PutMapping("/actualizar")
    public Coche actualizarCoche(@RequestBody Coche coche) {
        return cochesServ.actualizarCoche(coche);
    }

   @GetMapping("/historial/{anhoMax}")
   public List<Coche> obtenerCochesAntesDe(@PathVariable("anhoMax") Integer anhoMax) {
       return cochesServ.obtenerCochesAntesDe(anhoMax);
   }


}