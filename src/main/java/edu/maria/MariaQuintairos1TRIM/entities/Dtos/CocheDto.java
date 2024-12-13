package edu.maria.MariaQuintairos1TRIM.entities.Dtos;

import java.time.LocalDate;

import edu.maria.MariaQuintairos1TRIM.entities.enumerated.TipoCoche;

public class CocheDto {

    private Integer id;
    private String modelo;
    private TipoCoche marca;
    private String matricula;
    private LocalDate anhoMax;
}
