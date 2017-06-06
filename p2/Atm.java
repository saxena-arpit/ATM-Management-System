import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;

////////////////////////////////////////////////////////////////////////////////
//					Class Admin Used for Easier Sorting						  //
////////////////////////////////////////////////////////////////////////////////

class Admin{
private String Customer_Name;
private String Customer_ID;
private String Account_ID;
private String PIN;
private double balance;
private boolean active;
static int number;



	public Admin(String Customer_Name, String Customer_ID, String Account_ID, String PIN, double balance, boolean active){
		this.Customer_Name = Customer_Name;
		this.Customer_ID = Customer_ID;
		this.Account_ID = Account_ID;
		this.PIN = PIN;
		this.balance = balance;
		this.active = active;
	}

	public String info(){
		double rounded;
		rounded = round(this.balance, 2);

		return (this.Customer_Name + "\t\t" + this.Customer_ID + "\t" + this.Account_ID + "\t" + this.PIN + "          $" + rounded);
	}

	public double getBalance(){
		return balance;
	}

	public boolean getActive(){
			return active;
	}

	public static double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public double getAccount_ID(){
		double dbl_Account_ID = Double.parseDouble(this.Account_ID);
		return dbl_Account_ID;
		
	}
}

////////////////////////////////////////////////////////////////////////////////
//						Persistent ATM Class						 		  //
////////////////////////////////////////////////////////////////////////////////

public class Atm {

	private ArrayList<Customer> cust = new ArrayList<Customer>();
	private ArrayList<Logfile> logfile = new ArrayList<Logfile>();
	
	private int starting_account_number;
	private int starting_customer_number;
	private int total_logs;
	
	File file = new File("p2.dat");
	File log = new File("p2log.dat");

	// This Method is a Simple Check To Whether A String is Numeric or Not
	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	public Atm() {//constructor
		
		cust = new ArrayList<>(100);
		logfile = new ArrayList<>(100);
		
		int i = 0;
		int j = 0;
		int k = 0;
		int l = 0;
		this.readFromFile();
		this.readFromLog();
		for (Logfile m : logfile){
			l += 1;
			//System.out.println(l);
		}
		//System.out.println(l);
		for (Customer e : cust) {
		
			i += 1;
			j = j + e.getAccountNum();
			k = totalTransactions();
		}
			
		starting_account_number =  1001 + j;
	    starting_customer_number = 101 + i;
	    total_logs = l;
	    Customer.total_customers = i;
	    Customer.total_accounts = j;
	    Customer.total_transactions = k;
	}
	


//This Method Creates a New Customer Object and Adds it to The Array List
	public void create_customer(String NAME, String PIN){
		int array = starting_customer_number - 101;
		String ID;
			
		//Generate a customer ID
		ID = String.valueOf(starting_customer_number);
		
		//Add new customer to array list
		Customer new_cust = new Customer(NAME, ID, PIN);
		System.out.println("\n**Customer Created**");
		new_cust.info();
		
				
		starting_customer_number += 1;

		cust.add(array, new_cust);
		System.out.println("Total Transactions " + Customer.total_transactions);
		this.writeToFile();

		
	}
	
