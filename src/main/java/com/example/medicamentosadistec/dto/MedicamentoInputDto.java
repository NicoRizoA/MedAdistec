package com.example.medicamentosadistec.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class MedicamentoInputDto {

    private String nombre;

    private Integer monodroga;

    private Double precio;

    private String dosis;

    private Long pacienteId;
}

