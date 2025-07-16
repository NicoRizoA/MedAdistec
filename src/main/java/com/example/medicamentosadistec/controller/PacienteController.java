package com.example.medicamentosadistec.controller;

import com.example.medicamentosadistec.dto.PacienteOutputDto;
import com.example.medicamentosadistec.model.Paciente;
import com.example.medicamentosadistec.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarPorNombre(@RequestParam(required = false) String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body("El parámetro 'nombre' es obligatorio y no puede estar vacío.");
        }

        PacienteOutputDto resultado = pacienteService.buscarPorNombre(nombre);

        if ("Paciente no encontrado".equalsIgnoreCase(resultado.getMensaje())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultado);
        }

        if ("Error al buscar paciente".equalsIgnoreCase(resultado.getMensaje())) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultado);
        }

        return ResponseEntity.ok(resultado);
    }

}
