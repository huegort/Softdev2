package week18_integrate_with_windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import week18_integrate_with_windows.dao.Car;
import week18_integrate_with_windows.dao.CarDAO;

public class CreateJPanel extends JPanel {
	CarJFrame parent;
	
	JButton createButton = new JButton("Create Car");
	JTextField tfId = new JTextField();
	JTextField tfRegNumber = new JTextField();
	JTextField tfMake = new JTextField();
	JTextField tfEngineCC = new JTextField();
	
	JLabel lbTitle = new JLabel("Create Car");
	JLabel lbId = new JLabel("id");
	JLabel lbRegNumber = new JLabel("Reg Number");
	JLabel lbMake = new JLabel("Make");
	JLabel lbEngineCC = new JLabel("EngineCC");
	
	JPanel titlePanel = new JPanel(new FlowLayout());
	JPanel formPanel = new JPanel(new GridLayout(4,2));
	JPanel actionPanel = new JPanel(new FlowLayout());
	
	
	public CreateJPanel(CarJFrame parent){
		this.parent = parent;
		initUI();
		placeComponents();
		bindListeners();
	}

	private void initUI() {
		
		
	}

	private void placeComponents() {
		this.setLayout(new BorderLayout());
		// put panels into this
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(formPanel, BorderLayout.CENTER);
		this.add(actionPanel, BorderLayout.SOUTH);
		
		// titlePanel
		titlePanel.add(lbTitle);
		
		//formPanel
		formPanel.add(lbId);
		formPanel.add(tfId);
		formPanel.add(lbRegNumber);
		formPanel.add(tfRegNumber);
		formPanel.add(lbMake);
		formPanel.add(tfMake);
		formPanel.add(lbEngineCC);
		formPanel.add(tfEngineCC);
		
		//actionPanel
		
		actionPanel.add(createButton);
	}

	private void bindListeners() {
		createButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				createClicked(arg0);
				
			}
			
		});
		
	}
	public void createClicked(ActionEvent arg0){
		Car car = new Car();
		// bind data to car
		String idString = tfId.getText();
		long id = Long.parseLong(idString);
		car.setId(id);
		
		car.setRegNum(this.tfRegNumber.getText());
		car.setMake(this.tfMake.getText());
		car.setEngineCC(Integer.parseInt(this.tfEngineCC.getText()));
		
		// use DAO to insert car
		CarDAO carDAO = new CarDAO();
		carDAO.create(car);
		
		parent.gotoMenu();
	}

}
