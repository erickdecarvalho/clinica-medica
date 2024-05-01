package com.clinicamedica.api.domain.consulta.validacoes;

import com.clinicamedica.api.domain.consulta.ConsultaRepository;
import com.clinicamedica.api.domain.consulta.DadosAgendamentoConsulta;
import com.clinicamedica.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidadorMedicoComOutraConsultaNoMesmoHorario {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        var medicoPossuiOutraConsultaNoMesmoHorario = consultaRepository.existsByMedicoIdAndData(dados.idMedico(), dados.data());

        if (medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new ValidacaoException("Médico já possui outra consulta agendada nesse mesmo horário");
        }

    }

}
