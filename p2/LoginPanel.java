import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel implements ActionListener{
	
	private static boolean login = false;
	private static boolean register = false;
	
	private JLabel customer_ID;
	private JLabel pin_number;
	private JLabel incorrect;
	
	private static JTextField customer_ID_Field;
	private static JTextField pin_number_Field;
	
	private JButton loginButton;
	private JButton registerButton;
	private JButton exitButton;	
	
	public LoginPanel(){
		
//		setLayout(new GridLayout(4,2));
		GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
		
		customer_ID = new JLabel("Customer ID");
		pin_number = new JLabel("PIN Number");	
		incorrect = new JLabel("");

		
		customer_ID_Field = new JTextField(15);
		pin_number_Field = new JTextField(15);

		
		loginButton = new JButton("login");
		registerButton = new JButton("register");

		exitButton = new JButton("Exit");
		
		loginButton.addActionListener(this);
		registerButton.addActionListener(this);
		exitButton.addActionListener(this);
		

		
		//add the buttons to the panel
		constraints.gridx = 0;
		constraints.gridy = 3;
		add(customer_ID_Field, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 3;
		add(customer_ID, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		add(pin_number_Field, constraints);

		constraints.gridx = 1;
		constraints.gridy = 2;
		add(pin_number, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		add(loginButton, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		add(registerButton, constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 1;
		add(exitButton, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		add(incorrect, constraints);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		
		if (buttonPressed.equals(loginButton)){
			System.out.println("Logging In");
			login = true;
		}
		
		else if (buttonPressed.equals(registerButton)){
			System.out.println("Registering new customer");		
			register = true;
		}
		
		else if (buttonPressed.equals(exitButton)){
			System.exit(0);			
		} 

		
		
	}
	
	public static boolean getLogin(){
		
		return login;
	}
	
	public static void setLoginFalse(){
		
		login = false;
	}
	
	public static boolean getRegister(){
		
		return register;
	}
	
	public static void setRegisterFalse(){
		register = false;
	}
	
	public static String getID(){
		return customer_ID_Field.getText();
	}

	public static String getPIN(){
		return pin_number_Field.getText();
	}
	
	public void setIncorrect(){
		incorrect.setText("Incorrect ID or Password");
	}
	
	public void setAccountNumber(String ID){
		incorrect.setText("**Customer Created**\n Customer Number: " + ID);
	}
	
	public void setClear(){
		incorrect.setText("");
		customer_ID_Field.setText("");
		pin_number_Field.setText("");
	}

	

}