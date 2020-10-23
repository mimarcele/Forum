package com.alura.dto;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class TopicoFormDto {

   @NotEmpty @javax.validation.constraints.NotNull @Length(min = 6)
    private String titulo;
    @NotEmpty @javax.validation.constraints.NotNull @Length(min = 6)
    private String mensagem;
    @NotEmpty @javax.validation.constraints.NotNull @Length(min = 6)
    private String nomeCurso;

}
