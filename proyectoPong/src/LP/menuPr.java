package LP;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;





import Game.VentJuego;
import LP.clsInstrucciones;
import LN.clsGestor;
import LN.noFicheroException;


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
		setLayout(null);
		
		
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
				clsGestor.enfrentamientos();
			}
		});
		
		JMenuItem estad2=new JMenuItem ("Listado de los diferentes campeones");
		estadi.add(estad2);
		estad2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{ 
				clsGestor.campeones();
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
