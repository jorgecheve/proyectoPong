package LP;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import LN.clsGestor;
import LN.clsPausa;
import LN.noFicheroException;

public class clsSelPausadaTest {
	
	clsSelPausada prueba;
	
	@Test
	public void test() 
	{
		try {		
			prueba=new clsSelPausada();
			assertNotNull(prueba.rellenarModelo(prueba.modelo1));
			
		} catch (noFicheroException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMensaje2());
		}
	}

}
