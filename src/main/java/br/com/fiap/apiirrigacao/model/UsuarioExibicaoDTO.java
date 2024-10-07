package br.com.fiap.apiirrigacao.model;

import br.com.fiap.apiirrigacao.entity.Usuario;

public record UsuarioExibicaoDTO(Long usuarioId, String nome,
                                 String email,
                                 RoleEnum role) {
    public UsuarioExibicaoDTO(Usuario save) {
        this(
            save.getUsuarioId(),
            save.getNome(),
            save.getEmail(),
            save.getRole()
        );
    }
}
