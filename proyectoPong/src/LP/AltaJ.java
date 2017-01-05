package LP;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import LN.clsGestor;
import LN.clsRepException;


public class AltaJ extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the frame.
	 */
	public AltaJ() 
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(700,500);	
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(206, 102, 210, 27);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(206, 169, 210, 27);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBounds(193, 310, 111, 23);
		getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(textField.getText().isEmpty()||textField_1.getText().isEmpty()||textField_2.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Hay algún campo de texto vacío, rellénelo");
				}else
				{
					//Dar de alta a un jugador
					try {
						clsGestor.altaJugador(textField.getText(), textField_1.getText(),textField_2.getText() );
						dispose();
						
					} catch (clsRepException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e.getMensaje());
					}
				}
			}
		});
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(329, 310, 111, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{ dispose();			
			}
		});
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(66, 108, 80, 14);
		getContentPane().add(lblNombre);
		
		JLabel label = new JLabel("");
		label.setBounds(66, 191, 46, 14);
		getContentPane().add(label);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(66, 175, 80, 14);
		getContentPane().add(lblApellido);
		
		textField_2 = new JTextField();
		textField_2.setBounds(206, 226, 210, 27);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel nick = new JLabel("NICKNAME");
		nick.setBounds(66, 232, 60, 14);
		getContentPane().add(nick);
		
	}
}
