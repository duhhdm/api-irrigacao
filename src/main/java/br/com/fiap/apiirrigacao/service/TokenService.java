package br.com.fiap.apiirrigacao.service;

import br.com.fiap.apiirrigacao.entity.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    private String secretPass = "FIAP";

    public String gerarToken(Usuario usuario){
        Algorithm algorithm = Algorithm.HMAC256(secretPass);
        try {
            return JWT.create().
                    withIssuer("calorias").
                    withSubject(usuario.getEmail()).
                    withExpiresAt(gerarDataExpiracao()).
                    sign(algorithm);
        }catch (JWTCreationException e){
            throw new RuntimeException("não é possivel gerar token");
        }
    }

    public String validarToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretPass);
            return JWT.require(algorithm).
                    withIssuer("calorias").
                    build().verify(token).
                    getSubject();
        }catch (JWTVerificationException e){
            return "";
        }
    }

    public Instant gerarDataExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant((ZoneOffset.of("-03:00")));
    }
}
