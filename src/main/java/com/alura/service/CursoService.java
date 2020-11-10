package com.alura.service;

import com.alura.dto.CursoDto;
import com.alura.exception.CursoNotFoundException;
import com.alura.modelo.Curso;
import com.alura.repository.CursoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoDto criar(final CursoDto cursoDto) {
        Curso curso = new Curso();
        curso.setNome(cursoDto.getNome());
        curso.setCategoria(cursoDto.getCategoria());
        cursoRepository.save(curso);

        return cursoDto;
    }

    public List<Curso> listar() {
        List<Curso> cursos = cursoRepository.findAll();
        return cursos;
    }

    public Curso buscar(final Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        if (!curso.isPresent()) {
            throw new CursoNotFoundException("Curso não encontrado");
        }
        return curso.get();
    }

    public void atualizar(final CursoDto cursoDto, final Long id) {
        cursoRepository.findById(id)
                .map(curso -> {
                    BeanUtils.copyProperties(cursoDto, curso, "id");
                    cursoRepository.save(curso);
                    return curso;
                }).orElseThrow(() -> new CursoNotFoundException("Curso não encontrado para id solicitado"));
    }

    public void deletar(final Long id){
        Optional<Curso> cursos = cursoRepository.findById(id);
        if(!cursos.isPresent()){
            throw new CursoNotFoundException("Curso não encontrado para id solicitado");
        }
        cursoRepository.delete(cursos.get());
    }

}

