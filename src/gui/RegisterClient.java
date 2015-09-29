package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import businessLogic.ApplicationFacadeInterface;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.rmi.RemoteException;

public class RegisterClient extends JPanel implements Serializable{
	private JTextField surname;
	private JTextField name;
	private JTextField nick;
	private JPasswordField pass1;
	private JPasswordField pass2;
	private JLabel result = null;


	/**
	 * Create the panel.
	 */
	public RegisterClient() {
		setLayout(null);

		JLabel lblUser = DefaultComponentFactory.getInstance().createTitle(
				"new user ");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUser.setBounds(75, 11, 78, 21);
		add(lblUser);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(20, 46, 78, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Surname:");
		lblNewLabel_1.setBounds(20, 71, 78, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nick");
		lblNewLabel_2.setBounds(20, 96, 78, 14);
		add(lblNewLabel_2);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(20, 121, 78, 14);
		add(lblPassword);

		JLabel lblRepearPasswrd = new JLabel("Repeat pass:");
		lblRepearPasswrd.setBounds(20, 146, 78, 14);
		add(lblRepearPasswrd);

		surname = new JTextField();
		surname.setBounds(108, 68, 92, 20);
		add(surname);
		surname.setColumns(10);

		name = new JTextField();
		name.setBounds(108, 43, 92, 20);
		add(name);
		name.setColumns(10);
		name.setText("");

		nick = new JTextField();
		nick.setBounds(108, 93, 92, 20);
		add(nick);
		nick.setColumns(10);

		pass1 = new JPasswordField();
		pass1.setBounds(108, 118, 92, 20);
		add(pass1);
		pass1.setColumns(10);

		pass2 = new JPasswordField();
		pass2.setBounds(108, 143, 92, 20);
		add(pass2);
		pass2.setColumns(10);

		result = new JLabel();
		result.setBounds(20, 171, 179, 33);
		add(result);

		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String n = name.getText();
				String s = surname.getText();
				String user = nick.getText();
				String pas1 = pass1.getText();
				String pas2 = pass2.getText();
				if (!pas1.equals(pas2)) {
					JOptionPane.showMessageDialog(null, "Pasahitz ezberdinak",
							"alert", JOptionPane.CANCEL_OPTION);
				} else if (!n.equals("") && !s.equals("") && !user.equals("")
						&& !pas1.equals("") && !pas2.equals("")) {
					try {
						ApplicationFacadeInterface facades = StartWindow
								.getBusinessLogic();
						Boolean nick = facades.verifyLoginName(user);
						if (nick) {
							result.setForeground(Color.RED);
							result.setText("Nickname hori ez dago eskuragarri");
						} else {
							Boolean era = facades.createClient(n, s, user,
									pas1, true);
							if (era) {
								result.setForeground(Color.BLUE);
								result.setText("Erabiltzailea eratu da!");
							} else {
								result.setForeground(Color.RED);
								result.setText("Error, try again");
							}
						}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Bete itzazu atal guztiak mesedez", "alert",
							JOptionPane.CANCEL_OPTION);
				}
			}
		});
		register.setBounds(71, 215, 92, 23);
		add(register);

	}
}
