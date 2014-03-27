/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package irpf;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 12180247
 */
public class IrpfTest {
  
  public IrpfTest() {
  }
  
  @Test
  public void ConstructorTest()
  {
    String nome = "Guilherme", cpf = "000.000.000-05";
    Irpf irpf = new Irpf(nome, cpf);
    assertEquals(nome, irpf.getNome());
    assertEquals(cpf, irpf.getCpf());
  }
  
  @Test
  public void TotRendimentosTest()
  {
    Irpf irpf = new Irpf("Guilherme", "000.000.000-05");
    assertEquals(0, irpf.getTotRendimentos(), 0.01);
    double novoTotRendimentos = 12345.67;
    irpf.setTotRendimentos(novoTotRendimentos);
    assertEquals(novoTotRendimentos, irpf.getTotRendimentos(), 0.01);
  }
  
  @Test
  public void ContrPrevTest()
  {
    Irpf irpf = new Irpf("Guilherme", "000.000.000-05");
    assertEquals(0, irpf.getContrPrev(), 0.01);
    double novoContrPrev = 345.67;
    irpf.setContrPrev(novoContrPrev);
    assertEquals(novoContrPrev, irpf.getContrPrev(), 0.01);
  }
  
  @Test
  public void NroDepTest()
  {
    Irpf irpf = new Irpf("Guilherme", "000.000.000-05");
    assertEquals(0, irpf.getNroDep());
    int novoNroDep = 3;
    irpf.setNroDep(novoNroDep);
    assertEquals(novoNroDep, irpf.getNroDep());
  }
  
  @Test
  public void IdadeTest()
  {
    Irpf irpf = new Irpf("Guilherme", "000.000.000-05");
    assertEquals(0, irpf.getIdade());
    int novaIdade = 30;
    irpf.setIdade(novaIdade);
    assertEquals(novaIdade, irpf.getIdade());
  }    
}
