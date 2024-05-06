package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Financiamento;
import modelo.Casa;
import modelo.Apartamento;
import modelo.Terreno;
import util.InterfaceUsuario;
import util.DescontoMaiorDoQueJurosException;

public class Main {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
    List<Financiamento> listaDeFinanciamentos = new ArrayList<>();

    for (int i = 1; i <= 4; i++) {
      System.out.println("Financiamento " + i);
      double taxaJuros = interfaceUsuario.solicitarTaxaJuros();
      int prazoFinanciamento = interfaceUsuario.solicitarPrazoFinanciamento();
      double valorImovel = interfaceUsuario.solicitarValorImovel();
      String tipoImovel;

      do {
        tipoImovel = interfaceUsuario.solicitarTipoImovel();
        Financiamento financiamento;

        switch (tipoImovel.toLowerCase()) { // Convertendo para minúsculas para evitar problemas com
                                            // maiúsculas/minúsculas
          case "casa":
            double areaConstruida = interfaceUsuario.solicitarAreaConstruida();
            double tamanhoTerreno = interfaceUsuario.solicitarTamanhoTerreno();
            financiamento = new Casa(valorImovel, prazoFinanciamento, taxaJuros, areaConstruida, tamanhoTerreno);
            listaDeFinanciamentos.add(financiamento); // Adicionando o financiamento aqui para evitar repetição de
                                                      // código
            break;
          case "apartamento":
            int numeroVagasGaragem = interfaceUsuario.solicitarNumeroVagasGaragem();
            int numeroAndar = interfaceUsuario.solicitarNumeroAndar();
            financiamento = new Apartamento(valorImovel, prazoFinanciamento, taxaJuros, numeroVagasGaragem,
                numeroAndar);
            listaDeFinanciamentos.add(financiamento);

            break;
          case "terreno":
            String tipoZona = interfaceUsuario.solicitarTipoZona();
            financiamento = new Terreno(valorImovel, prazoFinanciamento, taxaJuros, tipoZona);
            listaDeFinanciamentos.add(financiamento);

            break;
          default:
            System.out.println("Tipo de imóvel inválido. Tente novamente.");
            break;
        }
      } while (!tipoImovel.equalsIgnoreCase("casa") && !tipoImovel.equalsIgnoreCase("apartamento")
          && !tipoImovel.equalsIgnoreCase("terreno"));
    }

    salvarFinanciamentosEmArquivoTexto(listaDeFinanciamentos);

    salvarFinanciamentosSerializados(listaDeFinanciamentos);

    double totalImoveis = 0;
    double totalFinanciamentos = 0;

    System.out.println("\nLista de Financiamentos:");
    for (int i = 0; i < listaDeFinanciamentos.size(); i++) {
      Financiamento financiamento = listaDeFinanciamentos.get(i);
      double totalFinanciamento = financiamento.calcularTotalPagamento();
      totalImoveis += financiamento.getValorImovel();
      totalFinanciamentos += totalFinanciamento;

      System.out.println("Financiamento " + (i + 1) + " – valor do imóvel: R$ " + financiamento.getValorImovel()
          + ", valor do financiamento: R$ " + totalFinanciamento + ".");
    }

    System.out.println("\nTotal de todos os imóveis: R$ " + totalImoveis);
    System.out.println("Total de todos os financiamentos: R$ " + totalFinanciamentos);

    interfaceUsuario.fecharScanner();
  }

  private static void salvarFinanciamentosEmArquivoTexto(List<Financiamento> listaDeFinanciamentos) throws IOException {
    try (PrintWriter writer = new PrintWriter("financiamentos.txt")) {
      for (Financiamento financiamento : listaDeFinanciamentos) {
        writer.println("Valor do imóvel: " + financiamento.getValorImovel());
        writer.println("Valor do financiamento: " + financiamento.calcularTotalPagamento());
        writer.println("Taxa de juros: " + financiamento.getTaxaJurosAnual());
        writer.println("Prazo de financiamento: " + financiamento.getPrazo());
        writer.println(financiamento.getDetalhesEspecificos());
        writer.println();
      }
    }
  }

  private static void salvarFinanciamentosSerializados(List<Financiamento> listaDeFinanciamentos) throws IOException {
    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("financiamentos.ser"))) {
      outputStream.writeObject(listaDeFinanciamentos);
    }
  }
}
