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
public class BancoHoras {
    @Id
    private Long idBancoHoras;

    private String categoriaUsuario;

    private LocalDateTime dataTrabalhada;

    private BigDecimal quantidadeHorasTrabalhadas;

    private BigDecimal saldoHorasTrabalhadas;
}
