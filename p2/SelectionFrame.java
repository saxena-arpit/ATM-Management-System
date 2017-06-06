import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class SelectionFrame extends JFrame{
		
		private SelectionPanel selectionPanel;
		private String selectID; 
		private String selectName;


		
		public SelectionFrame(){
			
			
			
			super("CS49J Banking System");
			setSize(400, 400);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			selectionPanel = new SelectionPanel();
			this.setLocation(500, 500);
			add(selectionPanel);
		
		}
		
		public void setName(String n){
			selectionPanel.setName(n);
		}
		
		public String getName(){
			return selectionPanel.getName();
		}
		
		public boolean getAddAccount(){
			return selectionPanel.getAddAccount();
		}
		
		public void setAddAccountFalse(){
			selectionPanel.setAddAccountFalse();
		}
		
		public boolean getDeposit(){
			return selectionPanel.getDeposit();
		}
		
		public void setDepositFalse(){
			selectionPanel.setDepositFalse();
		}
		
		public boolean getWithdraw(){
			return selectionPanel.getWithdraw();
		}
		
		public void setWithdrawFalse(){
			selectionPanel.setWithdrawFalse();
		}
		
		public boolean getTransfer(){
			return selectionPanel.getTransfer();
		}
		
		public void setTransferFalse(){
			selectionPanel.setTransferFalse();
		}		
		
		public boolean getClose(){
			return selectionPanel.getClose();
		}
		
		public void setCloseFalse(){
			selectionPanel.setCloseFalse();
		}
		
		public boolean getInfo(){
			return selectionPanel.getInfo();
		}
		
		public void setInfoFalse(){
			selectionPanel.setInfoFalse();
		}
		
		public boolean getExit(){
			return selectionPanel.getExit();
		}
		
		public void setExitFalse(){
			selectionPanel.setExitFalse();
		}
		
		public void setID(String ID){
			selectID = ID;
		}
		public String getID(){
			return selectID;
		}
		

		
		public void setSavingsAccountAdded(int account_number){
			selectionPanel.setSavingsAccountAdded(account_number);
		}

		public void setCheckingAccountAdded(int account_number){
			selectionPanel.setCheckingAccountAdded(account_number);
		}	
		
		public void setDepositReport(String account_number, double account_balance){
			selectionPanel.setDepositReport(account_number, account_balance);
		}
		
		public void setDepositReportNoSelect(){
			selectionPanel.setDepositReportNoSelect();
		}
		
		public void setDepositReportNotANumber(){
			selectionPanel.setDepositReportNotANumber();
		}
		
		public void setWithdrawReport(String account_number, double account_balance){
			selectionPanel.setWithdrawReport(account_number, account_balance);
		}
		
		public void setWithdrawReportNoSelect(){
			selectionPanel.setWithdrawReportNoSelect();
		}
		
		public void setWithdrawReportInsufficientFunds(){
			selectionPanel.setWithdrawReportInsufficientFunds();
		}
		
		public void setWithdrawReportNotANumber(){
			selectionPanel.setWithdrawReportNotANumber();
		}
		
		public void setTransferReportNoSelect(){
			selectionPanel.setTransferReportNoSelect();
		}
		
		public void setTransferReport(String withdraw_account_number, double withdraw_account_balance, String deposit_account_number, double deposit_account_balance){
			selectionPanel.setTransferReport(withdraw_account_number, withdraw_account_balance, deposit_account_number, deposit_account_balance);
		}
		
		public void setTransferReportInsufficientFunds(){
			selectionPanel.setTransferReportInsufficientFunds();
		}
		
		public void setTransferReportNotANumber(){
			selectionPanel.setWithdrawReportNotANumber();
		}
		
		public void setCloseReportNoSelect(){
			selectionPanel.setCloseReportNoSelect();
		}
		
		public void setCloseReport(String account_number){
			selectionPanel.setCloseReport(account_number);
		}
		public void setClear(){
			selectionPanel.setClear();
		}
}