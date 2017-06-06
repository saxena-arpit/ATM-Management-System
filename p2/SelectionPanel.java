import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SelectionPanel extends JPanel implements ActionListener{
	
	private static boolean AddAccount = false;
	private boolean deposit = false;
	private boolean withdraw = false;
	private boolean transfer = false;
	private boolean close = false;
	private boolean info = false;
	private boolean exit = false;
	
	private String name = " ";
	
	
	private JTextArea report = new JTextArea(10,25);
	

	
	private JLabel welcome;
	private JButton openButton;
	private JButton depositButton;
	private JButton withdrawButton;
	private JButton transferButton;
	private JButton accountinfoButton;
	private JButton closeaccountButton;
	private JButton	exitButton;
	
	public SelectionPanel(){
		
		GridBagConstraints constraints = new GridBagConstraints();
	    constraints.anchor = GridBagConstraints.NORTHWEST;

	    welcome = new JLabel("Welcome, " + name + " Please Make a Selection                                     ");
	    
		openButton = new JButton		("Open Account");
		depositButton = new JButton		("       Deposit     ");
		withdrawButton = new JButton	("    Withdraw    ");
		transferButton = new JButton	("     Transfer     ");
		accountinfoButton = new JButton	("  Account Info ");
		closeaccountButton = new JButton("Close Account");
		exitButton = new JButton("        Exit ATM        ");
		

		
		openButton.addActionListener(this);
		depositButton.addActionListener(this);
		withdrawButton.addActionListener(this);
		transferButton.addActionListener(this);
		closeaccountButton.addActionListener(this);
		accountinfoButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		
		constraints.gridx = 0;
		constraints.gridy = 4;
		add(welcome,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		add(openButton,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 3;
		add(depositButton,constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 3;
		add(withdrawButton,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		add(transferButton,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 2;
		add(accountinfoButton,constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 2;
		add(closeaccountButton,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		add(exitButton,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 0;		
		add(report, constraints);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();

		if (buttonPressed.equals(openButton)){
			System.out.println("Opening Account");
			AddAccount = true;
			LoginPanel.setLoginFalse();
		}
		
		else if (buttonPressed.equals(withdrawButton)){
			System.out.println("withdrawing funds");
			withdraw = true;
		}
		
		
		else if (buttonPressed.equals(depositButton)){
			System.out.println("Opening Account");
			deposit = true;
			
		}
		
		else if (buttonPressed.equals(closeaccountButton)){
			System.out.println("Closing Account");
			close = true;
			
		}
		
		else if (buttonPressed.equals(transferButton)){
			System.out.println("transfering funds");
			transfer = true;
		}
		
		else if (buttonPressed.equals(accountinfoButton)){
			System.out.println("Getting Info");
			info = true;
		}
		
		else if (buttonPressed.equals(exitButton)){
			System.out.println("Thank You!");
			exit = true;
		}
		
	}
	
	public boolean getAddAccount(){
		
		return AddAccount;
	}
	
	public void setAddAccountFalse(){
		AddAccount = false;
	}
	
	public boolean getDeposit(){
		return deposit;
	}
	
	public void setDepositFalse(){
		deposit = false;
	}
	
	public boolean getWithdraw(){
		return withdraw;
	}
	
	public void setWithdrawFalse(){
		withdraw = false;
	}
	
	public boolean getTransfer(){
		return transfer;
	}
	
	public void setTransferFalse(){
		transfer = false;
	}
	
	public boolean getClose(){
		return close;
	}
	
	public void setCloseFalse(){
		close = false;
	}
	
	public boolean getInfo(){
		return info;
	}
	
	public void setInfoFalse(){
		info = false;
	}
	
	public boolean getExit(){
		return exit;
	}
	
	public void setExitFalse(){
		exit = false;
	}

	public void setName(String n){
		name = n;
		welcome.setText("Welcome, " + name + " Please Make a Selection                                     ");
		
	}
	
	public String getName(){
		return name;
	}
	
	public void setSavingsAccountAdded(int account_number){
		report.setText("\n               **Savings Account Created**\n                  Account Number: " + account_number + "\n                  Account Balance: 0.0\n                  Active?: true\n                  Interest Rate: 5%");
	}
	
	public void setCheckingAccountAdded(int account_number){
		report.setText("\n               **Checking Account Created**\n                  Account Number: " + account_number + "\n                  Account Balance: 0.0\n                  Active?: true");
	}
	
	public void setDepositReport(String account_number, double account_balance){
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String dollar_account_balance = formatter.format(account_balance);
		report.setText("\n               **Account Balance Updated**\n                  Account Number: " + account_number + "\n                  Account Balance: " + dollar_account_balance+ "\n");
	}
	
	public void setDepositReportNoSelect(){
		report.setText("\n               **No Account Selected**\n");
	}
	
	public void setDepositReportNotANumber(){
		report.setText("\n               **Not an amount number!**\n");
	}
	
	public void setWithdrawReport(String account_number, double account_balance){
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String dollar_account_balance = formatter.format(account_balance);
		report.setText("\n               **Account Balance Updated**\n                  Account Number: " + account_number + "\n                  Account Balance: " + dollar_account_balance+ "\n");
	}
	public void setWithdrawReportNoSelect(){
		report.setText("\n               **No Account Selected**\n");
	}
	
	public void setWithdrawReportInsufficientFunds(){
		report.setText("\n               **Insufficient Funds!**\n");
	}
	
	public void setWithdrawReportNotANumber(){
		report.setText("\n               **Not an amount number!**\n");
	}
	
	public void setTransferReportNoSelect(){
		report.setText("\n       **Must Select To AND From Accounts**\n");
	}
	
	public void setTransferReport(String withdraw_account_number, double withdraw_account_balance, String deposit_account_number, double deposit_account_balance){
		report.setText("\n     **Account Balances Updated**\nFrom Account:\nAccount Number: " + withdraw_account_number + "\nAccount Balance: " + withdraw_account_balance+ "\n\nTo Account:\nAccount Number: " + deposit_account_number  + "\nAccount Balance: " + deposit_account_balance + "\n");//                  				To Account:\n				 Account Number: " + deposit_account_number + "\n                  Account Balance: " + deposit_account_balance + "\n");
	}
	
	public void setTransferReportInsufficientFunds(){
		report.setText("\n               **Insufficient Funds!**\n");
	}
	
	public void setTransferReportNotANumber(){
		report.setText("\n               **Not an amount number!**\n");
	}
	
	public void setCloseReportNoSelect(){
		report.setText("\n               **No Account Selected**\n");
	}
	
	public void setCloseReport(String account_number){
		report.setText("\n               **Account Closed**\nAccount Number: " + account_number + "\nAccount Balance: 0.0\nActive?: false");
	}
	
	public void setClear(){
		report.setText("");
	}
}