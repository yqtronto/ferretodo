import javax.swing.*;

//import Paneles.JPanelProducto;
//import Paneles.PanelEmpleado;
//import Paneles.PanelInicio;
import paneles.PanelInicio;
import paneles.PanelAdmonUsuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
// import java.net.PasswordAuthentication;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class AppFerretodo extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String TITULO = "Ferretodo";
	private static final int TAMX = 800, TAMY = 600;
	private Dimension pantalla;
	private int posX, posY;
	
	ImageIcon icono = new ImageIcon("image//febeca.png"); // El icono debe estar en el directorio raíz con extensión png.
    BarraMenu barraMenu = new BarraMenu();
    BarraHerramienta barraHerramienta = new BarraHerramienta();
    PanelCentral panelCentral = new PanelCentral();
    PanelSur panelSur = new PanelSur();
    public static PanelInicio panelInicio;
	
	public AppFerretodo() {
		this.setTitle(TITULO);
		this.setIconImage(icono.getImage());
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        posX = (int) ((pantalla.width - TAMX)/2);
        posY = (int) ((pantalla.height - TAMY)/2);
        setBounds(posX, posY, TAMX, TAMY);
		//this.setLocation(220,20); // posicion del JFrame en el escritorio.
		//this.setSize(800, 600);
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setLayout(new BorderLayout());
		this.agregarEventoBarraHerramienta();
		this.agregarEventoBarraMenu();
		this.agregarPaneles();
		//setResizable(false);
	}
	
	
	private void agregarPaneles() {
		this.setJMenuBar(barraMenu);
		this.add(barraHerramienta, BorderLayout.NORTH);
		this.add(panelCentral, BorderLayout.CENTER);
		this.add(panelSur, BorderLayout.SOUTH);
	}
	
	private void agregarEventoBarraHerramienta() {
		barraHerramienta.bhCliente.addActionListener(this);
		barraHerramienta.bhEmpleado.addActionListener(this);
		barraHerramienta.bhFactura.addActionListener(this);
		barraHerramienta.bhOrdenPago.addActionListener(this);
		barraHerramienta.bhProducto.addActionListener(this);
		barraHerramienta.bhProveedor.addActionListener(this);
		barraHerramienta.bhUsuario.addActionListener(this);
	}
	
	private void agregarEventoBarraMenu() {
		barraMenu.miAdministrarCargo.addActionListener(this);
		barraMenu.miCatalogoProducto.addActionListener(this);
		barraMenu.miCiudad.addActionListener(this);
		barraMenu.miDepartamento.addActionListener(this);
		barraMenu.miEmitirFactura.addActionListener(this);
		barraMenu.miEntidadBancaria.addActionListener(this);
		barraMenu.miEstado.addActionListener(this);
		barraMenu.miFormaPago.addActionListener(this);
		barraMenu.miGestionCliente.addActionListener(this);
		barraMenu.miGestionEmpleado.addActionListener(this);
		barraMenu.miGestionFactura.addActionListener(this);
		barraMenu.miGestionOrdenPago.addActionListener(this);
		barraMenu.miGrupoCargo.addActionListener(this);
		barraMenu.miIncentivoEmpleado.addActionListener(this);
		barraMenu.miIncentivoVenta.addActionListener(this);
		barraMenu.miModuloSistema.addActionListener(this);
		barraMenu.miPermisoRol.addActionListener(this);
		barraMenu.miProveedor.addActionListener(this);
		barraMenu.miRol.addActionListener(this);
		barraMenu.miSucursal.addActionListener(this);
		barraMenu.miTipoIncentivo.addActionListener(this);
		barraMenu.miUsuario.addActionListener(this);
		barraMenu.miVenta.addActionListener(this);
	}
	
	public static void main(String[] args) {
		// XXX - MAIN
		//Create and set up the window.
        //JFrame frame = new JFrame("Inicio de Sessión");
        //frame.setModalExclusionType(ModalExclusionType.NO_EXCLUDE);
        //frame.setVisible(true);
        
		//Create and set up the content pane.
        //PanelInicio panelInicio = new PanelInicio(frame);
        // panelInicio = new PanelInicio();
        // frame.getContentPane().add(panelInicio);
        //frame.setD

		
		//PanelInicio pi = new PanelInicio();
		panelInicio = new PanelInicio();
		//panelInicio.setTitle("Ingreso de Sesión");
		//panelInicio.setModal(true);
		panelInicio.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // Dimension pantalla, cuadro;
        // panelInicio.setSize(400, 150);
        //pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        //cuadro = panelInicio.getSize();
        //panelInicio.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
        panelInicio.setVisible(true);

        /*
        frame.getContentPane().add(pi);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 150);
        Dimension pantalla, cuadro;
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        cuadro = frame.getSize();
        frame.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
        frame.setVisible(true);
        */
        // panelInicio.setVisible(true);

        if (panelInicio.esCorrecto()) {
            //System.out.println("Cargado");
    		AppFerretodo marco = new AppFerretodo();
    		marco.setVisible(true);
        } else {
        	//System.out.println("Esperando");
        }
        
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //newContentPane.setOpaque(true); //content panes must be opaque
        //frame.setContentPane(newContentPane);
        
        // frame.pack();
		
		// AppFerretodo marco = new AppFerretodo();
		// marco.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO - ActionPerformed - ActionEvent de la barra de herramientas y de menús.
        if (e.getSource() == barraMenu.miGestionEmpleado || e.getSource() == barraHerramienta.bhEmpleado) {
            //jPanelCenterFerretodo.card.show(jPanelCenterFerretodo, "Empleados");
        	JOptionPane.showMessageDialog(null, "Gestion Empleados.");
        } else if (e.getSource() == barraMenu.miGestionCliente || e.getSource() == barraHerramienta.bhCliente) {
        	JOptionPane.showMessageDialog(null, "Gestion Clientes.");        	
        } else if (e.getSource() == barraMenu.miEmitirFactura || e.getSource() == barraHerramienta.bhFactura) {
        	JOptionPane.showMessageDialog(null, "Emisión de Facturas.");        	
        }

        //System.out.println(e.getSource());
	}
	
}

