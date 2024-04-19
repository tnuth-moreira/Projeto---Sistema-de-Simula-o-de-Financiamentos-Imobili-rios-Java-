package src.main;

import java.util.ArrayList;
import java.util.List;

import src.modelo.Financiamento;
import src.util.InterfaceUsuario;

public class Main {
  public static void main(String[] args) {

    InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
    List<Financiamento> listaDeFinanciamentos = new ArrayList<Financiamento>();

    double totalValorImoveis = 0;
    double totalValorFinanciamentos = 0;

    for (int i = 1; i <= 4; i++) {
      System.out.println("Dados do financiamento " + i + ":");
      double taxaJuros = interfaceUsuario.solicitarTaxaJuros();
      int prazoFinanciamento = interfaceUsuario.solicitarPrazoFinanciamento();
      double valorImovel = interfaceUsuario.solicitarValorImovel();

      totalValorImoveis += valorImovel;

      Financiamento novoFinanciamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJuros);
      listaDeFinanciamentos.add(novoFinanciamento);

      totalValorFinanciamentos += novoFinanciamento.calcularTotalPagamento();

      System.out.println();
    }

    for (int i = 0; i < listaDeFinanciamentos.size(); i++) {
      Financiamento financiamento = listaDeFinanciamentos.get(i);
      System.out.println("Financiamento " + (i + 1) + ":");
      System.out.println("Valor do imóvel: R$ " + financiamento.getValorImovel());
      System.out.println("Prazo de financiamento: " + financiamento.getPrazo() + " anos");
      System.out.println("Taxa de juros: " + financiamento.getTaxaJurosAnual() + "%");
      System.out.println("Pagamento mensal: R$ " + financiamento.calcularPagamentoMensal());
      System.out.println("Total de pagamentos: R$ " + financiamento.calcularTotalPagamento());
      System.out.println();
    }

    System.out.println("Total de todos os imóveis: R$ " + totalValorImoveis);
    System.out.println("Total de todos os financiamentos: R$ " + totalValorFinanciamentos);

    interfaceUsuario.fecharScanner();
  }
}
