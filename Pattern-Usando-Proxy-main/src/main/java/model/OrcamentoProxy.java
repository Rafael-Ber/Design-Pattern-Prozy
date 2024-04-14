package model;

import java.math.BigDecimal;

public class OrcamentoProxy extends com.example.model.Orcamento {
    private BigDecimal descontoOrcamento;
    private com.example.model.Orcamento orcamento;

    public OrcamentoProxy(com.example.model.Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    @Override
    public BigDecimal getDescontoOrcamento() {
       if(descontoOrcamento == null){
           this.descontoOrcamento = orcamento.getDescontoOrcamento();
       }
        return descontoOrcamento;
    }

    @Override
    public void setDescontoOrcamento(BigDecimal descontoOrcamento) {
        this.descontoOrcamento = descontoOrcamento;
    }
}
