package com.alura.modelo;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    @ManyToOne
    private Topico topico;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    @ManyToOne
    private Usuario autor;
    private Boolean solucao = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resposta resposta = (Resposta) o;
        return Objects.equals(id, resposta.id) &&
                Objects.equals(mensagem, resposta.mensagem) &&
                Objects.equals(topico, resposta.topico) &&
                Objects.equals(dataCriacao, resposta.dataCriacao) &&
                Objects.equals(autor, resposta.autor) &&
                Objects.equals(solucao, resposta.solucao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mensagem, topico, dataCriacao, autor, solucao);
    }
}
