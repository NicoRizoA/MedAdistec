package com.example.medicamentosadistec.repository;

import com.example.medicamentosadistec.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findByNombreIgnoreCase(String nombre);

}

