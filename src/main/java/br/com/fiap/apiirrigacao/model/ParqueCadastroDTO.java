package br.com.fiap.apiirrigacao.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ParqueCadastroDTO(@NotBlank String nomeParque, @NotBlank @Size(max = 9) String cep) {
}
