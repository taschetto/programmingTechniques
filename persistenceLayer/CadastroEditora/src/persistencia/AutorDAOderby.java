/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import negocio.Autor;
import negocio.AutorDAO;
import negocio.DAOAutorException;

/**
 *
 * @author julio
 */
public class AutorDAOderby implements AutorDAO {

    @Override
    public List<Autor> buscarTodos() throws DAOAutorException {
        List<Autor> autores = new ArrayList<>();
        Connection conexao = null;
        Statement comando = null;
        String sql = "select * from autores";
        ResultSet resultado = null;
        try {
            conexao = InicializadorBancoDados.conectarBd();
            comando = conexao.createStatement();
            resultado = comando.executeQuery(sql);
            while (resultado.next()) {
                Autor autor = new Autor(
                        resultado.getInt("codigo"),
                        resultado.getString("primeironome"),
                        resultado.getString("ultimonome"));
                autores.add(autor);
            }
            comando.close();
            conexao.close();
            return autores;
        } catch (Exception e) {
            throw new DAOAutorException("Falha na busca", e);
        }
    }

    @Override
    public Autor buscarPorCodigo(int codigo) throws DAOAutorException {
        Connection conexao = null;
        PreparedStatement comando = null;
        String sql = "select * from autores where codigo = ?";
        ResultSet resultado = null;
        Autor autor = null;
        try {
            conexao = InicializadorBancoDados.conectarBd();
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, codigo);
            resultado = comando.executeQuery();
            if(resultado.next()) {
              autor = new Autor(
                      resultado.getInt("codigo"),
                      resultado.getString("primeironome"),
                      resultado.getString("ultimonome")
              );
            }
            comando.close();
            conexao.close();
            return autor;
        } catch (Exception e) {
            throw new DAOAutorException("Falha na busca", e);
        }
    }

    @Override
    public List<Autor> buscarPorUltimoNome(String nome) throws DAOAutorException {
        Connection conexao = null;
        PreparedStatement comando = null;
        String sql = "select * from autores where ultimonome = ?";
        ResultSet resultado = null;
        List<Autor> autores = new ArrayList<>();
        try {
            conexao = InicializadorBancoDados.conectarBd();
            comando = conexao.prepareStatement(sql);
            comando.setString(1, nome);
            resultado = comando.executeQuery();
            while (resultado.next()) {
                Autor autor = new Autor(
                        resultado.getInt("codigo"),
                        resultado.getString("primeironome"),
                        resultado.getString("ultimonome"));
                autores.add(autor);
            }
            comando.close();
            conexao.close();
            return autores;
        } catch (Exception e) {
            throw new DAOAutorException("Falha na busca", e);
        }
    }

    @Override
    public void inserir(Autor autor) throws DAOAutorException {
        Connection conexao = null;
        PreparedStatement comando = null;
        String sql = "insert into autores(codigo,primeironome,ultimonome) values(?,?,?)";
        int resultado = 0;
        try {
            conexao = InicializadorBancoDados.conectarBd();
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, autor.getCodigo());
            comando.setString(2, autor.getPrimeiroNome());
            comando.setString(3, autor.getUltimoNome());
            resultado = comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (Exception e) {
            throw new DAOAutorException("Falha na inserção", e);
        }
        if(resultado == 0) {
            throw new DAOAutorException("Falha na inserção");
        }
    }

    @Override
    public void alterar(Autor autor) throws DAOAutorException {
        Connection conexao = null;
        PreparedStatement comando = null;
        String sql = "update autores set primeironome=?, ultimonome=? where codigo = ?";
        int resultado = 0;
        try {
            conexao = InicializadorBancoDados.conectarBd();
            comando = conexao.prepareStatement(sql);
            comando.setString(1, autor.getPrimeiroNome());
            comando.setString(2, autor.getUltimoNome());
            comando.setInt(3, autor.getCodigo());
            resultado = comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (Exception e) {
            throw new DAOAutorException("Falha na alteração", e);
        }
        if(resultado == 0) {
            throw new DAOAutorException("Falha na alteração");
        }
    }
}
