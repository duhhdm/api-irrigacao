package br.com.fiap.apiirrigacao.controller;

import br.com.fiap.apiirrigacao.entity.Usuario;
import br.com.fiap.apiirrigacao.model.LoginDTO;
import br.com.fiap.apiirrigacao.model.TokenDTO;
import br.com.fiap.apiirrigacao.model.UsuarioCadastroDTO;
import br.com.fiap.apiirrigacao.model.UsuarioExibicaoDTO;
import br.com.fiap.apiirrigacao.service.TokenService;
import br.com.fiap.apiirrigacao.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO){
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        loginDTO.email(),
                        loginDTO.senha()
                );
        Authentication authentication = authenticationManager.authenticate(usernamePassword);
        String token = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok().body(new TokenDTO(token,"Bearer"));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDTO registrar(@RequestBody UsuarioCadastroDTO usuarioCadastroDTO){
        UsuarioExibicaoDTO usuario = null;
        usuario = usuarioService.cadastroUsuario(usuarioCadastroDTO);
        return usuario;
    }
}
