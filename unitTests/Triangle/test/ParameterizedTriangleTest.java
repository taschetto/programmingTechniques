/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import triangle.Triangle;

/**
 *
 * @author Guilherme Taschetto
 */
@RunWith(Parameterized.class)
public class ParameterizedTriangleTest
{
    private int a = 0;
    private int b = 0;
    private int c = 0;
    
    public ParameterizedTriangleTest(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Test(expected = ArithmeticException.class)
    public void InvalidValues()
    {
        Triangle t = new Triangle(this.a, this.b, this.c);
    }
    
    @Parameters
    public static Collection<Integer[]> invalidValues() {
        return Arrays.asList(
            new Integer[][]
            {
                {  1,  1, -1 },
                {  1, -1,  1 },
                { -1,  1,  1 },
                { -1, -1,  1 },
                {  1, -1, -1 },
                { -1, -1, -1 },
                { 10, 20,  1 },
            });
    }

}
