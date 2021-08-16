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
@Entity(name = "Localidade")
@Table(name = "LOCALIDADE")
public class Localidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LOCALIDADE",
            nullable = false,
            unique = true)
    private Long idLocalidade;

    @Transient
    private Long idNivelAcesso;

    @Column(name = "DESCRICAO",
            nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "ID_NIVEL_ACESSO",
            nullable = false,
            foreignKey = @ForeignKey(name = "NIVACESS_LOCALID_FK"),
            referencedColumnName = "ID_NIVEL_ACESSO")
    private NivelAcesso nivelAcesso;
}
