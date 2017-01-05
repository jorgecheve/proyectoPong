package Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import LN.clsGestor;
import LN.noFicheroException;
import LP.AltaJ;
import LP.clsSelec;


public class panelJuego extends JPanel 
{
	//limites anchura y altura 694.0;472.0 Ya que el tamaño del panel es un poco inferior al de la ventana.
	static final int limAncho=694;
	static final int limAlto=472;
	
	
	private Bola bola;
	private raqueta local;
	private raqueta visitante;
	
	private int marcLoc=0;
	private int marcVis=0;
	private String nickL;
	private String nickV;
	
	private JLabel mLo;
	private JLabel mVi;
	private JButton guardar;
		
	private JPanel marcadores;
	private JFrame v;
	
	
	public panelJuego(String loc, String visi,JFrame ven)
	{
		setLayout(null);
		setBackground(Color.WHITE);
			
		bola=new Bola();
		local=new raqueta(true);
		visitante=new raqueta(false);
		
		marcadores=new JPanel();
		marcadores.setLayout(null);
		marcadores.setBounds(limAncho/2-100,1, 200, 40);
		marcadores.setBackground(Color.WHITE);
		marcadores.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		nickL=loc;
		nickV=visi;
		
		this.add(marcadores);
		
		mLo= new JLabel(nickL+":"+"0");
		mVi=new JLabel(nickV+":"+"0");
		//guardar=new JButton("G");
		
		marcadores.add(mVi);
		marcadores.add(mLo);
		//marcadores.add(guardar);
		
		
		
		mLo.setBounds(10, 10, 80, 20);
		mVi.setBounds(110, 10, 80, 20);  
		//guardar.setBounds(195, 10, 50, 20);
		
		v=ven;	//La ventana donde se encuentra este panel.
		
		
		/*guardar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{ 
				clsGestor.guardarPausado(nickL, nickV, bola.getX(), bola.getY());
				v.dispose();
			}
		});*/
		
		
			
	}
	
	@Override
	protected void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
		
		Graphics2D g2=(Graphics2D) arg0;
		g2.setColor(Color.BLACK);
		
		dibujar(g2);
		
		actualizar();
		
		choque();
		
		gol();
		
		guarYsalir();
		
	}

	public void dibujar(Graphics2D g)
	{
		g.fill(bola.getBola());
		g.fill(local.getRaqueta());
		g.fill(visitante.getRaqueta());
		
	}
	
	public void actualizar ()
	{
		bola.mover();
		local.moverLocal();
		visitante.moverVisitante();
		
		
	}
	
	public void choque()
	{
		if
		(bola.getX()+bola.getLado()/2==local.getX()+local.getBase() &&  //que la bola este a la misma altura en x
				((local.getY()+local.getAltura()>=bola.getY() && bola.getY()>=local.getY())  //que la parte de arriba de la bola este entre los extremos de la raq
				||(local.getY()+local.getAltura()>=bola.getY()+bola.getLado() && bola.getY()+bola.getLado()>=local.getY()) //OR que la parte de abajo de la bola se encuentre ahi
				)
		) 
		{
			bola.setxAvanza(-bola.getxAvanza());
		}
		
		if
		(bola.getX()+bola.getLado()/2==visitante.getX() && 
				((visitante.getY()+visitante.getAltura()>=bola.getY()	 && 	bola.getY()>=visitante.getY())
				||	(visitante.getY()+visitante.getAltura()>=bola.getY()+bola.getLado() 	&& 	bola.getY()+bola.getLado()>=visitante.getY())	
				)
		)
		{
			bola.setxAvanza(-bola.getxAvanza());
		}
	}
	
	public void gol()
	{
		if(bola.getX()==0)
		{
			bola.setX(limAncho/2);
			bola.setY(limAlto/2);
			
			marcVis++;
			mVi.setText(nickV+":"+String.valueOf(marcVis));
			
		}
		
		if (bola.getX()==limAncho-bola.getLado())
		{
			bola.setX(limAncho/2);
			bola.setY(limAlto/2);
			
			marcLoc++;
			mLo.setText(nickL+":"+String.valueOf(marcLoc));
		}
		
		if(marcVis==10||marcLoc==10)
		{
			
			v.dispose();
			clsGestor.partidaTerminada(nickL, nickV, marcLoc, marcVis);
			//JOptionPane.showMessageDialog(null, "El resultado ha sido: LOCAL:"+String.valueOf(marcLoc)+" - VISITANTE:"+String.valueOf(marcVis));
			/*marcVis=0;
			marcLoc=0;
			mLo.setText(nickL+":"+String.valueOf(marcLoc));
			mVi.setText(nickV+":"+String.valueOf(marcVis));*/		
			
		}
	}
	
	public void guarYsalir()
	{
		if(escuchaTec.space==true)
		{
			clsGestor.guardarPausado(nickL, nickV,marcLoc,marcVis, bola.getX(), bola.getY(),local.getY(),visitante.getY(),null);
			v.dispose();
		}
	}
	
	public void estabaPausada(int bolaX,int bolaY,int raqL,int raqV,int pL,int pV)
	{
		bola.setX(bolaX);
		bola.setY(bolaY);
		local.setY(raqL);
		visitante.setY(raqV);
		marcLoc=pL;
		mLo.setText(nickL+":"+String.valueOf(marcLoc));
		marcVis=pV;
		mVi.setText(nickV+":"+String.valueOf(marcVis));
	}
	
	
	
	
}
