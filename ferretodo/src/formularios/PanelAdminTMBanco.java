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

import formularios.PanelAdminTMBanco;
import formularios.PanelAdminTMBanco.ModBanco;
import formularios.PanelAdminTMBanco.NuevoBanco;
import java.awt.Color;

public class PanelAdminTMBanco extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private JTextField cTexto_denominacion;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PanelAdminTMBanco dialog = new PanelAdminTMBanco();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PanelAdminTMBanco() {
		this.setModal(true); 
		setBounds(100, 100, 459, 268);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(44, 62, 80));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			cTexto_denominacion = new JTextField();
			cTexto_denominacion.setBounds(120, 36, 181, 20);
			contentPanel.add(cTexto_denominacion);
			cTexto_denominacion.setColumns(10);
		}
		{
			JLabel lblDenominacin = new JLabel("Denominaci\u00F3n:");
			lblDenominacin.setForeground(Color.WHITE);
			lblDenominacin.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDenominacin.setBounds(10, 37, 118, 14);
			contentPanel.add(lblDenominacin);
		}
		{
			ImageIcon iconoOriginal4 = new ImageIcon("image//search.gif");
			int ancho4 = 15; // ancho en pixeles que tendra el icono escalado
			int alto4 = -1; // alto (para que conserve la proporcion pasamos -1)
			ImageIcon iconoEscala4 = new ImageIcon(iconoOriginal4.getImage().getScaledInstance(
					ancho4, alto4, java.awt.Image.SCALE_DEFAULT));
		}
		{

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 67, 325, 133);
			contentPanel.add(scrollPane);
			{
//CREACION DE LA TABLA
				table = new JTable();
				table.getTableHeader().setReorderingAllowed(false);
				table.setDefaultEditor(Object.class, null);


		
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{null},
					},
					new String[] {
						"Entidad Bancaria"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				scrollPane.setViewportView(table);
				table.setRowHeight(20);
			}
		}
		{
			JButton addButton = new JButton("");
			addButton.setIcon(new ImageIcon("image//nuevo.jpg"));
			addButton.setBounds(345, 64, 39, 38);
			contentPanel.add(addButton);
			addButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					NuevoBanco banco=new NuevoBanco();
					banco.setVisible(true);
				}
			});
			
			
		}
		{
//BOTON DE ELIMINAR REGISTROS
			
			JButton delButton = new JButton("");
			delButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			delButton.setIcon(new ImageIcon("image//borrar.png"));
			delButton.setBounds(345, 113, 39, 38);
			contentPanel.add(delButton);
		}
		{
			
//BOTON DE MODIFICAR REGISTROS
			
			JButton modButton = new JButton("");
			modButton.setIcon(new ImageIcon("image//editar.png"));
			modButton.setBounds(345, 162, 39, 38);
			contentPanel.add(modButton);
			modButton.addActionListener(new ActionListener() {
				ModBanco banco=new ModBanco();
				@Override
				public void actionPerformed(ActionEvent e) {
					banco.setVisible(true);
					
				}
			});
		}
	}

	
	class NuevoBanco extends JDialog {

		private final JPanel contentPanel = new JPanel();
		private JTextField cTexto_id;
		private JTextField cTexto_denominacion;


		public NuevoBanco() {
			this.setModal(true);
			setBounds(100, 100, 450, 186);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);

//CAMPO DE TEXTO PARA EL ID DEL BANCO
			cTexto_id = new JTextField();
			cTexto_id.setEnabled(false);
			cTexto_id.setEditable(false);
			cTexto_id.setColumns(10);

//CAMPO DE TEXTO PARA LA ENTIDAD BANCARIA
			cTexto_denominacion = new JTextField();
			cTexto_denominacion.setColumns(10);
			JLabel lblId = new JLabel("ID");
			lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
			JLabel lblDenominacin = new JLabel("Denominaci\u00F3n");
			lblDenominacin.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			JLabel lblIngreseNuevoBanco = new JLabel("Ingrese Nuevo Banco");
			lblIngreseNuevoBanco.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			
			GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
			gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addContainerGap()
								.addComponent(cTexto_id, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(cTexto_denominacion, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(19)
								.addComponent(lblId)
								.addGap(136)
								.addComponent(lblDenominacin))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(128)
								.addComponent(lblIngreseNuevoBanco)))
						.addContainerGap(91, Short.MAX_VALUE))
			);
			gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblIngreseNuevoBanco)
						.addGap(22)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblId)
							.addComponent(lblDenominacin))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(cTexto_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(cTexto_denominacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(18, Short.MAX_VALUE))
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
//*************INGRESE CODIGO DEL BOTON
							
						}
					});
				}
				{
	
//BOTON "CANCELAR"
					JButton cancelButton = new JButton("Cancelar");
					cancelButton.setActionCommand("Cancelar");
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
	
class ModBanco extends JDialog {

		private final JPanel contentPanel = new JPanel();
		private JTextField textField;


		public ModBanco() {
			this.setModal(true);
			setBounds(100, 100, 450, 215);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			JLabel lblModificarEntidadBancaria = new JLabel("Modificar Entidad Bancaria");
			lblModificarEntidadBancaria.setFont(new Font("Tahoma", Font.BOLD, 15));

	//CAMPO DE TEXTO PARA MODIFICAR ENTIDAD BANCARIA
			JLabel lblEntidadBancaria = new JLabel("Entidad Bancaria:");
			lblEntidadBancaria.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textField = new JTextField();
			textField.setColumns(10);
			
			
			GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
			gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
						.addContainerGap(113, Short.MAX_VALUE)
						.addComponent(lblModificarEntidadBancaria)
						.addGap(110))
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(19)
						.addComponent(lblEntidadBancaria)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(43, Short.MAX_VALUE))
			);
			gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(22)
						.addComponent(lblModificarEntidadBancaria)
						.addGap(50)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblEntidadBancaria)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(114, Short.MAX_VALUE))
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
							
	//****************INSERTE CODIGO
							
						}
					});
				}
				{
					
	//BOTON "CANCELAR"
					JButton cancelButton = new JButton("Cancelar");
					cancelButton.setActionCommand("Cancelar");
					buttonPane.add(cancelButton);
					cancelButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							dispose();
							
						}
					} );
				}
			}
		}

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
