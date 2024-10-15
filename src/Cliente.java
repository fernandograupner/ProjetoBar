import java.util.Scanner;

public class Cliente {

    double precoIngressoHomem = 10.0;
    double precoIngressoMulher = 8.0;
    double precoCerveja = 5.0;
    double precoRefrigerante = 3.0;
    double precoEspetinho = 7.0;
    double precoCouvert = 4.0;
    double consumoLimite = 30.0;

    // Atributos da classe
    private String nome;
    private String sexo;
    private int qtdCervejas;
    private int qtdRefrigerantes;
    private int qtdEspetinhos;

    // Método para ler os dados do cliente
    public void lerDados() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do cliente: ");
        nome = scanner.next();

        System.out.print("Sexo (F ou M): ");
        sexo = scanner.next();

        System.out.print("Quantidade de cervejas: ");
        qtdCervejas = scanner.nextInt();

        System.out.print("Quantidade de refrigerantes: ");
        qtdRefrigerantes = scanner.nextInt();

        System.out.print("Quantidade de espetinhos: ");
        qtdEspetinhos = scanner.nextInt();
    }

    public double calcularConsumo() {
        return (qtdCervejas * precoCerveja) + (qtdRefrigerantes * precoRefrigerante) + (qtdEspetinhos * precoEspetinho);
    }

    public double calcularIngresso() {
        if (sexo == "M" || sexo == "m") {
            return precoIngressoHomem;
        } else {
            return precoIngressoMulher;
        }
    }


    public double calcularCouvert(double consumo) {
        if (consumo > consumoLimite) {
            return 0.0;
        } else {
            return precoCouvert;
        }
    }

    public double calcularValorTotal(double consumo, double ingresso, double couvert) {
        return consumo + ingresso + couvert;
    }

    // Método para mostrar o relatório
    public void mostrarRelatorio() {
        double consumo = calcularConsumo();
        double ingresso = calcularIngresso();
        double couvert = calcularCouvert(consumo);
        double valorTotal = calcularValorTotal(consumo, ingresso, couvert);

        System.out.println("RELATÓRIO:");
        System.out.printf("Consumo = R$ %.2f\n", consumo);
        System.out.printf("Couvert = R$ %.2f\n", couvert);
        System.out.printf("Ingresso = R$ %.2f\n", ingresso);
        System.out.printf("Valor a pagar = R$ %.2f\n", valorTotal);
    }

}
