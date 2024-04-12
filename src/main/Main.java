package src.main;

import src.modelo.Financiamento;
import src.util.InterfaceUsuario;

public class Main {
  public static void main(String[] args) {

    InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

    double taxaJuros = interfaceUsuario.solicitarTaxaJuros();
    int prazoFinanciamento = interfaceUsuario.solicitarPrazoFinanciamento();
    double valorImovel = interfaceUsuario.solicitarValorImovel();

    Financiamento novoFinanciamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJuros);

    System.out.println("Pagamento mensal: " + novoFinanciamento.calcularPagamentoMensal());
    System.out.println("Total de pagamentos: " + novoFinanciamento.calcularTotalPagamento());

    interfaceUsuario.fecharScanner();

  }
}
