package com.med.voll.api.domain.consulta;

import com.med.voll.api.domain.medico.Medico;
import com.med.voll.api.domain.medico.MedicoRepository;
import com.med.voll.api.domain.paciente.PacienteRepository;
import com.med.voll.api.infra.exception.AAAHRRRGGHHHAHException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsulta dados){

        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw new AAAHRRRGGHHHAHException("Paciente não encontrado/cadastrado!");
        }

        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw new AAAHRRRGGHHHAHException("Médico não encontrado/cadastrado!");
        }

        var paciente= pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);
        var consulta = new Consulta(null, medico, paciente, dados.data());

        consultaRepository.save(consulta);
    }

    public void cancelarConsulta(DadosCancelamentoConsulta dados){

        if(!consultaRepository.existsById(dados.idConsulta())){
            throw new AAAHRRRGGHHHAHException("Consulta não encontrada/cadastrada!");
        }

        var consulta = consultaRepository.getReferenceById(dados.idConsulta());

        consultaRepository.deleteById(consulta.getId());
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if(dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if(dados.especialidade() == null) {
            throw new AAAHRRRGGHHHAHException("Especialidade é obrigatória para agendamento sem médico!");
        }

        return medicoRepository.escolherMedicoAleatorio(dados.especialidade(), dados.data());
    }
}
