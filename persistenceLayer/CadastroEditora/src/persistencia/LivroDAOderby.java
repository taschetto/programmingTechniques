package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import negocio.Autor;
import negocio.AutorDAO;
import negocio.DAOLivroException;
import negocio.Editora;
import negocio.EditoraDAO;
import negocio.Livro;
import negocio.LivroDAO;

/**
 *
 * @author bernardo
 */
public class LivroDAOderby implements LivroDAO{
    private EditoraDAO edDAO;
    private AutorDAO autDAO;

    // Esta solução só é possível porque um DAO não mantém estado (variáveis de instância)
    // De qualquer forma não é uma boa prática de programação
    // Ao invés desta solução, usar o padrão Singleton (será visto junto com a camada de negócios)
    public LivroDAOderby(){
        edDAO = new EditoraDAOderby();
        autDAO = new AutorDAOderby();
    }
    @Override
    public List<Livro> buscarTodos() throws DAOLivroException {
        List<Livro> livros = new ArrayList<>();
        List<Autor> autores;
                
        Connection conexao;
        
        Statement comandoLivros;
        PreparedStatement comandoLivrosAutores;
        String sqlLivros = "select * from livros";
        String sqlLivrosAutores = "select * from livrosautores where codlivro = ?";
        ResultSet resultadoLivros,resultadoLivrosAutores;
        try {
            conexao = InicializadorBancoDados.conectarBd();
            comandoLivros = conexao.createStatement();
            resultadoLivros = comandoLivros.executeQuery(sqlLivros);
            // Para cada linha da tabela livros
            while (resultadoLivros.next()) {
                // Recupera todos os autores
                
                comandoLivrosAutores = conexao.prepareStatement(sqlLivrosAutores);
                comandoLivrosAutores.setInt(1,resultadoLivros.getInt("codigo"));
                
                resultadoLivrosAutores = comandoLivrosAutores. executeQuery();
                autores = new ArrayList<>();
                while(resultadoLivrosAutores.next()){
                    int codAutor = resultadoLivrosAutores.getInt("codautor");
                    autores.add(autDAO.buscarPorCodigo(codAutor));
                }
                // Instancia o livro
                Livro livro = new Livro(
                        resultadoLivros.getInt("codigo"),
                        resultadoLivros.getString("titulo"),
                        resultadoLivros.getInt("ano"),
                        edDAO.buscarPorCodigo(resultadoLivros.getInt("codeditora")),
                        autores.get(0)
                );
                // Acrescenta os demais autores se houver
                for(int i=1;i<autores.size();i++){
                    livro.addAutor(autores.get(i));
                }
                livros.add(livro);
                comandoLivrosAutores.close();
            }
            comandoLivros.close();
            conexao.close();
            return livros;
        } catch (Exception e) {
            throw new DAOLivroException("Falha na busca: "+e.getMessage(), e);
        }
    }

    @Override
    public Livro buscarPorCodigo(int codigo) throws DAOLivroException {
        Livro livro = null;
        List<Autor> autores;
                
        Connection conexao;
        
        PreparedStatement comandoLivros;
        PreparedStatement comandoLivrosAutores;
        String sqlLivros = "select * from livros where codigo = ?";
        String sqlLivrosAutores = "select * from livrosautores where codlivro = ?";
        ResultSet resultadoLivros,resultadoLivrosAutores;
        try {
            conexao = InicializadorBancoDados.conectarBd();
            comandoLivros = conexao.prepareStatement(sqlLivros);
            comandoLivros.setInt(1,codigo);
            resultadoLivros = comandoLivros.executeQuery();
            // Para cada linha da tabela livros
            while (resultadoLivros.next()) {
                // Recupera todos os autores
                
                comandoLivrosAutores = conexao.prepareStatement(sqlLivrosAutores);
                comandoLivrosAutores.setInt(1,resultadoLivros.getInt("codigo"));
                
                resultadoLivrosAutores = comandoLivrosAutores. executeQuery();
                autores = new ArrayList<>();
                while(resultadoLivrosAutores.next()){
                    int codAutor = resultadoLivrosAutores.getInt("codautor");
                    autores.add(autDAO.buscarPorCodigo(codAutor));
                }
                // Instancia o livro
                 livro = new Livro(
                        resultadoLivros.getInt("codigo"),
                        resultadoLivros.getString("titulo"),
                        resultadoLivros.getInt("ano"),
                        edDAO.buscarPorCodigo(resultadoLivros.getInt("codeditora")),
                        autores.get(0)
                );
                // Acrescenta os demais autores se houver
                for(int i=1;i<autores.size();i++){
                    livro.addAutor(autores.get(i));
                }
                
                comandoLivrosAutores.close();
            }
            comandoLivros.close();
            conexao.close();
            return livro;
        } catch (Exception e) {
            throw new DAOLivroException("Falha na busca: "+e.getMessage(), e);
        }
    }

