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

public class FoundOfertak extends JPanel implements Serializable {

	/**
	 * 
	 * Create the panel.
	 */

	private ApplicationFacadeInterface facade = StartWindow.getBusinessLogic();
	private JLabel lblNewLabel = new JLabel("");


	public FoundOfertak(final Owner o, final Vector<Offer> h, final int ind) {

		setLayout(null);

		JLabel city = new JLabel("");

		city.setBounds(10, 61, 262, 14);

		add(city);

		city.setText(h.get(ind).getRuralHouse().getCity());

		JLabel lblRural = new JLabel("RuralHouse:");

		lblRural.setBounds(10, 36, 110, 14);

		add(lblRural);

		JLabel searchZbkia = new JLabel("");

		searchZbkia.setBounds(92, 11, 29, 14);

		add(searchZbkia);

		searchZbkia.setText(Integer.toString(h.get(ind).getRuralHouse()
				.getHouseNumber()));

		JLabel label = new JLabel("Landetxe zbkia:");

		label.setBounds(10, 11, 93, 14);

		add(label);

		JLabel lblPrice = new JLabel("Price:");

		lblPrice.setBounds(131, 11, 85, 14);

		add(lblPrice);

		JLabel searchPrice = new JLabel("");

		searchPrice.setBounds(167, 7, 68, 23);

		add(searchPrice);

		searchPrice.setBackground(Color.WHITE);

		searchPrice.setText(Float.toString(h.get(ind).getPrice()));


		lblNewLabel.setBounds(311, 60, 46, 14);

		add(lblNewLabel);

		JLabel lblFD = new JLabel("First Day");

		lblFD.setBounds(10, 86, 68, 14);

		add(lblFD);

		JLabel lblfir = new JLabel("");

		lblfir.setBounds(97, 86, 119, 14);

		add(lblfir);

		lblfir.setBackground(Color.WHITE);

		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-YYYY");

		DateFormat formatoHora = new SimpleDateFormat("HH:mm");

		lblfir.setText(sf.format(h.get(ind).getFirstDay()) + " "
				+ formatoHora.format(h.get(ind).getFirstDay()));

		JLabel lblLastDay = new JLabel("Last Day");

		lblLastDay.setBounds(10, 111, 46, 14);

		add(lblLastDay);

		JLabel lblNewLabel_1 = new JLabel("");

		lblNewLabel_1.setBounds(101, 111, 115, 14);

		add(lblNewLabel_1);

		// JLabel lblla = new JLabel("");

		// lblla.setBounds(92, 154, 46, 14);

		// add(lblla);

		lblNewLabel_1.setBackground(Color.WHITE);

		SimpleDateFormat sf2 = new SimpleDateFormat("dd-MM-YYYY");

		DateFormat formatoHora2 = new SimpleDateFormat("HH:mm");

		lblNewLabel_1.setText(sf2.format(h.get(ind).getLastDay()) + " "
				+ formatoHora2.format(h.get(ind).getLastDay()));

		JButton btnDelete = new JButton("Delete");

		btnDelete.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (lblNewLabel.getText().compareTo("Ziur?") == 0) {

					System.out.println("Ezabatzen...");

					try {

						RuralHouse rh = h.get(ind).getRuralHouse();

						System.out.println(rh.getCity() + rh.getDescription()
								+ rh.getOwner().getLogin()
								+ rh.getOffer().size());

						Date d1 = h.get(ind).getFirstDay();

						Date d2 = h.get(ind).getLastDay();

						Float f = h.get(ind).getPrice();

						Offer of = facade.offerBuelta(rh, d1, d2, f);

						System.out.println("Hau da logina");

						Boolean ondo = facade.deleteOferta(rh, of);

						if (ondo == true) {

							lblNewLabel.setText("Oferta ezabatu da.");

							lblNewLabel.setForeground(Color.GREEN);

							lblNewLabel.setVisible(true);

							StartWindow.setLogedPanel(o);

						}

					} catch (RemoteException e) {

						e.printStackTrace();

					} catch (Exception e) {

						// TODO Auto-generated catch block

						e.printStackTrace();

					}

				} else {

					lblNewLabel.setText("Ziur?");

					lblNewLabel.setForeground(Color.RED);

					lblNewLabel.setVisible(true);

				}

			}

		});

		btnDelete.setBounds(301, 23, 89, 23);

		add(btnDelete);

		// searchDate.setText(sf.format(commentList.get(ind).getEguna()) +"  "+
		// formatoHora.format(commentList.get(ind).getEguna()) );

		/*
		 * JLabel lblHiria = new JLabel("First day:");
		 * 
		 * lblHiria.setBounds(262, 11, 36, 14);
		 * 
		 * add(lblHiria);
		 * 
		 * JLabel searchHiria = new JLabel("");
		 * 
		 * searchHiria.setBounds(308, 11, 100, 14);
		 * 
		 * add(searchHiria);
		 * 
		 * searchHiria.setText(Date.h.get(ind).getFirstDay());
		 */

		/*
		 * if (c.getIsOwner()) {
		 * 
		 * if (h.elementAt(ind).getOwner().getLogin().equals(c.getLogin())) {
		 * 
		 * JButton btnSartu = new JButton("Go");
		 * 
		 * btnSartu.setBounds(431, 55, 76, 28);
		 * 
		 * add(btnSartu);
		 * 
		 * btnSartu.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent arg0) {
		 * 
		 * try {
		 * 
		 * ApplicationFacadeInterface facades = StartWindow
		 * 
		 * .getBusinessLogic();
		 * 
		 * Owner o = facades.clienToOwner(c);
		 * 
		 * JFrame a = new GoOwner(h.get(ind), o);
		 * 
		 * a.setVisible(true);
		 * 
		 * 
		 * 
		 * } catch (Exception e1) {
		 * 
		 * // TODO Auto-generated catch block
		 * 
		 * e1.printStackTrace();
		 * 
		 * }
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * });
		 * 
		 * }
		 * 
		 * 
		 * 
		 * } else {
		 * 
		 * JButton btnSartu = new JButton("Go");
		 * 
		 * btnSartu.setBounds(431, 55, 76, 28);
		 * 
		 * add(btnSartu);
		 * 
		 * btnSartu.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent arg0) {
		 * 
		 * JFrame a = new GoClient(h.get(ind), c);
		 * 
		 * a.setVisible(true);
		 * 
		 * }
		 * 
		 * });
		 * 
		 * }
		 */

		/*
		 * JLabel lblOfertaKop = new JLabel("Oferta kop:");
		 * 
		 * lblOfertaKop.setBounds(418, 11, 68, 14);
		 * 
		 * add(lblOfertaKop);
		 * 
		 * 
		 * 
		 * JLabel searchOfert = new JLabel("");
		 * 
		 * searchOfert.setBounds(496, 11, 36, 14);
		 * 
		 * add(searchOfert);
		 * 
		 * searchOfert.setText(Integer.toString(h.get(ind).getOffer().size()));
		 */

		// JLabel lblFavDa = new JLabel("");

		// lblFavDa.setBounds(431, 36, 76, 23);

		// add(lblFavDa);

		// lblFavDa.setText("Fav da");

		/*
		 * JButton btnNewButton = new JButton("Favorite");
		 * 
		 * btnNewButton.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent arg0) {
		 * 
		 * c.addRuralFav(h.elementAt(ind));
		 * 
		 * 
		 * 
		 * // ...................
		 * 
		 * ApplicationFacadeInterface facades = StartWindow
		 * 
		 * .getBusinessLogic();
		 * 
		 * Boolean j = false;
		 * 
		 * try {
		 * 
		 * j = facades.updateClient(c);
		 * 
		 * } catch (RemoteException e) {
		 * 
		 * // TODO Auto-generated catch block
		 * 
		 * e.printStackTrace();
		 * 
		 * }
		 * 
		 * if (j) {
		 * 
		 * System.out.println("ondo update client");
		 * 
		 * } else {
		 * 
		 * System.out.println("gaizki update client");
		 * 
		 * }
		 * 
		 * // .................
		 * 
		 * 
		 * 
		 * btnNewButton.setEnabled(false);
		 * 
		 * }
		 * 
		 * });
		 * 
		 * btnNewButton.setBounds(431, 30, 76, 23);
		 * 
		 * add(btnNewButton);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * // edit
		 * 
		 * if (h.elementAt(ind).getOwner().getLogin().equals(c.getLogin())) {
		 * 
		 * JButton btnEdit = new JButton("Edit");
		 * 
		 * btnEdit.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent arg0) {
		 * 
		 * try {
		 * 
		 * ApplicationFacadeInterface facades = StartWindow
		 * 
		 * .getBusinessLogic();
		 * 
		 * StartWindow.setEditRH((Owner) o, h.get(ind));
		 * 
		 * } catch (Exception e) {
		 * 
		 * // TODO Auto-generated catch block
		 * 
		 * e.printStackTrace();
		 * 
		 * }
		 * 
		 * }
		 * 
		 * });
		 * 
		 * btnEdit.setBounds(431, 85, 76, 23);
		 * 
		 * add(btnEdit);
		 * 
		 * }
		 */

		/*
		 * Vector<RuralHouse> vec = o.getRuralFav();
		 * 
		 * Iterator it = vec.iterator();
		 * 
		 * RuralHouse unekoa = h.elementAt(ind);
		 * 
		 * Integer num = unekoa.getHouseNumber();
		 * 
		 * String city = unekoa.getCity();
		 * 
		 * while (it.hasNext()) {
		 * 
		 * RuralHouse rh = (RuralHouse) it.next();
		 * 
		 * if (unekoa.equals(rh)) {
		 * 
		 * if (rh.getHouseNumber() == num) {
		 * 
		 * if (rh.getCity().equals(city)) {
		 * 
		 * btnNewButton.setEnabled(false);
		 * 
		 * }
		 * 
		 * }
		 * 
		 * }
		 * 
		 * }
		 */

	}

}