package com.example.medicamentosadistec.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class MedicamentoOutputDto {

    private Long id;

    private String nombre;

    private Integer monodroga;

    private Double precio;

    private String dosis;

    private String nombrePaciente;
}

