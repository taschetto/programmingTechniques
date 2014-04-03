package irpf;

/**
 *
 * @author Guilherme Taschetto
 */
public interface IIrpf
{
  //@ pure;
  double getTotRendimentos();
  
  //@ ensures getTotRendimentos() == totRendimentos;
  void setTotRendimentos(double totRendimentos);
  
  //@ pure;
  double getContrPrev();
  
  //@ ensures getContrPrev() == contrPrev;
  void setContrPrev(double contrPrev);
  
  //@ pure;
  int getNroDep();
  
  //@ ensures getNroDep() == nroDep;
  void setNroDep(int nroDep);
  
  //@ pure;
  int getIdade();
  
  //@ ensures getIdade() == idade;
  void setIdade(int idade); 
  
  //@ pure;
  String getNome();
  
  //@ pure;
  String getCpf();
  
  //@ pure;
  //@ ensures \result >= 0;
  double impostoDevido();      
}
