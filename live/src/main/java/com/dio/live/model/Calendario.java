package com.dio.live.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Calendario implements Serializable {

    private Long idCalendario;

    private Long idTipoData;

    private String descricao;

    private LocalDateTime dataEspecial;
}
