package br.com.fiap.apiirrigacao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_parques")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Parque {

    @Id
    @Column(name = "id_parque")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "nm_parque")
    private String nomeParque;

    @Column(name = "nr_cep")
    private String cep;

    @OneToMany(mappedBy = "idParque")
    private List<Irrigacao> irrigacaoList;

    @OneToMany(mappedBy = "idParque")
    private List<Sensor> sensorList;

    public Parque() {

    }
}
