package br.com.fiap.apiirrigacao.repository;

import br.com.fiap.apiirrigacao.entity.Irrigacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IrrigacaoRepository extends JpaRepository<Irrigacao, Integer> {
}