	public int login(String ID, String PIN) {

		int n = 0; // This will represent the location in the arrayList the cust is found at

		for (Customer c : cust) {
			// DEBUG System.out.println(n);
			n++;
			if (ID.equals(c.getId())) {
				if (PIN.equals(c.getPin())) {
					System.out.println("PIN Validated");
					return n - 1;
				} else {
					System.out.println("Incorrect PIN!");
					return -1;
				}

			}
		}
		System.out.println("Customer Does not Exist!");
		return -1;
	}
	// This Method Creates a New Account Object For a Customer and Adds it to
	// The Corresponding ArrayList
	public int open_account(String ID, String type) {
		String account_type = "";
		String acct = type;
		int n = 0;
		
		for (Customer c: cust){
			if (ID.equals(c.getId())){
				break;
			}
			n++;
			
		}

		if (acct.equals("c")) {
			cust.get(n).addAccountChecking(starting_account_number);
			
			starting_account_number += 1;
			cust.get(n).addTransaction();
			Customer.total_transactions = totalTransactions();
			if (Customer.total_transactions % 5 == 0) {
				System.out.println("\nAdding interest to savings accounts!");
				for (Customer c: cust){
					for (int i = 0; i < c.getAccountNum(); i++){
						if(c.getAccountArray(i).getType()){
							double new_amount = c.getAccountArray(i).getBalance();
							System.out.println(new_amount);
							new_amount = new_amount * 5/100;
							System.out.println(new_amount);
							String str_new_amount = String.valueOf(new_amount);
							String account_num = c.getAccountArray(i).getNumber();
							addTimeStampInterest(c.getId(), account_num, str_new_amount);
							addLog();
						}
					}
				}
				this.addInterest();
			}
			System.out.println(Customer.total_transactions);
			this.writeToFile();
			cust.get(n).getTotal();
			return starting_account_number - 1;
			
		} else if (acct.equals("s")) {
			cust.get(n).addAccountSaving(starting_account_number);
			System.out.println("Interest Rate is set to: 5%");
			starting_account_number += 1;
			cust.get(n).addTransaction();
			Customer.total_transactions = totalTransactions();
			if (Customer.total_transactions % 5 == 0) {
				System.out.println("\nAdding interest to savings accounts!");
				for (Customer c: cust){
					for (int i = 0; i < c.getAccountNum(); i++){
						if(c.getAccountArray(i).getType()){
							double new_amount = c.getAccountArray(i).getBalance();
							System.out.println(new_amount);
							new_amount = new_amount * 5/100;
							System.out.println(new_amount);
							String str_new_amount = String.valueOf(new_amount);
							String account_num = c.getAccountArray(i).getNumber();
							addTimeStampInterest(c.getId(), account_num, str_new_amount);
							addLog();
						}
					}
				}
				this.addInterest();
			}
			System.out.println("Total Transactions " + Customer.total_transactions);
			this.writeToFile();
			cust.get(n).getTotal();
			return starting_account_number - 1;
		} else {
			System.out.println("\nThat is not a type of account!");
			return 0;

		}

	}
	void deposit(String ID, String account, String deposit){
		int n = 0;
		int Id = 0;
		
		for (Customer c: cust){
			n++;
			if (ID.equals(c.getId())){
				Id = n - 1;
				break;
			}
		}

		if (isNumeric(account)){

			if(isNumeric(deposit)){
				cust.get(Id).validateAccount(account, deposit);
				
				//Debug to keep track of transactions
				//System.out.println(Customer.total_transactions);
				if(Customer.total_transactions %5 == 0){
					System.out.println("\nAdding interest to savings accounts!");
					for (Customer c: cust){
						for (int i = 0; i < c.getAccountNum(); i++){
							if(c.getAccountArray(i).getType()){
								double new_amount = c.getAccountArray(i).getBalance();
								System.out.println(new_amount);
								new_amount = new_amount * 5/100;
								System.out.println(new_amount);
								String account_num = c.getAccountArray(i).getNumber();
								String str_new_amount = String.valueOf(new_amount);
								addTimeStampInterest(c.getId(), account_num, str_new_amount);
								addLog();
							}
						}
					}
					this.addInterest();
				}
				
			}else{
				System.out.println("\nDeposit Amounts Must Be Numeric!");
			}
		}else{
			System.out.println("\nAccounts Must Be Numeric!");
		}
		
		this.writeToFile();
//		this.writeToLog();
		
	}
	
	public void withdraw(String ID, String account, String withdraw){
		int n = 0;
		int Id = 0;
		
		for (Customer c: cust){
			n++;
			if (ID.equals(c.getId())){
				Id = n - 1;
				break;
			}
		}

		if (isNumeric(account) ){

			if(isNumeric(withdraw)){
				
				cust.get(Id).validateAccountWithdraw(account, withdraw);
				System.out.println(Customer.total_transactions);
				if(Customer.total_transactions %5 == 0){
					System.out.println("\nAdding interest to savings accounts!");
					for (Customer c: cust){
						for (int i = 0; i < c.getAccountNum(); i++){
							if(c.getAccountArray(i).getType()){
								double new_amount = c.getAccountArray(i).getBalance();
								System.out.println(new_amount);
								new_amount = new_amount * 5/100;
								System.out.println(new_amount);
								String account_num = c.getAccountArray(i).getNumber();
								String str_new_amount = String.valueOf(new_amount);
								addTimeStampInterest(c.getId(), account_num, str_new_amount);
								addLog();
							}
						}
					}
					this.addInterest();
				}
			}else{
				System.out.println("\nWithdraw Amounts Must Be Numeric!");
			}
						
		}else{
			System.out.println("\nAccounts Must Be Numeric!");
		}
		this.writeToFile();


	}
	
// This Method Loops Through All the Customers and Adds Interest to Their Savings Accounts
	public void addInterest() {

		for (Customer e : cust) {
			e.addInterest();
		}

	}
	
