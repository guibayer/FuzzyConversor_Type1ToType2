public class Type1ToType2 {
	// A(a1, a2) e B(b1, b2)
	// x  y
	// a1 a2
	// b1 b2
	// x  y
	
	// x*a2 + a1*b2 + b1*y - y*a1 - a2*b1 - b2*x = 0
	// b1*y - y*a1 = -x*a2 - a1*b2 + a2*b1 + b2*x
	// (b1 - a1) * y = (b2 - a2) * x + (-a1*b2 + a2*b1)
	// y = ((b2 - a2) * x + (a1*b2 + a2*b1)) / (b1 - a1)
	
	
	public static void main(String args[]) {
		float x = 5;
		//Valores Default:
		float a2 = 0, b2 = 1, c2 = 1, d2 = 0;
		float valorDeSaida = 0;
		float xEqDaReta1 = 0, valorFixoEqDaReta1 = 0, yEqDaReta1 = 0;
		//Valores Lidos:
		float a1 = 4, b1 = 6, c1 = 10, d1 = 10;	
		
		yEqDaReta1 = b1 - a1; //(b1 - a1) * y
		xEqDaReta1 = b2 - a2; //(b2 - a2) * x
		valorFixoEqDaReta1 = -a1*b2 + a2*b1; //(-a1*b2 + a2*b1)
		
		float xEqDaReta2 = 0, valorFixoEqDaReta2 = 0, yEqDaReta2 = 0;
		
		yEqDaReta2 = d1 - c1;
		xEqDaReta2 = d2 - c2;
		valorFixoEqDaReta2 = c1*d2 + c2*d1;
		
		if (x >= a1 && x <= b1){
			valorDeSaida = (xEqDaReta1 * x + valorFixoEqDaReta1) / yEqDaReta1;
		}else if (x >= c1 && x <= d1){
			valorDeSaida = (xEqDaReta2 * x + valorFixoEqDaReta2) / yEqDaReta2;
		}else if (x > b1 && x < c1) {
			valorDeSaida = 1;
		}else {
			valorDeSaida = 0;
		}
		
		System.out.println("Para o valor de x: " + x + " o y correspondente será: " + valorDeSaida);
				
		
	}
}
