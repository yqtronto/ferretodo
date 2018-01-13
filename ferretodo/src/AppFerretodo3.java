import javax.swing.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class AppFerretodo3 extends JFrame {
	ImageIcon icono;
	Container cp;
	JLabel etiqueta_nombre;
	JTextField textField_nombre;
	JButton boton_saludo;
	
	public AppFerretodo3(String titulo) {
		setTitle(titulo);
		icono = new ImageIcon("image//sucursal.png");
		setIconImage(icono.getImage());
		setLocation(220,20); // posicion del JFrame en el escritorio.
		setSize(400, 300);
		addComponentes();
		//addTabla();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setVisible(true);
	}
	
	void addTabla() {
		//super(new GridLayout(1,0));
		// cp.setLayout(new FlowLayout());
		String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};
		final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
        cp.add(table);
	}
	
	void addComponentes() {
		cp = getContentPane();
		//cp.setLayout(new FlowLayout());
		etiqueta_nombre = new JLabel ("Nombre: ");
		textField_nombre = new JTextField(20);
		boton_saludo = new JButton("Saludar");
		FlowLayout mLayout = new FlowLayout();
		mLayout.setAlignment(FlowLayout.RIGHT);
		mLayout.setHgap(50);
		mLayout.setVgap(20);
		
		cp.setLayout(mLayout);
		cp.add(etiqueta_nombre);
		cp.add(textField_nombre);
		cp.add(boton_saludo);
	}
	
	public static void main(String[] args) {
		AppFerretodo3 marco = new AppFerretodo3("Ferretodo");
	}
}
