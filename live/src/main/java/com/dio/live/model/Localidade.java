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
public class Localidade {
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class LocalidadeId implements Serializable {

        private Long idLocalidade;

        private Long idNivelAcesso;
    }

    @EmbeddedId
    private LocalidadeId id;

    private String descricao;
}
