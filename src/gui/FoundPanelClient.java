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
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JRadioButton;

import businessLogic.ApplicationFacadeInterface;
import domain.Client;
import domain.Owner;
import domain.RuralHouse;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class FoundPanelClient extends JPanel implements Serializable{
	private JLabel searchOwnerN = new JLabel("");
	private JLabel lblOwner = new JLabel("Owner:");
	private JLabel searchZbkia = new JLabel("");
	private JLabel label = new JLabel("Landetxe zbkia:");
	private JLabel lblDescription = new JLabel("Description:");
	private JLabel searchDescription = new JLabel("");
	private JLabel lblHiria = new JLabel("Hiria:");
	private JLabel searchHiria = new JLabel("");
	private JButton btnNewButton = new JButton("Favorite");

	/**
	 * Create the panel.
	 */
	public FoundPanelClient(final Client c, final Vector<RuralHouse> h, final int ind) {

		setLayout(null);

		
		searchOwnerN.setBounds(10, 81, 108, 14);
		add(searchOwnerN);
		searchOwnerN.setText(h.get(ind).getOwner().getName() + " "
				+ h.get(ind).getOwner().getAbizena());

		
		lblOwner.setBounds(10, 66, 46, 14);
		add(lblOwner);

		
		searchZbkia.setBounds(10, 27, 46, 14);
		add(searchZbkia);
		searchZbkia.setText(Integer.toString(h.get(ind).getHouseNumber()));

		
		label.setBounds(10, 11, 93, 14);
		add(label);

		
		lblDescription.setBounds(131, 11, 85, 14);
		add(lblDescription);

		
		searchDescription.setBounds(141, 27, 280, 81);
		add(searchDescription);
		searchDescription.setBackground(Color.WHITE);
		searchDescription.setText(h.get(ind).getDescription());
		
		
		lblHiria.setBounds(262, 11, 36, 14);
		add(lblHiria);
		
		searchHiria.setBounds(308, 11, 100, 14);
		add(searchHiria);
		searchHiria.setText(h.get(ind).getCity());

		

		if (c.getIsOwner()) {
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
		}

		JLabel lblOfertaKop = new JLabel("Oferta kop:");
		lblOfertaKop.setBounds(418, 11, 68, 14);
		add(lblOfertaKop);

		JLabel searchOfert = new JLabel("");
		searchOfert.setBounds(496, 11, 36, 14);
		add(searchOfert);
		searchOfert.setText(Integer.toString(h.get(ind).getOffer().size()));

		// JLabel lblFavDa = new JLabel("");
		// lblFavDa.setBounds(431, 36, 76, 23);
		// add(lblFavDa);
		// lblFavDa.setText("Fav da");

		 
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
						StartWindow.setEditRH((Owner) c, h.get(ind));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			btnEdit.setBounds(431, 85, 76, 23);
			add(btnEdit);
		}

		Vector<RuralHouse> vec = c.getRuralFav();
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
		}

	}
}