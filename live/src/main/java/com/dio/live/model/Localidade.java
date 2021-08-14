package com.dio.live.model;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.Target;

import javax.persistence.*;


@Getter()
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Localidade {
    @Id
    private Long idLocalidade;

    private Long idNivelAcesso;

    private String descricao;

}
