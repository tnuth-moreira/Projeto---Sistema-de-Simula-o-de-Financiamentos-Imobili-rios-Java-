// modelo/Terreno.java
package modelo;

import util.DescontoMaiorDoQueJurosException;

public class Terreno extends Financiamento {
  private String tipoZona;

  public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    this.tipoZona = tipoZona;
  }

  @Override
  public double calcularPagamentoMensal() throws DescontoMaiorDoQueJurosException {
    double valorParcela = (this.getValorImovel() / (this.getPrazo() * 12)) * (1 + (this.getTaxaJurosAnual() / 12));

    if (valorParcela * 0.02 > this.getValorImovel()) {
      throw new DescontoMaiorDoQueJurosException("O acréscimo é maior que o valor dos juros.");
    }

    return valorParcela + (valorParcela * 0.02);
  }

  public String getTipoZona() {
    return tipoZona;
  }

  public void setTipoZona(String tipoZona) {
    this.tipoZona = tipoZona;
  }

  @Override
  public int getPrazo() { 
    return super.getPrazoFinanciamento(); 
}
