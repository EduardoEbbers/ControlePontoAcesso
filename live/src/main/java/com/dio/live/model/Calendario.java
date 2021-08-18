package com.dio.live.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.*;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.*;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

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
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataEspecial;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_DATA",
            nullable = false,
            foreignKey = @ForeignKey(name = "TIPDATA_CALEND_FK"),
            referencedColumnName = "ID_TIPO_DATA")
    private TipoData tipoData;
}
