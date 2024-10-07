import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o limite do cartão:");
        double limite = scanner.nextDouble();

        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        while (sair != 0) {
            System.out.println("Digite a descrição da compra:");
            String descricao = scanner.next();

            System.out.println("Digite o valor da compra:");
            double valor = scanner.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                sair = scanner.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                sair = 0;
            }
        }
        System.out.println("******************************");
        System.out.println("COMPRAS REALIZADAS: \n");
        Collections.sort(cartao.getCompras());
        for (Compra c : cartao.getCompras()) {
            System.out.println(String.format(c.getDescricao() + " - %.2f", c.getValor()));
        }
        System.out.println("\n ******************************");

        System.out.println(String.format("\n Saldo do cartão: %.2f", cartao.getSaldo()));
    }
}