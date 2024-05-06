package modelo;

import util.DescontoMaiorDoQueJurosException;

public class Casa extends Financiamento {
  private double seguroObrigatorio;
  private double areaConstruida;
  private double tamanhoTerreno;

  public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida,
      double tamanhoTerreno) {
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    this.areaConstruida = areaConstruida;
    this.tamanhoTerreno = tamanhoTerreno;
    this.seguroObrigatorio = 80.0;
  }

  @Override
  public double calcularPagamentoMensal() throws DescontoMaiorDoQueJurosException {
    double valorParcela = (this.getValorImovel() / (this.getPrazo() * 12)) * (1 + (this.getTaxaJurosAnual() / 12));

    if (this.seguroObrigatorio > valorParcela) {
      throw new DescontoMaiorDoQueJurosException("O valor do seguro é maior que o valor dos juros.");
    }

    return valorParcela + this.seguroObrigatorio;
  }

  public double getSeguroObrigatorio() {
    return seguroObrigatorio;
  }

  public void setSeguroObrigatorio(double seguroObrigatorio) {
    this.seguroObrigatorio = seguroObrigatorio;
  }

  public double getAreaConstruida() {
    return areaConstruida;
  }

  public void setAreaConstruida(double areaConstruida) {
    this.areaConstruida = areaConstruida;
  }

  public double getTamanhoTerreno() {
    return tamanhoTerreno;
  }

  public void setTamanhoTerreno(double tamanhoTerreno) {
    this.tamanhoTerreno = tamanhoTerreno;
  }

  @Override
  public int getPrazo() {
    return super.getPrazoFinanciamento();
  }
}