    @Override
    public List<Livro> buscarPorEditora(int codigo) throws DAOLivroException {
              List<Livro> livros = new ArrayList<>();
        List<Autor> autores;
                
        Connection conexao;
        
        PreparedStatement comandoLivros;
        PreparedStatement comandoLivrosAutores;
        String sqlLivros = "select * from livros where codeditora = ?";
        String sqlLivrosAutores = "select * from livrosautores where codlivro = ?";
        ResultSet resultadoLivros,resultadoLivrosAutores;
        try {
            conexao = InicializadorBancoDados.conectarBd();
            comandoLivros = conexao.prepareStatement(sqlLivros);
            comandoLivros.setInt(1, codigo);
            resultadoLivros = comandoLivros.executeQuery();
            // Para cada linha da tabela livros
            while (resultadoLivros.next()) {
                // Recupera todos os autores
                
                comandoLivrosAutores = conexao.prepareStatement(sqlLivrosAutores);
                comandoLivrosAutores.setInt(1,resultadoLivros.getInt("codigo"));
                
                resultadoLivrosAutores = comandoLivrosAutores. executeQuery();
                autores = new ArrayList<>();
                while(resultadoLivrosAutores.next()){
                    int codAutor = resultadoLivrosAutores.getInt("codautor");
                    autores.add(autDAO.buscarPorCodigo(codAutor));
                }
                // Instancia o livro
                Livro livro = new Livro(
                        resultadoLivros.getInt("codigo"),
                        resultadoLivros.getString("titulo"),
                        resultadoLivros.getInt("ano"),
                        edDAO.buscarPorCodigo(resultadoLivros.getInt("codeditora")),
                        autores.get(0)
                );
                // Acrescenta os demais autores se houver
                for(int i=1;i<autores.size();i++){
                    livro.addAutor(autores.get(i));
                }
                livros.add(livro);
                comandoLivrosAutores.close();
            }
            comandoLivros.close();
            conexao.close();
            return livros;
        } catch (Exception e) {
            throw new DAOLivroException("Falha na busca: "+e.getMessage(), e);
        }
    }

