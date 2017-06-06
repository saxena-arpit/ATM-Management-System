# ATM-Management-System
## A Java swing mini project.
#### To run this program you must have the files Account.java, ATM.java, ConsoleReader.java, Customer.java, p1.java, and Sav_Acct.java all in your working directory.
 
 ->Type: javac Account.java etc until you have all your .class files generated
 
 ->Type: java p2 to run the program!
 
 +This program consists of Choices that are user inputs in the form GUI clicks.
 
 +The Frames With Corresponding Options Are:
 
 #### 1) LoginFrame
 +	a)login
 +	b)register
 +	c)Exit
 
 #### 2)RegisterFrame
 +	a)accept
 +	b)back
 
 #### 3)SelectionFrame
 +	a)Open Account
 +	b)Deposit
 +	c)Withdraw
 +	d)Transfer
 +	e)Close Account
 +	f)Exit ATM
 
 #### 3)AddAccountFrame
 +	a)savings account
 +	b)checking account
 
 #### 4)DepositFrame
 +	a)Make Deposit
 
 #### 5)WithdrawFrame
 +	a)Make Withdraw
 
 #### 6)TransferFrame
 +	a)Make Transfer
 
 #### 7)InfoFrame
 +	a)return
 
 #### 8)CloseFrame
 +	a)close account
 
 #### 9)AdminFrame
 +	a)Accounts in Alphabetical Order
 +	b)Highest to Lowest Balance
 +	c)Transaction Report
 +	d)Customer Accounts
 +	e)Exit ADMIN

1.LoginFrame: is a simple frame that prompts a user for customer ID and PIN number(both must be created) 
	login: assuming both the ID and PIN entered exist you will jump to the SelectFrame
	register: jumps to Register frame where the user is prompted for a new customer account
	exit: This exits the program

2.RegisterFrame: a frame that prompts a user for a desired name and associated PIN number
	accept: this will create a customer and return a customer ID number assuming name and PIN are acceptable
	back: This just jumps to the LoginFrame (no action taken)

3.SelectionFrame: This is the main hub of the project. Here all choices are given to the user for account uses
	Open Account: This Choice will add an account object to an existing customer object and add it to a corresponding ArrayList
	Deposit: This Choice will add funds to a Customer objects specific account that is selected by the user
	Withdraw: This Choice will withdraw funds from a Customer objects specific account that is selected by the user
	Tranfser: This choice will take funds from A Customers account and place them in another one of their accounts
	Account Info: This choice will print out all account information for a chosen customer (also includes a transaction log)
	Close Account: This choice will close an account for a given Customer
	Exit ATM: returns to the LoginFrame

4.AddAccountFrame: This is where the user selects the type of account they want to add
	savings account: Adds an account object to their customer object with 5% interest
	checking account: Adds an account object to their customer object with 0% interest

5.DepositFrame: This is where the user adds money to their desired account
	Make Deposit: Assuming a number amount is in "desired amount" and an account is selected the desired amount will be added to their balance

6.WithdrawFrame:This is where the user removes money from their desired account
	Make Deposit: Assuming a number amount is in "desired amount" and an account is selected the desired amount will be subtracted from their balance

7.TransferFrame: This is where the user takes money from an account and adds it too another (can add too any existing acount)
	Make Transfer: Assuming a desired amount exists and to and from accounts are selected this will complete the transaction

8.InfoFrame: This will display all of the users accounts and shows a log of all their transactions
	return: simply goes back to the SelectionFrame

9.CloseFrame: This will set the selected account to inactive
	close account: closes the selected account


A secret choice exists that I will call Admin (it is accessed by entering abcd and 1234 for the Customer ID and PIN respectively on the loginFrame)

Admin has a pin requirement which is hard coded at "abcd" and will open a menu

1) Show accounts order by customer name
2) Show accounts order by highest balance
3) Show accounts belonging to the same customer
4) Show transaction log of all customers in descending order

Show accounts order by customer name:
This runs a sorting algorithm that prints out all the accounts information sorted by name

Show accounts order by highest balance:
This runs a sorting algorithm that prints out all the accounts information sorted by balance

Show accounts belonging to the same customer:
This runs a sorting algorithm that prints out the accounts information sorted by account number for a selected customer
Status API Training Shop Blog About

© 2016 GitHub, Inc. Terms Privacy Security Contact Help
