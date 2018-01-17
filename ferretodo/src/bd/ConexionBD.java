/**
 * Clase que permite realizar una conexión a la base de datos de Oracle.
 */
package bd;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Yhovanny Quintero
 * @since 1.0
 */
public class ConexionBD {
	
	private static final String BD_CONEXION = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String BD_USUARIO = "FERRETODO";
	private static final String BD_CLAVE = "123456";
	private static Connection conexion;
	private static Statement sentencia;
	

	/**
	 * Constructor
	 */
	public ConexionBD() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Método que permite realizar una conexión con la base de datos.
	 * @throws SQLException
	 */
	private static void abrirConexionBD() throws SQLException {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conexion = DriverManager.getConnection(BD_CONEXION, BD_USUARIO, BD_CLAVE);
		} catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	/**
	 * Método para cerrar la conexión con la base de datos.
	 * @throws SQLException
	 */
	private static void cerrarConexionBD() throws SQLException {
		try {
			conexion.close();
		} catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	/**
	 * Metodo que permite realizar una consulta en la base de datos,
	 * los datos obtenidos seran devueltos en modo ResulSet.
	 * @param sql - Sentencia que contiene la cadena SQL a consultar.
	 * @return - Retorna los datos obtenidos de la consulta realizada al objeto que lo invocó. 
	 * @throws SQLException
	 */
	public static ResultSet ejecutarConsulta(String sql) throws SQLException {
		ResultSet resultado = null;
		try {
			abrirConexionBD();
			sentencia = conexion.createStatement();
			resultado = sentencia.executeQuery(sql);
		} catch (SQLException ex) {
			System.out.println("Error: " + ex);
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
		return resultado;
	}
	
	/**
	 * Metodo que permite realizar una actualización en la base de datos
	 * ya sea para agregar, modificar o eliminar un registro.
	 * @param sql - Sentencia que contiene la cadena SQL a ejecutar.
	 * @return - Retorna un valor entero que determina si se realizó la operación de manera correcta.
	 * @throws SQLException
	 */
	public static int ejecutarActualizacion(String sql) throws SQLException {
		int resultado = -1;
		try {
			abrirConexionBD();
			sentencia = conexion.createStatement();
			resultado = sentencia.executeUpdate(sql);
		} catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
		return resultado;
	}
	
	public static void ejecutarLimpieza() throws SQLException {
		try {
			sentencia.close();
			cerrarConexionBD();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
}
