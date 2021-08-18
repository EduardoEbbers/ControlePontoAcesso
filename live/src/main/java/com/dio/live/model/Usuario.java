package com.dio.live.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
@Entity(name = "Usuario")
@Table(name = "USUARIO")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO",
            nullable = false,
            unique = true)
    private Long idUsuario;

    @Transient
    private Long idCategoriaUsuario;

    @Transient
    private Long idEmpresa;

    @Transient
    private Long idNivelAcesso;

    @Transient
    private Long idJornadaTrabalho;

    @Column(name = "NOME",
            nullable = false)
    private String nome;

    @Column(name = "TOLERANCIA_ATRASO",
            nullable = false,
            precision = 4,
            scale = 2)
    private BigDecimal toleranciaAtraso;

    @Column(name = "INICIO_JORNADA_TRABALHO",
            nullable = false)
    @Temporal(value = TemporalType.TIME)
    @JsonFormat(pattern = "mm:ss")
    private Date inicioJornadaTrabalho;

    @Column(name = "SAIDA_JORNADA_TRABALHO",
            nullable = false)
    @Temporal(value = TemporalType.TIME)
    @JsonFormat(pattern = "mm:ss")
    private Date saidaJornadaTrabalho;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA_USUARIO",
            nullable = false,
            foreignKey = @ForeignKey(name = "CATEGUSARIO_USUARIO_FK"),
            referencedColumnName = "ID_CATEGORIA_USUARIO")
    private CategoriaUsuario categoriaUsuario;

    @ManyToOne
    @JoinColumn(name = "ID_JORNADA_TRABALHO",
            nullable = false,
            foreignKey = @ForeignKey(name = "JORNTRAB_USUARIO_FK"),
            referencedColumnName = "ID_JORNADA_TRABALHO")
    private JornadaTrabalho jornadaTrabalho;

    @ManyToOne
    @JoinColumn(name = "ID_NIVEL_ACESSO",
            nullable = false,
            foreignKey = @ForeignKey(name = "NIVACESS_USUARIO_FK"),
            referencedColumnName = "ID_NIVEL_ACESSO")
    private NivelAcesso nivelAcesso;

    @ManyToOne
    @JoinColumn(name = "ID_EMPRESA",
            nullable = false,
            foreignKey = @ForeignKey(name = "EMPRESA_USUARIO_FK"),
            referencedColumnName = "ID_EMPRESA")
    private Empresa empresa;
}
