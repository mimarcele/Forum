package com.alura.form;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class TopicoForm {

 @NotEmpty
 @javax.validation.constraints.NotNull
 @Length(min = 6)
 private String titulo;
 @NotEmpty
 @javax.validation.constraints.NotNull
 @Length(min = 6)
 private String mensagem;
 @NotEmpty
 @javax.validation.constraints.NotNull
 @Length(min = 6)
 private String nomeCurso;

}
