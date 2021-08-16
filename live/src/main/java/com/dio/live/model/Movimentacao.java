package com.dio.live.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity(name = "Movimentacao")
@Table(name = "MOVIMENTACAO")
public class Movimentacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MOVIMENTACAO",
            nullable = false,
            unique = true)
    private Long idMovimentacao;

    @Transient
    private Long idUsuario;

    @Transient
    private Long idOcorrencia;

    @Transient
    private Long idCalendario;

    @Column(name = "ENTRADA_DATA_MOVIMENTACAO",
            nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date entradaDataMovimentacao;

    @Column(name = "SAIDA_DATA_MOVIMENTACAO",
            nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date saidaDataMovimentacao;

    @Column(name = "PERIODO_PERMANENCIA",
            nullable = false,
            precision = 4,
            scale = 2)
    private BigDecimal periodoPermanencia;

    @ManyToOne
    @JoinColumn(name = "ID_OCORRENCIA",
            nullable = false,
            foreignKey = @ForeignKey(name = "OCORR_MOV_FK"),
            referencedColumnName = "ID_OCORRENCIA")
    private Ocorrencia ocorrencia;

    @ManyToOne
    @JoinColumn(name = "ID_CALENDARIO",
            nullable = false,
            foreignKey = @ForeignKey(name = "CALEND_MOV_FK"),
            referencedColumnName = "ID_CALENDARIO")
    private Calendario calendario;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO",
            nullable = false,
            foreignKey = @ForeignKey(name = "USUARIO_MOV_FK"),
            referencedColumnName = "ID_USUARIO")
    private Usuario usuario;

    @OneToMany(mappedBy = "movimentacao")
    @ElementCollection
    private List<BancoHora> bancoHoras;
}
