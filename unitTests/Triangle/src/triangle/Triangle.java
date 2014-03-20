/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package triangle;

/**
 *
 * @author Guilherme Taschetto
 */
public class Triangle {

    private int a = 0;
    private int b = 0;
    private int c = 0;
    
    public Triangle(int a, int b, int c) throws ArithmeticException
    {
        if (!this.IsValid(a, b, c))
        {
            throw new ArithmeticException(String.format("The values %d, %d and %d does not form a triangle.", a, b, c));
        }
        
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public String Classify()
    {
        if (a == b)
        {
            if (b == c)
            {
                return "equilateral";
            }
            else
            {
                return "isosceles";
            }
        }
        else
        {
            if (b == c)
            {
                return "isosceles";
            }
            else
            {
                return "scalene";
            }
        }
    }
    
    private boolean IsValid(int a, int b, int c)
    {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }    
}
