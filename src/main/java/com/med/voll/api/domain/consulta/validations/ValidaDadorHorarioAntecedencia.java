package com.med.voll.api.domain.consulta.validations;

import com.med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import com.med.voll.api.domain.consulta.DadosCancelamentoConsulta;

import java.time.Duration;
import java.time.LocalDateTime;

public class ValidaDadorHorarioAntecedencia {
    public void antecedencia30minAgendamento(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var dataAtual = LocalDateTime.now();
        var diferenca = Duration.between(dataAtual, dataConsulta);

        if (diferenca.toMinutes() < 30) {
            throw new RuntimeException("Agendamento deve ser feito com no mínimo 30 minutos de antecedência!");
        }
    }
    public void antecedencia24hCancelamento(DadosCancelamentoConsulta dados) {
        var dataConsulta = dados.data();
        var dataAtual = LocalDateTime.now();
        var diferenca = Duration.between(dataAtual, dataConsulta);

        if (diferenca.toHours() < 24) {
            throw new RuntimeException("Cancelamento deve ser feito com no mínimo 24 horas de antecedência!");
        }
    }
}
