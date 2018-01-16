/**
 * @author Yhovanny Quintero y Cindy Machado
 */
package paneles;

import formularios.PanelAdminUsuarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class PanelAdmonUsuarios extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String TEXTO_EMPLEADO = "ID Empleado:";
	private static final String TEXTO_CEDULA = "Cedula:";
	private static final String TEXTO_BUSCAR = "Buscar";
	private JTextField tEmpleado;
	private JTextField tCedula;
	private JButton bBuscar;
	private JButton bAgregar;
	private JButton bModificar;
	private JButton bEliminar;
	private JTable tUsuarios;
	private PanelAdminUsuarios panelAdminUsuarios;
	
	public PanelAdmonUsuarios() {
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(2, 2, 2, 2));
		{
			JPanel pNorte = new JPanel();
			pNorte.setBorder(new EmptyBorder(2, 2, 2, 2));
			pNorte.setLayout(new BorderLayout());
			
			JPanel pTitulo = new JPanel();
			pTitulo.setBorder(new EmptyBorder(30, 10, 30, 10));
			pTitulo.setBackground(new Color(44, 62, 80));
			pTitulo.setLayout(new GridLayout(1, 1, 1, 1));
			{
				JLabel lblTitulo = new JLabel("GESTION DE USUARIOS");
				lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
				lblTitulo.setForeground(new Color(255, 255, 255));
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				pTitulo.add(lblTitulo);
			}
			pNorte.add(pTitulo, BorderLayout.NORTH);
			
			// XXX ========== PANEL BUSQUEDA ========== 
			JPanel pBusqueda = new JPanel();
			pBusqueda.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			GridBagLayout gbl_pBusqueda = new GridBagLayout();
			{
				gbl_pBusqueda.columnWidths = new int[]{0, 100, 200, 100, 0};
				gbl_pBusqueda.rowHeights = new int[]{0};
				gbl_pBusqueda.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0};
				gbl_pBusqueda.rowWeights = new double[]{0.0};
			}
			pBusqueda.setLayout(gbl_pBusqueda);
			{
				JPanel pEtiquetas = new JPanel();
				pEtiquetas.setBorder(new EmptyBorder(20, 5, 20, 5));
				pEtiquetas.setLayout(new GridLayout(2, 1, 1, 5));
				GridBagConstraints gbc_pEtiquetas = new GridBagConstraints();
				{
					gbc_pEtiquetas.anchor = GridBagConstraints.EAST;
					gbc_pEtiquetas.insets = new Insets(0, 0, 0, 5);
					gbc_pEtiquetas.gridx = 1;
					gbc_pEtiquetas.gridy = 0;
				}
				pBusqueda.add(pEtiquetas, gbc_pEtiquetas);
				{
					JLabel lblEmpleado = new JLabel(TEXTO_EMPLEADO);
					lblEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);
					pEtiquetas.add(lblEmpleado);
				}
				{
					JLabel lblCedula = new JLabel(TEXTO_CEDULA);
					lblCedula.setHorizontalAlignment(SwingConstants.RIGHT);
					pEtiquetas.add(lblCedula);
				}

				JPanel pCajasTextos = new JPanel();
				pCajasTextos.setBorder(new EmptyBorder(20, 5, 20, 5));
				pCajasTextos.setLayout(new GridLayout(2, 1, 1, 5));
				GridBagConstraints gbc_pCajasTextos = new GridBagConstraints();
				{
					gbc_pCajasTextos.anchor = GridBagConstraints.WEST;
					gbc_pCajasTextos.insets = new Insets(0, 0, 0, 5);
					gbc_pCajasTextos.gridx = 2;
					gbc_pCajasTextos.gridy = 0;
				}
				pBusqueda.add(pCajasTextos, gbc_pCajasTextos);
				{
					tEmpleado = new JTextField();
					tEmpleado.setColumns(20);
					pCajasTextos.add(tEmpleado);
				}
				{
					tCedula = new JTextField();
					tCedula.setColumns(20);
					pCajasTextos.add(tCedula);
				}
				
				JPanel pBotonBuscar = new JPanel();
				pBotonBuscar.setBorder(new EmptyBorder(20, 5, 20, 5));
				pBotonBuscar.setLayout(new GridLayout(1, 1, 2, 2));
				GridBagConstraints gbc_pBotonBuscar = new GridBagConstraints();
				{
					gbc_pBotonBuscar.anchor = GridBagConstraints.CENTER;
					gbc_pBotonBuscar.insets = new Insets(0, 0, 0, 0);
					gbc_pBotonBuscar.gridx = 3;
					gbc_pBotonBuscar.gridy = 0;
				}
				pBusqueda.add(pBotonBuscar, gbc_pBotonBuscar);
				{
					bBuscar = new JButton(TEXTO_BUSCAR);
					bBuscar.setIcon( icono("image//FindUser_32px.png", 30, 30));
					bBuscar.addActionListener(this);
					pBotonBuscar.add(bBuscar);
				}

			}
			
			pNorte.add(pBusqueda,  BorderLayout.CENTER);
			add(pNorte, BorderLayout.NORTH);
			
			// Panel Central.
			JPanel pCentral = new JPanel();
			pCentral.setBorder(new EmptyBorder(10, 10, 10, 10));
			pCentral.setLayout(new BorderLayout(0, 0));
			
			JPanel pBotonera = new JPanel();
			pBotonera.setLayout(new BorderLayout(0, 0));
			{
				JPanel pBotonesAcciones = new JPanel();
				pBotonesAcciones.setBorder(new EmptyBorder(5, 5, 5, 5));
				pBotonera.add(pBotonesAcciones, BorderLayout.EAST);
				
				bAgregar = new JButton();
				bAgregar.setIcon( icono("image//AddUser_32px.png", 30, 30));
				bAgregar.addActionListener(this);
				pBotonesAcciones.add(bAgregar);
				
				bModificar = new JButton();
				bModificar.setIcon( icono("image//EditUser_32px.png", 30, 30));
				bModificar.addActionListener(this);
				pBotonesAcciones.add(bModificar);
				
				bEliminar = new JButton();
				bEliminar.setIcon( icono("image//DeleteUser_32px.png", 30, 30));
				bEliminar.addActionListener(this);
				pBotonesAcciones.add(bEliminar);
			}
			pCentral.add(pBotonera, BorderLayout.NORTH);

			JPanel pTabla = new JPanel();
			pTabla.setBorder(new EmptyBorder(5, 5, 5, 5));
			pTabla.setLayout(new GridLayout(0, 1, 0, 0));
			{
				String[] nColumnas = {"ID Empleado", "Nombre y Apellido", "Cedula", "Departamento", "ROLES", "ESTATUS"};
				tUsuarios = new JTable();
				tUsuarios.setBorder(new EmptyBorder(5, 5, 5, 5));
				tUsuarios.setModel(new DefaultTableModel(nColumnas, 0) {
					private static final long serialVersionUID = 1L;
					@SuppressWarnings("rawtypes")
					Class[] columnTypes = new Class[] {
							String.class, String.class, String.class, Object.class, Object.class, Boolean.class
					};
					@SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				tUsuarios.getColumnModel().getColumn(0).setResizable(false);
				tUsuarios.getColumnModel().getColumn(0).setPreferredWidth(100);
				tUsuarios.getColumnModel().getColumn(0).setMinWidth(100);
				tUsuarios.getColumnModel().getColumn(0).setMaxWidth(100);
				tUsuarios.getColumnModel().getColumn(1).setPreferredWidth(200);
				tUsuarios.getColumnModel().getColumn(1).setMinWidth(200);
				tUsuarios.getColumnModel().getColumn(1).setMaxWidth(300);
				tUsuarios.getColumnModel().getColumn(2).setResizable(false);
				tUsuarios.getColumnModel().getColumn(2).setPreferredWidth(70);
				tUsuarios.getColumnModel().getColumn(2).setMinWidth(70);
				tUsuarios.getColumnModel().getColumn(2).setMaxWidth(80);
				tUsuarios.getColumnModel().getColumn(3).setPreferredWidth(100);
				tUsuarios.getColumnModel().getColumn(3).setMinWidth(100);
				tUsuarios.getColumnModel().getColumn(3).setMaxWidth(200);
				tUsuarios.getColumnModel().getColumn(4).setPreferredWidth(150);
				tUsuarios.getColumnModel().getColumn(4).setMinWidth(150);
				tUsuarios.getColumnModel().getColumn(4).setMaxWidth(300);
				tUsuarios.getColumnModel().getColumn(5).setResizable(false);
				tUsuarios.getColumnModel().getColumn(5).setPreferredWidth(70);
				tUsuarios.getColumnModel().getColumn(5).setMinWidth(70);
				tUsuarios.getColumnModel().getColumn(5).setMaxWidth(70);
				tUsuarios.setFillsViewportHeight(false);
				tUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			}
			JScrollPane scrollPane = new JScrollPane(tUsuarios);
	        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			pTabla.add(scrollPane);
			pCentral.add(pTabla, BorderLayout.CENTER);
			add(pCentral, BorderLayout.CENTER);
		}
	}
	
	protected ImageIcon icono (String direccion, int tamW, int tamH) {
		ImageIcon icon = new ImageIcon(direccion);
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(tamW, tamH,  java.awt.Image.SCALE_SMOOTH );
        return new ImageIcon( newimg );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// FIXME ===== actionPerformed - Manejo de eventos de los botones Agregar, Modificar, Eliminar y Buscar.
		if ( e.getSource() == bBuscar ) {
			System.out.println("Buscar");
		} else if (e.getSource() == bAgregar) {
			System.out.println("Agregar");
			panelAdminUsuarios = new PanelAdminUsuarios();
			panelAdminUsuarios.setVisible(true);
		} else if (e.getSource() == bModificar) {
			System.out.println("Modificar");
		} else if (e.getSource() == bEliminar) {
			System.out.println("Eliminar");
		}
	}

}
