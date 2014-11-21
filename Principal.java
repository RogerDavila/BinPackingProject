/*@Authors
 * David Ochoa
 * Roger Davila
 * */

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.awt.*;

import javax.swing.JFrame;

public class Principal {
	
	static Scanner sc = new Scanner(System.in);
	
	static int puntoInicioX = 0; //Punto de inicio X
	static int puntoInicioY = 0; //Punto de inicio Y
	
	int ic;  //Identificador de contenedores usados
	static int xc = 600; //Ancho(x) y largo(Y) del contenedor
	static int yc = 400;
	
	static int io = 0; //ID del objeto
	static int xi,yi; //Ancho(X) y largo(Y) el objeto
	static int n; //Objetos pendientes por acomodar
	
	static double areaContenedor;
	static double areaTotalObjetos = 0;
	
	static int contfo = 0; 
	
	static long time, time2, time3, time4, time5;
	
	static int bins = 0;
	
	static int[][] xy;
	static Objeto[] obj;
	static Contenedor contenedor;
	
	static double porcentajeVacio;
	static String res ="";
	
	static int hor,ver,cubo = 0;
	
	public static void main(String args[]){
		JFrame jf = new JFrame();
		jf.setTitle("Bin Packing 2D");
		jf.setSize(xc, yc);
		jf.setResizable(false);
		jf.setVisible(true);
		
		contenedor = new Contenedor(1,xc,yc);
		
		areaContenedor = xc * yc; //Se calcula el area del contenedor
		xy = lectura();
		n = xy.length;
		obj = new Objeto[n];
		//System.out.println("Inserta cuantos objetos entrarán\n");
		//n = sc.nextInt();
		
		time = System.currentTimeMillis();
		while(n != 0){
			n = n - 1;
			
			//lectura();
			xi = xy[n][0];
			yi = xy[n][1];
//			System.out.println("Inserta el ancho del objeto\n");
//			xi = sc.nextInt();
//			System.out.println("Inserta el largo del objeto\n");
//			yi = sc.nextInt();
			
			paint(jf.getGraphics());
			posicionador();
			verificador();
		}
		time2 = System.currentTimeMillis();
		time3 = time2 - time;
		System.out.println("\n");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Tiempo total de ejecucion: "+time3+ " milisegundos"); //Tiempo de ejecucion total
		System.out.println("Area total del contenedor: "+areaContenedor);
		System.out.println("Area total de objetos: " +areaTotalObjetos);
		
		porcentajeVacio = areaTotalObjetos / areaContenedor;
		porcentajeVacio = porcentajeVacio * 100;
		System.out.println("Porcentaje vacio: " +porcentajeVacio+"%");
		
			if(areaTotalObjetos < areaContenedor){
				System.out.println("No se llenó completo el contenedor");
				res = "No se llenó completo el contenedor";
				bins = bins + 1;
				System.out.println("Se requieren " +bins+ " contenedores");
			}else{
				double cantidadBins = areaTotalObjetos / areaContenedor; //Calculo de contenedores a usar
				System.out.println("Se llenó completo el contenedor");
				res = "Se llenó completo el contenedor";
				System.out.println("Se requieren " +cantidadBins+ " contenedores");
			}
			
			
			time = System.currentTimeMillis();
			
			improvementPhase(args);
			
			time2 = System.currentTimeMillis();
			time4 = time2-time;
			time5 = time4+time3;
			
			Resultados rs = new Resultados();
			Resultados.main(args);
	}
	

	public static void improvementPhase(String [] args){	
		Mejora.main(args);
	}
	
	public static int[][] lectura() {
		File f = new File("bintxt.txt");
		BufferedReader entrada;
		int n = 0;
		int i = 0;
		int [][] xy = null;
		try {
			entrada = new BufferedReader( new FileReader( f ) );
			String linea;

			while((entrada.readLine())!=null){
				n ++;
			}
			entrada.close();

			entrada = new BufferedReader( new FileReader( f ) );
			int n1 = n/2;
			int[] x = new int[n1];
			int[] y = new int[n1];
			while(n != 0){
				linea = entrada.readLine();
				int xxxx = Integer.parseInt(linea);
				//xi = xxxx;
				x[i]=xxxx;
				//System.out.println(x[i]);
				n--;
				linea = entrada.readLine();
				int yyyy = Integer.parseInt(linea);
				y[i] = yyyy;
				//System.out.println(y[i]);
				i++;
				n--;
			}

			xy = new int[n1][2];
			i=0;
			int j = 0;
			for(int fi = 0; fi < n1; fi++){
				for(int c = 0; c < 2; c++ ){
					if(c == 0){
						xy[fi][c]=x[i];
						i+=1;
					}else{
						xy[fi][c]=y[j];
						j+=1;
					}

				}
			}

			for(i = 0; i< n1; i++){
				for( j = 0; j < 2;j++){
					System.out.print(xy[i][j]+" ");
				}
				System.out.println();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return xy;
	}

	private static void verificador() {
		if(xi > yi){
			System.out.println("El objeto " +io+ " está en forma horizontal");
			hor = hor + 1;
		}
		if(xi < yi){
			System.out.println("El objeto " +io+" está en forma vertical");
			ver = ver + 1;
		}
		if(xi == yi){
			System.out.println("El objeto " +io+" es un cubo, no tiene orientacion");
			cubo = cubo + 1;
		}
		io = io + 1;
//		if(areaContenedor >= areaContenedor){
//			repaint();
//		}
	}

	private static void posicionador() {
		puntoInicioX = puntoInicioX + xi;
		if(puntoInicioX >= xc || xi >= xc){
			puntoInicioX = 0;
			puntoInicioY = puntoInicioY + yi;
		}
	}

	
	private static void paint(Graphics g) { //Selector de color para diferenciacion
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
		
		
		g.fillRect(puntoInicioX, puntoInicioY, xi, yi); //Dibujado de rectangulo
		
		//Se crean los objetos y se guardan dentro de un array
		obj[contfo] = new Objeto(contfo,puntoInicioX, puntoInicioY, xi, yi);
		contfo += 1;
		int areaObjeto = xi * yi;
		System.out.println("Area objeto: "+areaObjeto);
		areaTotalObjetos = areaTotalObjetos + areaObjeto;
		System.out.println("Area total objetos: "+areaTotalObjetos);		
	}
	
}
