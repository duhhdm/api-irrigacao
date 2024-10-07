package br.com.fiap.apiirrigacao.controller;

import br.com.fiap.apiirrigacao.model.ConfSensorDTO;
import br.com.fiap.apiirrigacao.model.SensorCadastroDTO;
import br.com.fiap.apiirrigacao.model.SensorExibicaoDTO;
import br.com.fiap.apiirrigacao.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SensorController {

    @Autowired
    SensorService sensorService;

    @PostMapping("/sensores")

    public ResponseEntity<SensorExibicaoDTO> cadastroSensor(@RequestBody SensorCadastroDTO sensorCadastroDTO){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(sensorService.cadastroSensor(sensorCadastroDTO));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/sensores/{id}")
    public SensorExibicaoDTO consultaSensor(@PathVariable Integer id){
        return sensorService.consultaSensor(id);
    }

    @PutMapping("/sensores/{id}/configuracao")
    public ResponseEntity<SensorExibicaoDTO> alteraConfiguracao(@PathVariable Integer id, @RequestBody ConfSensorDTO confSensor){
        try{
            return ResponseEntity.ok(sensorService.alterarConfiguracao(id,confSensor));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }
}
