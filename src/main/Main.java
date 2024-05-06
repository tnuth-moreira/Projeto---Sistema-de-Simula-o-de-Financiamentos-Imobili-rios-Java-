package main;

import java.util.ArrayList;
import java.util.List;
import modelo.Financiamento;
import modelo.Casa;
import modelo.Apartamento;
import modelo.Terreno;
import util.InterfaceUsuario;
import util.DescontoMaiorDoQueJurosException; // Importe a exceção aqui

public class Main {
  public static void main(String[] args) throws DescontoMaiorDoQueJurosException { // Declare o lançamento da exceção
    InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
    List<Financiamento> listaDeFinanciamentos = new ArrayList<>();

    for (int i = 1; i <= 4; i++) {
      System.out.println("Financiamento " + i);
      double taxaJuros = interfaceUsuario.solicitarTaxaJuros();
      int prazoFinanciamento = interfaceUsuario.solicitarPrazoFinanciamento();
      double valorImovel = interfaceUsuario.solicitarValorImovel();
      String tipoImovel = interfaceUsuario.solicitarTipoImovel();

      Financiamento financiamento;

      switch (tipoImovel) {
        case "Casa":
          double areaConstruida = interfaceUsuario.solicitarAreaConstruida();
          double tamanhoTerreno = interfaceUsuario.solicitarTamanhoTerreno();
          financiamento = new Casa(valorImovel, prazoFinanciamento, taxaJuros, areaConstruida, tamanhoTerreno);
          break;
        case "Apartamento":
          int numeroVagasGaragem = interfaceUsuario.solicitarNumeroVagasGaragem();
          int numeroAndar = interfaceUsuario.solicitarNumeroAndar();
          financiamento = new Apartamento(valorImovel, prazoFinanciamento, taxaJuros, numeroVagasGaragem, numeroAndar);
          break;
        case "Terreno":
          String tipoZona = interfaceUsuario.solicitarTipoZona();
          financiamento = new Terreno(valorImovel, prazoFinanciamento, taxaJuros, tipoZona);
          break;
        default:
          System.out.println("Tipo de imóvel inválido.");
          return;
      }

      listaDeFinanciamentos.add(financiamento);
    }

    double totalImoveis = 0;
    double totalFinanciamentos = 0;

    System.out.println("\nLista de Financiamentos:");
    for (int i = 0; i < listaDeFinanciamentos.size(); i++) {
      Financiamento financiamento = listaDeFinanciamentos.get(i);
      double totalFinanciamento = financiamento.calcularTotalPagamento(); // A exceção é lançada aqui
      totalImoveis += financiamento.getValorImovel();
      totalFinanciamentos += totalFinanciamento;

      System.out.println("Financiamento " + (i + 1) + " – valor do imóvel: R$ " + financiamento.getValorImovel()
          + ", valor do financiamento: R$ " + totalFinanciamento + ".");
    }

    System.out.println("\nTotal de todos os imóveis: R$ " + totalImoveis);
    System.out.println("Total de todos os financiamentos: R$ " + totalFinanciamentos);

    interfaceUsuario.fecharScanner();
  }
}
