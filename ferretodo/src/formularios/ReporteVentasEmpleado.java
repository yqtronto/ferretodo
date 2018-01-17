package formularios;

import bd.ConexionBDConsultarVentas;

import java.awt.Dimension;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ReporteVentasEmpleado extends JDialog{
	private final String[] arrayEmployeeMonthly = {"FECHA EMISION","CANTIDAD","PRECIO","TOTAL"};
	private final String[] arrayEmployeeSemesterly = {"FECHA EMISION","CANTIDAD","PRECIO","TOTAL"};
	private final String[] arrayEmployeeAnnually = {"FECHA EMISION","CANTIDAD","PRECIO","TOTAL"};
	private final String[] arrayEmployeePersonalized = {"FECHA EMISION","CANTIDAD","PRECIO","TOTAL"};
	private DefaultTableModel tableModelEmployeeMonthly = new DefaultTableModel(arrayEmployeeMonthly,0);
	private DefaultTableModel tableModelEmployeeSemesterly = new DefaultTableModel(arrayEmployeeSemesterly,0);
	private DefaultTableModel tableModelEmployeeAnnually = new DefaultTableModel(arrayEmployeeAnnually,0);
	private DefaultTableModel tableModelEmployeePersonalized = new DefaultTableModel(arrayEmployeePersonalized,0);
	private JTable tableReport;
	private JScrollPane scrollReport;
	private ConexionBDConsultarVentas conexionBDConsultarVentas = new ConexionBDConsultarVentas();
	
	public ReporteVentasEmpleado(String cod, String fullName, int month, int year) {
		this.setTitle("Reporte de Ventas por Empleado");
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setLayout(new BorderLayout());
		
		JPanel panelEmployeeInfo = new JPanel();
		JLabel labelEmployeeName = new JLabel("Empleado: "+fullName);
		JLabel labelEmployeeCode = new JLabel("Código del Empleado: "+cod);
		panelEmployeeInfo.add(labelEmployeeName);
		panelEmployeeInfo.add(labelEmployeeCode);
		
		tableReport = new JTable(tableModelEmployeeMonthly);
		tableReport.setFillsViewportHeight(true);
		tableReport.setPreferredScrollableViewportSize(new Dimension(600, 80));
		tableReport.setRowSelectionAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		tableReport.getTableHeader().setReorderingAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		scrollReport = new JScrollPane(tableReport);
		
		
		JPanel panelEmployeeTotal = new JPanel();
		int total = 0;
		try {
			total = conexionBDConsultarVentas.QueryEmployeeReport(cod, month, year, tableReport);
		} catch (Exception e){
			e.printStackTrace();
		}
		JLabel labelEmployeeTotal = new JLabel("Total: "+total+" Bs.");
		panelEmployeeTotal.add(labelEmployeeTotal);
		
		this.add(panelEmployeeInfo,BorderLayout.NORTH);
		this.add(scrollReport, BorderLayout.CENTER);
		this.add(panelEmployeeTotal,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public ReporteVentasEmpleado(String cod, String fullName, String semester, int year) {
		this.setTitle("Reporte de Ventas por Empleado");
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setLayout(new BorderLayout());
		
		JPanel panelEmployeeInfo = new JPanel();
		JLabel labelEmployeeName = new JLabel("Empleado: "+fullName);
		JLabel labelEmployeeCode = new JLabel("Código del Empleado: "+cod);
		panelEmployeeInfo.add(labelEmployeeName);
		panelEmployeeInfo.add(labelEmployeeCode);
		
		tableReport = new JTable(tableModelEmployeeSemesterly);
		tableReport.setFillsViewportHeight(true);
		tableReport.setPreferredScrollableViewportSize(new Dimension(600, 80));
		tableReport.setRowSelectionAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		tableReport.getTableHeader().setReorderingAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		scrollReport = new JScrollPane(tableReport);
		
		
		JPanel panelEmployeeTotal = new JPanel();
		int total = 0;
		try {
			total = conexionBDConsultarVentas.QueryEmployeeReport(cod, semester, year, tableReport);
		} catch (Exception e){
			e.printStackTrace();
		}
		JLabel labelEmployeeTotal = new JLabel("Total: "+total+" Bs.");
		panelEmployeeTotal.add(labelEmployeeTotal);
		
		this.add(panelEmployeeInfo,BorderLayout.NORTH);
		this.add(scrollReport, BorderLayout.CENTER);
		this.add(panelEmployeeTotal,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public ReporteVentasEmpleado(String cod, String fullName, int year) {
		this.setTitle("Reporte de Ventas por Empleado");
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setLayout(new BorderLayout());
		
		JPanel panelEmployeeInfo = new JPanel();
		JLabel labelEmployeeName = new JLabel("Empleado: "+fullName);
		JLabel labelEmployeeCode = new JLabel("Código del Empleado: "+cod);
		panelEmployeeInfo.add(labelEmployeeName);
		panelEmployeeInfo.add(labelEmployeeCode);
		
		tableReport = new JTable(tableModelEmployeeAnnually);
		tableReport.setFillsViewportHeight(true);
		tableReport.setPreferredScrollableViewportSize(new Dimension(600, 80));
		tableReport.setRowSelectionAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		tableReport.getTableHeader().setReorderingAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		scrollReport = new JScrollPane(tableReport);
		
		
		JPanel panelEmployeeTotal = new JPanel();
		int total = 0;
		try {
			total = conexionBDConsultarVentas.QueryEmployeeReport(cod, year, tableReport);
		} catch (Exception e){
			e.printStackTrace();
		}
		JLabel labelEmployeeTotal = new JLabel("Total: "+total+" Bs.");
		panelEmployeeTotal.add(labelEmployeeTotal);
		
		this.add(panelEmployeeInfo,BorderLayout.NORTH);
		this.add(scrollReport, BorderLayout.CENTER);
		this.add(panelEmployeeTotal,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public ReporteVentasEmpleado(String cod, String fullName, String start, String end) {
		this.setTitle("Reporte de Ventas por Empleado");
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setLayout(new BorderLayout());
		
		JPanel panelEmployeeInfo = new JPanel();
		JLabel labelEmployeeName = new JLabel("Empleado: "+fullName);
		JLabel labelEmployeeCode = new JLabel("Código del Empleado: "+cod);
		panelEmployeeInfo.add(labelEmployeeName);
		panelEmployeeInfo.add(labelEmployeeCode);
		
		tableReport = new JTable(tableModelEmployeePersonalized);
		tableReport.setFillsViewportHeight(true);
		tableReport.setPreferredScrollableViewportSize(new Dimension(600, 80));
		tableReport.setRowSelectionAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		tableReport.getTableHeader().setReorderingAllowed(false);
		tableReport.setDefaultEditor(Object.class, null);
		scrollReport = new JScrollPane(tableReport);
		
		
		JPanel panelEmployeeTotal = new JPanel();
		int total = 0;
		try {
			total = conexionBDConsultarVentas.QueryEmployeeReport(cod, start, end, tableReport);
		} catch (Exception e){
			e.printStackTrace();
		}
		JLabel labelEmployeeTotal = new JLabel("Total: "+total+" Bs.");
		panelEmployeeTotal.add(labelEmployeeTotal);
		
		this.add(panelEmployeeInfo,BorderLayout.NORTH);
		this.add(scrollReport, BorderLayout.CENTER);
		this.add(panelEmployeeTotal,BorderLayout.SOUTH);
		this.setVisible(true);
	}
}
