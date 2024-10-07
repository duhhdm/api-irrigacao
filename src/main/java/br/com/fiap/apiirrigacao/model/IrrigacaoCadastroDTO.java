package br.com.fiap.apiirrigacao.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record IrrigacaoCadastroDTO(@NotNull Date dtIrrigamento, @NotNull Integer idParque) {
}
