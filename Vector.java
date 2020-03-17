public class Vector {
	private float x;
	private float y;
	private float sup;
	private float inf;
	
	public Vector(float xInicial, float yInicial) {
		this.x = xInicial;
		this.y = yInicial;
		this.sup = 0;
		this.inf = 0;
	}
		
	public float getSup() {
		return sup;
	}
	
	public void setSup(float sup) {
		this.sup = sup;
	}

	public float getInf() {
		return inf;
	}
	
	public void setInf(float inf) {
		this.inf = inf;
	}

	public float getX() {
		return x;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(float y) {
		this.y = y;
	}
}
