package br.com.fiap.apiirrigacao.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "tb_irrigacoes")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Irrigacao {
    @Id
    @Column(name = "id_irrigacao")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "dt_agendamento")
    private Date dataAgendamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idParque")
    private Parque idParque;

    public Irrigacao() {
    }
}
