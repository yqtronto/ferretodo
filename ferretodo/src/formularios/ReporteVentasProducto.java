package formularios;

import bd.ConexionBDConsultarVentas;

import java.awt.Dimension;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ReporteVentasProducto extends JDialog{
	private final String[] arrayProductMonthly = {"FECHA EMISION","CANTIDAD","PRECIO","TOTAL"};
	private final String[] arrayProductSemesterly = {"FECHA EMISION","CANTIDAD","PRECIO","TOTAL"};
	private final String[] arrayProductAnnually = {"FECHA EMISION","CANTIDAD","PRECIO","TOTAL"};
	private final String[] arrayProductPersonalized = {"FECHA EMISION","CANTIDAD","PRECIO","TOTAL"};
	private DefaultTableModel tableModelProductMonthly = new DefaultTableModel(arrayProductMonthly,0);
	private DefaultTableModel tableModelProductSemesterly = new DefaultTableModel(arrayProductSemesterly,0);
	private DefaultTableModel tableModelProductAnnually = new DefaultTableModel(arrayProductAnnually,0);
	private DefaultTableModel tableModelProductPersonalized = new DefaultTableModel(arrayProductPersonalized,0);
	private JTable tableReport;
	private JScrollPane scrollReport;
	private ConexionBDConsultarVentas conexionBDConsultarVentas = new ConexionBDConsultarVentas();
	
	public ReporteVentasProducto(String cod, String productName, int month, int year) {
		this.setTitle("Reporte de Ventas por Producto");
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setLayout(new BorderLayout());
		
		JPanel panelProductInfo = new JPanel();
		JLabel labelProductName = new JLabel("Producto: "+productName);
		JLabel labelProductCode = new JLabel("Código del Producto: "+cod);
		panelProductInfo.add(labelProductName);
		panelProductInfo.add(labelProductCode);
		
		tableReport = new JTable(tableModelProductMonthly);
		tableReport.setFillsViewportHeight(true);
		tableReport.setPreferredScrollableViewportSize(new Dimension(600, 80));
		tableReport.setRowSelectionAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		tableReport.getTableHeader().setReorderingAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		scrollReport = new JScrollPane(tableReport);
		
		
		JPanel panelProductTotal = new JPanel();
		int total = 0;
		try {
			total = conexionBDConsultarVentas.QueryProductReport(cod, month, year, tableReport);
		} catch (Exception e){
			e.printStackTrace();
		}
		JLabel labelProductTotal = new JLabel("Total: "+total+" Bs.");
		panelProductTotal.add(labelProductTotal);
		
		this.add(panelProductInfo,BorderLayout.NORTH);
		this.add(scrollReport, BorderLayout.CENTER);
		this.add(panelProductTotal,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public ReporteVentasProducto(String cod, String productName, String semester, int year) {
		this.setTitle("Reporte de Ventas por Producto");
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setLayout(new BorderLayout());
		
		JPanel panelProductInfo = new JPanel();
		JLabel labelProductName = new JLabel("Producto: "+productName);
		JLabel labelProductCode = new JLabel("Código del Producto: "+cod);
		panelProductInfo.add(labelProductName);
		panelProductInfo.add(labelProductCode);
		
		tableReport = new JTable(tableModelProductSemesterly);
		tableReport.setFillsViewportHeight(true);
		tableReport.setPreferredScrollableViewportSize(new Dimension(600, 80));
		tableReport.setRowSelectionAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		tableReport.getTableHeader().setReorderingAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		scrollReport = new JScrollPane(tableReport);
		
		JPanel panelProductTotal = new JPanel();
		int total = 0;
		try {
			total = conexionBDConsultarVentas.QueryProductReport(cod, semester, year, tableReport);
		} catch (Exception e){
			e.printStackTrace();
		}
		JLabel labelProductTotal = new JLabel("Total: "+total+" Bs.");
		panelProductTotal.add(labelProductTotal);
		
		this.add(panelProductInfo,BorderLayout.NORTH);
		this.add(scrollReport, BorderLayout.CENTER);
		this.add(panelProductTotal,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public ReporteVentasProducto(String cod, String productName, int year) {
		this.setTitle("Reporte de Ventas por Producto");
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setLayout(new BorderLayout());
		
		JPanel panelProductInfo = new JPanel();
		JLabel labelProductName = new JLabel("Producto: "+productName);
		JLabel labelProductCode = new JLabel("Código del Producto: "+cod);
		panelProductInfo.add(labelProductName);
		panelProductInfo.add(labelProductCode);
		
		tableReport = new JTable(tableModelProductAnnually);
		tableReport.setFillsViewportHeight(true);
		tableReport.setPreferredScrollableViewportSize(new Dimension(600, 80));
		tableReport.setRowSelectionAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		tableReport.getTableHeader().setReorderingAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		scrollReport = new JScrollPane(tableReport);
		
		JPanel panelProductTotal = new JPanel();
		int total = 0;
		try {
			total = conexionBDConsultarVentas.QueryProductReport(cod, year, tableReport);
		} catch (Exception e){
			e.printStackTrace();
		}
		JLabel labelProductTotal = new JLabel("Total: "+total+" Bs.");
		panelProductTotal.add(labelProductTotal);
		
		this.add(panelProductInfo,BorderLayout.NORTH);
		this.add(scrollReport, BorderLayout.CENTER);
		this.add(panelProductTotal,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public ReporteVentasProducto(String cod, String productName, String start, String end) {
		this.setTitle("Reporte de Ventas por Producto");
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setLayout(new BorderLayout());
		
		JPanel panelProductInfo = new JPanel();
		JLabel labelProductName = new JLabel("Producto: "+productName);
		JLabel labelProductCode = new JLabel("Código del Producto: "+cod);
		panelProductInfo.add(labelProductName);
		panelProductInfo.add(labelProductCode);
		
		tableReport = new JTable(tableModelProductPersonalized);
		tableReport.setFillsViewportHeight(true);
		tableReport.setPreferredScrollableViewportSize(new Dimension(600, 80));
		tableReport.setRowSelectionAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		tableReport.getTableHeader().setReorderingAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		scrollReport = new JScrollPane(tableReport);
		
		JPanel panelProductTotal = new JPanel();
		int total = 0;
		try {
			total = conexionBDConsultarVentas.QueryProductReport(cod, start, end, tableReport);
		} catch (Exception e){
			e.printStackTrace();
		}
		JLabel labelProductTotal = new JLabel("Total: "+total+" Bs.");
		panelProductTotal.add(labelProductTotal);
		
		this.add(panelProductInfo,BorderLayout.NORTH);
		this.add(scrollReport, BorderLayout.CENTER);
		this.add(panelProductTotal,BorderLayout.SOUTH);
		this.setVisible(true);
	}
}
