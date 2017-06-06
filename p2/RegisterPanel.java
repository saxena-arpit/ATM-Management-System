import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterPanel extends JPanel implements ActionListener{
	
	public static boolean accept = false;
	public static boolean back = false;
	
	private JLabel desired_name;
	private JLabel desired_pin;
	private JLabel incorrect_pin;
	
	private JTextField desired_name_Field;
	private JTextField desired_PIN_Field;

	
	private JButton acceptButton;
	private JButton backButton;
	
	public RegisterPanel(){
		
		GridBagConstraints constraints = new GridBagConstraints();
	    constraints.anchor = GridBagConstraints.WEST;
//	    constraints.insets = new Insets(10, 10, 10, 10);
		
//		setLayout(new FlowLayout());
	
		desired_name = new JLabel("Desired Name");
		desired_pin = new JLabel("Desired PIN    ");
		incorrect_pin = new JLabel("                                                                              ");
		
		desired_name_Field = new JTextField(15);
		desired_PIN_Field = new JTextField(15);
		
		acceptButton = new JButton("accept");
		backButton = new JButton("back");
		
		acceptButton.addActionListener(this);
		backButton.addActionListener(this);
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		add(desired_name_Field, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 3;
		add(desired_name, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 2;
		add(desired_PIN_Field, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		add(desired_pin, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		add(acceptButton, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		add(backButton, constraints);		
		constraints.gridx = 0;
		constraints.gridy = 0;
		add(incorrect_pin, constraints);	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		
		if (buttonPressed.equals(acceptButton)){
			
			if (getPIN().length() == 4){
				accept = true;
				removeIncorrectPIN();
			} else {
				addIncorrectPIN();
			}
			
		}
		
		if (buttonPressed.equals(backButton)){
			back = true;
		}
	}
	
	public static boolean getAccept(){
		
		return accept;
	}
	
	public static boolean getBack(){
		return back;
	}
	
	public String getName(){
		
		return desired_name_Field.getText();
		
	}
	
	public String getPIN(){
		
		return desired_PIN_Field.getText();
		
	}
	
	public void setAcceptFalse(){
		accept = false;
	}
	
	public void setBackFalse(){
		back = false;
	}
	
	public void addIncorrectPIN(){
		
		incorrect_pin.setText("That is not a valid PIN number!           					");
	}
	
	public void removeIncorrectPIN(){
		incorrect_pin.setText("                                ");
	}
	
	public void setClear(){
		desired_name_Field.setText("");
		desired_PIN_Field.setText("");
		remove(incorrect_pin);
		
	}
	

}
