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
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class MovimentacaoId implements Serializable {

        private Long idMovimentacao;

        private Long idUsuario;
    }

    @EmbeddedId
    private MovimentacaoId id;

    private LocalDateTime entradaDataMovimentacao;

    private LocalDateTime saidaDataMovimentacao;

    private BigDecimal periodoPermanencia;

    @ManyToOne
    private Ocorrencia ocorrencia;

    @ManyToOne
    private Calendario calendario;
}
