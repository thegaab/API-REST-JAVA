package com.med.voll.api.domain.consulta.validations;

import com.med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import com.med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class Valida24HAntecedenciaCancelamento implements ValidadorCancelamentoDeConsulta {
    public void validar(DadosCancelamentoConsulta dados) {
        var dataConsulta = dados.data();
        if (dataConsulta == null) {
            throw new RuntimeException("Data da consulta não pode ser nula para cancelamento!");
        }

        var dataAtual = LocalDateTime.now();
        var diferenca = Duration.between(dataAtual, dataConsulta);

        if (diferenca.toHours() < 24) {
            throw new RuntimeException("Cancelamento deve ser feito com no mínimo 24 horas de antecedência!");
        }
    }
}
