package br.com.fiap.apiirrigacao.model;

import br.com.fiap.apiirrigacao.entity.ConfiguracaoSensor;

import java.util.Date;

public record SensorCadastroDTO(
        Date dtInstalacao,
        Date dtManutencao,
        Integer idParque,
        ConfSensorDTO configuracaoSensor) {
}
