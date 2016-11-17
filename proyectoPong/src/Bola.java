import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.JLabel;
import javax.swing.JPanel;



public class Bola 
{
	private int x;
	private int y;
	private int xAvanza=1, yAvanza=1;
	private final int lado=20;
	
	public Bola()
	{
		
		x=panelJuego.limAncho/2-lado/2;
		y=panelJuego.limAlto/2-lado/2;
	}
	
	public Rectangle2D getBola()
	{
		return new Rectangle2D.Double(x,y,lado, lado);
	}
	
	public void mover()
	{
		x=x+xAvanza;
		y=y+yAvanza;
		
		if(x+lado>panelJuego.limAncho||x<0)
		{
			xAvanza=-xAvanza;
		}
		
		if(y+lado>panelJuego.limAlto||y<0)
		{
			yAvanza=-yAvanza;
		}
		
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

	public int getxAvanza() {
		return xAvanza;
	}

	public void setxAvanza(int xAvanza) {
		this.xAvanza = xAvanza;
	}

	public int getyAvanza() {
		return yAvanza;
	}

	public void setyAvanza(int yAvanza) {
		this.yAvanza = yAvanza;
	}

	public int getLado() {
		return lado;
	}
	

	
	
	
	
	
	


	
	

}
