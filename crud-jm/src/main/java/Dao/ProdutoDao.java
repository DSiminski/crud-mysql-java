package Dao;

import ConnectionFactory.Factory;
import Model.Produto;
import View.ProdutoView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class ProdutoDao {
    private Connection connection;

    public ProdutoDao() {
        this.connection = new Factory().getConnection();
    }
    public void criaTabela(){

        String sql = "CREATE TABLE IF NOT EXISTS produtos (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "nome VARCHAR(50) NOT NULL," +
                "valor DECIMAL(10,2) );";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Produto criada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void cadastraProduto(Produto p) {
        String sql = "INSERT INTO produtos " +
                "(nome, valor) " +
                "VALUES (?,?)";
        try {
            PreparedStatement start = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            start.setString(1, p.getNome());
            start.setDouble(2, p.getValor());

            start.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Produto>visualiza() {
        String sql = "SELECT * FROM produtos";

        try {
            PreparedStatement start = connection.prepareStatement(sql);
            ResultSet resultSet = start.executeQuery();
            List<Produto> produtos = new ArrayList<Produto>();
            while (resultSet.next()){
                Produto recebe = new Produto();
                recebe.setID(resultSet.getInt("id"));
                recebe.setNome(resultSet.getString("nome"));
                recebe.setValor(resultSet.getDouble("valor"));
                produtos.add(recebe);
            }
            return produtos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Produto selectId(int id){
        String sql = "SELECT * FROM produtos WHERE id = ?";

        try {
            PreparedStatement start = connection.prepareStatement(sql);
            start.setInt(1,id);
            ResultSet resultSet = start.executeQuery();

            while (resultSet.next()){
                Produto recebe = new Produto();
                recebe.setID(resultSet.getInt("id"));
                recebe.setNome(resultSet.getString("nome"));
                recebe.setValor(resultSet.getDouble("valor"));
                return recebe;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public void editaProduto(Produto produto){
        String sql = "UPDATE produtos SET nome = ?, valor = ? WHERE id = ?";
                try{
                    PreparedStatement start = connection.prepareStatement(sql);
                    start.setString(1, produto.getNome());
                    start.setDouble(2, produto.getValor());
                    start.setInt(3, produto.getID());
                    start.execute();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
    }
}
