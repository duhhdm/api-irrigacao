package br.com.fiap.apiirrigacao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "tb_sensores")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_sensor")
    private Integer id;
    @Column(name = "dt_instalacao")
    private Date dtInstalacao;
    @Column(name = "dt_manutencao")
    private Date dtManutencao;

    @ManyToOne
    @JoinColumn(name = "id_parque")
    private Parque idParque;

    @OneToOne(mappedBy = "sensor", fetch = FetchType.EAGER)
    private ConfiguracaoSensor configuracaoSensor;

    public Sensor() {

    }
}
