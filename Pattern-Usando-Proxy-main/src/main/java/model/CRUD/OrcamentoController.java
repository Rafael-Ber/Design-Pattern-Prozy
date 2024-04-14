package com.example.controller;

import com.example.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orcamentos")
public class OrcamentoController {

    @Autowired
    private OrcamentoService orcamentoService;

    @GetMapping
    public ResponseEntity<List<com.example.model.Orcamento>> buscarTodos() {
        List<com.example.model.Orcamento> orcamentos = orcamentoService.buscarTodos();
        return ResponseEntity.ok(orcamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.example.model.Orcamento> buscarPorId(@PathVariable Long id) {
        Optional<com.example.model.Orcamento> orcamento = orcamentoService.buscarPorId(id);
        return orcamento.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<com.example.model.Orcamento> salvar(@RequestBody com.example.model.Orcamento orcamento) {
        com.example.model.Orcamento orcamentoSalvo = orcamentoService.salvar(orcamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(orcamentoSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        orcamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
