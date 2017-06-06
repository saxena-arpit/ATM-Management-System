import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LoginFrame extends JFrame {
	
	private LoginPanel loginPanel;

	private static boolean login;

	
	public LoginFrame(){ // Mainframe Constructor
		
	
		
		super("Please Login ...");
		setSize(320, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loginPanel = new LoginPanel();
		
		this.setLocation(500, 500);
		add(loginPanel);

		loginPanel.setVisible(true);

	
	}

	public static boolean isNumeric(String str)  {  
		  try  {  
			  double d = Double.parseDouble(str);  
		  }  
		  catch(NumberFormatException nfe)  {  
		    return false;  
		  }  
		  return true;  
		}
	
	public String getID(){
		return loginPanel.getID();
	}
	public String getPIN(){
		return loginPanel.getPIN();
	}
	
	public void setIncorrect(){
		loginPanel.setIncorrect();
	}
	
	public void setClear(){
		loginPanel.setClear();
	}
	public void setAccountNumber(String ID){
		loginPanel.setAccountNumber(ID);;
	}
	

}