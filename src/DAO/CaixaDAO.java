package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Caixa;
import Conexão.ConexaoComMySQL;

public class CaixaDAO {

private Connection conexao=null;

    public CaixaDAO() {
    conexao = ConexaoComMySQL.getConexaoMySQL();
    }
    
    //inserir
    public boolean insert(Caixa caixa){ 
        String sql = "INSERT INTO caixa (saldoInicial, saldoFinal, horaInicial, horaFinal, DataPedido) VALUES (?)";
        PreparedStatement statement = null;
        try{
        statement = conexao.prepareStatement(sql);
        statement.setInt(1, caixa.getIdCaixa());
        statement.setDouble(2, caixa.getSaldoInicial());
        statement.setDouble(3, caixa.getSaldoFinal());
        statement.setString(4, caixa.getHoraInicial());
        statement.setDate(5, caixa.getDataPedido());
        statement.executeUpdate();
        return true;
    }catch (SQLException e){
            System.out.println("erro: "+e);
            return false;
    }finally{
            //fechar conexao
            ConexaoComMySQL.FecharConexao();
        }
    }
    
    //SELECT
    public List<Caixa> select(){ 
         String sql = "SELECT * FROM caixa";
         PreparedStatement statement = null;
         ResultSet resultset = null;
         List<Caixa> caixas = new ArrayList<>();
         try{
             statement = conexao.prepareStatement(sql);
             resultset = statement.executeQuery();
             while(resultset.next()){
             Caixa caixa = new Caixa();
             caixa.setIdCaixa(resultset.getInt("SaldoInicial,SaldoFinal,horaInicial, horaFinal, DataPedido"));
             caixas.add(caixa);
             }
         }catch(SQLException e ){
             System.out.println("erro "+e);
         }
         finally{
             ConexaoComMySQL.FecharConexao();
         }
         return caixas;
    }
    
    //UPDATE
    public boolean update (Caixa caixa){ 
        String sql = "UPDATE categoria SET caixa = ? WHERE id= ?";
        PreparedStatement statement = null;
        try{
        statement = conexao.prepareStatement(sql);
        statement.setInt(1, caixa.getIdCaixa());
        statement.setDouble(2, caixa.getSaldoInicial());
        statement.setDouble(3, caixa.getSaldoFinal());
        statement.setString(4, caixa.getHoraInicial());
        statement.setDate(5, caixa.getDataPedido()); 
        statement.executeUpdate();
        return true;
    }catch (SQLException e){
            System.out.println("erro: "+e);
            return false;
    }finally{
            //fechar conexao
            ConexaoComMySQL.FecharConexao();
        }
    }
    
    //DELETE
    public boolean delete (Caixa caixa){
        String sql = "DELETE FROM caixa WHERE id = ?";
        PreparedStatement statement = null;
        try{
        statement = conexao.prepareStatement(sql);
        statement.setInt(1, caixa.getIdCaixa());
        statement.setDouble(2, caixa.getSaldoInicial());
        statement.setDouble(3, caixa.getSaldoFinal());
        statement.setString(4, caixa.getHoraInicial());
        statement.setDate(5, caixa.getDataPedido());
        statement.executeUpdate();
        return true;
    }catch (SQLException e){
            System.out.println("erro: "+e);
            return false;
    }finally{
            //fechar conexao
            ConexaoComMySQL.FecharConexao();
        }
    }
}
