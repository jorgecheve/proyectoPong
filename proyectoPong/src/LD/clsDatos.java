package LD;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import LN.noFicheroException;


public class clsDatos 
{
	private static String setFichero(LD.clsConstantes.enficdatos fichero)
	{
		switch(fichero)
		{
		case FICHERO_JUGADOR:
			return "src/jugadores.dat";
		case FICHERO_PAUSA:
			return "src/pausa.dat";
		
			
		}
		return null;
		
	}
	
	FileOutputStream fos;
	AppendableObjectOutputStream aos;
	ObjectOutputStream oos;
	
	public void ComenzarSave(LD.clsConstantes.enficdatos ficherox)
	{
		File fichero=new File(setFichero(ficherox));
		
		
		if(fichero.exists()==true)
		{
			
			try 
			{
				fos = new FileOutputStream(fichero,true);
				aos=new AppendableObjectOutputStream(fos);
			} catch (FileNotFoundException e ) 
			{
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}else
		{
			
			try {
				fos = new FileOutputStream(fichero);
				oos = new ObjectOutputStream(fos);
				}
			catch (FileNotFoundException e) 
				{
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			catch (IOException e) 
				{
				// TODO Auto-generated catch block
				e.printStackTrace();
				}	
		}
		
		
	}
	
	public void Save(Serializable o)
	{
		if(oos!=null)
		{
			try {
				oos.writeObject(o);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(aos!=null)
		{
			try {
				aos.writeObject(o);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void TerminarSave()
	{
		if(oos!=null)
		{
			try 
			{
				oos.close();
				
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(aos!=null)
		{
			try 
			{
				aos.close();
				
				
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	FileInputStream fis;
	ObjectInputStream ois;
	
	public void ComenzarRead(LD.clsConstantes.enficdatos ficherox) throws noFicheroException
	{
		File fichero=new File(setFichero (ficherox));
		if(fichero.exists()==true)
		{
			try 
			{
				fis=new FileInputStream(fichero);
				ois=new ObjectInputStream(fis);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		{
			throw new noFicheroException();
		}
		
	}
	
	
	public ArrayList<Serializable>Read() 
	{
		
		ArrayList<Serializable>read=new ArrayList<Serializable>();
		Serializable retorno;
		try {
			
			while((retorno=(Serializable)ois.readObject())!=null)
			{
				read.add((Serializable)retorno);	
			}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (EOFException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	
		return read;
	}
	
	public void TerminarRead()
	{
		if(ois!=null)
		{
			try 
			{
				ois.close();
				
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void ResetFile(LD.clsConstantes.enficdatos ficherox)
	{
		File fichero=new File(setFichero(ficherox));
		fichero.delete();
	}
	

}
