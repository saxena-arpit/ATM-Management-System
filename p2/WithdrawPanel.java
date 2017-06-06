import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class WithdrawPanel extends JPanel implements ActionListener{

	private boolean withdraw = false;
//	private boolean checking = false;
	
	private JLabel desired_amount;
	private JLabel desired_account;
	
	private JComboBox accounts_box = new JComboBox();
	
	private JButton makeWithdrawButton;
	
	private JTextField amount;
	
	public WithdrawPanel(){
			
			GridBagConstraints constraints = new GridBagConstraints();
		    constraints.anchor = GridBagConstraints.WEST;
		    
		    desired_amount = new JLabel ("Desired Amount");
		    desired_account = new JLabel ("                   Desired Account  ");
		    
		    accounts_box = new JComboBox();
		    accounts_box.addItem("-select account-");
		    		
		    makeWithdrawButton = new JButton		("Make Withdrawal");
		    
		    amount = new JTextField(15);
		    amount.setText("");
		    
		    makeWithdrawButton.addActionListener(this);
		    
			constraints.gridx = 0;
			constraints.gridy = 2;
			add(amount,constraints);
			
			constraints.gridx = 1;
			constraints.gridy = 2;
			add(desired_amount,constraints);
			
			constraints.gridx = 0;
			constraints.gridy = 1;
			add(accounts_box,constraints);
			
			constraints.gridx = 1;
			constraints.gridy = 1;
			add(desired_account,constraints);
			
			constraints.gridx = 0;
			constraints.gridy = 0;
			add(makeWithdrawButton,constraints);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();

		if (buttonPressed.equals(makeWithdrawButton)){
			System.out.println("Attempting Withdraw!");
			withdraw = true;
			
		}
	}
	
	public void addToAccountBox(String acct){
		accounts_box.addItem(acct);
	}
	
	public boolean getWithdraw(){
		return withdraw;
	}
	
	public void setWithdrawFalse(){
		withdraw = false;
	}
	
	public String getSelectedAccount(){
		return String.valueOf(accounts_box.getSelectedItem());
	}
	
	public String getWithdrawAmount(){
		return amount.getText();
	}
	
	public void setWithdrawClear(){
		amount.setText("");
		accounts_box.setSelectedIndex(0);
		accounts_box.removeAllItems();
		accounts_box.addItem("-select account-");
	}
}