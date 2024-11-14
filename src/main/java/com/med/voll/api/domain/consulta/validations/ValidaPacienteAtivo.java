package com.med.voll.api.domain.consulta.validations;

import com.med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import com.med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaPacienteAtivo implements ValidadorAgendamentoDeConsulta{
    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var pacienteAtivo = repository.existsByIdAndAtivoTrue(dados.idPaciente());
        if(!pacienteAtivo){
            throw new RuntimeException("Paciente inativo!");
        }
    }
}
