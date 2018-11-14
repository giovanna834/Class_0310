
package funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PedidoDAO {
    private Connection conexao=null;

    public PedidoDAO() {
    conexao = ConexaoComMySQL.getConexaoMySQL();
    }
    
    //inserir
    public boolean insert(Pedido pedido){ 
        String sql = "INSERT INTO pedido (Valor_total,status) VALUES (?)";
        PreparedStatement statement = null;
        try{
        statement = conexao.prepareStatement(sql);
        statement.setDouble(1, pedido.getValor_total());
        statement.setString(2, pedido.getstatus());
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
    public List<Pedido> select(){ 
         String sql = "SELECT * FROM pedido";
         PreparedStatement statement = null;
         ResultSet resultset = null;
         List<Pedido> pedidos = new ArrayList<>();
         try{
             statement = conexao.prepareStatement(sql);
             resultset = statement.executeQuery();
             while(resultset.next()){
                 Pedido pedido = new Pedido();
                 pedido.setStatus(resultset.getString("status"));
                 pedido.setValor_total(resultset.getDouble("Valor_total"));
                 pedidos.add(pedido);
             }
         }catch(SQLException e ){
             System.out.println("erro "+e);
         }
         finally{
             ConexaoComMySQL.FecharConexao();
         }
         return pedidos;
    }
    
    //UPDATE
    public boolean update (Pedido pedido){ 
        String sql = "UPDATE pedido SET status = ? WHERE id= ?";
        PreparedStatement statement = null;
        try{
        statement = conexao.prepareStatement(sql);
         statement.setInt(1, pedido.getIdPedido());
         statement.setDouble(2, pedido.getValor_total());
        statement.setString(3, pedido.getstatus());
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
    public boolean delete (Pedido pedido){
        String sql = "DELETE FROM pedido WHERE id = ?";
        PreparedStatement statement = null;
        try{
        statement = conexao.prepareStatement(sql);
        statement.setInt(1, pedido.getIdPedido());
         statement.setDouble(2, pedido.getValor_total());
        statement.setString(3, pedido.getstatus());
        
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
