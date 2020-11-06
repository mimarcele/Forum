package com.alura.modelo;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NAO_RESPONDIDO;

    @ManyToOne
    private Usuario autor;

    @ManyToOne
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Resposta> respostas = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topico topico = (Topico) o;
        return Objects.equals(id, topico.id) &&
                Objects.equals(titulo, topico.titulo) &&
                Objects.equals(mensagem, topico.mensagem) &&
                Objects.equals(dataCriacao, topico.dataCriacao) &&
                status == topico.status &&
                Objects.equals(autor, topico.autor) &&
                Objects.equals(curso, topico.curso) &&
                Objects.equals(respostas, topico.respostas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, mensagem, dataCriacao, status, autor, curso, respostas);
    }
}
