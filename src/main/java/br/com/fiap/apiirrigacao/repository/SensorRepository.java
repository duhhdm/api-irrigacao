package br.com.fiap.apiirrigacao.repository;

import br.com.fiap.apiirrigacao.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
}