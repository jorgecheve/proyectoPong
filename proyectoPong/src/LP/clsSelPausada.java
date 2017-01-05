package LP;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Game.VentJuego;
import LN.clsGestor;
import LN.clsPausa;
import LN.clsRepException;
import LN.noFicheroException;

import javax.swing.JButton;
import javax.swing.JLabel;


public class clsSelPausada extends JFrame implements ListSelectionListener{
	
	protected DefaultListModel<clsPausa> modelo1;
	private JList <clsPausa> jListaPartidas;
	private ArrayList <clsPausa> lista;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clsSelPausada frame = new clsSelPausada();
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
	public clsSelPausada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		this.getContentPane().setLayout(null);		
		modelo1=new DefaultListModel<clsPausa>();
		lista=new ArrayList<clsPausa>();
		
		try {
			lista=clsGestor.obtenerFichPausa();
		} catch (noFicheroException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "No hay partidas guardadas");
			this.dispose();
		}
		Componentes();
		
		jListaPartidas.addListSelectionListener(this);
		for(int i=0;i<lista.size();i++)
		{
			modelo1.addElement(lista.get(i));
		}
		setVisible(true);
		
	}
	
	public void Componentes()
	{
		jListaPartidas=new JList<clsPausa>(modelo1);
		jListaPartidas.setBounds(30, 58, 375, 280);
		getContentPane().add(jListaPartidas);
		
		JButton btnJugar = new JButton("JUGAR!");
		btnJugar.setBounds(93, 349, 109, 23);
		getContentPane().add(btnJugar);
		btnJugar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				if(jListaPartidas.isSelectionEmpty()==false)
				{
					VentJuego v=new VentJuego(jListaPartidas.getSelectedValue().getnLocal(),jListaPartidas.getSelectedValue().getnVisi(),true,jListaPartidas.getSelectedValue());
					clsGestor.elimPausadas(jListaPartidas.getSelectedIndex(),lista);
					dispose();
				}					
			}			
		});
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(244, 349, 109, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub					
				dispose();			
			}			
		});
		
		JLabel peticion = new JLabel("Selecciones una de las partidas guardadas:");
		peticion.setBounds(30, 11, 323, 21);
		getContentPane().add(peticion);
		
		
	}
	

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (e.getValueIsAdjusting()==false)
		{
			repaint();
			
		}
	}

}
