package com.clinicamedica.api.domain.consulta.validacoes;

import com.clinicamedica.api.domain.consulta.ConsultaRepository;
import com.clinicamedica.api.domain.consulta.DadosAgendamentoConsulta;
import com.clinicamedica.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidadorPacienteSemOutraConsultaNoDia {

    @Autowired
    private ConsultaRepository consultaRepository;

    private void validar(DadosAgendamentoConsulta dados) {
        var primeiroHorario = dados.data().withHour(7);
        var segundoHorario = dados.data().withHour(18);

        var pacientePossuiOutraConsultaNoDia = consultaRepository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, segundoHorario);

        if (pacientePossuiOutraConsultaNoDia) {
            throw new ValidacaoException("Paciente já possui consulta agendaad nesse dia!");
        }
    }


}
