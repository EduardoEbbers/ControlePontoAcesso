package com.dio.live.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder

public class Ocorrencia implements Serializable {
    private Long idOcorrencia;

    private String nome;

    private String descricao;
}