    @Override
    // ATENCAO: esta operação necessita de controle de transação (atualiza 2 tabelas)
    // Este tópico será discutido mais adiante. A alteração desta rotina fica como 
    // exercício !!!
    public void inserir(Livro livro) throws DAOLivroException {
        Connection conexao;
        PreparedStatement comandoLivros,comandoLivrosAutores,comandoLivrosEditoras;
        String sqlLiv = "insert into livros(codigo,titulo,ano) values(?,?,?)";
        String sqlLivAut = "insert into livrosautores(codlivro,codautor) values(?,?)";
        String sqlLivEd = "insert into livroseditoras(codlivro,codeditora) values(?,?)";
        int resultado = 0;
        try {

            // Antes de poder inserir o Livro no banco é necessário verificar se
            // tanto a editora como os autores referenciados já estão persistidos.
            // Caso contrário a inserção falha ...
            // Ou entao prever como pré-condicao em um contrato e eliminar
            // esta necessidade
            
            // Recupera as editoras
            for(Editora e:livro.getEditoras()){
                Editora busca = edDAO.buscarPorCodigo(e.getCodigo());
                if (busca == null)
                {
                  throw new DAOLivroException("Editora '" + e.getCodigo() + "' não cadastrada.");
                }
            }

            // Recupera os autores
            for(Autor a:livro.getAutores()){
                Autor busca = autDAO.buscarPorCodigo(a.getCodigo());
                if (busca == null)
                {
                  throw new DAOLivroException("Autor '" + a.getCodigo() + "' não cadastrado.");
                }
            }

            // Executa a inserção do livro propriamente dita
            conexao = InicializadorBancoDados.conectarBd();
            // Insere o Livro na tabela Livros
            comandoLivros = conexao.prepareStatement(sqlLiv);
            comandoLivros.setInt(1, livro.getCodigo());
            comandoLivros.setString(2, livro.getTitulo());
            comandoLivros.setInt(3, livro.getAno());
            resultado = comandoLivros.executeUpdate();
            comandoLivros.close();
            // Atualiza a tabela LivrosAutores
            comandoLivrosAutores = conexao.prepareStatement(sqlLivAut);
            for(Autor a:livro.getAutores()){
                comandoLivrosAutores.setInt(1, livro.getCodigo());
                comandoLivrosAutores.setInt(2, a.getCodigo());
                resultado += comandoLivrosAutores.executeUpdate();                
            }
            comandoLivrosAutores.close();
            // Atualiza a tabela LivrosEditoras
            comandoLivrosEditoras = conexao.prepareStatement(sqlLivEd);
            for(Editora e:livro.getEditoras()){
                comandoLivrosEditoras.setInt(1, livro.getCodigo());
                comandoLivrosEditoras.setInt(2, e.getCodigo());
                resultado += comandoLivrosEditoras.executeUpdate();                
            }
            comandoLivrosEditoras.close();            
            conexao.close();
        } catch (Exception e) {
            throw new DAOLivroException("Falha na inserção", e);
        }
        // Verifica se foi feita a inserção de 1 livro e de "size" referencias
        // para autores na tabela livrosautores
        /*
        if(resultado < livro.getAutores().size()+1) {
            throw new DAOLivroException("Falha na inserção");
        }*/
        
    }

    @Override
    public void alterar(Livro livro) throws DAOLivroException {
        Connection conexao = null;
        PreparedStatement comando;
        PreparedStatement cmdApagar;
        PreparedStatement cmdLivrosAutores;
        PreparedStatement cmdLivrosEditoras;
        
        String sql = "update livros set titulo=?, ano=? where codigo = ?";
        // Problemas na solução abaixo?????
        String sqlApagar = "delete from livrosautores where codlivro=?";
        String sqlLivAut = "insert into livrosautores(codlivro,codautor) values(?,?)";
        
        String sqlApagar2 = "delete from livroseditoras where codlivro=?";
        String sqlLivEd = "insert into livroseditoras(codlivro,codeditora) values(?,?)";
        
   
        int resultado = 0;
        try {
            conexao = InicializadorBancoDados.conectarBd();
            comando = conexao.prepareStatement(sql);
            comando.setString(1, livro.getTitulo());
            comando.setInt(2, livro.getAno());
            comando.setInt(3, livro.getCodigo());
            resultado = comando.executeUpdate();
            comando.close();
            
            cmdApagar = conexao.prepareStatement(sqlApagar);
            cmdApagar.setInt(1, livro.getCodigo());
            cmdApagar.executeUpdate();
            cmdApagar.close();
            
            cmdApagar = conexao.prepareStatement(sqlApagar2);
            cmdApagar.setInt(1, livro.getCodigo());
            cmdApagar.executeUpdate();
            cmdApagar.close();            
            
            // Atualiza a tabela LivrosAutores
            cmdLivrosAutores = conexao.prepareStatement(sqlLivAut);
            for(Autor a:livro.getAutores()){
                cmdLivrosAutores.setInt(1, livro.getCodigo());
                cmdLivrosAutores.setInt(2, a.getCodigo());
                resultado += cmdLivrosAutores.executeUpdate();                
            }
            cmdLivrosAutores.close();
            
            // Atualiza a tabela LivrosEditoras
            cmdLivrosEditoras = conexao.prepareStatement(sqlLivEd);
            for(Editora e:livro.getEditoras()){
                cmdLivrosEditoras.setInt(1, livro.getCodigo());
                cmdLivrosEditoras.setInt(2, e.getCodigo());
                resultado += cmdLivrosEditoras.executeUpdate();                
            }
            cmdLivrosEditoras.close();            
            
            conexao.close();
        } catch (Exception e) {
            throw new DAOLivroException("Falha na alteração: "+e.getMessage(), e);
        }
        if(resultado == 0) {
            throw new DAOLivroException("Falha na alteração");
        }
    }
    
}
