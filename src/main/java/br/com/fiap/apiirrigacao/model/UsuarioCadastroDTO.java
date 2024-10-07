package br.com.fiap.apiirrigacao.model;

import br.com.fiap.apiirrigacao.entity.Usuario;

public record UsuarioCadastroDTO(String nome,
                                 String email,
                                 String senha,
                                 RoleEnum role ){
}
