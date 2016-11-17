

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentJuego extends JFrame
{
	private panelJuego pPrincipal;
	final int ancho=700;
	final int alto=500;
	
	public VentJuego()
	{
		setSize(ancho,alto);
		setLocationRelativeTo(null);
		setTitle("PONG");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setResizable(false);
		setVisible(true);
		addKeyListener(new escuchaTec());
		
		pPrincipal=new panelJuego();
		add(pPrincipal);
		pPrincipal.hiloJuego();
		

		
		
		
		
	}
	
	public static void main(String[] args)
	{
		VentJuego v= new VentJuego();
		
		
	}
}
