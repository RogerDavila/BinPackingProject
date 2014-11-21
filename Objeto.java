
public class Objeto {

	private int ido,x,y,puntoInicialX,puntoInicialY;
	
	public Objeto(int ido,int puntoInicialX,int puntoInicialY,int x,int y){
		this.ido = ido;
		this.setPuntoInicialX(puntoInicialX);
		this.setPuntoInicialY(puntoInicialY);
		this.setX(x);
		this.setY(y);
	}

	public int getPuntoInicialY() {
		return puntoInicialY;
	}

	public void setPuntoInicialY(int puntoInicialY) {
		this.puntoInicialY = puntoInicialY;
	}

	public int getPuntoInicialX() {
		return puntoInicialX;
	}

	public void setPuntoInicialX(int puntoInicialX) {
		this.puntoInicialX = puntoInicialX;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getIdo() {
		return ido;
	}

	public void setIdo(int ido) {
		this.ido = ido;
	}
	
	
}
