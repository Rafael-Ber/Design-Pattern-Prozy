package com.example.service;

import com.example.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    public List<com.example.model.Orcamento> buscarTodos() {
        return orcamentoRepository.findAll();
    }

    public Optional<com.example.model.Orcamento> buscarPorId(Long id) {
        return orcamentoRepository.findById(id);
    }
    public com.example.model.Orcamento salvar(com.example.model.Orcamento orcamento) {
        return orcamentoRepository.save(orcamento);
    }
    public void deletar(Long id) {
        orcamentoRepository.deleteById(id);
    }
}
