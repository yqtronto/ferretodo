package paneles;

import bd.ConexionBDConsultarVentas;
import formularios.ReporteVentasProducto;
import formularios.ReporteVentasEmpleado;
import formularios.ReporteVentasSucursal;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.table.*;

import com.toedter.calendar.*;

public class PanelConsultasVarias extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private final String MONTHLY = "Mensual", SEMESTERLY = "Semestral", ANNUALLY = "Anual", PERSONALIZED = "Personalizado";
	private final String CONSOLIDATED = "Consolidado", BY_PRODUCT = "Por Producto", BY_EMPLOYEE = "Por Empleado", BY_BRANCH= "Por Sucursal";
	private final String[] arrayProduct = {"CODIGO","NOMBRE","PESO","COLOR","MARCA"};
	private final String[] arrayEmployee = {"CODIGO", "NOMBRE", "APELLIDO", "CI", "SUCURSAL"};
	private final String[] arrayBranch = {"CODIGO","CIUDAD","REFERENCIA"};
	
	private DefaultTableModel tableModelEmpty = new DefaultTableModel();
	private DefaultTableModel tableModelProduct = new DefaultTableModel(arrayProduct,0);
	private DefaultTableModel tableModelEmployee = new DefaultTableModel(arrayEmployee,0);
	private DefaultTableModel tableModelBranch = new DefaultTableModel(arrayBranch,0);
	
	private JComboBox<String> comboPeriod;
	private JComboBox<String> comboType;
	private JTable tableResults = new JTable();
	
	private JComboBox<String> comboMonth;
	private JYearChooser chooseYear1;
	
	private JComboBox<String> comboSemester;
	private JYearChooser chooseYear2;

	private JYearChooser chooseYear3;

	private JDateChooser chooseStartDate;
	private JDateChooser chooseEndDate;
	
	private JTextField textProductName;
	private JTextField textEmployeeName;
	private JTextField textBranchName;

	private ConexionBDConsultarVentas conexionBDConsultarVentas = new ConexionBDConsultarVentas();
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	//Constructor por defecto.
	
	public PanelConsultasVarias(){
		JLabel labelTitle = new JLabel("CONSULTA DE VENTAS");
		JLabel labelPeriod = new JLabel("Periodo: ");
		String[] arrayPeriod = {MONTHLY,SEMESTERLY,ANNUALLY,PERSONALIZED};
		comboPeriod = new JComboBox<>(arrayPeriod);
		comboPeriod.setSelectedIndex(0);

		JPanel panelPeriodSelect = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelPeriodSelect.add(labelPeriod);
		panelPeriodSelect.add(comboPeriod);
		
		PeriodPanel panelPeriod = new PeriodPanel();
		
		JLabel labelType = new JLabel("Tipo de Reporte: ");
		String[] arrayType = {CONSOLIDATED,BY_PRODUCT,BY_EMPLOYEE,BY_BRANCH};
		comboType = new JComboBox<>(arrayType);
		comboType.setSelectedIndex(0);
		
		JPanel panelTypeSelect = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelTypeSelect.add(labelType);
		panelTypeSelect.add(comboType);
		
		TypePanel panelType = new TypePanel();
		
		JPanel panelResults = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JScrollPane scrollResults = new JScrollPane(tableResults);
		tableResults.setFillsViewportHeight(true);
		tableResults.setPreferredScrollableViewportSize(new Dimension(600, 80));
		tableResults.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableResults.setDefaultEditor(Object.class, null);
		tableResults.getTableHeader().setReorderingAllowed(false);
		tableModelEmpty.addColumn(" ");
		tableResults.setModel(tableModelEmpty);
		panelResults.add(scrollResults);
		
		JButton btnReport = new JButton("Generar Reporte");
		btnReport.addActionListener(new SelectListener());
		
		comboPeriod.addActionListener(ActionEvent -> {
			switch (comboPeriod.getSelectedIndex()){
				case 0:
					panelPeriod.periodLay.show(panelPeriod, MONTHLY);
					break;
				case 1:
					panelPeriod.periodLay.show(panelPeriod, SEMESTERLY);
					break;
				case 2:
					panelPeriod.periodLay.show(panelPeriod, ANNUALLY);
					break;
				case 3:
					panelPeriod.periodLay.show(panelPeriod, PERSONALIZED);
					break;
				default:
			}
		});
		
		comboType.addActionListener(ActionEvent -> {
			switch (comboType.getSelectedIndex()){
				case 0:
					panelType.typeLay.show(panelType, CONSOLIDATED);
					tableResults.setModel(tableModelEmpty);
					break;
				case 1:
					panelType.typeLay.show(panelType, BY_PRODUCT);
					tableResults.setModel(tableModelProduct);
					break;
				case 2:
					panelType.typeLay.show(panelType, BY_EMPLOYEE);
					tableResults.setModel(tableModelEmployee);
					break;
				case 3:
					panelType.typeLay.show(panelType, BY_BRANCH);
					tableResults.setModel(tableModelBranch);
					break;
				default:
			}
		});
		
		GridBagLayout gridBagLay = new GridBagLayout();
		this.setLayout(gridBagLay);
		GridBagConstraints gridBagConst = new GridBagConstraints();
		
		//Posicionamiento de los componentes en el panel principal
		gridBagConst.anchor = GridBagConstraints.WEST;
		gridBagConst.gridx=0;
		gridBagConst.gridy=0;
		gridBagConst.insets=new Insets(5,0,5,0);
		gridBagLay.setConstraints(labelTitle, gridBagConst);
		this.add(labelTitle);
		
		gridBagConst.gridy=1;
		gridBagLay.setConstraints(panelPeriodSelect, gridBagConst);
		this.add(panelPeriodSelect);
		
		//Posicionamiento de PeriodPanel en panel principal
		gridBagConst.gridy=2;
		gridBagLay.setConstraints(panelPeriod, gridBagConst);
		this.add(panelPeriod);
		
		gridBagConst.gridy=3;
		gridBagLay.setConstraints(panelTypeSelect, gridBagConst);
		this.add(panelTypeSelect);
		
		//Posicionamiento de TypePanel en panel principal
		gridBagConst.gridy=4;
		gridBagLay.setConstraints(panelType, gridBagConst);
		this.add(panelType);

		gridBagConst.gridy=5;
		gridBagLay.setConstraints(panelResults, gridBagConst);
		this.add(panelResults);
		
		gridBagConst.gridy=6;
		gridBagConst.anchor = GridBagConstraints.EAST;
		gridBagLay.setConstraints(btnReport, gridBagConst);
		this.add(btnReport);
	}
	
	//Panel con un CardLayout para arropar las selecciones por periodo.
	//Agrega MonthPanel, SemesterPanel, YearPanel y DatePanel).
	@SuppressWarnings("serial")
	private class PeriodPanel extends JPanel {
		CardLayout periodLay = new CardLayout();
		
		private PeriodPanel() {
			MonthPanel monthPanel = new MonthPanel();
			SemesterPanel semesterPanel = new SemesterPanel();
			YearPanel yearPanel = new YearPanel();
			DatePanel datePanel = new DatePanel();
			this.setLayout(periodLay);
			this.add(monthPanel, MONTHLY);
			this.add(semesterPanel, SEMESTERLY);
			this.add(yearPanel, ANNUALLY);
			this.add(datePanel, PERSONALIZED);
		}
		
		private class MonthPanel extends JPanel {
			private final String[] monthArray = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
			private JLabel labelMonth = new JLabel("Mes: ");
			private JLabel labelYear = new JLabel("Año: ");
			
			private MonthPanel() {
				comboMonth = new JComboBox<>(monthArray);
				chooseYear1 = new JYearChooser();
				comboMonth.setSelectedIndex(-1);
				this.add(labelYear);
				this.add(chooseYear1);
				this.add(labelMonth);
				this.add(comboMonth);
			}
		}
		
		private class SemesterPanel extends JPanel {
			private JLabel labelSemester = new JLabel("Semestre: ");
			private JLabel labelYear = new JLabel("Año: ");
			private String[] semesterArray = {"Primero","Segundo"};
			
			private SemesterPanel() {
				comboSemester = new JComboBox<>(semesterArray);
				chooseYear2 = new JYearChooser();
				comboSemester.setSelectedIndex(-1);
				this.add(labelYear);
				this.add(chooseYear2);
				this.add(labelSemester);
				this.add(comboSemester);
			}
		}

		private class YearPanel extends JPanel {
			private JLabel labelYear = new JLabel("Año: ");
			
			private YearPanel() {
				chooseYear3 = new JYearChooser();
				this.add(labelYear);
				this.add(chooseYear3);
			}
		}
		
		private class DatePanel extends JPanel {
			private JLabel labelStartDate = new JLabel("Desde: ");
			private JLabel labelEndDate = new JLabel("Hasta: ");
			
			private DatePanel() {
				chooseStartDate = new JDateChooser();
				chooseEndDate = new JDateChooser();
				this.add(labelStartDate);
				this.add(chooseStartDate);
				this.add(labelEndDate);
				this.add(chooseEndDate);
			}
		}
	}
	
	//Panel con un CardLayout para arropar las selecciones por tipo de busqueda. 
	//Agrega ProductPanel, SemesterPanel y BranchPanel.
	@SuppressWarnings("serial")
	private class TypePanel extends JPanel {
		private CardLayout typeLay = new CardLayout();
		
		private TypePanel() {
			JPanel emptyPanel = new JPanel();
			ProductPanel productPanel = new ProductPanel();
			EmployeePanel employeePanel = new EmployeePanel();
			BranchPanel branchPanel = new BranchPanel();
			this.setLayout(typeLay);
			this.add(emptyPanel, CONSOLIDATED);
			this.add(productPanel, BY_PRODUCT);
			this.add(employeePanel, BY_EMPLOYEE);
			this.add(branchPanel, BY_BRANCH);
		}
		
		private class ProductPanel extends JPanel {
			private JLabel labelProductName = new JLabel("Nombre del producto: ");
			private JButton btnSearch = new JButton("Buscar");
			
			private ProductPanel() {
				textProductName = new JTextField(20);
				btnSearch.addActionListener(new SearchListener());
				this.add(labelProductName);
				this.add(textProductName);
				this.add(btnSearch);
			}
			
		}
		
		private class EmployeePanel extends JPanel {
			private JLabel labelEmployeeName = new JLabel("Nombre o apellido del empleado: ");
			private JButton btnSearch = new JButton("Buscar");
			
			private EmployeePanel() {
				textEmployeeName = new JTextField(20);
				btnSearch.addActionListener(new SearchListener());
				this.add(labelEmployeeName,BorderLayout.WEST);
				this.add(textEmployeeName);
				this.add(btnSearch);
			}
		}
		
		private class BranchPanel extends JPanel {
			private JLabel labelBranchName = new JLabel("Ciudad de la sucursal: ");
			private JButton btnSearch = new JButton("Buscar");
			
			private BranchPanel() {
				textBranchName = new JTextField(20);
				btnSearch.addActionListener(new SearchListener());
				this.add(labelBranchName);
				this.add(textBranchName);
				this.add(btnSearch);
			}
		}
	}
	
	private class SearchListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			try {
				switch (comboType.getSelectedIndex()){
				case 0:
					break;
				case 1: if (!textProductName.getText().isEmpty()){
					/*
					text = textProductName.getText();
					System.out.println("Searching for: "+text);
					tableModelProduct.setDataVector(dataProduct, arrayProduct);
					*/
					String text = textProductName.getText();
					conexionBDConsultarVentas.QueryProduct(tableResults,text);
				}else {
					//System.out.println("Must enter a product's name");
					conexionBDConsultarVentas.QueryProduct(tableResults);
				}
					break;
				case 2: if (!textEmployeeName.getText().isEmpty()){
					/*
					text = textEmployeeName.getText();
					System.out.println("Searching for: "+text);
					tableModelEmployee.setDataVector(dataEmployee, arrayEmployee);
					*/
					String text = textEmployeeName.getText();
					conexionBDConsultarVentas.QueryEmployee(tableResults,text);
				}else {
					//System.out.println("Must enter an employee's name");
					conexionBDConsultarVentas.QueryEmployee(tableResults);
				}
					break;
				case 3: if (!textBranchName.getText().isEmpty()){
					/*
					text = textBranchName.getText();
					System.out.println("Searching for: "+text);
					tableModelBranch.setDataVector(dataBranch, arrayBranch);
					*/
					String text = textBranchName.getText();
					conexionBDConsultarVentas.QueryBranch(tableResults,text);
				}else {
					//System.out.println("Must enter a branch's name");
					conexionBDConsultarVentas.QueryBranch(tableResults);
				}
					break;
				default:
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private class SelectListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			try {
				int month = 0, year = 0, salesNum = 0;
				String semester = "", start = "", end = "";
				String cod = "", productName = "", fullName = "", city= "";
				java.sql.Date dateStart = null, dateEnd = null;
				
				
				switch (comboType.getSelectedIndex()) {
				case 0:
					switch (comboPeriod.getSelectedIndex()) {
					case 0: 
						
						break;
					case 1:
						
						break;
					case 2:
						
						break;
					case 3:
						
						break;
					default:
							
					}
					
					break;
				case 1: 
					try {
						cod = getCodeFromTable(tableResults);
						productName = getProductNameFromTable(tableResults);
						switch (comboPeriod.getSelectedIndex()) {
						case 0: if (comboMonth.getSelectedIndex()>-1 && chooseYear1.getValue() > 0) {
							month = comboMonth.getSelectedIndex();
							year = chooseYear1.getValue();
							salesNum = conexionBDConsultarVentas.QueryProductSales(cod, month, Integer.valueOf(year));
							if (salesNum==0){
								JOptionPane.showMessageDialog(null, "No se encontraron ventas");
							}else {
								ReporteVentasProducto vent = new ReporteVentasProducto(cod,productName,month,year);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Debe indicar un mes y aun año");
						}
							break;
						case 1: if (comboSemester.getSelectedIndex()>-1 && chooseYear2.getValue() > 0) {
							semester = comboSemester.getItemAt(comboSemester.getSelectedIndex());
							year = chooseYear2.getValue();
							salesNum = conexionBDConsultarVentas.QueryProductSales(cod, semester, Integer.valueOf(year));
							if (salesNum==0){
								JOptionPane.showMessageDialog(null, "No se encontraron ventas");
							}else {
								ReporteVentasProducto vent = new ReporteVentasProducto(cod,productName,semester,year);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Debe indicar un semestre y un año");
						}
							break;
						case 2:if (chooseYear3.getValue() > 0) {
							year = chooseYear3.getValue();
							salesNum = conexionBDConsultarVentas.QueryProductSales(cod, Integer.valueOf(year));
							if (salesNum==0){
								JOptionPane.showMessageDialog(null, "No se encontraron ventas");
							}else {
								ReporteVentasProducto vent = new ReporteVentasProducto(cod,productName,year);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Debe indicar un año");
						}
							break;
						case 3: if (chooseStartDate.getDate() != null && chooseEndDate.getDate() != null) {
							dateStart = new java.sql.Date(chooseStartDate.getDate().getTime());
							dateEnd = new java.sql.Date(chooseEndDate.getDate().getTime());
							start = dateFormat.format(dateStart);
							end = dateFormat.format(dateEnd);
							salesNum = conexionBDConsultarVentas.QueryProductSales(cod, start, end);
							if (salesNum==0){
								JOptionPane.showMessageDialog(null, "No se encontraron ventas");
							}else {
								ReporteVentasProducto vent = new ReporteVentasProducto(cod,productName,start,end);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Debe indicar una fecha inicial y una fecha final");
						}
							break;
						default:
								
						}
					}catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
					}
				
				
					break;
				case 2: 
					try {
						cod = getCodeFromTable(tableResults);
						fullName = getFullNameFromTable(tableResults);
						switch (comboPeriod.getSelectedIndex()) {
						case 0: if (comboMonth.getSelectedIndex()>-1 && chooseYear1.getValue() > 0) {
							month = comboMonth.getSelectedIndex();
							year = chooseYear1.getValue();
							salesNum = conexionBDConsultarVentas.QueryEmployeeSales(cod, month, Integer.valueOf(year));
							if (salesNum==0){
								JOptionPane.showMessageDialog(null, "No se encontraron ventas");
							}else {
								ReporteVentasEmpleado vent = new ReporteVentasEmpleado(cod,fullName,month,year);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Debe indicar un mes y aun año");
						}
							break;
						case 1: if (comboSemester.getSelectedIndex()>-1 && chooseYear2.getValue() > 0) {
							semester = comboSemester.getItemAt(comboSemester.getSelectedIndex());
							year = chooseYear2.getValue();
							salesNum = conexionBDConsultarVentas.QueryEmployeeSales(cod, semester, Integer.valueOf(year));
							if (salesNum==0){
								JOptionPane.showMessageDialog(null, "No se encontraron ventas");
							}else {
								ReporteVentasEmpleado vent = new ReporteVentasEmpleado(cod,fullName,semester,year);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Debe indicar un semestre y un año");
						}
							break;
						case 2: if (chooseYear3.getValue() > 0) {
							year = chooseYear3.getValue();
							salesNum = conexionBDConsultarVentas.QueryEmployeeSales(cod, Integer.valueOf(year));
							if (salesNum==0){
								JOptionPane.showMessageDialog(null, "No se encontraron ventas");
							}else {
								ReporteVentasEmpleado vent = new ReporteVentasEmpleado(cod,fullName,year);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Debe indicar un año");
						}
							break;
						case 3: if (chooseStartDate.getDate() != null && chooseEndDate.getDate() != null) {
							dateStart = new java.sql.Date(chooseStartDate.getDate().getTime());
							dateEnd = new java.sql.Date(chooseEndDate.getDate().getTime());
							start = dateFormat.format(dateStart);
							end = dateFormat.format(dateEnd);
							salesNum = conexionBDConsultarVentas.QueryEmployeeSales(cod, start, end);
							if (salesNum==0){
								JOptionPane.showMessageDialog(null, "No se encontraron ventas");
							}else {
								ReporteVentasEmpleado vent = new ReporteVentasEmpleado(cod,fullName,start,end);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Debe indicar una fecha inicial y una fecha final");
						}
							break;
						default:
								
						}
					}catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
					}
					break;
				case 3:
					try {
						cod = getCodeFromTable(tableResults);
						city = getCityFromTable(tableResults);
						switch (comboPeriod.getSelectedIndex()) {
						case 0: if (comboMonth.getSelectedIndex()>-1 && chooseYear1.getValue() > 0) {
							month = comboMonth.getSelectedIndex();
							year = chooseYear1.getValue();
							salesNum = conexionBDConsultarVentas.QueryBranchSales(cod, month, Integer.valueOf(year));
							if (salesNum==0){
								JOptionPane.showMessageDialog(null, "No se encontraron ventas");
							}else {
								ReporteVentasSucursal vent = new ReporteVentasSucursal(cod,city,month,year);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Debe indicar un mes y aun año");
						}
							break;
						case 1: if (comboSemester.getSelectedIndex()>-1 && chooseYear2.getValue() > 0) {
							semester = comboSemester.getItemAt(comboSemester.getSelectedIndex());
							year = chooseYear2.getValue();
							salesNum = conexionBDConsultarVentas.QueryBranchSales(cod, semester, Integer.valueOf(year));
							if (salesNum==0){
								JOptionPane.showMessageDialog(null, "No se encontraron ventas");
							}else {
								ReporteVentasSucursal vent = new ReporteVentasSucursal(cod,city,semester,year);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Debe indicar un semestre y un año");
						}
							break;
						case 2: if (chooseYear3.getValue() > 0) {
							year = chooseYear3.getValue();
							salesNum = conexionBDConsultarVentas.QueryBranchSales(cod, Integer.valueOf(year));
							if (salesNum==0){
								JOptionPane.showMessageDialog(null, "No se encontraron ventas");
							}else {
								ReporteVentasSucursal vent = new ReporteVentasSucursal(cod,city,year);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Debe indicar un año");
						}
							break;
						case 3: if (chooseStartDate.getDate() != null && chooseEndDate.getDate() != null) {
							dateStart = new java.sql.Date(chooseStartDate.getDate().getTime());
							dateEnd = new java.sql.Date(chooseEndDate.getDate().getTime());
							start = dateFormat.format(dateStart);
							end = dateFormat.format(dateEnd);
							salesNum = conexionBDConsultarVentas.QueryBranchSales(cod, start, end);
							if (salesNum==0){
								JOptionPane.showMessageDialog(null, "No se encontraron ventas");
							}else {
								ReporteVentasSucursal vent = new ReporteVentasSucursal(cod,city,start,end);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Debe indicar una fecha inicial y una fecha final");
						}
							break;
						default:
								
						}
					}catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
					}
					break;
				default:
						
				}
				
			}catch (Exception e){
				e.printStackTrace();
			}
		}
			
		private String getCodeFromTable (JTable table) {
			String cod = "";
			int row = table.getSelectedRow();
			cod = table.getModel().getValueAt(row,0).toString();
			return cod;
		}
		
		private String getProductNameFromTable (JTable table) {
			String name = "";
			int row = table.getSelectedRow();
			name = table.getModel().getValueAt(row,1).toString();
			return name;
		}
		
		private String getFullNameFromTable (JTable table) {
			String firstName = "", lastName = "", fullName = "";
			int row = table.getSelectedRow();
			firstName = table.getModel().getValueAt(row,1).toString();
			lastName = table.getModel().getValueAt(row,2).toString();
			fullName = (firstName+" "+lastName);
			return fullName;
		}
		
		private String getCityFromTable (JTable table) {
			String city = "";
			int row = table.getSelectedRow();
			city = table.getModel().getValueAt(row,1).toString();
			return city;
		}
	}
}
