package bd;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConexionBDConsultarVentas {
	private Connection con = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	final String DB_CONEC="jdbc:oracle:thin:@localhost:1521:xe";
	final String DB_USUARIO="ferretodo";
	final String DB_PASS="123456";
	
	private void Connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");		
			con = DriverManager.getConnection(DB_CONEC,DB_USUARIO,DB_PASS); 
			if (con != null) {
				System.out.println("Conexion exitosa!");
			} else {
				System.out.println("Conexion fallida!");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void QueryProduct (JTable table) throws SQLException {
		Connect();
		while(table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT PRODUCTO_CODIGO, DENOMINACION, PESO, COLOR, MARCA FROM PRODUCTO");
		while (rs.next()) {
			Object[] rowData = new Object[5];
			rowData[0] = rs.getString("PRODUCTO_CODIGO");
			rowData[1] = rs.getString("DENOMINACION");
			rowData[2] = rs.getObject("PESO").toString();
			rowData[3] = rs.getString("COLOR");
			rowData[4] = rs.getString("MARCA");
			((DefaultTableModel) table.getModel()).insertRow(0, rowData);
        }
		rs.close();
		stmt.close();
		con.close();
		table.repaint();
	}
	
	public void QueryProduct (JTable table, String text) throws SQLException {
		Connect();
		while(table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT PRODUCTO_CODIGO, DENOMINACION, PESO, COLOR, MARCA FROM PRODUCTO WHERE DENOMINACION LIKE '%"+text.toUpperCase()+"%'");
		while (rs.next()) {
			Object[] rowData = new Object[5];
			rowData[0] = rs.getString("PRODUCTO_CODIGO");
			rowData[1] = rs.getString("DENOMINACION");
			rowData[2] = rs.getObject("PESO").toString();
			rowData[3] = rs.getString("COLOR");
			rowData[4] = rs.getString("MARCA");
			((DefaultTableModel) table.getModel()).insertRow(0, rowData);
        }
		rs.close();
		stmt.close();
		con.close();
		table.repaint();
	}
	
	public void QueryEmployee(JTable table) throws SQLException {
		Connect();
		while(table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT A.EMPLEADO_CODIGO, A.NOMBRE, A.APELLIDO, A.CI, B.REFERENCIA FROM EMPLEADO A, SUCURSAL B WHERE A.SUCURSAL_ID=B.SUCURSAL_ID");
		while (rs.next()) {
			Object[] rowData = new Object[5];
			rowData[0] = rs.getString("EMPLEADO_CODIGO");
			rowData[1] = rs.getString("NOMBRE");
			rowData[2] = rs.getString("APELLIDO");
			rowData[3] = rs.getString("CI");
			rowData[4] = rs.getString("REFERENCIA");
			((DefaultTableModel) table.getModel()).insertRow(0, rowData);
        }
		rs.close();
		stmt.close();
		con.close();
		table.repaint();
	}
	
	public void QueryEmployee(JTable table, String text) throws SQLException {
		Connect();
		while(table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT A.EMPLEADO_CODIGO, A.NOMBRE, A.APELLIDO, A.CI, B.REFERENCIA FROM EMPLEADO A, SUCURSAL B WHERE A.SUCURSAL_ID=B.SUCURSAL_ID AND (A.NOMBRE LIKE '%"+text.toUpperCase()+"%' OR A.APELLIDO LIKE '%"+text.toUpperCase()+"%')");
		while (rs.next()) {
			Object[] rowData = new Object[5];
			rowData[0] = rs.getString("EMPLEADO_CODIGO");
			rowData[1] = rs.getString("NOMBRE");
			rowData[2] = rs.getString("APELLIDO");
			rowData[3] = rs.getString("CI");
			rowData[4] = rs.getString("REFERENCIA");
			((DefaultTableModel) table.getModel()).insertRow(0, rowData);
        }
		rs.close();
		stmt.close();
		con.close();
		table.repaint();
	}
	
	public void QueryBranch(JTable table) throws SQLException {
		Connect();
		while(table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT A.CODIGO, B.CIUDAD, A.REFERENCIA FROM SUCURSAL A, CIUDAD B WHERE A.CIUDAD_ID=B.CIUDAD_ID");
		while (rs.next()) {
			Object[] rowData = new Object[3];
			rowData[0] = rs.getString("CODIGO");
			rowData[1] = rs.getString("CIUDAD");
			rowData[2] = rs.getString("REFERENCIA");
			((DefaultTableModel) table.getModel()).insertRow(0, rowData);
        }
		rs.close();
		stmt.close();
		con.close();
	}
	
	public void QueryBranch(JTable table, String text) throws SQLException {
		Connect();
		while(table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT A.CODIGO, B.CIUDAD, A.REFERENCIA FROM SUCURSAL A, CIUDAD B WHERE A.CIUDAD_ID=B.CIUDAD_ID AND B.CIUDAD LIKE '%"+text.toUpperCase()+"%'");
		while (rs.next()) {
			Object[] rowData = new Object[3];
			rowData[0] = rs.getString("CODIGO");
			rowData[1] = rs.getString("CIUDAD");
			rowData[2] = rs.getString("REFERENCIA");
			((DefaultTableModel) table.getModel()).insertRow(0, rowData);
        }
		rs.close();
		stmt.close();
		con.close();
	}

	public int QueryProductSales (String cod, int month, int year) throws SQLException {
		int n = 0;
		Connect();
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT COUNT(*) FROM PRODUCTO A, FACTURA_DETALLE B, FACTURA C WHERE A.PRODUCTO_ID=B.PRODUCTO_ID AND B.FACTURA_ID=C.FACTURA_ID "
				+ "AND A.PRODUCTO_CODIGO = '"+cod+"' AND (EXTRACT(MONTH FROM C.FECHA_EMISION) = "+month+") AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+" ) GROUP BY A.PRODUCTO_CODIGO");
		while (rs.next()) {
			n = rs.getInt("COUNT(*)");
        }
		rs.close();
		stmt.close();
		con.close();
		return n;
	}
	
	public int QueryProductSales (String cod, String semester, int year) throws SQLException {
		int n = 0;
		
		if (semester.equals("Primero")){
			Connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) FROM PRODUCTO A, FACTURA_DETALLE B, FACTURA C WHERE A.PRODUCTO_ID=B.PRODUCTO_ID AND B.FACTURA_ID=C.FACTURA_ID "
					+ "AND A.PRODUCTO_CODIGO = '"+cod+"' AND (EXTRACT(MONTH FROM C.FECHA_EMISION)<=(6)) AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+") GROUP BY A.PRODUCTO_CODIGO");
			while (rs.next()) {
				n = rs.getInt("COUNT(*)");
	        }
			rs.close();
			stmt.close();
			con.close();
		}else if (semester.equals("Segundo")) {
			Connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) FROM PRODUCTO A, FACTURA_DETALLE B, FACTURA C WHERE A.PRODUCTO_ID=B.PRODUCTO_ID AND B.FACTURA_ID=C.FACTURA_ID "
					+ "AND A.PRODUCTO_CODIGO = '"+cod+"' AND (EXTRACT(MONTH FROM C.FECHA_EMISION)>=(7)) AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+") GROUP BY A.PRODUCTO_CODIGO");
			while (rs.next()) {
				n = rs.getInt("COUNT(*)");
	        }
			rs.close();
			stmt.close();
			con.close();
		}else {
			
		}
		return n;
	}
	
	public int QueryProductSales (String cod, int year) throws SQLException {
		int n = 0;
		Connect();
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT COUNT(*) FROM PRODUCTO A, FACTURA_DETALLE B, FACTURA C WHERE A.PRODUCTO_ID=B.PRODUCTO_ID AND B.FACTURA_ID=C.FACTURA_ID "
				+ "AND A.PRODUCTO_CODIGO = '"+cod+"' AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+" ) GROUP BY A.PRODUCTO_CODIGO");
		while (rs.next()) {
			n = rs.getInt("COUNT(*)");
        }
		rs.close();
		stmt.close();
		con.close();
		return n;
	}
	
	public int QueryProductSales (String cod, String start, String end) throws SQLException {
		int n = 0;
		Connect();
		String sql = "SELECT COUNT(*) FROM PRODUCTO A, FACTURA_DETALLE B, FACTURA C WHERE A.PRODUCTO_ID=B.PRODUCTO_ID AND B.FACTURA_ID=C.FACTURA_ID "
				+ "AND A.PRODUCTO_CODIGO = ? AND C.FECHA_EMISION BETWEEN ? AND ? GROUP BY A.PRODUCTO_CODIGO";
		pstmt = con.prepareStatement(sql);
		System.out.println(cod);
		pstmt.setString(1, cod);
		pstmt.setString(2, start);
		pstmt.setString(3, end);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			n = rs.getInt("COUNT(*)");
        }
		rs.close();
		stmt.close();
		con.close();
		return n;
	}
	
	public int QueryEmployeeSales (String cod, int month, int year) throws SQLException {
		int n = 0;
		Connect();
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT COUNT(*) FROM EMPLEADO A, FACTURA_DETALLE B, FACTURA C  WHERE A.EMPLEADO_ID=C.EMPLEADO_ID AND B.FACTURA_ID=C.FACTURA_ID "
				+ "AND A.EMPLEADO_CODIGO = '"+cod+"' AND (EXTRACT(MONTH FROM C.FECHA_EMISION) = "+month+") AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+" ) GROUP BY A.EMPLEADO_CODIGO");
		while (rs.next()) {
			n = rs.getInt("COUNT(*)");
        }
		rs.close();
		stmt.close();
		con.close();
		return n;
	}
	
	public int QueryEmployeeSales (String cod, String semester, int year) throws SQLException {
		int n = 0;
		
		if (semester.equals("Primero")){
			Connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) FROM EMPLEADO A, FACTURA_DETALLE B, FACTURA C  WHERE A.EMPLEADO_ID=C.EMPLEADO_ID AND B.FACTURA_ID=C.FACTURA_ID "
					+ "AND A.EMPLEADO_CODIGO = '"+cod+"' AND (EXTRACT(MONTH FROM C.FECHA_EMISION)<=(6)) AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+") GROUP BY A.EMPLEADO_CODIGO");
			while (rs.next()) {
				n = rs.getInt("COUNT(*)");
	        }
			rs.close();
			stmt.close();
			con.close();
		}else if (semester.equals("Segundo")) {
			Connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) FROM EMPLEADO A, FACTURA_DETALLE B, FACTURA C  WHERE A.EMPLEADO_ID=C.EMPLEADO_ID AND B.FACTURA_ID=C.FACTURA_ID "
					+ "AND A.EMPLEADO_CODIGO = '"+cod+"' AND (EXTRACT(MONTH FROM C.FECHA_EMISION)>=(7)) AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+") GROUP BY A.EMPLEADO_CODIGO");
			while (rs.next()) {
				n = rs.getInt("COUNT(*)");
	        }
			rs.close();
			stmt.close();
			con.close();
		}else {
			
		}
		return n;
	}
	
	public int QueryEmployeeSales (String cod, int year) throws SQLException {
		int n = 0;
		Connect();
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT COUNT(*) FROM EMPLEADO A, FACTURA_DETALLE B, FACTURA C  WHERE A.EMPLEADO_ID=C.EMPLEADO_ID AND B.FACTURA_ID=C.FACTURA_ID "
				+ "AND A.EMPLEADO_CODIGO = '"+cod+"' AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+" ) GROUP BY A.EMPLEADO_CODIGO");
		while (rs.next()) {
			n = rs.getInt("COUNT(*)");
        }
		rs.close();
		stmt.close();
		con.close();
		return n;
	}
	
	public int QueryEmployeeSales (String cod, String start, String end) throws SQLException {
		int n = 0;
		Connect();
		String sql = "SELECT COUNT(*) FROM EMPLEADO A, FACTURA_DETALLE B, FACTURA C  WHERE A.EMPLEADO_ID=C.EMPLEADO_ID AND B.FACTURA_ID=C.FACTURA_ID "
				+ "AND A.EMPLEADO_CODIGO = ? AND C.FECHA_EMISION BETWEEN ? AND ? GROUP BY A.EMPLEADO_CODIGO";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, cod);
		pstmt.setString(2, start);
		pstmt.setString(3, end);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			n = rs.getInt("COUNT(*)");
        }
		rs.close();
		stmt.close();
		con.close();
		return n;
	}
	
	public int QueryBranchSales (String cod, int month, int year) throws SQLException {
		int n = 0;
		Connect();
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT COUNT(*) FROM SUCURSAL A, FACTURA_DETALLE B, FACTURA C WHERE A.SUCURSAL_ID=C.SUCURSAL_ID AND C.FACTURA_ID=B.FACTURA_ID "
				+ "AND A.CODIGO = '"+cod+"' AND (EXTRACT(MONTH FROM C.FECHA_EMISION) = "+month+") AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+" ) GROUP BY A.CODIGO");
		while (rs.next()) {
			n = rs.getInt("COUNT(*)");
        }
		rs.close();
		stmt.close();
		con.close();
		return n;
	}
	
	public int QueryBranchSales (String cod, String semester, int year) throws SQLException {
		int n = 0;
		
		if (semester.equals("Primero")){
			Connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) FROM SUCURSAL A, FACTURA_DETALLE B, FACTURA C WHERE A.SUCURSAL_ID=C.SUCURSAL_ID AND C.FACTURA_ID=B.FACTURA_ID "
					+ "AND A.CODIGO = '"+cod+"' AND (EXTRACT(MONTH FROM C.FECHA_EMISION)<=(6)) AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+") GROUP BY A.CODIGO");
			while (rs.next()) {
				n = rs.getInt("COUNT(*)");
	        }
			rs.close();
			stmt.close();
			con.close();
		}else if (semester.equals("Segundo")) {
			Connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) FROM SUCURSAL A, FACTURA_DETALLE B, FACTURA C WHERE A.SUCURSAL_ID=C.SUCURSAL_ID AND C.FACTURA_ID=B.FACTURA_ID "
					+ "AND A.CODIGO = '"+cod+"' AND (EXTRACT(MONTH FROM C.FECHA_EMISION)>=(7)) AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+") GROUP BY A.CODIGO");
			while (rs.next()) {
				n = rs.getInt("COUNT(*)");
	        }
			rs.close();
			stmt.close();
			con.close();
		}else {
			
		}
		return n;
	}
	
	public int QueryBranchSales (String cod, int year) throws SQLException {
		int n = 0;
		Connect();
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT COUNT(*) FROM SUCURSAL A, FACTURA_DETALLE B, FACTURA C WHERE A.SUCURSAL_ID=C.SUCURSAL_ID AND C.FACTURA_ID=B.FACTURA_ID "
				+ "AND A.CODIGO = '"+cod+"' AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+" ) GROUP BY A.CODIGO");
		while (rs.next()) {
			n = rs.getInt("COUNT(*)");
        }
		rs.close();
		stmt.close();
		con.close();
		return n;
	}
	
	public int QueryBranchSales (String cod, String start, String end) throws SQLException {
		int n = 0;
		Connect();
		String sql = "SELECT COUNT(*) FROM SUCURSAL A, FACTURA_DETALLE B, FACTURA C WHERE A.SUCURSAL_ID=C.SUCURSAL_ID AND C.FACTURA_ID=B.FACTURA_ID "
				+ "AND A.CODIGO = ? AND C.FECHA_EMISION BETWEEN ? AND ? GROUP BY A.CODIGO";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, cod);
		pstmt.setString(2, start);
		pstmt.setString(3, end);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			n = rs.getInt("COUNT(*)");
        }
		rs.close();
		stmt.close();
		con.close();
		return n;
	}
	
	
	
	
	
	
	public int QueryProductReport (String cod, int month, int year, JTable table) throws SQLException {
		Connect();
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT C.FECHA_EMISION, B.CANTIDAD, B.PRECIO FROM PRODUCTO A, FACTURA_DETALLE B, FACTURA C WHERE A.PRODUCTO_ID=B.PRODUCTO_ID AND B.FACTURA_ID=C.FACTURA_ID "
				+ "AND A.PRODUCTO_CODIGO = '"+cod+"' AND (EXTRACT(MONTH FROM C.FECHA_EMISION) = "+month+") AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+" )");
		int total = 0;
		while (rs.next()) {
			Object[] rowData = new Object[4];
			int cantidad = 0, precio = 0;
			rowData[0] = rs.getObject("FECHA_EMISION").toString();
			cantidad = rs.getInt("CANTIDAD");
			rowData[1] = cantidad;
			precio = rs.getInt("PRECIO");
			rowData[2] = precio;
			rowData[3] = (cantidad*precio);
			((DefaultTableModel) table.getModel()).insertRow(0, rowData);
			total += (cantidad*precio);
        }
		rs.close();
		stmt.close();
		con.close();
		return total;
	}
	
	public int QueryProductReport (String cod, String semester, int year, JTable table) throws SQLException {
		int total = 0;
		if (semester.equals("Primero")){
			Connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT C.FECHA_EMISION, B.CANTIDAD, B.PRECIO FROM PRODUCTO A, FACTURA_DETALLE B, FACTURA C WHERE A.PRODUCTO_ID=B.PRODUCTO_ID AND B.FACTURA_ID=C.FACTURA_ID "
					+ "AND A.PRODUCTO_CODIGO = '"+cod+"' AND (EXTRACT(MONTH FROM C.FECHA_EMISION)<=(6)) AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+")");
			while (rs.next()) {
				Object[] rowData = new Object[4];
				int cantidad = 0, precio = 0;
				rowData[0] = rs.getObject("FECHA_EMISION").toString();
				cantidad = rs.getInt("CANTIDAD");
				rowData[1] = cantidad;
				precio = rs.getInt("PRECIO");
				rowData[2] = precio;
				rowData[3] = (cantidad*precio);
				((DefaultTableModel) table.getModel()).insertRow(0, rowData);
				total += (cantidad*precio);
	        }
			rs.close();
			stmt.close();
			con.close();
		}else if (semester.equals("Segundo")) {
			Connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT C.FECHA_EMISION, B.CANTIDAD, B.PRECIO FROM PRODUCTO A, FACTURA_DETALLE B, FACTURA C WHERE A.PRODUCTO_ID=B.PRODUCTO_ID AND B.FACTURA_ID=C.FACTURA_ID "
					+ "AND A.PRODUCTO_CODIGO = '"+cod+"' AND (EXTRACT(MONTH FROM C.FECHA_EMISION)>=(7)) AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+")");
			while (rs.next()) {
				Object[] rowData = new Object[4];
				int cantidad = 0, precio = 0;
				rowData[0] = rs.getObject("FECHA_EMISION").toString();
				cantidad = rs.getInt("CANTIDAD");
				rowData[1] = cantidad;
				precio = rs.getInt("PRECIO");
				rowData[2] = precio;
				rowData[3] = (cantidad*precio);
				((DefaultTableModel) table.getModel()).insertRow(0, rowData);
				total += (cantidad*precio);
	        }
			rs.close();
			stmt.close();
			con.close();
		}else {
			
		}
		return total;
	}
	
	public int QueryProductReport (String cod, int year, JTable table) throws SQLException {
		Connect();
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT C.FECHA_EMISION, B.CANTIDAD, B.PRECIO FROM PRODUCTO A, FACTURA_DETALLE B, FACTURA C WHERE A.PRODUCTO_ID=B.PRODUCTO_ID AND B.FACTURA_ID=C.FACTURA_ID "
				+ "AND A.PRODUCTO_CODIGO = '"+cod+"' AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+" )");
		int total = 0;
		while (rs.next()) {
			Object[] rowData = new Object[4];
			int cantidad = 0, precio = 0;
			rowData[0] = rs.getObject("FECHA_EMISION").toString();
			cantidad = rs.getInt("CANTIDAD");
			rowData[1] = cantidad;
			precio = rs.getInt("PRECIO");
			rowData[2] = precio;
			rowData[3] = (cantidad*precio);
			((DefaultTableModel) table.getModel()).insertRow(0, rowData);
			total += (cantidad*precio);
        }
		rs.close();
		stmt.close();
		con.close();
		return total;
	}
	
	public int QueryProductReport (String cod, String start, String end, JTable table) throws SQLException {
		Connect();
		String sql = "SELECT C.FECHA_EMISION, B.CANTIDAD, B.PRECIO FROM PRODUCTO A, FACTURA_DETALLE B, FACTURA C WHERE A.PRODUCTO_ID=B.PRODUCTO_ID AND B.FACTURA_ID=C.FACTURA_ID "
				+ "AND A.PRODUCTO_CODIGO = ? AND C.FECHA_EMISION BETWEEN ? AND ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, cod);
		pstmt.setString(2, start);
		pstmt.setString(3, end);
		rs = pstmt.executeQuery();
		int total = 0;
		while (rs.next()) {
			Object[] rowData = new Object[4];
			int cantidad = 0, precio = 0;
			rowData[0] = rs.getObject("FECHA_EMISION").toString();
			cantidad = rs.getInt("CANTIDAD");
			rowData[1] = cantidad;
			precio = rs.getInt("PRECIO");
			rowData[2] = precio;
			rowData[3] = (cantidad*precio);
			((DefaultTableModel) table.getModel()).insertRow(0, rowData);
			total += (cantidad*precio);
        }
		rs.close();
		pstmt.close();
		con.close();
		return total;
	}
	
	public int QueryEmployeeReport (String cod, int month, int year, JTable table) throws SQLException {
		Connect();
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT C.FECHA_EMISION, B.CANTIDAD, B.PRECIO FROM EMPLEADO A, FACTURA_DETALLE B, FACTURA C  WHERE A.EMPLEADO_ID=C.EMPLEADO_ID AND B.FACTURA_ID=C.FACTURA_ID "
				+ "AND A.EMPLEADO_CODIGO = '"+cod+"' AND (EXTRACT(MONTH FROM C.FECHA_EMISION) = "+month+") AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+" )");
		int total = 0;
		while (rs.next()) {
			Object[] rowData = new Object[4];
			int cantidad = 0, precio = 0;
			rowData[0] = rs.getObject("FECHA_EMISION").toString();
			cantidad = rs.getInt("CANTIDAD");
			rowData[1] = cantidad;
			precio = rs.getInt("PRECIO");
			rowData[2] = precio;
			rowData[3] = (cantidad*precio);
			((DefaultTableModel) table.getModel()).insertRow(0, rowData);
			total += (cantidad*precio);
        }
		rs.close();
		stmt.close();
		con.close();
		return total;
	}
	
	public int QueryEmployeeReport (String cod, String semester, int year, JTable table) throws SQLException {
		int total = 0;
		if (semester.equals("Primero")){
			Connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT C.FECHA_EMISION, B.CANTIDAD, B.PRECIO FROM EMPLEADO A, FACTURA_DETALLE B, FACTURA C  WHERE A.EMPLEADO_ID=C.EMPLEADO_ID AND B.FACTURA_ID=C.FACTURA_ID "
					+ "AND A.EMPLEADO_CODIGO = '"+cod+"' AND (EXTRACT(MONTH FROM C.FECHA_EMISION)<=(6)) AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+")");
			while (rs.next()) {
				Object[] rowData = new Object[4];
				int cantidad = 0, precio = 0;
				rowData[0] = rs.getObject("FECHA_EMISION").toString();
				cantidad = rs.getInt("CANTIDAD");
				rowData[1] = cantidad;
				precio = rs.getInt("PRECIO");
				rowData[2] = precio;
				rowData[3] = (cantidad*precio);
				((DefaultTableModel) table.getModel()).insertRow(0, rowData);
				total += (cantidad*precio);
	        }
			rs.close();
			stmt.close();
			con.close();
		}else if (semester.equals("Segundo")) {
			Connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT C.FECHA_EMISION, B.CANTIDAD, B.PRECIO FROM EMPLEADO A, FACTURA_DETALLE B, FACTURA C  WHERE A.EMPLEADO_ID=C.EMPLEADO_ID AND B.FACTURA_ID=C.FACTURA_ID "
					+ "AND A.EMPLEADO_CODIGO = '"+cod+"' AND (EXTRACT(MONTH FROM C.FECHA_EMISION)>=(7)) AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+")");
			while (rs.next()) {
				Object[] rowData = new Object[4];
				int cantidad = 0, precio = 0;
				rowData[0] = rs.getObject("FECHA_EMISION").toString();
				cantidad = rs.getInt("CANTIDAD");
				rowData[1] = cantidad;
				precio = rs.getInt("PRECIO");
				rowData[2] = precio;
				rowData[3] = (cantidad*precio);
				((DefaultTableModel) table.getModel()).insertRow(0, rowData);
				total += (cantidad*precio);
	        }
			rs.close();
			stmt.close();
			con.close();
		}else {
			
		}
		return total;
	}
	
	public int QueryEmployeeReport (String cod, int year, JTable table) throws SQLException {
		Connect();
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT C.FECHA_EMISION, B.CANTIDAD, B.PRECIO FROM EMPLEADO A, FACTURA_DETALLE B, FACTURA C  WHERE A.EMPLEADO_ID=C.EMPLEADO_ID AND B.FACTURA_ID=C.FACTURA_ID "
				+ "AND A.EMPLEADO_CODIGO = '"+cod+"' AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+" )");
		int total = 0;
		while (rs.next()) {
			Object[] rowData = new Object[4];
			int cantidad = 0, precio = 0;
			rowData[0] = rs.getObject("FECHA_EMISION").toString();
			cantidad = rs.getInt("CANTIDAD");
			rowData[1] = cantidad;
			precio = rs.getInt("PRECIO");
			rowData[2] = precio;
			rowData[3] = (cantidad*precio);
			((DefaultTableModel) table.getModel()).insertRow(0, rowData);
			total += (cantidad*precio);
        }
		rs.close();
		stmt.close();
		con.close();
		return total;
	}
	
	public int QueryEmployeeReport (String cod, String start, String end, JTable table) throws SQLException {
		Connect();
		String sql = "SELECT C.FECHA_EMISION, B.CANTIDAD, B.PRECIO FROM EMPLEADO A, FACTURA_DETALLE B, FACTURA C  WHERE A.EMPLEADO_ID=C.EMPLEADO_ID AND B.FACTURA_ID=C.FACTURA_ID "
				+ "AND A.EMPLEADO_CODIGO = ? AND C.FECHA_EMISION BETWEEN ? AND ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, cod);
		pstmt.setString(2, start);
		pstmt.setString(3, end);
		rs = pstmt.executeQuery();
		int total = 0;
		while (rs.next()) {
			Object[] rowData = new Object[4];
			int cantidad = 0, precio = 0;
			rowData[0] = rs.getObject("FECHA_EMISION").toString();
			cantidad = rs.getInt("CANTIDAD");
			rowData[1] = cantidad;
			precio = rs.getInt("PRECIO");
			rowData[2] = precio;
			rowData[3] = (cantidad*precio);
			((DefaultTableModel) table.getModel()).insertRow(0, rowData);
			total += (cantidad*precio);
        }
		rs.close();
		pstmt.close();
		con.close();
		return total;
	}
	
	public int QueryBranchReport (String cod, int month, int year, JTable table) throws SQLException {
		Connect();
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT C.FECHA_EMISION, B.CANTIDAD, B.PRECIO FROM SUCURSAL A, FACTURA_DETALLE B, FACTURA C WHERE A.SUCURSAL_ID=C.SUCURSAL_ID AND C.FACTURA_ID=B.FACTURA_ID "
				+ "AND A.CODIGO = '"+cod+"' AND (EXTRACT(MONTH FROM C.FECHA_EMISION) = "+month+") AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+" )");
		int total = 0;
		while (rs.next()) {
			Object[] rowData = new Object[4];
			int cantidad = 0, precio = 0;
			rowData[0] = rs.getObject("FECHA_EMISION").toString();
			cantidad = rs.getInt("CANTIDAD");
			rowData[1] = cantidad;
			precio = rs.getInt("PRECIO");
			rowData[2] = precio;
			rowData[3] = (cantidad*precio);
			((DefaultTableModel) table.getModel()).insertRow(0, rowData);
			total += (cantidad*precio);
        }
		rs.close();
		stmt.close();
		con.close();
		return total;
	}
	
	public int QueryBranchReport (String cod, String semester, int year, JTable table) throws SQLException {
		int total = 0;
		if (semester.equals("Primero")){
			Connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT C.FECHA_EMISION, B.CANTIDAD, B.PRECIO FROM SUCURSAL A, FACTURA_DETALLE B, FACTURA C WHERE A.SUCURSAL_ID=C.SUCURSAL_ID AND C.FACTURA_ID=B.FACTURA_ID "
					+ "AND A.CODIGO = '"+cod+"' AND (EXTRACT(MONTH FROM C.FECHA_EMISION)<=(6)) AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+")");
			while (rs.next()) {
				Object[] rowData = new Object[4];
				int cantidad = 0, precio = 0;
				rowData[0] = rs.getObject("FECHA_EMISION").toString();
				cantidad = rs.getInt("CANTIDAD");
				rowData[1] = cantidad;
				precio = rs.getInt("PRECIO");
				rowData[2] = precio;
				rowData[3] = (cantidad*precio);
				((DefaultTableModel) table.getModel()).insertRow(0, rowData);
				total += (cantidad*precio);
	        }
			rs.close();
			stmt.close();
			con.close();
		}else if (semester.equals("Segundo")) {
			Connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT C.FECHA_EMISION, B.CANTIDAD, B.PRECIO FROM SUCURSAL A, FACTURA_DETALLE B, FACTURA C WHERE A.SUCURSAL_ID=C.SUCURSAL_ID AND C.FACTURA_ID=B.FACTURA_ID "
					+ "AND A.CODIGO = '"+cod+"' AND (EXTRACT(MONTH FROM C.FECHA_EMISION)>=(7)) AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+")");
			while (rs.next()) {
				Object[] rowData = new Object[4];
				int cantidad = 0, precio = 0;
				rowData[0] = rs.getObject("FECHA_EMISION").toString();
				cantidad = rs.getInt("CANTIDAD");
				rowData[1] = cantidad;
				precio = rs.getInt("PRECIO");
				rowData[2] = precio;
				rowData[3] = (cantidad*precio);
				((DefaultTableModel) table.getModel()).insertRow(0, rowData);
				total += (cantidad*precio);
	        }
			rs.close();
			stmt.close();
			con.close();
		}else {
			
		}
		return total;
	}
	
	public int QueryBranchReport (String cod, int year, JTable table) throws SQLException {
		Connect();
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT C.FECHA_EMISION, B.CANTIDAD, B.PRECIO FROM SUCURSAL A, FACTURA_DETALLE B, FACTURA C WHERE A.SUCURSAL_ID=C.SUCURSAL_ID AND C.FACTURA_ID=B.FACTURA_ID "
				+ "AND A.CODIGO = '"+cod+"' AND (EXTRACT(YEAR FROM C.FECHA_EMISION) = "+year+" )");
		int total = 0;
		while (rs.next()) {
			Object[] rowData = new Object[4];
			int cantidad = 0, precio = 0;
			rowData[0] = rs.getObject("FECHA_EMISION").toString();
			cantidad = rs.getInt("CANTIDAD");
			rowData[1] = cantidad;
			precio = rs.getInt("PRECIO");
			rowData[2] = precio;
			rowData[3] = (cantidad*precio);
			((DefaultTableModel) table.getModel()).insertRow(0, rowData);
			total += (cantidad*precio);
        }
		rs.close();
		stmt.close();
		con.close();
		return total;
	}
	
	public int QueryBranchReport (String cod, String start, String end, JTable table) throws SQLException {
		Connect();
		String sql = "SELECT C.FECHA_EMISION, B.CANTIDAD, B.PRECIO FROM SUCURSAL A, FACTURA_DETALLE B, FACTURA C WHERE A.SUCURSAL_ID=C.SUCURSAL_ID AND C.FACTURA_ID=B.FACTURA_ID "
				+ "AND A.CODIGO = ? AND C.FECHA_EMISION BETWEEN ? AND ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, cod);
		pstmt.setString(2, start);
		pstmt.setString(3, end);
		rs = pstmt.executeQuery();
		int total = 0;
		while (rs.next()) {
			Object[] rowData = new Object[4];
			int cantidad = 0, precio = 0;
			rowData[0] = rs.getObject("FECHA_EMISION").toString();
			cantidad = rs.getInt("CANTIDAD");
			rowData[1] = cantidad;
			precio = rs.getInt("PRECIO");
			rowData[2] = precio;
			rowData[3] = (cantidad*precio);
			((DefaultTableModel) table.getModel()).insertRow(0, rowData);
			total += (cantidad*precio);
        }
		rs.close();
		pstmt.close();
		con.close();
		return total;
	}
	
	
}





