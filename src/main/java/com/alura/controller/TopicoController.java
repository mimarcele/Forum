package com.alura.controller;

import com.alura.dto.DetalhesTopicoDto;
import com.alura.dto.TopicoDto;
import com.alura.form.TopicoForm;
import com.alura.modelo.Topico;
import com.alura.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alura")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Topico> listar(){
        return topicoService.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Topico cadastrar(@RequestBody @Valid final TopicoForm form){
        Topico topico = topicoService.cadastrar(form);
        return topico;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DetalhesTopicoDto buscar(@PathVariable final Long id){
        return topicoService.buscar(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void atualizar(@RequestBody  @Valid final TopicoDto topicoDto, @PathVariable final Long id){
        topicoService.atualizar(topicoDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable final Long id){
        topicoService.deletar(id);
    }
}
