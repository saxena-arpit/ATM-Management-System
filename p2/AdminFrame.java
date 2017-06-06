import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class AdminFrame extends JFrame{
		
		private AdminPanel adminPanel;



		
		public AdminFrame(){
			
			
			
			super("Administrative Tools");
			setSize(630, 300);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			adminPanel = new AdminPanel();
			this.setLocation(500, 500);
			add(adminPanel);
		
		}
		
		public void setPanel(){
			adminPanel.setPanel();
		}
		
		public void addToAccountBox(String acct){
			adminPanel.addToAccountBox(acct);
		}
		
		public boolean getExit(){
			return adminPanel.getExit();
		}
		
		public void setExitFalse(){
			adminPanel.setExitFalse();
		}
		
		public void clearDisplay(){
			adminPanel.clearDisplay();
		}
		
		public boolean getTransactionLog(){
			return adminPanel.getTransactionLog();
		}
		
		public void setTransactionLogFalse(){
			adminPanel.setTransactionLogFalse();
		}
		
		public void addToDisplay(String info){
			adminPanel.addToDisplay(info);
		}
		
		public boolean getAlphabetical(){
			return adminPanel.getAlphabetical();
		}
		
		public void setAlphabeticalFalse(){
			adminPanel.setAlphabeticalFalse();
		}
		
		public boolean getHighestBalance(){
			return adminPanel.getHighestBalance();
		}
		
		public void setHighestBalanceFalse(){
			adminPanel.setHighestBalanceFalse();
		}
		
		public boolean getSingleCust(){
			return adminPanel.getSingleCust();
		}
		
		public void setSingleCustFalse(){
			adminPanel.setSingleCustFalse();
		}
		
		public String getSelectCustomer(){
			return adminPanel.getSelectCustomer();
		}
		
}