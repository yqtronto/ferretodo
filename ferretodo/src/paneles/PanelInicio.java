/**
 * @author Yhovanny Quintero
 */
package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelInicio extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final String TEXTO_TITULO = "FERRETODO";
	private static final String TEXTO_BIENVENIDO = "BIENVENIDO";
	
	public PanelInicio() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridLayout(2, 1, 1, 1));
		setBackground(new Color(44, 62, 80));
		{
			JLabel lblTitulo = new JLabel(TEXTO_TITULO);
			lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 40));
			lblTitulo.setForeground(new Color(255, 255, 255));
			lblTitulo.setBackground(new Color(44, 62, 80));
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			add(lblTitulo);
		}
		{
			JLabel lblBienvenido = new JLabel(TEXTO_BIENVENIDO);
			lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 40));
			lblBienvenido.setForeground(new Color(255, 255, 255));
			lblBienvenido.setBackground(new Color(44, 62, 80));
			lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
			add(lblBienvenido);
		}
	}
	
	protected ImageIcon icono (String direccion, int tamW, int tamH) {
		ImageIcon icon = new ImageIcon(direccion);
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(tamW, tamH,  java.awt.Image.SCALE_SMOOTH );
        return new ImageIcon( newimg );
	}

}
