package Game;



import javax.swing.JFrame;

import LN.clsPausa;


public class VentJuego extends JFrame
{
	private panelJuego pPrincipal;
	final int ancho=700;
	final int alto=500;
	
	static hiloPartida h;
	
	
	public VentJuego(String local, String visi,boolean pausada,clsPausa p)
	{
		
		setSize(ancho,alto);
		setLocationRelativeTo(null);
		setTitle("PONG");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setResizable(false);
		setVisible(true);
		addKeyListener(new escuchaTec());
		
		pPrincipal=new panelJuego(local, visi,this);
		add(pPrincipal);
		
		if(pausada==true)
		{
			pPrincipal.estabaPausada(p.getPosXBola(), p.getPosYBola(), p.getPosYraqL(), p.getPosYraqV(), p.getpL(), p.getpV());
		}
		
		h=new hiloPartida(pPrincipal);
		h.start();
				
	}
		
		
}
	
	
	

