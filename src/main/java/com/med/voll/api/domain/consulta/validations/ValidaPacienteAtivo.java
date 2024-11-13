package com.med.voll.api.domain.consulta.validations;

import com.med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import com.med.voll.api.domain.paciente.PacienteRepository;

public class ValidaPacienteAtivo {
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var pacienteAtivo = repository.existsByIdAndAtivoTrue(dados.idPaciente());
        if(!pacienteAtivo){
            throw new RuntimeException("Paciente inativo!");
        }
    }
}
