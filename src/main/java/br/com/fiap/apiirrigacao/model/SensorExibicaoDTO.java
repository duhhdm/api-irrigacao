package br.com.fiap.apiirrigacao.model;

import br.com.fiap.apiirrigacao.entity.ConfiguracaoSensor;
import br.com.fiap.apiirrigacao.entity.Sensor;

import java.util.Date;

public record SensorExibicaoDTO(
        Integer id,
        Date dt_instalacao,
        Integer idParque,
        ConfSensorDTO configuracaoSensor) {
    public SensorExibicaoDTO(Sensor sensor, ConfiguracaoSensor configuracaoSensor){
        this(
                sensor.getId(),
                sensor.getDtInstalacao(),
                sensor.getIdParque().getId(),
                new ConfSensorDTO(
                        configuracaoSensor.getTemperatura(),
                        configuracaoSensor.getUmidade())
        );
    }
    public SensorExibicaoDTO(Sensor sensor){
        this(
                sensor.getId(),
                sensor.getDtInstalacao(),
                sensor.getIdParque().getId(),
                new ConfSensorDTO(
                        sensor.getConfiguracaoSensor().getTemperatura(),
                        sensor.getConfiguracaoSensor().getUmidade())
        );
    }
}
