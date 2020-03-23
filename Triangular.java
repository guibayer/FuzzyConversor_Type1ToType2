public class Triangular {
	private Vector a, b, c, d;
	private float constanteC;

	public Triangular(float a, float b, float c, float d, float constante) {
		this.a = new Vector(a, 0);
		this.b = new Vector(b, 1);
		this.c = new Vector(c, 1);
		this.d = new Vector(d, 0);
		this.setConstanteC(constante);
	
		this.calculaInferiores();
		this.calculaSuperiores();
	
	}
	
	public void printValoresResultantes() {
		System.out.println("Para uma função triangular com os pontos: (" + 
				this.a.getX() + ", " +
				this.b.getX() + ", " +
				this.c.getX() + ") e uma constante C: "  + this.constanteC);
		System.out.println("O valor da inferior do ponto A é: " + this.a.getInf() + " e o valor superior é: " + this.a.getSup());
		System.out.println("O valor da inferior do ponto B é: " + this.b.getInf() + " e o valor superior é: " + this.b.getSup());
		System.out.println("O valor da inferior do ponto C é: " + this.c.getInf() + " e o valor superior é: " + this.c.getSup());
		System.out.println("O valor da inferior do ponto D é: " + this.d.getInf() + " e o valor superior é: " + this.d.getSup());
	}
	
	public void calculaInferiores() {
		this.a.setInf(avaliaPontoDaRetaInferior(this.a.getX(), true));
		//No caso da função inferior os pontos b == c
		this.b.setInf(avaliaPontoDaRetaInferior(this.b.getX(), true));
		this.c.setInf(this.b.getInf());
		this.d.setInf(avaliaPontoDaRetaInferior(this.c.getX(), false));
	} 
	
	public void calculaSuperiores() {
		this.a.setSup(avaliaPontoDaRetaSuperior(this.a.getX(), true));
		this.b.setSup(avaliaPontoDaRetaSuperior(this.b.getX(), true));
		this.c.setSup(avaliaPontoDaRetaSuperior(this.c.getX(), false));
		this.d.setSup(avaliaPontoDaRetaSuperior(this.d.getX(), false));
	} 
	
	public float avaliaPontoDaRetaSuperior(float x, boolean primeiraReta) {
		// Equação superior:
		// sup_u(x) = min[u(x) + c/2, 1.0]
		float valorDeRetorno = 0;
		
		if(primeiraReta) {
			valorDeRetorno = x - minF((avaliaPontoDaReta(x) + constanteC), (float) 1.0);
		}else {
			valorDeRetorno = x + minF((avaliaPontoDaReta(x) + constanteC), (float) 1.0);
		}
		
		
		return valorDeRetorno;
	}
	
	public float avaliaPontoDaRetaInferior(float x, boolean primeiraReta) {
		// Equação inferior:
		// inf_u(x) = min[max[u(x) - c/2, 0], 1.0 - c]
		float valorDeRetorno = 0;
		
		if(primeiraReta) {
			valorDeRetorno = x + minF(maxF((avaliaPontoDaReta(x) - constanteC/2), 0), ((float) 1.0 - constanteC));
		}else {
			valorDeRetorno = x - minF(maxF((avaliaPontoDaReta(x) - constanteC/2), 0), ((float) 1.0 - constanteC));
		}
		return valorDeRetorno;
	}
	
	public float avaliaPontoDaReta(float x) {
		float valorDeRetorno = 0;
		float xEqDaReta1 = 0, valorFixoEqDaReta1 = 0, yEqDaReta1 = 0;
		
		yEqDaReta1 = b.getX() - a.getX(); //(b1 - a1) * y
		xEqDaReta1 = b.getY() - a.getY(); //(b2 - a2) * x
		valorFixoEqDaReta1 = -a.getX()*b.getY() + a.getY()*b.getX(); //(-a1*b2 + a2*b1)
			
		float xEqDaReta2 = 0, valorFixoEqDaReta2 = 0, yEqDaReta2 = 0;
		
		yEqDaReta2 = c.getX() - b.getX();
		xEqDaReta2 = c.getY() - b.getY();
		valorFixoEqDaReta2 = b.getX()*c.getY() + b.getY()*c.getX();
		
		if(x > a.getX() && x < b.getX()) {
			valorDeRetorno = (xEqDaReta1 * x + valorFixoEqDaReta1) / yEqDaReta1;
		}else if (x > b.getX() && x < c.getX()) {
			valorDeRetorno = (xEqDaReta2 * x + valorFixoEqDaReta2) / yEqDaReta2;
		}else if (x == b.getX()) {
			valorDeRetorno = 1;
		}else {
			valorDeRetorno = 0;
		}
		
		return valorDeRetorno;
		
	}
	
	public float minF(float a, float b) {
		if(a < b) 
			return a;
		else
			return b;
	}
	
	public float maxF(float a, float b) {
		if(a > b)
			return a;
		else
			return b;
	}
	
	public Vector getA() {
		return a;
	}

	public void setA(Vector a) {
		this.a = a;
	}

	public Vector getB() {
		return b;
	}

	public void setB(Vector b) {
		this.b = b;
	}

	public Vector getC() {
		return c;
	}

	public void setC(Vector c) {
		this.c = c;
	}

	public float getConstanteC() {
		return constanteC;
	}

	public void setConstanteC(float constanteC) {
		this.constanteC = constanteC;
	}
	
}
