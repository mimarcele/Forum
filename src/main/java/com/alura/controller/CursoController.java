package com.alura.controller;

import com.alura.dto.CursoDto;
import com.alura.modelo.Curso;
import com.alura.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CursoDto criar(@RequestBody @Valid final CursoDto cursoDto){
        CursoDto cursoDto1 = cursoService.criar(cursoDto);
        return cursoDto1;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Curso> listar(){
        return cursoService.listar();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Curso buscar(@PathVariable Long id){
        return cursoService.buscar(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void atualizar(@RequestBody final CursoDto cursoDto, @PathVariable final Long id){
        cursoService.atualizar(cursoDto, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable final Long id){
        cursoService.deletar(id);
    }

}
