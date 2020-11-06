package com.alura.controller;


import com.alura.dto.TokenDto;
import com.alura.form.LoginForm;
import com.alura.security.AutentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AutentService autentService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form){
        return ResponseEntity.ok().body(autentService.autenticar(form));

    }
}
