public class Trapezoidal {
	private Vector a, b, c, d;
	private float constanteC;
	
	public Trapezoidal(float pontoA, float pontoB, float pontoC, float pontoD, float constante) {
		this.a = new Vector(pontoA, 0);
		this.b = new Vector(pontoB, 1);
		this.c = new Vector(pontoC, 1);
		this.d = new Vector(pontoD, 0);	
		this.constanteC = constante;
		
		
		this.calculaInferiores();
		this.calculaSuperiores();
		
	}
	
	public void printValoresResultantes() {
		System.out.println("Para uma função trapezoidal com os pontos: (" + 
				this.a.getX() + ", " +
				this.b.getX() + ", " +
				this.c.getX() + ", " + 
				this.d.getX() + ") e uma constante c = " + this.constanteC);
		System.out.println("A função trapezoidal inferior terá pontos: (" + 
				this.a.getInf() + ", " +
				this.b.getInf() + ", " +
				this.c.getInf() + ", " + 
				this.d.getInf() + ") " );
		System.out.println("A função trapezoidal superior terá pontos: (" + 
				this.a.getSup() + ", " +
				this.b.getSup() + ", " +
				this.c.getSup() + ", " + 
				this.d.getSup() + ") " );
	}
	
	public void calculaSuperiores() {
		this.a.setSup(avaliaPontoDaRetaSuperior(this.a.getX(), true));
		this.b.setSup(avaliaPontoDaRetaSuperior(this.b.getX(), true));
		this.c.setSup(avaliaPontoDaRetaSuperior(this.c.getX(), false));
		this.d.setSup(avaliaPontoDaRetaSuperior(this.d.getX(), false));
	} 
	
	public void calculaInferiores() {
		this.a.setInf(avaliaPontoDaRetaInferior(this.a.getX(), true));
		this.b.setInf(avaliaPontoDaRetaInferior(this.b.getX(), true));
		this.c.setInf(avaliaPontoDaRetaInferior(this.c.getX(), false));
		this.d.setInf(avaliaPontoDaRetaInferior(this.d.getX(), false));
	} 
	
	public float avaliaPontoDaRetaSuperior(float x, boolean primeiraReta) {
		// Equação superior:
		// sup_u(x) = min[u(x) + c/2, 1.0]
		float valorDeRetorno;
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
		
		yEqDaReta2 = d.getX() - c.getX();
		xEqDaReta2 = d.getY() - c.getY();
		valorFixoEqDaReta2 = c.getX()*d.getY() + c.getY()*d.getX();
		
		if (x >= a.getX() && x <= b.getX()){
			valorDeRetorno = (xEqDaReta1 * x + valorFixoEqDaReta1) / yEqDaReta1;
		}else if (x >= c.getX() && x <= d.getX()){
			valorDeRetorno = (xEqDaReta2 * x + valorFixoEqDaReta2) / yEqDaReta2;
		}else if (x > b.getX() && x < c.getX()) {
			valorDeRetorno = 1;
		}else {
			valorDeRetorno = 0;
		}
		
		//System.out.println("Para o valor de x: " + x + " o y correspondente será: " + valorDeRetorno);
		
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

	public Vector getD() {
		return d;
	}

	public void setD(Vector d) {
		this.d = d;
	}

	public float getConstanteC() {
		return constanteC;
	}

	public void setConstanteC(float constanteC) {
		this.constanteC = constanteC;
	}
	
	
	
}
