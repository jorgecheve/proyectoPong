package LN;

import java.io.Serializable;

public class clsPausa implements Serializable
{
	private String nLocal;
	private String nVisi;
	private int pL;
	private int pV;
	private int posXBola; private int posYBola;
	private int posYraqL; private int posYraqV;
	private String fechaHora;

	public clsPausa(String nLocal, String nVisi,int posXBola,int posYBola, int pL, int pV,  int posYraqL, int posYraqV, String fechaHora) 
	{
		this.nLocal = nLocal;
		this.nVisi = nVisi;
		this.pL = pL;
		this.pV = pV;
		this.posXBola = posXBola;
		this.posYBola = posYBola;
		this.posYraqL = posYraqL;
		this.posYraqV = posYraqV;
		this.fechaHora=fechaHora;
	}
	
	

	public String getnLocal() {
		return nLocal;
	}



	public void setnLocal(String nLocal) {
		this.nLocal = nLocal;
	}



	public String getnVisi() {
		return nVisi;
	}



	public void setnVisi(String nVisi) {
		this.nVisi = nVisi;
	}



	public int getpL() {
		return pL;
	}



	public void setpL(int pL) {
		this.pL = pL;
	}



	public int getpV() {
		return pV;
	}



	public void setpV(int pV) {
		this.pV = pV;
	}



	public int getPosXBola() {
		return posXBola;
	}



	public void setPosXBola(int posXBola) {
		this.posXBola = posXBola;
	}



	public int getPosYBola() {
		return posYBola;
	}



	public void setPosYBola(int posYBola) {
		this.posYBola = posYBola;
	}



	public int getPosYraqL() {
		return posYraqL;
	}



	public void setPosYraqL(int posYraqL) {
		this.posYraqL = posYraqL;
	}



	public int getPosYraqV() {
		return posYraqV;
	}



	public void setPosYraqV(int posYraqV) {
		this.posYraqV = posYraqV;
	}



	public String getFechaHora() {
		return fechaHora;
	}



	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}



	@Override
	public String toString() {
		return nLocal +": "+pL+" - " + nVisi + ": " + pV+" a las "+ fechaHora;
	}
	
	
	
	
	

}
