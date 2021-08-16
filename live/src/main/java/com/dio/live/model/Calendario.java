package com.dio.live.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity(name = "Calendario")
@Table(name = "CALENDARIO")
public class Calendario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CALENDARIO",
            nullable = false,
            unique = true)
    private Long idCalendario;

    @Transient
    private Long idTipoData;

    @Column(name = "DESCRICAO",
            nullable = false)
    private String descricao;

    @Column(name = "DATA_ESPECIAL",
            nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date dataEspecial;

    @OneToMany(mappedBy = "calendario")
    @ElementCollection
    private List<Movimentacao> movimentacoes;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_DATA",
            nullable = false,
            foreignKey = @ForeignKey(name = "TIPDATA_CALEND_FK"),
            referencedColumnName = "ID_TIPO_DATA")
    private TipoData tipoData;
}
