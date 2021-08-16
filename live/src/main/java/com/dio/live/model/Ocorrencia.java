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
@Entity(name = "Ocorrencia")
@Table(name = "OCORRENCIA")
public class Ocorrencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_OCORRENCIA",
            nullable = false,
            unique = true)
    private Long idOcorrencia;

    @Column(name = "NOME",
            nullable = false)
    private String nome;

    @Column(name = "DESCRICAO",
            nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "ocorrencia")
    @ElementCollection
    private List<Movimentacao> movimentacoes;
}
