package LP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;








import org.sqlite.SQLiteException;

import Game.VentJuego;
import LP.clsInstrucciones;
import LN.clsGestor;
import LN.noFicheroException;
import javax.swing.JLabel;
import java.awt.Font;


public class menuPr extends JFrame {

	
	VentJuego v;
	AltaJ aj;
	clsSelec selec;
	clsInstrucciones frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					menuPr frame = new menuPr();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public menuPr() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(700,500);		
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		
		JLabel lblPongGame = new JLabel("PONG GAME");
		lblPongGame.setFont(new Font("Cooper Black", Font.PLAIN, 44));
		lblPongGame.setForeground(Color.WHITE);
		lblPongGame.setBounds(189, 107, 317, 139);
		getContentPane().add(lblPongGame);
		
		JLabel lblRealizadoPorIgnacio = new JLabel("Realizado por:  Ignacio garbizu, Mikel Aguiriano & Jorge Echeverr\u00EDa.");
		lblRealizadoPorIgnacio.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		lblRealizadoPorIgnacio.setForeground(Color.WHITE);
		lblRealizadoPorIgnacio.setBounds(203, 400, 471, 30);
		getContentPane().add(lblRealizadoPorIgnacio);
		
		
		JMenuBar menuBar=new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu juego=new JMenu("Juego");
		menuBar.add(juego);
		
		JMenuItem jugar=new JMenuItem("Jugar");
		juego.add(jugar);
		jugar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{ 
				//setVisible(false);	
				try {
					selec=new clsSelec();
					selec.setVisible(true);
				} catch (noFicheroException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMensaje());
				}			
			}
		});
		JMenuItem pausada=new JMenuItem("Partidas pausadas");
		juego.add(pausada);
		pausada.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{ 
				try {
					clsSelPausada v=new clsSelPausada();
				} catch (noFicheroException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMensaje2());
				}
			}
		});
		
		JMenuItem config=new JMenuItem("Configuración");
		juego.add(config);
		config.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{ 
				
				clsConfi c=new clsConfi();
				c.setVisible(true);
				
			}
		});
		
		JMenu alta=new JMenu("Usuario");
		menuBar.add(alta);
		
		JMenuItem a=new JMenuItem("Dar de alta jugador");
		alta.add(a);
		a.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{ 
				//setVisible(false);	
				aj=new AltaJ();			
				aj.setVisible(true);
			}
		});
		
		JMenu estadi=new JMenu("Estadísticas");
		menuBar.add(estadi);
		
		JMenuItem prueba=new JMenuItem ("Todos los enfrentamientos");
		estadi.add(prueba);
		prueba.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{ 
				try {
					clsGestor.enfrentamientos();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null, "No hay estadísticas");
				}			
			}
		});
		
		JMenuItem estad2=new JMenuItem ("Listado de los diferentes campeones");
		estadi.add(estad2);
		estad2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{ 
				try {
					clsGestor.campeones();
				} catch ( SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null, "No hay estadísticas");
				}
			}
		});
		
		JMenuItem estad3=new JMenuItem ("Partidas ganadas por cada jugador");
		estadi.add(estad3);
		estad3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{ 
				try {
					clsGestor.partGan();
				} catch ( SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null, "No hay estadísticas");
				}
			}
		});
		
		JMenuItem estad4=new JMenuItem ("Goles marcados por cada jugador");
		estadi.add(estad4);
		estad4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{ 
				try {
					clsGestor.goles();
				} catch ( SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null, "No hay estadísticas");
				}
			}
		});
		
		
		JMenu inst=new JMenu("Instrucciones");
		menuBar.add(inst);
		JMenuItem ver=new JMenuItem("Ver instrucciones");
		inst.add(ver);
		ver.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{ 
				frame = new clsInstrucciones();
				frame.setVisible(true);
			}
		});
	
	}
}
