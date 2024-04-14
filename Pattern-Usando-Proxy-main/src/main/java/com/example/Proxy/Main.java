import model.OrcamentoProxy;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o valor do orçamento:");
        BigDecimal valor = scanner.nextBigDecimal();

        System.out.println("Digite o desconto do orçamento:");
        BigDecimal desconto = scanner.nextBigDecimal();

        com.example.model.Orcamento orcamento = new com.example.model.Orcamento(valor, desconto);

        System.out.println("Valor do orçamento = " + orcamento.getValorOrcamento());

        OrcamentoProxy proxy = new OrcamentoProxy(orcamento);

        System.out.println("Desconto do orçamento = " + proxy.getDescontoOrcamento());

        com.example.service.OrcamentoService orcamentoService = new com.example.service.OrcamentoService(); // Criação de uma instância de OrcamentoService

        com.example.model.Orcamento orcamentoSalvo = null;
        orcamentoService.salvar(orcamento); // Chama o método salvar usando a instância criada

        orcamentoSalvo = orcamentoService.buscarPorId(orcamento.getId()).orElse(null);

        if (orcamentoSalvo != null) {
            System.out.println("Valor do orçamento salvo no banco de dados = " + orcamentoSalvo.getValorOrcamento());
        } else {
            System.out.println("Orçamento não encontrado no banco de dados");
        }

        System.out.println("Deseja atualizar o valor do orçamento? (S/N)");
        String resposta = scanner.next();

        if (resposta.equalsIgnoreCase("S")) {
            System.out.println("Digite o novo valor do orçamento:");
            BigDecimal novoValor = scanner.nextBigDecimal();
            orcamentoSalvo.setValorOrcamento(novoValor);
            orcamentoService.salvar(orcamentoSalvo);
        }

        System.out.println("Deseja excluir o orçamento? (S/N)");
        resposta = scanner.next();

        if (resposta.equalsIgnoreCase("S")) {
            orcamentoService.deletar(orcamentoSalvo.getId());
        }
    }
}
