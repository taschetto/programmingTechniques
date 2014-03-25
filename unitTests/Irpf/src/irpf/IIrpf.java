/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package irpf;

/**
 *
 * @author 12180247
 */
public interface IIrpf
{
  double getTotRendimentos();
  void setTotRendimentos(double totRendimentos);
  double getContrPrev();
  void setContrPrev(double contrPrev);
  int getNroDep();
  void setNroDep(int nroDep);
  int getIdade();
  void setIdade(int idade); 
  String getNome();
  String getCpf();
  double impostoDevido();      
}
