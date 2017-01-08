package LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import LP.TablaEstad;

public class BaseDeDatos {

	private static Connection connection = null;
	private static Statement statement = null;

	/** Inicializa una BD SQLITE y devuelve una conexión con ella. Debe llamarse a este 
	 * método antes que ningún otro, y debe devolver no null para poder seguir trabajando con la BD.
	 * @param nombreBD	Nombre de fichero de la base de datos
	 * @return	Conexión con la base de datos indicada. Si hay algún error, se devuelve null
	 */
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    connection = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
		    return connection;
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog( null, "Error de conexión!! No se ha podido conectar con " + nombreBD , "ERROR", JOptionPane.ERROR_MESSAGE );
			System.out.println( "Error de conexión!! No se ha podido conectar con " + nombreBD );
			return null;
		}
	}
	
	/** Cierra la conexión con la Base de Datos
	 */
	public static void close() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Devuelve la conexión si ha sido establecida previamente (#initBD()).
	 * @return	Conexión con la BD, null si no se ha establecido correctamente.
	 */
	public static Connection getConnection() {
		return connection;
	}
	
	/** Devuelve una sentencia para trabajar con la BD,
	 * si la conexión si ha sido establecida previamente (#initBD()).
	 * @return	Sentencia de trabajo con la BD, null si no se ha establecido correctamente.
	 */
	public static Statement getStatement() {
		return statement;
	}

	
	public static void crearTablaJugador() 
	{
		if (statement==null) return;
		try {
			statement.executeUpdate("create table jugador " +
				"(nickname string, nombre string, apellido string" +
				", id int)");
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	public static void crearTablaPartida()
	{
		if (statement==null) return;
		try {
			statement.executeUpdate("create table partida " +
				"(fecha string, hora string)");
			
			
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	public static void crearTablaJuega()
	{
		if (statement==null) return;
		try {
			statement.executeUpdate("create table juega " +
				"(nickname string, fechahora string, goles int, papel string)");
			
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}	
	}
	
	public static void insertJuega(String nickname, String fechahora, int goles, String papel)
	{
		if (statement==null) return;
		String i="insert into juega (nickname, fechahora, goles, papel) values(?,?,?,?)";
		
		try {
			 PreparedStatement pstmt = connection.prepareStatement(i);
			// getConnection();
			 pstmt.setString(1,nickname);
			 pstmt.setString(2, fechahora);
			 pstmt.setInt(3, goles);
			 pstmt.setString(4, papel);
			 pstmt.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insertPartida(String fecha, String hora)
	{
		if (statement==null) return;
		String i="insert into partida (fecha, hora) values(?,?)";
		
		try {
			 PreparedStatement pstmt = connection.prepareStatement(i);
			 pstmt.setString(1,fecha);
			 pstmt.setString(2, hora);
			 pstmt.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insertJugador(String nickname, String nom, String ape, int id)
	{
		if (statement==null) return;
		String i="insert into jugador (nickname, nombre, apellido, id) values(?,?,?,?)";
		
		try {
			 PreparedStatement pstmt = connection.prepareStatement(i);
			 pstmt.setString(1,nickname);
			 pstmt.setString(2, nom);
			 pstmt.setString(3, ape);
			 pstmt.setInt(4, id);
			 pstmt.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void selectJugador()
	{
		if(statement==null)return;
		String s="select * from jugador;";
		try {
			ResultSet rs=statement.executeQuery(s);
			
			while (rs.next()) {
                System.out.println(rs.getString("nickname") +  "\t" + 
                                   rs.getString("nombre") + "\t" +
                                   rs.getString("apellido")+ "\t"+
                                   rs.getInt("id"));
                				}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void select(TablaEstad p,String consulta)
	{
		initBD("pong game");
		
		if(statement==null) return;
		
		String s=consulta;
		try {
			ResultSet rs=statement.executeQuery(s);
			
			int col=rs.getMetaData().getColumnCount();
			
			
			Object[] etiquetas = new Object[col];
			// Se obtiene cada una de las etiquetas para cada columna
			for (int i = 0; i < col; i++)
			{
			   // Nuevamente, para ResultSetMetaData la primera columna es la 1. 
			   etiquetas[i] = rs.getMetaData().getColumnLabel(i + 1); 
			}
			p.getModelo().setColumnIdentifiers(etiquetas);
			while (rs.next())
			{
			   // Se crea un array que será una de las filas de la tabla. 
			   Object [] fila = new Object[col]; // Hay tres columnas en la tabla

			   // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
			   for (int i=0;i<col;i++)
			      fila[i] = rs.getObject(i+1); 

			   p.addFila(fila); 
			}
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		close();
				
	}
		
}
