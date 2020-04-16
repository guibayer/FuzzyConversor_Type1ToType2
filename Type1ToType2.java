public class Type1ToType2 {
	// A(a1, a2) e B(b1, b2)
	// x  y
	// a1 a2
	// b1 b2
	// x  y
	
	// Para descobrir o ponto Y:
	// x*a2 + a1*b2 + b1*y - y*a1 - a2*b1 - b2*x = 0
	// b1*y - y*a1 = -x*a2 - a1*b2 + a2*b1 + b2*x
	// (b1 - a1) * y = (b2 - a2) * x + (-a1*b2 + a2*b1)
	// y = ((b2 - a2) * x + (a1*b2 + a2*b1)) / (b1 - a1)
	
	//Para descobrir o ponto X baseado no Y;
	
	// x*a2 + a1*b2 + b1*y - y*a1 - a2*b1 - b2*x = 0
	// x*a2 - b2*x = -a1*b2 - b1*y + y*a1 + a2*b1
	// (a2 - b2) * x = (-b1 + a1) * y + (-a1*b2 + a2*b1)
	// x = (-b1 + a1) * y + (-a1*b2 + a2*b1) / (a2 - b2)
	
	
	
	public static void main(String args[]) {
		float constanteC = (float) 3;
		Trapezoidal highROA = new Trapezoidal((float) 0, (float) 0, (float) 2, (float) 4, constanteC);
		Trapezoidal mediumROA = new Trapezoidal((float) 2, (float) 4, (float) 4, (float) 6, constanteC);
		Trapezoidal lowROA = new Trapezoidal((float) 4, (float) 6, (float) 10, (float) 10, constanteC);
		highROA.printValoresResultantes();
		//lowROA.printValoresResultantes();
		
		//System.out.println("Com a entrada 8.45 o valor de y é: " + lowPromotion.avaliaPontoDaReta((float) 8.45));
		//System.out.println("Superior com entrada 8.45 é: " + lowPromotion.avaliaPontoDaRetaSuperior((float) 8.45));
		//System.out.println("Inferior com entrada 8.45 é: " + lowPromotion.avaliaPontoDaRetaInferior((float) 8.45));

		
		//Triangular mediumPromotion = new Triangular(0, 5, 10, (float) 0.2);
		//mediumPromotion.printValoresResultantes();
		
		//System.out.println("Ponto da reta 7: " + mediumPromotion.avaliaPontoDaRetaTriangular((float) 4.2));
		
		
		
	}
}
