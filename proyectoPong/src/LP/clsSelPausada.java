package LP;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
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
	

	public clsSelPausada() throws noFicheroException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		this.getContentPane().setLayout(null);		
		modelo1=new DefaultListModel<clsPausa>();
		lista=new ArrayList<clsPausa>();
		
		
		lista=clsGestor.obtenerFichPausa();
		
		Componentes();
		
		jListaPartidas.addListSelectionListener(this);
		/*for(int i=0;i<lista.size();i++)
		{
			modelo1.addElement(lista.get(i));
		}*/
		modelo1=rellenarModelo(modelo1);
		setVisible(true);
		
	}
	
	
	public JList<clsPausa> getjListaPartidas() {
		return jListaPartidas;
	}


	public DefaultListModel<clsPausa>rellenarModelo(DefaultListModel<clsPausa> m)
	{
		for(int i=0;i<lista.size();i++)
		{
			m.addElement(lista.get(i));
		}
		return m;
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
					int indice=0;
					for(int i=0;i<lista.size();i++)
					{
						if(jListaPartidas.getSelectedValue().getFechaHora()==lista.get(i).getFechaHora())
						{
							indice=i;
						}
					}
					
					VentJuego v=new VentJuego(lista.get(indice).getnLocal(),lista.get(indice).getnVisi(),true,lista.get(indice));
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
