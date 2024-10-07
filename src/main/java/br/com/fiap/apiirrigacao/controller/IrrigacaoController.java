package br.com.fiap.apiirrigacao.controller;

import br.com.fiap.apiirrigacao.model.IrrigacaoCadastroDTO;
import br.com.fiap.apiirrigacao.model.IrrigacaoExibicaoDTO;
import br.com.fiap.apiirrigacao.model.ListIrrigacaoExibicaoDTO;
import br.com.fiap.apiirrigacao.service.IrrigacaoService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IrrigacaoController {

    @Autowired
    IrrigacaoService irrigacaoService;

    @PostMapping("/irrigadores")
    public ResponseEntity<IrrigacaoExibicaoDTO> cadastrarIrrigacao(@RequestBody @Valid IrrigacaoCadastroDTO irrigacaoCadastroDTO){
        try {
            return ResponseEntity.ok(irrigacaoService.cadastrarIrrigador(irrigacaoCadastroDTO));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/irrigadores/{id}")
    public ResponseEntity deletaIrrigacao(@PathVariable Integer id){
        try {
            irrigacaoService.deletarIrrigacao(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/irrigadores")
    public ResponseEntity<List<ListIrrigacaoExibicaoDTO>> consultaListaIrrigacao(){
        return ResponseEntity.ok(irrigacaoService.lista());
    }
}
