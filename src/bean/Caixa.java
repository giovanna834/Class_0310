package bean;

import java.sql.Date;

public class Caixa {
private int idCaixa;
private double saldoInicial;
private double saldoFinal;
private String horaInicial ;
private String horaFinal;
private Date DataPedido;

    public Caixa(double saldoInicial, double saldoFinal, String horaInicial, String horaFinal, Date DataPedido) {
        this.saldoInicial = saldoInicial;
        this.saldoFinal = saldoFinal;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.DataPedido = DataPedido;
    }
    //construtor vazio
    public Caixa() {
    }

    //getters e setters
    public int getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(int idCaixa) {
        this.idCaixa=idCaixa;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }  
    
    public double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }
    
    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }
    
    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }
    
     public Date getDataPedido() {
        return DataPedido;
    }

    public void setDataPedido(Date DataPedido) {
        this.DataPedido = DataPedido;
    }
}
