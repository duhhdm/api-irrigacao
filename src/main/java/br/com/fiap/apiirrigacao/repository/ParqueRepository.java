package br.com.fiap.apiirrigacao.repository;

import br.com.fiap.apiirrigacao.entity.Parque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParqueRepository extends JpaRepository<Parque,Integer> {

}
