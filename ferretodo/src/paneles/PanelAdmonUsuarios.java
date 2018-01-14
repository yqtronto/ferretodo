package paneles;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PanelAdmonUsuarios extends JPanel{

	/**
	 * @author Yhovanny Quintero y Cindy Machado
	 */
	private static final long serialVersionUID = 1L;
	private static final String TEXTO_EMPLEADO = "ID Empleado:";
	private static final String TEXTO_CEDULA = "Cedula:";
	private static final String BOTON_BUSCAR = "Buscar";
	private JTextField cEmpleado;
	private JTextField cCedula;
	private JLabel lEmpleado;
	private JLabel lCedula;

	private JButton bBuscar;
	private JButton bAgregar;
	private JButton bModificar;
	private JButton bEliminar;
	
	private JTable tUsuario;
	
	public PanelAdmonUsuarios() {
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBounds(50, 50, 640, 480);
		GridBagConstraints gb = new GridBagConstraints();
		gb.fill = GridBagConstraints.HORIZONTAL;
		
		lEmpleado = new JLabel(TEXTO_EMPLEADO);
		gb.gridx = 0;
		gb.gridy = 0;
		gb.weightx = 0.5;
		panel.add(lEmpleado, gb);

		cEmpleado = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 0;
		gb.weightx = 1.5;
		panel.add(cEmpleado, gb);

		lCedula = new JLabel(TEXTO_CEDULA);
		gb.gridx = 3;
		gb.gridy = 0;
		gb.weightx  = 0.5;
		panel.add(lCedula, gb);

		cCedula = new JTextField(20);
		gb.gridx = 4;
		gb.gridy = 0;
		gb.weightx = 1.5;
		panel.add(cCedula, gb);
		
		bBuscar = new JButton(BOTON_BUSCAR);
		bBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (true) {
					
				}
			}
		});
		gb.gridx = 2;
		gb.gridy = 1;
		gb.weightx = 2;
		panel.add(bBuscar, gb);

		add(panel, BorderLayout.PAGE_START);

	}

}
