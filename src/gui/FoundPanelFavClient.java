package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Window;
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
import java.io.Serializable;

public class FoundPanelFavClient extends JPanel implements Serializable {
	private JLabel lblHiria;
	private JButton btnNewButton = new JButton("Favorite");
	private JButton btnNewButton_1 = new JButton("Delete Fav");

	/**
	 * Create the panel.
	 */
	public FoundPanelFavClient(final Client c, final Vector<RuralHouse> h, final int ind) {

		setLayout(null);

		JLabel searchOwnerN = new JLabel("");
		searchOwnerN.setBounds(10, 81, 108, 14);
		add(searchOwnerN);
		searchOwnerN.setText(h.get(ind).getOwner().getName() + " "
				+ h.get(ind).getOwner().getAbizena());

		JLabel lblOwner = new JLabel("Owner:");
		lblOwner.setBounds(10, 66, 46, 14);
		add(lblOwner);

		JLabel searchZbkia = new JLabel("");
		searchZbkia.setBounds(69, 11, 36, 14);
		add(searchZbkia);
		searchZbkia.setText(Integer.toString(h.get(ind).getHouseNumber()));

		JLabel lblLandZbkia = new JLabel("Land zbkia:");
		lblLandZbkia.setBounds(10, 11, 54, 14);
		add(lblLandZbkia);

		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(131, 11, 85, 14);
		add(lblDescription);

		JLabel searchDescription = new JLabel("");
		searchDescription.setBounds(141, 27, 280, 81);
		add(searchDescription);
		searchDescription.setBackground(Color.WHITE);
		searchDescription.setText(h.get(ind).getDescription());

		JLabel lblHiria = new JLabel("Hiria:");
		lblHiria.setBounds(262, 11, 36, 14);
		add(lblHiria);
		JLabel searchHiria = new JLabel("");
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
							ApplicationFacadeInterface facades = StartWindow.getBusinessLogic();
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
			btnSartu.setBounds(425, 64, 76, 28);
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
		btnNewButton.setBounds(418, 36, 90, 23);
		add(btnNewButton);

		Vector<RuralHouse> vec = c.getRuralFav();
		Iterator it = vec.iterator();
		RuralHouse unekoa = h.elementAt(ind);
		while (it.hasNext()) {
			RuralHouse rh = (RuralHouse) it.next();
			if (unekoa.equals(rh)) {
				btnNewButton.setEnabled(false);
			}

		}

		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// c.addRuralFav(h.elementAt(ind));
				c.getRuralFav().remove(ind);
				System.out.println(c.getRuralFav());

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
				btnNewButton_1.setEnabled(false);
				close();	
			}
		});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(418, 98, 90, 23);
		add(btnNewButton_1);

	}

	public void close() {
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
		frame.dispose();
	}

}