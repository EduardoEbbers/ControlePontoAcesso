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
public class BancoHora implements Serializable {

    private Long idBancoHora;

    private Long idMovimentacao;

    private String categoriaUsuario;

    private LocalDateTime dataTrabalhada;

    private BigDecimal quantidadeHorasTrabalhada;

    private BigDecimal saldoHorasTrabalhada;
}
