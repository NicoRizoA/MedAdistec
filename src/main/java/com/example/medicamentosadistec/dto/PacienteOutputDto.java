package com.example.medicamentosadistec.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class PacienteOutputDto {

    private String nombre;

    private String apellido;

    private int edad;

    private LocalDate fechaNacimiento;

    private List<String> medicamentos;

    private String mensaje;
}
