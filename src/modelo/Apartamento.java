package modelo;

import util.DescontoMaiorDoQueJurosException;

public class Apartamento extends Financiamento {
  private int numeroVagasGaragem;
  private int numeroAndar;

  public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numeroVagasGaragem,
      int numeroAndar) {
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    this.numeroVagasGaragem = numeroVagasGaragem;
    this.numeroAndar = numeroAndar;
  }

  @Override
  public double calcularPagamentoMensal() throws DescontoMaiorDoQueJurosException {
    double taxaMensal = (this.getTaxaJurosAnual() / 12) / 100;
    double prazoMeses = this.getPrazo() * 12;
    double valorParcela = (this.getValorImovel() * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -prazoMeses));
    return valorParcela;
  }

  public int getNumeroVagasGaragem() {
    return numeroVagasGaragem;
  }

  public void setNumeroVagasGaragem(int numeroVagasGaragem) {
    this.numeroVagasGaragem = numeroVagasGaragem;
  }

  public int getNumeroAndar() {
    return numeroAndar;
  }

  public void setNumeroAndar(int numeroAndar) {
    this.numeroAndar = numeroAndar;
  }

  @Override
  public int getPrazo() {
    return super.getPrazoFinanciamento();
  }
}
