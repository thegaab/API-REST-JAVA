package com.med.voll.api.domain.consulta.validations;

import com.med.voll.api.domain.consulta.DadosAgendamentoConsulta;

import java.time.DayOfWeek;

public class ValidadorHorarioFuncionamento {

    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAbertura = dataConsulta.getHour() < 7;
        var depoisDoFechamento = dataConsulta.getHour() > 18;

        if(domingo || antesDaAbertura || depoisDoFechamento){
            throw new RuntimeException("Horário de funcionamento: Segunda a Sexta das 07:00 às 18:00");
        }
    }
}
