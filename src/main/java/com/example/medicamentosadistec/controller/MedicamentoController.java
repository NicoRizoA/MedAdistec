package com.example.medicamentosadistec.controller;

import com.example.medicamentosadistec.dto.MedicamentoInputDto;
import com.example.medicamentosadistec.dto.MedicamentoOutputDto;
import com.example.medicamentosadistec.model.Medicamento;
import com.example.medicamentosadistec.service.MedicamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @PostMapping("/crearMedicamento")
    public ResponseEntity<MedicamentoOutputDto> crearMedicamento(@RequestBody MedicamentoInputDto dto) {
        MedicamentoOutputDto creado = medicamentoService.guardarMedicamento(dto);
        return ResponseEntity.ok(creado);
    }
}