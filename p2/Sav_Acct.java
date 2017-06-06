public class Sav_Acct extends Account implements java.io.Serializable{
	private double interest_rate;
	
	public Sav_Acct(int Account_Number, int total_accounts){
		
		super(Account_Number, total_accounts);
			interest_rate = 5;
		
			

		
		
	}
	
	void getInterest(){
		System.out.println("Interest Rate: " + interest_rate);
		
	}
	

	

}