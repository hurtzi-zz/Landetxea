package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JRadioButton;

import businessLogic.ApplicationFacadeInterface;
import domain.Admin;
import domain.Client;
import domain.Offer;
import domain.Owner;
import domain.RuralHouse;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class FoundOwnerPanel extends JPanel implements Serializable{

	/**
	 * Create the panel.
	 */
	
	private ApplicationFacadeInterface facade = StartWindow.getBusinessLogic();
	private JLabel lblNewLabel = new JLabel("");
	private JLabel lblDeleteOk = new JLabel("");

	public FoundOwnerPanel( final Vector<Owner> h, final int ind, final Admin ad) {

		setLayout(null);

		JLabel izena = new JLabel("");
		izena.setBounds(27, 189, 262, 14);
		add(izena);
		izena.setText(h.get(ind).getName());

		JLabel lblRural = new JLabel("Izena:");
		lblRural.setBounds(10, 11, 36, 14);
		add(lblRural);

		JLabel abizen = new JLabel("");
		abizen.setBounds(88, 41, 55, 14);
		add(abizen);
		abizen.setText(h.get(ind).getAbizena());

		JLabel label = new JLabel("Abizena:");
		label.setBounds(10, 36, 93, 14);
		add(label);

		JLabel searchPrice = new JLabel("");
		searchPrice.setBounds(88, 7, 68, 23);
		add(searchPrice);
		searchPrice.setBackground(Color.WHITE);
		searchPrice.setText(h.get(ind).getLogin());
		
		
		lblNewLabel.setBounds(311, 60, 46, 14);
		add(lblNewLabel);
		
		JLabel lblFD = new JLabel("Kontua");
		lblFD.setBounds(10, 111, 68, 14);
		add(lblFD);
		
		JLabel lblfir = new JLabel("");
		lblfir.setBounds(88, 111, 119, 14);
		add(lblfir);
		lblfir.setBackground(Color.WHITE);
		lblfir.setText(h.get(ind).getBankAccount());
        
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
		
		
		
		
		
        //searchDate.setText(sf.format(commentList.get(ind).getEguna()) +"  "+ formatoHora.format(commentList.get(ind).getEguna()) );
		
		/*JLabel lblHiria = new JLabel("First day:");
		lblHiria.setBounds(262, 11, 36, 14);
		add(lblHiria);
		JLabel searchHiria = new JLabel("");
		searchHiria.setBounds(308, 11, 100, 14);
		add(searchHiria);
		searchHiria.setText(Date.h.get(ind).getFirstDay());*/

		

		/*if (c.getIsOwner()) {
			if (h.elementAt(ind).getOwner().getLogin().equals(c.getLogin())) {
				JButton btnSartu = new JButton("Go");
				btnSartu.setBounds(431, 55, 76, 28);
				add(btnSartu);
				btnSartu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							ApplicationFacadeInterface facades = StartWindow
									.getBusinessLogic();
							Owner o = facades.clienToOwner(c);
							JFrame a = new GoOwner(h.get(ind), o);
							a.setVisible(true);

						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}

				});
			}

		} else {
			JButton btnSartu = new JButton("Go");
			btnSartu.setBounds(431, 55, 76, 28);
			add(btnSartu);
			btnSartu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JFrame a = new GoClient(h.get(ind), c);
					a.setVisible(true);
				}
			});
		}*/

		/*JLabel lblOfertaKop = new JLabel("Oferta kop:");
		lblOfertaKop.setBounds(418, 11, 68, 14);
		add(lblOfertaKop);

		JLabel searchOfert = new JLabel("");
		searchOfert.setBounds(496, 11, 36, 14);
		add(searchOfert);
		searchOfert.setText(Integer.toString(h.get(ind).getOffer().size()));*/

		// JLabel lblFavDa = new JLabel("");
		// lblFavDa.setBounds(431, 36, 76, 23);
		// add(lblFavDa);
		// lblFavDa.setText("Fav da");

	/*	JButton btnNewButton = new JButton("Favorite");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.addRuralFav(h.elementAt(ind));

				// ...................
				ApplicationFacadeInterface facades = StartWindow
						.getBusinessLogic();
				Boolean j = false;
				try {
					j = facades.updateClient(c);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (j) {
					System.out.println("ondo update client");
				} else {
					System.out.println("gaizki update client");
				}
				// .................

				btnNewButton.setEnabled(false);
			}
		});
		btnNewButton.setBounds(431, 30, 76, 23);
		add(btnNewButton);
		
		
		
		

		// edit
		if (h.elementAt(ind).getOwner().getLogin().equals(c.getLogin())) {
			JButton btnEdit = new JButton("Edit");
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						ApplicationFacadeInterface facades = StartWindow
								.getBusinessLogic();
						StartWindow.setEditRH((Owner) o, h.get(ind));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			btnEdit.setBounds(431, 85, 76, 23);
			add(btnEdit);
		}*/

		/*Vector<RuralHouse> vec = o.getRuralFav();
		Iterator it = vec.iterator();
		RuralHouse unekoa = h.elementAt(ind);
		Integer num = unekoa.getHouseNumber();
		String city = unekoa.getCity();
		while (it.hasNext()) {
			RuralHouse rh = (RuralHouse) it.next();
			if (unekoa.equals(rh)) {
				if (rh.getHouseNumber() == num) {
					if (rh.getCity().equals(city)) {
						btnNewButton.setEnabled(false);
					}
				}
			}
		}*/

	}
}