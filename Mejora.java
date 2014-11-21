import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Mejora {

	static int puntoInicioX = 0; //Punto de inicio X
	static int puntoInicioY = 0; //Punto de inicio Y
	
	public static void main(String args[]){
		JFrame jf = new JFrame();
		jf.setTitle("Bin Packing 2D");
		jf.setSize(Principal.xc, Principal.yc);
		jf.setResizable(false);
		jf.setVisible(true);
		int i;
		//for(i = Principal.xy.length-1; i >= 0; i--){
		for(i=0; i<Principal.xy.length;i++){
		paint(jf.getGraphics(), i);
		posicionador(i);
		}
	}
	
	private static void paint(Graphics g, int i) { //Selector de color para diferenciacion
		int rand = (int)(Math.random()*9);
		switch (rand){
		case 0: 
			g.setColor(Color.blue);
			break;
		case 1:
			g.setColor(Color.green);
			break;
		case 2:
			g.setColor(Color.gray);
			break;
		case 3:
			g.setColor(Color.black);
			break;
		case 4:
			g.setColor(Color.red);
			break;
		case 5:
			g.setColor(Color.pink);
			break;
		case 6:
			g.setColor(Color.cyan);
			break;
		case 7:
			g.setColor(Color.magenta);
			break;
		case 8:
			g.setColor(Color.darkGray);
			break;
		}
		
		g.fillRect(puntoInicioX, puntoInicioY,
				Principal.obj[i].getY(), Principal.obj[i].getX());
			/*g.fillRect(puntoInicioX, puntoInicioY,
					Principal.obj[i].getY(), Principal.obj[i].getX()); //Dibujado de rectangulo*/
		/*
		int areaObjeto =  Principal.obj[i].getX() * Principal.obj[i].getY();
		System.out.println("Area objeto: "+areaObjeto);
		areaTotalObjetos = areaTotalObjetos + areaObjeto;
		System.out.println("Area total objetos: "+areaTotalObjetos);	*/	
	}
	
	private static void posicionador(int i) {
		puntoInicioX = puntoInicioX + Principal.obj[i].getX();
		if(puntoInicioX >= Principal.xc || Principal.obj[i].getX() >= Principal.xc){
			puntoInicioX = 0;
			puntoInicioY = puntoInicioY + Principal.obj[i].getY();
		}
	}
}
