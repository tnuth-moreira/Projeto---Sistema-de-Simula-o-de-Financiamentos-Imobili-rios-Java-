package src.modelo;

public class Financiamento {

  private double valorImovel;
  private int prazoFinanciamento;
  private double taxaJurosAnual;

  public double getValorImovel() {
    return this.valorImovel;
  }

  public int getPrazoFinanciamento() {
    return this.prazoFinanciamento;
  }

  public double getTaxaJurosAnual() {
    return this.taxaJurosAnual;
  }

  public Financiamento(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
    this.valorImovel = valorDesejadoImovel;
    this.prazoFinanciamento = prazoFinanciamentoAnos;
    this.taxaJurosAnual = taxaJurosAnual;
  }

  public double calcularPagamentoMensal() {
    return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));
  }

  public double calcularTotalPagamento() {
    return calcularPagamentoMensal() * this.prazoFinanciamento * 12;
  }

  public void mostrarDadosFinanciamento() {
    System.out.println("Valor total do financiamento: " + calcularTotalPagamento());
    System.out.println("Valor do imóvel: " + getValorImovel());

  }
}
