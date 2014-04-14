package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author julio, bernardo, agustini
 */
public class InicializadorBancoDados {
    private static final String dbName = "CadastroLivraria";
    
    public static void inicializar() throws Exception {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    }
    
    public static void criarBd() throws Exception{
        Connection con = DriverManager.getConnection("jdbc:derby:"+dbName+";create=true");
        Statement sta = con.createStatement();
        String sqlAutor = "CREATE TABLE AUTORES("
                        + "CODIGO int PRIMARY KEY NOT NULL,"
                        + "PRIMEIRONOME varchar(100) NOT NULL,"
                        + "ULTIMONOME varchar(100) NOT NULL)";
        sta.executeUpdate(sqlAutor);
        String sqlEditora = "CREATE TABLE EDITORAS("
                          + "CODIGO int PRIMARY KEY NOT NULL,"
                          + "NOME varchar(100) NOT NULL)";
        sta.executeUpdate(sqlEditora);
        String sqlLivro = "CREATE TABLE LIVROS("
                        + "CODIGO int PRIMARY KEY NOT NULL,"
                        + "TITULO varchar(100) NOT NULL,"
                        + "ANO int NOT NULL,"
                        + "CODEDITORA int NOT NULL,"
                        + "CONSTRAINT FK_EDITORAS FOREIGN KEY (CODEDITORA) REFERENCES EDITORAS(CODIGO))";
        sta.executeUpdate(sqlLivro);
        String sqlLivroAutor = "CREATE TABLE LIVROSAUTORES("
                             + "CODLIVRO int NOT NULL,"
                             + "CODAUTOR int NOT NULL,"
                             + "CONSTRAINT PK_LIVROSAUTORES PRIMARY KEY (CODLIVRO,CODAUTOR),"
                             + "CONSTRAINT FK_LIVROS FOREIGN KEY (CODLIVRO) REFERENCES LIVROS(CODIGO),"
                             + "CONSTRAINT FK_AUTORES FOREIGN KEY (CODAUTOR) REFERENCES AUTORES(CODIGO))";
        sta.executeUpdate(sqlLivroAutor);
        sta.close();
        con.close();
    }
    
    public static Connection conectarBd() throws Exception{
        return DriverManager.getConnection("jdbc:derby:"+dbName);
    }
}