class PanelSur extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel logo = new JLabel(new ImageIcon("image//febeca.png"));
    JLabel copyRight = new JLabel("Creado por: Programa de formación de sistemas en Academia de Software 2018");

    public PanelSur() {
        this.setBackground(Color.WHITE);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(logo);
        this.add(copyRight);
    }
    
}

class BarraHerramienta extends JToolBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Textos Botones de Barra de Herramientas.
	static final private String HERRAMIENTA_FACTURA = "Facturación";
    static final private String HERRAMIENTA_CLIENTE = "Clientes";
    static final private String HERRAMIENTA_ORDEN_PAGO = "Orden de Pago";
    static final private String HERRAMIENTA_PRODUCTO = "Productos";
    static final private String HERRAMIENTA_PROVEEDOR = "Proveedores";
    static final private String HERRAMIENTA_EMPLEADO = "Empleados";
    static final private String HERRAMIENTA_USUARIO = "Usuarios";
    
    // Declaración e inicialización de los botones en la Barra de Herramientas.
    public JButton bhFactura = agregarBoton("factura", HERRAMIENTA_FACTURA, "Facturación", HERRAMIENTA_FACTURA);
    public JButton bhCliente = agregarBoton("clientes", HERRAMIENTA_CLIENTE, "Clientes", HERRAMIENTA_CLIENTE);
    public JButton bhOrdenPago = agregarBoton("odp", HERRAMIENTA_ORDEN_PAGO, "Orden de Pago", HERRAMIENTA_ORDEN_PAGO);
    public JButton bhProducto = agregarBoton("inventario", HERRAMIENTA_PRODUCTO, "Productos", HERRAMIENTA_PRODUCTO);
    public JButton bhProveedor = agregarBoton("proveedor", HERRAMIENTA_PROVEEDOR, "Proveedores", HERRAMIENTA_PROVEEDOR);
    public JButton bhEmpleado = agregarBoton("empleados", HERRAMIENTA_EMPLEADO, "Empleados", HERRAMIENTA_EMPLEADO);
    public JButton bhUsuario = agregarBoton("usr", HERRAMIENTA_USUARIO, "Usuarios", HERRAMIENTA_USUARIO);
    
    /**
     * Constructor de la Clase BarraHerramienta.
     */
    public BarraHerramienta() {
    	this.setFloatable(false);
    	this.setRollover(true);
    	this.add(bhFactura);
    	this.add(bhCliente);
    	this.addSeparator();
    	this.add(bhOrdenPago);
    	this.add(bhProducto);
    	this.add(bhProveedor);
    	this.addSeparator();
    	this.add(bhEmpleado);
    	this.add(bhUsuario);
    }
    
    /**
     * Este método permite crear un botón con imagen para ser agregado a la Barra de Herramientas. 
     * @param nombreImagen Nombre de la imagen sin extensión el cual debe estar ubicado en la carpeta image, la extensión de la imagen debe estar en formato png.
     * @param comandoAction Establece un comando de acción para luego ser atendido por ActionListener.
     * @param textoInformativo Establece el texto informativo para ser visualizado como ayuda de la acción del Item del Menú.
     * @param textoAlternativo Establece un texto en caso de que la imagen no se pudo asignar.
     * @return Retorna el botón con toda la información para ser agregada a la Barra de Herramienta.
     */
	protected JButton agregarBoton(String nombreImagen, String comandoAction, String textoInformativo, String textoAlternativo) {
		String nImagen = "image/" + nombreImagen + ".png";
		JButton boton = new JButton();
		boton.setActionCommand(comandoAction);
		if (textoInformativo != null ) {
			boton.setToolTipText(textoInformativo);
		}
		//boton.addActionListener(this);
		if (nombreImagen != null) {
			boton.setIcon(new ImageIcon(nImagen, textoAlternativo));
		} else {
			boton.setText(textoAlternativo);
			System.err.println("Recurso no encontrado: " + nImagen);
		}
		return boton;
	}

}

