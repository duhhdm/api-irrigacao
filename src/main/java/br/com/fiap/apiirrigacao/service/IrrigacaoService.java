package br.com.fiap.apiirrigacao.service;

import br.com.fiap.apiirrigacao.entity.Irrigacao;
import br.com.fiap.apiirrigacao.entity.Parque;
import br.com.fiap.apiirrigacao.model.ListIrrigacaoExibicaoDTO;
import br.com.fiap.apiirrigacao.repository.IrrigacaoRepository;
import br.com.fiap.apiirrigacao.model.IrrigacaoCadastroDTO;
import br.com.fiap.apiirrigacao.model.IrrigacaoExibicaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IrrigacaoService {

    @Autowired
    private IrrigacaoRepository irrigacaoRepository;

    @Autowired
    private ParqueService parqueService;

    public IrrigacaoService(IrrigacaoRepository irrigacaoRepository) {
        this.irrigacaoRepository = irrigacaoRepository;
    }

    public IrrigacaoExibicaoDTO cadastrarIrrigador(IrrigacaoCadastroDTO irrigacaoCadastroDTO){
        Irrigacao irrigacao = new Irrigacao();
        new Parque();
        Parque parque = parqueService.buscarParque(irrigacaoCadastroDTO.idParque());
        if(parque==null)
            throw new RuntimeException("Parque não encontrado");
        irrigacao.setIdParque(parque);
        irrigacao.setDataAgendamento(irrigacaoCadastroDTO.dtIrrigamento());
        return new IrrigacaoExibicaoDTO(irrigacaoRepository.save(irrigacao));
    }
    public void deletarIrrigacao(Integer id) {
        Irrigacao irrigacao = irrigacaoRepository.findById(id).orElseThrow();
        irrigacaoRepository.delete(irrigacao);
    }

    public List<ListIrrigacaoExibicaoDTO> lista() {
        return irrigacaoRepository.
                findAll().
                stream().
                map(ListIrrigacaoExibicaoDTO::new).
                toList();
    }
}
