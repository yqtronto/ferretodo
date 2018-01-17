package formularios;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import formularios.PanelAdmin;

public class PanelAdmin extends JDialog{
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PanelAdmin dialog = new PanelAdmin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PanelAdmin() {
		getContentPane().setForeground(Color.WHITE);
		this.setModal(true);		
		setBounds(100, 100, 559, 515);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(44, 62, 80));

	
//LISTA DESPLEGABLE DE ROLES DISPONIBLES EN EL SISTEMA
		Choice choice = new Choice();
		choice.setBounds(44, 85, 332, 20);
		contentPanel.add(choice);
		
		JLabel lblRolesDisponiblesEn = new JLabel("Roles Disponibles en la BD");
		lblRolesDisponiblesEn.setForeground(Color.WHITE);
		lblRolesDisponiblesEn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRolesDisponiblesEn.setBounds(79, 65, 148, 14);
		contentPanel.add(lblRolesDisponiblesEn);
		
//LISTA DE MODULOS ASIGNABLES
		JList list = new JList();
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setBounds(31, 173, 171, 186);
		contentPanel.add(list);
		
//LISTA DE MODULOS ASIGNADOS
		JList list_1 = new JList();
		list_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list_1.setBounds(352, 173, 171, 186);
		contentPanel.add(list_1);
		
//BOTON PARA ASIGNAR UN MODULO
		JButton addButton = new JButton("");
		addButton.setIcon(new ImageIcon("image//nuevo.jpg"));
		addButton.setBounds(259, 193, 36, 41);
		contentPanel.add(addButton);
		
//BOTON PARA QUITAR UN MODULO
		JButton delButton = new JButton("");
		delButton.setIcon(new ImageIcon("image//borrar.png"));
		delButton.setBounds(259, 244, 36, 41);
		contentPanel.add(delButton);
		
//BOTON PARA ASIGNAR TODOS LOS MODULOS A UN ROL
		JButton btnAsignarTodo = new JButton("Asignar Todo");
		btnAsignarTodo.setBounds(226, 296, 105, 23);
		contentPanel.add(btnAsignarTodo);

//BOTON PARA ACEPTAR Y GUARDAR LOS CAMBIOS
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(161, 431, 89, 23);
		contentPanel.add(btnAceptar);
		
//BOTON PARA CANCELAR LA OPERACION
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(306, 431, 89, 23);
		contentPanel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		JLabel lblModulosAsignables = new JLabel("Modulos Asignables");
		lblModulosAsignables.setForeground(Color.WHITE);
		lblModulosAsignables.setBounds(75, 148, 95, 14);
		contentPanel.add(lblModulosAsignables);
		
		JLabel lblModulosAsigandos = new JLabel("Modulos Asigandos");
		lblModulosAsigandos.setForeground(Color.WHITE);
		lblModulosAsigandos.setBounds(394, 148, 95, 14);
		contentPanel.add(lblModulosAsigandos);
		
		JLabel lblAsignacionDeModulos = new JLabel("Asignacion de Modulos ");
		lblAsignacionDeModulos.setForeground(Color.WHITE);
		lblAsignacionDeModulos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAsignacionDeModulos.setBounds(191, 24, 190, 14);
		contentPanel.add(lblAsignacionDeModulos);
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
