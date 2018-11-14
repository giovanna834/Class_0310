package bean;

public class Itens_Pedido {

private int idItens;
private int idPedido ;    
private int idProduto ;
private int idAdicional;
private int quantidade;
private double valorUni; 
private double valorTotal;

    public Itens_Pedido(int idPedido, int idProduto, int idAdicional, int quantidade, double valorUni, double valorTotal) {
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.idAdicional = idAdicional;
        this.quantidade = quantidade;
        this.valorUni = valorUni;
        this.valorTotal = valorTotal;
    }

    public Itens_Pedido() {
    }
   
//getters e setters
    public int getIdItens() {
        return idItens;
    }
    public void setIdItens(int idItens) {
        this.idItens=idItens;
    }
    public int getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(int idPedido) {
        this.idPedido=idPedido;
    }
    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto=idProduto;
    }
    public int getIdAdicional() {
        return idAdicional;
    }
    public void setIdAdicional(int quantidade) {
        this.quantidade=quantidade;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade=quantidade;
    }
    public double getValorUni() {
        return valorUni;
    }
    public void setValorUni(double valorUni) {
        this.valorUni=valorUni;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal=valorTotal;
    }

    void setIdItens_Pedido(double aDouble) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
