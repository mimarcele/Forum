package com.alura.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CursoDto {

    @NotEmpty @NotNull @Length(min = 5)
    private String nome;
    @NotEmpty @NotNull @Length(min = 6)
    private String categoria;

}
