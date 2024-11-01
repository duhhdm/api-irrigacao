package br.com.fiap.apiirrigacao.repository;

import br.com.fiap.apiirrigacao.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    public Usuario findByEmail(String email);
    public void deleteByEmail(String email);
}
