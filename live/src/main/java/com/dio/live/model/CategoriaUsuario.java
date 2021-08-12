package com.dio.live.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class CategoriaUsuario {
    @Id
    private Long idCategoriaUsuario;

    private String descricao;
}
