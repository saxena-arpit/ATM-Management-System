import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import javax.swing.JFrame;


public class AddAccountFrame extends JFrame{

	private AddAccountPanel addAccountPanel;
	
	public AddAccountFrame(){
		super("Select the Account Type");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addAccountPanel = new AddAccountPanel();
		this.setLocation(500, 500);
		add(addAccountPanel);
	}
	
	public boolean getSavings(){
		return addAccountPanel.getSavings();
	}
	
	public void setSavingsFalse(){
		addAccountPanel.setSavingsFalse();
	}
	
	public boolean getChecking(){
		return addAccountPanel.getChecking();
	}
	
	public void setCheckingFalse(){
		addAccountPanel.setCheckingFalse();
	}
}