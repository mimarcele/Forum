package com.alura.security;

import com.alura.dto.TokenDto;
import com.alura.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AutentService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;



    public TokenDto autenticar(final LoginForm form) {
        TokenDto tokenDto = new TokenDto();
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();

        try {
           Authentication authentication =  authenticationManager.authenticate(dadosLogin);
           String token = tokenService.gerarToken(authentication);
           return new TokenDto(token, "Bearer");

        } catch (AuthenticationException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return tokenDto;

    }
}
