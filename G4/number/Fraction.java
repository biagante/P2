package number;

/**
 * Tipo de dados representando uma fracção.
 * Nesta versão pretende-se garantir um invariante (interno) mais forte:
 * as frações armazenadas devem ter sempre denominador positivo.
 * Isto permite simplificar alguns métodos.
 *
 * AVISO: Vários métodos podem dar erros devidos a overflow.
 * (Não deve haver problemas com numeradores e denominadores até 46430.)
 *
 * @author João Manuel Rodrigues
 * 2007--2018
 */

public class Fraction implements Comparable<Fraction>
{
  private int num;
  private int den;
  
  public static final Fraction ZERO = new Fraction(0, 1);
  public static final Fraction ONE = new Fraction(1,1);
  
  /** Cria uma nova fracção a partir de um par (numerador, denominador).
   *  @param num numerador da nova fracção.
   *  @param den denominador da nova fracção.
   *  <b>Exige (pré-condição):</b> den != 0.
   */
  public Fraction(int num, int den) {
    assert den != 0; // check precondition
    if (den < 0)
	{
		num = -num;
	}
    this.num = num;
    this.den = den;
    reduce();
    assert invariant(); // check object invariant
  }

  /* Testa o invariante do objeto.
   * Ou seja, a propriedade que define a validade de uma fração.
   * É para testar em asserções nos métodos.
   */
  public boolean invariant() {
    return (den > 0 || den != 0);   // O denominador não pode ser nulo!
  }


  /** Converte uma string numa fracção.
   *  @param str String no formato {@code "inteiro/inteiro"}
   *             representando uma fracção válida.
   *  @return fracção correspondente a {@code str}.
   */
  public static Fraction parseFraction(String str) {
    String[] p = str.split("/", 2);  // divide a string em até 2 partes
    int n = Integer.parseInt(p[0]);  // extrai numerador
    int d = (p.length==2)? Integer.parseInt(p[1]) : 1;
        // se tem 2 partes, extrai denominador, senão fica d=1
    if (d == 0) return null;
    return new Fraction(n, d);
  }

  /** Converte a fracção numa string.
   *  @return string com a representação desta fracção.
   */
  public String toString() {
    // Com um invariante mais forte, podemos simplificar este método!
    //assert invariant();
    return num+"/"+den;
  }

  /** Devolve o numerador da fracção.
   *  @return numerador desta fração.
   */
  public int num() { return num; }

  /** Devolve o denominador da fracção.
   *  @return denominador desta fração.
   */
  public int den() { return den; }

  /** Multiplica esta fracção por outra (this * b).
   *  @param b multiplicando.
   *  @return fracção produto de this * b.
   */
  public Fraction multiply(Fraction b) {
    int n = num*b.num;
    int d = den*b.den;
    reduce();
    Fraction p = new Fraction(n, d); // product
    assert p.invariant() : "Result should be valid";
    return p;
  }

  /** Adiciona esta fracção com outra (this + b).
   *  @param b fracção a adicionar a esta.
   *  @return fracção soma de this + b.
   */
  public Fraction add(Fraction b) {
    int n = num*b.den + den*b.num;
    int d = den*b.den;
    reduce();
    Fraction s = new Fraction(n, d); // sum
    assert s.invariant() : "Result should be valid";
    return s;
  }

  public Fraction divide(Fraction b) {
	assert b.num != 0 : "Division by zero!";
	int n  = num*b.den; 
	int d  = den*b.num;
	reduce();
	Fraction r = new Fraction(n,d);
	assert r.invariant() : "Result should be valid.";
	return r;
    
  }

  public Fraction subtract(Fraction b) {
	assert b.num != 0 : "Division by zero!";
	int n  = num*b.den - den*b.num; 
	int d  = den*b.num;
	reduce();
	Fraction r = new Fraction(n,d);
	assert r.invariant() : "Result should be valid.";
	return r;
    
  }

  public boolean equals(Fraction b) {
	  assert b.invariant();
	  if (this.num*b.den == b.num*this.den)
	  {
		  return true;
	  }
	  else if (-(this.num*b.den) == b.num*this.den)
	  {
		  return true;
	  }
	  else if(this.num*b.den == -(b.num*this.den))
	  {
		  return true;
	  }
	  else
	  {
		  reduce();
		  return(this.num*b.den == b.num*this.den);
	  }
  }

  public int compareTo(Fraction b) {
	if (this.num*b.den == b.num*this.den)
	{
		return 0;
	}
	else if (this.num*b.den > b.num*this.den)
	{
		return 1;
	}
	else
	{
		return -1;
	}
  }
  
  private void reduce() {
        // find the larger of the numerator and denominator
        int n = num, d = den, largest;
        if (num < 0) {
            n = -num;
        }
        if (n > d) {
            largest = n;
        }
        else {
            largest = d;
        }
        // find the largest number that divide the numerator and
        // denominator evenly
        int gcd = 0;
        for (int i = largest; i >= 2; i--) {
            if (num % i == 0 && den % i == 0) {
                gcd = i;
                break;
            }
        }
        // divide the largest common denominator out of numerator, denominator
        if (gcd != 0) {
            num /= gcd;
            den /= gcd;
        }
    }
}

