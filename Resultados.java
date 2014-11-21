import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;


public class Resultados {

	private JFrame frame;
	private JTextField TTEjec;
	private JLabel lblAreaTotalDel;
	private JTextField AreaTotal;
	private JLabel lblAreaTotalDe;
	private JTextField AreaTotalObjetos;
	private JTextField porcenVacio;
	private JLabel lblResultado;
	private JTextField BinsReq;
	private JLabel lblBinscontenedoresRequeridos;
	private JTextField ResFinal;
	private JTextField Hor;
	private JTextField Vert;
	private JTextField Cubos;
	private JLabel lblH;
	private JLabel lblV;
	private JLabel lblC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resultados window = new Resultados();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Resultados() {
		initialize();
		setResultados();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 528, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Bin Packing 2D - Resultados");
		frame.setResizable(false);
		
		JLabel lblTiempoTotalDe = new JLabel("Tiempo total de ejecuci\u00F3n:");
		lblTiempoTotalDe.setBounds(10, 11, 182, 14);
		frame.getContentPane().add(lblTiempoTotalDe);
		
		TTEjec = new JTextField();
		TTEjec.setEditable(false);
		TTEjec.setBounds(202, 11, 140, 20);
		frame.getContentPane().add(TTEjec);
		TTEjec.setColumns(10);
		
		lblAreaTotalDel = new JLabel("Area total del contenedor:");
		lblAreaTotalDel.setBounds(10, 36, 182, 14);
		frame.getContentPane().add(lblAreaTotalDel);
		
		AreaTotal = new JTextField();
		AreaTotal.setEditable(false);
		AreaTotal.setBounds(202, 36, 140, 20);
		frame.getContentPane().add(AreaTotal);
		AreaTotal.setColumns(10);
		
		lblAreaTotalDe = new JLabel("Area total de los objetos:");
		lblAreaTotalDe.setBounds(10, 61, 182, 14);
		frame.getContentPane().add(lblAreaTotalDe);
		
		AreaTotalObjetos = new JTextField();
		AreaTotalObjetos.setEditable(false);
		AreaTotalObjetos.setBounds(202, 61, 140, 20);
		frame.getContentPane().add(AreaTotalObjetos);
		AreaTotalObjetos.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 89, 492, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblPorcentajeVacio = new JLabel("Porcentaje vacio:");
		lblPorcentajeVacio.setBounds(90, 102, 114, 14);
		frame.getContentPane().add(lblPorcentajeVacio);
		
		porcenVacio = new JTextField();
		porcenVacio.setEditable(false);
		porcenVacio.setBounds(232, 99, 86, 20);
		frame.getContentPane().add(porcenVacio);
		porcenVacio.setColumns(10);
		
		lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblResultado.setForeground(Color.RED);
		lblResultado.setBounds(10, 155, 98, 14);
		frame.getContentPane().add(lblResultado);
		
		BinsReq = new JTextField();
		BinsReq.setEditable(false);
		BinsReq.setBounds(202, 178, 86, 20);
		frame.getContentPane().add(BinsReq);
		BinsReq.setColumns(10);
		
		lblBinscontenedoresRequeridos = new JLabel("Bins (Contenedores requeridos):");
		lblBinscontenedoresRequeridos.setBounds(10, 181, 206, 14);
		frame.getContentPane().add(lblBinscontenedoresRequeridos);
		
		ResFinal = new JTextField();
		ResFinal.setEditable(false);
		ResFinal.setBounds(90, 153, 334, 20);
		frame.getContentPane().add(ResFinal);
		ResFinal.setColumns(10);
		
		Hor = new JTextField();
		Hor.setEditable(false);
		Hor.setBounds(441, 8, 61, 20);
		frame.getContentPane().add(Hor);
		Hor.setColumns(10);
		
		Vert = new JTextField();
		Vert.setEditable(false);
		Vert.setBounds(441, 33, 61, 20);
		frame.getContentPane().add(Vert);
		Vert.setColumns(10);
		
		Cubos = new JTextField();
		Cubos.setEditable(false);
		Cubos.setBounds(441, 58, 61, 20);
		frame.getContentPane().add(Cubos);
		Cubos.setColumns(10);
		
		lblH = new JLabel("H");
		lblH.setBounds(403, 11, 46, 14);
		frame.getContentPane().add(lblH);
		
		lblV = new JLabel("V");
		lblV.setBounds(403, 36, 46, 14);
		frame.getContentPane().add(lblV);
		
		lblC = new JLabel("C");
		lblC.setBounds(403, 61, 46, 14);
		frame.getContentPane().add(lblC);
	}
	
	private void setResultados() {
		TTEjec.setText(""+Principal.time3+" milisegundos");
		AreaTotal.setText(""+Principal.areaContenedor);
		AreaTotalObjetos.setText(""+Principal.areaTotalObjetos);
		porcenVacio.setText(""+Principal.porcentajeVacio+"%");
		ResFinal.setText(""+Principal.res);
		BinsReq.setText(""+Principal.bins);
		Hor.setText(""+Principal.hor);
		Vert.setText(""+Principal.ver);
		Cubos.setText(""+Principal.cubo);
	}
}
