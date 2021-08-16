package com.dio.live.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity(name = "BancoHora")
@Table(name = "BANCO_HORA")
public class BancoHora implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BANCO_HORA",
            nullable = false,
            unique = true)
    private Long idBancoHora;

    @Transient
    private Long idMovimentacao;

    @Column(name = "CATEGORIA_USUARIO",
            nullable = false)
    private String categoriaUsuario;

    @Column(name = "DATA_TRABALHADA",
            nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date dataTrabalhada;

    @Column(name = "QUANTIDADE_HORAS_TRABALHADA",
            nullable = false,
            precision = 4,
            scale = 2)
    private BigDecimal quantidadeHorasTrabalhada;

    @Column(name = "SALDO_HORAS_TRABALHADA",
            nullable = false,
            precision = 4,
            scale = 2)
    private BigDecimal saldoHorasTrabalhada;

    @ManyToOne
    @JoinColumn(name = "ID_MOVIMENTACAO",
            nullable = false,
            foreignKey = @ForeignKey(name = "MOV_BANCHORA_FK"),
            referencedColumnName = "ID_MOVIMENTACAO")
    private Movimentacao movimentacao;
}
