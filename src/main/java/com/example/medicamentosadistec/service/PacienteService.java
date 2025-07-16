package com.example.medicamentosadistec.service;

import com.example.medicamentosadistec.dto.PacienteOutputDto;
import com.example.medicamentosadistec.model.Medicamento;
import com.example.medicamentosadistec.model.Paciente;
import com.example.medicamentosadistec.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public PacienteOutputDto buscarPorNombre(String nombre) {
        try {
            Optional<Paciente> optionalPaciente = pacienteRepository.findByNombreIgnoreCase(nombre);

            if (optionalPaciente.isEmpty()) {
                return PacienteOutputDto.builder()
                        .mensaje("Paciente no encontrado")
                        .build();
            }

            Paciente paciente = optionalPaciente.get();

            List<String> nombresMeds = paciente.getMedicamentos() == null ?
                    List.of() :
                    paciente.getMedicamentos().stream()
                            .map(Medicamento::getNombre)
                            .collect(Collectors.toList());

            return PacienteOutputDto.builder()
                    .nombre(paciente.getNombre())
                    .apellido(paciente.getApellido())
                    .edad(paciente.getEdad())
                    .fechaNacimiento(paciente.getFechaNacimiento())
                    .medicamentos(nombresMeds)
                    .mensaje("OK")
                    .build();

        } catch (Exception e) {
            return PacienteOutputDto.builder()
                    .mensaje("Error al buscar paciente")
                    .build();
        }
    }

}
