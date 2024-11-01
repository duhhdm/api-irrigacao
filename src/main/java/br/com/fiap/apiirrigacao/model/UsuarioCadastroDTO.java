package br.com.fiap.apiirrigacao.model;

import br.com.fiap.apiirrigacao.entity.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioCadastroDTO(String nome,

                                 @NotNull @NotBlank @Email
                                 String email,
                                 @NotNull @NotBlank
                                 String senha,

                                 RoleEnum role ){
}
