package util;

import java.util.Scanner;

public class InterfaceUsuario {
  private Scanner scanner;
  private double TAXA_JUROS_MAX = 100.00;
  private int PRAZO_FINANCIAMENTO_MAX = 50;

  public InterfaceUsuario() {
    this.scanner = new Scanner(System.in);
  }

  public double solicitarValorImovel() {
    double valorImovel;
    do {
      System.out.println("Digite o valor do imóvel: ");
      valorImovel = scanner.nextDouble();

      if (valorImovel < 0) {
        System.out.println("Digite um valor válido (positivo).");
      }
    } while (valorImovel < 0);
    return valorImovel;
  }

  public int solicitarPrazoFinanciamento() {
    int prazoFinanciamento;
    do {
      System.out.println("Digite o prazo do financiamento em anos: ");
      prazoFinanciamento = scanner.nextInt();

      if (prazoFinanciamento <= 0 || prazoFinanciamento > PRAZO_FINANCIAMENTO_MAX) {
        System.out.println("Digite um prazo do financiamento válido (entre 1 e " + PRAZO_FINANCIAMENTO_MAX + " anos).");
      }
    } while (prazoFinanciamento <= 0 || prazoFinanciamento > PRAZO_FINANCIAMENTO_MAX);
    return prazoFinanciamento;
  }

  public double solicitarTaxaJuros() {
    double taxaJuros;
    do {
      System.out.println("Digite a taxa de juros anual (em %): ");
      taxaJuros = scanner.nextDouble();

      if (taxaJuros >= 0 && taxaJuros > TAXA_JUROS_MAX) {
        System.out.println("Digite uma taxa de juros válida (entre 0 e " + TAXA_JUROS_MAX + " %).");
      }
    } while (taxaJuros <= 0 || taxaJuros > TAXA_JUROS_MAX);
    return taxaJuros;
  }

  public String solicitarTipoImovel() {
    System.out.println("Digite o tipo de imóvel (Casa, Apartamento ou Terreno): ");
    return scanner.next();
  }

  public double solicitarAreaConstruida() {
    System.out.println("Digite a área construída: ");
    return scanner.nextDouble();
  }

  public double solicitarTamanhoTerreno() {
    System.out.println("Digite o tamanho do terreno: ");
    return scanner.nextDouble();
  }

  public int solicitarNumeroVagasGaragem() {
    System.out.println("Digite o número de vagas na garagem: ");
    return scanner.nextInt();
  }

  public int solicitarNumeroAndar() {
    System.out.println("Digite o número do andar: ");
    return scanner.nextInt();
  }

  public String solicitarTipoZona() {
    System.out.println("Digite o tipo de zona (rural, urbana, industrial, etc.): ");
    return scanner.next();
  }

  public void fecharScanner() {
    scanner.close();
  }
}
