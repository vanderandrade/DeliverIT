package Model;

public class FluxoCaixa {
    private String descricao = "UNKNOW";
    
    private String horario;
    
    private boolean movimentacao;
    private float valor;
     
    public FluxoCaixa(String descricao, String horario, boolean movimentacao, float valor){
        this.descricao = descricao;
        this.horario = horario;
        this.movimentacao = movimentacao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public String getHorario() {
        return horario;
    }

    public boolean getMovimentacao() {
        return movimentacao;
    }
    
    public float getValor() {
        return valor;
    }
    
}
