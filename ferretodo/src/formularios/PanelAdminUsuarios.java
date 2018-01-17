/**
 * @author Yhovanny Quintero y Cindy Machado
 */
package formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bd.ConexionBD;

public class PanelAdminUsuarios extends JDialog{

	private static final long serialVersionUID = 1L;
	private static final String TT_USUARIO = "Ingrese el Usuario: ";
	private static final String TT_CLAVE = "Ingrese la Clave: ";
	private static final String TEXT_EMPLEADO = "Cód. Empleado:";
	private static final String TEXT_USUARIO = "Usuario:";
	private static final String TEXT_CLAVE = "Clave:";
	private static final String TEXT_ROLES = "Roles:";
	private static final String TEXT_ESTATUS= "Estatus:";
	private static final String TEXT_MOSTRAR= "Mostrar contraseña";
	private static final String TEXT_TITULO = "Gestión de Usuario";
	private static final String TEXT_CONFIRMAR = "Confirmar si desea cerrar la ventana?";
	private static final int TAMX = 400, TAMY = 300;
	private JTextField txtIDEmpleado;
	private JTextField txtUsuario;
	private JPasswordField pwdClave;
	private JComboBox<Object> comRoles;
	private JCheckBox cheEstatus, cheMostrar;
	private boolean resultado;
	private Dimension pantalla;
	private int posX, posY;
	private String codEmpleado, usuario, clave;
	private String roles;
	private boolean estatus, isDebug = true;
	private int modo, rolID, usuarioID, empleadoID;
	private Vector posi;

	/**
	 * Constructor para inicializar el JDialog el cual recibe unos parámetros para realizar la tarea asignada.
	 * @param codigo - Es el código del empleado que se desea agregar o modificar, este campo no puede ser modificado en este JDialog.
	 * @param modo - Determinar si el JDialog actua para agregar un usuario o editarlo, los calores posibles son 0 - Agregar, 1 - Modificar.
	 * @throws SQLException 
	 */
	public PanelAdminUsuarios(String codigo, int modo) throws SQLException {
		if (!codigo.isEmpty()) {
			this.codEmpleado = codigo;
		} else {
			this.codEmpleado = "";
		}
		this.modo = modo;
		this.usuario = "";
		this.clave = "";
		this.roles = "";
		this.estatus = false;
		posi = new Vector();
		if (modo == 1) {
			String sql = "SELECT U.USUARIO_ID, U.USUARIO, U.CLAVE, U.ESTATUS, E.EMPLEADO_ID, R.ROL_ID, R.DENOMINACION AS ROL FROM USUARIO U, EMPLEADO E, ROLES R, USUARIO_ROLES UR WHERE U.EMPLEADO_ID = E.EMPLEADO_ID AND U.USUARIO_ID = UR.USUARIO_ID AND UR.ROL_ID = R.ROL_ID AND E.EMPLEADO_CODIGO = '" + codEmpleado + "'";
			ResultSet resultado = ConexionBD.ejecutarConsulta(sql);
			while (resultado.next()) {
				usuarioID = resultado.getInt("USUARIO_ID");
				usuario = resultado.getString("USUARIO");
				clave = resultado.getString("CLAVE");
				estatus = resultado.getBoolean("ESTATUS");
				// rolID = resultado.getInt("ROL_ID");
				roles = resultado.getString("ROL");
				empleadoID = resultado.getInt("EMPLEADO_ID");
			}
			ConexionBD.ejecutarLimpieza();
		} else if (modo == 0) {
			String sql = "SELECT EMPLEADO_ID FROM EMPLEADO WHERE EMPLEADO_CODIGO = '" + codEmpleado + "'";
			ResultSet resultado = ConexionBD.ejecutarConsulta(sql);
			while (resultado.next()) {
				empleadoID = resultado.getInt("EMPLEADO_ID");
			}
			ConexionBD.ejecutarLimpieza();
		}
		iniciarPanel();
		llenarRoles();
	}
	