	public int totalTransactions() {
		int i = 0;
		for (Customer c : cust) {
			i = i + c.getTransactions();
		}
		return i;
	}
	
	public void setSelection(SelectionFrame frame, String ID){
		for (Customer c : cust) {
			if(ID.equals(c.getId())){
				frame.setName(c.getName());
			}
		}
	}

	public Customer getCustomerArray(int i) {
		return this.cust.get(i);
	}
	
	public double getBalance(String ID, String account){
		for (Customer c : cust){
			if(ID.equals(c.getId())){
				return c.getBalance(account);
			}
		}
		
		return 0;
	}
	
	public void close_account(String ID, String account) {

		int Id = Integer.parseInt(ID) - 101;
		
		cust.get(Id).closeAccount(account);
		cust.get(Id).addTransaction();
		Customer.total_transactions = totalTransactions();
		if (Customer.total_transactions % 5 == 0) {
			System.out.println("\nAdding interest to savings accounts!");
			
			for (Customer c: cust){
				for (int i = 0; i < c.getAccountNum(); i++){
					if(c.getAccountArray(i).getType()){
						double new_amount = c.getAccountArray(i).getBalance();
						System.out.println(new_amount);
						new_amount = new_amount * 5/100;
						System.out.println(new_amount);
						String account_num = c.getAccountArray(i).getNumber();
						String str_new_amount = String.valueOf(new_amount);
						addTimeStampInterest(c.getId(), account_num, str_new_amount);
						addLog();
					}
				}
			}
			
			this.addInterest();
			
		}
		System.out.println("Total Transactions " + Customer.total_transactions);
		this.writeToFile();
		this.writeToLog();

	}
	
	public void readFromFile() {
		try {

			FileInputStream fi = new FileInputStream(file);
			ObjectInputStream input = new ObjectInputStream(fi);

			try {
				while (true) {
					Customer s = (Customer) input.readObject();
					cust.add(s);
					

				}

			} catch (EOFException ex) {

			}

		} catch (FileNotFoundException g) {
			System.out.println("File Not Found Creating p2.dat file");
			try {
				file.createNewFile();
			} catch (IOException t) {
				t.printStackTrace();
			}

		} catch (IOException h) {
			h.printStackTrace();
		} catch (ClassNotFoundException f) {
			f.printStackTrace();
		}
	}

