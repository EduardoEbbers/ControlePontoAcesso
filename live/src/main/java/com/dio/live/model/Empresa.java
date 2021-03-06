package com.dio.live.model;

import lombok.*;
import org.springframework.context.PayloadApplicationEvent;

import javax.persistence.*;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity(name = "Empresa")
@Table(name = "EMPRESA")
public class Empresa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EMPRESA",
            nullable = false,
            unique = true)
    private Long idEmpresa;

    @Column(name = "DESCRICAO",
            nullable = false)
    private String descricao;

    @Column(name = "CNPJ",
            nullable = false,
            length = 14)
    private String cnpj;

    @Column(name = "ENDERECO",
            nullable = false)
    private String endereco;

    @Column(name = "BAIRRO",
            nullable = false)
    private String bairro;

    @Column(name = "CIDADE",
            nullable = false)
    private String cidade;

    @Column(name = "ESTADO",
            nullable = false)
    private String estado;

    @Column(name = "TELEFONE",
            nullable = false,
            length = 15)
    private String telefone;
}
