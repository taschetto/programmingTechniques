/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exerciciojdbc1;

import java.sql.*;

/**
 *
 * @author guilherme
 */
public class ExercicioJDBC1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println("JavaDb driver not found!!");
            System.exit(0);
        }
        
        Connection conexao = null;
        Statement comando = null;
        String sql = "select * from produtos";
        ResultSet resultado = null;
        
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/Tecnicas","teste","teste");
            comando = conexao.createStatement();
            resultado = comando.executeQuery(sql);
            while(resultado.next()){
                System.out.println(String.format("Código: %d ; Nome: %s", resultado.getInt("codigo"), resultado.getString("nome")));
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
    }
}
