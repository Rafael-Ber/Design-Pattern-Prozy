package dao;

import orcamentodao.Orcamento;

import java.util.HashMap;
import java.util.Map;

public class OrcamentoDAO {
    private Map<Long, Orcamento> orcamentos = new HashMap<>();
    private long nextId = 1;

    public Orcamento salvarOrcamento(Orcamento orcamento) {
        long id = nextId++;
        orcamento.setId(id);
        orcamentos.put(id, orcamento);
        return orcamento;
    }

    public Orcamento buscarOrcamento(long id) {
        return orcamentos.get(id);
    }

    public Orcamento atualizarOrcamento(long id, Orcamento orcamentoAtualizado) {
        if (!orcamentos.containsKey(id)) {
            throw new IllegalArgumentException("Orcamento não encontrado");
        }
        orcamentoAtualizado.setId(id);
        orcamentos.put(id, orcamentoAtualizado);
        return orcamentoAtualizado;
    }

    public void deletarOrcamento(long id) {
        orcamentos.remove(id);
    }
}
