package com.med.voll.api.domain.consulta.validations;

import com.med.voll.api.domain.medico.MedicoRepository;

public class ValidadorMedicoAtivo {
    private MedicoRepository repository;

    public void validar(Long idMedico){
        var medicoAtivo = repository.findAtivoById(idMedico);
        if(!medicoAtivo){
            throw new RuntimeException("Médico inativo ou não encontrado!");
        }
    }
}
