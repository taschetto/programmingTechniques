/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import triangle.Triangle;

/**
 *
 * @author Guilherme Taschetto
 */
public class TriangleTest {
    
    public TriangleTest() {
    }
    
    // These test where moved to ParameterizedTriangleTest.java
    /*
    @Test(expected = ArithmeticException.class)
    public void InvalidValues()
    {
        Triangle t = new Triangle(-1, 1, 1);
    }
    
    @Test(expected = ArithmeticException.class)
    public void NegativeB()
    {
        Triangle t = new Triangle(1, -11, 1);
    }    
    
    @Test(expected = ArithmeticException.class)
    public void NegativeC()
    {
        Triangle t = new Triangle(1, 1, -1);
    }    
    
    @Test(expected = ArithmeticException.class)
    public void NegativeAB()
    {
        Triangle t = new Triangle(-1, -1, 1);
    }    
    
    @Test(expected = ArithmeticException.class)
    public void NegativeAC()
    {
        Triangle t = new Triangle(-1, 1, -1);
    }        

    @Test(expected = ArithmeticException.class)
    public void NegativeBC()
    {
        Triangle t = new Triangle(1, -1, -1);
    }        
    
    @Test(expected = ArithmeticException.class)
    public void NegativeABC()
    {
        Triangle t = new Triangle(-1, -1, -1);
    }
    */
    
    @Test
    public void Equilateral()
    {
        Triangle t = new Triangle(6, 6, 6);
        
        assertEquals(t.Classify(), "equilateral");
    }
    
    @Test
    public void Isosceles()
    {
        Triangle t = new Triangle(10, 6, 6);
        
        assertEquals(t.Classify(), "isosceles");
    }        
    
    @Test
    public void Scalene()
    {
        Triangle t = new Triangle(10, 7, 5);
        
        assertEquals(t.Classify(), "scalene");
    }
}
