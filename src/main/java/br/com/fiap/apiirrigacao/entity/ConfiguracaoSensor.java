package br.com.fiap.apiirrigacao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_Config_sensor")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class ConfiguracaoSensor {
    @Id
    @Column(name = "id_conf_sensor")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "nr_temperatura")
    private Double temperatura;
    @Column(name = "nr_umidade")
    private Double umidade;
    @OneToOne
    @JoinColumn(name = "id_sensor")
    private Sensor sensor;

    public ConfiguracaoSensor() {

    }
}