class BarraMenu extends JMenuBar {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Textos de los Menús.
    static final private String MENU_VENTA = "Ventas";
    static final private String MENU_GESTION_ADMIN = "Gestión Administrativa";
    static final private String MENU_RRHH = "Recursos Humanos";
    static final private String MENU_CONSULTA = "Consultas";
    static final private String MENU_ADMIN = "Administración de Sistema";
	
    // Textos de los Menús Items
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
    static final private String MENUITEM_ROL = "Roles";
    static final private String MENUITEM_MODULO_SISTEMA = "Módulos del Sistema";
    static final private String MENUITEM_PERMISO_ROL = "Permisología por Roles";
    static final private String MENUITEM_DEPARTAMENTO = "Departamento";
    static final private String MENUITEM_CIUDAD = "Ciudad"; 
    static final private String MENUITEM_ESTADO = "Estado";
    static final private String MENUITEM_ENTIDAD_BANCARIA = "Entidad Bancaria";
    static final private String MENUITEM_FORMA_PAGO = "Forma de Pago";
    static final private String MENUITEM_GRUPO_CARGO = "Grupos de Cargo";
    static final private String MENUITEM_TIPO_INCENTIVO = "Tipos de Incentivos";
    
    
    // Declaración e inicialización de los Menús e Items.
    public JMenu menuVenta = agregarMenu(MENU_VENTA, KeyEvent.VK_V, MENU_VENTA);
    public JMenuItem miEmitirFactura = agregarMenuItem(MENUITEM_EMITIR_FACTURAS, KeyEvent.VK_E, null, MENUITEM_EMITIR_FACTURAS, "Emisión de las Facturas.");
    public JMenuItem miGestionFactura = agregarMenuItem(MENUITEM_GESTION_FACTURAS, KeyEvent.VK_G, null, MENUITEM_GESTION_FACTURAS, "Gestión de las Facturas ingresadas.");
    public JMenuItem miGestionCliente = agregarMenuItem(MENUITEM_GESTION_CLIENTES, KeyEvent.VK_C, null, MENUITEM_GESTION_CLIENTES, "Gestión de las Facturas ingresadas.");
    
    public JMenu menuGestionAdmin = agregarMenu(MENU_GESTION_ADMIN, KeyEvent.VK_G, MENU_GESTION_ADMIN);
    public JMenuItem miCatalogoProducto = agregarMenuItem(MENUITEM_CATALOGO_PRODUCTO, KeyEvent.VK_C, null, MENUITEM_CATALOGO_PRODUCTO, "Catálogo de Productos.");
    public JMenuItem miGestionOrdenPago = agregarMenuItem(MENUITEM_GESTION_ORDEN_PAGO, KeyEvent.VK_G, null, MENUITEM_GESTION_ORDEN_PAGO, "Gestión de las Ordenes de Pagos.");
    public JMenuItem miIncentivoVenta = agregarMenuItem(MENUITEM_INCENTIVOS_VENTAS_EMPLEADOS, KeyEvent.VK_I, null, MENUITEM_INCENTIVOS_VENTAS_EMPLEADOS, "Incentivos por Ventas a los Empleados.");
    public JMenuItem miProveedor = agregarMenuItem(MENUITEM_PROVEEDORES, KeyEvent.VK_P, null, MENUITEM_PROVEEDORES, "Proveedores.");
    public JMenuItem miSucursal = agregarMenuItem(MENUITEM_SUCURSALES, KeyEvent.VK_S, null, MENUITEM_SUCURSALES, "Gestión de las Sucursales.");

