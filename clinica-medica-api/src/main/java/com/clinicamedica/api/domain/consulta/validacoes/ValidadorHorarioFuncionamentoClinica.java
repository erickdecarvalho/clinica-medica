package com.clinicamedica.api.domain.consulta.validacoes;

import com.clinicamedica.api.domain.consulta.DadosAgendamentoConsulta;
import com.clinicamedica.api.infra.exception.ValidacaoException;

import java.time.DayOfWeek;

/*
* O horário de funcionamento da clínica é de segunda a sábado, das 07:00 às 19:00
*/

public class ValidadorHorarioFuncionamentoClinica {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAbertura = dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;

        if (domingo || antesDaAbertura || depoisDoEncerramentoDaClinica) {
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica");
        }

    }

}
