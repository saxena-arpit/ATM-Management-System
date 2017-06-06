import java.util.Comparator;

public class CustomerNameComparator implements Comparator<Customer> {
	@Override
	public int compare(Customer c1, Customer c2){
		
		return c1.getName().compareToIgnoreCase(c2.getName());
		
	}
	
	

}