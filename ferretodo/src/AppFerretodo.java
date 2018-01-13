import javax.swing.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class AppFerretodo extends JFrame implements ActionListener, ItemListener {
	
	// Textos Botones de Barra de Herramientas.
	static final private String FACTURA = "Facturación";
    static final private String CLIENTE = "Clientes";
    static final private String ORDEN_PAGO = "Orden de Pago";
    static final private String PRODUCTO = "Productos";
    static final private String PROVEEDOR = "Proveedores";
    static final private String EMPLEADO = "Empleados";
    static final private String USUARIO = "Usuarios";
    
    // Textos Menú Items.
    static final private String MENUITEM_EMITIR_FACTURAS = "Emitir Facturas";
    static final private String MENUITEM_GESTION_FACTURAS = "Gestionar Facturas";
    static final private String MENUITEM_GESTION_CLIENTES = "Gestionar Cientes";
    static final private String MENUITEM_CATALOGO_PRODUCTO = "Catalogo de Productos";
    static final private String MENUITEM_GESTION_ORDEN_PAGO = "Gestionar Orden de Pago";
    static final private String MENUITEM_INCENTIVOS_VENTAS_EMPLEADOS = "Incentivos por Ventas a los Empleados";
    static final private String MENUITEM_PROVEEDORES = "Proveedores";
    static final private String MENUITEM_SUCURSALES = "Sucursales";
    static final private String MENUITEM_ADMINISTRACION_CARGOS = "Administración de Cargos";
    static final private String MENUITEM_GESTION_EMPLEADOS = "Gestionar Empleados";
    static final private String MENUITEM_INCENTIVOS_EMPLEADOS = "Incestivos al Empleado";
    static final private String MENUITEM_VENTAS = "Ventas";
    static final private String MENUITEM_USUARIOS = "Usuarios";

    
	ImageIcon icono;
	Container cp;
	JLabel etiqueta_nombre;
	JTextField textField_nombre;
	JButton boton_saludo;
	JLabel etiqueta_equipo;
	JToolBar barra_herramientas;
	JMenuBar menuBarra;
    JMenu menu, menuSecundario;
    JMenuItem menuItem;
	
	public AppFerretodo(String titulo) {
		setTitle(titulo);
		icono = new ImageIcon("image//sucursal.png");
		setIconImage(icono.getImage());
		setLocation(220,20); // posicion del JFrame en el escritorio.
		setSize(800, 600);
		addComponentes();
		//addTabla();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setJMenuBar(agregarMenuBarra());
		setVisible(true);
		//setResizable(false);
	}
	
	protected JMenuBar agregarMenuBarra() {
		// Creamos la instancia de la Barra de Menus.
        menuBarra = new JMenuBar();

        //-----------------------------------------------------------------------------------
        // Menú Ventas
        menu = agregarMenu("Ventas", KeyEvent.VK_V, "Menú ventas.");
        menuBarra.add(menu);
        // Sub Menú Ventas.
        //menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem = agregarMenuItem(MENUITEM_EMITIR_FACTURAS, KeyEvent.VK_E, null, MENUITEM_EMITIR_FACTURAS, "Emisión de las Facturas.");
        menu.add(menuItem);
        // menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        menuItem = agregarMenuItem(MENUITEM_GESTION_FACTURAS, KeyEvent.VK_G, null, MENUITEM_GESTION_FACTURAS, "Gestión de las Facturas ingresadas.");
        menu.add(menuItem);
        // menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
        menuItem = agregarMenuItem(MENUITEM_GESTION_CLIENTES, KeyEvent.VK_C, null, MENUITEM_GESTION_CLIENTES, "Gestión de las Facturas ingresadas.");
        menu.add(menuItem);

        
        //-----------------------------------------------------------------------------------
        // Menú Gestión Administrativa
        menu = agregarMenu("Gestión Administrativa", KeyEvent.VK_G, "Gestión Administrativa.");
        menuBarra.add(menu);
        // Sub Gestión Administrativa.
        menuItem = agregarMenuItem(MENUITEM_CATALOGO_PRODUCTO, KeyEvent.VK_C, null, MENUITEM_CATALOGO_PRODUCTO, "Catálogo de Productos.");
        menu.add(menuItem);
        menuItem = agregarMenuItem(MENUITEM_GESTION_ORDEN_PAGO, KeyEvent.VK_G, null, MENUITEM_GESTION_ORDEN_PAGO, "Gestión de las Ordenes de Pagos.");
        menu.add(menuItem);
        menuItem = agregarMenuItem(MENUITEM_INCENTIVOS_VENTAS_EMPLEADOS, KeyEvent.VK_I, null, MENUITEM_INCENTIVOS_VENTAS_EMPLEADOS, "Incentivos por Ventas a los Empleados.");
        menu.add(menuItem);
        menuItem = agregarMenuItem(MENUITEM_PROVEEDORES, KeyEvent.VK_P, null, MENUITEM_PROVEEDORES, "Proveedores.");
        menu.add(menuItem);
        menuItem = agregarMenuItem(MENUITEM_SUCURSALES, KeyEvent.VK_S, null, MENUITEM_SUCURSALES, "Gestión de las Sucursales.");
        menu.add(menuItem);
        
        
        //-----------------------------------------------------------------------------------
        // Menú Recursos Humanos
        menu = agregarMenu("Recursos Humanos", KeyEvent.VK_R, "Recursos Humanos.");
        menuBarra.add(menu);
        // Sub Recursos Humanos.
        menuItem = agregarMenuItem(MENUITEM_ADMINISTRACION_CARGOS, KeyEvent.VK_A, null, MENUITEM_ADMINISTRACION_CARGOS, "Gestión de las Facturas ingresadas.");
        menu.add(menuItem);
        menuItem = agregarMenuItem(MENUITEM_GESTION_EMPLEADOS, KeyEvent.VK_G, null, MENUITEM_GESTION_EMPLEADOS, "Gestión de los Empleados.");
        menu.add(menuItem);
        menuItem = agregarMenuItem(MENUITEM_INCENTIVOS_EMPLEADOS, KeyEvent.VK_I, null, MENUITEM_INCENTIVOS_EMPLEADOS, "Incentivos al Empleado.");
        menu.add(menuItem);
        
        
        //-----------------------------------------------------------------------------------
        // Menú Consultas
        menu = agregarMenu("Consultas", KeyEvent.VK_C, "Consultas.");
        menuBarra.add(menu);
        // Sub Menú Consultas.
        menuItem = agregarMenuItem(MENUITEM_VENTAS, KeyEvent.VK_V, null, MENUITEM_VENTAS, "Ventas");
        menu.add(menuItem);

        
        //-----------------------------------------------------------------------------------
        // Menú Administración del Sistema
        menu = agregarMenu("Administración del Sistema", KeyEvent.VK_A, "Administración del Sistema.");
        menuBarra.add(menu);
        // Sub Menú Administración del Sistema.
        menuItem = agregarMenuItem(MENUITEM_USUARIOS, KeyEvent.VK_U, null, MENUITEM_USUARIOS, "Usuarios");
        menu.add(menuItem);

        
        return menuBarra;
	}
	
	protected JMenu agregarMenu(String textMenu, int teclaEvento, String descripcionAccesible) {
		JMenu menu = new JMenu(textMenu);
        menu.setMnemonic(teclaEvento);
        menu.getAccessibleContext().setAccessibleDescription(descripcionAccesible);
        return menu;
	}
	
	protected JMenuItem agregarMenuItem(String textoMenu, int teclaEvento, KeyStroke teclaAcelerador, String comandoAccion, String descripcionAccesible) {
		JMenuItem menuItem = new JMenuItem(textoMenu,teclaEvento);
		if (teclaAcelerador != null) {
			menuItem.setAccelerator(teclaAcelerador);
		}
		menuItem.setActionCommand(comandoAccion);
        menuItem.addActionListener(this);
		return menuItem;
	}

	protected void agregarToolBar(JToolBar toolBar) {
		JButton boton = null;
		
		boton = agregarBoton("factura", FACTURA, "Facturación", FACTURA);
		toolBar.add(boton);
			
		boton = agregarBoton("clientes", CLIENTE, "Clientes", CLIENTE);
		toolBar.add(boton);
		
		//separador
        toolBar.addSeparator();

		boton = agregarBoton("odp", ORDEN_PAGO, "Generar Orden de Pago", ORDEN_PAGO);
		toolBar.add(boton);

		boton = agregarBoton("inventario", PRODUCTO, "Productos", PRODUCTO);
		toolBar.add(boton);

		boton = agregarBoton("proveedor", PROVEEDOR, "Proveedores", PROVEEDOR);
		toolBar.add(boton);
		
		//separador
        toolBar.addSeparator();

		boton = agregarBoton("empleados", EMPLEADO, "Empleados", EMPLEADO);
		toolBar.add(boton);

		boton = agregarBoton("usr", USUARIO, "Usuarios", USUARIO);
		toolBar.add(boton);

		
		
	}
	
	protected JButton agregarBoton(String nombreImagen, String comandoAction, String textoInformativo, String textoAlternativo) {
		//Look for the image.
		String locacionImagen = "image/" + nombreImagen + ".png";
	
		//Create and initialize the button.
		JButton boton = new JButton();
		boton.setActionCommand(comandoAction);
		boton.setToolTipText(textoInformativo);
		boton.addActionListener(this);
		
		if (locacionImagen != null) {
			boton.setIcon(new ImageIcon(locacionImagen, textoAlternativo));
		} else {
			boton.setText(textoAlternativo);
			System.err.println("Recurso no encontrado: " + locacionImagen);
		}
	
		return boton;
	}
	
	void addComponentes() {
		cp = getContentPane();
		
		//Create the toolbar.
        barra_herramientas = new JToolBar();
        agregarToolBar(barra_herramientas);
        barra_herramientas.setFloatable(false);
        barra_herramientas.setRollover(true);
		
		boton_saludo = new JButton("Barra de herramienta");
		etiqueta_equipo = new JLabel("Proyecto desarrollado por la Academia de Software - 2018");
		
		cp.add(barra_herramientas, BorderLayout.NORTH);
		cp.add(etiqueta_equipo, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		AppFerretodo marco = new AppFerretodo("Ferretodo");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane aviso = new JOptionPane();
		String cmd = e.getActionCommand();
        // String description = null;

        // Handle each button.
        if (FACTURA.equals(cmd)) { //first button clicked
			aviso.showMessageDialog(null, "Boton Factura.");
        } else if (CLIENTE.equals(cmd)) { // second button clicked
        	aviso.showMessageDialog(null, "Boton Clientes.");
        } else if (ORDEN_PAGO.equals(cmd)) { // third button clicked
        	aviso.showMessageDialog(null, "Boton Orden de Pago.");
        } else if (PRODUCTO.equals(cmd)) { // fourth button clicked
        	aviso.showMessageDialog(null, "Boton Productos.");
        } else if (PROVEEDOR.equals(cmd)) { // text field
        	aviso.showMessageDialog(null, "Boton Proveedores.");
        } else if (EMPLEADO.equals(cmd)) { // text field
        	aviso.showMessageDialog(null, "Boton Empleados.");
        } else if (USUARIO.equals(cmd)) { // text field
        	aviso.showMessageDialog(null, "Boton Usuarios.");
        }

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}
