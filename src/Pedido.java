import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pedido {
    private static int contadorPedidos = 1;
    private int codigoPedido;
    private String enderecoEntrega;
    private int quantidade;
    private double valorTotal;
    private String numeroCartao;
    private String status;
    private LocalDateTime horaCompra;
    private LocalDateTime horaEntrega;
    private static final double PRECO_BOTIJAO = 100.0;

    public Pedido(String enderecoEntrega) {
        this.codigoPedido = contadorPedidos++;
        this.enderecoEntrega = enderecoEntrega;
        this.status = "Pendente";
        this.horaCompra = LocalDateTime.now();
    }

    public void confirmarEndereco(String novoEndereco) {
        this.enderecoEntrega = novoEndereco;
    }

    public void inserirQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.valorTotal = quantidade * PRECO_BOTIJAO;
    }

    public void calcularHoraEntrega() {
        this.horaEntrega = this.horaCompra.plusHours(6);
    }

    public void inserirPagamento(String numeroCartao) {
        this.numeroCartao = numeroCartao;
        this.status = "Confirmado";
    }

    public void confirmarEntrega() {
        this.status = "Entregue";
    }

    public String obterDetalhesPedido() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        String detalhes = "Código: " + codigoPedido +
                          "\nEndereço: " + enderecoEntrega +
                          "\nQuantidade: " + quantidade +
                          "\nValor Total: R$ " + valorTotal +
                          "\nStatus: " + status +
                          "\nHora da Compra: " + horaCompra.format(formatter);

        if (horaEntrega != null) {
            detalhes += "\nHora de Entrega: " + horaEntrega.format(formatter);
        } else {
            detalhes += "\nHora de Entrega: Não definida";
        }

        return detalhes;
    }

    public String getStatus() {
        return status;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }
}