    public JMenu menuRRHH = agregarMenu(MENU_RRHH,KeyEvent.VK_R, MENU_RRHH); 
    public JMenuItem miAdministrarCargo = agregarMenuItem(MENUITEM_ADMINISTRACION_CARGOS, KeyEvent.VK_A, null, MENUITEM_ADMINISTRACION_CARGOS, "Gestión de las Facturas ingresadas.");
    public JMenuItem miGestionEmpleado = agregarMenuItem(MENUITEM_GESTION_EMPLEADOS, KeyEvent.VK_G, null, MENUITEM_GESTION_EMPLEADOS, "Gestión de los Empleados.");
    public JMenuItem miIncentivoEmpleado = agregarMenuItem(MENUITEM_INCENTIVOS_EMPLEADOS, KeyEvent.VK_I, null, MENUITEM_INCENTIVOS_EMPLEADOS, "Incentivos al Empleado.");
    
    public JMenu menuConsulta = agregarMenu(MENU_CONSULTA, KeyEvent.VK_C, MENU_CONSULTA ); 
    public JMenuItem miVenta = agregarMenuItem(MENUITEM_VENTAS, KeyEvent.VK_V, null, MENUITEM_VENTAS, "Ventas.");

    public JMenu menuAdmin = agregarMenu(MENU_ADMIN, KeyEvent.VK_A, MENU_ADMIN);
    public JMenuItem miUsuario = agregarMenuItem(MENUITEM_USUARIOS, KeyEvent.VK_U, null, MENUITEM_USUARIOS, "Usuarios.");
    public JMenuItem miRol = agregarMenuItem(MENUITEM_ROL, KeyEvent.VK_R, null, MENUITEM_ROL, "Roles.");
    public JMenuItem miModuloSistema = agregarMenuItem(MENUITEM_MODULO_SISTEMA, KeyEvent.VK_M, null, MENUITEM_MODULO_SISTEMA, "Módulos del Sistema.");
    public JMenuItem miPermisoRol = agregarMenuItem(MENUITEM_PERMISO_ROL, KeyEvent.VK_P, null, MENUITEM_PERMISO_ROL, "Permisología por Roles");
    public JMenuItem miDepartamento = agregarMenuItem(MENUITEM_DEPARTAMENTO, KeyEvent.VK_D, null, MENUITEM_DEPARTAMENTO, MENUITEM_DEPARTAMENTO);
    public JMenuItem miCiudad = agregarMenuItem(MENUITEM_CIUDAD, KeyEvent.VK_C, null, MENUITEM_CIUDAD, MENUITEM_CIUDAD);
    public JMenuItem miEstado = agregarMenuItem(MENUITEM_ESTADO, KeyEvent.VK_E, null, MENUITEM_ESTADO, MENUITEM_ESTADO);
    public JMenuItem miEntidadBancaria = agregarMenuItem(MENUITEM_ENTIDAD_BANCARIA, KeyEvent.VK_B, null, MENUITEM_ENTIDAD_BANCARIA, MENUITEM_ENTIDAD_BANCARIA);
    public JMenuItem miFormaPago = agregarMenuItem(MENUITEM_FORMA_PAGO, KeyEvent.VK_F, null, MENUITEM_FORMA_PAGO, MENUITEM_FORMA_PAGO);
    public JMenuItem miGrupoCargo = agregarMenuItem(MENUITEM_GRUPO_CARGO, KeyEvent.VK_G, null, MENUITEM_GRUPO_CARGO, MENUITEM_GRUPO_CARGO);
    public JMenuItem miTipoIncentivo = agregarMenuItem(MENUITEM_TIPO_INCENTIVO, KeyEvent.VK_T, null, MENUITEM_TIPO_INCENTIVO, MENUITEM_TIPO_INCENTIVO);

    /**
     * Constructor de la clase BarraMenu e inicializa el menú.
     */
    public BarraMenu() {
    	this.add(menuVenta());
    	this.add(menuGestionAdmin());
    	this.add(menuRRHH());
    	this.add(menuConsulta());
    	this.add(menuAdmin());
    }
    
    /**
     * Permite agregar el menú Venta y todos los items que conforma el menú.
     * @return
     */
    protected JMenu menuVenta(){
        menuVenta.add(miEmitirFactura);
        menuVenta.add(miGestionFactura);
        menuVenta.add(miGestionCliente);
        return menuVenta;
    }
    
    /**
     * Permite agregar el menú Gestion Administrativa y todos los items que conforma el menú.
     * @return
     */
    protected JMenu menuGestionAdmin(){
        menuGestionAdmin.add(miCatalogoProducto);
        menuGestionAdmin.add(miGestionOrdenPago);
        menuGestionAdmin.add(miIncentivoVenta);
        menuGestionAdmin.add(miProveedor);
        menuGestionAdmin.add(miSucursal);
        return menuGestionAdmin;
    }

