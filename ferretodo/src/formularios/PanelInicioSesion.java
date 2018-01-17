package formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bd.ConexionBD;

import javax.swing.JButton;
import javax.swing.JDialog;

public class PanelInicioSesion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String TT_USUARIO = "Ingrese el Usuario: ";
	private static final String TT_CLAVE = "Ingrese la Clave: ";
	private static final String TEXT_USUARIO = "Usuario:";
	private static final String TEXT_CLAVE = "Clave:";
	private static final String TEXT_TITULO = "Inicio de Sesi�n";
	private static final String TEXT_CONFIRMAR = "Confirmar si desea cancelar el inicio de sesi�n?";
	private static final int TAMX = 400, TAMY = 160;
	private JTextField tUsuario;
	private JPasswordField tClave;
	private boolean resultado;
	private Dimension pantalla;
	private int posX, posY;
	private boolean isDebug = true;
	
	/**
	 * Constructor para inicializar el PanelInicioSesion.
	 */
	public PanelInicioSesion() {
		// ----- Inicializaci�n del JDialog. ------------------------
		setResizable(false);
		getContentPane().setBackground(new Color(248, 148, 6));
		setModal(true);
		setTitle(TEXT_TITULO);
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        posX = (int) ((pantalla.width - TAMX)/2);
        posY = (int) ((pantalla.height - TAMY)/2);
        setBounds(posX, posY, TAMX, TAMY);
        addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				JFrame salir = new JFrame("Salir");
				if (JOptionPane.showConfirmDialog(salir, "Realmente desea salir de la aplicaci�n?", TEXT_TITULO, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
        // ----------------------------------------------------------
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
				gblDatos.rowHeights = new int[]{0, 0};
				gblDatos.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0};
				gblDatos.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
				pDatos.setLayout(gblDatos);
				
				JLabel lblUsuario = new JLabel(TEXT_USUARIO);
				GridBagConstraints gbc_lUsuario = new GridBagConstraints();
				{
					lblUsuario.setForeground(new Color(255, 255, 255));
					lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
					gbc_lUsuario.anchor = GridBagConstraints.EAST;
					gbc_lUsuario.insets = new Insets(0, 0, 5, 5);
					gbc_lUsuario.gridx = 1;
					gbc_lUsuario.gridy = 0;
				}
				pDatos.add(lblUsuario, gbc_lUsuario);

				GridBagConstraints gbc_tUsuario = new GridBagConstraints();
				{
					tUsuario = new JTextField();
					tUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
					tUsuario.setToolTipText(TT_USUARIO);
					gbc_tUsuario.insets = new Insets(0, 0, 5, 5);
					gbc_tUsuario.fill = GridBagConstraints.HORIZONTAL;
					gbc_tUsuario.gridx = 2;
					gbc_tUsuario.gridy = 0;
					tUsuario.setColumns(15);
				}
				pDatos.add(tUsuario, gbc_tUsuario);

				JLabel lblClave = new JLabel(TEXT_CLAVE);
				GridBagConstraints gbc_lClave = new GridBagConstraints();
				{
					lblClave.setForeground(new Color(255, 255, 255));
					lblClave.setFont(new Font("Tahoma", Font.BOLD, 20));
					gbc_lClave.anchor = GridBagConstraints.EAST;
					gbc_lClave.insets = new Insets(0, 0, 0, 5);
					gbc_lClave.gridx = 1;
					gbc_lClave.gridy = 1;
				}
				pDatos.add(lblClave, gbc_lClave);

				GridBagConstraints gbc_tClave = new GridBagConstraints();
				{
					tClave = new JPasswordField();
					tClave.setFont(new Font("Tahoma", Font.BOLD, 12));
					tClave.setToolTipText(TT_CLAVE);
					gbc_tClave.insets = new Insets(0, 0, 0, 5);
					gbc_tClave.fill = GridBagConstraints.HORIZONTAL;
					gbc_tClave.gridx = 2;
					gbc_tClave.gridy = 1;
					tClave.setColumns(15);
				}
				pDatos.add(tClave, gbc_tClave);

			
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
							// TODO - Boton Ingresar
							if (isDebug) {
								resultado = true;
								dispose();
							} else {
								try {
									int estado = Login.autentificar(getUsuario(), getClave());
									if ( estado > 0 ) {
										if ( estado == 1 ) {
										JOptionPane.showMessageDialog(PanelInicioSesion.this,
									            "Hola " + getUsuario() + "� Ha ingresado correctamente !",
									            "Ingreso",
									            JOptionPane.INFORMATION_MESSAGE);
										resultado = true;
										dispose();
										} else {
											JOptionPane.showMessageDialog(PanelInicioSesion.this,
										            "Hola " + getUsuario() + "� Su sesi�n se encuentra suspendido, contacte con administrador. !",
										            "Ingreso",
										            JOptionPane.INFORMATION_MESSAGE);
											tUsuario.setText("");
											tClave.setText("");
											tUsuario.requestFocus();
											resultado = false;
										}
									} else {
										JOptionPane.showMessageDialog(PanelInicioSesion.this,
												"Usuario o Contrase�a inv�lida",
									            "Ingreso",
									            JOptionPane.ERROR_MESSAGE);
										tUsuario.setText("");
										tClave.setText("");
										tUsuario.requestFocus();
										resultado = false;
									}
								} catch (HeadlessException | SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
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
								System.exit(0);
							}
						}
					});
				}
				pBotones.add(bCancelar);

			}
			pBorde.add(pBotones, BorderLayout.SOUTH);

        }
        
        
	}
	
	public String getUsuario() {
        return tUsuario.getText().trim();
    }
 
    public String getClave() {
        return new String(tClave.getPassword());
    }
 
    public boolean esCorrecto() {
        return resultado;
    }
	
}

class Login {
	 
    protected static int autentificar(String usuario, String clave) throws SQLException {
        // 
    	
    	String sql = "SELECT USUARIO, CLAVE, ESTATUS FROM USUARIO WHERE USUARIO = '" + usuario + "' AND CLAVE = '" + clave + "'";
    	ResultSet resultado = ConexionBD.ejecutarConsulta(sql);
    	while (resultado.next()) {
    		if (resultado.getInt(3) == 1) {
    			ConexionBD.ejecutarLimpieza();
    			return 1;
    		} else {
    			ConexionBD.ejecutarLimpieza();
    			return 2;
    		}
    	}
    	/*
        if (usuario.equals("SYSTEM") && clave.equals("123456")) {
            return true;
        }
        */
        return 0;
    }
}
