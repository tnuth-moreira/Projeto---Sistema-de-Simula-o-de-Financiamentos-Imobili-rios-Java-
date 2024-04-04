import java.util.Scanner;

class Financiamento {

  double valorImovel;
  int prazoFinanciamento;
  double taxaJurosAnual;

  Financiamento(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
    this.valorImovel = valorDesejadoImovel;
    this.prazoFinanciamento = prazoFinanciamentoAnos;
    this.taxaJurosAnual = taxaJurosAnual;
  }

  double calcularPagamentoMensal() {
    return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));
  }

  double calcularTotalPagamento() {
    return calcularPagamentoMensal() * this.prazoFinanciamento * 12;
  }
}

class InterfaceUsuario {
  private Scanner scanner;

  InterfaceUsuario() {
    this.scanner = new Scanner(System.in);
  }

  double solicitarValorImovel() {
    System.out.println("Digite o valor do imovel: ");
    return scanner.nextDouble();
  }

  int solicitarPrazoFinanciamento() {
    System.out.println("Digite o prazo do financimanto em anos: ");
    return scanner.nextInt();
  }

  double solicitarTaxaJuros() {
    System.out.println("Digite a taxa de juros anul (em %): ");
    return scanner.nextDouble();
  }

  void fecharScanner() {
    scanner.close();
  }
}

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