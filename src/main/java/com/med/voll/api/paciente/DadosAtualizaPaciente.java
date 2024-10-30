package com.med.voll.api.paciente;

import com.med.voll.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaPaciente(@NotNull String id, String email, String nome, String telefone, String cpf, String dataNascimento, DadosEndereco endereco) {
}
