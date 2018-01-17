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

import formularios.PanelAdminTMFormaPago;
import formularios.PanelAdminTMFormaPago.ModPago;
import formularios.PanelAdminTMFormaPago.NuevoPago;

public class PanelAdminTMFormaPago extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PanelAdminTMFormaPago dialog = new PanelAdminTMFormaPago();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PanelAdminTMFormaPago() {
		this.setModal(true); 
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBackground(new Color(44, 62, 80));
		
		JLabel lblAdministracinDeTipos = new JLabel("Administraci\u00F3n de Tipos de Pagos");
		lblAdministracinDeTipos.setForeground(Color.WHITE);
		lblAdministracinDeTipos.setFont(new Font("Tahoma", Font.BOLD, 15));
		JScrollPane scrollPane = new JScrollPane();
		
//BOTON PARA AGREGAR UN NUEVO TIPO DE PAGO
		JButton addButton = new JButton("");
		addButton.setIcon(new ImageIcon("image//nuevo.jpg"));
		addButton.addActionListener(new ActionListener() {
			NuevoPago pago=new NuevoPago();
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pago.setVisible(true);
			}
		});
		
//BOTON PARA ELIMINAR TIPO DE PAGO
		JButton delButton = new JButton("");
		delButton.setIcon(new ImageIcon("image//borrar.png"));
		delButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
//BOTON PARA MODIFICAR TIPO DE PAGO
		JButton modButton = new JButton("");
		modButton.setIcon(new ImageIcon("image//editar.png"));
		modButton.addActionListener(new ActionListener() {
			ModPago modpag=new ModPago();
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				modpag.setVisible(true);
			}
		});
		
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBuscar.setForeground(Color.WHITE);
		
		textField = new JTextField();
		textField.setColumns(10);
		 
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAdministracinDeTipos)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(modButton, 0, 0, Short.MAX_VALUE)
								.addComponent(delButton, 0, 0, Short.MAX_VALUE)
								.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 41, Short.MAX_VALUE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(19)
							.addComponent(lblBuscar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(21)
					.addComponent(lblAdministracinDeTipos)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBuscar)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(addButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(delButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(modButton)))
					.addGap(27))
		);
		{
			
//TABLA DE TIPOS DE PAGOS
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Denominaci\u00F3n"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			table.getColumnModel().getColumn(0).setPreferredWidth(41);
			table.getColumnModel().getColumn(1).setPreferredWidth(181);
			scrollPane.setViewportView(table);
		}
		contentPanel.setLayout(gl_contentPanel);
	}
	public class NuevoPago extends JDialog {

		private final JPanel contentPanel = new JPanel();
		private JTextField cTexto_id;
		private JTextField cTexto_pago;


		public NuevoPago() {
			this.setModal(true); 
			setBounds(100, 100, 450, 217);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			JLabel lblIngresarNuevoTipo = new JLabel("Ingresar Nuevo Tipo de Pago");
			lblIngresarNuevoTipo.setFont(new Font("Tahoma", Font.BOLD, 15));

//CAMPO DE TEXTO DE ID DEL TIPO DE PAGO
			JLabel lblId = new JLabel("ID:");
			lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cTexto_id = new JTextField();
			cTexto_id.setEnabled(false);
			cTexto_id.setEditable(false);
			cTexto_id.setColumns(10);
			
//CAMPO DE TEXTO DEL NUEVO TIPO DE PAGO
			JLabel lblTipoDePago = new JLabel("Tipo de Pago:");
			lblTipoDePago.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cTexto_pago = new JTextField();
			cTexto_pago.setColumns(10);
			
			
			GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
			gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
						.addContainerGap(107, Short.MAX_VALUE)
						.addComponent(lblIngresarNuevoTipo)
						.addGap(101))
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblId)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cTexto_id, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addGap(26)
						.addComponent(lblTipoDePago)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cTexto_pago, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(63, Short.MAX_VALUE))
			);
			gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblIngresarNuevoTipo)
						.addGap(44)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblId)
							.addComponent(cTexto_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTipoDePago)
							.addComponent(cTexto_pago, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(131, Short.MAX_VALUE))
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
	
	public class ModPago extends JDialog {

		private final JPanel contentPanel = new JPanel();
		private JTextField cTexto_id;
		private JTextField cTexto_pago;


		public ModPago() {
			this.setModal(true);
			setBounds(100, 100, 450, 197);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			JLabel lblModificarTipoDe = new JLabel("Modificar Tipo de Pago");
			lblModificarTipoDe.setFont(new Font("Tahoma", Font.BOLD, 15));
			
//CAMPO DE TEXTO PARA ID DE TIPO DE PAGO A MODIFICAR
			JLabel lblId = new JLabel("ID:");
			cTexto_id = new JTextField();
			cTexto_id.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cTexto_id.setEditable(false);
			cTexto_id.setEnabled(false);
			cTexto_id.setColumns(10);
			
//CAMPO DE TEXTO PARA TIPO DE PAGO A MODIFICAR
			JLabel lblTipoDePago = new JLabel("Tipo de Pago:");
			cTexto_pago = new JTextField();
			cTexto_pago.setColumns(10);
			
			
			GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
			gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(124)
								.addComponent(lblModificarTipoDe))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblId)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(cTexto_id, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addGap(29)
								.addComponent(lblTipoDePago)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(cTexto_pago, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(45, Short.MAX_VALUE))
			);
			gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblModificarTipoDe)
						.addGap(43)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblId)
							.addComponent(cTexto_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTipoDePago)
							.addComponent(cTexto_pago, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(132, Short.MAX_VALUE))
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
							// TODO Auto-generated method stub
							dispose();
						}
					});			}
			}
		}

	}


}
