package br.com.fiap.apiirrigacao.controller;

import br.com.fiap.apiirrigacao.model.ParqueCadastroDTO;
import br.com.fiap.apiirrigacao.model.ParqueExibicaoDTO;
import br.com.fiap.apiirrigacao.service.ParqueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ParqueController {

    @Autowired
    ParqueService parqueService;

    @PostMapping("/parques")
    @ResponseStatus(HttpStatus.CREATED)
    public ParqueExibicaoDTO cadastraParque(@RequestBody @Valid ParqueCadastroDTO parqueCadastroDTO){
        return parqueService.cadastraParque(parqueCadastroDTO);
    }

    @GetMapping("/parques")
    @ResponseStatus(HttpStatus.OK)
    public List<ParqueExibicaoDTO> listParque(){
        return parqueService.listarTodos();
    }

}
