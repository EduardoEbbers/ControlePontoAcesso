package com.dio.live.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity(name = "TipoData")
@Table(name = "TIPO_DATA")
public class TipoData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_DATA",
            nullable = false,
            unique = true)
    private Long idTipoData;

    @Column(name = "DESCRICAO",
            nullable = false)
    private String descricao;
}
