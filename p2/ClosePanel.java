import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ClosePanel extends JPanel implements ActionListener{

	private boolean close = false;	

	private JLabel desired_account;	
	private JComboBox accounts_box = new JComboBox();	
	private JButton closeButton;	
	
	public ClosePanel(){
			
			GridBagConstraints constraints = new GridBagConstraints();
		    constraints.anchor = GridBagConstraints.WEST;
		    
		    desired_account = new JLabel ("                   Desired Account  ");
		    
		    accounts_box = new JComboBox();
		    accounts_box.addItem("-select account-");
		    		
		    closeButton = new JButton		("Close Account");
		    		    
		    closeButton.addActionListener(this);
		    
			constraints.gridx = 0;
			constraints.gridy = 2;
			add(accounts_box,constraints);
			
			constraints.gridx = 1;
			constraints.gridy = 2;
			add(desired_account,constraints);
			
			constraints.gridx = 0;
			constraints.gridy = 0;
			add(closeButton,constraints);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();

		if (buttonPressed.equals(closeButton)){
			System.out.println("Closing Account!");
			close = true;
			
		}
	}
	
	public void addToAccountBox(String acct){
		accounts_box.addItem(acct);
	}
	public boolean getClose(){
		return close;
	}
	
	public void setCloseFalse(){
		close = false;
	}	
	
	public String getCloseAccount(){
		return String.valueOf(accounts_box.getSelectedItem());
	}
	
	public void setCloseClear(){
		accounts_box.setSelectedIndex(0);
		accounts_box.removeAllItems();
		accounts_box.addItem("-select account-");
	}
/*	public boolean getDeposit(){
		return deposit;
	}
	
	public void setDepositFalse(){
		deposit = false;
	}
	
	public String getSelectedAccount(){
		return String.valueOf(accounts_box.getSelectedItem());
	}
	
	public String getDepositAmount(){
		return amount.getText();
	}
	
	public void setDepositClear(){
		amount.setText("");
		accounts_box.setSelectedIndex(0);
	}
	*/
}