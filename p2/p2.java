
import java.text.NumberFormat;
import java.util.ArrayList;

public class p2 {

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {

		final String ACTION_IDLE = "100"; 				//LOGIN FRAME
		final String ACTION_SELECT = "99";				//SELECTION FRAME
		final String ACTION_ADMIN = "0";				//ADMIN FRAME
		final String ACTION_CREATE = "1";				//REGISTER FRAME
		final String ACTION_OPEN = "2";					//ADD ACCOUNT FRAME
		final String ACTION_DEPOSIT = "3";				//DEPOSIT FRAME
		final String ACTION_WITHDRAW = "4";				//WITHDRAW FRAME
		final String ACTION_TRANSFER = "5";				//TRANSFER FRAME
		final String ACTION_ACCOUNT_INFO = "6";			
		final String ACTION_CLOSE = "7";				//CLOSE FRAME
		final String ACTION_EXIT = "9";

		String action = "0";
		
		String cust_ID = "";

		// Create the correct Classes
		Atm atm = new Atm();

		// Create the frames and panels
		LoginFrame loginFrame = new LoginFrame();
		SelectionFrame selectionFrame = new SelectionFrame();
		RegisterFrame registerFrame = new RegisterFrame();
		AddAccountFrame addAccountFrame = new AddAccountFrame();
		DepositFrame depositFrame = new DepositFrame();
		WithdrawFrame withdrawFrame = new WithdrawFrame();
		TransferFrame transferFrame = new TransferFrame();
		CloseFrame closeFrame = new CloseFrame();
		InfoFrame infoFrame = new InfoFrame();
		AdminFrame adminFrame = new AdminFrame();
		
		action = ACTION_IDLE;
		
		int account_number;
		boolean empty_deposit = true;
		boolean empty_withdraw = true;
		boolean empty_transfer = true;
		boolean empty_close = true;
		boolean empty_info = true;
		boolean empty_admin = true;
		
		
		while (true) {

			switch (action) {
			
			case ACTION_IDLE: {

//Display the LOGIN frame
				loginFrame.setVisible(true);
				selectionFrame.setVisible(false);
				registerFrame.setVisible(false);
				addAccountFrame.setVisible(false);
				depositFrame.setVisible(false);
				withdrawFrame.setVisible(false);
				closeFrame.setVisible(false);
				infoFrame.setVisible(false);
				adminFrame.setVisible(false);
				
				empty_admin = true;

	//LOGIN BUTTON IS CLICKED
				
				
				if (LoginPanel.getLogin()){
					if(loginFrame.getID().equals("abcd") && loginFrame.getPIN().equals("1234")){
						action = ACTION_ADMIN;
						LoginPanel.setLoginFalse();
					}
					
					if (atm.login(loginFrame.getID(), loginFrame.getPIN()) != -1) {
						selectionFrame.setID(loginFrame.getID());
						cust_ID = loginFrame.getID();
						selectionFrame.setClear();
						action = ACTION_SELECT;
						LoginPanel.setLoginFalse();
					}else{
						loginFrame.setIncorrect();
						LoginPanel.setLoginFalse();
					}

	//REGISTER BUTTON IS CLICKED					
				} if(LoginPanel.getRegister()) {
					
					action = ACTION_CREATE;
				}
				break;

			}

			case ACTION_SELECT: {
				
				empty_deposit = true; 
				empty_withdraw = true;
				empty_transfer = true;
				empty_close = true;
				empty_info = true;
				
//Display the SELECT frame
				atm.setSelection(selectionFrame, loginFrame.getID());
				loginFrame.setVisible(false);
				selectionFrame.setVisible(true);
				registerFrame.setVisible(false);
				addAccountFrame.setVisible(false);
				depositFrame.setVisible(false);
				withdrawFrame.setVisible(false);
				transferFrame.setVisible(false);
				closeFrame.setVisible(false);
				infoFrame.setVisible(false);
				adminFrame.setVisible(false);

	//OPEN ACCOUNT BUTTON IS CLICKED
				if (selectionFrame.getAddAccount()){
					selectionFrame.setAddAccountFalse();
					action = ACTION_OPEN;
				}
	
	//DEPOSIT BUTTON IS CLICKED
				if (selectionFrame.getDeposit()){
					selectionFrame.setDepositFalse();
					action = ACTION_DEPOSIT;	
				}	

	//WITHDRAW BUTTON IS CLICKED
				if (selectionFrame.getWithdraw()){
					selectionFrame.setWithdrawFalse();
					action = ACTION_WITHDRAW;					
				}	
				
	//TRANSFER BUTTON IS CLICKED
				if (selectionFrame.getTransfer()){
					selectionFrame.setTransferFalse();
					action = ACTION_TRANSFER;					
				}
				
	//CLOSE BUTTON IS CLICKED
				if (selectionFrame.getClose()){
					selectionFrame.setCloseFalse();
					action = ACTION_CLOSE;					
				}	
	//INFO BUTTON IS CLICKED
				if (selectionFrame.getInfo()){
					selectionFrame.setInfoFalse();
					action = ACTION_ACCOUNT_INFO;					
				}	
	//EXIT BUTTON IS CLICKED
				if (selectionFrame.getExit()){
					selectionFrame.setExitFalse();
					loginFrame.setClear();
					action = ACTION_IDLE;
				}
				break;

			}
			

			
	
			case ACTION_CREATE: {
				
//Display the REGISTER frame					
				loginFrame.setVisible(false);
				selectionFrame.setVisible(false);
				registerFrame.setVisible(true);
				addAccountFrame.setVisible(false);
				depositFrame.setVisible(false);
				withdrawFrame.setVisible(false);
				transferFrame.setVisible(false);
				closeFrame.setVisible(false);
				infoFrame.setVisible(false);
				adminFrame.setVisible(false);

	//ACCEPT BUTTON IS CLICKED
				if (RegisterPanel.getAccept()) {
					if (isNumeric(registerFrame.getPIN()) && registerFrame.getPIN().length() == 4) {
						
						atm.create_customer(registerFrame.getName(), registerFrame.getPIN());
						
						LoginPanel.setRegisterFalse();
						registerFrame.setAcceptFalse();
						loginFrame.setClear();
						loginFrame.setAccountNumber(atm.getCustomerArray(Customer.total_customers).getId());
						registerFrame.setClear();
						Customer.total_customers += 1;
						action = ACTION_IDLE;

					}else{
						registerFrame.setIncorrectPIN();
					}
				}
	//BACK BUTTON IS CLICKED				
				if (registerFrame.getBack()){
					System.out.println("back");
					action = ACTION_IDLE;
					loginFrame.setClear();
					registerFrame.setClear();
					LoginPanel.setRegisterFalse();
					registerFrame.setBackFalse();
					
				}
				
				break;
			}
			
			
			
			case ACTION_OPEN: {

//Display the ADDACCOUNT frame
				loginFrame.setVisible(false);
				selectionFrame.setVisible(false);
				registerFrame.setVisible(false);
				addAccountFrame.setVisible(true);
				depositFrame.setVisible(false);
				withdrawFrame.setVisible(false);
				transferFrame.setVisible(false);
				closeFrame.setVisible(false);
				infoFrame.setVisible(false);
				adminFrame.setVisible(false);
				
	//SAVINGS BUTTON IS CLICKED
				if(addAccountFrame.getSavings()){
					
					System.out.println("Adding Savings Account!");
					account_number = atm.open_account(selectionFrame.getID(), "s");
					System.out.println(account_number);
					addAccountFrame.setSavingsFalse();
					selectionFrame.setSavingsAccountAdded(account_number);
					action = ACTION_SELECT;
				}
	//CHECKING BUTTON IS CLICKED
				if(addAccountFrame.getChecking()){
					
					System.out.println("Adding Checking Account!");
					account_number = atm.open_account(selectionFrame.getID(), "c");
					addAccountFrame.setCheckingFalse();
					selectionFrame.setCheckingAccountAdded(account_number);
					action = ACTION_SELECT;
				}
				break;
			}
			
			case ACTION_DEPOSIT:  {
			
//Display the DEPOSIT frame
				loginFrame.setVisible(false);
				selectionFrame.setVisible(false);
				registerFrame.setVisible(false);
				addAccountFrame.setVisible(false);
				depositFrame.setVisible(true); 
				withdrawFrame.setVisible(false);
				transferFrame.setVisible(false);
				closeFrame.setVisible(false);
				infoFrame.setVisible(false);
				adminFrame.setVisible(false);
				
				String deposit_account_number = depositFrame.getSelectedAccount();
				String deposit_account_amount = depositFrame.getDepositAmount();
				String deposit_cust_ID = selectionFrame.getID();
				
				if (empty_deposit) {
					for (int i = 0; i < Customer.total_customers; i++){
						if (cust_ID.equals(atm.getCustomerArray(i).getId())){
							for (int j = 0; j < atm.getCustomerArray(i).getAccountNum(); j++){
								//System.out.println(atm.getCustomerArray(i).getAccountArray(j).getNumber());
								if (atm.getCustomerArray(i).getAccountArray(j).getActive()){
									depositFrame.addToAccountBox(atm.getCustomerArray(i).getAccountArray(j).getNumber());		
								}
							}							
						}
					}
					empty_deposit = false; 
				}
				
	//DEPOSIT BUTTON IS CLICKED
				double amt = 0;
				
				if(depositFrame.getDeposit()){
					
					if (deposit_account_amount.equals("")){
						amt = 0;
					}else if (isNumeric(deposit_account_amount)){
						amt = Double.parseDouble(deposit_account_amount);
					}
					
					if (deposit_account_number.equals("-select account-")){
						selectionFrame.setDepositReportNoSelect();
						depositFrame.setDepositFalse();
						depositFrame.setDepositClear();
						action = ACTION_SELECT;	
					}else if (!isNumeric(deposit_account_amount)){
						selectionFrame.setDepositReportNotANumber();
						
						
						depositFrame.setDepositFalse();
						depositFrame.setDepositClear();
						action = ACTION_SELECT;	
					}else{
						System.out.println("Depositing!");
						
						atm.deposit(deposit_cust_ID,  deposit_account_number, deposit_account_amount);
						
						//Add a deposit timestamp to the logfile ARRAY
						
						String LogNumber = Integer.toString(atm.getLogNumber());
						
						atm.addTimeStampDeposit(LogNumber, deposit_cust_ID, deposit_account_number, deposit_account_amount);
						atm.addLog();
						atm.printTimeStampArray();
						atm.writeToLog();
						
						double deposit_account_balance = atm.getBalance(deposit_cust_ID, deposit_account_number);
						selectionFrame.setDepositReport(deposit_account_number, deposit_account_balance);
						depositFrame.setDepositFalse();
						depositFrame.setDepositClear();
						action = ACTION_SELECT;
					}
				}
				break;
				
			}
			
			case ACTION_WITHDRAW:  {
				
//Display the WITHDRAW frame
				loginFrame.setVisible(false);
				selectionFrame.setVisible(false);
				registerFrame.setVisible(false);
				addAccountFrame.setVisible(false);
				depositFrame.setVisible(false); 
				withdrawFrame.setVisible(true);
				transferFrame.setVisible(false);
				closeFrame.setVisible(false);
				infoFrame.setVisible(false);
				adminFrame.setVisible(false);
				
				String withdraw_account_number = withdrawFrame.getSelectedAccount();
				String withdraw_account_amount = withdrawFrame.getWithdrawAmount();
				String withdraw_cust_ID = selectionFrame.getID();
				
				if (empty_withdraw){
					for (int i = 0; i < Customer.total_customers; i++){
						System.out.println(i);
						System.out.println(cust_ID);
						System.out.println(atm.getCustomerArray(i).getId());
						if (cust_ID.equals(atm.getCustomerArray(i).getId())){
							for (int j = 0; j < atm.getCustomerArray(i).getAccountNum(); j++){
								//System.out.println(atm.getCustomerArray(i).getAccountArray(j).getNumber());
								if (atm.getCustomerArray(i).getAccountArray(j).getActive()){
									withdrawFrame.addToAccountBox(atm.getCustomerArray(i).getAccountArray(j).getNumber());
								}
							}
						}
					}
					empty_withdraw = false; 
				}
				
	//WITHDRAW BUTTON IS CLICKED
				double withdraw_account_balance = atm.getBalance(withdraw_cust_ID, withdraw_account_number);
				double amt = 0;

				if(withdrawFrame.getWithdraw()){
					
					if (withdraw_account_amount.equals("")){
						amt = 0;
					}else if (isNumeric(withdraw_account_amount)){
						amt = Double.parseDouble(withdraw_account_amount);
					}
					
					if (withdraw_account_number.equals("-select account-")){
						selectionFrame.setWithdrawReportNoSelect();
						withdrawFrame.setWithdrawFalse();
						withdrawFrame.setWithdrawClear();
						action = ACTION_SELECT;	
					}else if (amt <= withdraw_account_balance && isNumeric(withdraw_account_amount)){ 
						
						atm.withdraw(withdraw_cust_ID,  withdraw_account_number, withdraw_account_amount);
						withdraw_account_balance = atm.getBalance(withdraw_cust_ID, withdraw_account_number);
						selectionFrame.setWithdrawReport(withdraw_account_number, withdraw_account_balance);
						withdrawFrame.setWithdrawFalse();
						withdrawFrame.setWithdrawClear();
						
						//Add WITHDRAW to logfile	
						
						String LogNumber = Integer.toString(atm.getLogNumber());
						atm.addTimeStampWithdraw(LogNumber, withdraw_cust_ID, withdraw_account_number, withdraw_account_amount);
						atm.printTimeStampArray();
						atm.addLog();
						atm.writeToLog();
						
						action = ACTION_SELECT;	
					}else if(amt > withdraw_account_balance){
						selectionFrame.setWithdrawReportInsufficientFunds();
						withdrawFrame.setWithdrawFalse();
						withdrawFrame.setWithdrawClear();
						action = ACTION_SELECT;	
					}else{
						selectionFrame.setWithdrawReportNotANumber();
						withdrawFrame.setWithdrawFalse();
						withdrawFrame.setWithdrawClear();
						action = ACTION_SELECT;	
					}
	
				}
				break;
			}
			
			case ACTION_TRANSFER:  {
				
//Display the TRANSFER frame
				loginFrame.setVisible(false);
				selectionFrame.setVisible(false);
				registerFrame.setVisible(false);
				addAccountFrame.setVisible(false);
				depositFrame.setVisible(false); 
				withdrawFrame.setVisible(false);
				transferFrame.setVisible(true);
				closeFrame.setVisible(false);
				infoFrame.setVisible(false);
				adminFrame.setVisible(false);
				
				String transfer_deposit_account_number = transferFrame.getDepositAccount();

				
				String transfer_withdraw_account_number = transferFrame.getWithdrawAccount();
				String transfer_withdraw_account_amount = transferFrame.getWithdrawAmount();
				String transfer_cust_ID = selectionFrame.getID();
				
				if (empty_transfer){
					for (int i = 0; i < Customer.total_customers; i++){
						if (cust_ID.equals(atm.getCustomerArray(i).getId())){
							for (int j = 0; j < atm.getCustomerArray(i).getAccountNum(); j++){
								if (atm.getCustomerArray(i).getAccountArray(j).getActive()){
									transferFrame.addToAccountWithdrawBox(atm.getCustomerArray(i).getAccountArray(j).getNumber());
								}
							}
						}
					}
					
					for (int m = 0; m < Customer.total_customers; m++){
						System.out.println(m);
						System.out.println(cust_ID);
						System.out.println(atm.getCustomerArray(m).getId());
						//if (cust_ID.equals(atm.getCustomerArray(i).getId())){
							for (int j = 0; j < atm.getCustomerArray(m).getAccountNum(); j++){								
								if (atm.getCustomerArray(m).getAccountArray(j).getActive()){
									transferFrame.addToAccountDepositBox(atm.getCustomerArray(m).getAccountArray(j).getNumber());
								}
							}
						}
					
					empty_transfer = false; 
				}
				
	//TRANSFER BUTTON IS CLICKED
				double transfer_withdraw_account_balance = atm.getBalance(transfer_cust_ID, transfer_withdraw_account_number);
				double transfer_deposit_account_balance = atm.getBalance(transfer_cust_ID, transfer_deposit_account_number);
				double amt_withdraw = 0;
				double amt_deposit = 0;
				
				if(transferFrame.getTransfer()){
					
					if (transfer_withdraw_account_amount.equals("")){
						amt_withdraw = 0;
					}else if (isNumeric(transfer_withdraw_account_amount)){
						amt_withdraw = Double.parseDouble(transfer_withdraw_account_amount);
					}
					
					if (transfer_deposit_account_number.equals("-select account-") || transfer_withdraw_account_number.equals("-select account-")){
						selectionFrame.setTransferReportNoSelect();
						transferFrame.setTransferFalse();
						transferFrame.setTransferClear();
						action = ACTION_SELECT;	
					}else if (amt_withdraw <= transfer_withdraw_account_balance && isNumeric(transfer_withdraw_account_amount)){ 
						
						atm.withdraw(transfer_cust_ID,  transfer_withdraw_account_number, transfer_withdraw_account_amount);
						atm.deposit(transfer_cust_ID, transfer_deposit_account_number, transfer_withdraw_account_amount);
						transfer_withdraw_account_balance = atm.getBalance(transfer_cust_ID, transfer_withdraw_account_number);
						transfer_deposit_account_balance = atm.getBalance(transfer_cust_ID, transfer_deposit_account_number);
						selectionFrame.setTransferReport(transfer_withdraw_account_number, transfer_withdraw_account_balance, transfer_deposit_account_number, transfer_deposit_account_balance);
						

						String LogNumber = Integer.toString(atm.getLogNumber());
						System.out.println(atm.getLogNumber());
						atm.addTimeStampWithdraw(LogNumber, transfer_cust_ID, transfer_withdraw_account_number, transfer_withdraw_account_amount);
						atm.addLog();
						System.out.println(atm.getLogNumber());
						atm.addTimeStampDeposit(LogNumber, transfer_cust_ID, transfer_deposit_account_number, transfer_withdraw_account_amount);
						atm.addLog();
						System.out.println(atm.getLogNumber());
						atm.writeToLog();
						
						transferFrame.setTransferFalse();
						transferFrame.setTransferClear();
						action = ACTION_SELECT;	
					}else if(amt_withdraw > transfer_withdraw_account_balance){
						selectionFrame.setTransferReportInsufficientFunds();
						transferFrame.setTransferFalse();
						transferFrame.setTransferClear();
						action = ACTION_SELECT;	

					}else{
						selectionFrame.setTransferReportNotANumber();
						transferFrame.setTransferFalse();
						transferFrame.setTransferClear();
						action = ACTION_SELECT;	
					}
				
				}
				
				break;
			}
			
			case ACTION_CLOSE:  {

//Display the CLOSE frame
				loginFrame.setVisible(false);
				selectionFrame.setVisible(false);
				registerFrame.setVisible(false);
				addAccountFrame.setVisible(false);
				depositFrame.setVisible(false); 
				withdrawFrame.setVisible(false);
				transferFrame.setVisible(false);
				closeFrame.setVisible(true);
				infoFrame.setVisible(false);
				adminFrame.setVisible(false);
				
				String close_account_number = closeFrame.getCloseAccount();
				String close_cust_ID = selectionFrame.getID();
				
				if (empty_close){
					for (int i = 0; i < Customer.total_customers; i++){
						if (cust_ID.equals(atm.getCustomerArray(i).getId())){
							for (int j = 0; j < atm.getCustomerArray(i).getAccountNum(); j++){
								if (atm.getCustomerArray(i).getAccountArray(j).getActive()){
									closeFrame.addToAccountBox(atm.getCustomerArray(i).getAccountArray(j).getNumber());
								}
								
							}
						}
					}
					empty_close = false; 
				}
				
				if(closeFrame.getClose()){
					
					if (close_account_number.equals("-select account-")){
						selectionFrame.setCloseReportNoSelect();
						closeFrame.setCloseFalse();
						closeFrame.setCloseClear();
						action = ACTION_SELECT;	
					}else{
						
						
						atm.close_account(close_cust_ID, close_account_number);
						selectionFrame.setCloseReport(close_account_number);
						closeFrame.setCloseFalse();
						closeFrame.setCloseClear();
						action = ACTION_SELECT;	
						
					}
					
					
					
				}
				break;
			}
			
			case ACTION_ACCOUNT_INFO: {
//Display the INFO frame
				loginFrame.setVisible(false);
				selectionFrame.setVisible(false);
				registerFrame.setVisible(false);
				addAccountFrame.setVisible(false);
				depositFrame.setVisible(false); 
				withdrawFrame.setVisible(false);
				transferFrame.setVisible(false);
				closeFrame.setVisible(false);
				infoFrame.setVisible(true);
				adminFrame.setVisible(false);
				
				String display_cust_ID = selectionFrame.getID();
				
				if (empty_info){
					for (int i = 0; i < Customer.total_customers; i++){
						//System.out.println(atm.getCustomerArray(i).getId());
						if (cust_ID.equals(atm.getCustomerArray(i).getId())){
							infoFrame.addToDisplay("Customer Name: " + atm.getCustomerArray(i).getName() + "\n");
							infoFrame.addToDisplay("Customer ID: " + atm.getCustomerArray(i).getId() + "\n\n");
						//	System.out.println("Customer Name: " + atm.getCustomerArray(i).getName());
						//	System.out.println("Customer ID: " + atm.getCustomerArray(i).getId());
							for (int j = 0; j < atm.getCustomerArray(i).getAccountNum(); j++){
									if (atm.getCustomerArray(i).getAccountArray(j).getType()){
										infoFrame.addToDisplay("Account Type: Savings\n");
									} else{
										infoFrame.addToDisplay("Account Type: Checking\n");
									}
									
									if (atm.getCustomerArray(i).getAccountArray(j).getActive()){
										infoFrame.addToDisplay("Account Number: " + atm.getCustomerArray(i).getAccountArray(j).getNumber() + "\n");
										NumberFormat formatter = NumberFormat.getCurrencyInstance();
										String dollar_account_balance = formatter.format(atm.getCustomerArray(i).getAccountArray(j).getBalance());
										infoFrame.addToDisplay("Balance: " + dollar_account_balance + "\n");
										infoFrame.addToDisplay("Active? : true\n");
									//withdrawFrame.addToAccountBox(atm.getCustomerArray(i).getAccountArray(j).getNumber());
									}
									
									if (atm.getCustomerArray(i).getAccountArray(j).getType()){
										infoFrame.addToDisplay("Interest Rate: 5%\n\n");
									} else{
										infoFrame.addToDisplay("Interest Rate: 0%\n\n");
									}
							}
						}
					}
					infoFrame.addToDisplay("*Log File Contents**\n");
					for (int i = 0; i < atm.getLogNumber(); i++){
					//for (int i = 0; i < 3; i++){
						if (display_cust_ID.equals(atm.getLogID(i))){
							infoFrame.addToDisplay(atm.getTimeStampArray(i) + "\n");
						}
					}
					empty_info = false; 
				}
	//BACK BUTTON IS CLICKED
				if(infoFrame.getBack()){
					infoFrame.setBackFalse();
					infoFrame.clearDisplay();
					action = ACTION_SELECT;	

				}
				break;
			}
			
			case ACTION_ADMIN: {
	//Display the INFO frame
				loginFrame.setVisible(false);
				selectionFrame.setVisible(false);
				registerFrame.setVisible(false);
				addAccountFrame.setVisible(false);
				depositFrame.setVisible(false); 
				withdrawFrame.setVisible(false);
				transferFrame.setVisible(false);
				closeFrame.setVisible(false);
				infoFrame.setVisible(false);
				adminFrame.setVisible(true);
				
				if (empty_admin){
					for (int i = 0; i < Customer.total_customers; i++){
							adminFrame.addToAccountBox(atm.getCustomerArray(i).getId());
					}
					empty_admin = false; 
				}
	//ALPHABETICAL BUTTON IS CLICKED
				if (adminFrame.getAlphabetical()){
					adminFrame.clearDisplay();
					double rounded;
					double balance = 0;	
					String ID = "";
					
					atm.adminNames();
					adminFrame.addToDisplay("[Customer Name]\t[Customer ID]    [Account ID]       [Pin #]        [Current Balance]\n");
					for (int i = 0; i < Customer.total_customers; i++){
						//System.out.println(i);
						for (int j = 0; j < atm.getCustomerArray(i).getAccountNum(); j++){
							balance = atm.getCustomerArray(i).getAccountArrayList().get(j).getBalance();
							rounded = atm.round(balance, 2);
							ID = atm.getCustomerArray(i).getAccountArrayList().get(j).getNumber();
							
							if(atm.getCustomerArray(i).getAccountArrayList().get(j).getActive()){
								//System.out.println(atm.getCustomerArray(i).getName() + "\t\t\t" + atm.getCustomerArray(i).getId() + "\t\t\t" + ID + "\t\t\t"+ atm.getCustomerArray(i).getPin() + "\t\t$" + rounded);
								adminFrame.addToDisplay(atm.getCustomerArray(i).getName() + "\t\t" + atm.getCustomerArray(i).getId() + "\t" + ID + "\t"+ atm.getCustomerArray(i).getPin() + "          $" + rounded + "\n");
							}
						}
					}
					adminFrame.setAlphabeticalFalse();
				}

	//HIGHEST BALANCE BUTTON IS CLICKED
				if (adminFrame.getHighestBalance()){
					adminFrame.clearDisplay();
					ArrayList<Admin>new_admin = new ArrayList<Admin>();
					new_admin = atm.adminBalance();
					
					//double rounded;
					//double balance = 0;	
					//String ID = "";
					adminFrame.addToDisplay("[Customer Name]\t[Customer ID]    [Account ID]       [Pin #]        [Current Balance]\n");
					for (int i = 0; i < Admin.number; i++){
						if(new_admin.get(i).getActive()){
							adminFrame.addToDisplay(new_admin.get(i).info() + "\n");
						}
					}
			
					adminFrame.setHighestBalanceFalse();
				}
				
	//CUSTOMER BUTTON IS CLICKED
				ArrayList<Admin>new_admin = new ArrayList<Admin>();
				if (adminFrame.getSingleCust()){
					adminFrame.clearDisplay();
					if(adminFrame.getSelectCustomer().equals("-select customer-")){
						adminFrame.addToDisplay("No Customer Selected!");
						adminFrame.setSingleCustFalse();
					}else{
						
						new_admin = atm.adminCustomer(adminFrame.getSelectCustomer());
						
						adminFrame.addToDisplay("[Customer Name]\t[Customer ID]    [Account ID]       [Pin #]        [Current Balance]\n");
						for (int i = 0; i < Admin.number; i++){
							if(new_admin.get(i).getActive()){
								adminFrame.addToDisplay(new_admin.get(i).info() + "\n");
							}
						}
						adminFrame.setSingleCustFalse();
					}
				}
	//TRANSACTION_LOG BUTTON IS CLICKED
				if (adminFrame.getTransactionLog()){
					adminFrame.clearDisplay();
					adminFrame.addToDisplay("*Log File Contents**\n");
					for (int i = 0; i < atm.getLogNumber(); i++){

							adminFrame.addToDisplay(atm.getTimeStampArray(i) + "\n");
					}
					adminFrame.setTransactionLogFalse();
				}
				
	//EXIT BUTTON IS CLICKED 
				if(adminFrame.getExit()){
					adminFrame.setExitFalse();
					adminFrame.clearDisplay();
					loginFrame.setClear();
					action = ACTION_IDLE;	

				}
			}
			
			break;
			}
		}

	}

}