package com.example.medicamentosadistec.repository;

import com.example.medicamentosadistec.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
}