/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package irpf;

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author 12180247
 */
@RunWith(Parameterized.class)
public class ParameterizedIrpfTest {
  private int idade;
  private int nroDep;
  private double totRendimentos;
  private double contrPrev;
  private double impostoDevido;
  
  public ParameterizedIrpfTest(int idade, int nroDep, double totRendimentos, double contrPrev, double impostoDevido)
  {
    this.idade = idade;
    this.nroDep = nroDep;
    this.totRendimentos = totRendimentos;
    this.contrPrev = contrPrev;
    this.impostoDevido = impostoDevido;
  }
  
  @Parameters
  public static Collection<Object[]> values()
  {
    return Arrays.asList(
            new Object[][]
            {
              {25, 0, 10000, 500, 0},
              
              {64, 2, 15000, 500, 331.50},
              {64, 5, 15000, 500, 298.87},
              {64, 6, 15000, 500, 266.25},
              
              {65, 2, 15000, 500, 309.75},
              {65, 5, 15000, 500, 277.12},
              {65, 6, 15000, 500, 244.5},
              
              {64, 2, 30000, 500, 3886.75},
              {64, 5, 30000, 500, 3698.68},
              {64, 6, 30000, 500, 3510.625},
              
              {65, 2, 30000, 500, 3761.37},
              {65, 5, 30000, 500, 3573.31},
              {65, 6, 30000, 500, 3385.25},              
            });
  }
  
  @Test
  public void ImpostoDevidoTest()
  {
    Irpf irpf = new Irpf("Guilherme", "000.000.000-00");
    irpf.setIdade(this.idade);
    irpf.setNroDep(this.nroDep);
    irpf.setTotRendimentos(this.totRendimentos);
    irpf.setContrPrev(this.contrPrev);
    
    assertEquals(this.impostoDevido, irpf.impostoDevido(), 0.01);
  }
}
