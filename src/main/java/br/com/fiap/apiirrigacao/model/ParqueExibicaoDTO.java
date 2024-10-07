package br.com.fiap.apiirrigacao.model;

import br.com.fiap.apiirrigacao.entity.Parque;

public record ParqueExibicaoDTO(Integer id, String nomeParque, String cep) {

    public ParqueExibicaoDTO(Parque save) {
        this(
                save.getId(),
                save.getNomeParque(),
                save.getCep()
        );
    }
}
