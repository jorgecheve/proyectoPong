package LN;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class clsGestorTest {
	ArrayList<Jugador>lista;
	ArrayList<clsPausa>lista2;
	@Before
	public void before()
	{
		lista=new ArrayList<Jugador>();
		lista2=new ArrayList<clsPausa>();
	}
	@Test
	public void test() {
		try {
			lista=LN.clsGestor.obtenerFichJugador();
		} catch (noFicheroException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMensaje());
		}
		if(lista==null)
		{
			fail("Este método no debería devolver una lista Jugador nula");
		}
	}
	@Test
	public void test2() {
		try {
			lista2=LN.clsGestor.obtenerFichPausa();
		} catch (noFicheroException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMensaje2());
		}
		if(lista==null)
		{
			fail("Este método no debería devolver una lista clsPausa nula");
		}
	}

}
