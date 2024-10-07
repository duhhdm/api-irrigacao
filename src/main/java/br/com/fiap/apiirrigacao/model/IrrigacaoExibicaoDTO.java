package br.com.fiap.apiirrigacao.model;

import br.com.fiap.apiirrigacao.entity.Irrigacao;

import java.util.Date;

public record IrrigacaoExibicaoDTO(Integer id, Date dtIrrigamento, Integer idParque) {
    public IrrigacaoExibicaoDTO(Irrigacao irrigacao){
        this(
                irrigacao.getId(),
                irrigacao.getDataAgendamento(),
                irrigacao.getIdParque().getId()
        );
    }
}
