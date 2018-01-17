package formularios;

import bd.ConexionBDConsultarVentas;

import java.awt.Dimension;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ReporteVentasSucursal extends JDialog{
	private final String[] arrayBranchMonthly = {"FECHA EMISION","CANTIDAD","PRECIO","TOTAL"};
	private final String[] arrayBranchSemesterly = {"FECHA EMISION","CANTIDAD","PRECIO","TOTAL"};
	private final String[] arrayBranchAnnually = {"FECHA EMISION","CANTIDAD","PRECIO","TOTAL"};
	private final String[] arrayBranchPersonalized = {"FECHA EMISION","CANTIDAD","PRECIO","TOTAL"};
	private DefaultTableModel tableModelBranchMonthly = new DefaultTableModel(arrayBranchMonthly,0);
	private DefaultTableModel tableModelBranchSemesterly = new DefaultTableModel(arrayBranchSemesterly,0);
	private DefaultTableModel tableModelBranchAnnually = new DefaultTableModel(arrayBranchAnnually,0);
	private DefaultTableModel tableModelBranchPersonalized = new DefaultTableModel(arrayBranchPersonalized,0);
	private JTable tableReport;
	private JScrollPane scrollReport;
	private ConexionBDConsultarVentas conexionBDConsultarVentas = new ConexionBDConsultarVentas();
	
	public ReporteVentasSucursal(String cod, String city, int month, int year) {
		this.setTitle("Reporte de Ventas por Sucursal");
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setLayout(new BorderLayout());
		
		JPanel panelBranchInfo = new JPanel();
		JLabel labelBranchName = new JLabel("Sucursal de la ciudad: "+city);
		JLabel labelBranchCode = new JLabel("Código de la Sucursal: "+cod);
		panelBranchInfo.add(labelBranchName);
		panelBranchInfo.add(labelBranchCode);
		
		tableReport = new JTable(tableModelBranchMonthly);
		tableReport.setFillsViewportHeight(true);
		tableReport.setPreferredScrollableViewportSize(new Dimension(600, 80));
		tableReport.setRowSelectionAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		tableReport.getTableHeader().setReorderingAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		scrollReport = new JScrollPane(tableReport);
		
		
		JPanel panelBranchTotal = new JPanel();
		int total = 0;
		try {
			total = conexionBDConsultarVentas.QueryBranchReport(cod, month, year, tableReport);
		} catch (Exception e){
			e.printStackTrace();
		}
		JLabel labelBranchTotal = new JLabel("Total: "+total+" Bs.");
		panelBranchTotal.add(labelBranchTotal);
		
		this.add(panelBranchInfo,BorderLayout.NORTH);
		this.add(scrollReport, BorderLayout.CENTER);
		this.add(panelBranchTotal,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public ReporteVentasSucursal(String cod, String city, String semester, int year) {
		this.setTitle("Reporte de Ventas por Sucursal");
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setLayout(new BorderLayout());
		
		JPanel panelBranchInfo = new JPanel();
		JLabel labelBranchName = new JLabel("Sucursal de la ciudad: "+city);
		JLabel labelBranchCode = new JLabel("Código de la Sucursal: "+cod);
		panelBranchInfo.add(labelBranchName);
		panelBranchInfo.add(labelBranchCode);
		
		tableReport = new JTable(tableModelBranchSemesterly);
		tableReport.setFillsViewportHeight(true);
		tableReport.setPreferredScrollableViewportSize(new Dimension(600, 80));
		tableReport.setRowSelectionAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		tableReport.getTableHeader().setReorderingAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		scrollReport = new JScrollPane(tableReport);
		
		
		JPanel panelBranchTotal = new JPanel();
		int total = 0;
		try {
			total = conexionBDConsultarVentas.QueryBranchReport(cod, semester, year, tableReport);
		} catch (Exception e){
			e.printStackTrace();
		}
		JLabel labelBranchTotal = new JLabel("Total: "+total+" Bs.");
		panelBranchTotal.add(labelBranchTotal);
		
		this.add(panelBranchInfo,BorderLayout.NORTH);
		this.add(scrollReport, BorderLayout.CENTER);
		this.add(panelBranchTotal,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public ReporteVentasSucursal(String cod, String city, int year) {
		this.setTitle("Reporte de Ventas por Sucursal");
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setLayout(new BorderLayout());
		
		JPanel panelBranchInfo = new JPanel();
		JLabel labelBranchName = new JLabel("Sucursal de la ciudad: "+city);
		JLabel labelBranchCode = new JLabel("Código de la Sucursal: "+cod);
		panelBranchInfo.add(labelBranchName);
		panelBranchInfo.add(labelBranchCode);
		
		tableReport = new JTable(tableModelBranchAnnually);
		tableReport.setFillsViewportHeight(true);
		tableReport.setPreferredScrollableViewportSize(new Dimension(600, 80));
		tableReport.setRowSelectionAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		tableReport.getTableHeader().setReorderingAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		scrollReport = new JScrollPane(tableReport);
		
		
		JPanel panelBranchTotal = new JPanel();
		int total = 0;
		try {
			total = conexionBDConsultarVentas.QueryBranchReport(cod, year, tableReport);
		} catch (Exception e){
			e.printStackTrace();
		}
		JLabel labelBranchTotal = new JLabel("Total: "+total+" Bs.");
		panelBranchTotal.add(labelBranchTotal);
		
		this.add(panelBranchInfo,BorderLayout.NORTH);
		this.add(scrollReport, BorderLayout.CENTER);
		this.add(panelBranchTotal,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public ReporteVentasSucursal(String cod, String city, String start, String end) {
		this.setTitle("Reporte de Ventas por Sucursal");
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setLayout(new BorderLayout());
		
		JPanel panelBranchInfo = new JPanel();
		JLabel labelBranchName = new JLabel("Sucursal de la ciudad: "+city);
		JLabel labelBranchCode = new JLabel("Código de la Sucursal: "+cod);
		panelBranchInfo.add(labelBranchName);
		panelBranchInfo.add(labelBranchCode);
		
		tableReport = new JTable(tableModelBranchPersonalized);
		tableReport.setFillsViewportHeight(true);
		tableReport.setPreferredScrollableViewportSize(new Dimension(600, 80));
		tableReport.setRowSelectionAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		tableReport.getTableHeader().setReorderingAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		scrollReport = new JScrollPane(tableReport);
		
		
		JPanel panelBranchTotal = new JPanel();
		int total = 0;
		try {
			total = conexionBDConsultarVentas.QueryBranchReport(cod, start, end, tableReport);
		} catch (Exception e){
			e.printStackTrace();
		}
		JLabel labelBranchTotal = new JLabel("Total: "+total+" Bs.");
		panelBranchTotal.add(labelBranchTotal);
		
		this.add(panelBranchInfo,BorderLayout.NORTH);
		this.add(scrollReport, BorderLayout.CENTER);
		this.add(panelBranchTotal,BorderLayout.SOUTH);
		this.setVisible(true);
	}
}
