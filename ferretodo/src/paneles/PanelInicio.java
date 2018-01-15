package paneles;

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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;

public class PanelInicio extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String TT_USUARIO = "Ingrese el Usuario: ";
	private static final String TT_CLAVE = "Ingrese la Clave: ";
	private static final String TEXT_USUARIO = "Usuario:";
	private static final String TEXT_CLAVE = "Clave:";
	private static final String TEXT_TITULO = "Inicio de Sesión";
	private static final String TEXT_CONFIRMAR = "Confirmar si desea cancelar el inicio de sesión?";
	private static final int TAMX = 400, TAMY = 160;
	private JTextField tUsuario;
	private JPasswordField tClave;
	private boolean resultado;
	private Dimension pantalla;
	private int posX, posY;
	
	/**
	 * Constructor para inicializar el PanelInicio.
	 */
	public PanelInicio() {
		// XXX - Borrar Estos comentarios
		//super();
		//controlMarco = marco;
		//controlMarco.setTitle("Ingreso");
//		controlMarco.setIconImage(icono.getImage());
		//Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    //int x = (int) ((dimension.getWidth() - controlMarco.getWidth()) / 2);
	    //int y = (int) ((dimension.getHeight() - controlMarco.getHeight()) / 2);
	    //controlMarco.setLocation(x - (tamX / 2), y - (tamY / 2));
	    // controlMarco.setLocation(220,20); // Posición del JFrame en el escritorio.
		//controlMarco.setSize(tamX, tamY);
		//controlMarco.setResizable(false);
		//controlMarco.setLayout(new BorderLayout());
		//controlMarco.setLocationRelativeTo(marco);
        // marco = getSize();
		//setSize(400, 160);
        //setLocation(((pantalla.width - marco.width)/2), (pantalla.height - marco.height)/2);

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

        
        /*
        setLayout(new BorderLayout());
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gb = new GridBagConstraints();
		gb.fill = GridBagConstraints.HORIZONTAL;

		lUsuario = new JLabel(TEXTO_USUARIO);
		gb.gridx = 0;
		gb.gridy = 0;
		gb.gridwidth = 1;
		panel.add(lUsuario, gb);
		
		cUsuario = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 0;
		gb.gridwidth = 2;
		panel.add(cUsuario, gb);

		lClave = new JLabel(TEXTO_CLAVE);
		gb.gridx = 0;
		gb.gridy = 1;
		gb.gridwidth = 1;
		panel.add(lClave, gb);

		cClave = new JPasswordField(20);
		gb.gridx = 1;
		gb.gridy = 1;
		gb.gridwidth = 2;
		panel.add(cClave, gb);
		panel.setBorder(new LineBorder(Color.GRAY));
		*/
        
        /*
		bAceptar = new JButton("Ingresar");
		bAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// esCorrecto = true;
				// dispose();
				if (Login.authenticate(getUsername(), getPassword())) {
					JOptionPane.showMessageDialog(PanelInicio.this,
                            "Hola " + getUsername() + "¡ Ha ingresado correctamente !",
                            "Ingreso",
                            JOptionPane.INFORMATION_MESSAGE);
					esCorrecto = true;
					
					dispose();
				} else {
					JOptionPane.showMessageDialog(PanelInicio.this,
							"Usuario o Contraseña inválida",
                            "Ingreso",
                            JOptionPane.ERROR_MESSAGE);
					cUsuario.setText("");
					cClave.setText("");
					esCorrecto = false;		
					
				}
			}
		});
		
		bCancelar = new JButton("Cancelar");
		bCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame salir = new JFrame("Salir");
				if (JOptionPane.showConfirmDialog(salir, "Confirmar si desea cancelar", "Inicio de Sessión", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		
		JPanel bPanel = new JPanel();
		bPanel.add(bAceptar);
		bPanel.add(bCancelar);
		
		
		//controlMarco.getContentPane().add(panel, BorderLayout.CENTER);
		//controlMarco.getContentPane().add(bPanel, BorderLayout.PAGE_END);
		add(panel, BorderLayout.CENTER);
		add(bPanel, BorderLayout.PAGE_END);
		
		//controlMarco.pack();
		//controlMarco.setResizable(false);
		//controlMarco.setLocationRelativeTo(marco);
		*/
        
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
							resultado = true;
							dispose();
							/*
							if (Login.autentificar(getUsuario(), getClave())) {
								
								JOptionPane.showMessageDialog(PanelInicio.this,
			                            "Hola " + getUsuario() + "¡ Ha ingresado correctamente !",
			                            "Ingreso",
			                            JOptionPane.INFORMATION_MESSAGE);
								resultado = true;
								dispose();
							} else {
								JOptionPane.showMessageDialog(PanelInicio.this,
										"Usuario o Contraseña inválida",
			                            "Ingreso",
			                            JOptionPane.ERROR_MESSAGE);
								tUsuario.setText("");
								tClave.setText("");
								resultado = false;		
							}
							*/
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
	 
    protected static boolean autentificar(String usuario, String clave) {
        // 
        if (usuario.equals("SYSTEM") && clave.equals("123456")) {
            return true;
        }
        return false;
    }
}
