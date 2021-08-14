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
@Entity
public class Movimentacao {
    @Id
    private Long idMovimentacao;

    private LocalDateTime entradaDataMovimentacao;

    private LocalDateTime saidaDataMovimentacao;

    private BigDecimal periodoPermanencia;

    private Ocorrencia ocorrencia;

    private Calendario calendario;
}
