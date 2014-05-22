/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author 12180247
 */
public class MatrixMain {
    
    private static List<Matrix> getCallables(int[][] data) throws Exception
    {
        List<Matrix> list = new ArrayList<Matrix>();
        for (int i = 0; i < data[0].length; i++)
            list.add(new Matrix(data, i));
        return list;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        int[][] data = { {1, 2, 3}, {1, 2, 3}, {1, 2, 3} };
        
        List<Matrix> list = getCallables(data);
        
        List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
        ExecutorService e = Executors.newFixedThreadPool(2);
        for (Matrix m : list)
        {
            futureList.add(e.submit(m));
        }
    
        int soma = 0;
        for (Future<Integer> f : futureList)
            System.out.println("Soma da coluna: " + f.get());
        e.shutdown();        
    }
}
