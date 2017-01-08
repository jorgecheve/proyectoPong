package LN;

public class noFicheroException extends Exception
{
	private final String mensaje="Aún no existe ningún fichero jugador";
	private final String mensaje2="No hay partidas guardadas";

	public String getMensaje() 
	{

		return mensaje;
	}
	public String getMensaje2()
	{
		return mensaje2;
	}

	
	
	
			

}
