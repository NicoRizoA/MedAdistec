package com.example.medicamentosadistec;

import com.example.medicamentosadistec.model.Medicamento;
import com.example.medicamentosadistec.model.Paciente;
import com.example.medicamentosadistec.repository.MedicamentoRepository;
import com.example.medicamentosadistec.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class InsertarDatosDB implements CommandLineRunner {

    @Autowired
    private MedicamentoRepository medicamentoRepo;

    @Autowired
    private PacienteRepository pacienteRepo;

    @Override
    public void run(String... args) throws Exception {

        Paciente pac1 = Paciente.builder()
                .nombre("Juan")
                .apellido("Pérez")
                .edad(30)
                .fechaNacimiento(LocalDate.of(1993, 7, 16))
                .build();

        Paciente pac2 = Paciente.builder()
                .nombre("María")
                .apellido("López")
                .edad(25)
                .fechaNacimiento(LocalDate.of(1998, 3, 21))
                .build();

        Paciente pac3 = Paciente.builder()
                .nombre("Carlos")
                .apellido("Gómez")
                .edad(40)
                .fechaNacimiento(LocalDate.of(1983, 11, 2))
                .build();

        Medicamento med1 = Medicamento.builder()
                .nombre("Paracetamol")
                .monodroga(101)
                .precio(50.0)
                .dosis("500mg")
                .paciente(pac1)
                .build();

        Medicamento med2 = Medicamento.builder()
                .nombre("Ibuprofeno")
                .monodroga(102)
                .precio(75.0)
                .dosis("400mg")
                .paciente(pac2)
                .build();

        Medicamento med3 = Medicamento.builder()
                .nombre("Amoxicilina")
                .monodroga(103)
                .precio(120.0)
                .dosis("875mg")
                .paciente(pac3)
                .build();

        pac1.setMedicamentos(List.of(med1));
        pac2.setMedicamentos(List.of(med2));
        pac3.setMedicamentos(List.of(med3));

        pacienteRepo.save(pac1);
        pacienteRepo.save(pac2);
        pacienteRepo.save(pac3);

        System.out.println("Pacientes y medicamentos insertados con asociación.");
    }
}
