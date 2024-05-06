package modelo;

import util.DescontoMaiorDoQueJurosException;

public abstract class Financiamento {
  private double valorImovel;
  private int prazoFinanciamento;
  private double taxaJurosAnual;

  public double getValorImovel() {
    return valorImovel;
  }

  public int getPrazoFinanciamento() {
    return prazoFinanciamento;
  }

  public double getTaxaJurosAnual() {
    return taxaJurosAnual;
  }

  public Financiamento(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
    this.valorImovel = valorDesejadoImovel;
    this.prazoFinanciamento = prazoFinanciamentoAnos;
    this.taxaJurosAnual = taxaJurosAnual;
  }

  public abstract double calcularPagamentoMensal() throws DescontoMaiorDoQueJurosException;

  public double calcularTotalPagamento() {
    try {
      return calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    } catch (DescontoMaiorDoQueJurosException e) {
      System.out.println("Erro ao calcular o financiamento: " + e.getMessage());
      return 0; // Ou qualquer outro tratamento que você deseje fazer
    }
  }

  public void mostrarDadosFinanciamento() {
    System.out.println("Valor total do financiamento: " + calcularTotalPagamento());
    System.out.println("Valor do imóvel: " + getValorImovel());
  }

  public abstract int getPrazo();
}
