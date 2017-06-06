import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logfile implements java.io.Serializable{
	
	private String timestamp;
	private String transaction_ID;
	private String customer_ID;
	private String account_number;
	private String amount;
	private String plus_neg;

	public Logfile(String new_transaction_ID, String new_customer_ID, String new_account_number, String new_amount, String new_plus_neg){
		
		timestamp = new SimpleDateFormat("[yyyy_MM/dd_HH:mm:ss]").format(Calendar.getInstance().getTime());
		transaction_ID = new_transaction_ID;
		customer_ID = new_customer_ID;
		account_number = new_account_number; 
		amount = new_amount;
		plus_neg = new_plus_neg;
		
	}
	
	public String printTimeStampArray(){
//		if (amount.equals("$0.00")){
//			return (timestamp + "  trans_ID: " + transaction_ID + "  cust_ID: " + customer_ID + "   acct_#: " + account_number + "  amt: $0.00" +  plus_neg);
//		}else{
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		double amount_dbl = Double.parseDouble(this.amount);
		String dollar_amount = formatter.format(amount_dbl);
		return (timestamp + "  trans_ID: " + transaction_ID + "  cust_ID: " + customer_ID + "   acct_#: " + account_number + "  amt: " + dollar_amount + plus_neg);
//		}
	}
	
	public String getID(){
		return customer_ID;
	}
	
}