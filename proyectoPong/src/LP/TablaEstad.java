package LP;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.lang.reflect.Array;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TablaEstad extends JFrame
{
	DefaultTableModel modelo;
	JTable tabla;
	JPanel panel;
	
	public TablaEstad()
	{
		
		//super(new GridLayout(1,0));
		modelo = new DefaultTableModel();
		tabla = new JTable(modelo);
		panel=new JPanel();
		
		panel.setLayout(new GridLayout(1,0));
		panel.setOpaque(true);
		this.setContentPane(panel);
		
	        tabla.setPreferredScrollableViewportSize(new Dimension(500,100));
	        tabla.setFillsViewportHeight(true);
	        panel.add(tabla);
	      //Create the scroll pane and add the table to it.
	        JScrollPane scrollPane = new JScrollPane(tabla);
	 
	        //Add the scroll pane to this panel.
	        panel.add(scrollPane);
	}
	
	public void addFila(Object[]f)
	{
		modelo.addRow(f);
	}
	public DefaultTableModel getModelo()
	{
		return modelo;
	}
}
