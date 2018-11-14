package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Adicional;
import Conexão.ConexaoComMySQL;

public class AdicionalDAO {
private Connection conexao=null;

    public AdicionalDAO() {
    conexao = ConexaoComMySQL.getConexaoMySQL();
    }
    
    //inserir
    public boolean insert(Adicional adicional){ 
        String sql = "INSERT INTO Adicional(descricao,valor_adicional) VALUES (?)";
        PreparedStatement statement = null;
        try{
        statement = conexao.prepareStatement(sql);
        statement.setString(1, adicional.getDescricao());
        statement.setDouble(2, adicional.getValor_adicional());
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
    public List<Adicional> select(){ 
         String sql = "SELECT * FROM Adicional";
         PreparedStatement statement = null;
         ResultSet resultset = null;
         List<Adicional> adicionais = new ArrayList<>();
         try{
             statement = conexao.prepareStatement(sql);
             resultset = statement.executeQuery();
             while(resultset.next()){
                 Adicional adicional = new Adicional();
                 adicional.setDescricao(resultset.getString("descricao"));
                 adicionais.add(adicional);
             }
         }catch(SQLException e ){
             System.out.println("erro "+e);
         }
         finally{
             ConexaoComMySQL.FecharConexao();
         }
         return adicionais;
    }
    
    //UPDATE
    public boolean update (Adicional adicional){ 
        String sql = "UPDATE Adicional SET descricao = Frutas WHERE idAdicional= 1";
        PreparedStatement statement = null;
        try{
        statement = conexao.prepareStatement(sql);
        statement.setString(1, adicional.getDescricao());
        statement.setInt(2, adicional.getIdAdicional());
        statement.setDouble(3, adicional.getValor_adicional());
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
    public boolean delete (Adicional adicional){
        String sql = "DELETE FROM Adicional WHERE id = 1";
        PreparedStatement statement = null;
        try{
        statement = conexao.prepareStatement(sql);
        statement.setInt(1, adicional.getIdAdicional());
        statement.setDouble(2, adicional.getValor_adicional());
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
