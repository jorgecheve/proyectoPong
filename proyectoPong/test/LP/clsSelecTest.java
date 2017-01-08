package LP;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import LN.Jugador;
import LN.clsGestor;
import LN.noFicheroException;

public class clsSelecTest {
	
	clsSelec prueba;
	ArrayList<Jugador> listajug;
	@Test
	public void test() 
	{
		
		try {
			listajug=clsGestor.obtenerFichJugador();
			prueba=new clsSelec();
			String[] array=prueba.rellenarArrDeJugadores();
			
			assertEquals(array.length,listajug.size());
		} catch (noFicheroException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMensaje());
		}
		
		
	}

}
