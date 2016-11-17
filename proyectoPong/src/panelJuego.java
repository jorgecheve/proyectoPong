import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;


public class panelJuego extends JPanel 
{
	//limites anchura y altura 694.0;472.0 Ya que el tamño del panel es un poco inferior al de la ventana.
	static final int limAncho=694;
	static final int limAlto=472;
	
	
	private Bola bola=new Bola();
	private raqueta local=new raqueta(true);
	private raqueta visitante=new raqueta(false);
	
	private int marcLoc;
	private int marcVis;
	
	
	public panelJuego()
	{
		setBackground(Color.WHITE);
		
	}
	
	@Override
	protected void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
		
		Graphics2D g2=(Graphics2D) arg0;
		g2.setColor(Color.BLACK);
		
		dibujar(g2);
		
		actualizar();
		
		choque();
		
		gol();
		
	}

	public void dibujar(Graphics2D g)
	{
		g.fill(bola.getBola());
		g.fill(local.getRaqueta());
		g.fill(visitante.getRaqueta());
		
	}
	
	public void actualizar ()
	{
		bola.mover();
		local.moverLocal();
		visitante.moverVisitante();
		
		
	}
	
	public void choque()
	{
		if
		(bola.getX()+bola.getLado()/2==local.getX()+local.getBase() &&  //que la bola este a la misma altura en x
				((local.getY()+local.getAltura()>=bola.getY() && bola.getY()>=local.getY())  //que la parte de arriba de la bola este entre los extremos de la raq
				||(local.getY()+local.getAltura()>=bola.getY()+bola.getLado() && bola.getY()+bola.getLado()>=local.getY()) //OR que la parte de abajo de la bola se encuentre ahi
				)
		) 
		{
			bola.setxAvanza(-bola.getxAvanza());
		}
		
		if
		(bola.getX()+bola.getLado()/2==visitante.getX() && 
				((visitante.getY()+visitante.getAltura()>=bola.getY()	 && 	bola.getY()>=visitante.getY())
				||	(visitante.getY()+visitante.getAltura()>=bola.getY()+bola.getLado() 	&& 	bola.getY()+bola.getLado()>=visitante.getY())	
				)
		)
		{
			bola.setxAvanza(-bola.getxAvanza());
		}
	}
	
	public void gol()
	{
		if(bola.getX()==0)
		{
			bola.setX(limAncho/2);
			bola.setY(limAlto/2);
			
			marcLoc++;
		}
		
		if (bola.getX()==limAncho-bola.getLado())
		{
			bola.setX(limAncho/2);
			bola.setY(limAlto/2);
			
			marcVis++;
		}
	}
	
	 public void hiloJuego() {
      while (true) {
           try {
               repaint();
               Thread.sleep(5);
           } catch (InterruptedException ex) {
               Logger.getLogger(panelJuego.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
   }
	
	
	
	
	
	
	
}
