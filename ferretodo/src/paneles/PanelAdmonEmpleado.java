package paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelAdmonEmpleado extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelAdmonEmpleado() {
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
				JLabel lblTitulo = new JLabel("PANEL ADMON EMPLEADO");
				lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
				lblTitulo.setForeground(new Color(255, 255, 255));
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				pTitulo.add(lblTitulo);
			}
			pNorte.add(pTitulo, BorderLayout.NORTH);
			add(pNorte, BorderLayout.NORTH);
		}
	}

}
