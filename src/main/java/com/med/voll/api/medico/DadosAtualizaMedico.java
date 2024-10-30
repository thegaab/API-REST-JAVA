package com.med.voll.api.medico;

import com.med.voll.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaMedico(
        @NotNull
        Long id,
                                  String telefone,
                                  String nome,
                                  DadosEndereco endereco) {
}
