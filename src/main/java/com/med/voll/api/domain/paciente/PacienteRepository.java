package com.med.voll.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Boolean existsByIdAndAtivoTrue(@NotNull Long aLong);
}