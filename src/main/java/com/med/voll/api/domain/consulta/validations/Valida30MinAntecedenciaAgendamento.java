package com.med.voll.api.domain.consulta.validations;

import com.med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class Valida30MinAntecedenciaAgendamento implements ValidadorAgendamentoDeConsulta{
    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var dataAtual = LocalDateTime.now();
        var diferenca = Duration.between(dataAtual, dataConsulta);

        if (diferenca.toMinutes() < 30) {
            throw new RuntimeException("Agendamento deve ser feito com no mínimo 30 minutos de antecedência!");
        }
    }
}
