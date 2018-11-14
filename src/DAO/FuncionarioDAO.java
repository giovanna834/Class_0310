package DAO;
import bean.Caixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Funcionario;
import Conexão.ConexaoComMySQL;

public class FuncionarioDAO {
private Connection conexao=null;

    public FuncionarioDAO() {
    conexao = ConexaoComMySQL.getConexaoMySQL();
    }
    
    //inserir
    public boolean insert(Funcionario funcionario){ 
        String sql = "INSERT INTO funcionario (nome, RG, CPF, Telefone) VALUES (?)";
        PreparedStatement statement = null;
        try{
        statement = conexao.prepareStatement(sql);
        statement.setInt(1, funcionario.getIdFuncio());
        statement.setString(2, funcionario.getNome());
        statement.setDouble(3, funcionario.getRG());
        statement.setInt(4, funcionario.getCPF());
        statement.setInt(5, funcionario.getTelefone());
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
    public List<Funcionario> select(){ 
         String sql = "SELECT * FROM funcionario";
         PreparedStatement statement = null;
         ResultSet resultset = null;
         List<Funcionario> funcionarios = new ArrayList<>();
         try{
             statement = conexao.prepareStatement(sql);
             resultset = statement.executeQuery();
             while(resultset.next()){
             Funcionario funcionario = new Funcionario();
             funcionario.setIdFuncio(resultset.getInt("Nome, RG, CPF, Telefone"));
             funcionarios.add(funcionario);
             }
         }catch(SQLException e ){
             System.out.println("erro "+e);
         }
         finally{
             ConexaoComMySQL.FecharConexao();
         }
         return funcionarios;
    }
    
    //UPDATE
    public boolean update (Caixa caixa){ 
        String sql = "UPDATE categoria SET funcionario = ? WHERE id= ?";
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
    public boolean delete (Funcionario funcionario){
        String sql = "DELETE FROM funcionario WHERE id = ?";
        PreparedStatement statement = null;
        try{
        statement = conexao.prepareStatement(sql);
        statement.setInt(1, funcionario.getIdFuncio());
        statement.setString(2, funcionario.getNome());
        statement.setDouble(3, funcionario.getRG());
        statement.setInt(4, funcionario.getCPF());
        statement.setInt(5, funcionario.getTelefone());
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
