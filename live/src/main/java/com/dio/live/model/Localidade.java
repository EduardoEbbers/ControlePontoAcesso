package com.dio.live.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Localidade implements Serializable {

    private Long idLocalidade;

    private Long idNivelAcesso;

    private String descricao;
}
