package com.dio.live.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Usuario implements Serializable {
    private Long idUsuario;

    private Long idCategoriaUsuario;

    private Long idEmpresa;

    private Long idNivelAcesso;

    private Long idJornadaTrabalho;

    private String nome;

    private BigDecimal toleranciaAtraso;

    private LocalDateTime inicioJornadaTrabalho;

    private LocalDateTime saidaJornadaTrabalho;
}
