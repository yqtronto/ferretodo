package formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import formularios.PanelAdminTMRol;
import formularios.PanelAdminTMRol.ModRol;
import formularios.PanelAdminTMRol.NuevoRol;

public class PanelAdminTMRol extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField cTexto_buscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception{

		
		try {
			PanelAdminTMRol dialog = new PanelAdminTMRol();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PanelAdminTMRol() {
		setModal(true);
		setTitle("Roles");
		setBounds(100, 100, 450, 376);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBackground(new Color(44, 62, 80));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 152, 310, 147);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID del Rol", "Rol"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(61);
		table.getColumnModel().getColumn(1).setPreferredWidth(174);
		scrollPane.setViewportView(table);
		contentPanel.setLayout(null);
		contentPanel.add(scrollPane);
		
//BOTON PARA AGREGAR NUEVO ROL
		JButton addButton = new JButton("");
		addButton.setIcon(new ImageIcon("image//nuevo.jpg"));	
		addButton.setBounds(343, 152, 36, 41);
		contentPanel.add(addButton);
		addButton.addActionListener(new ActionListener() {
			NuevoRol rol=new NuevoRol();
			public void actionPerformed(ActionEvent e) {
				rol.setVisible(true);
			}
		});

//BOTON PARA ELIMINAR ROL
		JButton delButton = new JButton("");	
		delButton.setIcon(new ImageIcon("image//borrar.png"));
		delButton.setBounds(343, 205, 36, 36);
		contentPanel.add(delButton);
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		

//BOTON PARA MODIFICAR ROL
		JButton modButton = new JButton("");
		modButton.setIcon(new ImageIcon("image//editar.png"));
		modButton.setBounds(343, 258, 36, 41);
		contentPanel.add(modButton);
		modButton.addActionListener(new ActionListener() {
			ModRol rol= new ModRol();
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rol.setVisible(true); 
			}
		});
		
		JLabel lblAdministracionDeRoles = new JLabel("Administracion de Roles");
		lblAdministracionDeRoles.setForeground(Color.WHITE);
		lblAdministracionDeRoles.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdministracionDeRoles.setBounds(119, 23, 200, 23);
		contentPanel.add(lblAdministracionDeRoles);
		
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setBounds(23, 94, 52, 14);
		contentPanel.add(lblBuscar);
		
		cTexto_buscar = new JTextField();
		cTexto_buscar.setBounds(80, 93, 200, 20);
		contentPanel.add(cTexto_buscar);
		cTexto_buscar.setColumns(10);
		{

	
		}
	}
	
	class NuevoRol extends JDialog {

		private final JPanel contentPanel = new JPanel();
		private JTextField cTexto_rol;
		private JTextField cTexto_id;
		private JTextField cTexto_estatus;

//CONSTRUCTOR DE LA CLASE
		public NuevoRol() {
			this.setModal(true);
			setBounds(100, 100, 450, 216);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);

	//CAMPO DE TEXTO DE NUEVO ROL
			cTexto_rol = new JTextField();
			cTexto_rol.setColumns(10);
			
	//CAMPO DE TOEXTO DE ID
			cTexto_id = new JTextField();
			cTexto_id.setEditable(false);
			cTexto_id.setEnabled(false);
			cTexto_id.setColumns(10);
			
			JLabel lblRol = new JLabel("Rol");
			lblRol.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			JLabel lblId = new JLabel("ID");
			lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			JLabel lblIngresarNuevoRol = new JLabel("Ingresar Nuevo Rol");
			lblIngresarNuevoRol.setFont(new Font("Tahoma", Font.BOLD, 15));
			
	//CAMPO DE TEXTO DE ESTADO DEL ROL
			cTexto_estatus = new JTextField();
			cTexto_estatus.setColumns(10);
			
			JLabel lblEstatus = new JLabel("Estatus");
			lblEstatus.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
			gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(37)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
									.addComponent(cTexto_id, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(cTexto_rol, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(cTexto_estatus, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(80)
										.addComponent(lblRol)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblEstatus)
										.addGap(47))))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(126)
								.addComponent(lblIngresarNuevoRol)))
						.addContainerGap(30, Short.MAX_VALUE))
			);
			gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblIngresarNuevoRol)
						.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblId)
							.addComponent(lblRol)
							.addComponent(lblEstatus))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(cTexto_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(cTexto_rol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(cTexto_estatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(37))
			);
			contentPanel.setLayout(gl_contentPanel);
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					
	//BOTON "OK"
					JButton okButton = new JButton("OK");
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
					okButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							
							
							
						}
				});
				{
					
	//BOTON "CANCEL"
					JButton cancelButton = new JButton("Cancel");
					cancelButton.setActionCommand("Cancel");
					buttonPane.add(cancelButton);
					cancelButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							dispose();
						}
					});
				}
			}
		
	}
		}
		
	}

	class ModRol extends JDialog {

		private final JPanel contentPanel = new JPanel();
		private JTextField cTexto_id;
		private JTextField cTexto_rol;


		public ModRol() {
			this.setModal(true); 
			setBounds(100, 100, 450, 204);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			JLabel lblModificarRol = new JLabel("Modificar Rol");
			lblModificarRol.setFont(new Font("Tahoma", Font.BOLD, 15));
			
	//CAMPO DE TEXTO PARA EL ID DEL ROL A MODIFICAR
			JLabel lblNewLabel = new JLabel("ID:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cTexto_id = new JTextField();
			cTexto_id.setEnabled(false);
			cTexto_id.setEditable(false);
			cTexto_id.setColumns(10);
			
	//CAMPO DE TEXTO PARA MODIFICAR EL ROL
			JLabel lblRol = new JLabel("Rol:");
			lblRol.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cTexto_rol = new JTextField();
			cTexto_rol.setColumns(10);
			
			
			GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
			gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(154)
								.addComponent(lblModificarRol))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(19)
								.addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(cTexto_id, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(27)
								.addComponent(lblRol)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(cTexto_rol, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(51, Short.MAX_VALUE))
			);
			gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(23)
						.addComponent(lblModificarRol)
						.addGap(44)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(cTexto_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblRol)
							.addComponent(cTexto_rol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(119, Short.MAX_VALUE))
			);
			contentPanel.setLayout(gl_contentPanel);
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					
	//BOTON "OK"
					JButton okButton = new JButton("OK");
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
					
					okButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							
						}
					});
				}
				{
					
	//BOTON "CANCELAR"
					JButton cancelButton = new JButton("Cancelar");
					cancelButton.setActionCommand("Cancel");
					buttonPane.add(cancelButton);
					cancelButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							dispose();
						}
					});
				}
			}
		}

	}


}
