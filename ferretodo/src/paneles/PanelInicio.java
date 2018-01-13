package paneles;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JDialog;;


public class PanelInicio extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String TEXTO_USUARIO = "Ingrese el Usuario: ";
	private static final String TEXTO_CLAVE = "Ingrese la Clave: ";
	private static final int tamX = 400;
	private static final int tamY = 150;
	private JFrame controlMarco;
	private JTextField cUsuario;
	private JPasswordField cClave;
	private JLabel lUsuario;
	private JLabel lClave;
	private JButton bAceptar;
	private JButton bCancelar;
	private boolean esCorrecto;
	
	//public PanelInicio(JFrame marco) {
	public PanelInicio() {
		super();
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
		
		bAceptar = new JButton("Ingresar");
		bAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
		
	}
	
	public String getUsername() {
        return cUsuario.getText().trim();
    }
 
    public String getPassword() {
        return new String(cClave.getPassword());
    }
 
    public boolean isSucceeded() {
        return esCorrecto;
    }
	
    
}

class Login {
	 
    public static boolean authenticate(String username, String password) {
        // hardcoded username and password
        if (username.equals("SYSTEM") && password.equals("123456")) {
            return true;
        }
        return false;
    }
}
