package Game;


public class hiloPartida extends Thread
{
	private panelJuego partida=new panelJuego(null,null,null);
	
	
	public hiloPartida(panelJuego p)
	{
		this.partida=p;
	}
	
	
	
	public void run()
	{
		 while (true) 
		 {
			 
	            try {
	                Thread.sleep(3);
	             
	            } catch (InterruptedException ex) {
	              
	            }
	            
	            partida.repaint();
				
			 
			 
		 }
	}
	
	
}