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

import formularios.PanelAdminModuloSistema;
import formularios.PanelAdminModuloSistema.ModModulos;
import formularios.PanelAdminModuloSistema.NuevoModulo;

public class PanelAdminModuloSistema extends JDialog{


		private final JPanel contentPanel = new JPanel();
		private JTable table;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			try {
				PanelAdminModuloSistema dialog = new PanelAdminModuloSistema();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * Create the dialog.
		 */
		public PanelAdminModuloSistema() {
			this.setModal(true);
			setBounds(100, 100, 518, 309);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPanel.setBackground(new Color(44, 62, 80));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			JLabel lblAdministracionDeModulos = new JLabel("Administracion de Modulos del Sistema");
			lblAdministracionDeModulos.setForeground(Color.WHITE);
			lblAdministracionDeModulos.setFont(new Font("Tahoma", Font.BOLD, 15));
			JScrollPane scrollPane = new JScrollPane();
			
	//BOTON PARA AGREGAR MODULO
			JButton addButton = new JButton("");
			addButton.setIcon(new ImageIcon("image//nuevo.jpg"));
			addButton.addActionListener(new ActionListener() {
				NuevoModulo modulo=new NuevoModulo();
				@Override
				public void actionPerformed(ActionEvent e) {
					modulo.setVisible(true);
					
				}
			});
			
	//BOTON PARA ELIMINAR MODULO
			JButton delButton = new JButton("");
			delButton.setIcon(new ImageIcon("image//borrar.png"));
			delButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
	//BOTON PARA MODIFICAR MODULO
			JButton modButton = new JButton("");
			modButton.setIcon(new ImageIcon("image//editar.png"));
			modButton.addActionListener(new ActionListener() {
				ModModulos modulo=new ModModulos();
				@Override
				public void actionPerformed(ActionEvent e) {
					modulo.setVisible(true);
					
				}
			});
			
			JLabel lblBuscar = new JLabel("Buscar:");
			lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblBuscar.setForeground(Color.WHITE);
			
			cTexto_buscar = new JTextField();
			cTexto_buscar.setColumns(10);
			
			GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
			gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(64)
								.addComponent(lblAdministracionDeModulos))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(25)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(lblBuscar)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(cTexto_buscar, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(delButton, 0, 0, Short.MAX_VALUE)
											.addComponent(addButton, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 41, Short.MAX_VALUE)
											.addComponent(modButton, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 41, Short.MAX_VALUE))))))
						.addGap(75))
			);
			gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblAdministracionDeModulos)
						.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblBuscar)
							.addComponent(cTexto_buscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(addButton)
								.addGap(9)
								.addComponent(delButton)
								.addGap(15)
								.addComponent(modButton)))
						.addGap(19))
			);
			{
				
	//TABLA DE MODULOS EXISTENTES
				
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {},	new String[] {"ID", "Denominaci\u00F3n"}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				table.getColumnModel().getColumn(0).setPreferredWidth(27);
				table.getColumnModel().getColumn(1).setPreferredWidth(200);
				scrollPane.setViewportView(table);
			}
			contentPanel.setLayout(gl_contentPanel);
		}
		
		class NuevoModulo extends JDialog {

			private final JPanel contentPanel = new JPanel();
			private JTextField textField;
			private JTextField textField_1;


			public NuevoModulo() {
				this.setModal(true); 
				setBounds(100, 100, 450, 195);
				getContentPane().setLayout(new BorderLayout());
				contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
				getContentPane().add(contentPanel, BorderLayout.CENTER);
				JLabel lblIngrezarNuevoModulo = new JLabel("Ingrezar Nuevo Modulo");
				lblIngrezarNuevoModulo.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				
		//CAMPO DE TEXTO PARA ID
				JLabel lblId = new JLabel("ID:");
				lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
				textField = new JTextField();
				textField.setEnabled(false);
				textField.setEditable(false);
				textField.setColumns(10);
				
		//CAMPO DE TEXTO PARA DENOMINACION DEL NUEVO MODULO
				JLabel lblDenominacin = new JLabel("Denominaci\u00F3n:");
				lblDenominacin.setFont(new Font("Tahoma", Font.PLAIN, 12));
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				
				
				GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
				gl_contentPanel.setHorizontalGroup(
					gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(21)
							.addComponent(lblId)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblDenominacin)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblIngrezarNuevoModulo))
							.addContainerGap(32, Short.MAX_VALUE))
				);
				gl_contentPanel.setVerticalGroup(
					gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblIngrezarNuevoModulo)
							.addGap(39)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblId)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDenominacin)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(136, Short.MAX_VALUE))
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
		//******************* INGRESAR CODIGO		
							}
						});
					}
					{
						
		//BOTON "CANCELAR"
						JButton cancelButton = new JButton("Cancelar");
						cancelButton.setActionCommand("Cancelar");
						buttonPane.add(cancelButton);
						cancelButton.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								dispose();
								
							}
						});
					}
				
			}

		}
		}
		
		class ModModulos extends JDialog {

			private final JPanel contentPanel = new JPanel();
			private JTextField textField;


			public ModModulos() {
				this.setModal(true); 
				setBounds(100, 100, 450, 219);
				getContentPane().setLayout(new BorderLayout());
				contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
				getContentPane().add(contentPanel, BorderLayout.CENTER);
				JLabel lblModificarModulo = new JLabel("Modificar Modulo");
				lblModificarModulo.setFont(new Font("Tahoma", Font.BOLD, 15));
				JLabel lblNewLabel = new JLabel("Denominaci\u00F3n:");
				textField = new JTextField();
				textField.setColumns(10);
				GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
				gl_contentPanel.setHorizontalGroup(
					gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(142)
									.addComponent(lblModificarModulo))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField)))
							.addContainerGap(153, Short.MAX_VALUE))
				);
				gl_contentPanel.setVerticalGroup(
					gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblModificarModulo)
							.addGap(34)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(141, Short.MAX_VALUE))
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
		//***************** INGRESAR CODIGO
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField cTexto_buscar;

}
