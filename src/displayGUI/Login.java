package displayGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * Class that once launch, prompt the user to enter a username and password.
 * If either of the parameters are incorrect, the user is prompted to do it 
 * again and again until both are correct. Once the entered values are correct,
 * the RCM/RMOS GUI is launched 
 * */
public class Login extends JFrame implements ActionListener {
	private JButton blogin;
	private JPanel loginpanel;
	private JTextField txuser, pass;
	private JLabel username, password;

	//Constructor
	public Login() {
		super("EcoRecycle Login");

		blogin = new JButton("Login");
		loginpanel = new JPanel();
		txuser = new JTextField(15);
		pass = new JPasswordField(15);
		username = new JLabel("User:");
		password = new JLabel("Pass:");

		this.setSize(300, 200);
		
		loginpanel.setLayout(null);

		txuser.setBounds(70, 30, 150, 20);
		pass.setBounds(70, 65, 150, 20);
		blogin.setBounds(110, 100, 80, 20);
		username.setBounds(20, 28, 80, 20);
		password.setBounds(20, 63, 80, 20);

		loginpanel.add(blogin);
		loginpanel.add(txuser);
		loginpanel.add(pass);
		loginpanel.add(username);
		loginpanel.add(password);

		this.getContentPane().add(loginpanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);

		blogin.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String user = txuser.getText();
		String word = pass.getText();

		String check1 = "admin";
		String check2 = "admin";

		if ((user.equals(check1)) && (word.equals(check2))) {
			new RMOS();
			dispose();
		} else if (user == "" && word == "") {
			JOptionPane.showMessageDialog(null, "Please insert Username and Password");
		} else {
			JOptionPane.showMessageDialog(null, "Wrong Username / Password");
			txuser.setText("");
			pass.setText("");
			txuser.requestFocus();
		}
	}

	//Main Method 
	public static void main(String args[]) {
		new RMOS();
	}
}
