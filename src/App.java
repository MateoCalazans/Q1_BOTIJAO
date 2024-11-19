import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pedido> pedidos = new ArrayList<>();
        int opcao;

        do {
            System.out.println("-------------------------------------------");
            System.out.println("\nMenu:");
            System.out.println("1 - Fazer Pedido");
            System.out.println("2 - Ver Pedidos Confirmados");
            System.out.println("3 - Ver Pedidos Entregues");
            System.out.println("4 - Confirmar Entrega");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            System.out.println("-------------------------------------------");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    
                    System.out.print("Digite o endereço de entrega: ");
                    String endereco = scanner.nextLine();
                    Pedido novoPedido = new Pedido(endereco);

                    
                    System.out.println("Endereço: " + novoPedido.obterDetalhesPedido());
                    System.out.print("Deseja alterar o endereço? (s/n): ");
                    String alterarEndereco = scanner.nextLine();
                    if (alterarEndereco.equalsIgnoreCase("s")) {
                        System.out.print("Digite o novo endereço: ");
                        String novoEndereco = scanner.nextLine();
                        novoPedido.confirmarEndereco(novoEndereco);
                    }

                    
                    System.out.print("Digite a quantidade de botijões: ");
                    int quantidade = scanner.nextInt();
                    novoPedido.inserirQuantidade(quantidade);

                    
                    novoPedido.calcularHoraEntrega();

                    
                    scanner.nextLine(); 
                    System.out.print("Digite o número do cartão de crédito: ");
                    String numeroCartao = scanner.nextLine();
                    novoPedido.inserirPagamento(numeroCartao);
                    

                   
                    System.out.println("\nDetalhes do Pedido: ");
                    System.out.println(novoPedido.obterDetalhesPedido());

                    
                    pedidos.add(novoPedido);
                    break;

                case 2:
                    System.out.println("\nPedidos Confirmados:");
                    System.out.println("-------------------------------------------");
                    for (Pedido pedido : pedidos) {
                        if (pedido.getStatus().equals("Confirmado")) {
                            System.out.println(pedido.obterDetalhesPedido());
                            System.out.println("-------------------------------------------");
                        }
                    }
                    break;

                case 3:
                   
                    System.out.println("\nPedidos Entregues:");
                    for (Pedido pedido : pedidos) {
                        if (pedido.getStatus().equals("Entregue")) {
                            System.out.println(pedido.obterDetalhesPedido());
                            System.out.println("-------------------------------------------");
                        }
                    }
                    break;

                case 4:
                    
                    System.out.print("Digite o código do pedido: ");
                    int codigoPedido = scanner.nextInt();
                    boolean encontrado = false;
                    for (Pedido pedido : pedidos) {
                        if (pedido.getCodigoPedido() == codigoPedido) {
                            pedido.confirmarEntrega();
                            System.out.println("Pedido " + codigoPedido + " foi marcado como entregue.");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Pedido não localizado.");
                    }
                    break;


                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0); 

        scanner.close();
    }
}