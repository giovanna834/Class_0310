package bean;

public class Produto {
private int idProduto; 
private String nomeProduto;
private double valor;  
private int qtdDisponivel;

public Produto(String nomeProduto, double valor, int qtdDisponivel) {
        this.nomeProduto = nomeProduto;
        this.valor = valor;
        this.qtdDisponivel = qtdDisponivel;
    }

public Produto() {
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto= idProduto;
    }
    
     public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }  
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor= valor;
    }
    
    public int getQtdDisponivel() {
        return qtdDisponivel;
    }

    public void setQtdDisponivel(int qtdDisponivel) {
        this.qtdDisponivel= qtdDisponivel;
    }
}


