package com.example.medicamentosadistec.service;

import com.example.medicamentosadistec.dto.MedicamentoInputDto;
import com.example.medicamentosadistec.dto.MedicamentoOutputDto;
import com.example.medicamentosadistec.model.Medicamento;
import com.example.medicamentosadistec.model.Paciente;
import com.example.medicamentosadistec.repository.MedicamentoRepository;
import com.example.medicamentosadistec.repository.PacienteRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepo;
    private final PacienteRepository pacienteRepo;

    public MedicamentoService(MedicamentoRepository medicamentoRepo, PacienteRepository pacienteRepo) {
        this.medicamentoRepo = medicamentoRepo;
        this.pacienteRepo = pacienteRepo;
    }

    public MedicamentoOutputDto guardarMedicamento(MedicamentoInputDto dto) {
        Medicamento medicamento = Medicamento.builder()
                .nombre(dto.getNombre())
                .monodroga(dto.getMonodroga())
                .precio(dto.getPrecio())
                .dosis(dto.getDosis())
                .build();

        if (dto.getPacienteId() != null) {
            Paciente paciente = pacienteRepo.findById(dto.getPacienteId())
                    .orElseThrow(() -> new RuntimeException("Paciente no encontrado con id " + dto.getPacienteId()));
            medicamento.setPaciente(paciente);
        }

        Medicamento guardado = medicamentoRepo.save(medicamento);

        return MedicamentoOutputDto.builder()
                .id(guardado.getId())
                .nombre(guardado.getNombre())
                .monodroga(guardado.getMonodroga())
                .precio(guardado.getPrecio())
                .dosis(guardado.getDosis())
                .nombrePaciente(
                        guardado.getPaciente() != null ? guardado.getPaciente().getNombre() : null
                )
                .build();
    }

}

