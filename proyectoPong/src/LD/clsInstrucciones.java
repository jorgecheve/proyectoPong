package LD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import LN.clsGestor;

public class clsInstrucciones extends JFrame {

	private JPanel contentPane;

	public clsInstrucciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		
		JLabel lblInstruccionesDelPong = new JLabel("INSTRUCCIONES DEL PONG");
		lblInstruccionesDelPong.setFont(new Font("Showcard Gothic", Font.PLAIN, 16));
		lblInstruccionesDelPong.setBounds(22, 30, 304, 50);
		lblInstruccionesDelPong.setForeground(Color.WHITE);
		getContentPane().add(lblInstruccionesDelPong);
		
		JLabel lblParaMoverRaquetas = new JLabel("Para mover raquetas: Teclas S y X\r\n");
		lblParaMoverRaquetas.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		lblParaMoverRaquetas.setBounds(22, 96, 352, 59);
		lblParaMoverRaquetas.setForeground(Color.WHITE);
		getContentPane().add(lblParaMoverRaquetas);
		
		JLabel lblTeclasL = new JLabel("& Teclas L y N");
		lblTeclasL.setForeground(Color.WHITE);
		lblTeclasL.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		lblTeclasL.setBounds(166, 141, 139, 39);
		getContentPane().add(lblTeclasL);
		
		JLabel lblParaPausarY = new JLabel("Para pausar y guardar partida: Barra espaciadora\r\n");
		lblParaPausarY.setForeground(Color.WHITE);
		lblParaPausarY.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		lblParaPausarY.setBounds(22, 183, 352, 59);
		getContentPane().add(lblParaPausarY);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBounds(143, 277, 89, 23);
		getContentPane().add(btnAceptar);
		setSize(400,400);
		btnAceptar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{ 
				dispose();
			}
		});
	}
}
