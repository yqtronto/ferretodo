package barras;

import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


/**
 * Clase para la creaci�n de los Men�s de la Aplicaci�n Ferretodo. 
 * @author Yhovanny Quintero
 *
 */
public class BarraMenu extends JMenuBar {
    // Textos de los Men�s.
    static final private String MENU_VENTA = "Ventas";
    static final private String MENU_GESTION_ADMIN = "Gesti�n Administrativa";
    static final private String MENU_RRHH = "Recursos Humanos";
    static final private String MENU_CONSULTA = "Consultas";
    static final private String MENU_ADMIN = "Administraci�n de Sistema";
	
    // Textos de los Men�s Items
    static final private String MENUITEM_EMITIR_FACTURAS = "Emitir Facturas";
    static final private String MENUITEM_GESTION_FACTURAS = "Gestionar Facturas";
    static final private String MENUITEM_GESTION_CLIENTES = "Gestionar Cientes";
    static final private String MENUITEM_CATALOGO_PRODUCTO = "Catalogo de Productos";
    static final private String MENUITEM_GESTION_ORDEN_PAGO = "Gestionar Orden de Pago";
    static final private String MENUITEM_INCENTIVOS_VENTAS_EMPLEADOS = "Incentivos por Ventas a los Empleados";
    static final private String MENUITEM_PROVEEDORES = "Proveedores";
    static final private String MENUITEM_SUCURSALES = "Sucursales";
    static final private String MENUITEM_ADMINISTRACION_CARGOS = "Administraci�n de Cargos";
    static final private String MENUITEM_GESTION_EMPLEADOS = "Gestionar Empleados";
    static final private String MENUITEM_INCENTIVOS_EMPLEADOS = "Incestivos al Empleado";
    static final private String MENUITEM_VENTAS = "Ventas";
    static final private String MENUITEM_USUARIOS = "Usuarios";
    static final private String MENUITEM_ROL = "Roles";
    static final private String MENUITEM_MODULO_SISTEMA = "M�dulos del Sistema";
    static final private String MENUITEM_PERMISO_ROL = "Permisolog�a por Roles";
    static final private String MENUITEM_DEPARTAMENTO = "Departamento";
    static final private String MENUITEM_CIUDAD = "Ciudad"; 
    static final private String MENUITEM_ESTADO = "Estado";
    static final private String MENUITEM_ENTIDAD_BANCARIA = "Entidad Bancaria";
    static final private String MENUITEM_FORMA_PAGO = "Forma de Pago";
    static final private String MENUITEM_GRUPO_CARGO = "Grupos de Cargo";
    static final private String MENUITEM_TIPO_INCENTIVO = "Tipos de Incentivos";
    
    
    // Declaraci�n e inicializaci�n de los Men�s e Items.
    public JMenu menuVenta = agregarMenu(MENU_VENTA, KeyEvent.VK_V, MENU_VENTA);
    public JMenuItem miEmitirFactura = agregarMenuItem(MENUITEM_EMITIR_FACTURAS, KeyEvent.VK_E, null, MENUITEM_EMITIR_FACTURAS, "Emisi�n de las Facturas.");
    public JMenuItem miGestionFactura = agregarMenuItem(MENUITEM_GESTION_FACTURAS, KeyEvent.VK_G, null, MENUITEM_GESTION_FACTURAS, "Gesti�n de las Facturas ingresadas.");
    public JMenuItem miGestionCliente = agregarMenuItem(MENUITEM_GESTION_CLIENTES, KeyEvent.VK_C, null, MENUITEM_GESTION_CLIENTES, "Gesti�n de las Facturas ingresadas.");
    
    public JMenu menuGestionAdmin = agregarMenu(MENU_GESTION_ADMIN, KeyEvent.VK_G, MENU_GESTION_ADMIN);
    public JMenuItem miCatalogoProducto = agregarMenuItem(MENUITEM_CATALOGO_PRODUCTO, KeyEvent.VK_C, null, MENUITEM_CATALOGO_PRODUCTO, "Cat�logo de Productos.");
    public JMenuItem miGestionOrdenPago = agregarMenuItem(MENUITEM_GESTION_ORDEN_PAGO, KeyEvent.VK_G, null, MENUITEM_GESTION_ORDEN_PAGO, "Gesti�n de las Ordenes de Pagos.");
    public JMenuItem miIncentivoVenta = agregarMenuItem(MENUITEM_INCENTIVOS_VENTAS_EMPLEADOS, KeyEvent.VK_I, null, MENUITEM_INCENTIVOS_VENTAS_EMPLEADOS, "Incentivos por Ventas a los Empleados.");
    public JMenuItem miProveedor = agregarMenuItem(MENUITEM_PROVEEDORES, KeyEvent.VK_P, null, MENUITEM_PROVEEDORES, "Proveedores.");
    public JMenuItem miSucursal = agregarMenuItem(MENUITEM_SUCURSALES, KeyEvent.VK_S, null, MENUITEM_SUCURSALES, "Gesti�n de las Sucursales.");

    public JMenu menuRRHH = agregarMenu(MENU_RRHH,KeyEvent.VK_R, MENU_RRHH); 
    public JMenuItem miAdministrarCargo = agregarMenuItem(MENUITEM_ADMINISTRACION_CARGOS, KeyEvent.VK_A, null, MENUITEM_ADMINISTRACION_CARGOS, "Gesti�n de las Facturas ingresadas.");
    public JMenuItem miGestionEmpleado = agregarMenuItem(MENUITEM_GESTION_EMPLEADOS, KeyEvent.VK_G, null, MENUITEM_GESTION_EMPLEADOS, "Gesti�n de los Empleados.");
    public JMenuItem miIncentivoEmpleado = agregarMenuItem(MENUITEM_INCENTIVOS_EMPLEADOS, KeyEvent.VK_I, null, MENUITEM_INCENTIVOS_EMPLEADOS, "Incentivos al Empleado.");
    
