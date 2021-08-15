package com.dio.live.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class NivelAcesso implements Serializable {

    private Long idNivelAcesso;

    private String descricao;
}
