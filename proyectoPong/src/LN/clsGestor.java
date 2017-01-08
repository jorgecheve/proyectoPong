package LN;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

import javax.swing.JOptionPane;

import org.sqlite.SQLiteException;

import LD.BaseDeDatos;
import LD.clsConstantes.enficdatos;
import LD.clsDatos;
import LP.TablaEstad;



public class clsGestor 
{
	
	
	public static void altaJugador(String nom, String ape, String nick) throws clsRepException
	{
		HashSet<Jugador> jugones=new HashSet<Jugador>();
		try {
			jugones.addAll(clsGestor.obtenerFichJugador());
		} catch (noFicheroException e) {
			// TODO Auto-generated catch block
			e.getMensaje();
		}
		int id=1;
		if(jugones.size()!=0)
		{
			for(Jugador x:jugones)
			{
				if(x.getId()>=id)
				{
					id=x.getId()+1;
				}
			}
		}
		
		
		Jugador j= new Jugador(nom,ape,nick,id);
			
		boolean repetido;
		repetido=jugones.add(j);
		if(repetido==true)
		{
			clsDatos objDatos=new clsDatos();
			objDatos.ComenzarSave(enficdatos.FICHERO_JUGADOR);
			objDatos.Save(j);
			objDatos.TerminarSave();
		}else if(repetido==false)
		{
			throw new clsRepException();
		}
		
		BaseDeDatos.initBD("pong game");
		BaseDeDatos.crearTablaJugador();
		BaseDeDatos.insertJugador(nick, nom, ape, id);
		//BaseDeDatos.selectJugador();
		BaseDeDatos.close();
	}
	
	public static ArrayList<Jugador>obtenerFichJugador() throws noFicheroException
	{
		clsDatos objDatos=new clsDatos();
		ArrayList<Jugador>listajugadores=new ArrayList<Jugador>();
		
		objDatos.ComenzarRead(enficdatos.FICHERO_JUGADOR);
		
		for(Serializable x:objDatos.Read())
			{
				listajugadores.add((Jugador)x);
			}
			
		objDatos.TerminarRead();
		
		return listajugadores;
	}
	
	public static void partidaTerminada(String jloc, String jvis, int p1,int p2)
	{
		JOptionPane.showMessageDialog(null, "El resultado ha sido: "+jloc+": "+String.valueOf(p1)+" - "+jvis+": "+String.valueOf(p2));
		
		Calendar cal1 = Calendar.getInstance();
		String fecha= String.valueOf(cal1.get(Calendar.DATE))+"/"+String.valueOf(cal1.get(Calendar.MONTH)+1)+
				"/"+String.valueOf(cal1.get(Calendar.YEAR));
		String hora=String.valueOf(cal1.get(Calendar.HOUR))+":"+String.valueOf(cal1.get(Calendar.MINUTE))
				+":"+String.valueOf(cal1.get(Calendar.SECOND));
		
	   
		//Introducir en l base de datos
		BaseDeDatos.initBD("pong game");
		BaseDeDatos.crearTablaPartida();
		BaseDeDatos.insertPartida(fecha, hora);
		
		BaseDeDatos.crearTablaJuega();
		BaseDeDatos.insertJuega(jloc, fecha+" "+hora, p1, "local");
		BaseDeDatos.insertJuega(jvis, fecha+" "+hora, p2, "visitante");
		//BaseDeDatos.selectJuega();
		BaseDeDatos.close();			
	}
	
	public static void guardarPausado(String nL, String nV, int bolaX, int bolaY,int marcL,int marcV, int raqL, int raqV,String fechaHora)
	{
		String fechahora;
		if(fechaHora==null)
		{
			Calendar cal1 = Calendar.getInstance();
			String fecha= String.valueOf(cal1.get(Calendar.DATE))+"/"+String.valueOf(cal1.get(Calendar.MONTH)+1)+
					"/"+String.valueOf(cal1.get(Calendar.YEAR));
			String hora=String.valueOf(cal1.get(Calendar.HOUR))+":"+String.valueOf(cal1.get(Calendar.MINUTE))
					+":"+String.valueOf(cal1.get(Calendar.SECOND));
			fechahora=fecha+" "+hora;
		}
		else
		{fechahora=fechaHora;
		}
		
		
		clsPausa pausa=new clsPausa (nL,nV,bolaX,bolaY,marcL,marcV,raqL,raqV,fechahora);
		
		clsDatos objDatos=new clsDatos();
		objDatos.ComenzarSave(enficdatos.FICHERO_PAUSA);
		objDatos.Save(pausa);
		objDatos.TerminarSave();
	}
	
	public static ArrayList<clsPausa>obtenerFichPausa() throws noFicheroException
	{
		clsDatos objDatos=new clsDatos();
		ArrayList<clsPausa>listapausa=new ArrayList<clsPausa>();
		
		objDatos.ComenzarRead(enficdatos.FICHERO_PAUSA);
		
		for(Serializable x:objDatos.Read())
			{
				listapausa.add((clsPausa)x);
			}
			
		objDatos.TerminarRead();
		
		return listapausa;
	}
	
	public static void elimPausadas(int index, ArrayList<clsPausa>lista)
	{
	
		lista.remove(index);
				
		clsDatos objDatos=new clsDatos();
		objDatos.ResetFile(enficdatos.FICHERO_PAUSA);
		
		for(clsPausa x:lista)
		{
			guardarPausado(x.getnLocal(),x.getnVisi(),x.getPosXBola(),x.getPosYBola(),x.getpL(),x.getpV(),x.getPosYraqL(),x.getPosYraqV(),x.getFechaHora());
			
		}
	}
	
	public static void enfrentamientos() throws SQLException
	{
		TablaEstad t=new TablaEstad();
		BaseDeDatos.select(t, "select a.nickname,a.goles, b.nickname, b.goles, a.fechahora from juega a, juega b "
				+ "where a.fechahora=b.fechahora and a.nickname<> b.nickname and a.papel='local' and b.papel='visitante';"); //TODOS LOS ENFRENTAMIENTOS Y SUS RESULTADOS
		
		t.pack();
		t.setVisible(true);
		
	}
	public static void campeones() throws SQLException
	{
		TablaEstad t=new TablaEstad();	
		BaseDeDatos.select(t, "select distinct j.nombre, j.apellido, j.nickname from jugador j, juega jg where j.nickname=jg.nickname and jg.goles=10 ;"); //Los diferentes campeones que ha habido
		
		t.pack();
		t.setVisible(true);	
	}
	
	public static void partGan() throws SQLException
	{
		TablaEstad t=new TablaEstad();	
		BaseDeDatos.select(t, "select nickname, count(*) from juega where goles=10 group by nickname;");  //Numero de victorias por cada jugador			
		t.pack();
		t.setVisible(true);	
	}
	
	public static void goles() throws SQLException //goles marcados por cada jugador
	{
		TablaEstad t=new TablaEstad();	
		BaseDeDatos.select(t, "select j.nombre,j.apellido,ju.nickname, sum(ju.goles) from juega ju, jugador j where j.nickname=ju.nickname group by ju.nickname;");	
		t.pack();
		t.setVisible(true);	
	}

}
