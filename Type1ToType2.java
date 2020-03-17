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
		Trapezoidal lowPromotion = new Trapezoidal(4, 6, 8, 10);
		System.out.println("Com a entrada 8.45 o valor de y é: " + lowPromotion.avaliaPontoDaReta((float) 8.45));
		System.out.println("Superior com entrada 8.45 é: " + lowPromotion.avaliaPontoDaRetaSuperior((float) 8.45));
		System.out.println("Inferior com entrada 8.45 é: " + lowPromotion.avaliaPontoDaRetaInferior((float) 8.45));
		
	}
}
