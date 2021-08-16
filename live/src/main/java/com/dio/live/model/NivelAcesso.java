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
@Entity(name = "NivelAcesso")
@Table(name = "NIVEL_ACESSO")
public class NivelAcesso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_NIVEL_ACESSO",
            nullable = false,
            unique = true)
    private Long idNivelAcesso;

    @Column(name = "DESCRICAO",
            nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "nivelAcesso")
    @ElementCollection
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "nivelAcesso")
    @ElementCollection
    private List<Localidade> localidade;
}
