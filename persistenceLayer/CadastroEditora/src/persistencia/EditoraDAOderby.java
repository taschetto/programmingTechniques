
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import negocio.DAOEditoraException;
import negocio.Editora;
import negocio.EditoraDAO;


/**
 *
 * @author aa
 */
public class EditoraDAOderby implements EditoraDAO {

    @Override
    public List<Editora> buscarTodos() throws DAOEditoraException {
        List<Editora> editoras = new ArrayList<>();
        Connection conexao;
        Statement comando;
        String sql = "select * from editoras";
        ResultSet resultado;
        try {
            conexao = InicializadorBancoDados.conectarBd();
            comando = conexao.createStatement();
            resultado = comando.executeQuery(sql);
            while (resultado.next()) {
                Editora editora = new Editora(
                        resultado.getInt("codigo"),
                        resultado.getString("nome")
                );
                editoras.add(editora);
            }
            comando.close();
            conexao.close();
            return editoras;
        } catch (Exception e) {
            throw new DAOEditoraException("Falha na busca", e);
        }
    }
    

    
    @Override
    public Editora buscarPorCodigo(int codigo) throws DAOEditoraException {
        Connection conexao;
        PreparedStatement comando;
        String sql = "select * from editoras where codigo = ?";
        ResultSet resultado;
        Editora ed = null;
        try {
            conexao = InicializadorBancoDados.conectarBd();
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, codigo);
            resultado = comando.executeQuery();
            if(resultado.next()) {
              ed = new Editora(
                      resultado.getInt("codigo"),
                      resultado.getString("nome")
              );
            }
            comando.close();
            conexao.close();
            return ed;
        } catch (Exception e) {
            throw new DAOEditoraException("Falha na busca", e);
        }
    }


    
    @Override
    public void inserir(Editora ed) throws DAOEditoraException {
        Connection conexao;
        PreparedStatement comando;
        String sql = "insert into editoras(codigo,nome) values(?,?)";
        int resultado = 0;
        try {
            conexao = InicializadorBancoDados.conectarBd();
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, ed.getCodigo());
            comando.setString(2, ed.getNome());
            resultado = comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (Exception e) {
            throw new DAOEditoraException("Falha na inserção", e);
        }
        if(resultado == 0) {
            throw new DAOEditoraException("Falha na inserção");
        }
    }
    
    @Override
    public void alterar(Editora ed) throws DAOEditoraException {
        Connection conexao;
        PreparedStatement comando;
        String sql = "update editoras set nome=? where codigo = ?";
        int resultado = 0;
        try {
            conexao = InicializadorBancoDados.conectarBd();
            comando = conexao.prepareStatement(sql);
            comando.setString(1, ed.getNome());
            comando.setInt(2, ed.getCodigo());
            resultado = comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (Exception e) {
            throw new DAOEditoraException("Falha na alteração", e);
        }
        if(resultado == 0) {
            throw new DAOEditoraException("Falha na alteração");
        }
    }
}
