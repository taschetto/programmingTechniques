/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exerciciojdbc2;

/**
 *
 * @author guilherme
 */
public class ExercicioJDBC2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         } catch (ClassNotFoundException ex) {
             System.out.println("JavaDb driver not found!!");
             System.exit(0);
         }
    }
}
