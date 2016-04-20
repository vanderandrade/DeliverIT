package Model;

public class Pedido {
    private int codPedido;
    private float valorTotal;
    private float valorEntrega;
    private float valorDesconto;
    private int codCliente;
    private int codEstabelecimento;
    private String dataPedido;
    private String statusPedido;
    
    public Pedido(int codPedido, float valorTotal, float valorEntrega, float valorDesconto,
            int codCliente, int codEstabelecimento, String dataPedido, String statusPedido)
    {
        this.codPedido = codPedido;
        this.valorTotal = valorTotal;
        this.valorEntrega = valorEntrega;
        this.valorDesconto = valorDesconto;
        this.codCliente = codCliente;
        this.codEstabelecimento = codEstabelecimento;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;                
    }

    public int getCodPedido() {
        return codPedido;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public float getValorEntrega() {
        return valorEntrega;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public int getCodEstabelecimento() {
        return codEstabelecimento;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }
    
    
    
}
