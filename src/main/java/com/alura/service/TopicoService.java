package com.alura.service;

import com.alura.dto.DetalhesTopicoDto;
import com.alura.dto.TopicoDto;
import com.alura.exception.TopicoNotFoundException;
import com.alura.modelo.Topico;
import com.alura.dto.TopicoFormDto;
import com.alura.repository.CursoRepository;
import com.alura.repository.TopicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Topico cadastrar(final TopicoFormDto form) {
        Topico topico = new Topico();
        topico.setTitulo(form.getTitulo());
        topico.setMensagem(form.getMensagem());
        topico.setCurso(cursoRepository.findByNome(form.getNomeCurso()));
        topicoRepository.save(topico);

        return topico;
    }

    public List<Topico> listar() {
        List<Topico> topicos = topicoRepository.findAll();
        return topicos;
    }

    public DetalhesTopicoDto buscar(final Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if (!topico.isPresent()) {
            throw new TopicoNotFoundException("Tópico não encontrado");
        }
        return new DetalhesTopicoDto(topico.get());
    }

    public void atualizar(final TopicoDto topicoDto, final Long id) {
        topicoRepository.findById(id)
                .map(topico -> {
                    BeanUtils.copyProperties(topicoDto, topico, "id");
                    topicoRepository.save(topico);
                    return topico;
                }).orElseThrow(() -> new TopicoNotFoundException("Tópico não encontrado, verifique o id"));

    }

    public void deletar(final Long id){
      Optional<Topico> topico = topicoRepository.findById(id);
      if(!topico.isPresent()){
          throw new TopicoNotFoundException("Tópico não encontrado");
      }
      topicoRepository.delete(topico.get());

    }
}

