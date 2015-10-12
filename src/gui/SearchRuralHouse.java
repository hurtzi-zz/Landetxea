package gui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

import businessLogic.ApplicationFacadeInterface;
import domain.Client;
import domain.RuralHouse;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JLabel;

public class SearchRuralHouse extends JPanel implements Serializable{
	private JTextField textCity;

	/**
	 * Create the panel.
	 */
	public SearchRuralHouse() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Search Rural House:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 352, 65);
		add(panel);
		
		textCity = new JTextField();
		textCity.setText("City");
		textCity.setBounds(21, 21, 218, 27);
		panel.add(textCity);
		textCity.setColumns(10);
		
		final JLabel searchCity = new JLabel("");
		searchCity.setBounds(41, 78, 284, 30);
		add(searchCity);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String city =textCity.getText();
				Vector<RuralHouse> h= new Vector<RuralHouse>();
				try {
					ApplicationFacadeInterface facades = StartWindow.getBusinessLogic();
					h=facades.SarchByCity(city);
					if(h.size()==0){
						searchCity.setForeground(Color.RED);
						searchCity.setText("Ez daude etxeak "+city+"-n");
					}else{
						Iterator<RuralHouse> it = h.iterator();
						System.out.println(city+"-n etxeak:");
						while (it.hasNext()) {
							RuralHouse rh = (RuralHouse) it.next();
							System.out.println(rh.getHouseNumber()+" "+rh.getCity()+" "+rh.getDescription());
						}
						StartWindow.setFoundPanel(h,0);
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(249, 21, 91, 27);
		panel.add(btnSearch);
		
		

	}
}