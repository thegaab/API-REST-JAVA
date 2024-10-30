package com.med.voll.api.paciente;

import com.med.voll.api.endereco.DadosEndereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPaciente(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @Pattern(regexp = "\\d{10,11}")
        String telefone,
        @NotBlank
        String cpf,

        DadosEndereco endereco) {
}