    public JMenu menuConsulta = agregarMenu(MENU_CONSULTA, KeyEvent.VK_C, MENU_CONSULTA ); 
    public JMenuItem miVenta = agregarMenuItem(MENUITEM_VENTAS, KeyEvent.VK_V, null, MENUITEM_VENTAS, "Ventas.");

    public JMenu menuAdmin = agregarMenu(MENU_ADMIN, KeyEvent.VK_A, MENU_ADMIN);
    public JMenuItem miUsuario = agregarMenuItem(MENUITEM_USUARIOS, KeyEvent.VK_U, null, MENUITEM_USUARIOS, "Usuarios.");
    public JMenuItem miRol = agregarMenuItem(MENUITEM_ROL, KeyEvent.VK_R, null, MENUITEM_ROL, "Roles.");
    public JMenuItem miModuloSistema = agregarMenuItem(MENUITEM_MODULO_SISTEMA, KeyEvent.VK_M, null, MENUITEM_MODULO_SISTEMA, "M�dulos del Sistema.");
    public JMenuItem miPermisoRol = agregarMenuItem(MENUITEM_PERMISO_ROL, KeyEvent.VK_P, null, MENUITEM_PERMISO_ROL, "Permisolog�a por Roles");
    public JMenuItem miDepartamento = agregarMenuItem(MENUITEM_DEPARTAMENTO, KeyEvent.VK_D, null, MENUITEM_DEPARTAMENTO, MENUITEM_DEPARTAMENTO);
    public JMenuItem miCiudad = agregarMenuItem(MENUITEM_CIUDAD, KeyEvent.VK_C, null, MENUITEM_CIUDAD, MENUITEM_CIUDAD);
    public JMenuItem miEstado = agregarMenuItem(MENUITEM_ESTADO, KeyEvent.VK_E, null, MENUITEM_ESTADO, MENUITEM_ESTADO);
    public JMenuItem miEntidadBancaria = agregarMenuItem(MENUITEM_ENTIDAD_BANCARIA, KeyEvent.VK_B, null, MENUITEM_ENTIDAD_BANCARIA, MENUITEM_ENTIDAD_BANCARIA);
    public JMenuItem miFormaPago = agregarMenuItem(MENUITEM_FORMA_PAGO, KeyEvent.VK_F, null, MENUITEM_FORMA_PAGO, MENUITEM_FORMA_PAGO);
    public JMenuItem miGrupoCargo = agregarMenuItem(MENUITEM_GRUPO_CARGO, KeyEvent.VK_G, null, MENUITEM_GRUPO_CARGO, MENUITEM_GRUPO_CARGO);
    public JMenuItem miTipoIncentivo = agregarMenuItem(MENUITEM_TIPO_INCENTIVO, KeyEvent.VK_T, null, MENUITEM_TIPO_INCENTIVO, MENUITEM_TIPO_INCENTIVO);

    /**
     * Constructor de la clase BarraMenu e inicializa el men�.
     */
    public BarraMenu() {
    	this.add(menuVenta());
    	this.add(menuGestionAdmin());
    	this.add(menuRRHH());
    	this.add(menuConsulta());
    	this.add(menuAdmin());
    }
    
    /**
     * Permite agregar el men� Venta y todos los items que conforma el men�.
     * @return
     */
    protected JMenu menuVenta(){
        menuVenta.add(miEmitirFactura);
        menuVenta.add(miGestionFactura);
        menuVenta.add(miGestionCliente);
        return menuVenta;
    }
    
    /**
     * Permite agregar el men� Gestion Administrativa y todos los items que conforma el men�.
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
     * Permite agregar el men� de Recursos Humanos y todos los items que conforma el men�.
     * @return
     */
    protected JMenu menuRRHH(){
        menuRRHH.add(miAdministrarCargo);
        menuRRHH.add(miGestionEmpleado);
        menuRRHH.add(miIncentivoEmpleado);
        return menuRRHH;
    }

    /**
     * Permite agregar el men� Consulta y todos los items que conforma el men�.
     * @return
     */
    protected JMenu menuConsulta(){
        menuConsulta.add(miVenta);
        return menuConsulta;
    }

	/**
	 * Permite agregar el men� Administraci�n y todos los items que conforma el men�. 
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
     * Este m�todo permite agregar un nuevo Men� a la Barra de Men�s.
     * @param textMenu Especicf�ca cual va a ser el texto a visualizar en el Item del Men�.
     * @param teclaEvento Especifica la asociaci�n de una tecla mnemot�cnica para interactuar con el Item del Men�.
     * @param textoInformativo Establece el texto informativo para ser visualizado como ayuda de la acci�n del Item del Men�.
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
     * Un m�todo que primete agregar un nuevo Item del Men�.
     * @param textoMenu Especicf�ca cual va a ser el texto a visualizar en el Item del Men�.
     * @param teclaEvento Especifica la asociaci�n de una tecla mnemot�cnica para interactuar con el Item del Men�.
     * @param teclaAcelerador Especifica que tecla puede ser precionada para acceder directamente a la acci�n de ese Item del Men�.
     * @param comandoAccion Establece un comando de acci�n para luego ser atendido por ActionListener.
     * @param textoInformativo Establece el texto informativo para ser visualizado como ayuda de la acci�n del Item del Men�.
     * @return El contenido del Item del Men�.
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
