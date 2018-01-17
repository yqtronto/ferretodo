package formularios;

import java.awt.BorderLayout;
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

import formularios.PanelAdminTMDpto;
import formularios.PanelAdminTMDpto.ModDpto;
import formularios.PanelAdminTMDpto.NuevoDpto;
import java.awt.Color;

public class PanelAdminTMDpto extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PanelAdminTMDpto dialog = new PanelAdminTMDpto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PanelAdminTMDpto() {
		this.setModal(true);
		setBounds(100, 100, 484, 362);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(44, 62, 80));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 124, 315, 156);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Denominaci\u00F3n", "Gerente ", "Ciudad"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblAdministracionDeDepartamentos = new JLabel("Administracion de Departamentos");
		lblAdministracionDeDepartamentos.setForeground(Color.WHITE);
		lblAdministracionDeDepartamentos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdministracionDeDepartamentos.setBounds(115, 23, 262, 14);
		contentPanel.add(lblAdministracionDeDepartamentos);
		
		
//BOTON PARA AGREGAR NUEVO DEPARTAMENTO
		JButton addButton = new JButton("");
		addButton.setIcon(new ImageIcon("image//nuevo.jpg"));
		addButton.setBounds(364, 132, 41, 41);
		contentPanel.add(addButton);
		addButton.addActionListener(new ActionListener() {
			NuevoDpto dpto=new NuevoDpto();
			@Override
			public void actionPerformed(ActionEvent e) {
			dpto.setVisible(true);
				
				
			}
		});

//BOTON PARA ELIMINAR DEPARTAMENTO
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("image//borrar.png"));
		button_1.setBounds(364, 184, 41, 41);
		contentPanel.add(button_1);
		
		
//BOTON PARA MODIFICAR DEPARTAMENTO
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("image//editar.png"));
		button_2.setBounds(364, 236, 41, 44);
		contentPanel.add(button_2);
		
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setBounds(20, 75, 46, 14);
		contentPanel.add(lblBuscar);
		
		cTexto_buscar = new JTextField();
		cTexto_buscar.setBounds(76, 74, 180, 20);
		contentPanel.add(cTexto_buscar);
		cTexto_buscar.setColumns(10);
		button_2.addActionListener(new ActionListener() {
			ModDpto modificar=new ModDpto();
			@Override
			public void actionPerformed(ActionEvent e) {
				modificar.setVisible(true);
				
				
			}
		});
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setBackground(new Color(44, 62, 80));
			{

//BOTON PARA ACEPTAR Y GUARDAR CAMBIOS
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{

//BOTON PARA CANCELAR OPERACION
				
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
	
 class NuevoDpto extends JDialog {

		private final JPanel contentPanel = new JPanel();
		private JTextField cTexto_id;
		private JTextField cTexto_denominacion;
		private JTextField cTexto_gerente;
		private JTextField cTexto_ubicacion;


		public NuevoDpto() {
			this.setModal(true);
			setBounds(100, 100, 450, 242);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			
	//CAMPO DE TEXTO PARA EL ID DEL DEPARTAMENTO

			JLabel lblId = new JLabel("ID:");
			lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cTexto_id = new JTextField();
			cTexto_id.setEnabled(false);
			cTexto_id.setEditable(false);
			cTexto_id.setColumns(10);
			
	//CAMPO DE TEXTO PARA EL NOMBRE DEL DEPARTAMENTO		
			JLabel lblDenominacin = new JLabel("Denominaci\u00F3n:");
			lblDenominacin.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cTexto_denominacion = new JTextField();
			cTexto_denominacion.setToolTipText("Ingrese el nombre del departamento");
			cTexto_denominacion.setColumns(10);

	//CAMPO DE TEXTO PARA EL ID DEL GERENTE
			JLabel lblGerente = new JLabel("Gerente:");
			lblGerente.setFont(new Font("Tahoma", Font.PLAIN, 12));

			cTexto_gerente = new JTextField();
			cTexto_gerente.setToolTipText("Ingrese el ID del gerente del departamento");
			cTexto_gerente.setColumns(10);
			
	//CAMPO DE TEXTO PARA EL ID DE LA CIUDAD
			JLabel lblUbicacion = new JLabel("Ubicaci\u00F3n:");
			lblUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cTexto_ubicacion = new JTextField();
			cTexto_ubicacion.setToolTipText("Ingrese el ID de la ciudad donde se ubica");
			cTexto_ubicacion.setColumns(10);
			
			JLabel lblCrearNuevoDepartamento = new JLabel("Crear Nuevo Departamento");
			lblCrearNuevoDepartamento.setFont(new Font("Tahoma", Font.BOLD, 15));
			GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
			gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblId)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(cTexto_id, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addGap(37)
								.addComponent(lblDenominacin))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblGerente)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(cTexto_gerente, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblUbicacion)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(cTexto_denominacion, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
							.addComponent(cTexto_ubicacion, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(47, Short.MAX_VALUE))
					.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
						.addContainerGap(118, Short.MAX_VALUE)
						.addComponent(lblCrearNuevoDepartamento)
						.addGap(102))
			);
			gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblCrearNuevoDepartamento)
						.addGap(35)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblId)
							.addComponent(cTexto_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblDenominacin)
							.addComponent(cTexto_denominacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(38)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblGerente)
							.addComponent(cTexto_gerente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblUbicacion)
							.addComponent(cTexto_ubicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(87, Short.MAX_VALUE))
			);
			contentPanel.setLayout(gl_contentPanel);
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					
	//BOTON PARA ACEPTAR Y GUARDAR CAMBIOS
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
					
	//BOTON PARA CANCELAR LA OPERACION
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
 
 class ModDpto extends JDialog {

		private final JPanel contentPanel = new JPanel();
		private JTextField cTexto_denominacion;
		private JTextField cTexto_ubicacion;
		private JTextField cTexto_gerente;


		public ModDpto() {
			this.setModal(true);
			setBounds(100, 100, 484, 299);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			JLabel lblModificarDepartamento = new JLabel("Modificar Departamento");
			lblModificarDepartamento.setFont(new Font("Tahoma", Font.BOLD, 15));
			
	//CAMPO DE TEXTO PARA MODIFICAR NOMBRE DE DEPARTAMENTO
			JLabel lblDenominacin = new JLabel("Denominaci\u00F3n:");
			lblDenominacin.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cTexto_denominacion = new JTextField();
			cTexto_denominacion.setColumns(10);
			
	//CAMPO DE TEXTO PARA MODIFICAR CIUDAD
			JLabel lblCiudad = new JLabel("Ciudad:");
			lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cTexto_ubicacion = new JTextField();
			cTexto_ubicacion.setColumns(10);
			
	//CAMPO DE TEXTO PARA MODIFICAR GERENTE
			JLabel lblNewLabel = new JLabel("Gerente:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cTexto_gerente = new JTextField();
			cTexto_gerente.setColumns(10);
			
			GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
			gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(21)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblNewLabel)
									.addComponent(lblDenominacin))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(cTexto_denominacion, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblCiudad)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(cTexto_ubicacion, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
									.addComponent(cTexto_gerente, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(130)
								.addComponent(lblModificarDepartamento)))
						.addContainerGap(80, Short.MAX_VALUE))
			);
			gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(22)
						.addComponent(lblModificarDepartamento)
						.addGap(65)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblDenominacin)
							.addComponent(cTexto_denominacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblCiudad)
							.addComponent(cTexto_ubicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(44)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(cTexto_gerente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(28, Short.MAX_VALUE))
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
	private JTextField cTexto_buscar;
}
