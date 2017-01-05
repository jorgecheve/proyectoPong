package LD;

import java.io.*;

public class clsDatosTxt 
{
	String direccion="src/pausada.txt";
	
	public void escribirFichero(String nL, String nV, int bolaX, int bolaY, int marcL, int marcV)
	{
		String mensaje=nL +" "+nV +" "+bolaX+" "+bolaY;
		try {
			FileWriter fichero=new FileWriter(direccion,true);
			fichero.write("\n"+mensaje);
			fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String leerFichero()
	{
		
		String mensLeido = null;
		try {
			FileReader lector=new FileReader(direccion);
			BufferedReader B= new BufferedReader(lector);
			try {
				mensLeido=B.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mensLeido;
		
	}

}
