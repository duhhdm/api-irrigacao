package br.com.fiap.apiirrigacao.repository;

import br.com.fiap.apiirrigacao.entity.ConfiguracaoSensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfiguracaoSensorRepository extends JpaRepository<ConfiguracaoSensor, Integer> {
}