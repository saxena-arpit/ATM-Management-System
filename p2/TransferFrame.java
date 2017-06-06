import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;

import javax.swing.JFrame;


public class TransferFrame extends JFrame{

	private TransferPanel transferPanel;
	
	public TransferFrame(){
		super("Make A Transfer");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		transferPanel = new TransferPanel();
		this.setLocation(500, 500);
		add(transferPanel);
	}
	
	public void addToAccountWithdrawBox(String acct){
		transferPanel.addToAccountWithdrawBox(acct);
	}

	public void addToAccountDepositBox(String acct){
		transferPanel.addToAccountDepositBox(acct);
	}
	
	public boolean getTransfer(){
		return transferPanel.getTransfer();
	}
	
	public void setTransferFalse(){
		transferPanel.setTransferFalse();
	}
	
	public String getDepositAccount(){
		return transferPanel.getDepositAccount();
	}
	
	public String getDepositAmount(){
		return transferPanel.getDepositAmount();
	}

	public String getWithdrawAccount(){
		return transferPanel.getWithdrawAccount();
	}
	
	public String getWithdrawAmount(){
		return transferPanel.getWithdrawAmount();
	}
	
	public void setTransferClear(){
		transferPanel.setTransferClear();
	}
	
}