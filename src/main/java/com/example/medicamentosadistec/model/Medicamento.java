package com.example.medicamentosadistec.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity @AllArgsConstructor @NoArgsConstructor @Builder
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Integer monodroga;

    private Double precio;

    private String dosis;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

}
