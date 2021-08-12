package com.dio.live.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @ManyToOne
    private CategoriaUsuario categoriaUsuario;

    private String nome;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private NivelAcesso nivelAcesso;

    @ManyToOne
    private JornadaTrabalho jornadaTrabalho;

    private BigDecimal toleranciaAtraso;

    private LocalDateTime inicioJornadaTrabalho;

    private LocalDateTime saidaJornadaTrabalho;
}
