import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class AdminPanel extends JPanel implements ActionListener{
	
	private boolean alphabetical = false;
	private boolean highest_balance = false;
	private boolean single_cust = false;
	private boolean transaction_log = false;
	private boolean exit = false;
	
	private String name = " ";
	
	private JTextArea report = new JTextArea(10,52);
	private JScrollPane scroll = new JScrollPane (report);
	
	private JComboBox accounts_box = new JComboBox();
	

	private JButton alphabeticalButton;
	private JButton balanceButton;
	private JButton customerButton;
	private JButton transactionButton;
	private JButton	exitButton;
	
	public AdminPanel(){
		
		GridBagConstraints constraints = new GridBagConstraints();
		scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	    constraints.anchor = GridBagConstraints.NORTHWEST;

	    accounts_box = new JComboBox();
	    accounts_box.addItem("-select customer-");
	    
		alphabeticalButton = new JButton		("Accounts in Alphabetical Order");
		balanceButton = new JButton		("Highest to Lowest Balance");
		customerButton = new JButton	(" Customer Accounts");
		transactionButton = new JButton	("Transaction Report");

		exitButton = new JButton("                 Exit ADMIN                ");
		

		
		alphabeticalButton.addActionListener(this);
		balanceButton.addActionListener(this);
		customerButton.addActionListener(this);
		transactionButton.addActionListener(this);

		exitButton.addActionListener(this);
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		add(alphabeticalButton,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 3;
		add(balanceButton,constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 3;
		add(transactionButton,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		add(customerButton,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 2;
		add(accounts_box,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		add(exitButton,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 0;		
		add(scroll, constraints);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();

		if (buttonPressed.equals(alphabeticalButton)){
			System.out.println("Sorting Alphabetically");
			alphabetical = true;
			
		}
		
		else if (buttonPressed.equals(balanceButton)){
			System.out.println("Sorting by Balance");
			highest_balance = true;
		}
		
		
		else if (buttonPressed.equals(customerButton)){
			System.out.println("Sorting by Customer Per Account ID");
			single_cust = true;
			
		}
		
		else if (buttonPressed.equals(transactionButton)){
			System.out.println("Generating Transaction Log");
			transaction_log = true;
			
		}
		
		else if (buttonPressed.equals(exitButton)){
			System.out.println("Exiting Admin Tools!");
			exit = true;
		}

		
	}
	
	public void setPanel(){
		report.append("5\n");
		report.append("5\n");
		report.append("5\n");
		report.append("5\n");
		report.append("5\n");
		report.append("5\n");
		report.append("5\n");
		report.append("5\n");
		report.append("5\n");
		report.append("5\n");
		report.append("5\n");
		report.append("5\n");
	}
	
	public void addToAccountBox(String acct){
		accounts_box.addItem(acct);
	}
	
	public boolean getExit(){
		return exit;
	}
	
	public void setExitFalse(){
		exit = false;
	}
	
	public void clearDisplay(){
		report.setText("");
	}
	
	public boolean getTransactionLog(){
		return transaction_log;
	}
	
	public void setTransactionLogFalse(){
		transaction_log = false;
	}
	
	public void addToDisplay(String info){
		report.append(info);
	}
	
	public boolean getAlphabetical(){
		return alphabetical;
	}
	
	public void setAlphabeticalFalse(){
		alphabetical = false;
	}
	
	public boolean getHighestBalance(){
		return highest_balance;
	}
	
	public void setHighestBalanceFalse(){
		highest_balance = false;
	}
	
	public boolean getSingleCust(){
		return single_cust;
	}
	
	public void setSingleCustFalse(){
		single_cust = false;
	}
	
	public String getSelectCustomer(){
		return String.valueOf(accounts_box.getSelectedItem());
	}
}