/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matrix;

import java.util.concurrent.Callable;

/**
 *
 * @author 12180247
 */
public class Matrix implements Callable<Integer> {
    
    private int[] data;
    
    public Matrix(int[][] data, int column) throws Exception
    {
        int lineCount = data.length;
        int columnCount = data[0].length;
        
        if (column >= columnCount)
            throw new Exception();
        
        this.data = new int[columnCount];
        
        for (int i = 0; i < lineCount; i++)
            this.data[i] = data[i][column];
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < this.data.length; i++)
        {
            sum += this.data[i];
        }
        return sum;
    }
}
