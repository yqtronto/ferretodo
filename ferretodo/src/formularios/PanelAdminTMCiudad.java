package formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

import formularios.PanelAdminTMCiudad;
import formularios.PanelAdminTMCiudad.ModCiudad;
import formularios.PanelAdminTMCiudad.ingresar_ciudad;

public class PanelAdminTMCiudad extends JDialog{

	private JDialog GestionDeCiudades;

	private JTextField cTexto_ciudad;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public PanelAdminTMCiudad() {
		this.setModal(true); 
		this.setTitle("Gestion de Ciudades");
		this.setBounds(100, 100, 402, 351);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(44, 62, 80));
		
		cTexto_ciudad = new JTextField();
		cTexto_ciudad.setColumns(10);
		
		JLabel lblBuscarCiudad = new JLabel("Buscar:");
		lblBuscarCiudad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBuscarCiudad.setForeground(Color.WHITE);
		
		JScrollPane scrollPane;
		

		
//BOTON PARA AGREGAR NUEVA CIUDAD
		
		JButton addButton = new JButton("");
		addButton.setIcon(new ImageIcon("image//nuevo.jpg"));
		addButton.setVisible(true);
		addButton.addActionListener(new ActionListener() {
			ingresar_ciudad dialogo= new ingresar_ciudad();
			public void actionPerformed(ActionEvent arg0) {

				dialogo.setVisible(true);
			
			}
		});

	
		
		
//BOTON PARA ELIMINAR CIUDAD
		
		JButton revButton = new JButton("");
		revButton.setIcon(new ImageIcon("image//borrar.png"));
				

		
//BOTON PARA MODIFICAR CIUDAD
		
		JButton modButton = new JButton("");
		modButton.setIcon(new ImageIcon("image//editar.png"));
	
		modButton.addActionListener(new ActionListener(){
			ModCiudad ciudad=new ModCiudad();
			public void actionPerformed(ActionEvent arg0) {
				ciudad.setVisible(true);
				
			}
		});
		
		ImageIcon iconoOriginal4 = new ImageIcon("image//search.gif");
		int ancho4 = 32; // ancho en pixeles que tendra el icono escalado
		int alto4 = -1; // alto (para que conserve la proporcion pasamos -1)
		ImageIcon iconoEscala4 = new ImageIcon(iconoOriginal4.getImage().getScaledInstance(
				ancho4, alto4, java.awt.Image.SCALE_DEFAULT));
		
//DECLARACION DE LA TABLA DE DATOS
		DefaultTableModel tableModel = new DefaultTableModel(
				new Object[][] {},
				new String[] {"ID", "Ciudad", "Estado"});
		
		table = new JTable(tableModel);
		table.setPreferredSize(new Dimension(600,400));
		table.setVisible(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);
		scrollPane = new JScrollPane(table);
		

		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(modButton, 0, 0, Short.MAX_VALUE)
								.addComponent(revButton, 0, 0, Short.MAX_VALUE)
								.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(lblBuscarCiudad)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cTexto_ciudad, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBuscarCiudad)
						.addComponent(cTexto_ciudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(addButton)
							.addGap(18)
							.addComponent(revButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(modButton)))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		
		this.getContentPane().setLayout(groupLayout);
		
	
	}


	public static void main (String[]args) {
		PanelAdminTMCiudad test = new PanelAdminTMCiudad();
		test.setVisible(true);
	}
	
	
