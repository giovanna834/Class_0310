package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Produto;
import Conexão.ConexaoComMySQL;

public class ProdutoDAO {

private Connection conexao=null;

    public ProdutoDAO() {
    conexao = ConexaoComMySQL.getConexaoMySQL();
    }
    
    //inserir
    public boolean insert(Produto produto){ 
        String sql = "INSERT INTO produto (nomeProduto, valor, qtdDisponivel) VALUES (?)";
        PreparedStatement statement = null;
        try{
        statement = conexao.prepareStatement(sql);
        statement.setInt(1, produto.getIdProduto());
        statement.setString(2, produto.getNomeProduto());
        statement.setDouble(3, produto.getValor());
        statement.setInt(4, produto.getQtdDisponivel());
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
    public List<Produto> select(){ 
         String sql = "SELECT * FROM produto";
         PreparedStatement statement = null;
         ResultSet resultset = null;
         List<Produto> produtos = new ArrayList<>();
         try{
             statement = conexao.prepareStatement(sql);
             resultset = statement.executeQuery();
             while(resultset.next()){
             Produto produto = new Produto();
             produto.setIdProduto(resultset.getInt("nomeProduto, valor, qtdDisponivel"));
             produtos.add(produto);
             }
         }catch(SQLException e ){
             System.out.println("erro "+e);
         }
         finally{
             ConexaoComMySQL.FecharConexao();
         }
         return produtos;
    }
    
    //UPDATE
    public boolean update (Produto produto){ 
        String sql = "UPDATE categoria SET produto = ? WHERE id= ?";
        PreparedStatement statement = null;
        try{
        statement = conexao.prepareStatement(sql);
        statement.setInt(1, produto.getIdProduto());
        statement.setString(2, produto.getNomeProduto());
        statement.setDouble(3, produto.getValor());
        statement.setDouble(4, produto.getQtdDisponivel());
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
    public boolean delete (Produto produto){
        String sql = "DELETE FROM produto WHERE id = ?";
        PreparedStatement statement = null;
        try{
        statement = conexao.prepareStatement(sql);
        statement.setInt(1, produto.getIdProduto());
        statement.setString(2, produto.getNomeProduto());
        statement.setDouble(3, produto.getValor());
        statement.setDouble(3, produto.getQtdDisponivel());
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