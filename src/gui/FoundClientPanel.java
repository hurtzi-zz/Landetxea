package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businessLogic.ApplicationFacadeInterface;
import domain.Admin;
import domain.Client;

public class FoundClientPanel extends JPanel implements Serializable{

	/**
	 * Create the panel.
	 */
	
	private ApplicationFacadeInterface facade = StartWindow.getBusinessLogic();
	private JLabel lblNewLabel = new JLabel("");
	private JLabel lblDeleteOk = new JLabel("");

	public FoundClientPanel( final Vector<Client> h, final int ind,final Admin ad) {

		setLayout(null);

		JLabel izena = new JLabel("");
		izena.setBounds(27, 189, 262, 14);
		add(izena);
		izena.setText(h.get(ind).getName());

		JLabel lblRural = new JLabel("Izena:");
		lblRural.setBounds(10, 11, 110, 14);
		add(lblRural);

		JLabel abizen = new JLabel("");
		abizen.setBounds(92, 11, 29, 14);
		add(abizen);
		abizen.setText(h.get(ind).getAbizena());

		JLabel label = new JLabel("Abizena:");
		label.setBounds(10, 36, 93, 14);
		add(label);

		JLabel lblPrice = new JLabel("Login:");
		lblPrice.setBounds(10, 86, 85, 14);
		add(lblPrice);

		JLabel searchPrice = new JLabel("");
		searchPrice.setBounds(123, 60, 68, 23);
		add(searchPrice);
		searchPrice.setBackground(Color.WHITE);
		searchPrice.setText(h.get(ind).getLogin());
		
		lblNewLabel.setBounds(311, 60, 46, 14);
		add(lblNewLabel);
		
		lblDeleteOk.setBounds(398, 11, 46, 14);
		add(lblDeleteOk);
		
		
        
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ApplicationFacadeInterface facades = StartWindow.getBusinessLogic();
				try {
					Boolean rhUpdate = facades.deleteClient(h.get(ind));
					if(rhUpdate){
						lblDeleteOk.setForeground(Color.GREEN);
						lblDeleteOk.setText("Delete OK");
						StartWindow.setAdminPanel(ad);
					}else{
						lblDeleteOk.setForeground(Color.RED);
						lblDeleteOk.setText("gaizki");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnDelete.setBounds(299, 7, 89, 23);
		add(btnDelete);
		
		
		
		
        

	}
}