//CLASE PARA GENERAR DIALOGO DE INGRESO DE NUEVA CIUDAD
	class ingresar_ciudad extends JDialog {

		private final JPanel contentPanel = new JPanel();
		private JTextField cTexto_ciudad;
		private JTextField cTexto_estado;
		private JTextField cTexto_id;

		/**
		 * Launch the application.
		 */

		/**
		 * Create the dialog.
		 */
		public ingresar_ciudad() {
			this.setModal(true);
			setTitle("Ingresar Nueva Ciudad");
			setBounds(100, 100, 450, 163);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			
			JLabel lblCiudad = new JLabel("Ciudad");
			
//CAMPO DE TEXTO DEL NOMBRE DE LA NUEVA CIUDAD
			cTexto_ciudad = new JTextField();
			cTexto_ciudad.setColumns(10);

//CAMPO DE TEXTO DEL NOMBRE DEL NUEVO ESTADO
			cTexto_estado = new JTextField();
			cTexto_estado.setColumns(10);
			
//CAMPO DE TEXTO DE ID DE LA NUEVA CIUDAD
			cTexto_id = new JTextField();
			cTexto_id.setEnabled(false);
			cTexto_id.setEditable(false);
			cTexto_id.setColumns(10);
			
			JLabel lblEstado = new JLabel("Estado");
			
			JLabel lblId = new JLabel("ID");
			GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
			gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblId, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(cTexto_id, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(23)
								.addComponent(cTexto_ciudad, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(cTexto_estado, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(79)
								.addComponent(lblCiudad)
								.addPreferredGap(ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
								.addComponent(lblEstado)
								.addGap(96))))
			);
			gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(30)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblId)
							.addComponent(lblCiudad)
							.addComponent(lblEstado))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(cTexto_ciudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(cTexto_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(cTexto_estado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(149, Short.MAX_VALUE))
			);
			contentPanel.setLayout(gl_contentPanel);
			{
				
	
				JPanel buttonPane = new JPanel();
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
//BOTON PARA ACEPTAR Y GUARDAR CAMBIOS
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
				
					}
				});
				

				JButton cancelButton = new JButton("Cancel");
				GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
				gl_buttonPane.setHorizontalGroup(
					gl_buttonPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_buttonPane.createSequentialGroup()
							.addContainerGap(232, Short.MAX_VALUE)
							.addComponent(btnAceptar)
							.addGap(18)
							.addComponent(cancelButton)
							.addGap(6))
						
				);

//BOTON PARA CANCELAR LA OPERACION
				cancelButton.setToolTipText("Cancelar operacion");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				gl_buttonPane.setVerticalGroup(
					gl_buttonPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_buttonPane.createSequentialGroup()
							.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAceptar)
								.addComponent(cancelButton))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
				
				buttonPane.setLayout(gl_buttonPane);
				
			}
		}
	}
	
	public class ModCiudad extends JDialog {

		private final JPanel contentPanel = new JPanel();
		private JTextField cTexto_ciudad;
		private JTextField cTexto_estado;


		public ModCiudad() {
			this.setModal(true);
			setBounds(100, 100, 450, 238);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			JLabel lblModificarCiudad = new JLabel("Modificar Ciudad");
			lblModificarCiudad.setFont(new Font("Tahoma", Font.BOLD, 15));
			
	//CAMPO DE TEXTO PARA MODIFICAR CIUDAD
			JLabel lblCiudad = new JLabel("Ciudad:");
			lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cTexto_ciudad = new JTextField();
			cTexto_ciudad.setColumns(10);
			
	//CAMPO DE TEXTO PARA MODIFICAR ESTADO
			JLabel lblEstado = new JLabel("Estado:");
			lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cTexto_estado = new JTextField();
			cTexto_estado.setColumns(10);
			
			
			GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
			gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(147)
								.addComponent(lblModificarCiudad))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblEstado)
								.addGap(10)
								.addComponent(cTexto_estado, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblCiudad)
								.addGap(10)
								.addComponent(cTexto_ciudad, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(102, Short.MAX_VALUE))
			);
			gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(20)
						.addComponent(lblModificarCiudad)
						.addGap(42)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(cTexto_ciudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblCiudad))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(cTexto_estado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblEstado))
						.addContainerGap(85, Short.MAX_VALUE))
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
					JButton cancelButton = new JButton("Cancel");
					cancelButton.setActionCommand("Cancel");
					buttonPane.add(cancelButton);
					cancelButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
						dispose();
							
						}
					});
					
				}
			}
		}

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
