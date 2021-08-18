package com.dio.live.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
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
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataTrabalhada;

    @Column(name = "QUANTIDADE_HORAS_TRABALHADA",
            nullable = false)
    private BigDecimal quantidadeHorasTrabalhada;

    @Column(name = "SALDO_HORAS_TRABALHADA",
            nullable = false)
    private BigDecimal saldoHorasTrabalhada;

    @ManyToOne
    @JoinColumn(name = "ID_MOVIMENTACAO",
            nullable = false,
            foreignKey = @ForeignKey(name = "MOV_BANCHORA_FK"),
            referencedColumnName = "ID_MOVIMENTACAO")
    private Movimentacao movimentacao;
}
