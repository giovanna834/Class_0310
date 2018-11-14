package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Itens_Pedido;
import Conexão.ConexaoComMySQL;

public class Itens_PedidoDAO {

private Connection conexao=null;

    public Itens_PedidoDAO() {
    conexao = ConexaoComMySQL.getConexaoMySQL();
    }
    
    //inserir
    public boolean insert(Itens_Pedido itens_pedido){ 
        String sql = "INSERT INTO itens_pedido (idPedido, idProduto, idAdicional, quantidade, valorUni, valorTotal) VALUES (?)";
        PreparedStatement statement = null;
        try{
        statement = conexao.prepareStatement(sql);
        statement.setInt(1, itens_pedido.getIdItens());
        statement.setInt(2, itens_pedido.getIdPedido());
        statement.setDouble(3, itens_pedido.getIdProduto());
        statement.setInt(4, itens_pedido.getIdAdicional());
        statement.setInt(5, itens_pedido.getQuantidade());
        statement.setDouble(6, itens_pedido.getValorUni());
        statement.setDouble(7, itens_pedido.getValorTotal());
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
    public List<Itens_Pedido> select(){ 
         String sql = "SELECT * FROM itens_pedido";
         PreparedStatement statement = null;
         ResultSet resultset = null;
         List<Itens_Pedido> itens_pedidos = new ArrayList<>();
         try{
             statement = conexao.prepareStatement(sql);
             resultset = statement.executeQuery();
             while(resultset.next()){
             Itens_Pedido itens_pedido = new Itens_Pedido();
             itens_pedido.setIdItens(resultset.getInt("idPedido, idProduto, idAdicional, quantidade, valorUni, valorTotal"));
             itens_pedidos.add(itens_pedido);
             }
         }catch(SQLException e ){
             System.out.println("erro "+e);
         }
         finally{
             ConexaoComMySQL.FecharConexao();
         }
         return itens_pedidos;
    }
    
    //UPDATE
    public boolean update (Itens_Pedido itens_pedidos){ 
        String sql = "UPDATE categoria SET itens_pedido = ? WHERE id= ?";
        PreparedStatement statement = null;
        try{
        statement = conexao.prepareStatement(sql);
        
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
    public boolean delete (Itens_Pedido itens_pedido){
        String sql = "DELETE FROM itens_pedido WHERE id = ?";
        PreparedStatement statement = null;
        try{
        statement = conexao.prepareStatement(sql);
        statement.setInt(1, itens_pedido.getIdItens());
        statement.setInt(2, itens_pedido.getIdPedido());
        statement.setDouble(3, itens_pedido.getIdProduto());
        statement.setInt(4, itens_pedido.getIdAdicional());
        statement.setInt(5, itens_pedido.getQuantidade());
        statement.setDouble(6, itens_pedido.getValorUni());
        statement.setDouble(7, itens_pedido.getValorTotal());
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