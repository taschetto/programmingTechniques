package irpf;

/**
 *
 * @author Guilherme Taschetto
 */
public class Irpf implements IIrpf
{
  private String nome = "";
  private String cpf = "";
  private double totRendimentos = 0;
  private double contrPrev = 0;
  private int nroDep = 0;
  private int idade = 0;
  
  public Irpf(String nome, String cpf)
  {
    this.nome = nome;
    this.cpf = cpf;
  }
  
  @Override
  public double getTotRendimentos() {
    return this.totRendimentos;
  }

  @Override
  public void setTotRendimentos(double totRendimentos) {
    this.totRendimentos = totRendimentos;
  }

  @Override
  public double getContrPrev() {
    return this.contrPrev;
  }

  @Override
  public void setContrPrev(double contrPrev) {
    this.contrPrev = contrPrev;
  }

  @Override
  public int getNroDep() {
    return this.nroDep;
  }

  @Override
  public void setNroDep(int nroDep) {
    this.nroDep = nroDep;
  }

  @Override
  public int getIdade() {
    return this.idade;
  }

  @Override
  public void setIdade(int idade) {
    this.idade = idade;
  }

  @Override
  public String getNome() {
    return this.nome;
  }

  @Override
  public String getCpf() {
    return this.cpf;
  }

  @Override
  public double impostoDevido() {
    double baseCalculo = this.totRendimentos - this.contrPrev;
    
    if (baseCalculo < 12000)
    {
      return 0; // isento
    }
    
    double desconto = 0;
    
    if (this.idade < 65)
    {
      if (this.nroDep < 3)
      {
        desconto = 0.02;
      }
      else if (this.nroDep < 6)
      {
        desconto = 0.035;
      }
      else
      {
        desconto = 0.05;
      }
    }
    else
    {
      if (this.nroDep < 3)
      {
        desconto = 0.03;
      }
      else if (this.nroDep < 6)
      {
        desconto = 0.045;
      }
      else
      {
        desconto = 0.06;
      }      
    }
    
    baseCalculo *= (1 - desconto);
    
    double impostoDevido = (baseCalculo - 12000) * 0.15;
    
    if (baseCalculo < 24000)
    {
      return impostoDevido;
    }
    else
    {
      return impostoDevido + (baseCalculo - 24000) * 0.275;
    }
  }
}
