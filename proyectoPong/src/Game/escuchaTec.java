package Game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class escuchaTec implements KeyListener
{
	//s y x son teclas de subir y bajar del local, y k y m son del visitante
	static boolean s,x,k,m;
	
	static boolean space=false; //Pausar la partida

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	        
	        if (e.getKeyCode() == KeyEvent.VK_S) 
	        {
	            s = true;
	        }
	        if (e.getKeyCode() == KeyEvent.VK_X) 
	        {
	            x = true;
	        }
	        if (e.getKeyCode() == KeyEvent.VK_K) 
	        {
	            k = true;
	        }
	        if (e.getKeyCode() == KeyEvent.VK_M) 
	        {
	            m = true;
	        }
	        if(e.getKeyCode()==KeyEvent.VK_SPACE)
	        {
	        	space=true;
	        }
	      
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		  if (e.getKeyCode() == KeyEvent.VK_S) 
		  {
	            s = false;
	        }
	        if (e.getKeyCode() == KeyEvent.VK_X) 
	        {
	            x = false;
	        }
	        if (e.getKeyCode() == KeyEvent.VK_K) 
	        {
	            k = false;
	        }
	        if (e.getKeyCode() == KeyEvent.VK_M) 
	        {
	            m = false;
	        }
	        if(e.getKeyCode()==KeyEvent.VK_SPACE)
	        {
	        	space=false;
	        }
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
