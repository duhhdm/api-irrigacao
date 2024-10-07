package br.com.fiap.apiirrigacao.service;

import br.com.fiap.apiirrigacao.entity.Parque;
import br.com.fiap.apiirrigacao.model.ParqueCadastroDTO;
import br.com.fiap.apiirrigacao.model.ParqueExibicaoDTO;
import br.com.fiap.apiirrigacao.repository.ParqueRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParqueService {
    @Autowired
    ParqueRepository parqueRepository;

    public ParqueExibicaoDTO cadastraParque(ParqueCadastroDTO parqueCadastroDTO){
        Parque parque = new Parque();
        BeanUtils.copyProperties(parqueCadastroDTO,parque);
        return new ParqueExibicaoDTO(parqueRepository.save(parque));
    }

    public List<ParqueExibicaoDTO> listarTodos(){
        return parqueRepository.
                findAll().
                stream().
                map(ParqueExibicaoDTO::new).
                toList();
    }

    public Parque buscarParque(Integer id){
        return parqueRepository.findById(id).orElseThrow();
    }
}
