import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TransferPanel extends JPanel implements ActionListener{

	private boolean transfer = false;
//	private boolean checking = false;
	
	private JLabel desired_withdraw_amount;
	private JLabel desired_withdraw_account;
	private JLabel desired_deposit_amount;
	private JLabel desired_deposit_account;
		
	private JComboBox accounts_withdraw_box = new JComboBox();
	private JComboBox accounts_deposit_box = new JComboBox();
	
	private JButton makeTransferButton;
	
	private JTextField amount_withdraw;
	private JTextField amount_deposit;
	
	public TransferPanel(){
			
			GridBagConstraints constraints = new GridBagConstraints();
		    constraints.anchor = GridBagConstraints.WEST;
		    
		    desired_withdraw_amount = new JLabel ("Desired From Amount");
		    desired_withdraw_account = new JLabel ("                Desired From Account  ");
		    
		    desired_deposit_amount = new JLabel ("   Desired To Amount");
		    desired_deposit_account = new JLabel ("                    Desired To Account  ");
		    
		    accounts_withdraw_box = new JComboBox();
		    accounts_withdraw_box.addItem("-select account-");
		    
		    accounts_deposit_box = new JComboBox();
		    accounts_deposit_box.addItem("-select account-");
		    		
		    makeTransferButton = new JButton		("Make Transfer");
		    
		    amount_withdraw = new JTextField(15);
		    amount_deposit = new JTextField(15);
		    
		    makeTransferButton.addActionListener(this);
		    
			constraints.gridx = 0;
			constraints.gridy = 4;
			add(amount_withdraw,constraints);
			
			constraints.gridx = 1;
			constraints.gridy = 4;
			add(desired_withdraw_amount,constraints);

			constraints.gridx = 0;
			constraints.gridy = 3;
			add(accounts_withdraw_box,constraints);
			
			constraints.gridx = 0;
			constraints.gridy = 3;
			add(desired_withdraw_account,constraints);
/*	
			constraints.gridx = 0;
			constraints.gridy = 2;
			add(amount_deposit,constraints);
			constraints.gridx = 1;
			constraints.gridy = 2;
			add(desired_deposit_amount,constraints);
*/
			constraints.gridx = 0;
			constraints.gridy = 1;
			add(accounts_deposit_box,constraints);
			
			constraints.gridx = 1;
			constraints.gridy = 1;
			add(desired_deposit_account,constraints);			
		
			constraints.gridx = 0;
			constraints.gridy = 0;
			add(makeTransferButton,constraints);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();

		if (buttonPressed.equals(makeTransferButton)){
			System.out.println("Making Transfer!");
			transfer = true;
			
		}
	}
	
	public void addToAccountWithdrawBox(String acct){
		accounts_withdraw_box.addItem(acct);
	}
	
	public void addToAccountDepositBox(String acct){
		accounts_deposit_box.addItem(acct);
	}
	
	public boolean getTransfer(){
		return transfer;
	}
	
	public void setTransferFalse(){
		transfer = false;
	}
	
	public String getDepositAccount(){
		return String.valueOf(accounts_deposit_box.getSelectedItem());
	}
	
	public String getDepositAmount(){
		return amount_deposit.getText();
	}
	
	public String getWithdrawAccount(){
		return String.valueOf(accounts_withdraw_box.getSelectedItem());
	}
	
	public String getWithdrawAmount(){
		return amount_withdraw.getText();
	}
	
	public void setTransferClear(){
		amount_withdraw.setText("");
		amount_deposit.setText("");
		accounts_deposit_box.setSelectedIndex(0);
		accounts_withdraw_box.setSelectedIndex(0);		
		accounts_withdraw_box.removeAllItems();
		accounts_withdraw_box.addItem("-select account-");
		accounts_deposit_box.removeAllItems();
		accounts_deposit_box.addItem("-select account-");
	}
/*	
	public String getSelectedAccount(){
		return String.valueOf(accounts_box.getSelectedItem());
	}
	
	public String getDepositAmount(){
		return amount.getText();
	}
	
	public void setDepositClear(){
		amount.setText("");
		accounts_box.setSelectedIndex(0);
	}*/
}