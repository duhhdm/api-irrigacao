package br.com.fiap.apiirrigacao.model;

import br.com.fiap.apiirrigacao.entity.Irrigacao;
import br.com.fiap.apiirrigacao.entity.Parque;

import java.util.Date;

public record ListIrrigacaoExibicaoDTO(Integer id, Date dataAgendamento) {
    public ListIrrigacaoExibicaoDTO(Irrigacao irrigacao){
        this(
                irrigacao.getId(),
                irrigacao.getDataAgendamento());
    }
}
