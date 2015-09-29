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

public class RegisterOwner extends JPanel implements Serializable{
	private JTextField surname;
	private JTextField name;
	private JTextField nick;
	private JPasswordField pass1;
	private JPasswordField pass2;
	private JTextField textBank;
	private JTextField textPhone;
	private JLabel result = null;


	/**
	 * Create the panel.
	 */
	public RegisterOwner() {
		setLayout(null);

		JLabel lblUser = DefaultComponentFactory.getInstance().createTitle(
				"new owner");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUser.setBounds(76, 11, 92, 21);
		add(lblUser);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(26, 46, 78, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Surname:");
		lblNewLabel_1.setBounds(26, 71, 78, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nick");
		lblNewLabel_2.setBounds(26, 96, 78, 14);
		add(lblNewLabel_2);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(26, 121, 78, 14);
		add(lblPassword);

		JLabel lblRepearPasswrd = new JLabel("Repeat pass:");
		lblRepearPasswrd.setBounds(26, 146, 78, 14);
		add(lblRepearPasswrd);

		surname = new JTextField();
		surname.setBounds(114, 68, 92, 20);
		add(surname);
		surname.setColumns(10);

		name = new JTextField();
		name.setBounds(114, 43, 92, 20);
		add(name);
		name.setColumns(10);

		nick = new JTextField();
		nick.setBounds(114, 93, 92, 20);
		add(nick);
		nick.setColumns(10);

		pass1 = new JPasswordField();
		pass1.setBounds(114, 118, 92, 20);
		add(pass1);
		pass1.setColumns(10);

		pass2 = new JPasswordField();
		pass2.setBounds(114, 143, 92, 20);
		add(pass2);
		pass2.setColumns(10);

		result = new JLabel();
		result.setBounds(26, 227, 179, 21);
		add(result);

		textBank = new JTextField();
		textBank.setColumns(10);
		textBank.setBounds(114, 196, 92, 20);
		add(textBank);

		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(114, 171, 92, 20);
		add(textPhone);

		JLabel telefn = new JLabel("Phone number:");
		telefn.setBounds(26, 174, 78, 14);
		add(telefn);

		JLabel bankcoun = new JLabel("Banc count:");
		bankcoun.setBounds(26, 199, 78, 14);
		add(bankcoun);

		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String n = name.getText();
				String s = surname.getText();
				String user = nick.getText();
				String pas1 = pass1.getText();
				String pas2 = pass2.getText();
				Integer phone = Integer.valueOf(textPhone.getText());
				
				String bank = textBank.getText();
				if (!pas1.equals(pas2)) {
					JOptionPane.showMessageDialog(null, "Pasahitz ezberdinak",
							"alert", JOptionPane.CANCEL_OPTION);
				} else if (!n.equals("") && !s.equals("") && !user.equals("")
						&& !pas1.equals("") && !pas2.equals("")
						&& !phone.equals("") && !bank.equals("")) {
					try {
						ApplicationFacadeInterface facades = StartWindow
								.getBusinessLogic();
						Boolean nick = facades.verifyLoginName(user);
						if (nick) {
							// badago db-an
							result.setForeground(Color.RED);
							result.setText("Erabili duzun nickname-a ez dago eskuragarri");
						} else {
							// db-ez dago
							boolean era = facades.createOwner(phone, bank, n,
									s, user, pas1);
							if (era) {
								result.setForeground(Color.BLUE);
								result.setText("Jabea eratu da!");
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
		register.setBounds(64, 259, 92, 23);
		add(register);

	}
}
