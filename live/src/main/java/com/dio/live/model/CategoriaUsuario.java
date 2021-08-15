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
public class CategoriaUsuario implements Serializable {

    private Long idCategoriaUsuario;

    private String descricao;
}
