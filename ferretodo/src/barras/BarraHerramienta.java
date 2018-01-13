package barras;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 * Clase para la creación de la Barra de Herramientas para la Aplicación Ferretodo.
 * @author Yhovanny Quintero
 *
 */
public class BarraHerramienta extends JToolBar {
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
