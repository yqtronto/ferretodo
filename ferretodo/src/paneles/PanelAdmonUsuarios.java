/**
 * @author Yhovanny Quintero y Cindy Machado
 */
package paneles;

import bd.ConexionBD;
import formularios.PanelAdminUsuarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class PanelAdmonUsuarios extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String TEXTO_EMPLEADO = "Cód. Empleado:";
	private static final String TEXTO_CEDULA = "Cedula:";
	private static final String TEXTO_BUSCAR = "Buscar";
	private JTextField tEmpleado;
	private JTextField tCedula;
	private JButton bBuscar;
	private JButton bAgregar;
	private JButton bModificar;
	private JButton bEliminar;
	private JTable tUsuarios;
	private PanelAdminUsuarios panelAdminUsuarios;
	private String codEmpleado = "", nombre, apellido, cedEmpleado = "";
	private boolean estatus = false;
	private boolean isDebug = true;
	private int filaSel = 0;
	
	public PanelAdmonUsuarios() {
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(2, 2, 2, 2));
		{
			JPanel pNorte = new JPanel();
			pNorte.setBorder(new EmptyBorder(2, 2, 2, 2));
			pNorte.setLayout(new BorderLayout());
			
			JPanel pTitulo = new JPanel();
			pTitulo.setBorder(new EmptyBorder(30, 10, 30, 10));
			pTitulo.setBackground(new Color(44, 62, 80));
			pTitulo.setLayout(new GridLayout(1, 1, 1, 1));
			{
				JLabel lblTitulo = new JLabel("GESTION DE USUARIOS");
				lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
				lblTitulo.setForeground(new Color(255, 255, 255));
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				pTitulo.add(lblTitulo);
			}
			pNorte.add(pTitulo, BorderLayout.NORTH);
			
			// XXX ========== PANEL BUSQUEDA ========== 
			JPanel pBusqueda = new JPanel();
			pBusqueda.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			GridBagLayout gbl_pBusqueda = new GridBagLayout();
			{
				gbl_pBusqueda.columnWidths = new int[]{0, 100, 200, 100, 0};
				gbl_pBusqueda.rowHeights = new int[]{0};
				gbl_pBusqueda.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0};
				gbl_pBusqueda.rowWeights = new double[]{0.0};
			}
			pBusqueda.setLayout(gbl_pBusqueda);
			{
				JPanel pEtiquetas = new JPanel();
				pEtiquetas.setBorder(new EmptyBorder(20, 5, 20, 5));
				pEtiquetas.setLayout(new GridLayout(2, 1, 1, 5));
				GridBagConstraints gbc_pEtiquetas = new GridBagConstraints();
				{
					gbc_pEtiquetas.anchor = GridBagConstraints.EAST;
					gbc_pEtiquetas.insets = new Insets(0, 0, 0, 5);
					gbc_pEtiquetas.gridx = 1;
					gbc_pEtiquetas.gridy = 0;
				}
				pBusqueda.add(pEtiquetas, gbc_pEtiquetas);
				{
					JLabel lblEmpleado = new JLabel(TEXTO_EMPLEADO);
					lblEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);
					pEtiquetas.add(lblEmpleado);
				}
				{
					JLabel lblCedula = new JLabel(TEXTO_CEDULA);
					lblCedula.setHorizontalAlignment(SwingConstants.RIGHT);
					pEtiquetas.add(lblCedula);
				}

				JPanel pCajasTextos = new JPanel();
				pCajasTextos.setBorder(new EmptyBorder(20, 5, 20, 5));
				pCajasTextos.setLayout(new GridLayout(2, 1, 1, 5));
				GridBagConstraints gbc_pCajasTextos = new GridBagConstraints();
				{
					gbc_pCajasTextos.anchor = GridBagConstraints.WEST;
					gbc_pCajasTextos.insets = new Insets(0, 0, 0, 5);
					gbc_pCajasTextos.gridx = 2;
					gbc_pCajasTextos.gridy = 0;
				}
				pBusqueda.add(pCajasTextos, gbc_pCajasTextos);
				{
					tEmpleado = new JTextField();
					tEmpleado.setColumns(20);
					pCajasTextos.add(tEmpleado);
				}
				{
					tCedula = new JTextField();
					tCedula.setColumns(20);
					pCajasTextos.add(tCedula);
				}
				
				JPanel pBotonBuscar = new JPanel();
				pBotonBuscar.setBorder(new EmptyBorder(20, 5, 20, 5));
				pBotonBuscar.setLayout(new GridLayout(1, 1, 2, 2));
				GridBagConstraints gbc_pBotonBuscar = new GridBagConstraints();
				{
					gbc_pBotonBuscar.anchor = GridBagConstraints.CENTER;
					gbc_pBotonBuscar.insets = new Insets(0, 0, 0, 0);
					gbc_pBotonBuscar.gridx = 3;
					gbc_pBotonBuscar.gridy = 0;
				}
				pBusqueda.add(pBotonBuscar, gbc_pBotonBuscar);
				{
					bBuscar = new JButton(TEXTO_BUSCAR);
					bBuscar.setIcon( icono("image//FindUser_32px.png", 30, 30));
					bBuscar.addActionListener(this);
					pBotonBuscar.add(bBuscar);
				}

			}
			
			pNorte.add(pBusqueda,  BorderLayout.CENTER);
			add(pNorte, BorderLayout.NORTH);
			
			// Panel Central.
			JPanel pCentral = new JPanel();
			pCentral.setBorder(new EmptyBorder(10, 10, 10, 10));
			pCentral.setLayout(new BorderLayout(0, 0));
			
			JPanel pBotonera = new JPanel();
			pBotonera.setLayout(new BorderLayout(0, 0));
			{
				JPanel pBotonesAcciones = new JPanel();
				pBotonesAcciones.setBorder(new EmptyBorder(5, 5, 5, 5));
				pBotonera.add(pBotonesAcciones, BorderLayout.EAST);
				
				bAgregar = new JButton();
				bAgregar.setIcon( icono("image//AddUser_32px.png", 30, 30));
				bAgregar.addActionListener(this);
				pBotonesAcciones.add(bAgregar);
				
				bModificar = new JButton();
				bModificar.setIcon( icono("image//EditUser_32px.png", 30, 30));
				bModificar.addActionListener(this);
				pBotonesAcciones.add(bModificar);
				
				bEliminar = new JButton();
				bEliminar.setIcon( icono("image//DeleteUser_32px.png", 30, 30));
				bEliminar.addActionListener(this);
				pBotonesAcciones.add(bEliminar);
			}
			pCentral.add(pBotonera, BorderLayout.NORTH);

			JPanel pTabla = new JPanel();
			pTabla.setBorder(new EmptyBorder(5, 5, 5, 5));
			pTabla.setLayout(new GridLayout(0, 1, 0, 0));
			{
				String[] nColumnas = {"COD. EMPLEADO", "NOMBRE Y APELLIDO", "CEDULA", "USUARIO", "DEPARTAMENTO", "ROLES", "ESTATUS"};
				tUsuarios = new JTable();
				tUsuarios.setBorder(new EmptyBorder(5, 5, 5, 5));
				tUsuarios.setModel(new DefaultTableModel(nColumnas, 0) {
					private static final long serialVersionUID = 1L;
					@SuppressWarnings("rawtypes")
					Class[] columnTypes = new Class[] {
							String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class
					};
					@SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				tUsuarios.getColumnModel().getColumn(0).setResizable(false);
				tUsuarios.getColumnModel().getColumn(0).setPreferredWidth(120);
				tUsuarios.getColumnModel().getColumn(0).setMinWidth(120);
				tUsuarios.getColumnModel().getColumn(0).setMaxWidth(120);
				tUsuarios.getColumnModel().getColumn(1).setPreferredWidth(200);
				tUsuarios.getColumnModel().getColumn(1).setMinWidth(200);
				tUsuarios.getColumnModel().getColumn(1).setMaxWidth(300);
				tUsuarios.getColumnModel().getColumn(2).setResizable(false);
				tUsuarios.getColumnModel().getColumn(2).setPreferredWidth(70);
				tUsuarios.getColumnModel().getColumn(2).setMinWidth(70);
				tUsuarios.getColumnModel().getColumn(2).setMaxWidth(80);
				tUsuarios.getColumnModel().getColumn(3).setPreferredWidth(100);
				tUsuarios.getColumnModel().getColumn(3).setMinWidth(100);
				tUsuarios.getColumnModel().getColumn(3).setMaxWidth(100);
				tUsuarios.getColumnModel().getColumn(4).setPreferredWidth(150);
				tUsuarios.getColumnModel().getColumn(4).setMinWidth(150);
				tUsuarios.getColumnModel().getColumn(4).setMaxWidth(200);
				tUsuarios.getColumnModel().getColumn(5).setPreferredWidth(150);
				tUsuarios.getColumnModel().getColumn(5).setMinWidth(150);
				tUsuarios.getColumnModel().getColumn(5).setMaxWidth(300);
				tUsuarios.getColumnModel().getColumn(6).setResizable(false);
				tUsuarios.getColumnModel().getColumn(6).setPreferredWidth(70);
				tUsuarios.getColumnModel().getColumn(6).setMinWidth(70);
				tUsuarios.getColumnModel().getColumn(6).setMaxWidth(70);
				tUsuarios.setFillsViewportHeight(false);
				tUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				tUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						// TODO Auto-generated method stub
				        if (tUsuarios.getSelectedRow() > -1) {
				            // print first column value from selected row
				        	if (isDebug) {
				        		System.out.println(tUsuarios.getValueAt(tUsuarios.getSelectedRow(), 0).toString());
				        	}
				            bModificar.setEnabled(true);
				            bEliminar.setEnabled(true);
				            codEmpleado = tUsuarios.getValueAt(tUsuarios.getSelectedRow(),0).toString();
				            filaSel = tUsuarios.getSelectedRow();
				            if (isDebug) {
				            	System.out.println("Valor: " + codEmpleado);
				            }
				        }
					}
				});
			}
			JScrollPane scrollPane = new JScrollPane(tUsuarios);
	        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			pTabla.add(scrollPane);
			pCentral.add(pTabla, BorderLayout.CENTER);
			add(pCentral, BorderLayout.CENTER);
			desactivarBotones();
		}
	}
	
	protected ImageIcon icono (String direccion, int tamW, int tamH) {
		ImageIcon icon = new ImageIcon(direccion);
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(tamW, tamH,  java.awt.Image.SCALE_SMOOTH );
        return new ImageIcon( newimg );
	}
	
	public void desactivarBotones() {
		bAgregar.setEnabled(false);
		bModificar.setEnabled(false);
		bEliminar.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// FIXME ===== actionPerformed - Manejo de eventos de los botones Agregar, Modificar, Eliminar y Buscar.
		if ( e.getSource() == bBuscar ) {
			codEmpleado = ""; nombre = ""; apellido = ""; cedEmpleado = ""; estatus = false;
			desactivarBotones();
			while(tUsuarios.getRowCount() > 0) {
	            ((DefaultTableModel) tUsuarios.getModel()).removeRow(0);
	        }
			//System.out.println("Buscar");
			String sql = "", sqlEmpleado = "";
			if (!tCedula.getText().isEmpty() && tEmpleado.getText().isEmpty()) {
				sql = "SELECT E.EMPLEADO_CODIGO, E.NOMBRE, E.APELLIDO, E.CI, D.DENOMINACION, U.USUARIO, R.DENOMINACION AS ROL, U.ESTATUS FROM EMPLEADO E, USUARIO U, DEPARTAMENTO D, ROLES R, USUARIO_ROLES UR WHERE E.EMPLEADO_ID = U.EMPLEADO_ID AND D.DEP_ID = E.DEP_ID AND U.USUARIO_ID = UR.USUARIO_ID AND UR.ROL_ID = R.ROL_ID AND E.CI = " + tCedula.getText();
				sqlEmpleado = "SELECT EMPLEADO_CODIGO, NOMBRE, APELLIDO, CI, ESTATUS FROM EMPLEADO WHERE CI = " + tCedula.getText();
			} else if (tCedula.getText().isEmpty() && !tEmpleado.getText().isEmpty()) {
				sql = "SELECT E.EMPLEADO_CODIGO, E.NOMBRE, E.APELLIDO, E.CI, D.DENOMINACION, U.USUARIO, R.DENOMINACION AS ROL, U.ESTATUS FROM EMPLEADO E, USUARIO U, DEPARTAMENTO D, ROLES R, USUARIO_ROLES UR WHERE E.EMPLEADO_ID = U.EMPLEADO_ID AND D.DEP_ID = E.DEP_ID AND U.USUARIO_ID = UR.USUARIO_ID AND UR.ROL_ID = R.ROL_ID AND E.EMPLEADO_CODIGO = '" + tEmpleado.getText() + "'";
				sqlEmpleado = "SELECT EMPLEADO_CODIGO, NOMBRE, APELLIDO, CI, ESTATUS FROM EMPLEADO WHERE EMPLEADO_CODIGO = '" + tEmpleado.getText() + "'";
			}
			if (!tCedula.getText().isEmpty() && !tEmpleado.getText().isEmpty()) {
				JFrame info = new JFrame();
				JOptionPane.showConfirmDialog(info, "Solo debe ingresar un campo a la vez\npara realizar la busqueda.", "Busqueda", JOptionPane.DEFAULT_OPTION);
				tCedula.setText("");
				tEmpleado.setText("");
				tEmpleado.requestFocus();
			} else if (tCedula.getText().isEmpty() && tEmpleado.getText().isEmpty()) {
				JFrame info = new JFrame();
				JOptionPane.showConfirmDialog(info, "Debe ingresar una Cédula o un Código de Empleado\npara realizar la busqueda.", "Busqueda", JOptionPane.DEFAULT_OPTION);
				tCedula.setText("");
				tEmpleado.setText("");
				tEmpleado.requestFocus();
			} else if (!sqlEmpleado.isEmpty()) {
				try {
					//codEmpleado = ""; nombre = ""; apellido = ""; cedEmpleado = ""; estatus = false;
					ResultSet resEmpleado = ConexionBD.ejecutarConsulta(sqlEmpleado);
					while (resEmpleado.next()) {
						codEmpleado = resEmpleado.getString("EMPLEADO_CODIGO");
						nombre = resEmpleado.getString("NOMBRE");
						apellido = resEmpleado.getString("APELLIDO");
						cedEmpleado = resEmpleado.getString("CI");
						estatus = resEmpleado.getBoolean("ESTATUS");
					}
					System.out.println("COD: " + codEmpleado + " Nom: " + nombre + " Ape: " + apellido + " Ced: " + cedEmpleado + " Est: " + estatus);
					ConexionBD.ejecutarLimpieza();
					if (codEmpleado.isEmpty() && cedEmpleado.isEmpty() && !estatus) {
						JFrame info = new JFrame();
						JOptionPane.showConfirmDialog(info, "No se consigió el empleado con la busqueda indicada\nPor favor, revise los datos introducidos." , "Busqueda", JOptionPane.DEFAULT_OPTION);
						tCedula.setText("");
						tEmpleado.setText("");
						tEmpleado.requestFocus();
					} else if(!codEmpleado.isEmpty() && !cedEmpleado.isEmpty() && !estatus) {
						JFrame info = new JFrame();
						JOptionPane.showConfirmDialog(info, "El empleado que esta indicando esta dado de baja\nPor favor, revise los datos introducidos\nSi nó, contacte con el administrador." , "Busqueda", JOptionPane.DEFAULT_OPTION);
						tCedula.setText("");
						tEmpleado.setText("");
						tEmpleado.requestFocus();
					} else if(!codEmpleado.isEmpty() && !cedEmpleado.isEmpty() && estatus) {
						if (!sql.isEmpty()) {
							try {
								
								//desactivarBotones();
								ResultSet resultado = ConexionBD.ejecutarConsulta(sql);
								while ( resultado.next() ) {
									Object[] rowData = new Object[7];
									rowData[0] = resultado.getString("EMPLEADO_CODIGO");
									rowData[1] = resultado.getString("NOMBRE") + " " + resultado.getString("APELLIDO");
									rowData[2] = resultado.getString("CI");
									rowData[3] = resultado.getString("USUARIO");
									rowData[4] = resultado.getString("DENOMINACION");
									rowData[5] = resultado.getString("ROL");
									rowData[6] = resultado.getBoolean("ESTATUS"); // El getBoolean toma como verdadero el valor 1 y como falso el valor 0, en el campo ESTATUS de tipo Char(1);
									/*
									if (resultado.getInt("ESTATUS") == 1) {
										rowData[6] = "Activo";
									} else {
										rowData[6] = "Inactivo";
									}
									*/
									if (resultado.getBoolean("ESTATUS")) {
										((DefaultTableModel) tUsuarios.getModel()).insertRow(0, rowData);
									} else {
										bModificar.setEnabled(true);
									}
									//System.out.println("ID: " +  resultado.getInt(1) + " - Denominacion: " + resultado.getString(2));
								}
								ConexionBD.ejecutarLimpieza();
								if (tUsuarios.getRowCount() == 0 && !bModificar.isEnabled()) {
									bAgregar.setEnabled(true);
								}
							} catch (SQLException ex) {
								Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
							}
						} // fin if (sql.length() > 0)
					}
				} catch (SQLException ex) {
					Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		} else if (e.getSource() == bAgregar) {
			System.out.println("Agregar");
			try {
				panelAdminUsuarios = new PanelAdminUsuarios(codEmpleado, 0);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			panelAdminUsuarios.setVisible(true);
		} else if (e.getSource() == bModificar) {
			System.out.println("Modificar");
			try {
				panelAdminUsuarios = new PanelAdminUsuarios(codEmpleado, 1);
				String sql = "UPDATE ROLES SET DENOMINACION = 'ADMINISTRADOR' WHERE ROL_ID = 0";
				int res = ConexionBD.ejecutarActualizacion(sql);
				if (isDebug) {
					System.out.println("bModificar - res: " + res);
				}
				ConexionBD.ejecutarLimpieza();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			panelAdminUsuarios.setVisible(true);
			if (panelAdminUsuarios.esCorrecto()) {
				codEmpleado = ""; nombre = ""; apellido = ""; cedEmpleado = ""; estatus = false;
				desactivarBotones();
				while(tUsuarios.getRowCount() > 0) {
		            ((DefaultTableModel) tUsuarios.getModel()).removeRow(0);
		        }
				tCedula.setText("");
				tEmpleado.setText("");
				tEmpleado.requestFocus();
			}
		} else if (e.getSource() == bEliminar) {
			JFrame salir = new JFrame("Salir");
			if (JOptionPane.showConfirmDialog(salir, "Está seguro de querer eliminar al usuario?", "Eliminar Usuario", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
				// FIXME - ELIMINAR USUARIO
				if (isDebug) {
					System.out.println("COD: " + codEmpleado);
				}
				String sql = "UPDATE USUARIO SET ESTATUS = 0 WHERE EMPLEADO_ID IN (SELECT EMPLEADO_ID FROM EMPLEADO WHERE EMPLEADO_CODIGO = '" + codEmpleado + "')";
				try {
					int resultado = ConexionBD.ejecutarActualizacion(sql);
					if (isDebug) {
						System.out.println("bEliminar - res: " + resultado);
					}
					if (resultado == 1) {
						((DefaultTableModel) tUsuarios.getModel()).removeRow(filaSel);
						tCedula.setText("");
						tEmpleado.setText("");
						tEmpleado.requestFocus();
						desactivarBotones();
					}
					ConexionBD.ejecutarLimpieza();
				} catch (SQLException ex) {
					Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

}
