package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

import Game.VentJuego;
import Game.hiloPartida;

public class clsConfi extends JFrame {

	public clsConfi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		String[] niveles={"Principiante","Medio","Avanzado","Profesional"};
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(188, 96, 123, 28);
		comboBox.setModel(new DefaultComboBoxModel(niveles));
		getContentPane().add(comboBox);
		
		JLabel lblNivelDeDificultad = new JLabel("Nivel de dificultad");
		lblNivelDeDificultad.setBounds(62, 96, 116, 28);
		getContentPane().add(lblNivelDeDificultad);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBounds(131, 173, 108, 23);
		getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				if(comboBox.getSelectedItem().toString()=="Principiante")
				{
					hiloPartida.dormir=7;
					dispose();
				}
				if(comboBox.getSelectedItem().toString()=="Medio")
				{
					hiloPartida.dormir=5;
					dispose();
				}
				if(comboBox.getSelectedItem().toString()=="Avanzado")
				{
					hiloPartida.dormir=3;
					dispose();
				}
				if(comboBox.getSelectedItem().toString()=="Profesional")
				{
					hiloPartida.dormir=1;
					dispose();
				}
				
				
			}
		});
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(262, 173, 108, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});
		
		
	}
}
