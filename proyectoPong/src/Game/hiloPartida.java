package Game;


public class hiloPartida extends Thread
{
	private panelJuego partida=new panelJuego(null,null,null);
	public static int dormir=3;
	
	public hiloPartida(panelJuego p)
	{
		this.partida=p;
	}
	
	
	
	public void run()
	{
		 while (true) 
		 {
			 
	            try {
	                Thread.sleep(dormir);
	             
	            } catch (InterruptedException ex) {
	              
	            }
	            
	            partida.repaint();
				
			 
			 
		 }
	}
	
	
}