    /**
     * Permite agregar el menú de Recursos Humanos y todos los items que conforma el menú.
     * @return
     */
    protected JMenu menuRRHH(){
        menuRRHH.add(miAdministrarCargo);
        menuRRHH.add(miGestionEmpleado);
        menuRRHH.add(miIncentivoEmpleado);
        return menuRRHH;
    }

    /**
     * Permite agregar el menú Consulta y todos los items que conforma el menú.
     * @return
     */
    protected JMenu menuConsulta(){
        menuConsulta.add(miVenta);
        return menuConsulta;
    }

	/**
	 * Permite agregar el menú Administración y todos los items que conforma el menú. 
	 * @return
	 */
    protected JMenu menuAdmin(){
        menuAdmin.add(miUsuario);
        menuAdmin.add(miRol);
        menuAdmin.add(miModuloSistema);
        menuAdmin.add(miPermisoRol);
        menuAdmin.add(miDepartamento);
        menuAdmin.add(miCiudad);
        menuAdmin.add(miEstado);
        menuAdmin.add(miEntidadBancaria);
        menuAdmin.add(miFormaPago);
        menuAdmin.add(miGrupoCargo);
        menuAdmin.add(miTipoIncentivo);
        return menuAdmin;
    }

    /**
     * Este método permite agregar un nuevo Menú a la Barra de Menús.
     * @param textMenu Especicfíca cual va a ser el texto a visualizar en el Item del Menú.
     * @param teclaEvento Especifica la asociación de una tecla mnemotécnica para interactuar con el Item del Menú.
     * @param textoInformativo Establece el texto informativo para ser visualizado como ayuda de la acción del Item del Menú.
     * @return
     */
    protected JMenu agregarMenu(String textMenu, int teclaEvento, String textoInformativo) {
		JMenu menu = new JMenu(textMenu);
        menu.setMnemonic(teclaEvento);
        if (textoInformativo != null) {
			menu.setToolTipText(textoInformativo);
		}
        return menu;
	}
	
    /**
     * Un método que primete agregar un nuevo Item del Menú.
     * @param textoMenu Especicfíca cual va a ser el texto a visualizar en el Item del Menú.
     * @param teclaEvento Especifica la asociación de una tecla mnemotécnica para interactuar con el Item del Menú.
     * @param teclaAcelerador Especifica que tecla puede ser precionada para acceder directamente a la acción de ese Item del Menú.
     * @param comandoAccion Establece un comando de acción para luego ser atendido por ActionListener.
     * @param textoInformativo Establece el texto informativo para ser visualizado como ayuda de la acción del Item del Menú.
     * @return El contenido del Item del Menú.
     */
	protected JMenuItem agregarMenuItem(String textoMenu, int teclaEvento, KeyStroke teclaAcelerador, String comandoAccion, String textoInformativo) {
		JMenuItem menuItem = new JMenuItem(textoMenu,teclaEvento);
		if (teclaAcelerador != null) {
			menuItem.setAccelerator(teclaAcelerador);
		}
		menuItem.setActionCommand(comandoAccion);
        //menuItem.addActionListener(this);
		if (textoInformativo != null) {
			menuItem.setToolTipText(textoInformativo);
		}
		return menuItem;
	}
    
}

class PanelCentral extends JPanel{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CardLayout card;
    //PanelEmpleado panelEmpleado; 
    JPanel panelInicio;
    PanelAdmonUsuarios panelAdmonUsuario;
    //Panel panelProducto;
    //JPanelProducto panelProducto;
    public PanelCentral() {
        card = new CardLayout();
        
        //Creando paneles
        //panelEmpleado = new PanelEmpleado(); 
        //panelInicio = new PanelInicio();
        //panelProducto=new JPanelProducto();
        panelAdmonUsuario = new PanelAdmonUsuarios();
        
        //Añadiendo paneles al cardLayout
        //card.addLayoutComponent(panelEmpleado, "Empleados");
        card.addLayoutComponent(panelAdmonUsuario, "panelAdmonUsuario");
        //card.addLayoutComponent(panelProducto, "Producto");
        //setiando cardlayout a jpanel
        this.setLayout(card);
        
        //aÃ±adiendo paneles al Jpanel gracias a q es tipo cardLayout
        //this.add(panelEmpleado);
        this.add(panelAdmonUsuario);
        //this.add(panelProducto);
        card.show(this, "panelAdmonUsuario");
    }
       
}
