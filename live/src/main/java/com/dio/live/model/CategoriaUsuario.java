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
@Entity(name = "CategoriaUsuario")
@Table(name = "CATEGORIA_USUARIO")
public class CategoriaUsuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CATEGORIA_USUARIO",
            nullable = false,
            unique = true)
    private Long idCategoriaUsuario;

    @Column(name = "DESCRICAO",
            nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "categoriaUsuario")
    @ElementCollection
    private List<Usuario> usuarios;
}
