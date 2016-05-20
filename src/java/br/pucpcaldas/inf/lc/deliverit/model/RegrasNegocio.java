package br.pucpcaldas.inf.lc.deliverit.model;

public class RegrasNegocio {
    private int codDesconto;
    private final int codTipo;
    private int codRelacionado;
    private int quantidade;
    private float preco_distancia;
    private final float porcentagemDesconto;
    
    public RegrasNegocio(int codTipo, int codRelacionado, int quantidade, float porcentagemDesconto){
        this.codTipo = codTipo;
        this.codRelacionado = codRelacionado;
        this.quantidade = quantidade;
        this.porcentagemDesconto = porcentagemDesconto;
    }
    
    public RegrasNegocio(int codTipo, int codRelacionado, float precoDistancia, float porcentagemDesconto){
        this.codTipo = codTipo;
        this.codRelacionado = codRelacionado;
        this.preco_distancia = precoDistancia;
        this.porcentagemDesconto = porcentagemDesconto;
    }
    
    public RegrasNegocio(int codTipo, float precoDistancia, float porcentagemDesconto){
        this.codTipo = codTipo;
        this.preco_distancia = precoDistancia;
        this.porcentagemDesconto = porcentagemDesconto;
    }
     
    public RegrasNegocio(int codDesconto, int codTipo, int codRelacionado, int quantidade, float precoDistancia, float porcentagemDesconto){
        this.codDesconto = codDesconto;
        this.codTipo = codTipo;
        this.codRelacionado = codRelacionado;
        this.quantidade = quantidade;
        this.preco_distancia = precoDistancia;
        this.porcentagemDesconto = porcentagemDesconto;
    }

    public int getCodDesconto() {
        return codDesconto;
    }
    
    public int getCodTipo() {
        return codTipo;
    }
    
    public int getCodRelacionado() {
        return codRelacionado;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public float getPrecoDistancia() {
        return preco_distancia;
    }
    
    public float getPorcentagem() {
        return porcentagemDesconto;
    }
}
