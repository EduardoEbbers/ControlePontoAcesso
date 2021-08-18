package com.dio.live.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity(name = "JornadaTrabalho")
@Table(name = "JORNADA_TRABALHO")
public class JornadaTrabalho implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_JORNADA_TRABALHO",
            nullable = false,
            unique = true)
    private Long idJornadaTrabalho;

    @Column(name = "DESCRICAO",
            nullable = false)
    private String descricao;
}
