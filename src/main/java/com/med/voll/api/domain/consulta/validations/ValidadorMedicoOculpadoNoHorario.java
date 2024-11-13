package com.med.voll.api.domain.consulta.validations;

import com.med.voll.api.domain.consulta.ConsultaRepository;
import com.med.voll.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorMedicoOculpadoNoHorario {

    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var medicoOcupado = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if(medicoOcupado){
            throw new RuntimeException("Médico ocupado no horário solicitado!");
        }
    }
}
