package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Game.VentJuego;
import LN.Jugador;
import LN.clsGestor;
import LN.clsRepException;
import LN.noFicheroException;

public class clsSelec extends JFrame {
	

	public clsSelec() throws noFicheroException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);	
		getContentPane().setLayout(null);
		
		
		String[] nicks=rellenarArrDeJugadores();
		
		JComboBox comboLocal = new JComboBox();
		comboLocal.setModel(new DefaultComboBoxModel(nicks));
		comboLocal.setBounds(31, 80, 104, 20);
		getContentPane().add(comboLocal);
		
		JComboBox comboVis = new JComboBox();
		comboVis.setModel(new DefaultComboBoxModel(nicks));
		comboVis.setBounds(240, 80, 104, 20);
		getContentPane().add(comboVis);
		
		JButton btnJugar = new JButton("JUGAR!");
		btnJugar.setBounds(91, 160, 104, 23);
		getContentPane().add(btnJugar);
		btnJugar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//enviar nicks de jugadores
				if(comboLocal.getSelectedItem()==comboVis.getSelectedItem())
				{
					JOptionPane.showMessageDialog(null, "No se pueden enfrentar los 2 jugadores que ha seleccionado");
				}
				else
				{
					dispose();
					VentJuego v=new VentJuego((String)comboLocal.getSelectedItem(),(String)comboVis.getSelectedItem(),false,null);
				}
			}
		});
		
		JLabel lblJugadorLocal = new JLabel("Jugador LOCAL");
		lblJugadorLocal.setBounds(31, 35, 104, 14);
		getContentPane().add(lblJugadorLocal);
		
		JLabel lblJugadorVisitante = new JLabel("Jugador VISITANTE");
		lblJugadorVisitante.setBounds(248, 35, 111, 14);
		getContentPane().add(lblJugadorVisitante);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(201, 160, 104, 23);
		getContentPane().add(btnCancelar);
		setSize(400,300);
		btnCancelar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});		
	}
	
	public String[] rellenarArrDeJugadores() throws noFicheroException
	{
		ArrayList<Jugador> l=clsGestor.obtenerFichJugador();
		String[] nicks=new String[l.size()]; 
		for(Jugador x:l)
		{
			nicks[x.getId()-1]=x.getNickname();  
		}
		return nicks;
	}
}