	public void writeToFile() {
		try {
			FileOutputStream fo = new FileOutputStream(file);
			ObjectOutputStream output = new ObjectOutputStream(fo);
			// DEBUG
			// System.out.println("\nwriting");

			for (Customer s : cust) {
				output.writeObject(s);
			}
			

			// Close the output stream and file
			output.close();
			fo.close();

			// Catch exceptions
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	public void addTimeStampDeposit(String new_transaction_ID, String new_customer_ID, String new_account_number, String new_amount){
		int array = total_logs;
		Logfile new_logfile = new Logfile(new_transaction_ID, new_customer_ID, new_account_number, new_amount, "+");		
		
		logfile.add(array, new_logfile);
		//total_logs += 1;
	}
	
	public void addTimeStampWithdraw(String new_transaction_ID, String new_customer_ID, String new_account_number, String new_amount){
		int array = total_logs;
		Logfile new_logfile = new Logfile(new_transaction_ID, new_customer_ID, new_account_number, new_amount, "-");		
		
		logfile.add(array, new_logfile);
		//total_logs += 1;
	}
	
	public void addTimeStampInterest(String new_customer_ID, String new_account_number, String new_amount){
		int array = total_logs;
		Logfile new_logfile = new Logfile("int(0)", new_customer_ID, new_account_number, new_amount, "+");		
		
		logfile.add(array, new_logfile);
		//total_logs += 1;
	}
	
	public void printTimeStampArray(){
		for (Logfile l: logfile){
			l.printTimeStampArray();
		}
	}
	
	public String getTimeStampArray(int i){
		return logfile.get(i).printTimeStampArray();
	}
	
	public int getLogNumber(){
		return total_logs;
	}
	
	public void addLog(){
		total_logs += 1;
	}
	
	public String getLogID(int i){
		return logfile.get(i).getID();
	}
	

	public void readFromLog() {
		try {

			FileInputStream fin = new FileInputStream(log);
			ObjectInputStream input = new ObjectInputStream(fin);

			try {
				while (true) {
					Logfile s = (Logfile) input.readObject();
					logfile.add(s);
					

				}

			} catch (EOFException ex) {

			}

		} catch (FileNotFoundException g) {
			System.out.println("File Not Found Creating p2log.dat file");
			try {
				file.createNewFile();
			} catch (IOException t) {
				t.printStackTrace();
			}

		} catch (IOException h) {
			h.printStackTrace();
		} catch (ClassNotFoundException f) {
			f.printStackTrace();
		}
	}
	
	public void writeToLog() {
		try {
			FileOutputStream fout = new FileOutputStream(log);
			ObjectOutputStream output = new ObjectOutputStream(fout);
			// DEBUG
			// System.out.println("\nwriting");

			for (Logfile s : logfile) {
				output.writeObject(s);
			}
			

			// Close the output stream and file
			output.close();
			fout.close();

			// Catch exceptions
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	public void adminNames(){
		Collections.sort(cust, new CustomerNameComparator());
		
		double rounded;
		double balance = 0;	
		String ID = "";
		System.out.println("[Customer Name]\t\t[Customer ID]\t\t[Account ID]\t\t[Pin #]\t\t[Current Balance]");
		for (Customer c: cust) {
			for (int i = 0; i < c.getAccountNum(); i++){
				
				balance = c.getAccountArrayList().get(i).getBalance();
				rounded = round(balance, 2);
				ID = c.getAccountArrayList().get(i).getNumber();
				
				if(c.getAccountArrayList().get(i).getActive()){
					System.out.println(c.getName() + "\t\t\t" + c.getId() + "\t\t\t" + ID + "\t\t\t"+ c.getPin() + "\t\t$" + rounded);
				}
				
			}
		
		}
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public ArrayList <Admin> adminBalance(){
		
		int p = 0;
		int l = 0;
		Admin temp;

//Builds up an Array List of Admin Objects to Be Sorted and Printed
		
		ArrayList<Admin>new_admin = new ArrayList<Admin>();
		new_admin.clear();
		System.out.println("[Customer Name]\t\t[Customer ID]\t\t[Account ID]\t\t[Pin #]\t\t[Current Balance]");
		Admin.number = 0;
		
		for (Customer c: cust){
			for (int i = 0; i < c.getAccountNum(); i++){
				
				String Customer_Name = c.getName();
				String Customer_ID = c.getId();
				String Account_ID = c.getAccountArray(i).getNumber();
				String PIN = c.getPin();
				double balance = c.getAccountArray(i).getBalance();
				boolean active = c.getAccountArray(i).getActive();
				
				new_admin.add(new Admin(Customer_Name, Customer_ID, Account_ID, PIN, balance,active));
				Admin.number++;
				p++;
			}
		}
		
//Sorts the Array List for Balance Highest to Lowest
		
		for (int j = (p - 1); j >= 0; j--){
			for (int i = 0; i < (p - 1); i++){
				l = i + 1;
				if(new_admin.get(i).getBalance() < new_admin.get(l).getBalance()){
					
					Collections.swap(new_admin,i,l);
					
				}
			}
		}	
		return new_admin;
	}

	//This Method Prints a List of A Single Customers Accounts w/ Info Sorted by Account Number
		public ArrayList <Admin> adminCustomer(String ID){
			ArrayList<Admin>new_admin = new ArrayList<Admin>();
			Admin.number = 0;
			boolean found = false;
			int n = 0;
			int p = 0;
			int l = 0;

			for (Customer c: cust){				
				if(ID.equals(c.getId())){
					found = true;
					break;
				}
				n++;				
			}
			
			if (!found){
				System.out.println("Customer Not Found");
				
				
			}else{
				System.out.println(n);
				System.out.println("[Name]\t\t[Cust ID]\t[Acct ID]\t[Pin #]\t\t[Balance]");
				for (int i = 0; i < cust.get(n).getAccountNum(); i++){
					String Customer_Name = cust.get(n).getName();
					String Customer_ID = cust.get(n).getId();
					String Account_ID = cust.get(n).getAccountArray(i).getNumber();
					String PIN = cust.get(n).getPin();
					double balance = cust.get(n).getAccountArray(i).getBalance();
					boolean active = cust.get(n).getAccountArray(i).getActive();
					new_admin.add(new Admin(Customer_Name, Customer_ID, Account_ID, PIN, balance,active));
					Admin.number++;
					p++;
					
				}
				
				for (int j = (p - 1); j >= 0; j--){
					for (int i = 0; i < (p - 1); i++){
						l = i + 1;
						if(new_admin.get(i).getAccount_ID() > new_admin.get(l).getAccount_ID()){
							
							Collections.swap(new_admin,i,l);
							
						}
					}
				}
				
			}
			return new_admin;
		}

}