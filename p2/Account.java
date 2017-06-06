public class Account implements java.io.Serializable {

	private String number; // 4 digit string
	private double balance;
	private boolean active;
	private int array_number;
	private boolean type;
	int interest = 5;

	public Account(int Account_Number, int total_accounts) {
		String Accnt_Num = String.valueOf(Account_Number);
		this.number = Accnt_Num;
		this.balance = 0;
		this.active = true;
		this.array_number = total_accounts;

	}
	
//This Method Just Prints Out Account Info and returns the Array Number
	int info(){
		
		System.out.println("Account number: " + this.number);
		System.out.println("Account balance: " + this.balance);
		System.out.println("Active?: " + this.active);
		//System.out.println("array number: " + this.array_number);
		return this.array_number;
	}
	
//This Method Updates the Deposit Balance for This Account
	void addDeposit(double deposit){
		System.out.println("\n**Account balance updated**");
		this.balance = this.balance + deposit;
		this.info();
	}

//This Method Updates the Withdraw Balance for This Account
	void subWithdraw(double withdraw){
		
		if (withdraw > this.balance){
			System.out.println("\nInsufficient Funds!");
		}else{
			System.out.println("\n**Account balance updated**");
			this.balance = this.balance - withdraw;
			this.info();
		}
	}
//This Method Adds To the Balance (Every 5 transactions) The Interest Rate for All Savings Accounts	
		void addInterest(){
			this.balance = this.balance + this.balance * this.interest/100;
		}

////////////////////////////////////////////////////////////////////////////////
// 						Simple Getters and Setters 							  //
////////////////////////////////////////////////////////////////////////////////

	int getArray() {
		return array_number;
	}

	String getNumber() {
		return this.number;

	}

	public double getBalance() {

		return this.balance;

	}

	boolean getType() {
		return type;
	}

	void setTypeSavings() {
		this.type = true;
	}

	void setTypeChecking() {
		this.type = false;
	}

	void setActiveFalse() {

		this.active = false;
		this.balance = 0;
	}

	boolean getActive() {
		return this.active;
	}

}