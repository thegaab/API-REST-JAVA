package com.med.voll.api.domain.paciente;

import com.med.voll.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaPaciente(@NotNull String id, String email, String nome, String telefone, String dataNascimento, DadosEndereco endereco) {
}
