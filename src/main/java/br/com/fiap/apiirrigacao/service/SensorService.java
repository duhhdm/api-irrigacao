package br.com.fiap.apiirrigacao.service;

import br.com.fiap.apiirrigacao.entity.ConfiguracaoSensor;
import br.com.fiap.apiirrigacao.model.ConfSensorDTO;
import br.com.fiap.apiirrigacao.repository.ConfiguracaoSensorRepository;
import br.com.fiap.apiirrigacao.entity.Parque;
import br.com.fiap.apiirrigacao.entity.Sensor;
import br.com.fiap.apiirrigacao.repository.SensorRepository;
import br.com.fiap.apiirrigacao.model.SensorCadastroDTO;
import br.com.fiap.apiirrigacao.model.SensorExibicaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorService {

    @Autowired
    private ParqueService parqueService;
    @Autowired
    private SensorRepository sensorRepository;
    @Autowired
    private ConfiguracaoSensorRepository configuracaoSensorRepository;

    public SensorExibicaoDTO cadastroSensor(SensorCadastroDTO sensorCadastroDTO){
        Parque parque = parqueService.buscarParque(sensorCadastroDTO.idParque());
        ConfiguracaoSensor configuracaoSensor = new ConfiguracaoSensor();
        configuracaoSensor.setTemperatura(sensorCadastroDTO.configuracaoSensor().temperatura());
        configuracaoSensor.setUmidade(sensorCadastroDTO.configuracaoSensor().umidade());
        Sensor sensor = new Sensor();
        sensor.setDtInstalacao(sensorCadastroDTO.dtInstalacao());
        if(parque==null)
            throw new RuntimeException("parque não encontrado");
        sensor.setIdParque(parque);
        sensorRepository.save(sensor);
        configuracaoSensor.setSensor(sensor);
        configuracaoSensorRepository.save(configuracaoSensor);

        return new SensorExibicaoDTO(sensor,configuracaoSensor);
    }

    public SensorExibicaoDTO consultaSensor(Integer id) {
        return new SensorExibicaoDTO(sensorRepository.findById(id).orElseThrow());
    }

    public SensorExibicaoDTO alterarConfiguracao(Integer id, ConfSensorDTO confSensor) {
        Sensor sensor = sensorRepository.findById(id).orElseThrow();
        if(
                confSensor==null ||
                        (sensor.getConfiguracaoSensor().
                                getTemperatura().equals(confSensor.temperatura()) &&
                                sensor.getConfiguracaoSensor().
                                        getUmidade().equals(confSensor.umidade())))
            throw new RuntimeException("Não há alteração a ser feita");
        ConfiguracaoSensor configuracaoSensor = sensor.getConfiguracaoSensor();
        if(confSensor.temperatura()!=null && !confSensor.temperatura().isNaN() )
            configuracaoSensor.setTemperatura(confSensor.temperatura());
        if(confSensor.umidade()!=null && !confSensor.umidade().isNaN())
            configuracaoSensor.setUmidade(confSensor.umidade());

        configuracaoSensorRepository.save(configuracaoSensor);
        return new SensorExibicaoDTO(sensor,configuracaoSensor);
    }
}