	public void iniciarPanel() {
		// ----- Inicialización del JDialog. ------------------------
		setResizable(false);
		getContentPane().setBackground(new Color(248, 148, 6));
		setModal(true);
		setTitle(TEXT_TITULO);
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        posX = (int) ((pantalla.width - TAMX)/2);
        posY = (int) ((pantalla.height - TAMY)/2);
        setBounds(posX, posY, TAMX, TAMY);
        // ----------------------------------------------------------
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent e){
				JFrame salir = new JFrame("Salir");
				if (JOptionPane.showConfirmDialog(salir, TEXT_CONFIRMAR, TEXT_TITULO, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					resultado = false;
					dispose();
				}
			}
        });

        getContentPane().setLayout(new BorderLayout());
        {
			JPanel pBorde = new JPanel();
			pBorde.setBackground(new Color(248, 148, 6));
			pBorde.setBorder(new EmptyBorder(5, 5, 5, 5));
			pBorde.setLayout(new BorderLayout(0, 0));
			getContentPane().add(pBorde, BorderLayout.CENTER);
			
			JPanel pDatos = new JPanel();
			GridBagLayout gblDatos = new GridBagLayout();
			{
				pDatos.setBackground(new Color(44, 62, 80));
				pDatos.setBorder(new EmptyBorder(10, 10, 10, 10));
				gblDatos.columnWidths = new int[]{0, 100, 200, 0};
				gblDatos.rowHeights = new int[]{0, 0, 0, 0, 0};
				gblDatos.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0};
				gblDatos.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
				pDatos.setLayout(gblDatos);
				
				JLabel lblIDEmpleado = new JLabel(TEXT_EMPLEADO);
				GridBagConstraints gbc_lEmpledo = new GridBagConstraints();
				{
					lblIDEmpleado.setForeground(new Color(255, 255, 255));
					lblIDEmpleado.setFont(new Font("Tahoma", Font.BOLD, 18));
					gbc_lEmpledo.anchor = GridBagConstraints.EAST;
					gbc_lEmpledo.insets = new Insets(0, 0, 5, 5);
					gbc_lEmpledo.gridx = 1;
					gbc_lEmpledo.gridy = 0;
				}
				pDatos.add(lblIDEmpleado, gbc_lEmpledo);

				GridBagConstraints gbc_tEmpleado = new GridBagConstraints();
				{
					txtIDEmpleado = new JTextField();
					txtIDEmpleado.setFont(new Font("Tahoma", Font.BOLD, 12));
					//txtIDEmpleado.setToolTipText("");
					txtIDEmpleado.setEditable(false);
					if (!codEmpleado.isEmpty()) {
						txtIDEmpleado.setText(codEmpleado);
					}
					gbc_tEmpleado.insets = new Insets(0, 0, 5, 5);
					gbc_tEmpleado.fill = GridBagConstraints.HORIZONTAL;
					gbc_tEmpleado.gridx = 2;
					gbc_tEmpleado.gridy = 0;
					txtIDEmpleado.setColumns(15);
				}
				pDatos.add(txtIDEmpleado, gbc_tEmpleado);
				
				JLabel lblUsuario = new JLabel(TEXT_USUARIO);
				GridBagConstraints gbc_lUsuario = new GridBagConstraints();
				{
					lblUsuario.setForeground(new Color(255, 255, 255));
					lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
					gbc_lUsuario.anchor = GridBagConstraints.EAST;
					gbc_lUsuario.insets = new Insets(0, 0, 5, 5);
					gbc_lUsuario.gridx = 1;
					gbc_lUsuario.gridy = 1;
				}
				pDatos.add(lblUsuario, gbc_lUsuario);

				GridBagConstraints gbc_tUsuario = new GridBagConstraints();
				{
					txtUsuario = new JTextField();
					txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
					txtUsuario.setToolTipText(TT_USUARIO);
					if (modo == 1) {
						txtUsuario.setEditable(false);
					}
					if (!usuario.isEmpty()) {
						txtUsuario.setText(usuario);
					}
					gbc_tUsuario.insets = new Insets(0, 0, 5, 5);
					gbc_tUsuario.fill = GridBagConstraints.HORIZONTAL;
					gbc_tUsuario.gridx = 2;
					gbc_tUsuario.gridy = 1;
					txtUsuario.setColumns(15);
				}
				pDatos.add(txtUsuario, gbc_tUsuario);


				JLabel lblClave = new JLabel(TEXT_CLAVE);
				GridBagConstraints gbc_lClave = new GridBagConstraints();
				{
					lblClave.setForeground(new Color(255, 255, 255));
					lblClave.setFont(new Font("Tahoma", Font.BOLD, 18));
					gbc_lClave.anchor = GridBagConstraints.EAST;
					gbc_lClave.insets = new Insets(0, 0, 0, 5);
					gbc_lClave.gridx = 1;
					gbc_lClave.gridy = 2;
				}
				pDatos.add(lblClave, gbc_lClave);

				GridBagConstraints gbc_tClave = new GridBagConstraints();
				{
					pwdClave = new JPasswordField();
					pwdClave.setFont(new Font("Tahoma", Font.BOLD, 12));
					pwdClave.setToolTipText(TT_CLAVE);
					if (!clave.isEmpty()) {
						pwdClave.setText(clave);
					}
					gbc_tClave.insets = new Insets(0, 0, 0, 5);
					gbc_tClave.fill = GridBagConstraints.HORIZONTAL;
					gbc_tClave.gridx = 2;
					gbc_tClave.gridy = 2;
					pwdClave.setColumns(15);
				}
				pDatos.add(pwdClave, gbc_tClave);

				GridBagConstraints gbc_cMostrar = new GridBagConstraints();
				{
					cheMostrar = new JCheckBox(TEXT_MOSTRAR);
					cheMostrar.setFont(new Font("Tahoma", Font.BOLD, 14));
					cheMostrar.setForeground(new Color(255, 255, 255));
					cheMostrar.setBackground(new Color(44, 62, 80));
					cheMostrar.addItemListener(new ItemListener() {
						@Override
						public void itemStateChanged(ItemEvent e) {
							if (e.getStateChange() == ItemEvent.SELECTED) {
								//System.out.println(pwdClave.getEchoChar());
					        	pwdClave.setEchoChar((char) 0);
					        } else {
					            pwdClave.setEchoChar('•');
					        }
						}
					});
					//comRoles.setFont(new Font("Tahoma", Font.BOLD, 12));
					//comRoles.setToolTipText(TT_CLAVE);
					gbc_cMostrar.insets = new Insets(0, 0, 0, 5);
					gbc_cMostrar.fill = GridBagConstraints.HORIZONTAL;
					gbc_cMostrar.gridx = 2;
					gbc_cMostrar.gridy = 3;
					//pwdClave.setColumns(15);
				}
				pDatos.add(cheMostrar, gbc_cMostrar);

				JLabel lblRoles = new JLabel(TEXT_ROLES);
				GridBagConstraints gbc_lRoles = new GridBagConstraints();
				{
					lblRoles.setForeground(new Color(255, 255, 255));
					lblRoles.setFont(new Font("Tahoma", Font.BOLD, 18));
					gbc_lRoles.anchor = GridBagConstraints.EAST;
					gbc_lRoles.insets = new Insets(0, 0, 0, 5);
					gbc_lRoles.gridx = 1;
					gbc_lRoles.gridy = 4;
				}
				pDatos.add(lblRoles, gbc_lRoles);

				GridBagConstraints gbc_tRoles = new GridBagConstraints();
				{
					comRoles = new JComboBox<>();
					comRoles.setFont(new Font("Tahoma", Font.BOLD, 12));
					//comRoles.setToolTipText(TT_CLAVE);
					gbc_tRoles.insets = new Insets(0, 0, 0, 5);
					gbc_tRoles.fill = GridBagConstraints.HORIZONTAL;
					gbc_tRoles.gridx = 2;
					gbc_tRoles.gridy = 4;
					pwdClave.setColumns(15);
				}
				pDatos.add(comRoles, gbc_tRoles);
			
				JLabel lblEstatus = new JLabel(TEXT_ESTATUS);
				GridBagConstraints gbc_lEstatus = new GridBagConstraints();
				{
					lblEstatus.setForeground(new Color(255, 255, 255));
					lblEstatus.setFont(new Font("Tahoma", Font.BOLD, 18));
					gbc_lEstatus.anchor = GridBagConstraints.EAST;
					gbc_lEstatus.insets = new Insets(0, 0, 0, 5);
					gbc_lEstatus.gridx = 1;
					gbc_lEstatus.gridy = 5;
				}
				//pDatos.add(lblEstatus, gbc_lEstatus);

				GridBagConstraints gbc_tEstatus = new GridBagConstraints();
				{
					cheEstatus = new JCheckBox(TEXT_ESTATUS);
					cheEstatus.setFont(new Font("Tahoma", Font.BOLD, 18));
					cheEstatus.setForeground(new Color(255, 255, 255));
					cheEstatus.setBackground(new Color(44, 62, 80));
					cheEstatus.setSelected(estatus);
					//comRoles.setFont(new Font("Tahoma", Font.BOLD, 12));
					//comRoles.setToolTipText(TT_CLAVE);
					gbc_tEstatus.insets = new Insets(0, 0, 0, 5);
					gbc_tEstatus.fill = GridBagConstraints.HORIZONTAL;
					gbc_tEstatus.gridx = 2;
					gbc_tEstatus.gridy = 5;
					//pwdClave.setColumns(15);
				}
				pDatos.add(cheEstatus, gbc_tEstatus);

			}
			pBorde.add(pDatos, BorderLayout.CENTER);
			
			// TODO - Panel de Botones
			JPanel pBotones = new JPanel();
			{
				pBotones.setBackground(new Color(44, 62, 80));
				pBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
				JButton bAceptar = new JButton("Ingresar");
				{
					bAceptar.setFont(new Font("Tahoma", Font.BOLD, 12));
					bAceptar.setBackground(new Color(34, 167, 240));
					bAceptar.setActionCommand("Ingresar");
					bAceptar.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							int est = 0;
							if (cheEstatus.isSelected()) {
								est = 1;
							}
							// TODO - Boton Ingresar
							if (modo == 0) {
								// Modo Agregar.
								JFrame salir = new JFrame();
								if (JOptionPane.showConfirmDialog(salir, "Esta seguro de agregar al usuario?", TEXT_TITULO, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
									int nuevoID = 0;
									String sql = "SELECT COUNT(*) AS ID FROM USUARIO";
									ResultSet res;
									try {
										res = ConexionBD.ejecutarConsulta(sql);
										while (res.next()) {
											nuevoID = res.getInt("ID");
										}
										ConexionBD.ejecutarLimpieza();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									sql = "INSERT INTO USUARIO (USUARIO_ID, EMPLEADO_ID, USUARIO, CLAVE, ESTATUS) VALUES (" + nuevoID + ", " + empleadoID + ", '" + txtUsuario.getText() + "', '" + pwdClave.getText() + "', " + est + ")";
									try {
										int resu = ConexionBD.ejecutarActualizacion(sql);
										if (isDebug) {
											System.out.println("Agregar Usuario - res: " + resu);
										}
										ConexionBD.ejecutarLimpieza();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									sql = "INSERT INTO USUARIO_ROLES (USUARIO_ID, ROL_ID) VALUES (" + nuevoID + ", " + posi.elementAt(comRoles.getSelectedIndex()) + ")";
									try {
										int resu = ConexionBD.ejecutarActualizacion(sql);
										if (isDebug) {
											System.out.println("Agregar Usuario_Roles - res: " + resu);
										}
										ConexionBD.ejecutarLimpieza();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									resultado = true;
									dispose();
								}
							} else if (modo == 1) {
								// Modo Modificar.
								JFrame salir = new JFrame();
								if (JOptionPane.showConfirmDialog(salir, "Esta seguro de realizar los cambios?", TEXT_TITULO, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
									//System.out.println(pwdClave.getPassword().toString());
									String sql = "UPDATE USUARIO SET ESTATUS = " + est + ", CLAVE = '" + pwdClave.getText() + "' WHERE EMPLEADO_ID IN (SELECT EMPLEADO_ID FROM EMPLEADO WHERE EMPLEADO_CODIGO = '" + codEmpleado + "')";
									try {
										int res = ConexionBD.ejecutarActualizacion(sql);
										if (isDebug) {
											System.out.println("Modificar - res: " + res);
										}
										ConexionBD.ejecutarLimpieza();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									sql = "UPDATE USUARIO_ROLES SET ROL_ID = " + posi.elementAt(comRoles.getSelectedIndex()) + " WHERE USUARIO_ID = " + usuarioID;
									try {
										int res = ConexionBD.ejecutarActualizacion(sql);
										if (isDebug) {
											System.out.println("Modificar - res: " + res);
										}
										ConexionBD.ejecutarLimpieza();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									resultado = true;
									dispose();
								}
								// System.out.println(posi.elementAt(comRoles.getSelectedIndex()));
							}
							// dispose();
						}
					});
					getRootPane().setDefaultButton(bAceptar);
				}
				pBotones.add(bAceptar);

				JButton bCancelar = new JButton("Cancelar");
				{
					bCancelar.setBackground(new Color(192, 57, 43));
					bCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
					bCancelar.setActionCommand("Cancelar");
					bCancelar.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							JFrame salir = new JFrame("Salir");
							if (JOptionPane.showConfirmDialog(salir, TEXT_CONFIRMAR, TEXT_TITULO, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
								// System.exit(0);
								resultado = false;
								dispose();
							}
						}
					});
				}
				pBotones.add(bCancelar);

			}
			pBorde.add(pBotones, BorderLayout.SOUTH);
			
        }
		
	}
	
	private void llenarRoles() throws SQLException {
		comRoles.removeAllItems();
		rolID = 0;
		String sql = "SELECT ROL_ID, DENOMINACION AS ROL, ESTATUS FROM ROLES ORDER BY DENOMINACION ASC";
		ResultSet resultado = ConexionBD.ejecutarConsulta(sql);
		while (resultado.next()) {
			comRoles.addItem(resultado.getString("ROL"));
			posi.addElement(resultado.getInt("ROL_ID"));
			if (resultado.getString("ROL").equals(roles)) {
				rolID = resultado.getInt("ROL_ID");
			}
		}
		comRoles.setSelectedIndex(rolID);
		ConexionBD.ejecutarLimpieza();
	}

    public boolean esCorrecto() {
        return resultado;
    }

}
