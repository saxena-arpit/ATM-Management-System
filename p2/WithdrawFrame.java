import javax.swing.JFrame;

public class WithdrawFrame extends JFrame{

	private WithdrawPanel withdrawPanel;
	
	public WithdrawFrame(){
		super("Make A Withdrawal");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		withdrawPanel = new WithdrawPanel();
		this.setLocation(500, 500);
		add(withdrawPanel);
	}
	
	public void addToAccountBox(String acct){
		withdrawPanel.addToAccountBox(acct);
	}
	
	public boolean getWithdraw(){
		return withdrawPanel.getWithdraw();
	}
	
	public void setWithdrawFalse(){
		withdrawPanel.setWithdrawFalse();
	}
	
	public String getSelectedAccount(){
		return withdrawPanel.getSelectedAccount();
	}
	
	public String getWithdrawAmount(){
		return withdrawPanel.getWithdrawAmount();
	}
	
	public void setWithdrawClear(){
		withdrawPanel.setWithdrawClear();
	}
	

}