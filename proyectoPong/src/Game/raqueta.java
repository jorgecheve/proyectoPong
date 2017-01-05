package Game;
import java.awt.geom.Rectangle2D;


public class raqueta 
{
	private int x;
	private int y;
	private final int base=10;
	private final int altura=50;
	private int mueveY=1;
	
	public raqueta(boolean local)
	{
		if(local==true)
		{
			x=20;
		}
		if(local==false)
		{
			x=panelJuego.limAncho-20-10;
		}

		y=(panelJuego.limAlto/2)-altura/2;
	}
	
	public Rectangle2D getRaqueta()
	{
		return new Rectangle2D.Double(x,y,base,altura);
	}
	
	
	public void moverLocal()
	{
		if(y+mueveY<=panelJuego.limAlto-altura && escuchaTec.x==true)
		{
			y=y+mueveY;
		}
		
		if(y-mueveY>=0 && escuchaTec.s==true)
		{
			y=y-mueveY;
		}	
	}
	
	public void moverVisitante()
	{
		if(y+mueveY<=panelJuego.limAlto-altura && escuchaTec.m==true)
		{
			y=y+mueveY;
		}
		
		if(y-mueveY>=0 && escuchaTec.k==true)
		{
			y=y-mueveY;
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

	public int getBase() {
		return base;
	}

	public int getAltura() {
		return altura;
	}
	
	

}
